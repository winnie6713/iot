package com.iot.es.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * @author: weiyunyun
 * @date: 2020/4/13 17:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryVO {
    @NotEmpty
    private String indexName;

    private String className;

    private Map<String,Map<String,Object>> query;
}
