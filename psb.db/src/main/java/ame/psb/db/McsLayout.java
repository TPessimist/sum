package ame.psb.db;

import java.util.Date;

public class McsLayout {

  private String resourceBo;

  private String nextResourceBo;

  private String bayBo;

  private String comment;

  private String updatedUser;

  private Date updatedTime;


  public McsLayout() {
  }

  public McsLayout(McsLayout data) {
    this.resourceBo = data.resourceBo;
    this.nextResourceBo = data.nextResourceBo;
    this.bayBo = data.bayBo;
    this.comment = data.comment;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getNextResourceBo() {
    return nextResourceBo;
  }

  public void setNextResourceBo(String nextResourceBo) {
    this.nextResourceBo = nextResourceBo;
  }

  public String getBayBo() {
    return bayBo;
  }

  public void setBayBo(String bayBo) {
    this.bayBo = bayBo;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  @Override
  public McsLayout clone() {
    return new McsLayout(this);
  }

  @Override
  public String toString() {
    return this.resourceBo + ", " + this.bayBo;
  }
}
