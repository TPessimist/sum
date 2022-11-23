package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SpcLog {

  private String id;

  private String sfcBos;

  private String deviceName;

  private String operationBo;

  private String dcGroup;

  private String parameterName;

  private String displayTemplate;

  private String queryTemplate;

  private String message;

  private Date createDateTime;

  public SpcLog() {
    this.id = UUID.randomUUID().toString();
    this.createDateTime = new Date();
  }

  public SpcLog(SpcLog data) {
    this.id = data.id;
    this.sfcBos = data.sfcBos;
    this.deviceName = data.deviceName;
    this.operationBo = data.operationBo;
    this.dcGroup = data.dcGroup;
    this.parameterName = data.parameterName;
    this.displayTemplate = data.displayTemplate;
    this.queryTemplate = data.queryTemplate;
    this.message = data.message;
    this.createDateTime = data.createDateTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBos() {
    return this.sfcBos;
  }

  public void setSfcBos(String sfcBos) {
    this.sfcBos = sfcBos;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDcGroup() {
    return this.dcGroup;
  }

  public void setDcGroup(String dcGroup) {
    this.dcGroup = dcGroup;
  }

  public String getParameterName() {
    return this.parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getDisplayTemplate() {
    return this.displayTemplate;
  }

  public void setDisplayTemplate(String displayTemplate) {
    this.displayTemplate = displayTemplate;
  }

  public String getQueryTemplate() {
    return this.queryTemplate;
  }

  public void setQueryTemplate(String queryTemplate) {
    this.queryTemplate = queryTemplate;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getCreateDateTime() {
    return this.createDateTime;
  }

  public void setCreateDateTime(Date createDateTime) {
    this.createDateTime = createDateTime;
  }

  @Override
  public SpcLog clone() {
    return new SpcLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
