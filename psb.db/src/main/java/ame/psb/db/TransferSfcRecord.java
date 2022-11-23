package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class TransferSfcRecord {

  private String id;

  private String sfcBo;

  private String area;

  private String userId;

  private int itemQty;

  private String operationBo;

  private Date createdTime;

  private String createdUser;


  public TransferSfcRecord() {
    this.id = UUID.randomUUID().toString();
  }

  public TransferSfcRecord(TransferSfcRecord data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.area = data.area;
    this.userId = data.userId;
    this.operationBo = data.operationBo;
    this.createdTime = data.createdTime;
    this.createdUser = data.createdUser;
  }

  @Override
  public TransferSfcRecord clone() {
    return new TransferSfcRecord(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getArea() {
    return this.area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public int getItemQty() {
    return this.itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }
}
