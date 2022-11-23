package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ViewHoldSfc extends HoldSfc {

  private String holdLogBo;

  private String sfcBo;

  private String originalStatusBo;

  private String holdStatusBo;

  private Date releasedDateTime;

  private String releasedByBo;

  private String releaseComments;

  private String reasonCodeBo;

  private String holdType;

  private String comments;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String userBo;

  private String txnId;

  private String sfcName;

  private String stateName;

  private String customerItemsetBo;

  private BigDecimal priority;

  private String dptNo;

  private String lotType;

  private BigDecimal itemQty;

  private String shopOrderBo;

  private String itemBo;

  private String itemName;

  private String deviceBo;

  private String deviceName;

  private String packageBo;

  private String packageName;

  private String routerBo;

  private String routerName;

  private BigDecimal sfcQty;

  private String customer;

  private String statusBo;

  private String customerItemLotName;

  private String shopOrderName;

  private String reason;

  private String reasonCodeDescription;

  public String getHoldLogBo() {
    return this.holdLogBo;
  }

  public void setHoldLogBo(String holdLogBo) {
    this.holdLogBo = holdLogBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOriginalStatusBo() {
    return this.originalStatusBo;
  }

  public void setOriginalStatusBo(String originalStatusBo) {
    this.originalStatusBo = originalStatusBo;
  }

  public String getHoldStatusBo() {
    return this.holdStatusBo;
  }

  public void setHoldStatusBo(String holdStatusBo) {
    this.holdStatusBo = holdStatusBo;
  }

  public Date getReleasedDateTime() {
    return this.releasedDateTime;
  }

  public void setReleasedDateTime(Date releasedDateTime) {
    this.releasedDateTime = releasedDateTime;
  }

  public String getReleasedByBo() {
    return this.releasedByBo;
  }

  public void setReleasedByBo(String releasedByBo) {
    this.releasedByBo = releasedByBo;
  }

  public String getReleaseComments() {
    return this.releaseComments;
  }

  public void setReleaseComments(String releaseComments) {
    this.releaseComments = releaseComments;
  }

  public String getReasonCodeBo() {
    return this.reasonCodeBo;
  }

  public void setReasonCodeBo(String reasonCodeBo) {
    this.reasonCodeBo = reasonCodeBo;
  }

  public String getHoldType() {
    return this.holdType;
  }

  public void setHoldType(String holdType) {
    this.holdType = holdType;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getUserBo() {
    return this.userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public String getTxnId() {
    return this.txnId;
  }

  public void setTxnId(String txnId) {
    this.txnId = txnId;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCustomerItemsetBo() {
    return this.customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public BigDecimal getPriority() {
    return this.priority;
  }

  public void setPriority(BigDecimal priority) {
    this.priority = priority;
  }

  public String getDptNo() {
    return this.dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public BigDecimal getItemQty() {
    return this.itemQty;
  }

  public void setItemQty(BigDecimal itemQty) {
    this.itemQty = itemQty;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDeviceBo() {
    return this.deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPackageBo() {
    return this.packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return this.packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRouterName() {
    return this.routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public BigDecimal getSfcQty() {
    return this.sfcQty;
  }

  public void setSfcQty(BigDecimal sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getCustomer() {
    return this.customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getCustomerItemLotName() {
    return this.customerItemLotName;
  }

  public void setCustomerItemLotName(String customerItemLotName) {
    this.customerItemLotName = customerItemLotName;
  }

  public String getShopOrderName() {
    return this.shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getReasonCodeDescription() {
    return reasonCodeDescription;
  }

  public void setReasonCodeDescription(String reasonCodeDescription) {
    this.reasonCodeDescription = reasonCodeDescription;
  }

}
