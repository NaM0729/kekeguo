package com.kekeguo.admin.util;

import com.sunlands.study.common.constant.DeleteFlag;
import com.sunlands.study.service.entity.biz.SubjectEntity;
import com.sunlands.study.service.mapper.master.biz.SubjectMapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zhangyuna
 * @date 2018年10月17日17:38:20
 * <dependency>
 * <groupId>org.apache.poi</groupId>
 * <artifactId>poi-ooxml</artifactId>
 * <version>3.15</version>
 * </dependency>
 */
@RestController
public class ReadExcelController {

    @RequestMapping("saveSubjectByExcel")
    public void saveSubjectByExcel() throws IOException, InvalidFormatException {
        List<List> datas = getDatas(1);
        List<List> collect = datas.stream().filter(distinctByKey(list -> list.get(0))).collect(Collectors.toList());
        System.out.println((collect.size()));
        List<SubjectEntity> subjectList = subjectMapper.getSubjectList();

        for (int i = 0; i < collect.size(); i++) {
            List<String> list = collect.get(i);
            SubjectEntity subjectEntity = checkName(subjectList, list.get(0));
//            SubjectEntity subjectEntity = new SubjectEntity();
            if(StringUtils.isEmpty(subjectEntity.getId())){
                System.out.println(list.get(0));
                subjectEntity.setName(list.get(0));
                subjectEntity.setKnowledgeTreeId(list.get(1));
                subjectEntity.setHasKnowledgeTree(1);
                subjectEntity.setProperty("SP_ZY");
                subjectEntity.setExamMode("SE_W");
                subjectEntity.setIsOptional(0);
                subjectEntity.setIsCertificateCourse(0);
                subjectEntity.setCreateUserId("0");
                subjectEntity.setCreateTime(new Date());
                subjectEntity.setUpdateTime(new Date());
                subjectEntity.setOperatorId("0");
                subjectEntity.setDeleteFlag(DeleteFlag.NORMAL.getValue());
//                subjectMapper.insert(subjectEntity);
            }
            else {
                subjectEntity.setKnowledgeTreeId(list.get(1));
//                subjectMapper.update(subjectEntity);
            }
        }

    }

    public SubjectEntity checkName(List<SubjectEntity> list,String name){
        for(int i=0;i<list.size();i++){
            SubjectEntity subjectEntity = list.get(i);
            if(name.equals(subjectEntity.getName())){
                return subjectEntity;
            }
        }
        return null;
    }

    /**
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return
     * @throws IOException
     */
    public List<List> getDatas(int ignoreRows) throws IOException, InvalidFormatException {
        List<List> objectList = new ArrayList<>();
        File file = new File("/Users/admin/Documents/subjectData.xlsx");
        XSSFWorkbook sheets = new XSSFWorkbook(file);
        int rowSize = 0;
        for (int sheetIndex = 0; sheetIndex < sheets.getNumberOfSheets(); sheetIndex++) {
            XSSFSheet sheetAt = sheets.getSheetAt(sheetIndex);
            // 第一行为标题，不取
            for (int rowIndex = ignoreRows; rowIndex <= sheetAt.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheetAt.getRow(rowIndex);
                if (StringUtils.isEmpty(row)) {
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if (tempRowSize > rowSize) {
                    rowSize = tempRowSize;
                }
                List<String> list = new ArrayList<>();
                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                    XSSFCell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        list.add(getCellValue(cell));
                    }
                }
                objectList.add(list);
            }
        }

        return objectList;
    }


    //获取xlsx单元格数据
    public static String getCellValue(XSSFCell cell) {
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

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {

        Map<Object,Boolean> seen = new ConcurrentHashMap<>();

        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;

    }
}
