package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class LabelTagContent {

  private String uuid;

  private String containerBo;

  private String labelBo;

  private String tagBo;

  private String tagValue;

  private String tagType;

  private BigDecimal printQty;

  private String reserveField1;

  private String reserveField2;

  private String updatedUser;

  private Date updatedTime;

  private boolean scanned;

  private String containerName;

  public LabelTagContent() {
  }

  public LabelTagContent(LabelTagContent data) {
    this.uuid = data.uuid;
    this.containerBo = data.containerBo;
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
    this.tagValue = data.tagValue;
    this.tagType = data.tagType;
    this.printQty = data.printQty;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public LabelTagContent clone() {
    return new LabelTagContent(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
