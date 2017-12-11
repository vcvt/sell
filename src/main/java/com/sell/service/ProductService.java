package com.sell.service;

import com.sell.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    //查找具体商品
    ProductInfo findOne(String productId);

    //查询所有在架商品列表
    List<ProductInfo> findUpAll();

    //分页查询
    Page<ProductInfo> findAll(Pageable pageable);

    //添加商品
    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
