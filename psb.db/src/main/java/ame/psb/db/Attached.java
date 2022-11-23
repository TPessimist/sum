package ame.psb.db;

import java.math.BigDecimal;

public class Attached {

  private String handle;

  private String attachmentBo;

  private BigDecimal attachmentSet;

  private BigDecimal keyId;

  private String attachmentType;

  private String attachedToGbo;

  private BigDecimal countTotal;

  private String item;

  private String operation;


  public Attached() {
  }

  public Attached(Attached data) {
    this.handle = data.handle;
    this.attachmentBo = data.attachmentBo;
    this.attachmentSet = data.attachmentSet;
    this.keyId = data.keyId;
    this.attachmentType = data.attachmentType;
    this.attachedToGbo = data.attachedToGbo;
    this.countTotal = data.countTotal;
    this.item = data.item;
    this.operation = data.operation;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getAttachmentBo() {
    return attachmentBo;
  }

  public void setAttachmentBo(String attachmentBo) {
    this.attachmentBo = attachmentBo;
  }

  public BigDecimal getAttachmentSet() {
    return attachmentSet;
  }

  public void setAttachmentSet(BigDecimal attachmentSet) {
    this.attachmentSet = attachmentSet;
  }

  public BigDecimal getKeyId() {
    return keyId;
  }

  public void setKeyId(BigDecimal keyId) {
    this.keyId = keyId;
  }

  public String getAttachmentType() {
    return attachmentType;
  }

  public void setAttachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
  }

  public String getAttachedToGbo() {
    return attachedToGbo;
  }

  public void setAttachedToGbo(String attachedToGbo) {
    this.attachedToGbo = attachedToGbo;
  }

  public BigDecimal getCountTotal() {
    return countTotal;
  }

  public void setCountTotal(BigDecimal countTotal) {
    this.countTotal = countTotal;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  @Override
  public Attached clone() {
    return new Attached(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
