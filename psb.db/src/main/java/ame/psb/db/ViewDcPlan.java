package ame.psb.db;

import java.math.BigDecimal;

public class ViewDcPlan extends DcPlan {

  private String dcGroupBo;

  private BigDecimal dcCount;

  private BigDecimal dieCount;

  private String itemGroupBo;

  private String dcGroup;

  private String dcGroupRevision;

  private String description;

  private String resourceName;

  private String holdResourceName;

  public String getDcGroupBo() {
    return this.dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public BigDecimal getDcCount() {
    return this.dcCount;
  }

  public void setDcCount(BigDecimal dcCount) {
    this.dcCount = dcCount;
  }

  public BigDecimal getDieCount() {
    return this.dieCount;
  }

  public void setDieCount(BigDecimal dieCount) {
    this.dieCount = dieCount;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getDcGroup() {
    return this.dcGroup;
  }

  public void setDcGroup(String dcGroup) {
    this.dcGroup = dcGroup;
  }

  public String getDcGroupRevision() {
    return this.dcGroupRevision;
  }

  public void setDcGroupRevision(String dcGroupRevision) {
    this.dcGroupRevision = dcGroupRevision;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getHoldResourceName() {
    return this.holdResourceName;
  }

  public void setHoldResourceName(String holdResourceName) {
    this.holdResourceName = holdResourceName;
  }

}
