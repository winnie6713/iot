package com.iot.controller;

import com.iot.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: weiyunyun
 * @date: 2020/4/8 10:18
 */
@RestController
@Slf4j
public class TestController {

    @PostMapping("test")
    public Result hello(){
        log.info("test hello");
        return Result.success("hello");
    }
}
