package com.imooc.dataobject;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@DynamicUpdate
@Data
public class SellerInfo {

  @Id
  private String sellerId;
  private String username;
  private String password;
  private String openid;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date createTime;
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date updateTime;

}
