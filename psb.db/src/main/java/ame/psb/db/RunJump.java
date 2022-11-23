package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class RunJump {

  private String id;

  private String runSfcBo;

  private String currentStepBo;

  private String nextStepBo;

  private String createUser;

  private Date createTime;

  private String comment;


  public RunJump() {
    this.id = UUID.randomUUID().toString();
    this.createTime = new Date();
  }

  public RunJump(RunJump data) {
    this.id = data.id;
    this.runSfcBo = data.runSfcBo;
    this.currentStepBo = data.currentStepBo;
    this.nextStepBo = data.nextStepBo;
    this.createUser = data.createUser;
    this.createTime = data.createTime;
  }

  @Override
  public RunJump clone() {
    return new RunJump(this);
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

  public String getRunSfcBo() {
    return this.runSfcBo;
  }

  public void setRunSfcBo(String runSfcBo) {
    this.runSfcBo = runSfcBo;
  }

  public String getCurrentStepBo() {
    return this.currentStepBo;
  }

  public void setCurrentStepBo(String currentStepBo) {
    this.currentStepBo = currentStepBo;
  }

  public String getNextStepBo() {
    return this.nextStepBo;
  }

  public void setNextStepBo(String nextStepBo) {
    this.nextStepBo = nextStepBo;
  }

  public String getCreateUser() {
    return this.createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}