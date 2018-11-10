package com.sunlands.examplan.mapper;


import com.sunlands.examplan.base.mapper.BaseMapper;
import com.sunlands.examplan.entity.RoundRuleEntity;

/**
 * 轮次规则表，OPEN开关：1开/0关；EXAM_PROVINCE考试计划省份：sch_local_province.id，多个用逗号分隔；ORDER_PERIOD报名时间段：yyyy-MM-dd，多个用逗号分隔；ALLOT同科目精讲轮次未结束时允许分配：1允许/0不允许;EXAM_PLAN限定分配的考期，如1703Mapper
 * 
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface RoundRuleMapper extends BaseMapper<RoundRuleEntity> {
	
}
