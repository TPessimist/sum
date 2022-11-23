package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewSpcResult {

  private String ids;

  private String sfcBo;

  private String sfcName;

  private String customerItemsetBo;

  private String customerItemsetName;

  private String itemBo;

  private String itemName;

  private String deviceBo;

  private String deviceName;

  private String packageBo;

  private String packageName;

  private String dcResultBo;

  private Date dcTime;

  private String resourceBo;

  private String operationBo;

  private String dcDcopBo;

  private String stateName;

  private String id;

  private BigDecimal groupId;

  private String customerItemBo;

  private BigDecimal dcValue;

  private String dcParameterBo;

  private String dcGroupBo;

  private String dcGroup;

  private String parameterName;

  private BigDecimal warnUcl;

  private BigDecimal warnLcl;

  private BigDecimal alarmUcl;

  private BigDecimal alarmLcl;

  private BigDecimal targetValue;

  private String valueState;


  public ViewSpcResult() {
  }


  public ViewSpcResult(ViewSpcResult data) {
    this.ids = data.ids;
    this.sfcBo = data.sfcBo;
    this.sfcName = data.sfcName;
    this.customerItemsetBo = data.customerItemsetBo;
    this.customerItemsetName = data.customerItemsetName;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
    this.deviceBo = data.deviceBo;
    this.deviceName = data.deviceName;
    this.packageBo = data.packageBo;
    this.packageName = data.packageName;
    this.dcResultBo = data.dcResultBo;
    this.dcTime = data.dcTime;
    this.resourceBo = data.resourceBo;
    this.operationBo = data.operationBo;
    this.dcDcopBo = data.dcDcopBo;
    this.stateName = data.stateName;
    this.id = data.id;
    this.groupId = data.groupId;
    this.customerItemBo = data.customerItemBo;
    this.dcValue = data.dcValue;
    this.dcParameterBo = data.dcParameterBo;
    this.dcGroupBo = data.dcGroupBo;
    this.dcGroup = data.dcGroup;
    this.parameterName = data.parameterName;
    this.warnUcl = data.warnUcl;
    this.warnLcl = data.warnLcl;
    this.alarmUcl = data.alarmUcl;
    this.alarmLcl = data.alarmLcl;
    this.targetValue = data.targetValue;
    this.valueState = data.valueState;
  }

  public String getIds() {
    return ids;
  }

  public void setIds(String ids) {
    this.ids = ids;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getCustomerItemsetBo() {
    return customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPackageBo() {
    return packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getDcResultBo() {
    return dcResultBo;
  }

  public void setDcResultBo(String dcResultBo) {
    this.dcResultBo = dcResultBo;
  }

  public Date getDcTime() {
    return dcTime;
  }

  public void setDcTime(Date dcTime) {
    this.dcTime = dcTime;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDcDcopBo() {
    return dcDcopBo;
  }

  public void setDcDcopBo(String dcDcopBo) {
    this.dcDcopBo = dcDcopBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BigDecimal getGroupId() {
    return groupId;
  }

  public void setGroupId(BigDecimal groupId) {
    this.groupId = groupId;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public BigDecimal getDcValue() {
    return dcValue;
  }

  public void setDcValue(BigDecimal dcValue) {
    this.dcValue = dcValue;
  }

  public Double getDoubleDcValue() {
    return dcValue.doubleValue();
  }

  public String getDcParameterBo() {
    return dcParameterBo;
  }

  public void setDcParameterBo(String dcParameterBo) {
    this.dcParameterBo = dcParameterBo;
  }

  public String getDcGroupBo() {
    return dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public String getDcGroup() {
    return dcGroup;
  }

  public void setDcGroup(String dcGroup) {
    this.dcGroup = dcGroup;
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public BigDecimal getWarnUcl() {
    return warnUcl;
  }

  public void setWarnUcl(BigDecimal warnUcl) {
    this.warnUcl = warnUcl;
  }

  public BigDecimal getWarnLcl() {
    return warnLcl;
  }

  public void setWarnLcl(BigDecimal warnLcl) {
    this.warnLcl = warnLcl;
  }

  public BigDecimal getAlarmUcl() {
    return alarmUcl;
  }

  public void setAlarmUcl(BigDecimal alarmUcl) {
    this.alarmUcl = alarmUcl;
  }

  public BigDecimal getAlarmLcl() {
    return alarmLcl;
  }

  public void setAlarmLcl(BigDecimal alarmLcl) {
    this.alarmLcl = alarmLcl;
  }

  public BigDecimal getTargetValue() {
    return targetValue;
  }

  public void setTargetValue(BigDecimal targetValue) {
    this.targetValue = targetValue;
  }

  public String getValueState() {
    return valueState;
  }

  public void setValueState(String valueState) {
    this.valueState = valueState;
  }

  @Override
  public ViewSpcResult clone() {
    return new ViewSpcResult(this);
  }

  @Override
  public String toString() {
    return this.ids;
  }
}
