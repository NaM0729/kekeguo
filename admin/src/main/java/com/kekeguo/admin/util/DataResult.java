package com.kekeguo.admin.util;

import lombok.Data;

@Data
public class DataResult {

    private String message;
    private Object data;

    public DataResult(String message) {
        this.message = message;
    }

    public DataResult(Object data) {
        this.data = data;
    }

    public static DataResult success(String message) {
        return new DataResult(message);
    }

    public static DataResult success(Object data) {
        return new DataResult(data);
    }
    public static DataResult error(String message) {
        return new DataResult(message);
    }

}
