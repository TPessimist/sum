package ame.psb.db;

/**
 * @author Coffee
 */
public class ViewResourceRunBlock extends ResourceRunBlock {

  private String customerName;

  private String packageName;

  private String itemGroupName;

  private String itemName;

  private String routerName;

  private String operationName;

  private String resourceName;


  public ViewResourceRunBlock() {
  }

  public ViewResourceRunBlock(ViewResourceRunBlock data) {
    this.customerName = data.customerName;
    this.packageName = data.packageName;
    this.itemGroupName = data.itemGroupName;
    this.itemName = data.itemName;
    this.routerName = data.routerName;
    this.operationName = data.operationName;
    this.resourceName = data.resourceName;
  }

  @Override
  public ViewResourceRunBlock clone() {
    return new ViewResourceRunBlock(this);
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getItemGroupName() {
    return itemGroupName;
  }

  public void setItemGroupName(String itemGroupName) {
    this.itemGroupName = itemGroupName;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getRouterName() {
    return routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }
}