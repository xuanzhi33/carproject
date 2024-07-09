package cn.xuanzhi33.carprojectserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }
    public static Result<Void> success() {
        return Result.success(null);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> serverError(String message) {
        return Result.error(500, message);
    }

    public static <T> Result<T> clientError(String message) {
        return Result.error(400, message);
    }
}
