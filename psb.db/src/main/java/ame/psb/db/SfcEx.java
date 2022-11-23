package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class SfcEx {

  private String sfcBo;

  private String stateName;

  private String currentRun;

  private String customerItemLotBo;

  private int hotLevel;

  private String dptNo;

  private String lotType;

  private int itemQty;

  private String customerItemLotName;

  private String remark;

  private int currSeq;

  private String sfcType;

  private String createdUser;

  private Date createdTime;

  private String batchId;

  private String handoverType;

  public SfcEx() {
    this("SFC-01", "WAIT");
  }

  public SfcEx(String sfcBo, String stateName) {
    this.sfcBo = sfcBo;
    this.stateName = stateName;
    this.currSeq = 0;
    this.sfcType = "S";
  }

  public SfcEx(SfcEx data) {
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.currentRun = data.currentRun;
    this.customerItemLotBo = data.customerItemLotBo;
    this.hotLevel = data.hotLevel;
    this.dptNo = data.dptNo;
    this.lotType = data.lotType;
    this.itemQty = data.itemQty;
    this.customerItemLotName = data.customerItemLotName;
    this.remark = data.remark;
    this.currSeq = data.currSeq;
    this.sfcType = data.sfcType;
    this.createdUser = data.createdUser;
    this.createdTime = data.createdTime;
    this.batchId = data.batchId;
    this.handoverType = data.handoverType;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCurrentRun() {
    return this.currentRun;
  }

  public void setCurrentRun(String currentRun) {
    this.currentRun = currentRun;
  }

  public String getCustomerItemLotBo() {
    return this.customerItemLotBo;
  }

  public void setCustomerItemLotBo(String customerItemLotBo) {
    this.customerItemLotBo = customerItemLotBo;
  }

  public int getHotLevel() {
    return this.hotLevel;
  }

  public void setHotLevel(int hotLevel) {
    this.hotLevel = hotLevel;
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

  public boolean isRunning() {
    return "RUN_STANDBY".equals(this.stateName)
        || "PROCESSING".equals(this.stateName)
        || "RUN_FINISH".equals(this.stateName)
        || "RUN_HOLD_RELEASE".equals(this.stateName);
  }

  public boolean isHold() {
    return "RUN_HOLD".equals(this.stateName)
        || "HOLD".equals(this.stateName);
  }

  /**
   * @return 是否在委外流程中
   */
  public boolean isOuting() {
    return "RESERVE_OUT".equals(this.stateName)
        || "OUT".equals(this.stateName)
        || "OUT_RETURN".equals(this.stateName);
  }

  /**
   * 取得 Wafer 數量。
   *
   * @return Wafer 數量。
   */
  public int getItemQty() {
    return this.itemQty;
  }

  /**
   * 設定 Wafer 數量。
   *
   * @param itemQty Wafer 數量。
   */
  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }

  public String getCustomerItemLotName() {
    return this.customerItemLotName;
  }

  public void setCustomerItemLotName(String customerItemLotName) {
    this.customerItemLotName = customerItemLotName;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public int getCurrSeq() {
    return this.currSeq;
  }

  public void setCurrSeq(int currSeq) {
    this.currSeq = currSeq;
  }

  public String getSfcType() {
    return this.sfcType;
  }

  public void setSfcType(String sfcType) {
    this.sfcType = sfcType;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getHandoverType() {
    return handoverType;
  }

  public void setHandoverType(String handoverType) {
    this.handoverType = handoverType;
  }

  @Override
  public SfcEx clone() {
    return new SfcEx(this);
  }

  @Override
  public String toString() {
    return String.format("%s, %s, %s, %s, %s",
        this.sfcBo,
        this.stateName,
        this.hotLevel,
        this.dptNo,
        this.lotType);
  }

}
