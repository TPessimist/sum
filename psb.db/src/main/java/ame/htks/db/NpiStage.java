package ame.htks.db;

import java.util.Date;

public class NpiStage {

  private String handle;

  private String stage;

  private String description;

  private String stageOperations;

  private String updatedUser;

  private Date updatedTime;


  public NpiStage() {
  }

  public NpiStage(NpiStage data) {
    this.handle = data.handle;
    this.stage = data.stage;
    this.description = data.description;
    this.stageOperations = data.stageOperations;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public NpiStage clone() {
    return new NpiStage(this);
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

  public String getStage() {
    return this.stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStageOperations() {
    return this.stageOperations;
  }

  public void setStageOperations(String stageOperations) {
    this.stageOperations = stageOperations;
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
