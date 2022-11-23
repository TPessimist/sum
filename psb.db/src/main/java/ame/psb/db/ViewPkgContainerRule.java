package ame.psb.db;

public class ViewPkgContainerRule extends PkgContainerRule {

  private String site;

  private String itemGroup;

  private String itemGroupDescription;

  private String operation;

  public ViewPkgContainerRule() {
  }

  public ViewPkgContainerRule(ViewPkgContainerRule data) {
    super(data);
    this.site = data.site;
    this.itemGroup = data.itemGroup;
    this.itemGroupDescription = data.itemGroupDescription;
    this.operation = data.operation;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getItemGroup() {
    return itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public String getItemGroupDescription() {
    return itemGroupDescription;
  }

  public void setItemGroupDescription(String itemGroupDescription) {
    this.itemGroupDescription = itemGroupDescription;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }



  public String value() {
    return "ViewPkgContainerRule{" +
        "site='" + site + '\'' +
        //", itemGroup='" + itemGroup + '\'' +
        ", operation='" + operation + '\'' +
        '}';
  }
}
