package ame.psb.db;

import java.util.Date;

public class MtBindOperation {

  private String bomComponentItemBo;

  private String startOperationBo;

  private String endOperationBo;

  private String updatedUser;

  private Date updatedTime;


  public MtBindOperation() {
  }

  public MtBindOperation(MtBindOperation data) {
    this.bomComponentItemBo = data.bomComponentItemBo;
    this.startOperationBo = data.startOperationBo;
    this.endOperationBo = data.endOperationBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public MtBindOperation clone() {
    return new MtBindOperation(this);
  }

  @Override
  public String toString() {
    return this.bomComponentItemBo + ", " + this.startOperationBo + ", " + this.endOperationBo;
  }

  public String getBomComponentItemBo() {
    return bomComponentItemBo;
  }

  public void setBomComponentItemBo(String bomComponentItemBo) {
    this.bomComponentItemBo = bomComponentItemBo;
  }

  public String getStartOperationBo() {
    return startOperationBo;
  }

  public void setStartOperationBo(String startOperationBo) {
    this.startOperationBo = startOperationBo;
  }

  public String getEndOperationBo() {
    return endOperationBo;
  }

  public void setEndOperationBo(String endOperationBo) {
    this.endOperationBo = endOperationBo;
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
