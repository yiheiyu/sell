package com.imooc.controller;

import com.imooc.constant.CookieConstant;
import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.form.SellerForm;
import com.imooc.service.SellerService;
import com.imooc.utils.CookieUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;


    /**
     * 用户登陆
     * @param form
     * @param bindingResult
     * @param response
     * @param map
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@Valid SellerForm form, BindingResult bindingResult, HttpServletResponse response, Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell");
            return new ModelAndView("common/error", map);
        }

        SellerInfo sellerInfo = new SellerInfo();
        try {
            sellerInfo = sellerService.findSellerByUsername(form.getUsername());
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell");
            return new ModelAndView("common/error", map);
        }
        if (!form.getPassword().equals(sellerInfo.getPassword())) {
            map.put("msg", ResultEnum.LOGIN_ERROR.getMessage());
            map.put("url","/sell");
            return new ModelAndView("common/error", map);
        }

        //设置token
        String token = UUID.randomUUID().toString();
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        map.put("msg", ResultEnum.LOGIN_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");

        return new ModelAndView("common/success", map);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie != null) {
            //清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell");

        return new ModelAndView("common/success", map);
    }


}
