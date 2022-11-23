package ame.psb.db;

import java.util.Date;

public class QueryFTFifoResult {

  private String sfc;
  private Date dateQuequed;
  private String shopOrder;
  private String operationBo;
  private String location;
  private String sfcStateName;
  private String description;
  private String state;

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public Date getDateQuequed() {
    return dateQuequed;
  }

  public void setDateQuequed(Date dateQuequed) {
    this.dateQuequed = dateQuequed;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getSfcStateName() {
    return sfcStateName;
  }

  public void setSfcStateName(String sfcStateName) {
    this.sfcStateName = sfcStateName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
