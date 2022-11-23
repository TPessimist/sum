package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class MoldLocationManagement {

  private String batchId;

  private String location;

  private String shopOrder;

  private String device;

  private String operation;

  private String stateName;

  private String updateUser;

  private Date updatedTime;

  private String reserve1;

  private String reserve2;

  private String reserve3;

  private String relation;


  public MoldLocationManagement() {
  }

  public MoldLocationManagement(MoldLocationManagement data) {
    this.batchId = data.batchId;
    this.location = data.location;
    this.shopOrder = data.shopOrder;
    this.device = data.device;
    this.operation = data.operation;
    this.stateName = data.stateName;
    this.updateUser = data.updateUser;
    this.updatedTime = data.updatedTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
    this.reserve3 = data.reserve3;
    this.relation = data.relation;
  }

  @Override
  public MoldLocationManagement clone() {
    return new MoldLocationManagement(this);
  }

  @Override
  public String toString() {
    return this.batchId + ", " + this.location;
  }
}
