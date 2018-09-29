package com.sportsxdata.adms.service.impl;

import com.sportsxdata.adms.dao.*;
import com.sportsxdata.adms.model.*;
import com.sportsxdata.adms.service.TrainingService;
import com.sportsxdata.adms.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import com.sportsxdata.adms.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;
    @Autowired
    private MainTraningPlanMapper mainTraningPlanMapper;
    @Autowired
    private PlanActionRelationMapper planActionRelationMapper;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private ThemeMapper themeMapper;
    @Autowired
    private AthleteMapper athleteMapper;

    /**
     * 查看该教练下训练计划列表 zyn 2018-06-28
     * @param entry
     * @return
     */
    @Override
    public PageSizeDataGrid getTraningPlanListsBycocah(TraningPlanListsBycocahEntry entry) {

//        String currentTime = entry.getCurrentTime();
//        if(currentTime != null && !("").equals(currentTime)){
//            String[] split = currentTime.split(" ");
//            entry.setTime(split[1]);
//        }
        PageSizeDataGrid psdg = new PageSizeDataGrid();
        Integer pageNum = entry.getPageNum();
        Integer pageRowNum = entry.getPageRowNum();
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if (pageRowNum == null || pageRowNum == 0) {
            pageRowNum = 10;
            //保存每页条数
            entry.setPageRowNum(pageRowNum);
        }
        Integer startSize = (pageNum - 1) * pageRowNum;
        //保存当前页码
        entry.setStartSize(startSize);
        //查看该教练下训练计划数据条数
        Integer recordNum = trainingPlanMapper.getTraningPlanCountBycocah(entry);
        List<TraningPlanListsBycocahResult> list = new ArrayList<>();
        if(recordNum > 0){
            int totalPage = recordNum%pageRowNum==0?recordNum/pageRowNum:recordNum/pageRowNum+1;
            psdg.setTotal(recordNum);
            psdg.setTotalPage(totalPage);
            list = trainingPlanMapper.getTraningPlanListsBycocah(entry);
            psdg.setRows(list);
            psdg.setStatus(200);
            psdg.setMessage("查询成功!");
        }else{
            psdg.setStatus(200);
            psdg.setRows(list);
            psdg.setMessage("无数据!");
        }
        return psdg;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult insertTrainPlan(InsertTrainPlanPojo insertTrainPlanPojo) {
        String startDate = insertTrainPlanPojo.getStartDate();
        String endDate = insertTrainPlanPojo.getEndDate();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date starDate = simpleDateFormat.parse(startDate);
            Date enDate = simpleDateFormat.parse(endDate);
            Date now = new Date();
            String mainId = UUID.randomUUID().toString();
            //需要存入库中的主训练计划
            MainTraningPlan mainTraningPlan = new MainTraningPlan();
            mainTraningPlan.setAdmsCoachId(insertTrainPlanPojo.getCoachId());
            mainTraningPlan.setAthleteNum(insertTrainPlanPojo.getAthleteIdList().size() + "");
            mainTraningPlan.setCreateTime(now);
            mainTraningPlan.setEndDate(insertTrainPlanPojo.getEndDate());
            mainTraningPlan.setEndTime(insertTrainPlanPojo.getEndTime());
            mainTraningPlan.setStartDate(insertTrainPlanPojo.getStartDate());
            mainTraningPlan.setStartTime(insertTrainPlanPojo.getStartTime());
            mainTraningPlan.setId(mainId);
            mainTraningPlan.setTeamName(insertTrainPlanPojo.getTraningTeamName());
            mainTraningPlan.setTheme1ProjectNum(insertTrainPlanPojo.getReadyAction() == null ? "0" : insertTrainPlanPojo.getReadyAction().size() + "");
            mainTraningPlan.setTheme2ProjectNum(insertTrainPlanPojo.getAdminAction() == null ? "0" : insertTrainPlanPojo.getAdminAction().size() + "");
            mainTraningPlan.setTheme3ProjectNum(insertTrainPlanPojo.getRelaxAction() == null ? "0" : insertTrainPlanPojo.getRelaxAction().size() + "");

            //===========================================================================================================================================
            int days = DateTimeUtil.daysBetween(starDate ,enDate);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = new GregorianCalendar();
            Date todayDate;
            String todayStartTime;
            String todayEndTime;
            //存入库中的子级训练计划
            List<TrainingPlan> ereryDaysTrainingPlan = new ArrayList<>();
            for (int i = 0; i <= days; i++){
                calendar.setTime(starDate);
                calendar.add(Calendar.DATE,i);
                todayDate = calendar.getTime();
                todayStartTime = simpleDateFormat.format(todayDate) + " " + insertTrainPlanPojo.getStartTime();
                todayEndTime = simpleDateFormat.format(todayDate) + " " + insertTrainPlanPojo.getEndTime();
                TrainingPlan trainingPlan = new TrainingPlan();
                trainingPlan.setCoachId(insertTrainPlanPojo.getCoachId());
                trainingPlan.setCreateTime(now);
                trainingPlan.setId(UUID.randomUUID().toString());
                trainingPlan.setMainPlanId(mainId);
                trainingPlan.setTraningEndTime(dateFormat.parse(todayEndTime));
                trainingPlan.setTraningStartTime(dateFormat.parse(todayStartTime));
                trainingPlan.setTraningRemark(insertTrainPlanPojo.getTraningRemark());
                trainingPlan.setTraningSite(insertTrainPlanPojo.getTraningSite());
                trainingPlan.setTraningTeamName(insertTrainPlanPojo.getTraningTeamName());
                trainingPlan.setTraningTarget(insertTrainPlanPojo.getTraningTarget());
                trainingPlan.setTraningStage(insertTrainPlanPojo.getTraningStage());
                trainingPlan.setBelongCoach(insertTrainPlanPojo.getCoachName());
                if (dateFormat.parse(todayStartTime).getTime() <= now.getTime() || dateFormat.parse(todayEndTime).getTime() <= now.getTime()){
                    return DataResult.fail("训练的开始时间或结束时间不可小于当前时间!");
                }
                if (trainingPlanMapper.selectPlanByStartTimeAndEndTimeAndAthleteList(trainingPlan.getTraningStartTime(),trainingPlan.getTraningEndTime(),insertTrainPlanPojo.getAthleteIdList()) != 0){
                    return DataResult.fail("有部分队员的训练计划冲突,请确认后重试!");
                }
                ereryDaysTrainingPlan.add(trainingPlan);
            }
            //===========================================================================================================================================================================================
            List<PlanActionRelation> AllAction = insertTrainPlanPojo.getReadyAction();
            AllAction.addAll(insertTrainPlanPojo.getAdminAction());
            AllAction.addAll(insertTrainPlanPojo.getRelaxAction());
            List<PlanActionRelation> toSavePlanActionRelation;
            Action newAction;
            Theme newTheme;
            int num = 1;
            calendar.setTime(now);
            for (TrainingPlan t : ereryDaysTrainingPlan) {
                toSavePlanActionRelation = new ArrayList<>();
                int order = 1;
                for (PlanActionRelation par : AllAction){
                    for (String id : insertTrainPlanPojo.getAthleteIdList()) {
                        newAction = null;
                        newTheme = null;
                        //判断是否是自定义主题
                        if (par.getThemeId() == null || "".equals(par.getThemeId())){
                            if (par.getThenmeName() == null || "".equals(par.getThenmeName())){
                                return DataResult.fail("自定义主题名字为空,添加失败");
                            }
                            Theme theme = themeMapper.selectByThenmeNameAndCoachId(par.getThenmeName(),insertTrainPlanPojo.getCoachId());
                            if (theme == null){
                                newTheme = new Theme();
                                //判断该主题属于哪个阶段
                                if (insertTrainPlanPojo.getRelaxAction().contains(par)){
                                    newTheme.setAdmsSectionId("3");
                                }else if (insertTrainPlanPojo.getAdminAction().contains(par)){
                                    newTheme.setAdmsSectionId("2");
                                }else{
                                    newTheme.setAdmsSectionId("1");
                                }
                                newTheme.setCoachId(insertTrainPlanPojo.getCoachId());
                                newTheme.setCreateTime(now);
                                newTheme.setId(UUID.randomUUID().toString());
                                newTheme.setName(par.getThenmeName());
                                newTheme.setType("2");
                            }

                        }
                        //判断是否是自定义动作
                        if (par.getAdmsActionId() == null || "".equals(par.getAdmsActionId())){
                            if (par.getActionName() == null || "".equals(par.getActionName())){
                                return DataResult.fail("自定义动作名字为空,添加失败");
                            }
                            Action action = actionMapper.selectByActionNameAndCoachId(par.getActionName(),insertTrainPlanPojo.getCoachId());
                            if (action == null){
                                newAction = new Action();
                                newAction.setCoachId(insertTrainPlanPojo.getCoachId());
                                newAction.setCreateTime(now);
                                newAction.setId(UUID.randomUUID().toString());
                                newAction.setName(par.getActionName());
                                newAction.setType("2");
                            }

                        }
                        //判断是否同时是自定义主题和自定义动作
                        if (newAction != null){
                            actionMapper.insert(newAction);
                            par.setAdmsActionId(newAction.getId());
                            if (newTheme != null){
                                themeMapper.insert(newTheme);
                                themeMapper.insertThemeAndActionRelation(newTheme.getId(),newAction.getId());
                                par.setThemeId(newTheme.getId());
                            }else{
                                themeMapper.insertThemeAndActionRelation(par.getThemeId(),newAction.getId());
                            }
                        }
                        par.setAdmsTrainingPlaneId(t.getId());
                        par.setAthleteId(id);
                        par.setId(UUID.randomUUID().toString());
                        par.setOrder(order + "");
                        try{
                            if (par.getGroupNum() != null || !"".equals(par.getGroupNum())){
                                num = Integer.parseInt(par.getGroupNum());
                            }
                            for (int i = 1; i <= num; i++){
                                calendar.add(Calendar.SECOND,1);
                                PlanActionRelation clone = par.clone();
                                clone.setGroupNum(i + "");
                                clone.setId(UUID.randomUUID().toString());
                                clone.setCreateTime(calendar.getTime());
                                toSavePlanActionRelation.add(clone);
                            }
                            /*PlanActionRelation clone = par.clone();
                            clone.setId(UUID.randomUUID().toString());
                            toSavePlanActionRelation.add(clone);*/
                        }catch (NumberFormatException e){
                            return DataResult.fail("动作组数数据填写错误!");
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }

                    }
                    order++;
                }
                planActionRelationMapper.batchInsert(toSavePlanActionRelation);
            }
            trainingPlanMapper.batchInsert(ereryDaysTrainingPlan);
            mainTraningPlanMapper.insert(mainTraningPlan);
        }catch (ParseException e){
            return DataResult.fail("时间日期不正确!");
        }catch (NullPointerException n){
            return DataResult.fail("主要数据为空,添加失败");
        }

        return DataResult.success("添加训练计划成功!");
    }

    /**
     * 删除训练列表
     * @param entry
     * @return
     */
    @Override
    @Transactional
    public PageSizeDataGrid deleteTraningPlanById(TraningPlanListsBycocahEntry entry) {
        List<String> list = entry.getId();
        for(int i=0; i<list.size();i++){
            String id = list.get(i);
            //查询该训练同级个数，如果为1条，则同时删除MainTraningPlan主表数据。
            Map<String,String> map = trainingPlanMapper.selectCountByMainId(id);
            if(map != null && map.size() == 1){
                mainTraningPlanMapper.deleteByPrimaryKey(map.get("mainId"));
            }
            //删除训练计划
            trainingPlanMapper.deleteByPrimaryKey(id);
            //删除远动员结果表
            planActionRelationMapper.deleteByTrainingPlaneId(id);
        }

        //删除之后重新查找训练计划列表
        return this.getTraningPlanListsBycocah(entry);
    }

    @Override
    public DataResult getPlanByAthleteIdAndDatetime(String athleteId, String datetime) {
        log.info("查询运动员:{} ,在:{}时有多少计划",athleteId,datetime);
        List<TrainingPlan> planByAthleteIdAndDatetime = trainingPlanMapper.getPlanByAthleteIdAndDatetime(athleteId, datetime);
        return DataResult.success(planByAthleteIdAndDatetime);
    }

    @Override
    public DataResult getTrainingPlanById(String planId) {
        log.info("根据id:{},查询训练计划数据",planId);
        TrainingPlan trainingPlan = trainingPlanMapper.selectByPrimaryKey(planId);
        List<PlanActionRelation> planActionRelationByPlanId = planActionRelationMapper.getPlanActionRelationByPlanId(trainingPlan.getId());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("plan", trainingPlan);
        resultMap.put("planActRel", planActionRelationByPlanId);
        return DataResult.success(resultMap);
    }

    /**
     * 通过阶段id查询主题集
     * @param sectionId
     * @return
     */
    @Override
    public DataResult selectThemeBySectionId(String sectionId,String coachId) {
        if (sectionId == null || "".equals(sectionId) || coachId == null || "".equals(coachId)){
            return DataResult.fail("阶段id为空");
        }
        if ("1".equals(sectionId) || "2".equals(sectionId) || "3".equals(sectionId)){
            List<Theme> list = themeMapper.selectBySectionId(sectionId,coachId);
            return DataResult.success(list);
        }else{
            return DataResult.fail("阶段id错误");
        }
    }

    /**
     * 通过主题id查询动作集
     * @param themeId
     * @return
     */
    @Override
    public DataResult selectActionByThemeId(String themeId,String coachId) {
        if (themeId == null || "".equals(themeId) || coachId == null || "".equals(coachId)){
            return DataResult.fail("主题id为空");
        }
        if ("zidingyizhuti".equals(themeId)){
            List<Action> actions = actionMapper.selectDIYActionByThemeId(themeId, coachId);
            return DataResult.success(actions);
        }
        List<Action> list = actionMapper.selectActionByThemeId(themeId,coachId);
        return DataResult.success(list);
    }

    /**
     * 数字录入中 展示运动员列表（通过训练时间段来分类） zyn 2018-06-30
     * @return
     */
    @Override
    public DataResult getAthletesByTrainingTimeAndCoachId(String coachId) {
        List<AthletesByTrainingTimeResult> list = trainingPlanMapper.getAthletesByTrainingTimeAndCoachId(coachId);
        return DataResult.success(list);
    }

    /**
     * 数字录入中 展示运动员列表（包含训练进行状态） zyn 2018-06-30
     * @return
     */
    @Override
    public DataResult getAthletesTrainingByCoachId(String coachId) {
        List<AthletesTrainingResultV> list = trainingPlanMapper.getAthletesTrainingByCoachId(coachId);
        for(int i=list.size()-1; i >=0 ; i--){
            AthletesTrainingResultV athletesTrainingResultV = list.get(i);
            if(athletesTrainingResultV.getList().size() == 0){
                list.remove(i);
            }
        }
        return DataResult.success(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult afterUpdateToSaveTrainPlan(InsertEveryDayTrainPlanPojo insertEveryDayTrainPlanPojo) {
        planActionRelationMapper.deleteByTrainPlanId(insertEveryDayTrainPlanPojo.getId());
        Calendar calendar = new GregorianCalendar();
        Date now = new Date();
        List<PlanActionRelation> AllAction = insertEveryDayTrainPlanPojo.getReadyAction();
        AllAction.addAll(insertEveryDayTrainPlanPojo.getAdminAction());
        AllAction.addAll(insertEveryDayTrainPlanPojo.getRelaxAction());
        List<PlanActionRelation> toSavePlanActionRelation;
        Action newAction;
        Theme newTheme;
        int num = 1;
        calendar.setTime(now);
        toSavePlanActionRelation = new ArrayList<>();
        int order = 1;
        for (PlanActionRelation par : AllAction){
            for (String id : insertEveryDayTrainPlanPojo.getAthleteIdList()) {
                newAction = null;
                newTheme = null;
                //判断是否是自定义主题
                if (par.getThemeId() == null || "".equals(par.getThemeId())){
                    if (par.getThenmeName() == null || "".equals(par.getThenmeName())){
                        return DataResult.fail("自定义主题名字为空,添加失败");
                    }
                    Theme theme = themeMapper.selectByThenmeNameAndCoachId(par.getThenmeName(),insertEveryDayTrainPlanPojo.getCoachId());
                    if (theme == null){
                        newTheme = new Theme();
                        //判断该主题属于哪个阶段
                        if (insertEveryDayTrainPlanPojo.getRelaxAction().contains(par)){
                            newTheme.setAdmsSectionId("3");
                        }else if (insertEveryDayTrainPlanPojo.getAdminAction().contains(par)){
                            newTheme.setAdmsSectionId("2");
                        }else{
                            newTheme.setAdmsSectionId("1");
                        }
                        newTheme.setCoachId(insertEveryDayTrainPlanPojo.getCoachId());
                        newTheme.setCreateTime(now);
                        newTheme.setId(UUID.randomUUID().toString());
                        newTheme.setName(par.getThenmeName());
                        newTheme.setType("2");
                    }

                }
                //判断是否是自定义动作
                if (par.getAdmsActionId() == null || "".equals(par.getAdmsActionId())){
                    if (par.getActionName() == null || "".equals(par.getActionName())){
                        return DataResult.fail("自定义动作名字为空,添加失败");
                    }
                    Action action = actionMapper.selectByActionNameAndCoachId(par.getActionName(),insertEveryDayTrainPlanPojo.getCoachId());
                    if (action == null){
                        newAction = new Action();
                        newAction.setCoachId(insertEveryDayTrainPlanPojo.getCoachId());
                        newAction.setCreateTime(now);
                        newAction.setId(UUID.randomUUID().toString());
                        newAction.setName(par.getActionName());
                        newAction.setType("2");
                    }

                }
                //判断是否同时是自定义主题和自定义动作
                if (newAction != null){
                    actionMapper.insert(newAction);
                    par.setAdmsActionId(newAction.getId());
                    if (newTheme != null){
                        themeMapper.insert(newTheme);
                        themeMapper.insertThemeAndActionRelation(newTheme.getId(),newAction.getId());
                        par.setThemeId(newTheme.getId());
                    }else{
                        themeMapper.insertThemeAndActionRelation(par.getThemeId(),newAction.getId());
                    }
                }
                par.setAdmsTrainingPlaneId(insertEveryDayTrainPlanPojo.getId());
                par.setAthleteId(id);
                par.setId(UUID.randomUUID().toString());
                par.setOrder(order + "");
                try{
                    if (par.getGroupNum() != null || !"".equals(par.getGroupNum())){
                        num = Integer.parseInt(par.getGroupNum());
                    }
                    for (int i = 1; i <= num; i++){
                        calendar.add(Calendar.SECOND,1);
                        PlanActionRelation clone = par.clone();
                        clone.setGroupNum(i + "");
                        clone.setId(UUID.randomUUID().toString());
                        clone.setCreateTime(calendar.getTime());
                        toSavePlanActionRelation.add(clone);
                    }
                }catch (NumberFormatException e){
                    return DataResult.fail("动作组数数据填写错误!");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            }
            order++;
        }
        planActionRelationMapper.batchInsert(toSavePlanActionRelation);
        return DataResult.success("保存成功");
    }

    @Override
    public DataResult getPlanInfoByAthleteIdAndTime(String athleteId, String date) {
        List<TrainingPlan> planByAthleteIdAndDatetime = trainingPlanMapper.getPlanByAthleteIdAndDatetime(athleteId, date);

        List<String> planIds = new ArrayList<>();
        planByAthleteIdAndDatetime.forEach(p -> {
            planIds.add(p.getId());
        });
        DataResult success ;

        if(planIds.size()<=0){
            success = DataResult.fail("没有找到计划");
            return success;
        }
        List<AthletePlansVO> planInfo = new ArrayList<>();
        /*planIds.clear();
        planIds.add("5c2077ee-fa41-41f7-ba0e-68d5a36cda23");*/
        for (String s: planIds) {
            AthletePlansVO athletePlansVO = planActionRelationMapper.getOnePlanInfo(s, athleteId);
            planInfo.add(athletePlansVO);
        }
        //List<AthletePlansVO> planInfo = planActionRelationMapper.getPlanInfo(planIds, athleteId);

        if(planInfo == null || planInfo.size() ==0){
            success = DataResult.fail("没有找到计划");
        }else{
            Collections.sort(planInfo, new Comparator<AthletePlansVO>() {
                @Override
                public int compare(AthletePlansVO arg0, AthletePlansVO arg1) {
                    long hits0 = arg0.getT_starttime().getTime();
                    long hits1 = arg1.getT_starttime().getTime();
                    if (hits1 > hits0) {
                        return -1;
                    } else if (hits1 == hits0) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            success = DataResult.success(planInfo);
        }
        return success;
    }

    @Override
    public DataResult editPlanInfoByCoachIdAndPlanId(String coachId, String planId) {
        List<ActionRelEditPlanVo> actionRelEditPlanVos = planActionRelationMapper.editPlanSearch(planId, coachId);
        DataResult success = DataResult.success(actionRelEditPlanVos);
        return success;
    }

    @Override
    public DataResult seachPlanInfoById(String planId) {
        log.info("查询计划:{}",planId);
        DataResult success ;
        TrainingPlanInfo trainingPlanInfo = planActionRelationMapper.selectInfoByPlanId(planId);

        if(trainingPlanInfo==null){
            success = DataResult.fail("未找到数据");
            return success;
        }

        List<Athlete> athletes = athleteMapper.selectAthletesByPlanId(planId);
        if (athletes.size()<=0){
            success = DataResult.fail("未找到数据");
            return success;
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

        //判断是否编辑, 只有未开始的才能编辑 即:开始时间大于当前时间
        long l = System.currentTimeMillis();
        long time = trainingPlanInfo.getStartTime().getTime();
        if(l > time){
            trainingPlanInfo.setEditStatus(true);
        }
        success = DataResult.success(trainingPlanInfo);
        return success;
    }

    @Override
    public DataResult selectAllAthleteByCoachId(String coachId) {
        if (coachId == null || "".equals(coachId)){
            return DataResult.fail("教练员id为空,无法查询!");
        }
        List<Athlete> list = athleteMapper.selectAllAthleteByCoachId(coachId);
        return DataResult.success(list);
    }

    @Override
    public List<AthletePlansVO> excel(String athleteId, String datetime) {
        List<TrainingPlan> planByAthleteIdAndDatetime = trainingPlanMapper.getPlanByAthleteIdAndDatetime(athleteId, datetime);

        List<String> planIds = new ArrayList<>();
        planByAthleteIdAndDatetime.forEach(p -> {
            planIds.add(p.getId());
        });

        if(planIds.size()<=0){
            return null;
        }
        List<AthletePlansVO> planInfo = new ArrayList<>();
        /*planIds.clear();
        planIds.add("5c2077ee-fa41-41f7-ba0e-68d5a36cda23");*/
        for (String s: planIds) {
            AthletePlansVO athletePlansVO = planActionRelationMapper.getOnePlanInfo(s, athleteId);
            planInfo.add(athletePlansVO);
        }
        //List<AthletePlansVO> planInfo = planActionRelationMapper.getPlanInfo(planIds, athleteId);

        if(planInfo == null || planInfo.size() ==0){
            return null;
        }else{
            Collections.sort(planInfo, new Comparator<AthletePlansVO>() {
                @Override
                public int compare(AthletePlansVO arg0, AthletePlansVO arg1) {
                    long hits0 = arg0.getT_starttime().getTime();
                    long hits1 = arg1.getT_starttime().getTime();
                    if (hits1 > hits0) {
                        return -1;
                    } else if (hits1 == hits0) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }
        //List<AthletePlansVO> planInfo = planActionRelationMapper.getPlanInfo(planIds, athleteId);
        return planInfo;
    }


}

