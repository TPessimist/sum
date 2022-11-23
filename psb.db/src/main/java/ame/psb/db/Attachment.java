package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class Attachment {

  private String handle;

  private String site;

  private String attachedFromGbo;

  private BigDecimal sequence;

  private BigDecimal keyId;

  private BigDecimal qtyReq;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public Attachment() {
  }

  public Attachment(Attachment data) {
    this.handle = data.handle;
    this.site = data.site;
    this.attachedFromGbo = data.attachedFromGbo;
    this.sequence = data.sequence;
    this.keyId = data.keyId;
    this.qtyReq = data.qtyReq;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getAttachedFromGbo() {
    return attachedFromGbo;
  }

  public void setAttachedFromGbo(String attachedFromGbo) {
    this.attachedFromGbo = attachedFromGbo;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public BigDecimal getKeyId() {
    return keyId;
  }

  public void setKeyId(BigDecimal keyId) {
    this.keyId = keyId;
  }

  public BigDecimal getQtyReq() {
    return qtyReq;
  }

  public void setQtyReq(BigDecimal qtyReq) {
    this.qtyReq = qtyReq;
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

  @Override
  public Attachment clone() {
    return new Attachment(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
