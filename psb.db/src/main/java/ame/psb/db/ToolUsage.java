package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ToolUsage {

  private String toolNumberBo;

  private BigDecimal toolLimitTimes;

  private BigDecimal toolUsage;

  private Date eventDatetime;


  public ToolUsage() {
  }

  public ToolUsage(ToolUsage data) {
    this.toolNumberBo = data.toolNumberBo;
    this.toolLimitTimes = data.toolLimitTimes;
    this.toolUsage = data.toolUsage;
    this.eventDatetime = data.eventDatetime;
  }

  @Override
  public ToolUsage clone() {
    return new ToolUsage(this);
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
}