package com.sunlands.examplan.mapper;


import java.util.List;

import com.sunlands.examplan.base.mapper.BaseMapper;
import com.sunlands.examplan.entity.Proj2ndEntity;

/**
 * 学院与项目关系表Mapper
 * 
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface Proj2ndMapper extends BaseMapper<Proj2ndEntity> {
	
	/**
     * 获取专业列表
     * @param major
     * @return
     */
    List<Proj2ndEntity> getMajorList(Proj2ndEntity proj);
}
