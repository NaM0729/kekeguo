package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author goulin
 * @Title: ${file_name}
 * @Description: 用于编辑计划时使用
 * @date 2018/7/2上午10:54
 */
@Data
public class ActionRelEditPlanVo {
    String main_plan_id;
    String plan_id;
    String belongcoach;
    List<SectionEditPlanVo> sectionVos;
}

@Data
class SectionEditPlanVo extends  SectionVo{
    List<ThemeEditPlanVo> themeEditPlanVos;
}
@Data
class ThemeEditPlanVo extends ThemeVo{
}


