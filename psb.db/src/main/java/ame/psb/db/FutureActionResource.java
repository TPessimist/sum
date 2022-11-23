package ame.psb.db;

import ame.psb.commons.Env;
import javax.persistence.Entity;

@Entity
public class FutureActionResource {

  private String futureActionBo;

  private String resourceBo;

  private String recipeName;

  public FutureActionResource() {
  }

  public FutureActionResource(FutureActionResource data) {
    this.futureActionBo = data.futureActionBo;
    this.resourceBo = data.resourceBo;
    this.recipeName = data.recipeName;
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

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public boolean oneRecipeForAll() {
    String resource = Env.trimHandle(this.resourceBo);
    return "*".equals(resource) || "".equals(resource);
  }

  @Override
  public FutureActionResource clone() {
    return new FutureActionResource(this);
  }

  @Override
  public String toString() {
    return this.futureActionBo + ", " + this.resourceBo;
  }
}