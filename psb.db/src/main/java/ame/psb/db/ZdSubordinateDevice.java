package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ZdSubordinateDevice {

  private String id;

  private String masterDeviceBo;

  private String assistantDeviceBo;

  private String subordinateType;

  private String reverseField1;

  private String reverseField2;

  private String updatedUser;

  private Date updatedTime;


  public ZdSubordinateDevice() {
  }

  public ZdSubordinateDevice(ZdSubordinateDevice data) {
    this.id = data.id;
    this.masterDeviceBo = data.masterDeviceBo;
    this.assistantDeviceBo = data.assistantDeviceBo;
    this.subordinateType = data.subordinateType;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ZdSubordinateDevice clone() {
    return new ZdSubordinateDevice(this);
  }

  @Override
  public String toString() {
    return this.masterDeviceBo + ", " + this.assistantDeviceBo;
  }
}
