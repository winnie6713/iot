package com.iot.mapper;

import com.iot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weiyunyun
 * @since 2020-04-07
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
