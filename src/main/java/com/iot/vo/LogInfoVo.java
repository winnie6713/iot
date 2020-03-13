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
    private String logtime;
    private String level;
    private String message;

}
