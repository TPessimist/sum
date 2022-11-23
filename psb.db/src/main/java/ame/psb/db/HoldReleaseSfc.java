package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class HoldReleaseSfc {

  private String holdReleaseBo;

  private String sfcBo;

  private String actionName;

  private String resultRouterBo;

  public String getHoldReleaseBo() {
    return this.holdReleaseBo;
  }

  public void setHoldReleaseBo(String holdReleaseBo) {
    this.holdReleaseBo = holdReleaseBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getActionName() {
    return this.actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getResultRouterBo() {
    return this.resultRouterBo;
  }

  public void setResultRouterBo(String resultRouterBo) {
    this.resultRouterBo = resultRouterBo;
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }
}