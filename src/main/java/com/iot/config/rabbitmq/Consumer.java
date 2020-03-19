package com.iot.config.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iot.config.influxdb.InfluxDBConnect;
import com.iot.entity.LogInfo;
import com.iot.mapper.LogInfoMapper;
import com.iot.service.LogInfoService;
import com.iot.vo.LogInfoVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyunyun
 * @date 2020/2/13 15:57
 */
@Component
@Data
@Slf4j
public class Consumer {


    @Autowired
    private InfluxDBConnect influxDBConnect;
    @Autowired
    private LogInfoMapper logInfoMapper;

    @RabbitHandler
    @RabbitListener(queues = "api.core")
    public void sendToSubject(LogInfoVo logInfoVo) throws ParseException {
        String body = JSON.toJSONString(logInfoVo);
        sendToMysql(body);
//        sendToInfluxdb(body);
    }


    private void sendToMysql(String body) throws ParseException {
        JSONObject jsonObject = JSON.parseObject(body);
        String message = jsonObject.getString("message");
        String logtime = jsonObject.getString("logtime");
        String level = jsonObject.getString("level");
        LocalDateTime timer = LocalDateTime.parse(logtime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LogInfo logInfoDo = new LogInfo();
        logInfoDo.setLevel(level);
        logInfoDo.setMsg(message);
        logInfoDo.setLogtime(timer);
        logInfoMapper.insert(logInfoDo);
        log.info("data is send to mysql");
    }

    private void sendToInfluxdb(String body){
        JSONObject jsonObject = JSON.parseObject(body);
        String message = jsonObject.getString("message");
        String logtime = jsonObject.getString("logtime");
        Map<String,Object> data = new HashMap<>();
        data.put("message",message);
        data.put("logtime",logtime);
        Map<String, String> tags = new HashMap<>();
        tags.put("level",jsonObject.getString("level"));
        influxDBConnect.insert("tb_iot",tags,data);
        log.info("data is send to influxdb");
    }

}
