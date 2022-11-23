package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class LabelBuyoffLog extends LabelBuyOff {

  private String uuid;

  private String updatedUser;

  private Date updatedTime;


  public LabelBuyoffLog() {
  }

  public LabelBuyoffLog(LabelBuyoffLog data) {
    this.uuid = data.uuid;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public LabelBuyoffLog(LabelBuyOff data, String updatedUser) {
    super(data);
    this.uuid = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.updatedTime = new Date();
    this.updatedUser = updatedUser;
  }

  @Override
  public LabelBuyoffLog clone() {
    return new LabelBuyoffLog(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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
