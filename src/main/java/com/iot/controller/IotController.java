package com.iot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iot.common.Result;
import com.iot.common.ResultCode;
import com.iot.config.rabbitmq.ApiCoreSender;
import com.iot.config.rabbitmq.ApiPaymentSender;
import com.iot.entity.DeviceInfo;
import com.iot.service.DeviceInfoService;
import com.iot.util.ParamaterJudgeUtil;
import com.iot.vo.LogInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiyunyun
 * @date 2020/2/12 18:09
 */
@RestController
@Slf4j
@RequestMapping("iot")
public class IotController {

    @Autowired
    private ApiCoreSender coreSender;

    @Autowired
    private DeviceInfoService deviceInfoService;

    @PostMapping("/data/input")
    public Result send(@RequestBody LogInfoVo logInfoVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        String deviceCode = logInfoVo.getDeviceCode();
        DeviceInfo deviceInfo = deviceInfoService.getOne(new QueryWrapper<DeviceInfo>().eq("device_code",deviceCode));
        if (ParamaterJudgeUtil.isEmpty(deviceInfo)){
            return Result.failure(ResultCode.DEVICE_NOT_EXIST);
        }
        String message = logInfoVo.getMessage();
        log.info("message is {}",message);
        coreSender.sendStrMsg(logInfoVo);
        return Result.success();
    }



}
