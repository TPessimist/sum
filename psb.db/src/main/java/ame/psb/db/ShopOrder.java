package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ShopOrder {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String shopOrder;

  private String statusBo;

  private BigDecimal priority;

  private String plannedWorkCenterBo;

  private String plannedItemBo;

  private String plannedBomBo;

  private String plannedRouterBo;

  private String itemBo;

  private String bomBo;

  private String routerBo;

  private BigDecimal qtyToBuild;

  private BigDecimal qtyOrdered;

  private BigDecimal qtyReleased;

  private Date releasedDate;

  private Date plannedStartDate;

  private Date plannedCompDate;

  private Date scheduledStartDate;

  private Date scheduledCompDate;

  private Date actualStartDate;

  private Date actualCompDate;

  private BigDecimal qtyDone;

  private BigDecimal qtyScrapped;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String customer;

  private String customerOrder;

  private String rmaSfcDataTypeBo;

  private String rmaShopOrderDataTypeBo;

  private String originalStatusBo;

  private String transferSite;

  private String transferType;

  private String lccBo;

  private String shopOrderTypeBo;

  private BigDecimal holdId;

  private String endUnitNumber;

  private String reqSerialChange;

  private String collectParentSerial;

  private String batchNumber;

  private String erpOrder;

  private String erpProductionVersion;

  private String erpUnitOfMeasure;

  private Date partitionDate;

  private String inspectionLot;

  private BigDecimal inspectionGroupSize;

  private String erpPutawayStorloc;

  private String warehouseNumber;


  public ShopOrder() {
  }

  public ShopOrder(ShopOrder data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.shopOrder = data.shopOrder;
    this.statusBo = data.statusBo;
    this.priority = data.priority;
    this.plannedWorkCenterBo = data.plannedWorkCenterBo;
    this.plannedItemBo = data.plannedItemBo;
    this.plannedBomBo = data.plannedBomBo;
    this.plannedRouterBo = data.plannedRouterBo;
    this.itemBo = data.itemBo;
    this.bomBo = data.bomBo;
    this.routerBo = data.routerBo;
    this.qtyToBuild = data.qtyToBuild;
    this.qtyOrdered = data.qtyOrdered;
    this.qtyReleased = data.qtyReleased;
    this.releasedDate = data.releasedDate;
    this.plannedStartDate = data.plannedStartDate;
    this.plannedCompDate = data.plannedCompDate;
    this.scheduledStartDate = data.scheduledStartDate;
    this.scheduledCompDate = data.scheduledCompDate;
    this.actualStartDate = data.actualStartDate;
    this.actualCompDate = data.actualCompDate;
    this.qtyDone = data.qtyDone;
    this.qtyScrapped = data.qtyScrapped;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.customer = data.customer;
    this.customerOrder = data.customerOrder;
    this.rmaSfcDataTypeBo = data.rmaSfcDataTypeBo;
    this.rmaShopOrderDataTypeBo = data.rmaShopOrderDataTypeBo;
    this.originalStatusBo = data.originalStatusBo;
    this.transferSite = data.transferSite;
    this.transferType = data.transferType;
    this.lccBo = data.lccBo;
    this.shopOrderTypeBo = data.shopOrderTypeBo;
    this.holdId = data.holdId;
    this.endUnitNumber = data.endUnitNumber;
    this.reqSerialChange = data.reqSerialChange;
    this.collectParentSerial = data.collectParentSerial;
    this.batchNumber = data.batchNumber;
    this.erpOrder = data.erpOrder;
    this.erpProductionVersion = data.erpProductionVersion;
    this.erpUnitOfMeasure = data.erpUnitOfMeasure;
    this.partitionDate = data.partitionDate;
    this.inspectionLot = data.inspectionLot;
    this.inspectionGroupSize = data.inspectionGroupSize;
    this.erpPutawayStorloc = data.erpPutawayStorloc;
    this.warehouseNumber = data.warehouseNumber;
  }

  @Override
  public ShopOrder clone() {
    return new ShopOrder(this);
  }

  @Override
  public String toString() {
    return this.handle;
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

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public BigDecimal getPriority() {
    return priority;
  }

  public void setPriority(BigDecimal priority) {
    this.priority = priority;
  }

  public String getPlannedWorkCenterBo() {
    return plannedWorkCenterBo;
  }

  public void setPlannedWorkCenterBo(String plannedWorkCenterBo) {
    this.plannedWorkCenterBo = plannedWorkCenterBo;
  }

  public String getPlannedItemBo() {
    return plannedItemBo;
  }

  public void setPlannedItemBo(String plannedItemBo) {
    this.plannedItemBo = plannedItemBo;
  }

  public String getPlannedBomBo() {
    return plannedBomBo;
  }

  public void setPlannedBomBo(String plannedBomBo) {
    this.plannedBomBo = plannedBomBo;
  }

  public String getPlannedRouterBo() {
    return plannedRouterBo;
  }

  public void setPlannedRouterBo(String plannedRouterBo) {
    this.plannedRouterBo = plannedRouterBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getBomBo() {
    return bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getRouterBo() {
    return routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public BigDecimal getQtyToBuild() {
    return qtyToBuild;
  }

  public void setQtyToBuild(BigDecimal qtyToBuild) {
    this.qtyToBuild = qtyToBuild;
  }

  public BigDecimal getQtyOrdered() {
    return qtyOrdered;
  }

  public void setQtyOrdered(BigDecimal qtyOrdered) {
    this.qtyOrdered = qtyOrdered;
  }

  public BigDecimal getQtyReleased() {
    return qtyReleased;
  }

  public void setQtyReleased(BigDecimal qtyReleased) {
    this.qtyReleased = qtyReleased;
  }

  public Date getReleasedDate() {
    return releasedDate;
  }

  public void setReleasedDate(Date releasedDate) {
    this.releasedDate = releasedDate;
  }

  public Date getPlannedStartDate() {
    return plannedStartDate;
  }

  public void setPlannedStartDate(Date plannedStartDate) {
    this.plannedStartDate = plannedStartDate;
  }

  public Date getPlannedCompDate() {
    return plannedCompDate;
  }

  public void setPlannedCompDate(Date plannedCompDate) {
    this.plannedCompDate = plannedCompDate;
  }

  public Date getScheduledStartDate() {
    return scheduledStartDate;
  }

  public void setScheduledStartDate(Date scheduledStartDate) {
    this.scheduledStartDate = scheduledStartDate;
  }

  public Date getScheduledCompDate() {
    return scheduledCompDate;
  }

  public void setScheduledCompDate(Date scheduledCompDate) {
    this.scheduledCompDate = scheduledCompDate;
  }

  public Date getActualStartDate() {
    return actualStartDate;
  }

  public void setActualStartDate(Date actualStartDate) {
    this.actualStartDate = actualStartDate;
  }

  public Date getActualCompDate() {
    return actualCompDate;
  }

  public void setActualCompDate(Date actualCompDate) {
    this.actualCompDate = actualCompDate;
  }

  public BigDecimal getQtyDone() {
    return qtyDone;
  }

  public void setQtyDone(BigDecimal qtyDone) {
    this.qtyDone = qtyDone;
  }

  public BigDecimal getQtyScrapped() {
    return qtyScrapped;
  }

  public void setQtyScrapped(BigDecimal qtyScrapped) {
    this.qtyScrapped = qtyScrapped;
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

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getCustomerOrder() {
    return customerOrder;
  }

  public void setCustomerOrder(String customerOrder) {
    this.customerOrder = customerOrder;
  }

  public String getRmaSfcDataTypeBo() {
    return rmaSfcDataTypeBo;
  }

  public void setRmaSfcDataTypeBo(String rmaSfcDataTypeBo) {
    this.rmaSfcDataTypeBo = rmaSfcDataTypeBo;
  }

  public String getRmaShopOrderDataTypeBo() {
    return rmaShopOrderDataTypeBo;
  }

  public void setRmaShopOrderDataTypeBo(String rmaShopOrderDataTypeBo) {
    this.rmaShopOrderDataTypeBo = rmaShopOrderDataTypeBo;
  }

  public String getOriginalStatusBo() {
    return originalStatusBo;
  }

  public void setOriginalStatusBo(String originalStatusBo) {
    this.originalStatusBo = originalStatusBo;
  }

  public String getTransferSite() {
    return transferSite;
  }

  public void setTransferSite(String transferSite) {
    this.transferSite = transferSite;
  }

  public String getTransferType() {
    return transferType;
  }

  public void setTransferType(String transferType) {
    this.transferType = transferType;
  }

  public String getLccBo() {
    return lccBo;
  }

  public void setLccBo(String lccBo) {
    this.lccBo = lccBo;
  }

  public String getShopOrderTypeBo() {
    return shopOrderTypeBo;
  }

  public void setShopOrderTypeBo(String shopOrderTypeBo) {
    this.shopOrderTypeBo = shopOrderTypeBo;
  }

  public BigDecimal getHoldId() {
    return holdId;
  }

  public void setHoldId(BigDecimal holdId) {
    this.holdId = holdId;
  }

  public String getEndUnitNumber() {
    return endUnitNumber;
  }

  public void setEndUnitNumber(String endUnitNumber) {
    this.endUnitNumber = endUnitNumber;
  }

  public String getReqSerialChange() {
    return reqSerialChange;
  }

  public void setReqSerialChange(String reqSerialChange) {
    this.reqSerialChange = reqSerialChange;
  }

  public String getCollectParentSerial() {
    return collectParentSerial;
  }

  public void setCollectParentSerial(String collectParentSerial) {
    this.collectParentSerial = collectParentSerial;
  }

  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public String getErpOrder() {
    return erpOrder;
  }

  public void setErpOrder(String erpOrder) {
    this.erpOrder = erpOrder;
  }

  public String getErpProductionVersion() {
    return erpProductionVersion;
  }

  public void setErpProductionVersion(String erpProductionVersion) {
    this.erpProductionVersion = erpProductionVersion;
  }

  public String getErpUnitOfMeasure() {
    return erpUnitOfMeasure;
  }

  public void setErpUnitOfMeasure(String erpUnitOfMeasure) {
    this.erpUnitOfMeasure = erpUnitOfMeasure;
  }

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  public String getInspectionLot() {
    return inspectionLot;
  }

  public void setInspectionLot(String inspectionLot) {
    this.inspectionLot = inspectionLot;
  }

  public BigDecimal getInspectionGroupSize() {
    return inspectionGroupSize;
  }

  public void setInspectionGroupSize(BigDecimal inspectionGroupSize) {
    this.inspectionGroupSize = inspectionGroupSize;
  }

  public String getErpPutawayStorloc() {
    return erpPutawayStorloc;
  }

  public void setErpPutawayStorloc(String erpPutawayStorloc) {
    this.erpPutawayStorloc = erpPutawayStorloc;
  }

  public String getWarehouseNumber() {
    return warehouseNumber;
  }

  public void setWarehouseNumber(String warehouseNumber) {
    this.warehouseNumber = warehouseNumber;
  }


}
