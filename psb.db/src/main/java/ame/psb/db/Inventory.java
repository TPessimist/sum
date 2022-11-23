package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class Inventory {

  private String handle;
  private BigDecimal changeStamp;
  private String site;
  private String inventoryId;
  private String itemBo;
  private String inventoryContextGbo;
  private String description;
  private BigDecimal qtyOnHand;
  private String assyDataTypeBo;
  private BigDecimal usageCount;
  private BigDecimal maximumUsage;
  private String statusBo;
  private BigDecimal originalQty;
  private String workCenterLocBo;
  private String workCenterLocRes;
  private String operationLocBo;
  private String operationLocRes;
  private String resourceLocBo;
  private String resourceLocRes;
  private String shopOrderLocBo;
  private String shopOrderLocRes;
  private String shopOrderSetByErp;
  private Date receiveDateTime;
  private String originalUserBo;
  private String storageLocationBo;
  private String hasBeenUsed;
  private Date createdDateTime;
  private Date modifiedDateTime;
  private Date partitionDate;
  private String parentInventoryBo;
  private String erpInventory;

  public Inventory() {
  }

  public Inventory(Inventory data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.inventoryId = data.inventoryId;
    this.itemBo = data.itemBo;
    this.inventoryContextGbo = data.inventoryContextGbo;
    this.description = data.description;
    this.qtyOnHand = data.qtyOnHand;
    this.assyDataTypeBo = data.assyDataTypeBo;
    this.usageCount = data.usageCount;
    this.maximumUsage = data.maximumUsage;
    this.statusBo = data.statusBo;
    this.originalQty = data.originalQty;
    this.workCenterLocBo = data.workCenterLocBo;
    this.workCenterLocRes = data.workCenterLocRes;
    this.operationLocBo = data.operationLocBo;
    this.operationLocRes = data.operationLocRes;
    this.resourceLocBo = data.resourceLocBo;
    this.resourceLocRes = data.resourceLocRes;
    this.shopOrderLocBo = data.shopOrderLocBo;
    this.shopOrderLocRes = data.shopOrderLocRes;
    this.shopOrderSetByErp = data.shopOrderSetByErp;
    this.receiveDateTime = data.receiveDateTime;
    this.originalUserBo = data.originalUserBo;
    this.storageLocationBo = data.storageLocationBo;
    this.hasBeenUsed = data.hasBeenUsed;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.partitionDate = data.partitionDate;
    this.parentInventoryBo = data.parentInventoryBo;
    this.erpInventory = data.erpInventory;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getInventoryContextGbo() {
    return inventoryContextGbo;
  }

  public void setInventoryContextGbo(String inventoryContextGbo) {
    this.inventoryContextGbo = inventoryContextGbo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getQtyOnHand() {
    return qtyOnHand;
  }

  public void setQtyOnHand(BigDecimal qtyOnHand) {
    this.qtyOnHand = qtyOnHand;
  }

  public String getAssyDataTypeBo() {
    return assyDataTypeBo;
  }

  public void setAssyDataTypeBo(String assyDataTypeBo) {
    this.assyDataTypeBo = assyDataTypeBo;
  }

  public BigDecimal getUsageCount() {
    return usageCount;
  }

  public void setUsageCount(BigDecimal usageCount) {
    this.usageCount = usageCount;
  }

  public BigDecimal getMaximumUsage() {
    return maximumUsage;
  }

  public void setMaximumUsage(BigDecimal maximumUsage) {
    this.maximumUsage = maximumUsage;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public BigDecimal getOriginalQty() {
    return originalQty;
  }

  public void setOriginalQty(BigDecimal originalQty) {
    this.originalQty = originalQty;
  }

  public String getWorkCenterLocBo() {
    return workCenterLocBo;
  }

  public void setWorkCenterLocBo(String workCenterLocBo) {
    this.workCenterLocBo = workCenterLocBo;
  }

  public String getWorkCenterLocRes() {
    return workCenterLocRes;
  }

  public void setWorkCenterLocRes(String workCenterLocRes) {
    this.workCenterLocRes = workCenterLocRes;
  }

  public String getOperationLocBo() {
    return operationLocBo;
  }

  public void setOperationLocBo(String operationLocBo) {
    this.operationLocBo = operationLocBo;
  }

  public String getOperationLocRes() {
    return operationLocRes;
  }

  public void setOperationLocRes(String operationLocRes) {
    this.operationLocRes = operationLocRes;
  }

  public String getResourceLocBo() {
    return resourceLocBo;
  }

  public void setResourceLocBo(String resourceLocBo) {
    this.resourceLocBo = resourceLocBo;
  }

  public String getResourceLocRes() {
    return resourceLocRes;
  }

  public void setResourceLocRes(String resourceLocRes) {
    this.resourceLocRes = resourceLocRes;
  }

  public String getShopOrderLocBo() {
    return shopOrderLocBo;
  }

  public void setShopOrderLocBo(String shopOrderLocBo) {
    this.shopOrderLocBo = shopOrderLocBo;
  }

  public String getShopOrderLocRes() {
    return shopOrderLocRes;
  }

  public void setShopOrderLocRes(String shopOrderLocRes) {
    this.shopOrderLocRes = shopOrderLocRes;
  }

  public String getShopOrderSetByErp() {
    return shopOrderSetByErp;
  }

  public void setShopOrderSetByErp(String shopOrderSetByErp) {
    this.shopOrderSetByErp = shopOrderSetByErp;
  }

  public Date getReceiveDateTime() {
    return receiveDateTime;
  }

  public void setReceiveDateTime(Date receiveDateTime) {
    this.receiveDateTime = receiveDateTime;
  }

  public String getOriginalUserBo() {
    return originalUserBo;
  }

  public void setOriginalUserBo(String originalUserBo) {
    this.originalUserBo = originalUserBo;
  }

  public String getStorageLocationBo() {
    return storageLocationBo;
  }

  public void setStorageLocationBo(String storageLocationBo) {
    this.storageLocationBo = storageLocationBo;
  }

  public String getHasBeenUsed() {
    return hasBeenUsed;
  }

  public void setHasBeenUsed(String hasBeenUsed) {
    this.hasBeenUsed = hasBeenUsed;
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

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  public String getParentInventoryBo() {
    return parentInventoryBo;
  }

  public void setParentInventoryBo(String parentInventoryBo) {
    this.parentInventoryBo = parentInventoryBo;
  }

  public String getErpInventory() {
    return erpInventory;
  }

  public void setErpInventory(String erpInventory) {
    this.erpInventory = erpInventory;
  }

  @Override
  public Inventory clone() {
    return new Inventory(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
