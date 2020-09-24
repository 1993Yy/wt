package com.yy.common.config;


import com.yy.common.enums.ResultEnum;
import com.yy.common.exception.AppException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

/**
 * @package: com.yy.source.common.config
 * @className: ExceptionDeal
 * @author: Created By 94035
 * @date: 2020-06-05 22:38
 */
@RestControllerAdvice
public class ExceptionDeal {

    @ExceptionHandler(value = AppException.class)
    public Result appException(AppException appException){
        if (!Objects.isNull(appException.getResultEnum())){
            return Result.error(appException.getResultEnum());
        }
        return Result.error(appException.getCode(),appException.getMsg());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        ObjectError error = allErrors.get(0);
        return Result.error(ResultEnum.PARAMS_ERR.getCode(),error.getDefaultMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result illegalArgumentException(IllegalArgumentException e){

        return Result.error(ResultEnum.PARAMS_ERR.getCode(),e.getMessage());
    }
}
