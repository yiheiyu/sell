package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {


    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){


        log.info("进入auth方法。。。");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx0743b1c018ce64b7&secret=e3f9fee6ac1cdb9e74b1bd17cfcf95bc&code=" + code + "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);
    }
}
