package tanaduus.github.io;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@Data
public class BaseResult<T> implements Serializable {
    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public BaseResult() {
    }

    public static <T> BaseResult<T> newSuccess(T data) {
        BaseResult<T> result = new BaseResult<>();
        result.success = true;
        result.code = 200;
        result.message = "成功";
        result.data = data;
        return result;
    }

    public static <T> BaseResult<T> newFailure(Integer code, String message) {
        BaseResult<T> result = new BaseResult<>();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }
}
