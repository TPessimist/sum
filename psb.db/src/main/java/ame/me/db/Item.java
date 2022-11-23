package ame.me.db;

import java.util.Date;

public class Item {

  private String handle;

  private Integer changeStamp;

  private String site;

  private String item;

  private String description;

  private String statusBo;

  private String itemType;

  private String erpGtin;

  private Integer effStartSeq;

  private Integer effEndSeq;

  private Integer lotSize;

  private String quantityRestriction;

  private String routerBo;

  private String bomBo;

  private String componentGroupBo;

  private String itemGroupBo;

  private Date lastReleasedDate;

  private String assyDataTypeBo;

  private String preAssembled;

  private String revision;

  private String currentRevision;

  private Date effStartDate;

  private Date effEndDate;

  private String selectorActivityBo;

  private String selectorNote;

  private String assignSerialAtRelease;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String drawingName;

  private Integer maximumUsage;

  private String useCompFromDrawing;

  private String panel;

  private String removalAssyDataTypeBo;

  private String invAssyDataTypeBo;

  private String originalStatusBo;

  private Integer qtyMultiplier;

  private String createTrackableSfc;

  private String maskGroupBo;

  private String transferItemGroupBo;

  private String unitOfMeasure;

  private Integer holdId;

  private String collectParentSerial;

  private String reqSerialChange;

  private String isCollector;

  private String incBatchNumber;

  private String timeSensitive;

  private Integer maxShelfLife;

  private String maxShelfLifeUnits;

  private Integer maxFloorLife;

  private String maxFloorLifeUnits;

  private String notes;

  private String tbCompType;

  private Integer consumptionTol;

  private String erpBackflushing;

  private String storageLocationBo;

  private String erpPutawayStorloc;

