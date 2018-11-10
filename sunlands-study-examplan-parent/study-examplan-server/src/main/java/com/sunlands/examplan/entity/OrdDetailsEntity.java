package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单明细表。子订单表。实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class OrdDetailsEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 子订单的业务单据编号。编码规则：前缀（系统识别码）+日期+6位序列号。系统识别码：分校FXD、门户MHD、续报CPD、企业家ENTD。比如：FXD150706000001。
     */
    private String serialNo;
    /**
     * 主订单ID
     */
    private Integer ordId;
    /**
     * 产品类型：普通NORMAL、远程教育REMOTE_EDU
     */
    private String packageTypeCode;
    /**
     * 产品包ID（普通 或 远程教育）
     */
    private Integer packageId;
    /**
     * 产品包名称。注：远程教育产品名称将 “院校|层次|专业“ 名称拼装显示。
     */
    private String packageName;
    /**
     * 外部系统编号（例如官网订单，对应的是扩展班型Id），仅用于存储，支付成功后回传
     */
    private String outItemId;
    /**
     * 业务日期，应对后期补录子订单的情况
     */
    private Date bizDate;
    /**
     *
     */
    private BigDecimal refundedAmount;
    /**
     * 产品包价格（培训费），注：未减优惠金额前
     */
    private BigDecimal price;
    /**
     * 子订单最低限制价格。用于优惠金额分摊限制。
     */
    private BigDecimal floorPrice;
    /**
     * 保险费
     */
    private BigDecimal insuranceAmount;
    /**
     * 培训费：减掉优惠券以后的培训费
     */
    private BigDecimal trainingAmount;
    /**
     * 子订单实收金额：产品包培训费 - 优惠金额+保险费
     */
    private BigDecimal amount;
    /**
     * 子订单状态：｛未支付UNPAID、已支付PAID、已解约CANCELED、已冻结FREEZED、已取消REVOKED、已作废REPEALED、已转人STUCHANGED、已转班PRODCHANGED、已过服务期EXPIRED｝
     */
    private String statusCode;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private String createUserId;
    /**
     * 最后更新用户
     */
    private String operatorId;
    /**
     *
     */
    private Integer deleteFlag;
    /**
     * 商品编号
     */
    private String itemNo;
    /**
     * 公司主体code
     */
    private Integer companyCode;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：子订单的业务单据编号。编码规则：前缀（系统识别码）+日期+6位序列号。系统识别码：分校FXD、门户MHD、续报CPD、企业家ENTD。比如：FXD150706000001。
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获取：子订单的业务单据编号。编码规则：前缀（系统识别码）+日期+6位序列号。系统识别码：分校FXD、门户MHD、续报CPD、企业家ENTD。比如：FXD150706000001。
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 设置：主订单ID
     */
    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取：主订单ID
     */
    public Integer getOrdId() {
        return ordId;
    }

    /**
     * 设置：产品类型：普通NORMAL、远程教育REMOTE_EDU
     */
    public void setPackageTypeCode(String packageTypeCode) {
        this.packageTypeCode = packageTypeCode;
    }

    /**
     * 获取：产品类型：普通NORMAL、远程教育REMOTE_EDU
     */
    public String getPackageTypeCode() {
        return packageTypeCode;
    }

    /**
     * 设置：产品包ID（普通 或 远程教育）
     */
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    /**
     * 获取：产品包ID（普通 或 远程教育）
     */
    public Integer getPackageId() {
        return packageId;
    }

    /**
     * 设置：产品包名称。注：远程教育产品名称将 “院校|层次|专业“ 名称拼装显示。
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 获取：产品包名称。注：远程教育产品名称将 “院校|层次|专业“ 名称拼装显示。
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 设置：外部系统编号（例如官网订单，对应的是扩展班型Id），仅用于存储，支付成功后回传
     */
    public void setOutItemId(String outItemId) {
        this.outItemId = outItemId;
    }

    /**
     * 获取：外部系统编号（例如官网订单，对应的是扩展班型Id），仅用于存储，支付成功后回传
     */
    public String getOutItemId() {
        return outItemId;
    }

    /**
     * 设置：业务日期，应对后期补录子订单的情况
     */
    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    /**
     * 获取：业务日期，应对后期补录子订单的情况
     */
    public Date getBizDate() {
        return bizDate;
    }

    /**
     * 设置：
     */
    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    /**
     * 获取：
     */
    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    /**
     * 设置：产品包价格（培训费），注：未减优惠金额前
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：产品包价格（培训费），注：未减优惠金额前
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置：子订单最低限制价格。用于优惠金额分摊限制。
     */
    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    /**
     * 获取：子订单最低限制价格。用于优惠金额分摊限制。
     */
    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    /**
     * 设置：保险费
     */
    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    /**
     * 获取：保险费
     */
    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    /**
     * 设置：培训费：减掉优惠券以后的培训费
     */
    public void setTrainingAmount(BigDecimal trainingAmount) {
        this.trainingAmount = trainingAmount;
    }

    /**
     * 获取：培训费：减掉优惠券以后的培训费
     */
    public BigDecimal getTrainingAmount() {
        return trainingAmount;
    }

    /**
     * 设置：子订单实收金额：产品包培训费 - 优惠金额+保险费
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取：子订单实收金额：产品包培训费 - 优惠金额+保险费
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置：子订单状态：｛未支付UNPAID、已支付PAID、已解约CANCELED、已冻结FREEZED、已取消REVOKED、已作废REPEALED、已转人STUCHANGED、已转班PRODCHANGED、已过服务期EXPIRED｝
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 获取：子订单状态：｛未支付UNPAID、已支付PAID、已解约CANCELED、已冻结FREEZED、已取消REVOKED、已作废REPEALED、已转人STUCHANGED、已转班PRODCHANGED、已过服务期EXPIRED｝
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置：
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取：
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置：最后更新用户
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取：最后更新用户
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置：
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取：
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置：商品编号
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * 获取：商品编号
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * 设置：公司主体code
     */
    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取：公司主体code
     */
    public Integer getCompanyCode() {
        return companyCode;
    }
}
