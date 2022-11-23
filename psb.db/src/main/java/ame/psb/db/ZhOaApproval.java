package ame.psb.db;

import java.util.Date;
import lombok.Data;


@Data
public class ZhOaApproval {

  private String requestId;

  private String formName;

  private String formStatus;

  private String customer;

  private String customerDevice;

  private String device;

  private String customerLot;

  private String waferList;

  private Date scheduledStartDate;

  private Date scheduledCompDate;

  private String remark;

  private Date createdDateTime;

  private String createUser;

  private Date updatedTime;

  private Boolean firstMakeFlag; //首次制样

  private String department;//部门

  private String updateUser;//工号

  private String leaderUser;//直属上级的工号

  public ZhOaApproval() {
  }

  public ZhOaApproval(ZhOaApproval data) {
    this.requestId = data.requestId;
    this.formName = data.formName;
    this.formStatus = data.formStatus;
    this.customer = data.customer;
    this.customerDevice = data.customerDevice;
    this.device = data.device;
    this.customerLot = data.customerLot;
    this.waferList = data.waferList;
    this.scheduledStartDate = data.scheduledStartDate;
    this.scheduledCompDate = data.scheduledCompDate;
    this.remark = data.remark;
    this.createdDateTime = data.createdDateTime;
    this.createUser = data.createUser;
    this.updatedTime = data.updatedTime;
    this.firstMakeFlag = data.firstMakeFlag;
    this.department = data.department;
    this.updateUser = data.updateUser;
    this.leaderUser = data.leaderUser;
  }


  @Override
  public ZhOaApproval clone() {
    return new ZhOaApproval(this);
  }

  @Override
  public String toString() {
    return this.requestId + ", " + this.customerLot;
  }
}
