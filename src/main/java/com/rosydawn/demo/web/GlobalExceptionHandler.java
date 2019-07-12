package com.rosydawn.demo.web;

import com.rosydawn.demo.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/12 14:22
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 缺少请求参数异常
     *
     * @param exception HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Result<String> handleHttpMessageNotReadableException(MissingServletRequestParameterException exception) {
        log.error("缺少请求参数，{}", exception.getMessage());
        return Result.of(400, "缺少必要的请求参数");
    }

    /**
     * 空指针异常
     * @param exception NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> handleTypeMismatchException(NullPointerException exception) {
        log.error("空指针异常，{}", exception.getMessage());
        return Result.of(500, "系统异常");
    }

    /**
     * 在项目中，我们一般都会比较详细地去拦截一些常见异常，拦截 Exception 虽然可以一劳永逸，但是不利于我们去排查或者定位问题。
     *
     * 实际项目中，可以把拦截Exception异常写在GlobalExceptionHandler最下面，如果都没有找到，最后再拦截一下Exception异常。
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> handleUnexpectedServer(Exception exception) {
        log.error("系统异常：", exception);
        return Result.of(500, "系统发生异常，请联系管理员");
    }

    /**
     * 拦截业务异常，返回业务异常信息
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleBusinessError(BusinessErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

}


