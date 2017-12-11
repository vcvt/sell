package com.sell.repository;

import com.sell.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
        //System.out.println(productCategory.get().toString());
    }

    @Test
    @Transactional //测试数据不保存
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("小孩最爱");
        productCategory.setCategoryType(4);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null, result);
        //Assert.assertEquals(null, result);
    }

    @Test
    public void updateTest() {
        //更新是需要先查出来再设置
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(1);
        //Optional这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
        if(productCategoryOptional.isPresent()){
            ProductCategory productCategory = productCategoryOptional.get();
            productCategory.setCategoryType(6);
            productCategoryRepository.save(productCategory);
        }
    }

    @Test
    public void findByCategoryTpyeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        //判断结果是否满足要求
        Assert.assertNotEquals(0, result.size());
    }
}
