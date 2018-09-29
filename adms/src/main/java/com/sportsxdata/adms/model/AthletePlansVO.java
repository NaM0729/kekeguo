package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author goulin
 * @Title: ${file_name}
 * @Description: ${todo}
 * @date 2018/6/29下午4:25
 */

@Data
public class AthletePlansVO {
    String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date t_endtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date t_starttime;
    String belongcoach;
    List<SectionVo> sectionVos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getT_endtime() {
        return t_endtime;
    }

    public void setT_endtime(Date t_endtime) {
        this.t_endtime = t_endtime;
    }

    public Date getT_starttime() {
        return t_starttime;
    }

    public void setT_starttime(Date t_starttime) {
        this.t_starttime = t_starttime;
    }

    public String getBelongcoach() {
        return belongcoach;
    }

    public void setBelongcoach(String belongcoach) {
        this.belongcoach = belongcoach;
    }

    public List<SectionVo> getSectionVos() {
        return sectionVos;
    }

    public void setSectionVos(List<SectionVo> sectionVos) {
        this.sectionVos = sectionVos;
    }
}

