package com.iot.common;

/**
 * @author weiyunyun
 * @date 2020/2/13 12:57
 */
public enum ResultCode {

    /**
     * 200	success
     */
    SUCCESS("200", "success"),

    INVALID_PARAMS("101", "参数不正确"),

    SQL_ERROR("SQL01", "数据库操作失败"),

    INVALID_GRANT("901", "用户名或密码错误"),

    NOT_PERMIT("902", "无权限操作"),

    NO_SUCH_USER("903", "无此用户"),

    INVALID_PASSWORD("904", "密码错误"),

    CUSTOMER_EXISTS("905", "customer_id已经存在"),

    USER_EXISTS("906", "user_name已经存在"),

    PASSWORD_MUST_NOT_NULL("907", "密码不能为空"),

    PASSWORD_NEW_OLD_EQUAL("908", "新密码和旧密码不能相同"),

    USER_ADMIN_EXIST("909", "用户管理员已经存在"),

    USER_STATUS_ERROR("910", "用户状态异常"),

    USER_EXPIRED("911", "用户已过期"),

    REMOTE_ERROR("998", "远程服务调用失败"),

    SYSTEM_ERROR("999", "系统繁忙，请稍后再试");

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public ResultCode setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
