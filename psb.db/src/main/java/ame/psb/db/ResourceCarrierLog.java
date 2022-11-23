package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ResourceCarrierLog {

  private String id;

  private String resourceBo;

  private String carrierBo;

  private String resourceName;

  private String carrierName;

  private String action;

  private String lp;

  private String reserveField1;

  private String reserveField2;

  private String logUser;

  private Date logTime;


  public ResourceCarrierLog() {
  }

  public ResourceCarrierLog(ResourceCarrierLog data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.carrierBo = data.carrierBo;
    this.resourceName = data.resourceName;
    this.carrierName = data.carrierName;
    this.action = data.action;
    this.lp = data.lp;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
  }

  @Override
  public ResourceCarrierLog clone() {
    return new ResourceCarrierLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
