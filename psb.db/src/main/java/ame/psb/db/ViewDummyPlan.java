package ame.psb.db;

/**
 * @author Coffee
 */
public class ViewDummyPlan extends DummyPlan {

  private String resourceName;

  private String itemName;

  private String beginOperation;

  private String endOperation;


  public ViewDummyPlan() {
  }

  public ViewDummyPlan(ViewDummyPlan data) {
    this.resourceName = data.resourceName;
    this.itemName = data.itemName;
    this.beginOperation = data.beginOperation;
    this.endOperation = data.endOperation;
  }

  @Override
  public ViewDummyPlan clone() {
    return new ViewDummyPlan(this);
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getBeginOperation() {
    return beginOperation;
  }

  public void setBeginOperation(String beginOperation) {
    this.beginOperation = beginOperation;
  }

  public String getEndOperation() {
    return endOperation;
  }

  public void setEndOperation(String endOperation) {
    this.endOperation = endOperation;
  }
}