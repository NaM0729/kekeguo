package com.sportsxdata.adms.utils;

import com.sportsxdata.adms.model.PlanActionRelationVo;
import com.sportsxdata.adms.model.ThemeVo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author goulin
 * @Title: ${file_name}
 * @Description: ${todo}
 * @date 2018/7/10下午4:35
 */
public class ExcelUtil {



    /**
     * 复制头部信息
     * @param st
     * @param insertRowNum
     */
    public static void copyTitle(HSSFSheet st, String sname){
        int head_start_row = 1;
        int head_end_row = 4;
        copyRows(st, head_start_row, head_end_row, st.getLastRowNum()+1);
        HSSFRow row = st.getRow(st.getLastRowNum() - 3);
        st.removeRow(row);
        // 修改阶段名称
        row = st.getRow(st.getLastRowNum() - 2);
        String stringCellValue = row.getCell(0).getStringCellValue();
        row.getCell(0).setCellValue(sname);
    }

    public static void copyCellColumn(HSSFSheet sh, HSSFRow row  , ThemeVo themeVo, PlanActionRelationVo planActionRelationVo, CellStyle style){
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(themeVo.getTname());
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(planActionRelationVo.getActname());
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue(planActionRelationVo.getGroupNum());
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue(planActionRelationVo.getTimeReal());
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue(planActionRelationVo.getTime());
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue(planActionRelationVo.getIntervalReal());
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue(planActionRelationVo.getInterval());
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue(planActionRelationVo.getDurationReal());
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue(planActionRelationVo.getDuration());
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue(planActionRelationVo.getStrengthReal());
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue(planActionRelationVo.getStrength());
        cell.setCellStyle(style);

        cell = row.createCell(11);
        cell.setCellValue(planActionRelationVo.getMaxSpeed());
        cell.setCellStyle(style);

        cell = row.createCell(12);
        cell.setCellValue(planActionRelationVo.getAvgSpeed());
        cell.setCellStyle(style);

        cell = row.createCell(13);
        cell.setCellValue(planActionRelationVo.getMaxPower());
        cell.setCellStyle(style);

        cell = row.createCell(14);
        cell.setCellValue(planActionRelationVo.getAvgPower());
        cell.setCellStyle(style);

        cell = row.createCell(15);
        cell.setCellValue(planActionRelationVo.getAssess());
        cell.setCellStyle(style);

    }


    /**
     * 复制cell
     * @param srcCell
     * @param distCell
     */
    public static void copyCell(HSSFCell srcCell, HSSFCell distCell){
        distCell.setCellStyle(srcCell.getCellStyle());
        if(srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }
        int srcCellType = srcCell.getCellType();
        distCell.setCellType(srcCellType);

        if (srcCellType == HSSFCell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(srcCell)) {
                distCell.setCellValue(srcCell.getDateCellValue());
            } else {
                distCell.setCellValue(srcCell.getNumericCellValue());
            }
        } else if (srcCellType == HSSFCell.CELL_TYPE_STRING) {
            distCell.setCellValue(srcCell.getRichStringCellValue());
        } else if (srcCellType == HSSFCell.CELL_TYPE_BLANK) {
            //nothing
        } else if (srcCellType == HSSFCell.CELL_TYPE_BOOLEAN) {
            distCell.setCellValue(srcCell.getBooleanCellValue());
        } else if (srcCellType == HSSFCell.CELL_TYPE_ERROR) {
            distCell.setCellErrorValue(srcCell.getErrorCellValue());
        } else if (srcCellType == HSSFCell.CELL_TYPE_FORMULA) {
            distCell.setCellFormula(srcCell.getCellFormula());
        } else {
            //nothing
        }
    }

    /**
     *复制行
     * @param st
     * @param startRow
     * @param endRow
     * @param pPosition  准备在哪行 开始加新复制的行
     */
    //to same sheet
    public static void copyRows(HSSFSheet st,int startRow,int endRow,int pPosition) {
        int pStartRow = startRow - 1;
        int pEndRow = endRow - 1;
        int targetRowFrom;
        int targetRowTo;
        int columnCount;
        CellRangeAddress region = null;
        int i;
        int j;

        if(pStartRow==-1||pEndRow ==-1) {
            return;
        }

        //merged cells
        System.out.println(st.getNumMergedRegions());
        List<CellRangeAddress> mergedRegions = st.getMergedRegions();
        List<CellRangeAddress> distinctClass = mergedRegions.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getFirstColumn() + ";" + o.getLastColumn()+";"+o.getFirstRow()+";"+o.getLastRow()))), ArrayList::new));
        for (i = 0; i < distinctClass.size(); i++) {
            region = distinctClass.get(i);
            if ((region.getFirstRow() >= pStartRow)&& (region.getLastRow() <= pEndRow)) {
                targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
                targetRowTo = region.getLastRow() - pStartRow + pPosition;

                CellRangeAddress newRegion = new CellRangeAddress(targetRowFrom,targetRowTo,region.getFirstColumn(),region.getLastColumn());

                int i1 = st.addMergedRegion(newRegion);
            }
        }
        //set the column height and value
        for (i = pStartRow; i <= pEndRow; i++) {
            HSSFRow sourceRow = st.getRow(i);
            columnCount = sourceRow.getLastCellNum();
            if(sourceRow != null) {
                HSSFRow newRow = st.createRow(pPosition+i);
                newRow.setHeight(sourceRow.getHeight());
                for(j=0;j<columnCount;j++) {
                    HSSFCell templateCell = sourceRow.getCell(j);
                    if(templateCell != null) {
                        HSSFCell newCell = newRow.createCell(j);
                        copyCell(templateCell,newCell);
                    }
                }
            }
        }
    }
}
