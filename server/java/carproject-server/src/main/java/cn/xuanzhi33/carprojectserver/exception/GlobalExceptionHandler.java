package cn.xuanzhi33.carprojectserver.exception;

import cn.xuanzhi33.carprojectserver.pojo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.serverError(e.getMessage());
    }
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<String> handleNoResourceFoundException(NoResourceFoundException e) {
        return Result.error(404, "Not Found");
    }
    @ExceptionHandler({MethodArgumentNotValidException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Result<String> res = Result.clientError(e.getMessage());
        FieldError fieldError = e.getFieldError();
        if (fieldError != null) {
            res = Result.clientError(fieldError.getDefaultMessage());
        }
        return res;
    }
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result<String> handleUnauthorizedException(UnauthorizedException e) {
        return Result.error(401, e.getMessage());
    }
}
