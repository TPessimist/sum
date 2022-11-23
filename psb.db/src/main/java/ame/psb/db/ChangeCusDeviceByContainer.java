package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ChangeCusDeviceByContainer {

  private String id;

  private String oldCustomerDevice;

  private String newCustomerDevice;

  private String sfcBo;

  private String shopOrderBo;

  private String sfcName;

  private String shopOrderName;

  private String updateUser;

  private Date updateTime;

  private String reversedField1;

  private String reversedField2;


  public ChangeCusDeviceByContainer() {
  }

  public ChangeCusDeviceByContainer(ChangeCusDeviceByContainer data) {
    this.id = data.id;
    this.oldCustomerDevice = data.oldCustomerDevice;
    this.newCustomerDevice = data.newCustomerDevice;
    this.sfcBo = data.sfcBo;
    this.shopOrderBo = data.shopOrderBo;
    this.sfcName = data.sfcName;
    this.shopOrderName = data.shopOrderName;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
  }

  @Override
  public ChangeCusDeviceByContainer clone() {
    return new ChangeCusDeviceByContainer(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
