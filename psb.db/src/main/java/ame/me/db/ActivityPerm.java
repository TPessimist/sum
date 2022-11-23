package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityPerm {

  private String handle;

  private BigDecimal changeStamp;

  private String userOrGroupGbo;

  private String activityOrGroupGbo;

  private Date createdDateTime;

  private Date modifiedDateTime;

  public ActivityPerm() {
  }

  public ActivityPerm(ActivityPerm data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.userOrGroupGbo = data.userOrGroupGbo;
    this.activityOrGroupGbo = data.activityOrGroupGbo;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public ActivityPerm clone() {
    return new ActivityPerm(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return this.changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getUserOrGroupGbo() {
    return this.userOrGroupGbo;
  }

  public void setUserOrGroupGbo(String userOrGroupGbo) {
    this.userOrGroupGbo = userOrGroupGbo;
  }

  public String getActivityOrGroupGbo() {
    return this.activityOrGroupGbo;
  }

  public void setActivityOrGroupGbo(String activityOrGroupGbo) {
    this.activityOrGroupGbo = activityOrGroupGbo;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

}
