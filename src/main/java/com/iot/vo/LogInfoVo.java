package com.iot.vo;

import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: weiyunyun
 * @date: 2020/3/12 16:45
 */
@Data
public class LogInfoVo implements Serializable {
    /**
     * 日志信息
     */
    private String message;
    /**
     * 数据类型
     */
    private Integer type;
    /**
     * 设备编码
     */
    private String deviceCode;

}
