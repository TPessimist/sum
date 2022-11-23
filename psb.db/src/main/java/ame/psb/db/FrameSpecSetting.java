package ame.psb.db;

import java.util.Date;

public class FrameSpecSetting {

  private String id;

  private String itemBo;

  private String item;

  private String itemRevision;

  private String quantity;

  private String frameModel;

  private String frameSpec;

  private String compensationValue;

  private String createUser;

  private Date createTime;

  private String updatedUser;

  private Date updatedTime;


  public FrameSpecSetting() {
  }

  public FrameSpecSetting(FrameSpecSetting data) {
    this.id = data.id;
    this.itemBo = data.itemBo;
    this.item = data.item;
    this.itemRevision = data.itemRevision;
    this.quantity = data.quantity;
    this.frameModel = data.frameModel;
    this.frameSpec = data.frameSpec;
    this.compensationValue = data.compensationValue;
    this.createUser = data.createUser;
    this.createTime = data.createTime;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public FrameSpecSetting clone() {
    return new FrameSpecSetting(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getItemRevision() {
    return itemRevision;
  }

  public void setItemRevision(String itemRevision) {
    this.itemRevision = itemRevision;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getFrameModel() {
    return frameModel;
  }

  public void setFrameModel(String frameModel) {
    this.frameModel = frameModel;
  }

  public String getFrameSpec() {
    return frameSpec;
  }

  public void setFrameSpec(String frameSpec) {
    this.frameSpec = frameSpec;
  }

  public String getCompensationValue() {
    return compensationValue;
  }

  public void setCompensationValue(String compensationValue) {
    this.compensationValue = compensationValue;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
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

}
