package cn.xuanzhi33.carprojectserver.exception;

import cn.xuanzhi33.carprojectserver.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        if (e instanceof NoResourceFoundException) {
            return Result.error(404, "Not Found");
        } else {
            return Result.serverError(e.getMessage());
        }
    }
}
