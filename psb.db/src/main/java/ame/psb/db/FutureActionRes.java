package ame.psb.db;

import ame.psb.commons.Env;

public class FutureActionRes {

  private String futureActionBo;

  private String resourceBo;

  public FutureActionRes() {
  }

  public FutureActionRes(FutureActionRes data) {
    this.futureActionBo = data.futureActionBo;
    this.resourceBo = data.resourceBo;

  }

  public String getFutureActionBo() {
    return this.futureActionBo;
  }

  public void setFutureActionBo(String futureActionBo) {
    this.futureActionBo = futureActionBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }


  public boolean oneRecipeForAll() {
    String resource = Env.trimHandle(this.resourceBo);
    return "*".equals(resource) || "".equals(resource);
  }

}
