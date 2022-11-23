package ame.me.db;

import java.util.List;

/**
 * zxj
 */
public class CustomerSystemWaferResult {

  //厂内机种
  private String device;
  //站点
  private String site;

  /**
   * 厂内批次list
   */
  private String lot;
  /**
   * 客户型号
   */
  private String custDevice;
  /**
   * 客户批次
   */
  private String custLot;
  /**
   * 测试程序
   */
  private String testProgram;

  /**
   * wafers
   */
  private List<String> wafers;

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getLot() {
    return lot;
  }

  public void setLot(String lot) {
    this.lot = lot;
  }

  public String getCustDevice() {
    return custDevice;
  }

  public void setCustDevice(String custDevice) {
    this.custDevice = custDevice;
  }

  public String getCustLot() {
    return custLot;
  }

  public void setCustLot(String custLot) {
    this.custLot = custLot;
  }

  public String getTestProgram() {
    return testProgram;
  }

  public void setTestProgram(String testProgram) {
    this.testProgram = testProgram;
  }

  public List<String> getWafers() {
    return wafers;
  }

  public void setWafers(List<String> wafers) {
    this.wafers = wafers;
  }
}
