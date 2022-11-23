package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class DcPlan extends AbstractLoggable {

  private String id;

  private String dcopBo;

  private String operationBo;

  private String resourceBo;

  private Date dcTime;

  private String stateName;

  private String dptNo;

  private String updatedUser;

  private Date updatedTime;

  private String holdResourceBo;

  private String holdOperationBo;

  public DcPlan() {
    this.id = UUID.randomUUID().toString();
    this.dcTime = new Date();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDcopBo() {
    return this.dcopBo;
  }

  public void setDcopBo(String dcopBo) {
    this.dcopBo = dcopBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public Date getDcTime() {
    return this.dcTime;
  }

  public void setDcTime(Date dcTime) {
    this.dcTime = dcTime;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getDptNo() {
    return this.dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
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

  public String getHoldResourceBo() {
    return this.holdResourceBo;
  }

  public void setHoldResourceBo(String holdResourceBo) {
    this.holdResourceBo = holdResourceBo;
  }

  public String getHoldOperationBo() {
    return this.holdOperationBo;
  }

  public void setHoldOperationBo(String holdOperationBo) {
    this.holdOperationBo = holdOperationBo;
  }

  @Override
  public String getTableName() {
    return "ZD_DC_PLAN";
  }

  @Override
  public String getLogUser() {
    return this.updatedUser;
  }

  @Override
  public Date getLogDateTime() {
    return this.updatedTime;
  }

  @Override
  public String toString() {
    return this.id + "," + this.dcopBo + "," + this.stateName + "," + this.operationBo;
  }
}
