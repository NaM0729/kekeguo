package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Theme;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThemeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Theme record);

    int insertSelective(Theme record);

    Theme selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Theme record);

    int updateByPrimaryKey(Theme record);

    void insertThemeAndActionRelation(@Param("themeId")String id, @Param("actionId")String id1);

    Theme selectByThenmeNameAndCoachId(@Param("thenmeName")String thenmeName, @Param("coachId")String coachId);

    List<Theme> selectBySectionId(@Param("sectionId")String sectionId,@Param("coachId")String coachId);

    List<Theme> selectDIYThemeBySectionId(@Param("sectionId")String sectionId, @Param("coachId")String coachId);
}