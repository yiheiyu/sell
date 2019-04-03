package com.imooc.exception;

import com.imooc.VO.ResultVO;
import com.imooc.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class SellerAuthorizeException extends RuntimeException {


    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), getMessage());
    }

}
