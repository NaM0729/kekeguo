package com.sunlands.examplan.mapper;


import com.sunlands.examplan.base.mapper.BaseMapper;
import com.sunlands.examplan.entity.CourseEntity;

/**
 * 科目表，不复用现在的ent_subject，因为含义不一致，现在科目隶属于二级项目Mapper
 * 
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface CourseMapper extends BaseMapper<CourseEntity> {
	
}
