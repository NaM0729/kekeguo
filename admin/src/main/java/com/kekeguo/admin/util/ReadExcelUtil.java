package com.kekeguo.admin.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangyuna
 * @date 2018年10月23日14:51:38
 */
public class ReadExcelUtil {

    public static final String XLSX_TAB = ".xlsx";
    public static final String XLS_TAB = ".xls";

    /**
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return
     * @throws IOException
     */
    public static Map<String, Object> getDatas(Workbook workbook, int ignoreRows) throws IOException, InvalidFormatException {

        Map<String, Object> map = new HashMap<>();
        List<Map> objectList = new ArrayList<>();
        int rowSize = 0;
        for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);  //取sheet页
            String sheetName = sheetAt.getSheetName();

            // 第一行为标题，不取
            Row rowOne = sheetAt.getRow(0);
            Map<String, Object> mapRow = new HashMap<>();
            for (int rowIndex = ignoreRows; rowIndex <= sheetAt.getLastRowNum(); rowIndex++) {

                Row row = sheetAt.getRow(rowIndex);   //取行信息
                if (StringUtils.isEmpty(row)) {
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if (tempRowSize > rowSize) {
                    rowSize = tempRowSize;
                }
                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        mapRow.put(String.valueOf(rowOne.getCell(columnIndex)), getCellValue(cell));
                    }
                }
                objectList.add(mapRow);
            }
            map.put(sheetName, objectList);
        }
        return map;
    }

    /**
     * 另外如果日期中有精确到日，精确到秒不同精度的，可以用cell.getCellStyle().getDataFormat()或cell.getCellStyle().getDataFormatString()来获取格式。
     * @param cell
     * @return
     */
    //获取xlsx单元格数据
    public static String getCellValue(Cell cell) {
        String  cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = simpleDateFormat.format(cell.getDateCellValue());
                } else {
                    DecimalFormat df = new DecimalFormat("0");
                    cellValue = df.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public static Workbook creatWorkbook(File file) throws IOException {
        if (file.getName().endsWith(XLS_TAB)) {
            return new HSSFWorkbook(new FileInputStream(file));
        }
        if (file.getName().endsWith(XLSX_TAB)) {
            return new XSSFWorkbook(new FileInputStream(file));
        }
        return null;
    }
}
