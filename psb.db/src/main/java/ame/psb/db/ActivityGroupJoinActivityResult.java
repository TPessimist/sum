package ame.psb.db;

import java.util.Date;

public class ActivityGroupJoinActivityResult {

  private String handle;

  private String description;

  private String activityGroupBo;

  private Date crateDateTime;

  private Date modifiedDateTime;

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getActivityGroupBo() {
    return activityGroupBo;
  }

  public void setActivityGroupBo(String activityGroupBo) {
    this.activityGroupBo = activityGroupBo;
  }

  public Date getCrateDateTime() {
    return crateDateTime;
  }

  public void setCrateDateTime(Date crateDateTime) {
    this.crateDateTime = crateDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }


  @Override
  public String toString() {
    return "ActivityGroupJoinActivityResult{" +
        "description='" + description + '\'' +
        ", activityGroupBo='" + activityGroupBo + '\'' +
        ", crateDateTime=" + crateDateTime +
        ", modifiedDateTime=" + modifiedDateTime +
        '}';
  }
}
