package com.iot.elasticsearch.service;

import com.iot.common.Result;
import com.iot.elasticsearch.vo.FullSearchVo;

public interface EsLoginfoService {
    public Result fullSearch(FullSearchVo fullSearchVo);


}
