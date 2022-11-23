package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ViewResourceEx extends ResourceEx {

  private String site;

  private String resourceName;

  private String description;

  private String statusBo;

  private Date validFrom;

  private Date validTo;

  private String pendingStatusBo;

  private String pendingComments;

  private String pendingReasonCodeBo;

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
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

  public Date getValidFrom() {
    return this.validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return this.validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public String getPendingStatusBo() {
    return this.pendingStatusBo;
  }

  public void setPendingStatusBo(String pendingStatusBo) {
    this.pendingStatusBo = pendingStatusBo;
  }

  public String getPendingComments() {
    return this.pendingComments;
  }

  public void setPendingComments(String pendingComments) {
    this.pendingComments = pendingComments;
  }

  public String getPendingReasonCodeBo() {
    return this.pendingReasonCodeBo;
  }

  public void setPendingReasonCodeBo(String pendingReasonCodeBo) {
    this.pendingReasonCodeBo = pendingReasonCodeBo;
  }

  @Override
  public String toString() {
    return getVirtual() + ":" + this.resourceName + "," + super.toString();
  }

}
