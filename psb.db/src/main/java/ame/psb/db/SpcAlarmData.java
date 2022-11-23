package ame.psb.db;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class SpcAlarmData {

  private String idMaster;

  private String id;

  private String sfc;

  private String deviceName;

  private String operationBo;

  private String parameterName;

  private String rulename;

  private String description;

  private BigDecimal dcPosition;

  private BigDecimal usl;

  private BigDecimal lsl;

  private BigDecimal ucl;

  private BigDecimal lcl;

  private BigDecimal dcValue;

  private Date createdDateTime;


  public SpcAlarmData() {
  }

  public SpcAlarmData(SpcAlarmData data) {
    this.idMaster = data.idMaster;
    this.id = data.id;
    this.sfc = data.sfc;
    this.deviceName = data.deviceName;
    this.operationBo = data.operationBo;
    this.parameterName = data.parameterName;
    this.rulename = data.rulename;
    this.description = data.description;
    this.dcPosition = data.dcPosition;
    this.usl = data.usl;
    this.lsl = data.lsl;
    this.ucl = data.ucl;
    this.lcl = data.lcl;
    this.dcValue = data.dcValue;
    this.createdDateTime = data.createdDateTime;
  }

  @Override
  public SpcAlarmData clone() {
    return new SpcAlarmData(this);
  }

  @Override
  public String toString() {
    return this.id + ", " + this.rulename;
  }

  public String getIdMaster() {
    return idMaster;
  }

  public void setIdMaster(String idMaster) {
    this.idMaster = idMaster;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getRulename() {
    return rulename;
  }

  public void setRulename(String rulename) {
    this.rulename = rulename;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getDcPosition() {
    return dcPosition;
  }

  public void setDcPosition(BigDecimal dcPosition) {
    this.dcPosition = dcPosition;
  }

  public BigDecimal getUsl() {
    return usl;
  }

  public void setUsl(BigDecimal usl) {
    this.usl = usl;
  }

  public BigDecimal getLsl() {
    return lsl;
  }

  public void setLsl(BigDecimal lsl) {
    this.lsl = lsl;
  }

  public BigDecimal getUcl() {
    return ucl;
  }

  public void setUcl(BigDecimal ucl) {
    this.ucl = ucl;
  }

  public BigDecimal getLcl() {
    return lcl;
  }

  public void setLcl(BigDecimal lcl) {
    this.lcl = lcl;
  }

  public BigDecimal getDcValue() {
    return dcValue;
  }

  public void setDcValue(BigDecimal dcValue) {
    this.dcValue = dcValue;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public boolean isControlAlramData() {
    String[] controlRuleNames = {"Specification limits", "Western Electric Rule #1"
        //,"Western Electric Rule #3","Western Electric Rule #4"
    };
    return Arrays.asList(controlRuleNames).contains(this.rulename);
  }

}
