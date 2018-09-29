package com.sportsxdata.adms.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.sportsxdata.adms.dao.AthleteMapper;
import com.sportsxdata.adms.dao.PlanActionRelationMapper;
import com.sportsxdata.adms.dao.TrainingPlanMapper;
import com.sportsxdata.adms.model.*;
import com.sportsxdata.adms.utils.CreateHtmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Slf4j
public class FreemarkerController {

    @Autowired
    private PlanActionRelationMapper planActionRelationMapper;
    @Autowired
    private AthleteMapper athleteMapper;

    @RequestMapping("/exportPlanInfo/{planId}")
    public void demo(Map<String, Object> map, @PathVariable String planId, HttpServletResponse response) throws IOException {
        log.info("导出{}训练计划的pdf",planId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("hh时mm分");
        TrainingPlanInfo trainingPlanInfo = planActionRelationMapper.selectInfoByPlanId(planId);
        List<Athlete> athletes = athleteMapper.selectAthletesByPlanId(planId);
        if (trainingPlanInfo == null){
            //程序控制浏览器以什么码表打开
            response.setHeader("content-type", "text/html;charset=utf-8");
            String data = "该训练计划未添加训练动作";
            OutputStream out = response.getOutputStream();
            //以什么编码打入
            out.write(data.getBytes("utf-8"));
            out.close();
            return;
        }
        if (athletes == null || athletes.size() == 0){
            //程序控制浏览器以什么码表打开
            response.setHeader("content-type", "text/html;charset=utf-8");
            String data = "该训练计划无人参加";
            OutputStream out = response.getOutputStream();
            //以什么编码打入
            out.write(data.getBytes("utf-8"));
            out.close();
            return;
        }
        trainingPlanInfo.setAthleteIdList(athletes);
        List<SectionVoByPdf> sectionVoList = trainingPlanInfo.getSectionVoList();
        for (SectionVoByPdf s : sectionVoList) {
            if ("1".equals(s.getSectionId())){
                trainingPlanInfo.getReadyAction().add(s);
            }else if ("2".equals(s.getSectionId())){
                trainingPlanInfo.getAdminAction().add(s);
            }else{
                trainingPlanInfo.getRelaxAction().add(s);
            }
        }
        map.put("remark",trainingPlanInfo.getRemark()== null?"":trainingPlanInfo.getRemark());
        map.put("startTime",dateFormat.format(trainingPlanInfo.getStartTime()));
        map.put("endTime",dateFormat.format(trainingPlanInfo.getEndTime()));
        map.put("site",trainingPlanInfo.getSite()== null?"":trainingPlanInfo.getSite());
        map.put("stage",trainingPlanInfo.getStage()== null?"":trainingPlanInfo.getStage());
        map.put("teamName",trainingPlanInfo.getTeamName() == null?"":trainingPlanInfo.getTeamName());
        map.put("target",trainingPlanInfo.getTarget()== null?"":trainingPlanInfo.getTarget());
        map.put("readyAction",trainingPlanInfo.getReadyAction());
        map.put("adminAction",trainingPlanInfo.getAdminAction());
        map.put("relaxAction",trainingPlanInfo.getRelaxAction());
        map.put("athleteIdList",trainingPlanInfo.getAthleteIdList());
        map.put("belongCoach",trainingPlanInfo.getBelongcoach());
        map.put("lengthOfTime",dateFormat2.format(trainingPlanInfo.getStartTime()) + "-" + dateFormat2.format(trainingPlanInfo.getEndTime()));
        try {
            String fileName = map.get("startTime") + "" + dateFormat3.format(trainingPlanInfo.getStartTime()) + "开始的训练计划";
            CreateHtmlUtils.createHtml("model.ftl","model.html",map);
            createPdf(fileName + ".pdf",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createPdf(String fileName,HttpServletResponse response) {
        try {
            // 防止中文乱码
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("ISO-8859-1"),"UTF-8") + "\"");
            response.setContentType("application/octet-stream;charset=UTF-8");
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
            Font font = new Font(bfChinese, 12, Font.NORMAL);

            Document document = new Document(PageSize.A4, 10, 10, 10, 10);
            PdfWriter mPdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
            document.open();


            File file = new File(ResourceUtils.getFile("classpath:templates").getPath() + "/" + "model.html");
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            StringBuffer lineTxt = new StringBuffer();
            String s = null;
            while((s = bufferedReader.readLine()) != null){
                lineTxt.append(s);
            }
            read.close();
            ByteArrayInputStream bin = new ByteArrayInputStream(lineTxt.toString().getBytes());
            XMLWorkerHelper.getInstance().parseXHtml(mPdfWriter, document, bin, Charset.forName("UTF-8"), new ChinaFontProvide());
            document.close();
            mPdfWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 提供中文
     *
     */
    public static final class ChinaFontProvide implements FontProvider {

        @Override
        public Font getFont(String arg0, String arg1, boolean arg2, float arg3,
                            int arg4, BaseColor arg5) {
            BaseFont bfChinese = null;
            try {
                bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                        BaseFont.NOT_EMBEDDED);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
            return FontChinese;
        }

        @Override
        public boolean isRegistered(String arg0) {
            return false;
        }
    }


}
