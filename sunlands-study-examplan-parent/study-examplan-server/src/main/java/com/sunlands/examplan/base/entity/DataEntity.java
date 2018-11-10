package com.sunlands.examplan.base.entity;

import com.sunlands.examplan.constant.DeleteFlag;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据实体类
 *
 * @author 周宇
 * @Class Name DataEntity
 * @Create In 2018年08月10日14:20:40
 */
public abstract class DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String createBy;    // 创建者
    protected Date createDate;    // 创建日期
    protected String updateBy;    // 更新者
    protected Date updateDate;    // 更新日期
    /**
     * 删除标示（0：正常，1：删除）
     */
    protected Integer deleteFlag;
    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(String userId) {
        if (StringUtils.isNotBlank(userId)) {
            this.updateBy = userId;
            this.createBy = userId;
            this.deleteFlag = DeleteFlag.NORMAL.getValue();
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(String userId) {
        if (StringUtils.isNotBlank(userId)) {
            this.updateBy = userId;
        }
        this.updateDate = new Date();
    }


}
