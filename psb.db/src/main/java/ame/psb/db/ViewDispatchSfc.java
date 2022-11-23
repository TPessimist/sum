package ame.psb.db;

import ame.psb.commons.Env;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import uia.utils.dao.DatePeriod;

@Entity
public class ViewDispatchSfc extends DispatchSfc {

  private String shopOrderBo;

  private String shopOrder;

  private String sfc;

  private String sfcRouterBo;

  private int sfcRouterSeq;

  private int sfcStepSeq;

  private String routerBo;

  private String operationBo;

  private String done;

  private String bypassed;

  private int qtyInQueue;

  private int qtyInWork;

  private int qtyCompleted;

  private int qtyCompletePending;

  private int qtyRejected;

  private String previouslyStarted;

  private String previousStepId;

  private String previousResourceBo;

  private Date dateQueued;

  private String itemBo;

  private Date scheduledCompDate;

  private Date planCompDate;

  private Date plannedStartDate;

  private Date scheduledStartDate;

  private String resourceBo;

  private String workCenterBo;

  private String queueTimeBo;

  private String holdComment;

  private String itemGroupBo;

  private String sfcStateName;

  private String currentRun;

  private String customerItemLotBo;

  private int priority;

  private int itemQty;

  private String itemName;

  private String deviceBo;

  private String deviceName;

  private String packageBo;

  private String packageName;

  private String routerName;

  private int sfcQty;

  private String customer;

  private String statusBo;

  private String customerItemLotName;

  private String remark;

  private String customerItemLotNameOrig;

  private String carrierBo;

  private String carrierName;

  private String carrierStateName;

  private int currSeq;

  private String sfcType;

  private Date createdDateTime;

  private String resourceSlotId;

  private String batchId;

  private Date bumpingSod;

  private Date wlpSod;

  private Date cpSod;

  private Date fcSod;

  private String custOperation;

  public static boolean compareDate(Date date1, Date date2) {
    if (date1 == null) {
      return date2 == null;
    } else {
      return date2 != null && (Math.abs(date1.getTime() - date2.getTime()) < 5000);
    }
  }

  public String getCustOperation() {
    return custOperation;
  }

  public void setCustOperation(String custOperation) {
    this.custOperation = custOperation;
  }

