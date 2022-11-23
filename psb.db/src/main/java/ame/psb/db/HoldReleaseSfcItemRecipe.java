package ame.psb.db;


public class HoldReleaseSfcItemRecipe {

  private String holdReleaseBo;

  private String customerItemBo;

  private int step;

  private String operationBo;

  private String recipeName;

  private String capability;

  public HoldReleaseSfcItemRecipe() {
  }

  public HoldReleaseSfcItemRecipe(HoldReleaseSfcItemRecipe data) {
    this.holdReleaseBo = data.holdReleaseBo;
    this.customerItemBo = data.customerItemBo;
    this.step = data.step;
    this.operationBo = data.operationBo;
    this.recipeName = data.recipeName;
    this.capability = data.capability;
  }

  @Override
  public HoldReleaseSfcItemRecipe clone() {
    return new HoldReleaseSfcItemRecipe(this);
  }

  @Override
  public String toString() {
    return this.holdReleaseBo + ", " + this.customerItemBo + ", " + this.step;
  }

  public String getHoldReleaseBo() {
    return holdReleaseBo;
  }

  public void setHoldReleaseBo(String holdReleaseBo) {
    this.holdReleaseBo = holdReleaseBo;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public int getStep() {
    return step;
  }

  public void setStep(int step) {
    this.step = step;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }
}
