package cn.xuanzhi33.carprojectserver.exception;

import cn.xuanzhi33.carprojectserver.pojo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.serverError(e.getMessage());
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public  ResponseEntity<Result<String>> handleNoResourceFoundException(NoResourceFoundException e) {
        return new ResponseEntity<>(Result.error(404, "Not Found"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getFieldError();
        Result<String> res = Result.clientError("Invalid Request");
        if (fieldError != null) {
            res = Result.clientError(fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
