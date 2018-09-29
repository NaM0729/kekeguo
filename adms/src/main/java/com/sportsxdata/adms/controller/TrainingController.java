package com.sportsxdata.adms.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sportsxdata.adms.model.*;
import com.sportsxdata.adms.service.AdmsAthleticsDataService;
import com.sportsxdata.adms.service.TrainingService;
import com.sportsxdata.adms.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Slf4j
@Controller
@RequestMapping("/training")
@ResponseBody
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    /**
     * 查看该教练下训练计划列表 zyn 2018-06-28
     * @param entry
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @RequestMapping("getTraningPlanListsBycocah")
    public PageSizeDataGrid getTraningPlanListsBycocah(@RequestBody TraningPlanListsBycocahEntry entry) {
        return trainingService.getTraningPlanListsBycocah(entry);
    }

    /**
     * 删除训练计划 zyn 2018-06-28
     * @param entry
     * @return
     * @throws IOException
     */
    @RequestMapping("deleteTraningPlanById")
    public PageSizeDataGrid deleteTraningPlanById(@RequestBody TraningPlanListsBycocahEntry entry) {
        return trainingService.deleteTraningPlanById(entry);
    }

    /**
     * 添加训练计划
     * @param insertTrainPlanPojo
     * @return
     */
    @PostMapping("insertTrainPlan")
    public DataResult insertTrainPlan(@RequestBody InsertTrainPlanPojo insertTrainPlanPojo){
        return trainingService.insertTrainPlan(insertTrainPlanPojo);

    }

    /**
     *通过训练阶段id查询训练主题
     * id写死如下
     * 1.动作准备
     * 2.主要训练
     * 3.整理放松
     */
    @GetMapping("selectThemeBySectionId/{sectionId}/{coachId}")
    public DataResult selectThemeBySectionId(@PathVariable String sectionId,@PathVariable String coachId){
        return trainingService.selectThemeBySectionId(sectionId,coachId);
    }
    /**
     * 通过主题id查询动作集
     *
     */
    @GetMapping("selectActionByThemeId/{themeId}/{coachId}")
    public DataResult selectActionByThemeId(@PathVariable String themeId,@PathVariable String coachId){
        return trainingService.selectActionByThemeId(themeId,coachId);
    }

    /**
     * 数字录入中 展示运动员列表（通过训练时间段来分类） zyn 2018-06-30
     * @return
     */
    @GetMapping("getAthletesByTrainingTimeAndCoachId/{coachId}")
    public DataResult getAthletesByTrainingTimeAndCoachId(@PathVariable String coachId){
        return trainingService.getAthletesByTrainingTimeAndCoachId(coachId);
    }

    /**
     * 数字录入中 展示运动员列表（包含训练进行状态） zyn 2018-06-30
     * @return
     */
    @GetMapping("getAthletesTrainingByCoachId/{coachId}")
    public DataResult getAthletesTrainingByCoachId(@PathVariable String coachId){
        return trainingService.getAthletesTrainingByCoachId(coachId);
    }



    @RequestMapping("/download/{coachId}")
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String coachId ) {
//        // 告诉浏览器用什么软件可以打开此文件
//        response.setHeader("content-Type", "application/pdf");
//        // 下载文件的默认名称
//        response.setHeader("Content-Disposition", "attachment;filename=user.pdf");
//
//        Document document = new Document();
//        PdfWriter.getInstance(document, response.getOutputStream());
//        document.open();
//        DataResult dataResult = admsAthleticsDataService.queryAthleteDataList(coachId);
//        List<Map<String,String>> data = (List<Map<String, String>>) dataResult.getData();
//
//        for (Map<String,String> user : data) {
//            PdfPTable table = new PdfPTable(3);
//            PdfPCell cell = new PdfPCell();
//            cell.setPhrase(new Paragraph(user.get("attendanceId").toString()));
//            table.addCell(cell);
//            document.add(table);
//
//            cell = new PdfPCell();
//            cell.setPhrase(new Paragraph(user.get("name").toString()));
//            table.addCell(cell);
//            document.add(table);
//
//            cell = new PdfPCell();
//            cell.setPhrase(new Paragraph(user.get("sex").toString()));
//            table.addCell(cell);
//            document.add(table);
//        }
//        document.close();
    }


    /**
     * 根据训练计划id,获得训练计划数据
     * @param planId
     * @return
     */
    @RequestMapping("/planInfo/{planId}")
    public DataResult getPlanById(@PathVariable String planId){
        DataResult trainingPlanById = trainingService.getTrainingPlanById(planId);
        return trainingPlanById;
    }

    @RequestMapping("/getPlansByDateTime/{athleteId}/{datetime}")
    public DataResult getPlansByDateTime(@PathVariable String athleteId, @PathVariable String datetime){
        log.info("查询运动员{}在{}时的训练计划",athleteId,datetime);
        DataResult planByAthleteIdAndDatetime = trainingService.getPlanInfoByAthleteIdAndTime(athleteId, datetime);
        log.info("查询结果{}",planByAthleteIdAndDatetime);
        return planByAthleteIdAndDatetime;
    }


    @RequestMapping("/planInfo/{coachId}/{planId}")
    public DataResult planInfo(@PathVariable String coachId, @PathVariable String planId){
        log.info("编辑教练员{}下的计划id{}时的训练计划",coachId,planId);
        DataResult planByAthleteIdAndDatetime = trainingService.editPlanInfoByCoachIdAndPlanId(coachId, planId);
        log.info("编辑查询结果{}",planByAthleteIdAndDatetime);
        return planByAthleteIdAndDatetime;
    }



    /**
     * 编辑训练计划后保存
     */
    @PostMapping("afterUpdateToSaveTrainPlan")
    public DataResult afterUpdateToSaveTrainPlan(@RequestBody InsertEveryDayTrainPlanPojo insertEveryDayTrainPlanPojo){
        return trainingService.afterUpdateToSaveTrainPlan(insertEveryDayTrainPlanPojo);
    }

    @RequestMapping("/seachPlan/{planId}")
    public DataResult seachPlanInfoById(@PathVariable String planId){
        log.info("查看{}的计划详情",planId);
        return trainingService.seachPlanInfoById(planId);
    }

    /**
     * 查询某教练员下所有运动员
     */
    @GetMapping("selectAllAthleteByCoachId/{coachId}")
    public DataResult selectAllAthleteByCoachId(@PathVariable String coachId){
        return trainingService.selectAllAthleteByCoachId(coachId);
    }

}
