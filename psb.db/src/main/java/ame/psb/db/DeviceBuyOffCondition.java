package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class DeviceBuyOffCondition {

  private String id;

  private String itemGroupBo;

  private String operationBo;

  private String sfcType;

  private BigDecimal sfcQty;

  private String stateName;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public DeviceBuyOffCondition() {
  }

  public DeviceBuyOffCondition(DeviceBuyOffCondition data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.sfcType = data.sfcType;
    this.sfcQty = data.sfcQty;
    this.stateName = data.stateName;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public DeviceBuyOffCondition clone() {
    return new DeviceBuyOffCondition(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
