package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class RouterOperationChangeLog {

  private String id;

  private String customerId;

  private String deviceName;

  private String routerName;

  private String packageName;

  private String deviceBo;

  private String routerBo;

  private String packageBo;

  private String changeType;

  private String pdmFlag;

  private String reserveField1;

  private String reserveField2;

  private String logUser;

  private Date logTime;


  public RouterOperationChangeLog() {
  }

  public RouterOperationChangeLog(RouterOperationChangeLog data) {
    this.id = data.id;
    this.customerId = data.customerId;
    this.deviceName = data.deviceName;
    this.routerName = data.routerName;
    this.packageName = data.packageName;
    this.deviceBo = data.deviceBo;
    this.routerBo = data.routerBo;
    this.packageBo = data.packageBo;
    this.changeType = data.changeType;
    this.pdmFlag = data.pdmFlag;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
  }

  @Override
  public RouterOperationChangeLog clone() {
    return new RouterOperationChangeLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
