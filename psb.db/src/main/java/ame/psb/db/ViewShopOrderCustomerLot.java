package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ViewShopOrderCustomerLot extends ShopOrderCustomerLot {

  private String shopOrder;

  private String statusBo;

  private String statusDescription;

  private String shopOrderTypeBo;

  private String orderType;

  private String itemBo;

  private String itemGroupBo;

  private String item;

  private String plannedRouterBo;

  private String router;

  private Integer priority;

  private Date scheduledStartDate;

  private Date scheduledCompDate;

  private String lotName;

  private String customerBo;

  private String customer;

  private String customerOrder;

  public String getShopOrder() {
    return this.shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getStatusDescription() {
    return this.statusDescription;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  public String getShopOrderTypeBo() {
    return this.shopOrderTypeBo;
  }

  public void setShopOrderTypeBo(String shopOrderTypeBo) {
    this.shopOrderTypeBo = shopOrderTypeBo;
  }

  public String getOrderType() {
    return this.orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getPlannedRouterBo() {
    return this.plannedRouterBo;
  }

  public void setPlannedRouterBo(String plannedRouterBo) {
    this.plannedRouterBo = plannedRouterBo;
  }

  public String getRouter() {
    return this.router;
  }

  public void setRouter(String router) {
    this.router = router;
  }

  public Integer getPriority() {
    return this.priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Date getScheduledStartDate() {
    return this.scheduledStartDate;
  }

  public void setScheduledStartDate(Date scheduledStartDate) {
    this.scheduledStartDate = scheduledStartDate;
  }

  public Date getScheduledCompDate() {
    return this.scheduledCompDate;
  }

  public void setScheduledCompDate(Date scheduledCompDate) {
    this.scheduledCompDate = scheduledCompDate;
  }

  public String getLotName() {
    return this.lotName;
  }

  public void setLotName(String lotName) {
    this.lotName = lotName;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getCustomer() {
    return this.customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getCustomerOrder() {
    return this.customerOrder;
  }

  public void setCustomerOrder(String customerOrder) {
    this.customerOrder = customerOrder;
  }

}
