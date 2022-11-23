package ame.psb.db;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

public class PmsResourceSetting {

  private String handle;

  private int seq;

  private String resourceBo;

  private String resrce;

  private boolean enabled;

  private String checklist;

  private String checkType;

  private String periodValue;

  private String periodUnit;

  private String toleranceTime;

  private String toleranceUnit;

  private Date nextExecuteTime;

  private boolean baseOnCompleted;

  private String warningSetting;

  private String jobId;

  private String createdUser;

  private Date createdDateTime;

  private String modifyUser;

  private Date modifiedDateTime;


  public PmsResourceSetting() {
  }

  public PmsResourceSetting(PmsResourceSetting data) {
    this.handle = data.handle;
    this.seq = data.seq;
    this.resourceBo = data.resourceBo;
    this.resrce = data.resrce;
    this.enabled = data.enabled;
    this.checklist = data.checklist;
    this.checkType = data.checkType;
    this.periodValue = data.periodValue;
    this.periodUnit = data.periodUnit;
    this.toleranceTime = data.toleranceTime;
    this.toleranceUnit = data.toleranceUnit;
    this.nextExecuteTime = data.nextExecuteTime;
    this.baseOnCompleted = data.baseOnCompleted;
    this.warningSetting = data.warningSetting;
    this.createdUser = data.createdUser;
    this.createdDateTime = data.createdDateTime;
    this.modifyUser = data.modifyUser;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public PmsResourceSetting clone() {
    return new PmsResourceSetting(this);
  }

  public boolean isOverDue() {
    return this.isEnabled() && this.nextExecuteTime != null && new Date()
        .after(this.nextExecuteTime);
  }

  @Override
  public String toString() {
    return String.join("::", this.resrce, this.checklist,
        this.nextExecuteTime == null ? "NULL" : this.nextExecuteTime.toString());
  }

  public String getCheckType() {
    return checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public int getSeq() {
    return this.seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getResrce() {
    return this.resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }


  public String getChecklist() {
    return this.checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public String getPeriodValue() {
    return this.periodValue;
  }

  public void setPeriodValue(String periodValue) {
    this.periodValue = periodValue;
  }

  public String getPeriodUnit() {
    return this.periodUnit;
  }

  public void setPeriodUnit(String periodUnit) {
    this.periodUnit = periodUnit;
  }

  public String getToleranceTime() {
    return this.toleranceTime;
  }

  public void setToleranceTime(String toleranceTime) {
    this.toleranceTime = toleranceTime;
  }

  public String getToleranceUnit() {
    return this.toleranceUnit;
  }

  public void setToleranceUnit(String toleranceUnit) {
    this.toleranceUnit = toleranceUnit;
  }

  public Date getNextExecuteTime() {
    return this.nextExecuteTime;
  }

  public void setNextExecuteTime(Date nextExecuteTime) {
    this.nextExecuteTime = nextExecuteTime;
  }

  public void generateNextExecuteTime() throws Exception {
    if (this.nextExecuteTime == null) {
      return;
    }
    if (Strings.isNullOrEmpty(this.periodUnit) || Strings.isNullOrEmpty(this.periodValue)) {
      return;
    }
    LocalDateTime result;
    if (this.baseOnCompleted) {
      result = this.datePlus(this.periodUnit, new BigDecimal(this.periodValue).longValue())
          .apply(LocalDateTime.now());
    } else {
      LocalDateTime lastDateTime = Instant.ofEpochMilli(this.nextExecuteTime.getTime())
          .atZone(ZoneId.systemDefault()).toLocalDateTime();
      LocalDateTime test = this
          .datePlus(this.periodUnit, new BigDecimal(this.periodValue).longValue())
          .apply(lastDateTime);
      // 下次执行时间大于now
      if (test.isAfter(LocalDateTime.now())) {
        result = test;
      } else {
        Duration duration1 = Duration.between(test, lastDateTime);
        Duration duration2 = Duration.between(LocalDateTime.now(), lastDateTime);
        long count = duration2.toMillis() / duration1.toMillis();
        result = this
            .datePlus(this.periodUnit, new BigDecimal(this.periodValue).longValue() * (count + 1))
            .apply(lastDateTime);
      }
    }
    this.nextExecuteTime = Date.from(result.atZone(ZoneId.systemDefault()).toInstant());
  }

  public Date earliestExecuteTime() {
    LocalDateTime dueDay = Instant.ofEpochMilli(this.nextExecuteTime.getTime())
        .atZone(ZoneId.systemDefault()).toLocalDateTime();
    LocalDateTime result = this
        .datePlus(this.toleranceUnit, new BigDecimal(this.toleranceTime).negate().longValue())
        .apply(dueDay);
    return Date.from(result.atZone(ZoneId.systemDefault()).toInstant());
  }

  private Function<LocalDateTime, LocalDateTime> datePlus(String unit, long offset) {
    switch (unit) {
      case "Second":
        return time -> time.plusSeconds(offset);
      case "Minute":
        return time -> time.plusMinutes(offset);
      case "Hour":
        return time -> time.plusHours(offset);
      case "Day":
        return time -> time.plusDays(offset);
      case "Week":
        return time -> time.plusWeeks(offset);
      case "Month":
        return time -> time.plusMonths(offset);
      case "Year":
        return time -> time.plusYears(offset);
      default:
        return time -> LocalDateTime.MAX;
    }
  }


  public String getWarningSetting() {
    return this.warningSetting;
  }

  public void setWarningSetting(String warningSetting) {
    this.warningSetting = warningSetting;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getModifyUser() {
    return this.modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isBaseOnCompleted() {
    return this.baseOnCompleted;
  }

  public void setBaseOnCompleted(boolean baseOnCompleted) {
    this.baseOnCompleted = baseOnCompleted;
  }

  public String getJobId() {
    return this.jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

}
