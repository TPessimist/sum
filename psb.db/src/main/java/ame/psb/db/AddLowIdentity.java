package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class AddLowIdentity {

  private String handle;

  private String itemName;

  private String sfcBo;

  private String sfc;

  private String shopOrderBo;

  private String shopOrderName;

  private String type;

  private String state;

  private String updatedUser;

  private Date updatedTime;

  private String reverseField2;

  private String device;

  private String customerItemsetName;

  public AddLowIdentity() {
  }

  public AddLowIdentity(AddLowIdentity data) {
    this.handle = data.handle;
    this.itemName = data.itemName;
    this.sfcBo = data.sfcBo;
    this.sfc = data.sfc;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.type = data.type;
    this.state = data.state;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.reverseField2 = data.reverseField2;
    this.device = data.device;
    this.customerItemsetName = data.customerItemsetName;
  }
  

  @Override
  public AddLowIdentity clone() {
    return new AddLowIdentity(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
