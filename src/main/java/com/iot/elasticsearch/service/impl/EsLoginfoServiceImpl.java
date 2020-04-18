package com.iot.elasticsearch.service.impl;

import com.iot.common.Result;
import com.iot.elasticsearch.entity.EsLogInfo;
import com.iot.elasticsearch.service.EsLoginfoService;
import com.iot.elasticsearch.vo.FullSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class EsLoginfoServiceImpl implements EsLoginfoService {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Override
    public Result fullSearch(FullSearchVo fullSearchVo) {
        int page = fullSearchVo.getPage();
        int size = fullSearchVo.getSize();
        String keyword = fullSearchVo.getKeyword();
        Pageable pageable = PageRequest.of(page,size);
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder().withPageable(pageable);
        searchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keyword));
        SearchQuery searchQuery = searchQueryBuilder.build();
        Page<EsLogInfo> esLogInfoPage = elasticsearchTemplate.queryForPage(searchQuery,EsLogInfo.class);
        return Result.success(esLogInfoPage);
    }
}
