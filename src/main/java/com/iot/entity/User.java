package com.iot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author weiyunyun
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 用户名
     */
    @NotEmpty(message = "username can not be empty")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "password can not be empty")
    private String password;

    /**
     * 邮箱
     */
    @Email(message = "错误的邮箱格式")
    private String email;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
