package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewFrameProcess {

  private String sfcBo;

  private String stateName;

  private String currentRun;

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

  private String customer;

  private String statusBo;

  private String customerItemsetName;

  private String remark;

  private String customerItemsetNameOrig;

  private String carrierBo;

  private String carrierName;

  private String carrierStateName;

  private BigDecimal currSeq;

  private String sfcType;

  private Date createdDateTime;

  private String resourceSlotId;

  private String batchId;

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


  public ViewFrameProcess() {
  }

  public ViewFrameProcess(ViewFrameProcess data) {
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.currentRun = data.currentRun;
    this.customerItemsetBo = data.customerItemsetBo;
    this.priority = data.priority;
    this.dptNo = data.dptNo;
    this.lotType = data.lotType;
    this.itemQty = data.itemQty;
    this.shopOrderBo = data.shopOrderBo;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
    this.deviceBo = data.deviceBo;
    this.deviceName = data.deviceName;
    this.packageBo = data.packageBo;
    this.packageName = data.packageName;
    this.routerBo = data.routerBo;
    this.routerName = data.routerName;
    this.customer = data.customer;
    this.statusBo = data.statusBo;
    this.customerItemsetName = data.customerItemsetName;
    this.remark = data.remark;
    this.customerItemsetNameOrig = data.customerItemsetNameOrig;
    this.carrierBo = data.carrierBo;
    this.carrierName = data.carrierName;
    this.carrierStateName = data.carrierStateName;
    this.currSeq = data.currSeq;
    this.sfcType = data.sfcType;
    this.createdDateTime = data.createdDateTime;
    this.resourceSlotId = data.resourceSlotId;
    this.batchId = data.batchId;
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
  public ViewFrameProcess clone() {
    return new ViewFrameProcess(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCurrentRun() {
    return currentRun;
  }

  public void setCurrentRun(String currentRun) {
    this.currentRun = currentRun;
  }

  public String getCustomerItemsetBo() {
    return customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public BigDecimal getPriority() {
    return priority;
  }

  public void setPriority(BigDecimal priority) {
    this.priority = priority;
  }

  public String getDptNo() {
    return dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getLotType() {
    return lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public BigDecimal getItemQty() {
    return itemQty;
  }

  public void setItemQty(BigDecimal itemQty) {
    this.itemQty = itemQty;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPackageBo() {
    return packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getRouterBo() {
    return routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRouterName() {
    return routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCustomerItemsetNameOrig() {
    return customerItemsetNameOrig;
  }

  public void setCustomerItemsetNameOrig(String customerItemsetNameOrig) {
    this.customerItemsetNameOrig = customerItemsetNameOrig;
  }

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getCarrierStateName() {
    return carrierStateName;
  }

  public void setCarrierStateName(String carrierStateName) {
    this.carrierStateName = carrierStateName;
  }

  public BigDecimal getCurrSeq() {
    return currSeq;
  }

  public void setCurrSeq(BigDecimal currSeq) {
    this.currSeq = currSeq;
  }

  public String getSfcType() {
    return sfcType;
  }

  public void setSfcType(String sfcType) {
    this.sfcType = sfcType;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getResourceSlotId() {
    return resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
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
