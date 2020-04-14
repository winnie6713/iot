package com.iot.es.controller;

import com.iot.common.Result;
import com.iot.common.ResultCode;
import com.iot.es.service.BaseElasticService;
import com.iot.es.util.ElasticUtil;
import com.iot.es.vo.ElasticDataVo;
import com.iot.es.vo.QueryVO;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: weiyunyun
 * @date: 2020/4/13 16:38
 */
@RestController
@RequestMapping("elastic")
@Slf4j
public class EsController {

    @Autowired
    BaseElasticService elasticService;


    @PostMapping(value = "/query")
    public Result query(@RequestBody @Validated QueryVO queryVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }

        try {
            Class<?> clazz = ElasticUtil.getClazz(queryVo.getClassName());
            Map<String,Object> params = queryVo.getQuery().get("match");
            Set<String> keys = params.keySet();
            MatchQueryBuilder queryBuilders=null;
            for(String ke:keys){
                queryBuilders = QueryBuilders.matchQuery(ke, params.get(ke));
            }
            if(null!=queryBuilders){
                SearchSourceBuilder searchSourceBuilder = ElasticUtil.initSearchSourceBuilder(queryBuilders);
                List<?> data = elasticService.search(queryVo.getIndexName(),searchSourceBuilder,clazz);
                return Result.success(data);
            }
        } catch (Exception e) {
            log.error("查询数据异常，metadataVo={},异常信息={}", queryVo.toString(),e.getMessage());
            return Result.failure(ResultCode.SYSTEM_ERROR);
        }
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }

    /**
     * @Description 删除
     * @param elasticDataVo
     * @return xyz.wongs.weathertop.base.message.response.ResponseResult
     * @throws
     * @date 2019/11/21 9:56
     */
    @PostMapping(value = "/delete")
    public Result delete(@RequestBody@Validated ElasticDataVo elasticDataVo,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        try {
            elasticService.deleteOne(elasticDataVo.getIndexName(),elasticDataVo.getElasticEntity());
        } catch (Exception e) {
            log.error("删除数据失败");
        }
        return Result.success();

    }


}
