package ame.psb.db;

import java.util.Date;

public class ViewDummyCount extends DummyCount {

  private String resourceBo;

  private String itemBo;

  private String beginOperationBo;

  private String endOperationBo;

  private Date chkFrom;

  private Date chkTo;

  private String stateName;

  private String beginOperation;

  private String endOperation;

  private String resourceName;

  private String itemName;

  public ViewDummyCount() {
  }

  public ViewDummyCount(ViewDummyCount data) {
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.beginOperationBo = data.beginOperationBo;
    this.endOperationBo = data.endOperationBo;
    this.chkFrom = data.chkFrom;
    this.chkTo = data.chkTo;
    this.stateName = data.stateName;
    this.beginOperation = data.beginOperation;
    this.endOperation = data.endOperation;
    this.resourceName = data.resourceName;
    this.itemName = data.itemName;
  }

  @Override
  public ViewDummyCount clone() {
    return new ViewDummyCount(this);
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getBeginOperationBo() {
    return this.beginOperationBo;
  }

  public void setBeginOperationBo(String beginOperationBo) {
    this.beginOperationBo = beginOperationBo;
  }

  public String getEndOperationBo() {
    return this.endOperationBo;
  }

  public void setEndOperationBo(String endOperationBo) {
    this.endOperationBo = endOperationBo;
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

  @Override
  public String getStateName() {
    return this.stateName;
  }

  @Override
  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getBeginOperation() {
    return this.beginOperation;
  }

  public void setBeginOperation(String beginOperation) {
    this.beginOperation = beginOperation;
  }

  public String getEndOperation() {
    return this.endOperation;
  }

  public void setEndOperation(String endOperation) {
    this.endOperation = endOperation;
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public boolean isTimeOut(long time) {
    if (getDummyCount() != null && getCurrentCount().intValue() >= getDummyCount().intValue()) {
      return true;
    }

    if (getDummyTimes() != null && time >= (getLastTime().getTime()
        + getDummyTimes().longValue() * 60000)) {
      return true;
    }

    return false;
  }
}