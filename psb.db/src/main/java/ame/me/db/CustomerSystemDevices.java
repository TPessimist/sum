package ame.me.db;

import java.util.HashMap;
import java.util.List;

public class CustomerSystemDevices {


  private HashMap<String, List<String>> custDevices;
  /**
   * 结果标识：0成功，1失败
   */
  private int error;
  /**
   * 结果提示：提示信息
   */
  private String msg;

  public CustomerSystemDevices() {
    this.custDevices = new HashMap<>();
  }

  public HashMap<String, List<String>> getCustDevices() {
    return custDevices;
  }

  public void setCustDevices(HashMap<String, List<String>> custDevices) {
    this.custDevices = custDevices;
  }

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
}
