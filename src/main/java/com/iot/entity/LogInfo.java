package com.iot.entity;

import lombok.Builder;
import lombok.Data;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

/**
 * @author: weiyunyun
 * @date: 2020/3/12 15:07
 */
@Builder
@Data
@Measurement(name = "logInfo")
public class LogInfo {

    // Column中的name为measurement中的列名
    // 此外,需要注意InfluxDB中时间戳均是以UTC时保存,在保存以及提取过程中需要注意时区转换
    @Column(name = "time")
    private String time;
    // 注解中添加tag = true,表示当前字段内容为tag内容
    @Column(name = "module", tag = true)
    private String module;
    @Column(name = "level", tag = true)
    private String level;
    @Column(name = "msg")
    private String msg;
}
