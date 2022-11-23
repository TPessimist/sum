package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrier implements Comparable<Carrier> {

  @Id
  private String id;

  private String carrierName;

  private String carrierType;

  private String stateName;

  private String currentRun;

  private String operationBo;

  private String updatedUser;

  private Date updatedTime;

  private String description;

  private long capacity;

  private long cleanCycle;

  private Date buyTime;

  private Date lastCleanTime;

  private int maxUsage;

  private int nowUsage;

  private String timeFlag;


  public Carrier() {

  }

  public Carrier(Carrier data) {
    this.id = (data.carrierType + "::" + data.carrierName).toUpperCase();
    this.carrierName = data.carrierName;
    this.carrierType = data.carrierType;
    this.stateName = data.stateName;
    this.currentRun = data.currentRun;
    this.operationBo = data.operationBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.description = data.description;
    this.capacity = data.capacity;
    this.cleanCycle = data.cleanCycle;
    this.buyTime = data.buyTime;
    this.lastCleanTime = data.lastCleanTime;
    this.maxUsage = data.maxUsage;
    this.nowUsage = data.nowUsage;
  }

  public Carrier(String carrierName, String carrierType, String stateName) {
    this.id = (carrierType + "::" + carrierName).toUpperCase();
    this.carrierName = carrierName;
    this.carrierType = carrierType;
    this.stateName = stateName;
  }

  public Carrier(String carrierType) {
    this.id = UUID.randomUUID().toString();
    this.carrierType = carrierType;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCarrierName() {
    return this.carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getCarrierType() {
    return this.carrierType;
  }

  public void setCarrierType(String carrierType) {
    this.carrierType = carrierType;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCurrentRun() {
    return this.currentRun;
  }

  public void setCurrentRun(String currentRun) {
    this.currentRun = currentRun;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
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

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getCapacity() {
    return this.capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }

  public String getTimeFlag() {
    return timeFlag;
  }

  public void setTimeFlag(String timeFlag) {
    this.timeFlag = timeFlag;
  }

  /**
   * 取得清洗週期，分鐘。
   *
   * @return 清洗週期，分鐘。
   */
  public long getCleanCycle() {
    return this.cleanCycle;
  }

  /**
   * 設定清洗週期，分鐘。
   *
   * @param cleanCycle 清洗週期，分鐘。
   */
  public void setCleanCycle(long cleanCycle) {
    this.cleanCycle = cleanCycle;
  }

  public Date getBuyTime() {
    return this.buyTime;
  }

  public void setBuyTime(Date buyTime) {
    this.buyTime = buyTime;
  }

  public Date getLastCleanTime() {
    return this.lastCleanTime;
  }

  public void setLastCleanTime(Date lastCleanTime) {
    this.lastCleanTime = lastCleanTime;
  }

  public int getMaxUsage() {
    return maxUsage;
  }

  public void setMaxUsage(int maxUsage) {
    this.maxUsage = maxUsage;
  }

  public int getNowUsage() {
    return nowUsage;
  }

  public void setNowUsage(int nowUsage) {
    this.nowUsage = nowUsage;
  }

  @Override
  public boolean equals(Object o) {
    return o != null && o instanceof Carrier && ((Carrier) o).getId().equals(this.id);
  }

  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  @Override
  public int compareTo(Carrier carrier) {
    return this.id.compareTo(carrier.id);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
