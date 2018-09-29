package com.sportsxdata.adms.model;

import lombok.Data;

import java.util.List;

@Data
public class SectionVo {
    String sid;
    String sname;
    private List<ThemeVo> themeVos;
}
