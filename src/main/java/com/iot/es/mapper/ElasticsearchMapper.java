package com.iot.es.mapper;

import com.iot.es.entity.EsLogInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: weiyunyun
 * @date: 2020/4/14 16:33
 */
public interface ElasticsearchMapper extends ElasticsearchRepository<EsLogInfo,Long> {
}
