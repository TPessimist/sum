package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class DummyCount {

  private String id;

  private String dummyPlanBo;

  private BigDecimal currentTimes;

  private BigDecimal dummyTimes;

  private BigDecimal currentCount;

  private BigDecimal dummyCount;

  private Date lastTime;

  private String stateName;


  public DummyCount() {
    this.id = UUID.randomUUID().toString();
  }

  public DummyCount(DummyCount data) {
    this.id = data.id;
    this.dummyPlanBo = data.dummyPlanBo;
    this.currentTimes = data.currentTimes;
    this.dummyTimes = data.dummyTimes;
    this.currentCount = data.currentCount;
    this.dummyCount = data.dummyCount;
    this.lastTime = data.lastTime;
    this.stateName = data.stateName;
  }

  @Override
  public DummyCount clone() {
    return new DummyCount(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDummyPlanBo() {
    return dummyPlanBo;
  }

  public void setDummyPlanBo(String dummyPlanBo) {
    this.dummyPlanBo = dummyPlanBo;
  }

  public BigDecimal getCurrentTimes() {
    return currentTimes;
  }

  public void setCurrentTimes(BigDecimal currentTimes) {
    this.currentTimes = currentTimes;
  }

  public BigDecimal getDummyTimes() {
    return dummyTimes;
  }

  public void setDummyTimes(BigDecimal dummyTimes) {
    this.dummyTimes = dummyTimes;
  }

  public BigDecimal getCurrentCount() {
    return currentCount;
  }

  public void setCurrentCount(BigDecimal currentCount) {
    this.currentCount = currentCount;
  }

  public BigDecimal getDummyCount() {
    return dummyCount;
  }

  public void setDummyCount(BigDecimal dummyCount) {
    this.dummyCount = dummyCount;
  }

  public Date getLastTime() {
    return lastTime;
  }

  public void setLastTime(Date lastTime) {
    this.lastTime = lastTime;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }
}