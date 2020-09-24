package com.yy.common.enums;

/**
 * @Package: com.fantasi.nr.notice.common.enums
 * @ClassName: ResultEnum
 * @Author: Created By Yy
 * @Date: 2020-05-15 14:47
 */
public enum ResultEnum {

    SUCCESS(2000,"成功"),
    FAIL(5000,"系统错误"),
    PARAMS_ERR(4000,"参数错误"),
    OTHER_ERR(6000,"其他错误");










    ResultEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    private final Integer code;
    private final String msg;

    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
