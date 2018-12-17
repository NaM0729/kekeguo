package com.kekeguo.admin.excel;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangyuna
 * @date 2018年10月23日14:51:38
 */
public class ReadExcelUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReadExcelUtil.class);

    public static final String XLSX_TAB = ".xlsx";
    public static final String XLS_TAB = ".xls";

    public static void readMemory() {
        logger.info("总内存:" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "MB");
        logger.info("剩余内存:" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");
        logger.info("最大内存:" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "MB");
    }

    /**
     * 读取指定sheet页中的信息
     *
     * @return
     * @throws IOException
     */
    public static Sheet getSheetBySheetName(Workbook workbook, String sheetName) {
        if (StringUtils.isEmpty(sheetName) || ObjectUtils.isEmpty(workbook)) {
            return null;
        }
        logger.info("getSheetList");
        Map<String, Object> map = new HashMap<>();
        for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);
            if (sheetName.equals(sheetAt.getSheetName())) {
                return sheetAt;
            }
        }
        return null;
    }

    /**
     * 读取每个sheet页的数据
     *
     * @param sheetAt
     * @param ignoreRows
     * @return
     */
    private static List<Map> getDatasBySheet(Workbook workbook, int ignoreRows, Sheet sheetAt) {
        readMemory();
        logger.info("开始读excel");
        long start = System.currentTimeMillis();
        if (sheetAt == null) {
            sheetAt = workbook.getSheetAt(0);
        }
        List<Map> objectList = new ArrayList<>();
        int rowSize = 0;
        // 第一行为标题，不取
        Row rowOne = sheetAt.getRow(0);
        int rowNum = sheetAt.getLastRowNum();
        for (int rowIndex = ignoreRows; rowIndex <= rowNum; rowIndex++) {
            Map<String, Object> mapRow = new HashMap<>();
            Row row = sheetAt.getRow(rowIndex);   //取行信息
            if (StringUtils.isEmpty(row)) {
                continue;
            }
            int tempRowSize = row.getLastCellNum() + 1;
            if (tempRowSize > rowSize) {
                rowSize = tempRowSize;
            }
            short cellNum = row.getLastCellNum();
            for (short columnIndex = 0; columnIndex <= cellNum; columnIndex++) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    mapRow.put(String.valueOf(rowOne.getCell(columnIndex)), getCellValue(cell));
                }
            }
            objectList.add(mapRow);
        }
        logger.info("读取excel完成！耗时：" + (System.currentTimeMillis() - start));
        return objectList;
    }

    /**
     * 通过sheet名称获取该页的数据
     * @param workbook
     * @param ignoreRows
     * @param sheetName
     * @return
     */
    public static List<Map> getDatasBySheetName(Workbook workbook, int ignoreRows, String sheetName) {
        Sheet sheet = getSheetBySheetName(workbook, sheetName);
        return getDatasBySheet(workbook, ignoreRows, sheet);
    }

    /**
     * 获取excel中所有数据
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return
     * @throws IOException
     */
    public static Map<String, Object> getDatasAll(Workbook workbook, int ignoreRows) {
        readMemory();
        logger.info("开始读excel");
        long start = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);  //取sheet页
            String sheetName = sheetAt.getSheetName();
            map.put(sheetName, getDatasBySheet(workbook, ignoreRows, sheetAt));
        }
        logger.info("读取excel完成！耗时：" + (System.currentTimeMillis() - start));
        return map;
    }


    /**
     * .rowCacheSize(100)  //缓存到内存中的行数，默认是10
     * .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
     * open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
     *
     * @param file
     * @throws FileNotFoundException
     */
    public static Map<String, Object> getLargeData (File file) throws FileNotFoundException {
        readMemory();
        logger.info("开始读excel");
        long start = System.currentTimeMillis();
        FileInputStream in = new FileInputStream(file);
        Map<String, Object> map = new HashMap<>();
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(100)
                .bufferSize(4096)
                .open(in);
        for (int sheetIndex = 0; sheetIndex < wk.getNumberOfSheets(); sheetIndex++) {
            Sheet sheet = wk.getSheetAt(sheetIndex);
            List list = new LinkedList<Map>();
            Row rowOne = null;
            for (Row row : sheet) {  //遍历所有的行
                if (row.getRowNum() == 0) {
                    rowOne = row;
                    continue;
                }
                Map<String, Object> map1 = new HashMap<>();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    map1.put(getCellValue(rowOne.getCell(i)), getCellValue(row.getCell(i)));
                }
                list.add(map1);
            }
            map.put(sheet.getSheetName(), list);
        }
        logger.info("读取excel完成！耗时：" + (System.currentTimeMillis()-start));
        return map;
    }

    /**
     * 另外如果日期中有精确到日，精确到秒不同精度的，可以用cell.getCellStyle().getDataFormat()或cell.getCellStyle().getDataFormatString()来获取格式。
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
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
//                    // 取一位整数
//                    DecimalFormat df = new DecimalFormat("0");
//                    cellValue = df.format(cell.getNumericCellValue());
                    cellValue = String.valueOf(cell.getNumericCellValue());
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

    /**
     * 获取Workbook
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Workbook creatWorkbook(String filePath) throws IOException {
        Workbook book = null;
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (filePath.endsWith(XLS_TAB)) {
                book = new HSSFWorkbook(is);
            } else if (filePath.endsWith(XLSX_TAB)) {
                book = new XSSFWorkbook(is);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return book;
    }

    public static Workbook creatWorkbook(File file) throws IOException {
        Workbook book = null;
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            if (file.getName().endsWith(XLS_TAB)) {
                book = new HSSFWorkbook(is);
            } else if (file.getName().endsWith(XLSX_TAB)) {
                book = new XSSFWorkbook(is);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return book;
    }
}
