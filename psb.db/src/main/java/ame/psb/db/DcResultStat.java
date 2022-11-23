package ame.psb.db;

import java.math.BigDecimal;

public class DcResultStat {

  private String id;

  private String dcResultBo;

  private String dcParameterBo;

  private String statTarget;

  private String customerItemBo;

  private String groupId;

  private String dcValueType;

  private BigDecimal dcValue;

  public DcResultStat() {
  }

  public DcResultStat(DcResultStat data) {
    this.id = data.id;
    this.dcResultBo = data.dcResultBo;
    this.dcParameterBo = data.dcParameterBo;
    this.statTarget = data.statTarget;
    this.customerItemBo = data.customerItemBo;
    this.groupId = data.groupId;
    this.dcValueType = data.dcValueType;
    this.dcValue = data.dcValue;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDcResultBo() {
    return this.dcResultBo;
  }

  public void setDcResultBo(String dcResultBo) {
    this.dcResultBo = dcResultBo;
  }

  public String getDcParameterBo() {
    return this.dcParameterBo;
  }

  public void setDcParameterBo(String dcParameterBo) {
    this.dcParameterBo = dcParameterBo;
  }

  public String getStatTarget() {
    return this.statTarget;
  }

  public void setStatTarget(String statTarget) {
    this.statTarget = statTarget;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getGroupId() {
    return this.groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getDcValueType() {
    return this.dcValueType;
  }

  public void setDcValueType(String dcValueType) {
    this.dcValueType = dcValueType;
  }

  public BigDecimal getDcValue() {
    return this.dcValue;
  }

  public void setDcValue(BigDecimal dcValue) {
    this.dcValue = dcValue;
  }

  @Override
  public String toString() {
    return this.id;
  }
}
