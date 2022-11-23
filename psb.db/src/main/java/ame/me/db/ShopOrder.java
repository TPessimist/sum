package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class ShopOrder {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String shopOrder;

  private String statusBo;

  private int priority;

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

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return this.changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

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

  public int getPriority() {
    return this.priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public String getPlannedWorkCenterBo() {
    return this.plannedWorkCenterBo;
  }

  public void setPlannedWorkCenterBo(String plannedWorkCenterBo) {
    this.plannedWorkCenterBo = plannedWorkCenterBo;
  }

  public String getPlannedItemBo() {
    return this.plannedItemBo;
  }

  public void setPlannedItemBo(String plannedItemBo) {
    this.plannedItemBo = plannedItemBo;
  }

  public String getPlannedBomBo() {
    return this.plannedBomBo;
  }

  public void setPlannedBomBo(String plannedBomBo) {
    this.plannedBomBo = plannedBomBo;
  }

  public String getPlannedRouterBo() {
    return this.plannedRouterBo;
  }

  public void setPlannedRouterBo(String plannedRouterBo) {
    this.plannedRouterBo = plannedRouterBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getBomBo() {
    return this.bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public BigDecimal getQtyToBuild() {
    return this.qtyToBuild;
  }

  public void setQtyToBuild(BigDecimal qtyToBuild) {
    this.qtyToBuild = qtyToBuild;
  }

  public BigDecimal getQtyOrdered() {
    return this.qtyOrdered;
  }

  public void setQtyOrdered(BigDecimal qtyOrdered) {
    this.qtyOrdered = qtyOrdered;
  }

  public BigDecimal getQtyReleased() {
    return this.qtyReleased;
  }

  public void setQtyReleased(BigDecimal qtyReleased) {
    this.qtyReleased = qtyReleased;
  }

  public Date getReleasedDate() {
    return this.releasedDate;
  }

  public void setReleasedDate(Date releasedDate) {
    this.releasedDate = releasedDate;
  }

  public Date getPlannedStartDate() {
    return this.plannedStartDate;
  }

  public void setPlannedStartDate(Date plannedStartDate) {
    this.plannedStartDate = plannedStartDate;
  }

  public Date getPlannedCompDate() {
    return this.plannedCompDate;
  }

  public void setPlannedCompDate(Date plannedCompDate) {
    this.plannedCompDate = plannedCompDate;
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

  public Date getActualStartDate() {
    return this.actualStartDate;
  }

  public void setActualStartDate(Date actualStartDate) {
    this.actualStartDate = actualStartDate;
  }

  public Date getActualCompDate() {
    return this.actualCompDate;
  }

  public void setActualCompDate(Date actualCompDate) {
    this.actualCompDate = actualCompDate;
  }

  public BigDecimal getQtyDone() {
    return this.qtyDone;
  }

  public void setQtyDone(BigDecimal qtyDone) {
    this.qtyDone = qtyDone;
  }

  public BigDecimal getQtyScrapped() {
    return this.qtyScrapped;
  }

  public void setQtyScrapped(BigDecimal qtyScrapped) {
    this.qtyScrapped = qtyScrapped;
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

  public String getRmaSfcDataTypeBo() {
    return this.rmaSfcDataTypeBo;
  }

  public void setRmaSfcDataTypeBo(String rmaSfcDataTypeBo) {
    this.rmaSfcDataTypeBo = rmaSfcDataTypeBo;
  }

  public String getRmaShopOrderDataTypeBo() {
    return this.rmaShopOrderDataTypeBo;
  }

  public void setRmaShopOrderDataTypeBo(String rmaShopOrderDataTypeBo) {
    this.rmaShopOrderDataTypeBo = rmaShopOrderDataTypeBo;
  }

  public String getOriginalStatusBo() {
    return this.originalStatusBo;
  }

  public void setOriginalStatusBo(String originalStatusBo) {
    this.originalStatusBo = originalStatusBo;
  }

  public String getTransferSite() {
    return this.transferSite;
  }

  public void setTransferSite(String transferSite) {
    this.transferSite = transferSite;
  }

  public String getTransferType() {
    return this.transferType;
  }

  public void setTransferType(String transferType) {
    this.transferType = transferType;
  }

  public String getLccBo() {
    return this.lccBo;
  }

  public void setLccBo(String lccBo) {
    this.lccBo = lccBo;
  }

  public String getShopOrderTypeBo() {
    return this.shopOrderTypeBo;
  }

  public void setShopOrderTypeBo(String shopOrderTypeBo) {
    this.shopOrderTypeBo = shopOrderTypeBo;
  }

  public BigDecimal getHoldId() {
    return this.holdId;
  }

  public void setHoldId(BigDecimal holdId) {
    this.holdId = holdId;
  }

  public String getEndUnitNumber() {
    return this.endUnitNumber;
  }

  public void setEndUnitNumber(String endUnitNumber) {
    this.endUnitNumber = endUnitNumber;
  }

  public String getReqSerialChange() {
    return this.reqSerialChange;
  }

  public void setReqSerialChange(String reqSerialChange) {
    this.reqSerialChange = reqSerialChange;
  }

  public String getCollectParentSerial() {
    return this.collectParentSerial;
  }

  public void setCollectParentSerial(String collectParentSerial) {
    this.collectParentSerial = collectParentSerial;
  }

  public String getBatchNumber() {
    return this.batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public String getErpOrder() {
    return this.erpOrder;
  }

  public void setErpOrder(String erpOrder) {
    this.erpOrder = erpOrder;
  }

  public String getErpProductionVersion() {
    return this.erpProductionVersion;
  }

  public void setErpProductionVersion(String erpProductionVersion) {
    this.erpProductionVersion = erpProductionVersion;
  }

  public String getErpUnitOfMeasure() {
    return this.erpUnitOfMeasure;
  }

  public void setErpUnitOfMeasure(String erpUnitOfMeasure) {
    this.erpUnitOfMeasure = erpUnitOfMeasure;
  }

  public Date getPartitionDate() {
    return this.partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  public String getInspectionLot() {
    return this.inspectionLot;
  }

  public void setInspectionLot(String inspectionLot) {
    this.inspectionLot = inspectionLot;
  }

  public BigDecimal getInspectionGroupSize() {
    return this.inspectionGroupSize;
  }

  public void setInspectionGroupSize(BigDecimal inspectionGroupSize) {
    this.inspectionGroupSize = inspectionGroupSize;
  }

  public String getErpPutawayStorloc() {
    return this.erpPutawayStorloc;
  }

  public void setErpPutawayStorloc(String erpPutawayStorloc) {
    this.erpPutawayStorloc = erpPutawayStorloc;
  }

  public String getWarehouseNumber() {
    return this.warehouseNumber;
  }

  public void setWarehouseNumber(String warehouseNumber) {
    this.warehouseNumber = warehouseNumber;
  }

  @Override
  public String toString() {
    return this.handle;
  }

}
