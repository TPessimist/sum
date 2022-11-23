package ame.psb.db;

import java.util.Date;

public class RunOperationWaferLock {

  private String customerItemBo;

  private String operationBo;

  private String lockName;

  private String lockMsg;

  private String htResult;

  private String flag;

  private Date createTime;

  private Date unlockTime;


  public RunOperationWaferLock() {
  }

  public RunOperationWaferLock(RunOperationWaferLock data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.lockName = data.lockName;
    this.lockMsg = data.lockMsg;
    this.htResult = data.htResult;
    this.flag = data.flag;
    this.createTime = data.createTime;
    this.unlockTime = data.unlockTime;
  }

  @Override
  public RunOperationWaferLock clone() {
    return new RunOperationWaferLock(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo + ", " + this.lockName;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getLockName() {
    return lockName;
  }

  public void setLockName(String lockName) {
    this.lockName = lockName;
  }

  public String getLockMsg() {
    return lockMsg;
  }

  public void setLockMsg(String lockMsg) {
    this.lockMsg = lockMsg;
  }

  public String getHtResult() {
    return htResult;
  }

  public void setHtResult(String htResult) {
    this.htResult = htResult;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUnlockTime() {
    return unlockTime;
  }

  public void setUnlockTime(Date unlockTime) {
    this.unlockTime = unlockTime;
  }

}