  public String getBatchId() {
    return this.batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrder() {
    return this.shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getSfc() {
    return this.sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getSfcRouterBo() {
    return this.sfcRouterBo;
  }

  public void setSfcRouterBo(String sfcRouterBo) {
    this.sfcRouterBo = sfcRouterBo;
  }

  public int getSfcRouterSeq() {
    return this.sfcRouterSeq;
  }

  public void setSfcRouterSeq(int sfcRouterSeq) {
    this.sfcRouterSeq = sfcRouterSeq;
  }

  public int getSfcStepSeq() {
    return this.sfcStepSeq;
  }

  public void setSfcStepSeq(int sfcStepSeq) {
    this.sfcStepSeq = sfcStepSeq;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDone() {
    return this.done;
  }

  public void setDone(String done) {
    this.done = done;
  }

  public String getBypassed() {
    return this.bypassed;
  }

  public void setBypassed(String bypassed) {
    this.bypassed = bypassed;
  }

  public int getQtyInQueue() {
    return this.qtyInQueue;
  }

  public void setQtyInQueue(int qtyInQueue) {
    this.qtyInQueue = qtyInQueue;
  }

  public int getQtyInWork() {
    return this.qtyInWork;
  }

  public void setQtyInWork(int qtyInWork) {
    this.qtyInWork = qtyInWork;
  }

  public int getQtyCompleted() {
    return this.qtyCompleted;
  }

  public void setQtyCompleted(int qtyCompleted) {
    this.qtyCompleted = qtyCompleted;
  }

  public int getQtyCompletePending() {
    return this.qtyCompletePending;
  }

  public void setQtyCompletePending(int qtyCompletePending) {
    this.qtyCompletePending = qtyCompletePending;
  }

  public int getQtyRejected() {
    return this.qtyRejected;
  }

  public void setQtyRejected(int qtyRejected) {
    this.qtyRejected = qtyRejected;
  }

  public String getPreviouslyStarted() {
    return this.previouslyStarted;
  }

  public void setPreviouslyStarted(String previouslyStarted) {
    this.previouslyStarted = previouslyStarted;
  }

  public String getPreviousStepId() {
    return this.previousStepId;
  }

  public void setPreviousStepId(String previousStepId) {
    this.previousStepId = previousStepId;
  }

  public String getPreviousResourceBo() {
    return this.previousResourceBo;
  }

  public void setPreviousResourceBo(String previousResourceBo) {
    this.previousResourceBo = previousResourceBo;
  }

  public Date getDateQueued() {
    return this.dateQueued;
  }

  public void setDateQueued(Date dateQueued) {
    this.dateQueued = dateQueued;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public Date getScheduledCompDate() {
    return this.scheduledCompDate;
  }

  public void setScheduledCompDate(Date scheduledCompDate) {
    this.scheduledCompDate = scheduledCompDate;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getWorkCenterBo() {
    return this.workCenterBo;
  }

  public void setWorkCenterBo(String workCenterBo) {
    this.workCenterBo = workCenterBo;
  }

  public String getQueueTimeBo() {
    return this.queueTimeBo;
  }

  public void setQueueTimeBo(String queueTimeBo) {
    this.queueTimeBo = queueTimeBo;
  }

  public Date getPlanCompDate() {
    return this.planCompDate;
  }

  public void setPlanCompDate(Date planCompDate) {
    this.planCompDate = planCompDate;
  }

  public String getHoldComment() {
    return this.holdComment;
  }

  public void setHoldComment(String holdComment) {
    this.holdComment = holdComment;
  }

  public Date getPlannedStartDate() {
    return this.plannedStartDate;
  }

  public void setPlannedStartDate(Date plannedStartDate) {
    this.plannedStartDate = plannedStartDate;
  }

  public Date getScheduledStartDate() {
    return this.scheduledStartDate;
  }

  public void setScheduledStartDate(Date scheduledStartDate) {
    this.scheduledStartDate = scheduledStartDate;
  }

  //比较qtime equals方法
  public boolean equalsQtime(ViewDispatchSfc data) {
    return compareDate(this.getInMinTime(), data.getInMinTime())
        && compareDate(this.getInMaxTime(), data.getInMaxTime())
        && compareDate(this.getOutMinTime(), data.getOutMinTime())
        && compareDate(this.getOutMaxTime(), data.getOutMaxTime())
        && this.sfcStepSeq == data.sfcStepSeq;
  }

  //检验2个 Q-time是否有交集
  public boolean qtimeIntersectionCheck(ViewDispatchSfc data) {
    //如果有一个sfc为完成，则无需校验Q-time是否有交集
    if ("true".equals(this.getDone()) || "true".equals(data.getDone())) {
      return true;
    }
    if (this.sfcStepSeq != data.sfcStepSeq) {
      return false;
    }
    if (!this.crossInQtime(data).isAvailable()) {
      return false;
    }

    if (!this.crossInQtime(data).isAvailable()) {
      return false;
    }

    return true;
  }

  public DatePeriod crossInQtime(ViewDispatchSfc data) {
    DatePeriod inDatePeriod1 = new DatePeriod(this.getInMinTime(), this.getInMaxTime());
    DatePeriod inDatePeriod2 = new DatePeriod(data.getInMinTime(), data.getInMaxTime());
    return inDatePeriod1.crossWith(inDatePeriod2);
  }

  public DatePeriod crossOutQtime(ViewDispatchSfc data) {
    DatePeriod outDatePeriod1 = new DatePeriod(this.getOutMinTime(), this.getOutMaxTime());
    DatePeriod outDatePeriod2 = new DatePeriod(data.getOutMinTime(), data.getOutMaxTime());
    return outDatePeriod1.crossWith(outDatePeriod2);
  }

  public String findAssignRecipeName(String resourceBo) {
    String recipeName = this.getAssignRecipeName();
    if (recipeName != null) {
      return recipeName;
    }

    String assignResources = this.getAssignResources();
    if (assignResources == null) {
      return null;
    }

    List<Object> rs = new GsonBuilder().serializeNulls().create()
        .fromJson(assignResources, List.class);
    for (Object temp : rs) {
      Map<String, Object> r = (Map<String, Object>) temp;

      Object _resourceBo = r.get("resourceBo");
      Object _recipeName = r.get("recipeName");
      if (_recipeName != null && resourceBo.equals(_resourceBo)) {
        return "" + _recipeName;
      }
    }

    return null;
  }

  public String getSfcStateName() {
    return this.sfcStateName;
  }

  public void setSfcStateName(String sfcStateName) {
    this.sfcStateName = sfcStateName;
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

  public int getPriority() {
    return this.priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public int getItemQty() {
    return this.itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
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

  public String getRouterName() {
    return this.routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public int getSfcQty() {
    return this.sfcQty;
  }

  public void setSfcQty(int sfcQty) {
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

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCustomerItemLotNameOrig() {
    return this.customerItemLotNameOrig;
  }

  public void setCustomerItemLotNameOrig(String customerItemLotNameOrig) {
    this.customerItemLotNameOrig = customerItemLotNameOrig;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getCarrierName() {
    return this.carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getCarrierStateName() {
    return this.carrierStateName;
  }

  public void setCarrierStateName(String carrierStateName) {
    this.carrierStateName = carrierStateName;
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

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getResourceSlotId() {
    return this.resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public Date getBumpingSod() {
    return this.bumpingSod;
  }

  public void setBumpingSod(Date bumpingSod) {
    this.bumpingSod = bumpingSod;
  }

  public Date getWlpSod() {
    return this.wlpSod;
  }

  public void setWlpSod(Date wlpSod) {
    this.wlpSod = wlpSod;
  }

  public Date getCpSod() {
    return this.cpSod;
  }

  public void setCpSod(Date cpSod) {
    this.cpSod = cpSod;
  }

  public Date getFcSod() {
    return this.fcSod;
  }

  public void setFcSod(Date fcSod) {
    this.fcSod = fcSod;
  }

  public boolean isClosed() {
    if (this.statusBo == null) {
      return false;
    }

    String status = Env.trimHandle(this.statusBo);
    return !"401".equals(status) && !"402".equals(status) && !"403".equals(status) && !"404"
        .equals(status);
  }

  public boolean isRunning() {
    return "RUN_STANDBY".equals(this.sfcStateName)
        || "PROCESSING".equals(this.sfcStateName)
        || "RUN_FINISH".equals(this.sfcStateName)
        || "RUN_HOLD_RELEASE".equals(this.sfcStateName);
  }

  public boolean isProcessing() {
    return "PROCESSING".equals(this.sfcStateName);
  }

  public boolean isHold() {
    return "RUN_HOLD".equals(this.sfcStateName)
        || "HOLD".equals(this.sfcStateName);
  }

  /**
   * @return 是否在委外流程中
   */
  public boolean isOuting() {
    return "RESERVE_OUT".equals(this.sfcStateName)
        || "OUT".equals(this.sfcStateName)
        || "OUT_RETURN".equals(this.sfcStateName);
  }
}
