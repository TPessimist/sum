package ame.me.db;

import java.util.HashMap;
import java.util.List;

public class CustomerSystemLots {


  private String custDevices;
  private HashMap<String, List<String>> lots;
  /**
   * 结果标识：0成功，1失败
   */
  private int error;
  /**
   * 结果提示：提示信息
   */
  private String msg;


  public int getError() {
    return error;
  }

  public void setError(int error) {
    this.error = error;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getCustDevices() {
    return custDevices;
  }

  public void setCustDevices(String custDevices) {
    this.custDevices = custDevices;
  }

  public HashMap<String, List<String>> getLots() {
    return lots;
  }

  public void setLots(HashMap<String, List<String>> lots) {
    this.lots = lots;
  }
}
