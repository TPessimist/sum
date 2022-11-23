package ame.me.db;

import java.util.Date;

public class ZdWtrQcGate {

  private String id;

  private String sfcBo;

  private String sfc;

  private String comparisonResults;

  private String remarks1;

  private String remarks2;

  private String remarks3;

  private String remarks4;

  private String remarks5;

  private String remarks6;

  private String remarks7;

  private String updatedUser;

  private Date updatedTime;

  public ZdWtrQcGate() {
  }

  public ZdWtrQcGate(ZdWtrQcGate data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.sfc = data.sfc;
    this.comparisonResults = data.comparisonResults;
    this.remarks1 = data.remarks1;
    this.remarks2 = data.remarks2;
    this.remarks3 = data.remarks3;
    this.remarks4 = data.remarks4;
    this.remarks5 = data.remarks5;
    this.remarks6 = data.remarks6;
    this.remarks7 = data.remarks7;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getComparisonResults() {
    return comparisonResults;
  }

  public void setComparisonResults(String comparisonResults) {
    this.comparisonResults = comparisonResults;
  }

  public String getRemarks1() {
    return remarks1;
  }

  public void setRemarks1(String remarks1) {
    this.remarks1 = remarks1;
  }

  public String getRemarks2() {
    return remarks2;
  }

  public void setRemarks2(String remarks2) {
    this.remarks2 = remarks2;
  }

  public String getRemarks3() {
    return remarks3;
  }

  public void setRemarks3(String remarks3) {
    this.remarks3 = remarks3;
  }

  public String getRemarks4() {
    return remarks4;
  }

  public void setRemarks4(String remarks4) {
    this.remarks4 = remarks4;
  }

  public String getRemarks5() {
    return remarks5;
  }

  public void setRemarks5(String remarks5) {
    this.remarks5 = remarks5;
  }

  public String getRemarks6() {
    return remarks6;
  }

  public void setRemarks6(String remarks6) {
    this.remarks6 = remarks6;
  }

  public String getRemarks7() {
    return remarks7;
  }

  public void setRemarks7(String remarks7) {
    this.remarks7 = remarks7;
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
  public ZdWtrQcGate clone() {
    return new ZdWtrQcGate(this);
  }

  @Override
  public String toString() {
    return this.id + ", " + this.sfcBo;
  }
}
