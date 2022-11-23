package ame.psb.db;

import java.util.Date;

public class StripCoordinateClob {

  private String stripId;

  private String content;

  private String createUser;

  private Date createTime;

  private String physicalWaferId;

  public StripCoordinateClob() {
  }

  public StripCoordinateClob(StripCoordinateClob data) {
    this.stripId = data.stripId;
    this.content = data.content;
    this.createUser = data.createUser;
    this.createTime = data.createTime;
    this.physicalWaferId = data.physicalWaferId;
  }

  public String getStripId() {
    return stripId;
  }

  public void setStripId(String stripId) {
    this.stripId = stripId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public String getPhysicalWaferId() {
    return physicalWaferId;
  }

  public void setPhysicalWaferId(String physicalWaferId) {
    this.physicalWaferId = physicalWaferId;
  }

  @Override
  public StripCoordinateClob clone() {
    return new StripCoordinateClob(this);
  }

  @Override
  public String toString() {
    return this.stripId;
  }
}
