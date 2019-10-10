package edu.whu.sim.cloudnote.entity;

import org.apache.http.HttpStatus;

public class BaseResponse<T> {

    private int status;
    private String message;
    private Object data;
    private String exception;
    private String error;

    public static <T> BaseResponse successResponse(T data) {
        return new BaseResponse(HttpStatus.SC_OK, "SUCCESS", data);
    }

    public static BaseResponse successResponse() {
        return new BaseResponse(HttpStatus.SC_OK, "SUCCESS", null);
    }

    public static BaseResponse internalServerError(String message) {
        return new BaseResponse(HttpStatus.SC_INTERNAL_SERVER_ERROR, message, null);
    }

    public static BaseResponse notFoundError(String message) {
        return new BaseResponse(HttpStatus.SC_NOT_FOUND, message, null);
    }

    public static BaseResponse errorResponse(int status, String message) {
        return new BaseResponse(status, message, null);
    }

    public static BaseResponse errorResponse(int status, String message, String exception, String error) {
        BaseResponse response = new BaseResponse(status, message, null);
        response.setException(exception);
        response.setError(error);
        return response;
    }


    public BaseResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
