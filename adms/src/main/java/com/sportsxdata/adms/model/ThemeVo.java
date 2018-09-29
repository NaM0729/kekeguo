package com.sportsxdata.adms.model;

import lombok.Data;

import java.util.List;

@Data
public class ThemeVo {
    String tid;
    String tname;
    List<PlanActionRelationVo> planActionRelationVos;
}
