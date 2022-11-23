package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Dcop {

  private String id;

  private String operationBo;

  private String dcGroupBo;

  private String itemGroupBo;

  private String waferSelector;

  private int dieCount;

  private int dcCount;

  private String updatedUser;

  private String itemBo;

  private Date updatedTime;

  private String holdOperationBo;

  private String stateName;

  private String checkFlag;


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDcGroupBo() {
    return this.dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getWaferSelector() {
    return this.waferSelector;
  }

  public void setWaferSelector(String waferSelector) {
    this.waferSelector = waferSelector;
  }

  public int getDieCount() {
    return this.dieCount;
  }

  public void setDieCount(int dieCount) {
    this.dieCount = dieCount;
  }

  public int getDcCount() {
    return this.dcCount;
  }

  public void setDcCount(int dcCount) {
    this.dcCount = dcCount;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
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

  public String getHoldOperationBo() {
    return this.holdOperationBo;
  }

  public void setHoldOperationBo(String holdOperationBo) {
    this.holdOperationBo = holdOperationBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCheckFlag() {
    return checkFlag;
  }

  public void setCheckFlag(String checkFlag) {
    this.checkFlag = checkFlag;
  }

  @Override
  public String toString() {
    return this.id;
  }
}
