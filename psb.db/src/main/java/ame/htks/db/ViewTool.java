package ame.htks.db;

import java.util.Date;

public class ViewTool extends ZhToolUsage {

  private String toolNumber;

  private String statusBo;

  private String toolGroupBo;

  private String description;

  private String calibrationType;

  private Date calibrationDate;

  private Date expDate;

  private String currentStatus;

  private String comments;

  private Date updateTime;

  public ViewTool() {

  }

  public ViewTool(ViewTool data) {
    super(data);
    this.toolNumber = data.toolNumber;
    this.statusBo = data.statusBo;
    this.toolGroupBo = data.toolGroupBo;
    this.description = data.description;
    this.calibrationType = data.calibrationType;
    this.calibrationDate = data.calibrationDate;
    this.expDate = data.expDate;
    this.currentStatus = data.currentStatus;
    this.comments = data.comments;
    this.updateTime = data.updateTime;
  }

  @Override
  public ViewTool clone() {
    return new ViewTool(this);
  }


  public String getToolNumber() {
    return toolNumber;
  }

  public void setToolNumber(String toolNumber) {
    this.toolNumber = toolNumber;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getToolGroupBo() {
    return toolGroupBo;
  }

  public void setToolGroupBo(String toolGroupBo) {
    this.toolGroupBo = toolGroupBo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getExpDate() {
    return expDate;
  }

  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }


  public String getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(String currentStatus) {
    this.currentStatus = currentStatus;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getCalibrationType() {
    return calibrationType;
  }

  public void setCalibrationType(String calibrationType) {
    this.calibrationType = calibrationType;
  }

  public Date getCalibrationDate() {
    return calibrationDate;
  }

  public void setCalibrationDate(Date calibrationDate) {
    this.calibrationDate = calibrationDate;
  }


  public boolean beAvailable() {
    // if current tool is out of time;
    if (!"N".equals(this.calibrationType) && this.expDate != null && this.expDate
        .before(new Date())) {
      return false;
    }
    // 301:可用 1:使用中
    if (!"StatusBO:1020,301".equals(this.statusBo) && !"StatusBO:1020,1".equals(this.statusBo)) {
      return false;
    }
    return true;
  }


}