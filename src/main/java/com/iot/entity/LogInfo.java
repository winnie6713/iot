package com.iot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author weiyunyun
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LogInfo extends Model<LogInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 日志警告级别
     */
    private String level;

    /**
     * 日志详细信息
     */
    private String msg;

    /**
     * 日志产生时间
     */
    private LocalDateTime logtime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
