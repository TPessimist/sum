package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class CustomerItemDefect {

  private String customerItemBo;

  private String ncCodeBo;

  private int ncValue;

  private String updatedUser;

  private Date updatedTime;

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getNcCodeBo() {
    return this.ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public int getNcValue() {
    return this.ncValue;
  }

  public void setNcValue(int ncValue) {
    this.ncValue = ncValue;
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

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.ncCodeBo;
  }
}