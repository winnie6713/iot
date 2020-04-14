package com.iot.es.vo;

import com.iot.es.entity.ElasticEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author: weiyunyun
 * @date: 2020/4/13 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElasticDataVo<T> {

    @NotEmpty
    private String indexName;

    private ElasticEntity elasticEntity;
}
