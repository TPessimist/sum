package ame.psb.db;

public class OperationMapGenerateForGCAutoExtend {

  private String sfcName;

  private String id;

  private String containerBo;

  private String containerName;

  private String content;

  private String customer;

  private String customerItemBo;

  private String fileName;


  public OperationMapGenerateForGCAutoExtend() {
  }

  public OperationMapGenerateForGCAutoExtend(OperationMapGenerateForGCAutoExtend data) {
    this.sfcName = data.sfcName;
    this.id = data.id;
    this.containerBo = data.containerBo;
    this.containerName = data.containerName;
    this.content = data.content;
    this.customer = data.customer;
    this.customerItemBo = data.customerItemBo;
    this.fileName = data.fileName;
  }


  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getContainerName() {
    return containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public OperationMapGenerateForGCAutoExtend clone() {
    return new OperationMapGenerateForGCAutoExtend(this);
  }

  @Override
  public String toString() {
    return this.sfcName;
  }
}
