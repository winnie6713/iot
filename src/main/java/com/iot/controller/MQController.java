package com.iot.controller;

import com.iot.common.Result;
import com.iot.config.ApiCoreSender;
import com.iot.config.ApiPaymentSender;
import com.iot.vo.LogInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiyunyun
 * @date 2020/2/12 18:09
 */
@RestController
@Slf4j
public class MQController {

    @Autowired
    private ApiCoreSender coreSender;

    @Autowired
    private ApiPaymentSender apiPaymentSender;

    @PostMapping("/mq/message")
    public Result send(@RequestBody LogInfoVo logInfoVo){
        String message = logInfoVo.getMessage();
        log.info("message is {}",message);
        coreSender.sendStrMsg(logInfoVo);
        return Result.success(message);
    }

    @PostMapping("mq/byte/message")
    public Result sendByte(@RequestBody byte[] message) {
        coreSender.sendByteMsg(message);
        return Result.success();
    }


}
