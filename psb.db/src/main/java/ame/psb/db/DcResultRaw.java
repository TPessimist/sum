package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class DcResultRaw {

  private String id;

  private String dcResultBo;

  private String groupId;

  private String dcParameterBo;

  private BigDecimal dcValue;

  private Date dcTime;

  private String customerItemBo;

  private String stateName;

  private String dcValueText;

  private String dcValuestate;

  private String latestFlag;

  public String getLatestFlag() {
    return latestFlag;
  }

  public void setLatestFlag(String latestFlag) {
    this.latestFlag = latestFlag;
  }

  public String getDcValuestate() {
    return dcValuestate;
  }

  public void setDcValuestate(String dcValuestate) {
    this.dcValuestate = dcValuestate;
  }

  public DcResultRaw() {
    this.id = UUID.randomUUID().toString();
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

  public String getGroupId() {
    return this.groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getDcParameterBo() {
    return this.dcParameterBo;
  }

  public void setDcParameterBo(String dcParameterBo) {
    this.dcParameterBo = dcParameterBo;
  }

  public BigDecimal getDcValue() {
    return this.dcValue;
  }

  public void setDcValue(BigDecimal dcValue) {
    this.dcValue = dcValue;
  }

  public Date getDcTime() {
    return this.dcTime;
  }

  public void setDcTime(Date dcTime) {
    this.dcTime = dcTime;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getDcValueText() {
    return dcValueText;
  }

  public void setDcValueText(String dcValueText) {
    this.dcValueText = dcValueText;
  }

  @Override
  public String toString() {
    return this.id;
  }
}