package com.sell.service.impl;

import com.sell.domain.ProductCategory;
import com.sell.repository.ProductCategoryRepository;
import com.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Service实现要加注解
public class CategoryServiceImpl implements CategoryService {

    private ProductCategoryRepository repository;

    /*
        注入分为：
            1. 构造器注入
            2. setter注入
            3. field注入
        注入知道方针
            1、为了强制依赖，或者为了易变性，使用构造方法注入
            2、为了可选的或者可变的依赖，使用setter注入
            3、尽量避免使用直接在属性上注入
        属性注入的不足:
            1、你不能使用属性注入的方式构建不可变对象。
            2、你的类和依赖容器强耦合，不能再容器外使用。
            3、你的类不能绕过反射（例如单元测试的时候）进行实例化，必须通过依赖容器才能实例化，这更像是集成测试。
            4、实际的依赖被隐藏在外面，不是在构造方法或者其它方法里面反射的。
        通过get方式获得的不是必然执行，而通过构造器的是必然发生，避免空指针异常
     */
    @Autowired
    public CategoryServiceImpl(ProductCategoryRepository repository) {
        this.repository = repository;
    }
    @Override
    public ProductCategory findOne(Integer id) {
        Optional<ProductCategory> productCategory = repository.findById(id);
        if(productCategory.isPresent()){
            return productCategory.get();
        } else {
            //如果没有结果则返回一个id为0的对象
            ProductCategory nullProductCategory = new ProductCategory();
            nullProductCategory.setCategoryId(0);
            return nullProductCategory;
        }
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
