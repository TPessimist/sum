package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtPassHoldRelease {

  private String id;

  private String sfcBo;

  private String shopOrderBo;

  private String sfcName;

  private String shopOrderName;

  private String operationBo;

  private String qePassFlag;

  private String engineerPassFlag;

  private String qePassUser;

  private String engineerPassUser;

  private String customerPassFlag;

  private String custoemr;

  private String updateUser;

  private Date updateTime;

  private String reserve1;

  private String reserve2;

  private String status;

  private String holdCode;

  private String holdComment;


  public FtPassHoldRelease() {
  }

  public FtPassHoldRelease(FtPassHoldRelease data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.shopOrderBo = data.shopOrderBo;
    this.sfcName = data.sfcName;
    this.shopOrderName = data.shopOrderName;
    this.operationBo = data.operationBo;
    this.qePassFlag = data.qePassFlag;
    this.engineerPassFlag = data.engineerPassFlag;
    this.qePassUser = data.qePassUser;
    this.engineerPassUser = data.engineerPassUser;
    this.customerPassFlag = data.customerPassFlag;
    this.custoemr = data.custoemr;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
    this.status = data.status;
    this.holdCode = data.holdCode;
    this.holdComment = data.holdComment;
  }

  @Override
  public FtPassHoldRelease clone() {
    return new FtPassHoldRelease(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
