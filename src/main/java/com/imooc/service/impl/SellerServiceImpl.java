package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;


    @Override
    public SellerInfo findSellerByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerByUsername(String username) {
        SellerInfo result = repository.findByUsername(username);
        if (result == null) {
            throw new SellException(ResultEnum.LOGIN_ERROR);
        }
        return result;
    }
}
