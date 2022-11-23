package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class ZdConvertTsk {

  private String id;

  private String deviceBo;

  private String convertType;

  private String combineOperationBo;

  private String fromOperationBo;

  private String useOperationBo;

  private String templateId;

  private Date updatedTime;

  private String updatedUser;


  public ZdConvertTsk() {
    this.id = UUID.randomUUID().toString();
  }

  public ZdConvertTsk(ZdConvertTsk data) {
    this.id = data.getId();
    this.deviceBo = data.getDeviceBo();
    this.convertType = data.getConvertType();
    this.combineOperationBo = data.getCombineOperationBo();
    this.fromOperationBo = data.getFromOperationBo();
    this.useOperationBo = data.getUseOperationBo();
    this.templateId = data.getTemplateId();
    this.updatedTime = data.getUpdatedTime();
    this.updatedUser = data.getUpdatedUser();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getConvertType() {
    return convertType;
  }

  public void setConvertType(String convertType) {
    this.convertType = convertType;
  }

  public String getCombineOperationBo() {
    return combineOperationBo;
  }

  public void setCombineOperationBo(String combineOperationBo) {
    this.combineOperationBo = combineOperationBo;
  }

  public String getFromOperationBo() {
    return fromOperationBo;
  }

  public void setFromOperationBo(String fromOperationBo) {
    this.fromOperationBo = fromOperationBo;
  }

  public String getUseOperationBo() {
    return useOperationBo;
  }

  public void setUseOperationBo(String useOperationBo) {
    this.useOperationBo = useOperationBo;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  @Override
  public ZdConvertTsk clone() {
    return new ZdConvertTsk(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
