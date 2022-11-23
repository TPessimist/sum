package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class DeviceBuyOffWLPResult {

  private String id;

  private String itemGroupBo;

  private String opertionBo;

  private String sfcBo;

  private String paramBo;

  private String paramValue;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;

  private String npiPosition;

  private String pePosition;


  public DeviceBuyOffWLPResult() {
  }

  public DeviceBuyOffWLPResult(DeviceBuyOffWLPResult data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.opertionBo = data.opertionBo;
    this.sfcBo = data.sfcBo;
    this.paramBo = data.paramBo;
    this.paramValue = data.paramValue;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.npiPosition = data.npiPosition;
    this.pePosition = data.pePosition;
  }

  @Override
  public DeviceBuyOffWLPResult clone() {
    return new DeviceBuyOffWLPResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
