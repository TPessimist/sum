package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class MultiTerminalLabelCheckRule {

  private String itemGroupBo;

  private String containerType;

  private String terminalName;

  private String labelBo;

  private String tagBo;

  private String tagType;

  private String tagOrder;

  private String requireInOrder;

  private String reserveField1;

  private String reserveField2;

  private String updatedUser;

  private Date updatedTime;


  public MultiTerminalLabelCheckRule() {
  }

  public MultiTerminalLabelCheckRule(MultiTerminalLabelCheckRule data) {
    this.itemGroupBo = data.itemGroupBo;
    this.containerType = data.containerType;
    this.terminalName = data.terminalName;
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
    this.tagType = data.tagType;
    this.tagOrder = data.tagOrder;
    this.requireInOrder = data.requireInOrder;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public MultiTerminalLabelCheckRule clone() {
    return new MultiTerminalLabelCheckRule(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.containerType + ", " + this.terminalName + ", "
        + this.labelBo + ", " + this.tagBo;
  }

}
