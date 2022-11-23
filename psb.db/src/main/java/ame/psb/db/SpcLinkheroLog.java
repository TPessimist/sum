package ame.psb.db;

import java.util.Date;

public class SpcLinkheroLog {

  private String id;

  private String resultsize;

  private String memo;

  private Date watchTime;

  private String watchUser;


  public SpcLinkheroLog() {
  }

  public SpcLinkheroLog(SpcLinkheroLog data) {
    this.id = data.id;
    this.resultsize = data.resultsize;
    this.memo = data.memo;
    this.watchTime = data.watchTime;
    this.watchUser = data.watchUser;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResultsize() {
    return resultsize;
  }

  public void setResultsize(String resultsize) {
    this.resultsize = resultsize;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Date getWatchTime() {
    return watchTime;
  }

  public void setWatchTime(Date watchTime) {
    this.watchTime = watchTime;
  }

  public String getWatchUser() {
    return watchUser;
  }

  public void setWatchUser(String watchUser) {
    this.watchUser = watchUser;
  }

  @Override
  public SpcLinkheroLog clone() {
    return new SpcLinkheroLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
