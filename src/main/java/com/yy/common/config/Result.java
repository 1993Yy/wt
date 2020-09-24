package com.yy.common.config;

import com.yy.common.enums.ResultEnum;
import lombok.Data;

/**
 * @package: com.yy.source.common.config
 * @className: Result
 * @author: Created By 94035
 * @date: 2020-06-05 22:39
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;


    public static <T> Result<T> success(T t){
        return new Result<>(t);
    }

    public static <T> Result<T> error(ResultEnum resultEnum){
        return new Result<>(resultEnum);
    }

    public static <T> Result<T> error(Integer code,String msg){
        return new Result<>(code,msg);
    }

    private Result(T t){
        this(ResultEnum.SUCCESS);
        this.data=t;
    }

    private Result(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private Result(ResultEnum resultEnum){
        this(resultEnum.getCode(),resultEnum.getMsg());
    }
}
