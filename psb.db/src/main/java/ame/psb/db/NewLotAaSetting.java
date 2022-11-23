package ame.psb.db;

import java.util.Date;

public class NewLotAaSetting {

  private String customerBo;

  private String departmentBo;

  private String lotType;

  private String operationBo;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public NewLotAaSetting() {
  }

  public NewLotAaSetting(NewLotAaSetting data) {
    this.customerBo = data.customerBo;
    this.departmentBo = data.departmentBo;
    this.lotType = data.lotType;
    this.operationBo = data.operationBo;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public NewLotAaSetting clone() {
    return new NewLotAaSetting(this);
  }

  @Override
  public String toString() {
    return this.customerBo + ", " + this.departmentBo + ", " + this.lotType + ", "
        + this.operationBo;
  }

  public String getCustomerBo() {
    return customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getDepartmentBo() {
    return departmentBo;
  }

  public void setDepartmentBo(String departmentBo) {
    this.departmentBo = departmentBo;
  }

  public String getLotType() {
    return lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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
