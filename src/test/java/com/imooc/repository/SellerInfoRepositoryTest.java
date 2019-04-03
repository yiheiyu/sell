package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void findByOpenid() {

        SellerInfo result = repository.findByOpenid("abcd");
        Assert.assertEquals("abcd",result.getOpenid());

    }

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();

//        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setSellerId("1554272536241690567");
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abcd");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void login() {

        SellerInfo result = repository.findByUsername("admin");
        Assert.assertEquals("admin",result.getUsername());
    }

}