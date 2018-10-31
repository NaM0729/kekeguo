package com.kekeguo.admin.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.kekeguo.admin.util.DataResult;
import com.kekeguo.admin.excel.ReadExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author zhangyuna
 * @date 2018年10月17日17:38:20
 *
 */
@RestController
public class ReadExcelController {

    /**
     * 适用于读取一个sheet信息
     * @param excelFile
     * @return
     * @throws Exception
     */
    @PostMapping("saveExcel1")
    public DataResult readExcel(MultipartFile excelFile) throws Exception {
        List<Map<String, String>> excelList;
        if (ObjectUtils.isEmpty(excelFile)) {
            return DataResult.error("Excel不可为空");
        }
        ImportParams params = new ImportParams();
        excelList = ExcelImportUtil.importExcel(
                excelFile.getInputStream(), Map.class, params);
        System.out.println(excelList);
        return DataResult.success(null);
    }

    /**
     * 适用于读取多个sheet信息
     * @param excelFile
     * @return
     * @throws Exception
     */
    @PostMapping("saveExcel2")
    public DataResult readAllExcel(MultipartFile excelFile) throws Exception {
        if (ObjectUtils.isEmpty(excelFile)) {
            return DataResult.error("Excel不可为空");
        }
        Workbook book = null;
        if(excelFile.getOriginalFilename().endsWith(ReadExcelUtil.XLS_TAB)) {
            book = new HSSFWorkbook(excelFile.getInputStream());
        }else if(excelFile.getOriginalFilename().endsWith(ReadExcelUtil.XLSX_TAB)) {
            book = new XSSFWorkbook(excelFile.getInputStream());
        }else {
            book = null;
            return DataResult.error("请上传Excel文件");
        }
        Map<String, Object> datas = ReadExcelUtil.getDatasAndSheet(book, 1);
        System.out.println(datas);
        return DataResult.success("读取完成");
    }
}
