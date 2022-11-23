package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewItemOperation extends ItemOperation {

  private String operation;

  private String item;

  private String routerBo;

  private String router;

  private String operationType;

  private String recipeType;

  private String cycleTimeType;


  public ViewItemOperation() {
  }

  public ViewItemOperation(boolean newData) {
    super(newData);
  }

  public String getOperation() {
    return this.operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getOperationType() {
    return this.operationType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public String getRecipeType() {
    return this.recipeType;
  }

  public void setRecipeType(String recipeType) {
    this.recipeType = recipeType;
  }

  public String getCycleTimeType() {
    return this.cycleTimeType;
  }

  public void setCycleTimeType(String cycleTimeType) {
    this.cycleTimeType = cycleTimeType;
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRouter() {
    return this.router;
  }

  public void setRouter(String router) {
    this.router = router;
  }


}
