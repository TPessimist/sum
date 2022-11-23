package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class SorterMcsJob {

  private String handle;

  private String resourceBo;

  private String operationBo;

  private String jobId;

  private String customerLot;

  private BigDecimal waferSize;

  private String carrierPorta;

  private String carrierPortb;

  private String carrierPortc;

  private String jobType;

  private String stateName;

  private String message;

  private String createUser;

  private Date createTime;

  private String updateUser;

  private Date updateTime;


  public SorterMcsJob() {
  }

  public SorterMcsJob(SorterMcsJob data) {
    this.handle = data.handle;
    this.resourceBo = data.resourceBo;
    this.operationBo = data.operationBo;
    this.jobId = data.jobId;
    this.customerLot = data.customerLot;
    this.waferSize = data.waferSize;
    this.carrierPorta = data.carrierPorta;
    this.carrierPortb = data.carrierPortb;
    this.carrierPortc = data.carrierPortc;
    this.jobType = data.jobType;
    this.stateName = data.stateName;
    this.message = data.message;
    this.createUser = data.createUser;
    this.createTime = data.createTime;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getCustomerLot() {
    return customerLot;
  }

  public void setCustomerLot(String customerLot) {
    this.customerLot = customerLot;
  }

  public BigDecimal getWaferSize() {
    return waferSize;
  }

  public void setWaferSize(BigDecimal waferSize) {
    this.waferSize = waferSize;
  }

  public String getCarrierPorta() {
    return carrierPorta;
  }

  public void setCarrierPorta(String carrierPorta) {
    this.carrierPorta = carrierPorta;
  }

  public String getCarrierPortb() {
    return carrierPortb;
  }

  public void setCarrierPortb(String carrierPortb) {
    this.carrierPortb = carrierPortb;
  }

  public String getCarrierPortc() {
    return carrierPortc;
  }

  public void setCarrierPortc(String carrierPortc) {
    this.carrierPortc = carrierPortc;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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
  public SorterMcsJob clone() {
    return new SorterMcsJob(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
