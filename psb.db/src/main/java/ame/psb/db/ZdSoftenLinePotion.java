package ame.psb.db;

import java.util.Date;
import java.util.UUID;


/*
 * @author:cc
 * */
public class ZdSoftenLinePotion {

  private String id; //槽位号+上机编号+料号

  private String handle;

  private String resource; //上机编号

  private String resourceSlotId; //槽位号

  private String itemBo; //料号  ResourceBO:1020,itemBo

  private String inventoryBo;

  private String updateUser;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String stateName;

  private String content1;

  private String content2;

  private String status;

  public ZdSoftenLinePotion() {
    this.id = UUID.randomUUID().toString();
  }

  public ZdSoftenLinePotion(ZdSoftenLinePotion softenLinePotion) {
    this.id = softenLinePotion.id;
    this.handle = softenLinePotion.handle;
    this.resource = softenLinePotion.resource;
    this.resourceSlotId = softenLinePotion.resourceSlotId;
    this.itemBo = softenLinePotion.itemBo;
    this.inventoryBo = softenLinePotion.inventoryBo;
    this.updateUser = softenLinePotion.updateUser;
    this.createdDateTime = softenLinePotion.createdDateTime;
    this.modifiedDateTime = softenLinePotion.modifiedDateTime;
    this.stateName = softenLinePotion.stateName;
    this.content1 = softenLinePotion.content1;
    this.content2 = softenLinePotion.content2;
    this.status = softenLinePotion.status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getResourceSlotId() {
    return resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getContent1() {
    return content1;
  }

  public void setContent1(String content1) {
    this.content1 = content1;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public ZdSoftenLinePotion clone() {
    return new ZdSoftenLinePotion(this);
  }

  @Override
  public String toString() {
    return this.resourceSlotId + "," + this.resource + ", " + this.itemBo;
  }
}
