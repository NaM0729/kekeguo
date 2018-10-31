package com.kekeguo.admin.util;

import com.kekeguo.admin.AdminApplicationTest;
import com.kekeguo.admin.excel.ReadExcelUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadExcelUtilTest extends AdminApplicationTest {

    @Test
    public void getDatas() {
        String path = "/Users/admin/Documents/TestImportExcel/testReadExcel.xlsx";
        File file = new File(path);
        try {
            Workbook workbook = ReadExcelUtil.creatWorkbook(file);
            Map<String, Object> datas = ReadExcelUtil.getDatasAndSheet(workbook,1 );
            System.out.println(datas);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}