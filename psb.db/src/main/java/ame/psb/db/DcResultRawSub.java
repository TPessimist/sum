package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class DcResultRawSub {

  private String id;

  private String dcResultBo;

  private String dcResultRawBo;

  private String groupId;

  private String dcParameterBo;

  private BigDecimal dcValue;

  private BigDecimal dcValueSub;

  private String dcValueSubResult;

  private String dcSubResultBo;

  private Date dcTime;

  private String customerItemBo;

  private String stateName;


  public DcResultRawSub() {
  }

  public DcResultRawSub(DcResultRawSub data) {
    this.id = data.id;
    this.dcResultBo = data.dcResultBo;
    this.dcResultRawBo = data.dcResultRawBo;
    this.groupId = data.groupId;
    this.dcParameterBo = data.dcParameterBo;
    this.dcValue = data.dcValue;
    this.dcValueSub = data.dcValueSub;
    this.dcValueSubResult = data.dcValueSubResult;
    this.dcSubResultBo = data.dcSubResultBo;
    this.dcTime = data.dcTime;
    this.customerItemBo = data.customerItemBo;
    this.stateName = data.stateName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDcResultBo() {
    return dcResultBo;
  }

  public void setDcResultBo(String dcResultBo) {
    this.dcResultBo = dcResultBo;
  }

  public String getDcResultRawBo() {
    return dcResultRawBo;
  }

  public void setDcResultRawBo(String dcResultRawBo) {
    this.dcResultRawBo = dcResultRawBo;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getDcParameterBo() {
    return dcParameterBo;
  }

  public void setDcParameterBo(String dcParameterBo) {
    this.dcParameterBo = dcParameterBo;
  }

  public BigDecimal getDcValue() {
    return dcValue;
  }

  public void setDcValue(BigDecimal dcValue) {
    this.dcValue = dcValue;
  }

  public BigDecimal getDcValueSub() {
    return dcValueSub;
  }

  public void setDcValueSub(BigDecimal dcValueSub) {
    this.dcValueSub = dcValueSub;
  }

  public String getDcValueSubResult() {
    return dcValueSubResult;
  }

  public void setDcValueSubResult(String dcValueSubResult) {
    this.dcValueSubResult = dcValueSubResult;
  }

  public String getDcSubResultBo() {
    return dcSubResultBo;
  }

  public void setDcSubResultBo(String dcSubResultBo) {
    this.dcSubResultBo = dcSubResultBo;
  }

  public Date getDcTime() {
    return dcTime;
  }

  public void setDcTime(Date dcTime) {
    this.dcTime = dcTime;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public DcResultRawSub clone() {
    return new DcResultRawSub(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
