package ame.psb.db;

import java.util.Date;

public class McsInOut {

  private String resourceBo;

  private String nextResourceBo;

  private String bayBo;

  private String comment;

  private Date updatedTime;

  private String updatedUser;

  private String restype;

  private String inOut;


  public McsInOut() {
  }

  public McsInOut(McsInOut data) {
    this.resourceBo = data.resourceBo;
    this.nextResourceBo = data.nextResourceBo;
    this.bayBo = data.bayBo;
    this.comment = data.comment;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
    this.restype = data.restype;
    this.inOut = data.inOut;
  }

  @Override
  public McsInOut clone() {
    return new McsInOut(this);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getNextResourceBo() {
    return this.nextResourceBo;
  }

  public void setNextResourceBo(String nextResourceBo) {
    this.nextResourceBo = nextResourceBo;
  }

  public String getBayBo() {
    return this.bayBo;
  }

  public void setBayBo(String bayBo) {
    this.bayBo = bayBo;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public String getRestype() {
    return this.restype;
  }

  public void setRestype(String restype) {
    this.restype = restype;
  }

  public String getInOut() {
    return this.inOut;
  }

  public void setInOut(String inOut) {
    this.inOut = inOut;
  }
}
