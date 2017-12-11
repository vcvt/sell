package com.sell.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * product_category
 */
@Entity
@DynamicUpdate //动态更新时间
@Data //使用lombok插件，保护生成get,set toString方法
public class ProductCategory {

    //类目Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增类型,要加strategy，不然报错
    private Integer categoryId;

    //类目名称
    private String categoryName;

    //类目编号
    private Integer categoryType;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
