package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class FOUPInsertBinding {

  private String id;

  private String foupId;

  private String foupInsertId;

  private String flag;

  private String createdUser;

  private Date createdTime;

  private String updatedUser;

  private Date updatedTime;


  public FOUPInsertBinding() {
    this.id = UUID.randomUUID().toString();
  }

  public FOUPInsertBinding(FOUPInsertBinding data) {
    this.id = data.id;
    this.foupId = data.foupId;
    this.foupInsertId = data.foupInsertId;
    this.flag = data.flag;
    this.createdUser = data.createdUser;
    this.createdTime = data.createdTime;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public FOUPInsertBinding clone() {
    return new FOUPInsertBinding(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFoupId() {
    return this.foupId;
  }

  public void setFoupId(String foupId) {
    this.foupId = foupId;
  }

  public String getFoupInsertId() {
    return this.foupInsertId;
  }

  public void setFoupInsertId(String foupInsertId) {
    this.foupInsertId = foupInsertId;
  }

  public String getFlag() {
    return this.flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
