package com.sell.service.impl;

import com.sell.domain.ProductInfo;
import com.sell.enums.ProductStatusEnum;
import com.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123");
        Assert.assertEquals("123", productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfos = productService.findUpAll();
        Assert.assertNotEquals(0, productInfos.size());
    }

    @Test
    public void findAll() throws Exception {
        //PageRequest已经被废弃，QPageRequest还可以进行排序
        Pageable request = new QPageRequest(0, 1);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        //对象总数
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(18));
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setCategoryType(3);
        productInfo.setProductStatus(ProductStatusEnum.Down.getCode());
        productInfo.setProductStock(105);
        productInfo.setProductIcon("...");
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}