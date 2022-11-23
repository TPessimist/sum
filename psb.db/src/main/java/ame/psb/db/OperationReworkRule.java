package ame.psb.db;

import java.util.Date;

public class OperationReworkRule {

  private String itemGroupBo;

  private String operationBo;

  private String nccodeBo;

  private String comment;

  private String reworktype;

  private String updatedUser;

  private Date updatedTime;

  private String state;

  private String reworkRule;


  public OperationReworkRule() {
  }

  public OperationReworkRule(OperationReworkRule data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.nccodeBo = data.nccodeBo;
    this.comment = data.comment;
    this.reworktype = data.reworktype;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.state = data.state;
    this.reworkRule = data.reworkRule;
  }


  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getNccodeBo() {
    return nccodeBo;
  }

  public void setNccodeBo(String nccodeBo) {
    this.nccodeBo = nccodeBo;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getReworktype() {
    return reworktype;
  }

  public void setReworktype(String reworktype) {
    this.reworktype = reworktype;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getReworkRule() {
    return reworkRule;
  }

  public void setReworkRule(String reworkRule) {
    this.reworkRule = reworkRule;
  }

  @Override
  public OperationReworkRule clone() {
    return new OperationReworkRule(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo;
  }
}
