package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class AgedLotJumStation {

  private String requestId;

  private String sfcBo;

  private String sfcName;

  private String carrierBo;

  private String carrierName;

  private String beginOperation;

  private String endOperation;

  private String customer;

  private String department;

  private String holdCode;

  private String holdeComment;

  private String status;

  private String message;

  private String actionContent;

  private String updateUser;

  private Date updateTime;

  private String reverse1;

  private String reverse2;


  public AgedLotJumStation() {
  }

  public AgedLotJumStation(AgedLotJumStation data) {
    this.requestId = data.requestId;
    this.sfcBo = data.sfcBo;
    this.sfcName = data.sfcName;
    this.carrierBo = data.carrierBo;
    this.carrierName = data.carrierName;
    this.beginOperation = data.beginOperation;
    this.endOperation = data.endOperation;
    this.customer = data.customer;
    this.department = data.department;
    this.holdCode = data.holdCode;
    this.holdeComment = data.holdeComment;
    this.status = data.status;
    this.message = data.message;
    this.actionContent = data.actionContent;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reverse1 = data.reverse1;
    this.reverse2 = data.reverse2;
  }

  @Override
  public AgedLotJumStation clone() {
    return new AgedLotJumStation(this);
  }

  @Override
  public String toString() {
    return this.requestId;
  }
}
