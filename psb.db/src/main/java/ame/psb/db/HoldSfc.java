package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class HoldSfc extends AbstractLoggable {

  private String holdDetailBo;

  private String carrierBo;

  private String runSfcBo;

  private String eeApproved;

  private String holdReleaseBo;

  private String updatedUser;

  private Date updatedTime;

  private String department;

  private String uploadPath;

  public String getHoldDetailBo() {
    return this.holdDetailBo;
  }

  public void setHoldDetailBo(String holdDetailBo) {
    this.holdDetailBo = holdDetailBo;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getRunSfcBo() {
    return this.runSfcBo;
  }

  public void setRunSfcBo(String runSfcBo) {
    this.runSfcBo = runSfcBo;
  }

  public String getEeApproved() {
    return this.eeApproved;
  }

  public void setEeApproved(String eeApproved) {
    this.eeApproved = eeApproved;
  }

  public String getHoldReleaseBo() {
    return this.holdReleaseBo;
  }

  public void setHoldReleaseBo(String holdReleaseBo) {
    this.holdReleaseBo = holdReleaseBo;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUploadPath() {
    return uploadPath;
  }

  public void setUploadPath(String uploadPath) {
    this.uploadPath = uploadPath;
  }

  @Override
  public String getTableName() {
    return "ZD_DC_PLAN";
  }

  @Override
  public String getLogUser() {
    return this.updatedUser;
  }

  @Override
  public Date getLogDateTime() {
    return this.updatedTime;
  }

  @Override
  public String toString() {
    return this.holdDetailBo;
  }

}
