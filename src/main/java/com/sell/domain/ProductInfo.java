package com.sell.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/*
    商品
    字段要和数据库一一对应
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;

    //商品名称
    private String productName;

    //商品价格
    private BigDecimal productPrice;

    //商品描述
    private String productDescription;

    //库存
    private Integer productStock;
    //商品小图
    private String productIcon;

    //商品状态 0：正常；1：下架
    private Integer productStatus;

    //类目编号
    private Integer categoryType;
}
