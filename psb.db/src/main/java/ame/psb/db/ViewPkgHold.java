package ame.psb.db;

import java.util.Date;

public class ViewPkgHold extends PkgHoldDetail {

  private String holdId;

  private String userBo;

  private Date dateTime;

  private String comments;

  public String getHoldId() {
    return holdId;
  }

  public void setHoldId(String holdId) {
    this.holdId = holdId;
  }

  public String getUserBo() {
    return userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}
