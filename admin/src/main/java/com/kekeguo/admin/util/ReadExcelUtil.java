package com.kekeguo.admin.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author zhangyuna
 * @date 2018年10月23日14:51:38
 */
public class ReadExcelUtil {

    /**
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return
     * @throws IOException
     */
    public static DataByExcel ReadData(int ignoreRows, String filePath) throws IOException, InvalidFormatException {
//        String filePath = "/Users/admin/Documents/AIdemo.xls";
        File file = new File(filePath);
        DataByExcel dataByExcel = new DataByExcel();
        if (file.isFile() && file.exists()) {  //判断文件是否存在
            dataByExcel.message = "文件不存在";
            return dataByExcel;
        }
        filePath = "/Users/admin/Documents/AIdemo.xls";
        Workbook sheets = readExcel(filePath);

        if (ObjectUtils.isEmpty(sheets)) {
            dataByExcel.message = "文件格式不正确";
            return dataByExcel;
        }
        dataByExcel.setData(ReadExcel(sheets, ignoreRows));

        return dataByExcel;
    }

    private static Workbook readExcel(String filePath) throws InvalidFormatException {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            File file = new File(filePath);
            if (".xls".equals(extString)) {
                is = new FileInputStream(file);
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(file);
            } else {
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    private static List<List> ReadExcel(Workbook sheets, int ignoreRows) {
        List<List> objectList = new ArrayList<>();
        int rowSize = 0;
        for (int sheetIndex = 0; sheetIndex < sheets.getNumberOfSheets(); sheetIndex++) {
            Sheet sheetAt = sheets.getSheetAt(sheetIndex);
            // 第一行为标题，不取  ignoreRows = 1
            for (int rowIndex = ignoreRows; rowIndex <= sheetAt.getLastRowNum(); rowIndex++) {
                Row row = sheetAt.getRow(rowIndex);
                if (StringUtils.isEmpty(row)) {
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if (tempRowSize > rowSize) {
                    rowSize = tempRowSize;
                }
                List<Object> list = new ArrayList<>();
                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        if (columnIndex == 4) {
                            String str = getCellValue(cell);
                            list.add(groupBy(str));
                        } else {
//                            list.add(getCellValue(cell));
                        }
                    }
                }
                objectList.add(list);
            }
        }
        return objectList;
    }


    //获取xlsx单元格数据
    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
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

    private static List groupBy(String str) {
        List<Object> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();

        String pat1 = "\\d+\\、"; // 指定好正则表达式
        Pattern p1 = Pattern.compile(pat1); // 实例化Pattern类
        String s1[] = p1.split(str); // 执行拆分操作
        if (s1.length > 0) {
            for (int i = 0; i < s1.length; i++) {
                if (!StringUtils.isEmpty(s1[i].trim())) {
                    list1.add(i + "、" + s1[i].trim());
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = new HashMap<>();
            String data1 = (String) list1.get(i);
            String pat2 = "\\（+\\d+\\）"; // 指定好正则表达式
            Pattern p2 = Pattern.compile(pat2); // 实例化Pattern类
            String s2[] = p2.split(data1);
            List<Object> list2 = new ArrayList<>();
            if (s2.length > 1) {
                for (int j = 1; j < s2.length; j++) {
                    if (!StringUtils.isEmpty(s2[j].trim())) {
                        list2.add("（" + j + "）" + s2[j].trim());
                    }
                }
            }
            map1.put("header", s2[0].trim());
            map1.put("option", list2);
            list.add(map1);
        }

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map2 = (Map<String, Object>) list.get(i);
            List list3 = (List) map2.get("option");
            List list5 = new ArrayList();
            if (list3.size() > 0) {
                for (int j = 0; j < list3.size(); j++) {
                    Map<String, Object> map4 = new HashMap<>();
                    List list4 = new ArrayList();
                    String data2 = (String) list3.get(j);
                    String[] split = data2.split("\\n");
                    if(split.length == 1){
                        map4.put("header", split[0].trim());
                        map4.put("option", list4);
                    }
                    if (split.length > 1) {
                        for (int k = 1; k < split.length; k++) {
                            Map<String, String> map3 = new HashMap<>();
                            if (!StringUtils.isEmpty(split[k].trim())) {
                                map3.put("header", split[k].trim());
                            }
                            list4.add(map3);
                        }
                        map4.put("header", split[0].trim());
                        map4.put("option", list4);
                    }
                    list5.add(map4);
                }
                map2.put("option", list5);
            }
        }

        System.out.println(list);
        return list;
    }


    public static void main(String[] args) {
        String str = "1、资本一帝国主义列强对中国的侵略，首先和主要的是进行军事侵略\n" +
                "\n 2、第一次鸦片战争后\n" +
                "（1）1842年8月，中英《南京条约（江宁条约）》（第一个不平等条约）\n" +
                "\n" +
                "①割让香港岛给英国\n" +
                "\n" +
                "②开放广州、厦门、福州、宁波、上海等港口城市作通商口岸\n" +
                "\n" +
                "③赔款2100万银元\n" +
                "\n" +
                "（2）1843年，中英《五口通商章程》\n" +
                "\n" +
                "（3）1843年，中英《虎门条约》\n" +
                "\n" +
                "（4）1844年，中美《望厦条约》 \n" +
                "（5）1844年，中法《黄埔条约》\n" +
                "\n" +
                "3、第二次鸦片战争后\n" +
                "（1）1858年，中俄《瑷珲条约》\n" +
                "\n" +
                "①割去黑龙江以北60多万平方公里的中国领土 \n" +
                "（2）1858年，中、美、英、法、俄 《天津条约》 \n" +
                "（3）1860年，中英《北京条约》 \n" +
                "\n" +
                "①割让九龙半岛南端和昂船洲\n" +
                "\n" +
                "②赔款800万两\n" +
                "\n" +
                "（4）1860年，中法《北京条约》\n" +
                "\n" +
                "①赔款800万两\n" +
                "\n" +
                "（5）1860年，中俄《北京条约》\n" +
                "\n" +
                "①割去乌苏里江以东40万平方公里领土\n" +
                "\n" +
                "（6）1864年，中俄《勘分西北界约记》\n" +
                "\n" +
                "①割去中国西北44万多平方公里的领土\n" +
                "\n" +
                "（7）1881年，中俄《改订伊犁条约》和5个勘界议定书\n" +
                "\n" +
                "①割去7万平方公里领土\n";

        List<Object> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();


        String pat1 = "\\d+\\、"; // 指定好正则表达式
        Pattern p1 = Pattern.compile(pat1); // 实例化Pattern类
        String s1[] = p1.split(str); // 执行拆分操作
        if (s1.length > 0) {
            for (int i = 0; i < s1.length; i++) {
                if (!StringUtils.isEmpty(s1[i].trim())) {
                    list1.add(i + "、" + s1[i].trim());
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = new HashMap<>();
            String data1 = (String) list1.get(i);
            String pat2 = "\\（+\\d+\\）"; // 指定好正则表达式
            Pattern p2 = Pattern.compile(pat2); // 实例化Pattern类
            String s2[] = p2.split(data1);
            List<Object> list2 = new ArrayList<>();
            if (s2.length > 1) {
                for (int j = 1; j < s2.length; j++) {
                    if (!StringUtils.isEmpty(s2[j].trim())) {
                        list2.add("（" + j + "）" + s2[j].trim());
                    }
                }
            }
            map1.put("header", s2[0].trim());
            map1.put("option", list2);
            list.add(map1);
        }

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map2 = (Map<String, Object>) list.get(i);
            List list3 = (List) map2.get("option");
            List list5 = new ArrayList();
            if (list3.size() > 0) {
                for (int j = 0; j < list3.size(); j++) {
                    Map<String, Object> map4 = new HashMap<>();
                    List list4 = new ArrayList();
                    String data2 = (String) list3.get(j);
                    String[] split = data2.split("\\n");
                    if (split.length > 1) {
                        for (int k = 1; k < split.length; k++) {
                            Map<String, String> map3 = new HashMap<>();
                            if (!StringUtils.isEmpty(split[k].trim())) {
                                map3.put("header", split[k]);
                            }
                            list4.add(map3);
                        }
                        map4.put("header", split[0]);
                        map4.put("option", list4);
                    }
                    list5.add(map4);
                }
                map2.put("option", list5);
            }
        }

        System.out.println(list);
    }


}
