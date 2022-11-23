package ame.psb.db;

import java.util.Date;

public class FrameProcess {

  private String id;

  private String shopOrder;

  private String sfc;

  private String operation;

  private String device;

  private String sfcQty;

  private String resrce;

  private String frameItemBo;

  private String frameItem;

  private String frameItemRevision;

  private String frameModel;

  private String frameSpec;

  private String compensationValue;

  private String singleQty;

  private String originStripQty;

  private String neededStripQty;

  private String reprintStripQty;

  private Date processStartDate;

  private Date processCompleteDate;

  private String processStatus;

  private String createUser;

  private Date createTime;

  private String updatedUser;

  private Date updatedTime;


  public FrameProcess() {
  }

  public FrameProcess(FrameProcess data) {
    this.id = data.id;
    this.shopOrder = data.shopOrder;
    this.sfc = data.sfc;
    this.operation = data.operation;
    this.device = data.device;
    this.sfcQty = data.sfcQty;
    this.resrce = data.resrce;
    this.frameItemBo = data.frameItemBo;
    this.frameItem = data.frameItem;
    this.frameItemRevision = data.frameItemRevision;
    this.frameModel = data.frameModel;
    this.frameSpec = data.frameSpec;
    this.compensationValue = data.compensationValue;
    this.singleQty = data.singleQty;
    this.originStripQty = data.originStripQty;
    this.neededStripQty = data.neededStripQty;
    this.reprintStripQty = data.reprintStripQty;
    this.processStartDate = data.processStartDate;
    this.processCompleteDate = data.processCompleteDate;
    this.processStatus = data.processStatus;
    this.createUser = data.createUser;
    this.createTime = data.createTime;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public FrameProcess clone() {
    return new FrameProcess(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getSfcQty() {
    return sfcQty;
  }

  public void setSfcQty(String sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getFrameItemBo() {
    return frameItemBo;
  }

  public void setFrameItemBo(String frameItemBo) {
    this.frameItemBo = frameItemBo;
  }

  public String getFrameItem() {
    return frameItem;
  }

  public void setFrameItem(String frameItem) {
    this.frameItem = frameItem;
  }

  public String getFrameItemRevision() {
    return frameItemRevision;
  }

  public void setFrameItemRevision(String frameItemRevision) {
    this.frameItemRevision = frameItemRevision;
  }

  public String getFrameModel() {
    return frameModel;
  }

  public void setFrameModel(String frameModel) {
    this.frameModel = frameModel;
  }

  public String getFrameSpec() {
    return frameSpec;
  }

  public void setFrameSpec(String frameSpec) {
    this.frameSpec = frameSpec;
  }

  public String getCompensationValue() {
    return compensationValue;
  }

  public void setCompensationValue(String compensationValue) {
    this.compensationValue = compensationValue;
  }

  public String getSingleQty() {
    return singleQty;
  }

  public void setSingleQty(String singleQty) {
    this.singleQty = singleQty;
  }

  public String getOriginStripQty() {
    return originStripQty;
  }

  public void setOriginStripQty(String originStripQty) {
    this.originStripQty = originStripQty;
  }

  public String getNeededStripQty() {
    return neededStripQty;
  }

  public void setNeededStripQty(String neededStripQty) {
    this.neededStripQty = neededStripQty;
  }

  public String getReprintStripQty() {
    return reprintStripQty;
  }

  public void setReprintStripQty(String reprintStripQty) {
    this.reprintStripQty = reprintStripQty;
  }

  public Date getProcessStartDate() {
    return processStartDate;
  }

  public void setProcessStartDate(Date processStartDate) {
    this.processStartDate = processStartDate;
  }

  public Date getProcessCompleteDate() {
    return processCompleteDate;
  }

  public void setProcessCompleteDate(Date processCompleteDate) {
    this.processCompleteDate = processCompleteDate;
  }

  public String getProcessStatus() {
    return processStatus;
  }

  public void setProcessStatus(String processStatus) {
    this.processStatus = processStatus;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
