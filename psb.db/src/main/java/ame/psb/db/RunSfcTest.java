package ame.psb.db;

import java.util.Date;

public class RunSfcTest {

  private String sfcStepBo;

  private String sfcBo;

  private String resourceBo;

  private String testerId;

  private String operationBo;

  private String updatedUser;

  private Date updatedTime;

  private String runSfcBo;

  private String testerRecipe;

  public RunSfcTest() {
  }

  public RunSfcTest(RunSfcTest data) {
    this.sfcStepBo = data.sfcStepBo;
    this.sfcBo = data.sfcBo;
    this.resourceBo = data.resourceBo;
    this.testerId = data.testerId;
    this.operationBo = data.operationBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.runSfcBo = data.runSfcBo;
    this.testerRecipe = data.testerRecipe;
  }

  public String getSfcStepBo() {
    return sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getTesterId() {
    return testerId;
  }

  public void setTesterId(String testerId) {
    this.testerId = testerId;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
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

  public String getRunSfcBo() {
    return runSfcBo;
  }

  public void setRunSfcBo(String runSfcBo) {
    this.runSfcBo = runSfcBo;
  }

  public String getTesterRecipe() {
    return testerRecipe;
  }

  public void setTesterRecipe(String testerRecipe) {
    this.testerRecipe = testerRecipe;
  }

  @Override
  public String toString() {
    return this.sfcStepBo;
  }
}
