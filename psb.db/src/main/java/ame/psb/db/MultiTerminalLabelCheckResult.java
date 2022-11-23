package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class MultiTerminalLabelCheckResult {

  private String uuid;

  private String compareContainerBo;

  private String containerBo;

  private String containerName;

  private String containerType;

  private String qrCode;

  private String labelBo;

  private String tagBo;

  private String tagValue;

  private String stateName;

  private String reserveField1;

  private String reserveField2;

  private String updatedUser;

  private Date updatedTime;


  public MultiTerminalLabelCheckResult() {
  }

  public MultiTerminalLabelCheckResult(MultiTerminalLabelCheckResult data) {
    this.uuid = data.uuid;
    this.compareContainerBo = data.compareContainerBo;
    this.containerBo = data.containerBo;
    this.containerName = data.containerName;
    this.containerType = data.containerType;
    this.qrCode = data.qrCode;
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
    this.tagValue = data.tagValue;
    this.stateName = data.stateName;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public MultiTerminalLabelCheckResult clone() {
    return new MultiTerminalLabelCheckResult(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
