package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Action;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);

    Action selectByActionNameAndCoachId(@Param("actionName")String actionName, @Param("coachId")String coachId);

    List<Action> selectActionByThemeId(@Param("themeId")String themeId,@Param("coachId")String coachId);

    List<Action> selectDIYActionByThemeId(String themeId, String coachId);
}