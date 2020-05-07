package com.iot.service.impl;

import com.iot.entity.DeviceInfo;
import com.iot.mapper.DeviceInfoMapper;
import com.iot.service.DeviceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weiyunyun
 * @since 2020-05-06
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoService {

}
