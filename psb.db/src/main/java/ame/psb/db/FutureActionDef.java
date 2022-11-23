package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class FutureActionDef {

  private String actionName;

  private String configGroup;

  private String oa;

  private String oaHandle;

  private String oaHoldCode;

  private String oaHoldComments;

  private String oaHoldRelease;

  public String getActionName() {
    return this.actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getConfigGroup() {
    return this.configGroup;
  }

  public void setConfigGroup(String configGroup) {
    this.configGroup = configGroup;
  }

  public String getOa() {
    return this.oa;
  }

  public void setOa(String oa) {
    this.oa = oa;
  }

  public String getOaHandle() {
    return this.oaHandle;
  }

  public void setOaHandle(String oaHandle) {
    this.oaHandle = oaHandle;
  }

  public String getOaHoldCode() {
    return this.oaHoldCode;
  }

  public void setOaHoldCode(String oaHoldCode) {
    this.oaHoldCode = oaHoldCode;
  }

  public String getOaHoldComments() {
    return this.oaHoldComments;
  }

  public void setOaHoldComments(String oaHoldComments) {
    this.oaHoldComments = oaHoldComments;
  }

  public String getOaHoldRelease() {
    return this.oaHoldRelease;
  }

  public void setOaHoldRelease(String oaHoldRelease) {
    this.oaHoldRelease = oaHoldRelease;
  }

  @Override
  public String toString() {
    return this.actionName + "," + this.configGroup;
  }
}
