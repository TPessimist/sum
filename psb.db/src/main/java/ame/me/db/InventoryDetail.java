package ame.me.db;

import ame.psb.commons.Env;
import java.math.BigDecimal;
import java.util.Date;

public class InventoryDetail {

  public static final String FIELD_EFF_DATE = "EFF_DATE";

  public static final String FIELD_PRD_DATE = "PRD_DATE";

  public static final String FIELD_SUP_SN = "SUP_SN";

  private String handle;

  private Integer changeStamp;

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

  private String originalUserBo;

  private String storageLocationBo;

  private String hasBeenUsed;

  private Date receiveDateTime;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private Date partitionDate;

  private String parentInventoryBo;

  private String erpInventory;

  private String supSn;

  private String prdDate;

  private String effDate;

  public InventoryDetail() {

  }

  public InventoryDetail(InventoryDetail inventory) {
    this.handle = inventory.handle;
    this.changeStamp = inventory.changeStamp;
    this.site = inventory.site;
    this.inventoryId = inventory.inventoryId;
    this.itemBo = inventory.itemBo;
    this.inventoryContextGbo = inventory.inventoryContextGbo;
    this.description = inventory.description;
    this.qtyOnHand = inventory.qtyOnHand;
    this.assyDataTypeBo = inventory.assyDataTypeBo;
    this.usageCount = inventory.usageCount;
    this.maximumUsage = inventory.maximumUsage;
    this.statusBo = inventory.statusBo;
    this.originalQty = inventory.originalQty;
    this.workCenterLocBo = inventory.workCenterLocBo;
    this.workCenterLocRes = inventory.workCenterLocRes;
    this.operationLocBo = inventory.operationLocBo;
    this.operationLocRes = inventory.operationLocRes;
    this.resourceLocBo = inventory.resourceLocBo;
    this.resourceLocRes = inventory.resourceLocRes;
    this.shopOrderLocBo = inventory.shopOrderLocBo;
    this.shopOrderLocRes = inventory.shopOrderLocRes;
    this.shopOrderSetByErp = inventory.shopOrderSetByErp;
    this.originalUserBo = inventory.originalUserBo;
    this.storageLocationBo = inventory.storageLocationBo;
    this.hasBeenUsed = inventory.hasBeenUsed;
    this.receiveDateTime = inventory.receiveDateTime;
    this.createdDateTime = inventory.createdDateTime;
    this.modifiedDateTime = inventory.modifiedDateTime;
    this.partitionDate = inventory.partitionDate;
    this.parentInventoryBo = inventory.parentInventoryBo;
    this.erpInventory = inventory.erpInventory;
    this.supSn = inventory.supSn;
    this.prdDate = inventory.prdDate;
    this.effDate = inventory.effDate;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public Integer getChangeStamp() {
    return this.changeStamp;
  }

  public void setChangeStamp(Integer changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getInventoryId() {
    return this.inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getInventoryContextGbo() {
    return this.inventoryContextGbo;
  }

  public void setInventoryContextGbo(String inventoryContextGbo) {
    this.inventoryContextGbo = inventoryContextGbo;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getQtyOnHand() {
    return this.qtyOnHand;
  }

  public void setQtyOnHand(BigDecimal qtyOnHand) {
    this.qtyOnHand = qtyOnHand;
  }

  public String getAssyDataTypeBo() {
    return this.assyDataTypeBo;
  }

  public void setAssyDataTypeBo(String assyDataTypeBo) {
    this.assyDataTypeBo = assyDataTypeBo;
  }

  public BigDecimal getUsageCount() {
    return this.usageCount;
  }

  public void setUsageCount(BigDecimal usageCount) {
    this.usageCount = usageCount;
  }

  public BigDecimal getMaximumUsage() {
    return this.maximumUsage;
  }

  public void setMaximumUsage(BigDecimal maximumUsage) {
    this.maximumUsage = maximumUsage;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public BigDecimal getOriginalQty() {
    return this.originalQty;
  }

  public void setOriginalQty(BigDecimal originalQty) {
    this.originalQty = originalQty;
  }

  public String getWorkCenterLocBo() {
    return this.workCenterLocBo;
  }

  public void setWorkCenterLocBo(String workCenterLocBo) {
    this.workCenterLocBo = workCenterLocBo;
  }

  public String getWorkCenterLocRes() {
    return this.workCenterLocRes;
  }

  public void setWorkCenterLocRes(String workCenterLocRes) {
    this.workCenterLocRes = workCenterLocRes;
  }

  public String getOperationLocBo() {
    return this.operationLocBo;
  }

  public void setOperationLocBo(String operationLocBo) {
    this.operationLocBo = operationLocBo;
  }

  public String getOperationLocRes() {
    return this.operationLocRes;
  }

  public void setOperationLocRes(String operationLocRes) {
    this.operationLocRes = operationLocRes;
  }

  public String getResourceLocBo() {
    return this.resourceLocBo;
  }

  public void setResourceLocBo(String resourceLocBo) {
    this.resourceLocBo = resourceLocBo;
  }

  public String getResourceLocRes() {
    return this.resourceLocRes;
  }

  public void setResourceLocRes(String resourceLocRes) {
    this.resourceLocRes = resourceLocRes;
  }

  public String getShopOrderLocBo() {
    return this.shopOrderLocBo;
  }

  public void setShopOrderLocBo(String shopOrderLocBo) {
    this.shopOrderLocBo = shopOrderLocBo;
  }

  public String getShopOrderLocRes() {
    return this.shopOrderLocRes;
  }

  public void setShopOrderLocRes(String shopOrderLocRes) {
    this.shopOrderLocRes = shopOrderLocRes;
  }

  public String getShopOrderSetByErp() {
    return this.shopOrderSetByErp;
  }

  public void setShopOrderSetByErp(String shopOrderSetByErp) {
    this.shopOrderSetByErp = shopOrderSetByErp;
  }

  public String getOriginalUserBo() {
    return this.originalUserBo;
  }

  public void setOriginalUserBo(String originalUserBo) {
    this.originalUserBo = originalUserBo;
  }

  public String getStorageLocationBo() {
    return this.storageLocationBo;
  }

  public void setStorageLocationBo(String storageLocationBo) {
    this.storageLocationBo = storageLocationBo;
  }

  public String getHasBeenUsed() {
    return this.hasBeenUsed;
  }

  public void setHasBeenUsed(String hasBeenUsed) {
    this.hasBeenUsed = hasBeenUsed;
  }

  public Date getReceiveDateTime() {
    return this.receiveDateTime;
  }

  public void setReceiveDateTime(Date receiveDateTime) {
    this.receiveDateTime = receiveDateTime;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public Date getPartitionDate() {
    return this.partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  public String getParentInventoryBo() {
    return this.parentInventoryBo;
  }

  public void setParentInventoryBo(String parentInventoryBo) {
    this.parentInventoryBo = parentInventoryBo;
  }

  public String getErpInventory() {
    return this.erpInventory;
  }

  public void setErpInventory(String erpInventory) {
    this.erpInventory = erpInventory;
  }

  public String getSupSn() {
    return this.supSn;
  }

  public void setSupSn(String supSn) {
    this.supSn = supSn;
  }

  public String getPrdDate() {
    return this.prdDate;
  }

  public void setPrdDate(String prdDate) {
    this.prdDate = prdDate;
  }

  public String getEffDate() {
    return this.effDate;
  }

  public void setEffDate(String effDate) {
    this.effDate = effDate;
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public boolean isAvailable() {
    return "1001".equals(Env.trimHandle(this.statusBo));
  }

  public boolean isHold() {
    return "1002".equals(Env.trimHandle(this.statusBo));
  }

  public boolean isQuarantine() {
    return "1003".equals(Env.trimHandle(this.statusBo));
  }

  @Override
  public boolean equals(Object o) {
    return o != null && o instanceof InventoryDetail && ((InventoryDetail) o).getHandle()
        .equals(this.handle);
  }

}
