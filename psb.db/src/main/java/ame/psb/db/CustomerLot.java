package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class CustomerLot {

  private String id;

  private String customerBo;

  private String itemLotName;

  private String itemLotNameOrig;

  private Date createdTime;

  private Date closedTime;

  private String customerOrder;

  public CustomerLot() {
    this.id = UUID.randomUUID().toString();
    this.createdTime = new Date();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getItemLotName() {
    return this.itemLotName;
  }

  public void setItemLotName(String itemLotName) {
    this.itemLotName = itemLotName;
  }


  public String getItemLotNameOrig() {
    return itemLotNameOrig;
  }

  public void setItenLotNameOrig(String itemLotNameOrig) {
    this.itemLotNameOrig = itemLotNameOrig;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getClosedTime() {
    return this.closedTime;
  }

  public void setClosedTime(Date closedTime) {
    this.closedTime = closedTime;
  }

  public String getCustomerOrder() {
    return this.customerOrder;
  }

  public void setCustomerOrder(String customerOrder) {
    this.customerOrder = customerOrder;
  }
}
