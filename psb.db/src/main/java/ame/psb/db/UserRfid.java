package ame.psb.db;

import java.util.Date;

public class UserRfid {

  private String rfId;

  private String userId;

  private String value;

  private String content;

  private Date updatedTime;


  public UserRfid() {
  }

  public UserRfid(UserRfid data) {
    this.rfId = data.rfId;
    this.userId = data.userId;
    this.value = data.value;
    this.content = data.content;
    this.updatedTime = data.updatedTime;
  }

  public String getRfId() {
    return rfId;
  }

  public void setRfId(String rfId) {
    this.rfId = rfId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public UserRfid clone() {
    return new UserRfid(this);
  }

  @Override
  public String toString() {
    return this.rfId;
  }
}
