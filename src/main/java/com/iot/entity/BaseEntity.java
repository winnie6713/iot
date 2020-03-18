package com.iot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.util.Date;

/**
 * @author: weiyunyun
 * @date: 2020/3/17 16:22
 */
public class BaseEntity {

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
