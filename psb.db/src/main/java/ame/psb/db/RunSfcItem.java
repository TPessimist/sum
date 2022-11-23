package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

/**
 * Table: SFC 的 "Shop Order 項目" 在特定站點的執行紀錄。
 *
 * @author Kyle K. Lin
 */
@Entity
public class RunSfcItem extends Run {

  private String runSfc;

  private String sfcBo;

  private String customerItem;

  private String customerItemBo;

  private Date dateTime;

  public RunSfcItem() {
    super("SFCITEM");
  }

  public RunSfcItem(RunSfcItem data) {
    super("SFCITEM", data);
    this.runSfc = data.runSfc;
    this.sfcBo = data.sfcBo;
    this.customerItem = data.customerItem;
    this.customerItemBo = data.customerItemBo;
    this.dateTime = data.dateTime;
  }

  public String getRunSfc() {
    return this.runSfc;
  }

  public void setRunSfc(String runSfc) {
    this.runSfc = runSfc;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItem() {
    return this.customerItem;
  }

  public void setCustomerItem(String customerItem) {
    this.customerItem = customerItem;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  @Override
  public String toString() {
    return getId() + "@" + this.runSfc + "," + getStateName();
  }

}
