package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class HoldReleaseSfcItem {

  private String holdReleaseBo;

  private String customerItemBo;

  private String sfcBo;

  private String actionName;

  private String resultCarrierBo;

  private String resultSfcBo;

  private int resultSlotNo;

  private String ncCode;

  private String resultRouterBo;

  private String status;

  private String operationBo;

  private String actionNameGroup;

  public String getHoldReleaseBo() {
    return this.holdReleaseBo;
  }

  public void setHoldReleaseBo(String holdReleaseBo) {
    this.holdReleaseBo = holdReleaseBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getActionName() {
    return this.actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getResultCarrierBo() {
    return this.resultCarrierBo;
  }

  public void setResultCarrierBo(String resultCarrierBo) {
    this.resultCarrierBo = resultCarrierBo;
  }

  public String getResultSfcBo() {
    return this.resultSfcBo;
  }

  public void setResultSfcBo(String resultSfcBo) {
    this.resultSfcBo = resultSfcBo;
  }

  public int getResultSlotNo() {
    return this.resultSlotNo;
  }

  public void setResultSlotNo(int resultSlotNo) {
    this.resultSlotNo = resultSlotNo;
  }

  public String getNcCode() {
    return this.ncCode;
  }

  public void setNcCode(String ncCode) {
    this.ncCode = ncCode;
  }

  public String getResultRouterBo() {
    return this.resultRouterBo;
  }

  public void setResultRouterBo(String resultRouterBo) {
    this.resultRouterBo = resultRouterBo;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getActionNameGroup() {
    return actionNameGroup;
  }

  public void setActionNameGroup(String actionNameGroup) {
    this.actionNameGroup = actionNameGroup;
  }

  @Override
  public String toString() {
    return this.customerItemBo + "," + this.sfcBo;
  }
}