package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class BinMapRule {

  private String id;

  private Integer startX;

  private Integer startY;

  private Integer waferDirection;

  private Integer rowCount;

  private Integer colCount;

  private Integer dieQty;

  private Integer lotIdRow;

  private Integer lotIdCol;

  private Integer waferIdRow;

  private Integer waferIdCol;

  private String positive;

  private Integer symbolLength;

  private Integer symbolInterval;

  private String alignmentDieSymbol;

  private String incomingBadDieSymbol;

  private String processBadDieSymbol;

  private String dutms;

  private BigDecimal xdieSize;

  private BigDecimal ydieSize;

  private BigDecimal screenInch;

  private String updatedUser;

  private Date updatedTime;

  private String status;

  private String inkSymbol;

  private String backgroundFileId;

  private Integer stripBlockLength;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getStartX() {
    return this.startX;
  }

  public void setStartX(Integer startX) {
    this.startX = startX;
  }

  public Integer getStartY() {
    return this.startY;
  }

  public void setStartY(Integer startY) {
    this.startY = startY;
  }

  public Integer getWaferDirection() {
    return this.waferDirection;
  }

  public void setWaferDirection(Integer waferDirection) {
    this.waferDirection = waferDirection;
  }

  public Integer getRowCount() {
    return this.rowCount;
  }

  public void setRowCount(Integer rowCount) {
    this.rowCount = rowCount;
  }

  public Integer getColCount() {
    return this.colCount;
  }

  public void setColCount(Integer colCount) {
    this.colCount = colCount;
  }

  public Integer getDieQty() {
    return this.dieQty;
  }

  public void setDieQty(Integer dieQty) {
    this.dieQty = dieQty;
  }

  public Integer getLotIdRow() {
    return this.lotIdRow;
  }

  public void setLotIdRow(Integer lotIdRow) {
    this.lotIdRow = lotIdRow;
  }

  public Integer getLotIdCol() {
    return this.lotIdCol;
  }

  public void setLotIdCol(Integer lotIdCol) {
    this.lotIdCol = lotIdCol;
  }

  public Integer getWaferIdRow() {
    return this.waferIdRow;
  }

  public void setWaferIdRow(Integer waferIdRow) {
    this.waferIdRow = waferIdRow;
  }

  public Integer getWaferIdCol() {
    return this.waferIdCol;
  }

  public void setWaferIdCol(Integer waferIdCol) {
    this.waferIdCol = waferIdCol;
  }

  public String getPositive() {
    return this.positive;
  }

  public void setPositive(String positive) {
    this.positive = positive;
  }

  public Integer getSymbolLength() {
    return this.symbolLength;
  }

  public void setSymbolLength(Integer symbolLength) {
    this.symbolLength = symbolLength;
  }

  public Integer getSymbolInterval() {
    return this.symbolInterval;
  }

  public void setSymbolInterval(Integer symbolInterval) {
    this.symbolInterval = symbolInterval;
  }

  public String getAlignmentDieSymbol() {
    return this.alignmentDieSymbol;
  }

  public void setAlignmentDieSymbol(String alignmentDieSymbol) {
    this.alignmentDieSymbol = alignmentDieSymbol;
  }

  public String getIncomingBadDieSymbol() {
    return this.incomingBadDieSymbol;
  }

  public void setIncomingBadDieSymbol(String incomingBadDieSymbol) {
    this.incomingBadDieSymbol = incomingBadDieSymbol;
  }

  public String getProcessBadDieSymbol() {
    return this.processBadDieSymbol;
  }

  public void setProcessBadDieSymbol(String processBadDieSymbol) {
    this.processBadDieSymbol = processBadDieSymbol;
  }

  public String getDutms() {
    return this.dutms;
  }

  public void setDutms(String dutms) {
    this.dutms = dutms;
  }

  public BigDecimal getXdieSize() {
    return this.xdieSize;
  }

  public void setXdieSize(BigDecimal xdieSize) {
    this.xdieSize = xdieSize;
  }

  public BigDecimal getYdieSize() {
    return this.ydieSize;
  }

  public void setYdieSize(BigDecimal ydieSize) {
    this.ydieSize = ydieSize;
  }

  public BigDecimal getScreenInch() {
    return screenInch;
  }

  public void setScreenInch(BigDecimal screenInch) {
    this.screenInch = screenInch;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getInkSymbol() {
    return inkSymbol;
  }

  public void setInkSymbol(String inkSymbol) {
    this.inkSymbol = inkSymbol;
  }

  public String getBackgroundFileId() {
    return backgroundFileId;
  }

  public void setBackgroundFileId(String backgroundFileId) {
    this.backgroundFileId = backgroundFileId;
  }

  public Integer getStripBlockLength() {
    return stripBlockLength;
  }

  public void setStripBlockLength(Integer stripBlockLength) {
    this.stripBlockLength = stripBlockLength;
  }

}
