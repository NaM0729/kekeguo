package com.kekeguo.admin.util;

import java.io.File;
import java.util.List;

/**
 * @author zhangyuna
 * @date 2018年10月23日15:08:54
 */
public class DataByExcel {
    public List<List> data;
    public String message = "";

    public List<List> getData() {
        return data;
    }

    public void setData(List<List> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
