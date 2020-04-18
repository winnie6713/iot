package com.iot.elasticsearch.repository;

import com.iot.elasticsearch.entity.EsLogInfo;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;
import java.util.List;

public interface EsLoginfoRepository extends ElasticsearchRepository<EsLogInfo, String> {

    List<EsLogInfo> findByLevel(String level);

    List<EsLogInfo> findByInfoCoding(String infoCoding);

    List<EsLogInfo> findByTimeBetween(Date start,Date end);

    @Query("{\"match_phrase\":{\"detailInfo\":\"?0\"}}")
    List<EsLogInfo> findByDetailInfoLike(String keyword);
}
