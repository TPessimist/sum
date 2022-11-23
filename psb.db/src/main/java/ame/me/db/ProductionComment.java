package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class ProductionComment {

  private String handle;

  private String site;

  private String contextGbo;

  private BigDecimal sequence;

  private String userBo;

  private String comments;

  private String activity;

  private String commentType;

  private String state;

  private String reasonCodeBo;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String productionContextGbo;

  private String txnId;


  public ProductionComment() {
  }

  public ProductionComment(ProductionComment data) {
    this.handle = data.handle;
    this.site = data.site;
    this.contextGbo = data.contextGbo;
    this.sequence = data.sequence;
    this.userBo = data.userBo;
    this.comments = data.comments;
    this.activity = data.activity;
    this.commentType = data.commentType;
    this.state = data.state;
    this.reasonCodeBo = data.reasonCodeBo;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.productionContextGbo = data.productionContextGbo;
    this.txnId = data.txnId;
  }

  @Override
  public ProductionComment clone() {
    return new ProductionComment(this);
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

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getContextGbo() {
    return contextGbo;
  }

  public void setContextGbo(String contextGbo) {
    this.contextGbo = contextGbo;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getUserBo() {
    return userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public String getCommentType() {
    return commentType;
  }

  public void setCommentType(String commentType) {
    this.commentType = commentType;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getReasonCodeBo() {
    return reasonCodeBo;
  }

  public void setReasonCodeBo(String reasonCodeBo) {
    this.reasonCodeBo = reasonCodeBo;
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

  public String getProductionContextGbo() {
    return productionContextGbo;
  }

  public void setProductionContextGbo(String productionContextGbo) {
    this.productionContextGbo = productionContextGbo;
  }

  public String getTxnId() {
    return txnId;
  }

  public void setTxnId(String txnId) {
    this.txnId = txnId;
  }
}