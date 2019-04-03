package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

public interface SellerService {

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    SellerInfo findSellerByOpenid(String openid);

    /**
     * 通过username查询用户信息
     * @param username
     * @return
     */
    SellerInfo findSellerByUsername(String username);
}
