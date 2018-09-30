package com.kekeguo.admin.util;

import lombok.Data;

@Data
public class DataResult {

    private String message;

    public DataResult(String message) {
        this.message = message;
    }

    public static DataResult success(String message){
        return new DataResult(message);
    }

}
