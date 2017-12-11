package com.sell.repository;

import com.sell.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

    //按CategoryType查找范围内的产品
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
