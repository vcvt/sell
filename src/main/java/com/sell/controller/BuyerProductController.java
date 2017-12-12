package com.sell.controller;

import com.sell.VO.ProductInfoVO;
import com.sell.VO.ProductVO;
import com.sell.VO.ResultVO;
import com.sell.domain.ProductCategory;
import com.sell.domain.ProductInfo;
import com.sell.service.CategoryService;
import com.sell.service.ProductService;
import com.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
    买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public BuyerProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        /*
            最后商品是要按类目排序，所有下查询所有上架的商品，找出对应的类目
         */
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 2.查询类目(一次性查询)
        //传统方法
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            //categoryTypeList是用来查找类目对象的，不应该有重复值
            if(!categoryTypeList.contains(productInfo.getCategoryType()))
                categoryTypeList.add(productInfo.getCategoryType());
        }
       /* //精简方法lambda
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());*/
       //查询某些类目的具体信息
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //将类目相同的商品放在一起
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //将对象productInfo的属性拷贝到productInfoVO，省去了一个个写set,get方法
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
