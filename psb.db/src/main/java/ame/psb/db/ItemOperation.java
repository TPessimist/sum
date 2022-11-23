package ame.psb.db;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class ItemOperation {

  private boolean newData;

  private String itemBo;

  private String operationBo;

  private String recipeName;

  private int cycleTime;

  private String capability;

  private BigDecimal yieldSfc;

  private BigDecimal yieldSfcItem;

  //add 2019-01-24
  private BigDecimal yieldSfcItemOperation;

  private String dptOwner;

  private String updatedUser;

  private Date updatedTime;

  public String getDptOwner() {
    return this.dptOwner;
  }

  public void setDptOwner(String dptOwner) {
    this.dptOwner = dptOwner;
  }

  public ItemOperation() {
    this.newData = false;
  }

  public ItemOperation(boolean newData) {
    this.newData = newData;
  }

  public boolean isNewData() {
    return this.newData;
  }

  public void setNewData(boolean newData) {
    this.newData = newData;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public int getCycleTime() {
    return this.cycleTime;
  }

  public void setCycleTime(int cycleTime) {
    this.cycleTime = cycleTime;
  }

  public String getCapability() {
    return this.capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public BigDecimal getYieldSfc() {
    return this.yieldSfc;
  }

  public void setYieldSfc(BigDecimal yieldSfc) {
    this.yieldSfc = yieldSfc;
  }

  public BigDecimal getYieldSfcItem() {
    return this.yieldSfcItem;
  }

  public void setYieldSfcItem(BigDecimal yieldSfcItem) {
    this.yieldSfcItem = yieldSfcItem;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public BigDecimal getYieldSfcItemOperation() {
    if (this.yieldSfcItemOperation == null) {
      return BigDecimal.valueOf(0);
    }
    return this.yieldSfcItemOperation;
  }

  public void setYieldSfcItemOperation(BigDecimal yieldSfcItemOperation) {
    this.yieldSfcItemOperation = yieldSfcItemOperation;
  }

  @Override
  public String toString() {
    return this.itemBo + ", " + this.operationBo;
  }


  /**
   * 檢查LOT是否具備特定工作特性。
   *
   * @param capability 工作特性。
   * @return
   */
  public boolean match(String capability) {

    if (Strings.isNullOrEmpty(capability)) {
      return true;
    }
    if (Strings.isNullOrEmpty(this.capability)) {
      return false;
    }

    List<String> cs = Arrays.asList(this.capability.split(","));
    if (cs.size() == 0) {
      return true;
    }
    for (String key : capability.split(",")) {
      if (!cs.contains(key)) {
        return false;
      }
    }
    return true;
  }

}
