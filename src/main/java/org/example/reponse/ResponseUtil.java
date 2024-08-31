package org.example.reponse;

public class ResponseUtil {

    public static <T>ResponseDto<T> SUCCESS (String message, T result) {
        return new ResponseDto(ResponseCode.SUCCESS, message, result);
    }

    public static <T>ResponseDto<T> FAILURE (String message, T result) {
        return new ResponseDto(ResponseCode.FAILURE, message, result);
    }

    public static <T>ResponseDto<T> ERROR (String message, T result) {
        return new ResponseDto(ResponseCode.ERROR, message, result);
    }
}