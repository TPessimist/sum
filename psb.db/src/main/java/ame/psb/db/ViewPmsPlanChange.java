package ame.psb.db;

import java.util.Date;

public class ViewPmsPlanChange extends PmsPlanChange {

  private String enabled;

  private String jobId;

  private String jobStatus;

  private Date startDateTime;

  private Date nextExecuTime;

  public ViewPmsPlanChange() {
  }

  public ViewPmsPlanChange(ViewPmsPlanChange data) {
    this.enabled = data.enabled;
    this.jobId = data.jobId;
    this.jobStatus = data.jobStatus;
    this.startDateTime = data.startDateTime;
    this.nextExecuTime = data.nextExecuTime;
  }

  @Override
  public ViewPmsPlanChange clone() {
    return new ViewPmsPlanChange(this);
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(String jobStatus) {
    this.jobStatus = jobStatus;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getNextExecuTime() {
    return nextExecuTime;
  }

  public void setNextExecuTime(Date nextExecuTime) {
    this.nextExecuTime = nextExecuTime;
  }
}