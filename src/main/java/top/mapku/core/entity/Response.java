package top.mapku.core.entity;

import org.springframework.stereotype.Component;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class Response {
    private Boolean success;
    private Object data;
    private String message;

    public Response() {
    }

    public Response(Boolean success, Object data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static Response success(Object data) {
        return new Response(true, data, "访问成功");
    }

    public static Response info(Object data, String message) {
        return new Response(true, data, message);
    }

    public static Response fail(String message) {
        return new Response(false, null, message);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
