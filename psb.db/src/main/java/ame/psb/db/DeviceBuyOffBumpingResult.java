package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class DeviceBuyOffBumpingResult {

  private String id;

  private String itemGroupBo;

  private String opertionBo;

  private String sfcBo;

  private String dcopGroupBo;

  private String dcopValue;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public DeviceBuyOffBumpingResult() {
  }

  public DeviceBuyOffBumpingResult(DeviceBuyOffBumpingResult data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.opertionBo = data.opertionBo;
    this.sfcBo = data.sfcBo;
    this.dcopGroupBo = data.dcopGroupBo;
    this.dcopValue = data.dcopValue;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public DeviceBuyOffBumpingResult clone() {
    return new DeviceBuyOffBumpingResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
