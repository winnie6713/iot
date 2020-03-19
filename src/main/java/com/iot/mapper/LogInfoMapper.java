package com.iot.mapper;

import com.iot.entity.LogInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weiyunyun
 * @since 2020-03-19
 */
@Repository
public interface LogInfoMapper extends BaseMapper<LogInfo> {

}
