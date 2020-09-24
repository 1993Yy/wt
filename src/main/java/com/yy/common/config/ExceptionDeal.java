package com.yy.common.config;


import com.yy.common.enums.ResultEnum;
import com.yy.common.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @package: com.yy.source.common.config
 * @className: ExceptionDeal
 * @author: Created By 94035
 * @date: 2020-06-05 22:38
 */
@RestControllerAdvice
@Slf4j
public class ExceptionDeal{
    
    
    @ExceptionHandler(value = AppException.class)
    public Result appException(AppException e){
        if (!Objects.isNull(e.getResultEnum())){
            return Result.error(e.getResultEnum());
        }
        return Result.error(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("===",e);
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        ObjectError error = allErrors.get(0);
        return Result.error(ResultEnum.PARAMS_ERR.getCode(),error.getDefaultMessage());
    }
    
    @ExceptionHandler(value = BindException.class)
    public Result bindException(BindException e){
        log.error("===",e);
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        ObjectError error = allErrors.get(0);
        return Result.error(ResultEnum.PARAMS_ERR.getCode(),error.getDefaultMessage());
    }
    
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Result constraintViolationException(ConstraintViolationException e){
        log.error("===",e);
        Set<ConstraintViolation<?>> set = e.getConstraintViolations();
        ConstraintViolation<?> next = set.iterator().next();
        return Result.error(ResultEnum.PARAMS_ERR.getCode(),next.getMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result illegalArgumentException(IllegalArgumentException e){
        log.error("===",e);
        return Result.error(ResultEnum.PARAMS_ERR.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        log.error("===",e);
        return Result.error(ResultEnum.ERR.getCode(),e.getMessage());
    }
}
