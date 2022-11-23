package ame.psb.db;

import java.util.Date;

public class WaferMembranceType {

  private String id;
  private String typeName;
  private Integer holdDay;
  private Integer aheadDay;
  private String mailTo;
  private Date createdTime;
  private Date updatedTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public Integer getHoldDay() {
    return holdDay;
  }

  public void setHoldDay(Integer holdDay) {
    this.holdDay = holdDay;
  }

  public String getMailTo() {
    return mailTo;
  }

  public void setMailTo(String mailTo) {
    this.mailTo = mailTo;
  }

  public Integer getAheadDay() {
    return aheadDay;
  }

  public void setAheadDay(Integer aheadDay) {
    this.aheadDay = aheadDay;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
