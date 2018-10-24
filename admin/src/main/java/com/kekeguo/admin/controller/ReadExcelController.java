package com.kekeguo.admin.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.kekeguo.admin.util.DataByExcel;
import com.kekeguo.admin.util.DataResult;
import com.kekeguo.admin.util.ReadExcelUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

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

    @GetMapping("saveDataByLocal")
    public DataResult saveSubjectByExcel(@Param("filePath") String filePath) throws IOException, InvalidFormatException {
//        String filePath = "/Users/admin/Documents/AIdemo.xls";
        DataByExcel dataByExcel = ReadExcelUtil.ReadData(1, filePath);
        return DataResult.success(dataByExcel.getData());
    }

    @GetMapping("saveExcel")
    public DataResult saveSubjectByExcel(MultipartFile excelFile) throws Exception {
        List<Map<String, String>> excelList;
        if (null != excelFile && !excelFile.isEmpty()) {
            ImportParams params = new ImportParams();
            excelList = ExcelImportUtil.importExcel(
                    excelFile.getInputStream(), Map.class, params);

            System.out.println(excelList);
        } else {
            return DataResult.error("Excel不可为空");
        }

        return DataResult.success(null);
    }



    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();

        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;

    }
}
