package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class NcCode {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String ncCode;

  private String description;

  private String statusBo;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String ncCategory;

  private String dpmoCategoryBo;

  public NcCode() {
  }

  public NcCode(NcCode data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.ncCode = data.ncCode;
    this.description = data.description;
    this.statusBo = data.statusBo;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.ncCategory = data.ncCategory;
    this.dpmoCategoryBo = data.dpmoCategoryBo;
  }

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

  public String getNcCode() {
    return this.ncCode;
  }

  public void setNcCode(String ncCode) {
    this.ncCode = ncCode;
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

  public String getNcCategory() {
    return this.ncCategory;
  }

  public void setNcCategory(String ncCategory) {
    this.ncCategory = ncCategory;
  }

  public String getDpmoCategoryBo() {
    return this.dpmoCategoryBo;
  }

  public void setDpmoCategoryBo(String dpmoCategoryBo) {
    this.dpmoCategoryBo = dpmoCategoryBo;
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
