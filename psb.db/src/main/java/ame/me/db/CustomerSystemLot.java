package ame.me.db;

import java.util.ArrayList;
import java.util.List;

public class CustomerSystemLot {

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
  private List<String> testProgram;
  /**
   * wafers
   */
  private List<String> wafers;


  public CustomerSystemLot() {
    this.wafers = new ArrayList<>();
    this.testProgram = new ArrayList<>();
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

  public List<String> getTestProgram() {
    return testProgram;
  }

  public void setTestProgram(List<String> testProgram) {
    this.testProgram = testProgram;
  }

  public List<String> getWafers() {
    return wafers;
  }

  public void setWafers(List<String> wafers) {
    this.wafers = wafers;
  }
}
