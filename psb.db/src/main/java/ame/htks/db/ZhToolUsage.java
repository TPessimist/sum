package ame.htks.db;

import java.math.BigDecimal;
import java.util.Date;

public class ZhToolUsage {

  private String toolNumberBo;

  private BigDecimal toolLimitTimes;

  private BigDecimal toolUsage;

  private Date eventDatetime;

  private BigDecimal limitCleanDayTime;

  private BigDecimal sumUsage;

  private BigDecimal sumLimitTimes;

  private String updateUser;


  public ZhToolUsage() {

  }

  public ZhToolUsage(ZhToolUsage data) {
    this.toolNumberBo = data.toolNumberBo;
    this.toolLimitTimes = data.toolLimitTimes;
    this.toolUsage = data.toolUsage;
    this.eventDatetime = data.eventDatetime;
    this.sumUsage = data.sumUsage;
    this.sumLimitTimes = data.sumLimitTimes;
    this.updateUser = data.updateUser;
    this.limitCleanDayTime = data.limitCleanDayTime;
  }

  @Override
  public ZhToolUsage clone() {
    return new ZhToolUsage(this);
  }

  @Override
  public String toString() {
    return this.toolNumberBo;
  }

  public String getToolNumberBo() {
    return toolNumberBo;
  }

  public void setToolNumberBo(String toolNumberBo) {
    this.toolNumberBo = toolNumberBo;
  }

  public BigDecimal getToolLimitTimes() {
    return toolLimitTimes;
  }

  public void setToolLimitTimes(BigDecimal toolLimitTimes) {
    this.toolLimitTimes = toolLimitTimes;
  }

  public BigDecimal getToolUsage() {
    return toolUsage;
  }

  public void setToolUsage(BigDecimal toolUsage) {
    this.toolUsage = toolUsage;
  }

  public Date getEventDatetime() {
    return eventDatetime;
  }

  public void setEventDatetime(Date eventDatetime) {
    this.eventDatetime = eventDatetime;
  }

  public BigDecimal getSumUsage() {
    return sumUsage;
  }

  public void setSumUsage(BigDecimal sumUsage) {
    this.sumUsage = sumUsage;
  }

  public BigDecimal getSumLimitTimes() {
    return sumLimitTimes;
  }

  public void setSumLimitTimes(BigDecimal sumLimitTimes) {
    this.sumLimitTimes = sumLimitTimes;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public BigDecimal getLimitCleanDayTime() {
    return limitCleanDayTime;
  }

  public void setLimitCleanDayTime(BigDecimal limitCleanDayTime) {
    this.limitCleanDayTime = limitCleanDayTime;
  }
}
