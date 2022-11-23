package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class CarrierType {

  private String handle;

  private String site;

  private String carrierType;

  private String description;

  private BigDecimal capacity;

  private BigDecimal rowSize;

  private BigDecimal columnSize;

  private String sequencePriority;

  private String category;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public CarrierType() {
  }

  public CarrierType(CarrierType data) {
    this.handle = data.handle;
    this.site = data.site;
    this.carrierType = data.carrierType;
    this.description = data.description;
    this.capacity = data.capacity;
    this.rowSize = data.rowSize;
    this.columnSize = data.columnSize;
    this.sequencePriority = data.sequencePriority;
    this.category = data.category;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public CarrierType clone() {
    return new CarrierType(this);
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

  public String getCarrierType() {
    return carrierType;
  }

  public void setCarrierType(String carrierType) {
    this.carrierType = carrierType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getCapacity() {
    return capacity;
  }

  public void setCapacity(BigDecimal capacity) {
    this.capacity = capacity;
  }

  public BigDecimal getRowSize() {
    return rowSize;
  }

  public void setRowSize(BigDecimal rowSize) {
    this.rowSize = rowSize;
  }

  public BigDecimal getColumnSize() {
    return columnSize;
  }

  public void setColumnSize(BigDecimal columnSize) {
    this.columnSize = columnSize;
  }

  public String getSequencePriority() {
    return sequencePriority;
  }

  public void setSequencePriority(String sequencePriority) {
    this.sequencePriority = sequencePriority;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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
}