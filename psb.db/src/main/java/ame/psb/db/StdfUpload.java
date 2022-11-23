package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class StdfUpload {

  private String id;

  private String filePath;

  private String stateName;

  private Date createdTime;

  private Date processedTime;

  private String binmapBo;

  private String operationBo;

  private String sfcBo;

  private String waferBo;

  private String deviceBo;

  private String custLotId;

  private String custWaferId;

  private String custDeviceId;

  private int grossDie;

  private int rows;

  private int cols;

  private String notch;

  private String packageBo;

  private String shareFolder;

  private String probeResourceBo;

  private String testResourceBo;

  private String reportId;

  private String stdfLotId;

  private String stdfSubLotId;

  private String checkSum;

  private String fileType;

  private String proberCard;

  private String tskResult;

  public StdfUpload() {
    this.id = UUID.randomUUID().toString();
  }

  public StdfUpload(StdfUpload data) {
    this.id = data.id;
    this.filePath = data.filePath;
    this.stateName = data.stateName;
    this.createdTime = data.createdTime;
    this.processedTime = data.processedTime;
    this.binmapBo = data.binmapBo;
    this.operationBo = data.operationBo;
    this.sfcBo = data.sfcBo;
    this.waferBo = data.waferBo;
    this.deviceBo = data.deviceBo;
    this.custLotId = data.custLotId;
    this.custWaferId = data.custWaferId;
    this.custDeviceId = data.custDeviceId;
    this.grossDie = data.grossDie;
    this.rows = data.rows;
    this.cols = data.cols;
    this.notch = data.notch;
    this.packageBo = data.packageBo;
    this.shareFolder = data.shareFolder;
    this.probeResourceBo = data.probeResourceBo;
    this.testResourceBo = data.testResourceBo;
    this.reportId = data.reportId;
    this.stdfLotId = data.stdfLotId;
    this.stdfSubLotId = data.stdfSubLotId;
    this.checkSum = data.checkSum;
    this.proberCard = data.proberCard;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getProcessedTime() {
    return processedTime;
  }

  public void setProcessedTime(Date processedTime) {
    this.processedTime = processedTime;
  }

  public String getBinmapBo() {
    return binmapBo;
  }

  public void setBinmapBo(String binmapBo) {
    this.binmapBo = binmapBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getWaferBo() {
    return waferBo;
  }

  public void setWaferBo(String waferBo) {
    this.waferBo = waferBo;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getCustLotId() {
    return custLotId;
  }

  public void setCustLotId(String custLotId) {
    this.custLotId = custLotId;
  }

  public String getCustWaferId() {
    return custWaferId;
  }

  public void setCustWaferId(String custWaferId) {
    this.custWaferId = custWaferId;
  }

  public String getCustDeviceId() {
    return custDeviceId;
  }

  public void setCustDeviceId(String custDeviceId) {
    this.custDeviceId = custDeviceId;
  }

  public int getGrossDie() {
    return grossDie;
  }

  public void setGrossDie(int grossDie) {
    this.grossDie = grossDie;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getCols() {
    return cols;
  }

  public void setCols(int cols) {
    this.cols = cols;
  }

  public String getNotch() {
    return notch;
  }

  public void setNotch(String notch) {
    this.notch = notch;
  }

  public String getPackageBo() {
    return packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getShareFolder() {
    return shareFolder;
  }

  public void setShareFolder(String shareFolder) {
    this.shareFolder = shareFolder;
  }

  public String getProbeResourceBo() {
    return probeResourceBo;
  }

  public void setProbeResourceBo(String probeResourceBo) {
    this.probeResourceBo = probeResourceBo;
  }

  public String getTestResourceBo() {
    return testResourceBo;
  }

  public void setTestResourceBo(String testResourceBo) {
    this.testResourceBo = testResourceBo;
  }

  public String getReportId() {
    return reportId;
  }

  public void setReportId(String reportId) {
    this.reportId = reportId;
  }

  public String getStdfLotId() {
    return stdfLotId;
  }

  public void setStdfLotId(String stdfLotId) {
    this.stdfLotId = stdfLotId;
  }

  public String getStdfSubLotId() {
    return stdfSubLotId;
  }

  public void setStdfSubLotId(String stdfSubLotId) {
    this.stdfSubLotId = stdfSubLotId;
  }

  public String getCheckSum() {
    return checkSum;
  }

  public void setCheckSum(String checkSum) {
    this.checkSum = checkSum;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getProberCard() {
    return proberCard;
  }

  public void setProberCard(String proberCard) {
    this.proberCard = proberCard;
  }

  public String getTskResult() {
    return tskResult;
  }

  public void setTskResult(String tskResult) {
    this.tskResult = tskResult;
  }

  @Override
  public StdfUpload clone() {
    return new StdfUpload(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
