package com.imooc.dataobject;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Proxy(lazy = false)
@DynamicUpdate
public class OrderDetail {

  @Id
  private String detailId;
  private String orderId;
  private String productId;
  private String productName;
  private BigDecimal productPrice;
  private Integer productQuantity;
  private String productIcon;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date createTime;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date updateTime;



}
