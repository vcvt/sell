package com.sell.service.impl;

import com.sell.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(10);
        //对比的两个需要是同一类型
        Assert.assertEquals(new Integer(10),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = categoryService.save(new ProductCategory("小孩最爱",6));
        //判断返回结果是否为空
        Assert.assertNotEquals(null, productCategory);
    }

}