package com.sportsxdata.adms.controller;

import com.sportsxdata.adms.model.AthletePlansVO;
import com.sportsxdata.adms.model.PlanActionRelationVo;
import com.sportsxdata.adms.model.SectionVo;
import com.sportsxdata.adms.model.ThemeVo;
import com.sportsxdata.adms.service.TrainingService;
import com.sportsxdata.adms.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author goulin
 * @Title: ${file_name}
 * @Description: ${todo}
 * @date 2018/7/10下午4:12
 */
@RequestMapping("/export")
@Controller
public class ExcelController {

    @Autowired
    private TrainingService trainingService;

    @RequestMapping("/excel/{athleteId}/{datetime}")
    public void excel(@PathVariable String athleteId, @PathVariable String datetime, HttpServletResponse response) throws IOException {

        List<AthletePlansVO> excel = trainingService.excel(athleteId, datetime);
        if (excel != null && excel.size() > 0) {
            // 告诉浏览器用什么软件可以打开此文件
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("训练计划表", "UTF-8") + ".xls");
            //编码
            response.setCharacterEncoding("UTF-8");
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "用户数据模板.xls");
            FileInputStream fis = new FileInputStream(file);

            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);

            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(hssfWorkbook.getActiveSheetIndex());

            HSSFCellStyle style = hssfWorkbook.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);


            for (int i = 0; i < excel.size(); i++) {
                AthletePlansVO plansVO = excel.get(i);
                List<SectionVo> sectionVos = plansVO.getSectionVos();

                // 设置计划开始结束时间
                HSSFCell cell1 = sheetAt.getRow(0).getCell(0);
                String stringCellValue = cell1.getStringCellValue();
                Date t_starttime = plansVO.getT_starttime();
                Date t_endtime = plansVO.getT_endtime();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime start = LocalDateTime.ofInstant(t_starttime.toInstant(), ZoneId.systemDefault());
                LocalDateTime end = LocalDateTime.ofInstant(t_endtime.toInstant(), ZoneId.systemDefault());

                String start_formart = start.format(dateTimeFormatter);
                String end_formart = end.format(dateTimeFormatter);

                String[] split = end_formart.split(" ");
                String s = start_formart + " - " + split[1];

                cell1.setCellValue(s + " " + stringCellValue);

                for (int j = 0; j < sectionVos.size(); j++) {
                    SectionVo sectionVo = sectionVos.get(j);
                    List<ThemeVo> themeVos = sectionVo.getThemeVos();

                    // 复制表头(主题)
                    if (j > 0) {
                        ExcelUtil.copyTitle(sheetAt, sectionVo.getSname());
                    } else {
                        HSSFRow row = sheetAt.getRow(sheetAt.getLastRowNum() - 2);
                        row.getCell(0).setCellValue(sectionVo.getSname());
                    }

                    for (int x = 0; x < themeVos.size(); x++) {
                        ThemeVo themeVo = themeVos.get(x);
                        List<PlanActionRelationVo> planActionRelationVos = themeVo.getPlanActionRelationVos();

                        for (int y = 0; y < planActionRelationVos.size(); y++) {
                            PlanActionRelationVo planActionRelationVo = planActionRelationVos.get(y);
                            HSSFRow row;
                            int lastRowNum1 = sheetAt.getLastRowNum();
                            row = sheetAt.createRow(lastRowNum1 + 1);
                            ExcelUtil.copyCellColumn(sheetAt, row, themeVo, planActionRelationVo, style);
                        }// 循环最里层(动作)
                    }// 循环主题结束
                }// 循环阶段结束
            }
            hssfWorkbook.write(response.getOutputStream());

        } else {
            System.out.println("不导出");
        }
    }


}
