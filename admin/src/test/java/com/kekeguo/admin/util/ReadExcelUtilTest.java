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

    String path = "/Users/admin/Documents/TestImportExcel/大批量数据.xlsx";

    @Test
    public void getDatas() {
        try {
            Workbook workbook = ReadExcelUtil.creatWorkbook(path);
            Map<String, Object> datas = ReadExcelUtil.getDatasAndSheet(workbook, 1);
            System.out.println(datas);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoad() throws Exception {
        Map<String, Object> datasAndSheetBig = ReadExcelUtil.getDatasAndSheetBig(new File(path));
        System.out.println(datasAndSheetBig);
    }
}