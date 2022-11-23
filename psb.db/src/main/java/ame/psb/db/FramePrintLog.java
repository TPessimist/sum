package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class FramePrintLog {

  private String id;

  private String sfc;

  private String seq;

  private String inventoryId;

  private String firstStripId;

  private String lastStripId;

  private String stripQty;

  private String dieQty;

  private String resrce;

  private String frameItemBo;

  private String frameItem;

  private String frameItemRevision;

  private String frameModel;

  private String frameSpec;

  private String singleQty;

  private Date processTime;

  private Date createTime;

  private String stripId;

  private String frameId;


  public FramePrintLog() {
    this.id = UUID.randomUUID().toString();
    this.createTime = new Date();
  }

  public FramePrintLog(FramePrintLog data) {
    this.id = UUID.randomUUID().toString();
    this.sfc = data.sfc;
    this.seq = data.seq;
    this.inventoryId = data.inventoryId;
    this.firstStripId = data.firstStripId;
    this.lastStripId = data.lastStripId;
    this.stripQty = data.stripQty;
    this.dieQty = data.dieQty;
    this.resrce = data.resrce;
    this.frameItemBo = data.frameItemBo;
    this.frameItem = data.frameItem;
    this.frameItemRevision = data.frameItemRevision;
    this.frameModel = data.frameModel;
    this.frameSpec = data.frameSpec;
    this.singleQty = data.singleQty;
    this.processTime = data.processTime;
    this.createTime = data.createTime;
    this.stripId = data.stripId;
    this.frameId = data.frameId;
  }

  @Override
  public FramePrintLog clone() {
    return new FramePrintLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getFirstStripId() {
    return firstStripId;
  }

  public void setFirstStripId(String firstStripId) {
    this.firstStripId = firstStripId;
  }

  public String getLastStripId() {
    return lastStripId;
  }

  public void setLastStripId(String lastStripId) {
    this.lastStripId = lastStripId;
  }

  public String getStripQty() {
    return stripQty;
  }

  public void setStripQty(String stripQty) {
    this.stripQty = stripQty;
  }

  public String getDieQty() {
    return dieQty;
  }

  public void setDieQty(String dieQty) {
    this.dieQty = dieQty;
  }

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getFrameItemBo() {
    return frameItemBo;
  }

  public void setFrameItemBo(String frameItemBo) {
    this.frameItemBo = frameItemBo;
  }

  public String getFrameItem() {
    return frameItem;
  }

  public void setFrameItem(String frameItem) {
    this.frameItem = frameItem;
  }

  public String getFrameItemRevision() {
    return frameItemRevision;
  }

  public void setFrameItemRevision(String frameItemRevision) {
    this.frameItemRevision = frameItemRevision;
  }

  public String getFrameModel() {
    return frameModel;
  }

  public void setFrameModel(String frameModel) {
    this.frameModel = frameModel;
  }

  public String getFrameSpec() {
    return frameSpec;
  }

  public void setFrameSpec(String frameSpec) {
    this.frameSpec = frameSpec;
  }

  public String getSingleQty() {
    return singleQty;
  }

  public void setSingleQty(String singleQty) {
    this.singleQty = singleQty;
  }

  public Date getProcessTime() {
    return processTime;
  }

  public void setProcessTime(Date processTime) {
    this.processTime = processTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getStripId() {
    return stripId;
  }

  public void setStripId(String stripId) {
    this.stripId = stripId;
  }

  public String getFrameId() {
    return frameId;
  }

  public void setFrameId(String frameId) {
    this.frameId = frameId;
  }
}
