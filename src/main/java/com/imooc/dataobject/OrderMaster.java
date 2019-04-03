package com.imooc.dataobject;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Proxy(lazy = false)
@DynamicUpdate
public class OrderMaster {

  @Id
  private String orderId;
  private String buyerName;
  private String buyerPhone;
  private String buyerAddress;
  private String buyerOpenid;
  private BigDecimal orderAmount;
  private Integer orderStatus = OrderStatusEnum.NEW.getCode(); //订单状态，默认为新下单
  private Integer payStatus = PayStatusEnum.WAIT.getCode(); //支付状态，默认为待支付
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date createTime;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date updateTime;



}
