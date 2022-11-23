package ame.me.db;

import java.util.ArrayList;
import java.util.List;

public class CustomerSystemSuper {

  private List<CustomerSystemLot> lots;

  /**
   * 结果 0 1
   */
  private int error;
  /**
   * 结果提示：提示信息
   */
  private String msg;

  public CustomerSystemSuper() {
    this.lots = new ArrayList<>();
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

  public List<CustomerSystemLot> getLots() {
    return lots;
  }

  public void setLots(List<CustomerSystemLot> lots) {
    this.lots = lots;
  }
}
