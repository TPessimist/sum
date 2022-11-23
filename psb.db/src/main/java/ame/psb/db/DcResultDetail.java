package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class DcResultDetail {

  private String dcResultBo;

  private String customerItemBo;

  private int dieCount;

  private int dcCount;

  private String stateName;

  public String getDcResultBo() {
    return this.dcResultBo;
  }

  public void setDcResultBo(String dcResultBo) {
    this.dcResultBo = dcResultBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public int getDieCount() {
    return this.dieCount;
  }

  public void setDieCount(int dieCount) {
    this.dieCount = dieCount;
  }

  public int getDcCount() {
    return this.dcCount;
  }

  public void setDcCount(int dcCount) {
    this.dcCount = dcCount;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public String toString() {
    return this.dcResultBo;
  }
}
