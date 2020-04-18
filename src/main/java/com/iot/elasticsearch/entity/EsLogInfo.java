package com.iot.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: weiyunyun
 * @date: 2020/4/14 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "es-message",type = "runtimelog")
public class EsLogInfo {
    @Id
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    /**
     * 日志级别
     */
    private String level;

    /**
     * 信息编码
     */
    private String infoCoding;

    /**
     * 详细日志信息
     */
    private String detailInfo;

}
