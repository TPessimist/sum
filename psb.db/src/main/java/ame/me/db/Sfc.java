package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class Sfc {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String sfc;

  private String statusBo;

  private String shopOrderBo;

  private BigDecimal qty;

  private BigDecimal qtyDone;

  private BigDecimal qtyScrapped;

  private BigDecimal qtyHistoricalMin;

  private BigDecimal qtyHistoricalMax;

  private String itemBo;

  private BigDecimal priority;

  private String location;

  private BigDecimal rmaMaxTimesProcessed;

  private String lccBo;

  private String originalStatusBo;

  private String qtyMultPerformed;

  private Date actualCompDate;

  private String prevSite;

  private String originalTransferKey;

  private String immediateArchive;

  private Date transferDatetime;

  private String transferUser;

  private String snDone;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private Date partitionDate;


  public Sfc() {
  }

  public Sfc(Sfc data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.sfc = data.sfc;
    this.statusBo = data.statusBo;
    this.shopOrderBo = data.shopOrderBo;
    this.qty = data.qty;
    this.qtyDone = data.qtyDone;
    this.qtyScrapped = data.qtyScrapped;
    this.qtyHistoricalMin = data.qtyHistoricalMin;
    this.qtyHistoricalMax = data.qtyHistoricalMax;
    this.itemBo = data.itemBo;
    this.priority = data.priority;
    this.location = data.location;
    this.rmaMaxTimesProcessed = data.rmaMaxTimesProcessed;
    this.lccBo = data.lccBo;
    this.originalStatusBo = data.originalStatusBo;
    this.qtyMultPerformed = data.qtyMultPerformed;
    this.actualCompDate = data.actualCompDate;
    this.prevSite = data.prevSite;
    this.originalTransferKey = data.originalTransferKey;
    this.immediateArchive = data.immediateArchive;
    this.transferDatetime = data.transferDatetime;
    this.transferUser = data.transferUser;
    this.snDone = data.snDone;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.partitionDate = data.partitionDate;
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

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
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

  public BigDecimal getQtyHistoricalMin() {
    return qtyHistoricalMin;
  }

  public void setQtyHistoricalMin(BigDecimal qtyHistoricalMin) {
    this.qtyHistoricalMin = qtyHistoricalMin;
  }

  public BigDecimal getQtyHistoricalMax() {
    return qtyHistoricalMax;
  }

  public void setQtyHistoricalMax(BigDecimal qtyHistoricalMax) {
    this.qtyHistoricalMax = qtyHistoricalMax;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public BigDecimal getPriority() {
    return priority;
  }

  public void setPriority(BigDecimal priority) {
    this.priority = priority;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public BigDecimal getRmaMaxTimesProcessed() {
    return rmaMaxTimesProcessed;
  }

  public void setRmaMaxTimesProcessed(BigDecimal rmaMaxTimesProcessed) {
    this.rmaMaxTimesProcessed = rmaMaxTimesProcessed;
  }

  public String getLccBo() {
    return lccBo;
  }

  public void setLccBo(String lccBo) {
    this.lccBo = lccBo;
  }

  public String getOriginalStatusBo() {
    return originalStatusBo;
  }

  public void setOriginalStatusBo(String originalStatusBo) {
    this.originalStatusBo = originalStatusBo;
  }

  public String getQtyMultPerformed() {
    return qtyMultPerformed;
  }

  public void setQtyMultPerformed(String qtyMultPerformed) {
    this.qtyMultPerformed = qtyMultPerformed;
  }

  public Date getActualCompDate() {
    return actualCompDate;
  }

  public void setActualCompDate(Date actualCompDate) {
    this.actualCompDate = actualCompDate;
  }

  public String getPrevSite() {
    return prevSite;
  }

  public void setPrevSite(String prevSite) {
    this.prevSite = prevSite;
  }

  public String getOriginalTransferKey() {
    return originalTransferKey;
  }

  public void setOriginalTransferKey(String originalTransferKey) {
    this.originalTransferKey = originalTransferKey;
  }

  public String getImmediateArchive() {
    return immediateArchive;
  }

  public void setImmediateArchive(String immediateArchive) {
    this.immediateArchive = immediateArchive;
  }

  public Date getTransferDatetime() {
    return transferDatetime;
  }

  public void setTransferDatetime(Date transferDatetime) {
    this.transferDatetime = transferDatetime;
  }

  public String getTransferUser() {
    return transferUser;
  }

  public void setTransferUser(String transferUser) {
    this.transferUser = transferUser;
  }

  public String getSnDone() {
    return snDone;
  }

  public void setSnDone(String snDone) {
    this.snDone = snDone;
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

  @Override
  public Sfc clone() {
    return new Sfc(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
