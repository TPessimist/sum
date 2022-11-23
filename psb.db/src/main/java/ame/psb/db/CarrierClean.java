package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class CarrierClean {

  private String id;

  private String subId;

  private String name;

  private String carrierTool;

  private String stateName;

  private String type;

  private String cleanUser;

  private Date startTime;

  private Date endTime;

  public CarrierClean() {
    this.id = UUID.randomUUID().toString();
  }

  public CarrierClean(CarrierClean data) {
    this.id = data.id;
    this.subId = data.subId;
    this.name = data.name;
    this.carrierTool = data.carrierTool;
    this.stateName = data.stateName;
    this.type = data.type;
    this.cleanUser = data.cleanUser;
    this.startTime = data.startTime;
    this.endTime = data.endTime;
  }

  @Override
  public CarrierClean clone() {
    return new CarrierClean(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubId() {
    return subId;
  }

  public void setSubId(String subId) {
    this.subId = subId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCarrierTool() {
    return this.carrierTool;
  }

  public void setCarrierTool(String carrierTool) {
    this.carrierTool = carrierTool;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCleanUser() {
    return this.cleanUser;
  }

  public void setCleanUser(String cleanUser) {
    this.cleanUser = cleanUser;
  }

  /**
   * 取得清洗週期起算時間。
   *
   * @return 清洗週期起算時間。
   */
  public Date getStartTime() {
    return this.startTime;
  }

  /**
   * 設定清洗週期起算時間。
   *
   * @param startTime 清洗週期起算時間。
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
}