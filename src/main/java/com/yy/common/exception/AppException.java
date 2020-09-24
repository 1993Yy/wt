package com.yy.common.exception;

import com.yy.common.enums.ResultEnum;
import lombok.Getter;

/**
 * @Package: com.fantasi.nr.notice.common.exception
 * @ClassName: AppException
 * @Author: Created By Yy
 * @Date: 2020-05-15 14:47
 */
@Getter
public class AppException extends RuntimeException{

    private final Integer code;

    private final String msg;

    private ResultEnum resultEnum;

    public AppException(Integer code, String msg){
        super();
        this.code=code;
        this.msg=msg;
    }

    public AppException(ResultEnum resultEnum){
        this(resultEnum.getCode(),resultEnum.getMsg());
        this.resultEnum=resultEnum;
    }
}
