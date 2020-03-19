package com.iot.service.impl;

import com.iot.entity.LogInfo;
import com.iot.mapper.LogInfoMapper;
import com.iot.service.LogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weiyunyun
 * @since 2020-03-19
 */
@Service
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements LogInfoService {

}
