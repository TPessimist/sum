package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class CarrierSfc {

  private String carrierBo;

  private String sfcBo;

  private String updatedUser;

  private Date updatedTime;

  public CarrierSfc() {
  }

  public CarrierSfc(String carrier, String sfcBo) {
    this.carrierBo = carrier;
    this.sfcBo = sfcBo;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
