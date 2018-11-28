package com.kekeguo.admin.util;

import java.io.File;

/**
 * @author zhangyuna
 * @date 2018年11月28日17:22:58
 */
public class ReadFileTest {

    public static String[] readFileList(String filePath) {
        File files = new File(filePath);
        File[] fileLists = files.listFiles();
        String[] fileNames = new String[fileLists.length];
        int num = 0;
        for (File file : fileLists) {
            fileNames[num++] = file.getName();
        }
        return fileNames;
    }

    public static void main(String[] args) {
        String filePath = "/Users/admin/Desktop/已完成sql";
        String[] strings = readFileList(filePath);
        System.out.println(strings);
    }
}
