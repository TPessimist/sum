package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ZdBincondeControl {

  private String id;

  private String controlType;

  private String itemGroupBo;

  private String itemGroupName;

  private String operationBo;

  private String operationName;

  private String shopOrderBo;

  private String shopOrderName;

  private String customerItemBo;

  private String customerItemName;

  private String binCode;

  private BigDecimal binCodeOffset;

  private BigDecimal waferUcl;

  private BigDecimal waferLcl;

  private BigDecimal waferUclCount;

  private BigDecimal waferLclCount;

  private String updateUser;

  private Date updateTime;


  public ZdBincondeControl() {
  }

  public ZdBincondeControl(ZdBincondeControl data) {
    this.id = data.id;
    this.controlType = data.controlType;
    this.itemGroupBo = data.itemGroupBo;
    this.itemGroupName = data.itemGroupName;
    this.operationBo = data.operationBo;
    this.operationName = data.operationName;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.customerItemBo = data.customerItemBo;
    this.customerItemName = data.customerItemName;
    this.binCode = data.binCode;
    this.binCodeOffset = data.binCodeOffset;
    this.waferUcl = data.waferUcl;
    this.waferLcl = data.waferLcl;
    this.waferUclCount = data.waferUclCount;
    this.waferLclCount = data.waferLclCount;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public BigDecimal getBinCodeOffset() {
    return binCodeOffset;
  }

  public void setBinCodeOffset(BigDecimal binCodeOffset) {
    this.binCodeOffset = binCodeOffset;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getControlType() {
    return controlType;
  }

  public void setControlType(String controlType) {
    this.controlType = controlType;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemGroupName() {
    return itemGroupName;
  }

  public void setItemGroupName(String itemGroupName) {
    this.itemGroupName = itemGroupName;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getCustomerItemName() {
    return customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public String getBinCode() {
    return binCode;
  }

  public void setBinCode(String binCode) {
    this.binCode = binCode;
  }

  public BigDecimal getWaferUcl() {
    return waferUcl;
  }

  public void setWaferUcl(BigDecimal waferUcl) {
    this.waferUcl = waferUcl;
  }

  public BigDecimal getWaferLcl() {
    return waferLcl;
  }

  public void setWaferLcl(BigDecimal waferLcl) {
    this.waferLcl = waferLcl;
  }

  public BigDecimal getWaferUclCount() {
    return waferUclCount;
  }

  public void setWaferUclCount(BigDecimal waferUclCount) {
    this.waferUclCount = waferUclCount;
  }

  public BigDecimal getWaferLclCount() {
    return waferLclCount;
  }

  public void setWaferLclCount(BigDecimal waferLclCount) {
    this.waferLclCount = waferLclCount;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public ZdBincondeControl clone() {
    return new ZdBincondeControl(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
