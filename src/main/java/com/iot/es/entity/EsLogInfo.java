package com.iot.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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
    private Long id;

    private String logtime;

    private String errorInfo;

}