  private String useOrderIdRel1;

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

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getItemType() {
    return this.itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getErpGtin() {
    return this.erpGtin;
  }

  public void setErpGtin(String erpGtin) {
    this.erpGtin = erpGtin;
  }

  public Integer getEffStartSeq() {
    return this.effStartSeq;
  }

  public void setEffStartSeq(Integer effStartSeq) {
    this.effStartSeq = effStartSeq;
  }

  public Integer getEffEndSeq() {
    return this.effEndSeq;
  }

  public void setEffEndSeq(Integer effEndSeq) {
    this.effEndSeq = effEndSeq;
  }

  public Integer getLotSize() {
    return this.lotSize;
  }

  public void setLotSize(Integer lotSize) {
    this.lotSize = lotSize;
  }

  public String getQuantityRestriction() {
    return this.quantityRestriction;
  }

  public void setQuantityRestriction(String quantityRestriction) {
    this.quantityRestriction = quantityRestriction;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getBomBo() {
    return this.bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getComponentGroupBo() {
    return this.componentGroupBo;
  }

  public void setComponentGroupBo(String componentGroupBo) {
    this.componentGroupBo = componentGroupBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public Date getLastReleasedDate() {
    return this.lastReleasedDate;
  }

  public void setLastReleasedDate(Date lastReleasedDate) {
    this.lastReleasedDate = lastReleasedDate;
  }

  public String getAssyDataTypeBo() {
    return this.assyDataTypeBo;
  }

  public void setAssyDataTypeBo(String assyDataTypeBo) {
    this.assyDataTypeBo = assyDataTypeBo;
  }

  public String getPreAssembled() {
    return this.preAssembled;
  }

  public void setPreAssembled(String preAssembled) {
    this.preAssembled = preAssembled;
  }

  public String getRevision() {
    return this.revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getCurrentRevision() {
    return this.currentRevision;
  }

  public void setCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
  }

  public Date getEffStartDate() {
    return this.effStartDate;
  }

  public void setEffStartDate(Date effStartDate) {
    this.effStartDate = effStartDate;
  }

  public Date getEffEndDate() {
    return this.effEndDate;
  }

  public void setEffEndDate(Date effEndDate) {
    this.effEndDate = effEndDate;
  }

  public String getSelectorActivityBo() {
    return this.selectorActivityBo;
  }

  public void setSelectorActivityBo(String selectorActivityBo) {
    this.selectorActivityBo = selectorActivityBo;
  }

  public String getSelectorNote() {
    return this.selectorNote;
  }

  public void setSelectorNote(String selectorNote) {
    this.selectorNote = selectorNote;
  }

  public String getAssignSerialAtRelease() {
    return this.assignSerialAtRelease;
  }

  public void setAssignSerialAtRelease(String assignSerialAtRelease) {
    this.assignSerialAtRelease = assignSerialAtRelease;
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

  public String getDrawingName() {
    return this.drawingName;
  }

  public void setDrawingName(String drawingName) {
    this.drawingName = drawingName;
  }

  public Integer getMaximumUsage() {
    return this.maximumUsage;
  }

  public void setMaximumUsage(Integer maximumUsage) {
    this.maximumUsage = maximumUsage;
  }

  public String getUseCompFromDrawing() {
    return this.useCompFromDrawing;
  }

  public void setUseCompFromDrawing(String useCompFromDrawing) {
    this.useCompFromDrawing = useCompFromDrawing;
  }

  public String getPanel() {
    return this.panel;
  }

  public void setPanel(String panel) {
    this.panel = panel;
  }

  public String getRemovalAssyDataTypeBo() {
    return this.removalAssyDataTypeBo;
  }

  public void setRemovalAssyDataTypeBo(String removalAssyDataTypeBo) {
    this.removalAssyDataTypeBo = removalAssyDataTypeBo;
  }

  public String getInvAssyDataTypeBo() {
    return this.invAssyDataTypeBo;
  }

  public void setInvAssyDataTypeBo(String invAssyDataTypeBo) {
    this.invAssyDataTypeBo = invAssyDataTypeBo;
  }

  public String getOriginalStatusBo() {
    return this.originalStatusBo;
  }

  public void setOriginalStatusBo(String originalStatusBo) {
    this.originalStatusBo = originalStatusBo;
  }

  public Integer getQtyMultiplier() {
    return this.qtyMultiplier;
  }

  public void setQtyMultiplier(Integer qtyMultiplier) {
    this.qtyMultiplier = qtyMultiplier;
  }

  public String getCreateTrackableSfc() {
    return this.createTrackableSfc;
  }

  public void setCreateTrackableSfc(String createTrackableSfc) {
    this.createTrackableSfc = createTrackableSfc;
  }

  public String getMaskGroupBo() {
    return this.maskGroupBo;
  }

  public void setMaskGroupBo(String maskGroupBo) {
    this.maskGroupBo = maskGroupBo;
  }

  public String getTransferItemGroupBo() {
    return this.transferItemGroupBo;
  }

  public void setTransferItemGroupBo(String transferItemGroupBo) {
    this.transferItemGroupBo = transferItemGroupBo;
  }

  public String getUnitOfMeasure() {
    return this.unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public Integer getHoldId() {
    return this.holdId;
  }

  public void setHoldId(Integer holdId) {
    this.holdId = holdId;
  }

  public String getCollectParentSerial() {
    return this.collectParentSerial;
  }

  public void setCollectParentSerial(String collectParentSerial) {
    this.collectParentSerial = collectParentSerial;
  }

  public String getReqSerialChange() {
    return this.reqSerialChange;
  }

  public void setReqSerialChange(String reqSerialChange) {
    this.reqSerialChange = reqSerialChange;
  }

  public String getIsCollector() {
    return this.isCollector;
  }

  public void setIsCollector(String isCollector) {
    this.isCollector = isCollector;
  }

  public String getIncBatchNumber() {
    return this.incBatchNumber;
  }

  public void setIncBatchNumber(String incBatchNumber) {
    this.incBatchNumber = incBatchNumber;
  }

  public String getTimeSensitive() {
    return this.timeSensitive;
  }

  public void setTimeSensitive(String timeSensitive) {
    this.timeSensitive = timeSensitive;
  }

  public Integer getMaxShelfLife() {
    return this.maxShelfLife;
  }

  public void setMaxShelfLife(Integer maxShelfLife) {
    this.maxShelfLife = maxShelfLife;
  }

  public String getMaxShelfLifeUnits() {
    return this.maxShelfLifeUnits;
  }

  public void setMaxShelfLifeUnits(String maxShelfLifeUnits) {
    this.maxShelfLifeUnits = maxShelfLifeUnits;
  }

  public Integer getMaxFloorLife() {
    return this.maxFloorLife;
  }

  public void setMaxFloorLife(Integer maxFloorLife) {
    this.maxFloorLife = maxFloorLife;
  }

  public String getMaxFloorLifeUnits() {
    return this.maxFloorLifeUnits;
  }

  public void setMaxFloorLifeUnits(String maxFloorLifeUnits) {
    this.maxFloorLifeUnits = maxFloorLifeUnits;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getTbCompType() {
    return this.tbCompType;
  }

  public void setTbCompType(String tbCompType) {
    this.tbCompType = tbCompType;
  }

  public Integer getConsumptionTol() {
    return this.consumptionTol;
  }

  public void setConsumptionTol(Integer consumptionTol) {
    this.consumptionTol = consumptionTol;
  }

  public String getErpBackflushing() {
    return this.erpBackflushing;
  }

  public void setErpBackflushing(String erpBackflushing) {
    this.erpBackflushing = erpBackflushing;
  }

  public String getStorageLocationBo() {
    return this.storageLocationBo;
  }

  public void setStorageLocationBo(String storageLocationBo) {
    this.storageLocationBo = storageLocationBo;
  }

  public String getErpPutawayStorloc() {
    return this.erpPutawayStorloc;
  }

  public void setErpPutawayStorloc(String erpPutawayStorloc) {
    this.erpPutawayStorloc = erpPutawayStorloc;
  }

  public String getUseOrderIdRel1() {
    return this.useOrderIdRel1;
  }

  public void setUseOrderIdRel1(String useOrderIdRel1) {
    this.useOrderIdRel1 = useOrderIdRel1;
  }

  @Override
  public String toString() {
    return this.handle + ", " + this.itemGroupBo;
  }

}
