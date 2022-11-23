package ame.psb.db;

import java.util.Date;

public class FunctionCardControl {

  private String functionId;

  private String functionName;

  private String functionState;

  private String updateUser;

  private Date updateTime;


  public FunctionCardControl() {
  }

  public FunctionCardControl(FunctionCardControl data) {
    this.functionId = data.functionId;
    this.functionName = data.functionName;
    this.functionState = data.functionState;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  @Override
  public FunctionCardControl clone() {
    return new FunctionCardControl(this);
  }

  @Override
  public String toString() {
    return this.functionId;
  }

  public String getFunctionId() {
    return functionId;
  }

  public void setFunctionId(String functionId) {
    this.functionId = functionId;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public String getFunctionState() {
    return functionState;
  }

  public void setFunctionState(String functionState) {
    this.functionState = functionState;
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


}
