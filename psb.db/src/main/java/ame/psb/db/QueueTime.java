package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class QueueTime {

  private String id;

  private String itemGroupBo;

  private String itemBo;

  private String beginOperationBo;

  private String beginType;

  private String endOperationBo;

  private String endType;

  private Integer minTime;

  private Integer maxTime;

  private String packageBo;

  private String status;

  private String updatedUser;

  private Date updatedTime;

  public QueueTime() {
    this.id = UUID.randomUUID().toString();
    this.status = "Y";
  }

  public QueueTime(String itemGroupBo, String itemBo, String beginOperationBo, String beginType,
      String endOperationBo, String endType, int minTime, int maxTime) {
    this.id = UUID.randomUUID().toString();
    this.itemGroupBo = itemGroupBo;
    this.itemBo = itemBo;
    this.beginOperationBo = beginOperationBo;
    this.beginType = beginType;
    this.endOperationBo = endOperationBo;
    this.endType = endType;
    this.minTime = minTime;
    this.maxTime = maxTime;
    this.status = "Y";
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getBeginOperationBo() {
    return this.beginOperationBo;
  }

  public void setBeginOperationBo(String beginOperationBo) {
    this.beginOperationBo = beginOperationBo;
  }

  public String getBeginType() {
    return this.beginType;
  }

  public void setBeginType(String beginType) {
    this.beginType = beginType;
  }

  public String getEndOperationBo() {
    return this.endOperationBo;
  }

  public void setEndOperationBo(String endOperationBo) {
    this.endOperationBo = endOperationBo;
  }

  public String getEndType() {
    return this.endType;
  }

  public void setEndType(String endType) {
    this.endType = endType;
  }

  public Integer getMinTime() {
    return this.minTime;
  }

  public void setMinTime(Integer minTime) {
    this.minTime = minTime;
  }

  public Integer getMaxTime() {
    return this.maxTime;
  }

  public void setMaxTime(Integer maxTime) {
    this.maxTime = maxTime;
  }

  public String getPackageBo() {
    return this.packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String monitorKey() {
    return String.format("%s_%s_%s_%s", this.beginOperationBo, this.beginType, this.endOperationBo,
        this.endType);
  }

  @Override
  public String toString() {
    return String.format("%s> %s, from %s(%s) to %s(%s), queueTime:%s~%s",
        this.status,
        this.id,
        this.beginOperationBo,
        this.beginType,
        this.endOperationBo,
        this.endType,
        this.minTime,
        this.maxTime);
  }

}
