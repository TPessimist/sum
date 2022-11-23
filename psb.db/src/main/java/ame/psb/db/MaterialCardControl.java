package ame.psb.db;

import java.util.Date;

public class MaterialCardControl {

  private String id;

  private String resourceBo;

  private String itemBo;

  private String type;

  private String state;

  private String updatedUser;

  private Date updatedTime;

  private String reverseField1;

  private String reverseField2;


  public MaterialCardControl() {
  }

  public MaterialCardControl(MaterialCardControl data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.type = data.type;
    this.state = data.state;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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

  public String getReverseField1() {
    return reverseField1;
  }

  public void setReverseField1(String reverseField1) {
    this.reverseField1 = reverseField1;
  }

  public String getReverseField2() {
    return reverseField2;
  }

  public void setReverseField2(String reverseField2) {
    this.reverseField2 = reverseField2;
  }

  @Override
  public MaterialCardControl clone() {
    return new MaterialCardControl(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
