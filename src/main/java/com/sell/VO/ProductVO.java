package com.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*
    商品(包含类目)
 */
@Data
public class ProductVO {

    @JsonProperty("name")   //返回给前端以name的样子
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")  //前端需要多少数据就返回多少，不要返回多余的数据
    private List<ProductInfoVO> productInfoVOList;


}
