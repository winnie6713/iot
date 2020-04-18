package com.iot.elasticsearch.controller;

import com.iot.common.Result;
import com.iot.common.ResultCode;
import com.iot.elasticsearch.entity.EsLogInfo;
import com.iot.elasticsearch.repository.EsLoginfoRepository;
import com.iot.elasticsearch.service.EsLoginfoService;
import com.iot.elasticsearch.vo.FullSearchVo;
import com.iot.util.ParamaterJudgeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: weiyunyun
 * @date: 2020/4/13 16:38
 */
@RestController
@RequestMapping("elastic")
@Slf4j
public class EsLoginfoController {
    @Autowired
    EsLoginfoRepository esLoginfoRepository;
    @Autowired
    private EsLoginfoService esLoginfoService;

    @PostMapping("add")
    public Result add(@RequestBody @Validated EsLogInfo esLogInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        esLoginfoRepository.save(esLogInfo);
        return Result.success();
    }

    @GetMapping("get/{id}")
    public Result getById(@PathVariable String id,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        Optional<EsLogInfo> esLogInfoOptional = esLoginfoRepository.findById(id);
        if (esLogInfoOptional.isPresent()){
            EsLogInfo esLogInfo = esLogInfoOptional.get();
            return Result.success(esLogInfo);
        }
        return Result.failure(ResultCode.INVALID_PARAMS);
    }

    @GetMapping("get/all")
    public Result getAll(){
        Iterable<EsLogInfo> iterable = esLoginfoRepository.findAll();
        List<EsLogInfo> esLogInfoList = new ArrayList<>();
        iterable.forEach(esLogInfoList::add);
        return Result.success(esLogInfoList);
    }

    @PostMapping("update")
    public Result updateById(@RequestBody @Validated EsLogInfo esLogInfo,BindingResult bindingResult ){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        esLoginfoRepository.save(esLogInfo);
        return Result.success();
    }

    @DeleteMapping("delete/{id}")
    public Result deleteById(@PathVariable String id,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        esLoginfoRepository.deleteById(id);
        return Result.success();
    }

    @PostMapping("rep/search/keyword")
    public Result repSearchKeyword(@RequestBody @Validated String keyword){
        if (ParamaterJudgeUtil.isEmpty(keyword)){
            return Result.failure(ResultCode.INVALID_PARAMS);
        }
        List<EsLogInfo> esLogInfoList = esLoginfoRepository.findByDetailInfoLike(keyword);
        return Result.success(esLogInfoList);
    }

    /**
     * 全文搜索
     * @param fullSearchVo
     * @param bindingResult
     * @return
     */
    @PostMapping("full/search")
    public Result fullSearch(@RequestBody @Validated FullSearchVo fullSearchVo,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }

        return esLoginfoService.fullSearch(fullSearchVo);
    }




}
