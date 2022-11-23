package ame.psb.db;

import com.google.common.base.Strings;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class FutureAction {

  private String id;

  private String stateName;

  private String department;

  private String customerBo;

  private String itemGroupBo;

  private String itemBo;

  private String shopOrderBo;

  private String sfcBo;

  private String operationBo;

  private String actionName;

  private String actionContent;

  private String chkType;

  private int chkQty;

  private Date chkFrom;

  private Date chkTo;

  private int stepSeq;

  private String actionComment;

  private String updatedUser;

  private Date updatedTime;

  private String customerLot;

  private String waferId;

  private String lotType;

  private String uploadPath;

  private String customerDevice;

  private String capAbilityContent; //能力

  private String oaId;

  private String fabLotId;

  public FutureAction() {
    this.id = UUID.randomUUID().toString();
    this.stateName = "EDIT";
    this.chkType = "T";
  }

  public FutureAction(FutureAction data) {
    this.id = data.id;
    this.stateName = data.stateName;
    this.customerBo = data.customerBo;
    this.itemGroupBo = data.itemGroupBo;
    this.itemBo = data.itemBo;
    this.shopOrderBo = data.shopOrderBo;
    this.sfcBo = data.sfcBo;
    this.operationBo = data.operationBo;
    this.actionName = data.actionName;
    this.actionContent = data.actionContent;
    this.chkType = data.chkType;
    this.chkQty = data.chkQty;
    this.chkFrom = data.chkFrom;
    this.chkTo = data.chkTo;
    this.stepSeq = data.stepSeq;
    this.actionComment = data.actionComment;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.customerLot = data.customerLot;
    this.waferId = data.waferId;
    this.lotType = data.lotType;
    this.uploadPath = data.uploadPath;
    this.department = data.department;
    this.customerDevice = data.customerDevice;
    this.capAbilityContent = data.capAbilityContent;
    this.oaId = data.oaId;
    this.fabLotId = data.fabLotId;
  }

  public static boolean compareString(String str1, String str2) {
    if (str1 == null) {
      return str2 == null;
    } else {
      return str1.equals(str2);
    }
  }

  public static boolean compareDate(Date date1, Date date2) {
    if (date1 == null) {
      return date2 == null;
    } else {
      return date2 != null && (Math.abs(date1.getTime() - date2.getTime()) < 5000);
    }
  }

  public String getConfigTarget() {
    if (this.sfcBo != null) {
      return this.sfcBo;
    }
    if (this.shopOrderBo != null) {
      return this.shopOrderBo;
    }
    if (this.itemBo != null) {
      return this.itemBo;
    }
    if (this.itemGroupBo != null) {
      return this.sfcBo;
    }
    if (this.customerBo != null) {
      return this.customerBo;
    }
    if (this.customerLot != null) {
      return this.customerLot;
    }
    if (this.waferId != null) {
      return this.waferId;
    }
    if (this.fabLotId != null) {
      return this.fabLotId;
    }
    return null;
  }

  public boolean isEditable() {
    return "EDIT".equalsIgnoreCase(this.stateName);
  }

  public boolean isOnline() {
    return !"EDIT".equalsIgnoreCase(this.stateName) && !"CANCEL".equalsIgnoreCase(this.stateName);
  }

  public boolean isEnable() {
    return "ENABLE".equalsIgnoreCase(this.stateName);
  }

  public String monitorKey() {
    return String.format("%s_%s",
        this.operationBo,
        this.actionName);
  }

  public String getCustomerDevice() {
    return customerDevice;
  }

  public void setCustomerDevice(String customerDevice) {
    this.customerDevice = customerDevice;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getActionName() {
    return this.actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getActionContent() {
    return this.actionContent;
  }

  public void setActionContent(String actionContent) {
    this.actionContent = actionContent;
  }

  public String getCapAbilityContent() {
    return capAbilityContent;
  }

  public void setCapAbilityContent(String capAbilityContent) {
    this.capAbilityContent = capAbilityContent;
  }

  public String getChkType() {
    return this.chkType;
  }

  public void setChkType(String chkType) {
    this.chkType = chkType;
  }

  public int getChkQty() {
    return this.chkQty;
  }

  public void setChkQty(int chkQty) {
    this.chkQty = chkQty;
  }

  public Date getChkFrom() {
    return this.chkFrom;
  }

  public void setChkFrom(Date chkFrom) {
    this.chkFrom = chkFrom;
  }

  public Date getChkTo() {
    return this.chkTo;
  }

  public void setChkTo(Date chkTo) {
    this.chkTo = chkTo;
  }

  public int getStepSeq() {
    return this.stepSeq;
  }

  public void setStepSeq(int stepSeq) {
    this.stepSeq = stepSeq;
  }

  public String getActionComment() {
    return this.actionComment;
  }

  public void setActionComment(String actionComment) {
    this.actionComment = actionComment;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getCustomerLot() {
    return this.customerLot;
  }

  public void setCustomerLot(String customerLot) {
    this.customerLot = customerLot;
  }

  public String getWaferId() {
    return this.waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getUploadPath() {
    return uploadPath;
  }

  public void setUploadPath(String uploadPath) {
    this.uploadPath = uploadPath;
  }

  public String getOaId() {
    return oaId;
  }

  public void setOaId(String oaId) {
    this.oaId = oaId;
  }

  public String getFabLotId() {
    return fabLotId;
  }

  public void setFabLotId(String fabLotId) {
    this.fabLotId = fabLotId;
  }

  @Override
  public FutureAction clone() {
    return new FutureAction(this);
  }

  // 不比较ID和SFCBO
  @Deprecated
  public boolean equalsIgnoreIdSfc(FutureAction data) {
    return compareString(this.actionComment, data.actionComment)
        && compareString(this.actionContent, data.actionContent)
        && compareString(this.actionName, data.actionName)
        && compareDate(this.chkFrom, data.chkFrom)
        && this.chkQty == data.chkQty
        && compareDate(this.chkTo, data.chkTo)
        && compareString(this.chkType, data.chkType)
        && compareString(this.customerBo, data.customerBo)
        && compareString(this.customerLot, data.customerLot)
        && compareString(this.itemBo, data.itemBo)
        && compareString(this.itemGroupBo, data.itemGroupBo)
        && compareString(this.lotType, data.lotType)
        && compareString(this.operationBo, data.operationBo)
        && compareString(this.sfcBo, data.sfcBo)
        && compareString(this.shopOrderBo, data.shopOrderBo)
        && compareString(this.stateName, data.stateName)
        && compareString(this.updatedUser, data.updatedUser)
        && compareString(this.waferId, data.waferId);

  }

  public String holdCode() {
    if (!"HOLD".equals(this.getActionName())) {
      return null;
    }
    if (this.getActionContent() == null || this.getActionContent().isEmpty()) {
      return "FTLD";
    }
    return this.getActionContent();
  }

  @Override
  public String toString() {
    return String.format("%-18s, %-35s, %-11s = %s", this.id, this.operationBo, this.actionName,
        this.actionContent);
  }

  public String getActionNameCN() {
    if (Strings.isNullOrEmpty(this.actionName)) {
      return "空";
    }
    switch (this.actionName) {
      case "HOLD":
        return "预约保留";
      case "INSTRUCTION":
        return "预约提示";
      case "OPERATION":
        return "预约跳站";
      case "PRIORITY":
        return "预约变更优先级";
      case "RESERVE_OUT":
        return "预约委外";
      case "RESOURCE_RECIPE":
        return "预约变更设备/配方";
      case "SAMPLING":
        return "预约抽样";
      default:
        return "空";
    }
  }
}
