package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Data
@DynamicUpdate
public class ProductInfo {

  @Id
  private String productId;
  private String productName;
  private BigDecimal productPrice;
  private Integer productStock;
  private String productDescription;
  private String productIcon;
  private Integer productStatus;
  private Integer categoryType;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date createTime;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date updateTime;

  @JsonIgnore
  public ProductStatusEnum getProductStatusEnum() {
    return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
  }

}
