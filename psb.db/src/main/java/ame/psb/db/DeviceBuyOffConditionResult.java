package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class DeviceBuyOffConditionResult {

  private String conditionBo;

  private String sfcBo;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public DeviceBuyOffConditionResult() {
  }

  public DeviceBuyOffConditionResult(DeviceBuyOffConditionResult data) {
    this.conditionBo = data.conditionBo;
    this.sfcBo = data.sfcBo;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public DeviceBuyOffConditionResult clone() {
    return new DeviceBuyOffConditionResult(this);
  }

  @Override
  public String toString() {
    return this.conditionBo + ", " + this.sfcBo;
  }
}
