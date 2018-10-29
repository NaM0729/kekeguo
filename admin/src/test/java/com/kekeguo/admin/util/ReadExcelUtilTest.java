package com.kekeguo.admin.util;

import com.kekeguo.admin.AdminApplicationTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadExcelUtilTest extends AdminApplicationTest {

    @Test
    public void getDatas() {
        String path = "/Users/admin/Documents/TestImportExcel/subjectDatas.xlsx";
        File file = new File(path);
        try {
            Workbook workbook = ReadExcelUtil.creatWorkbook(file);
            List<List> datas = ReadExcelUtil.getDatas(workbook, 1);
            System.out.println(datas);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}