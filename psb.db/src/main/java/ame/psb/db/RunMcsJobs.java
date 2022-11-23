package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class RunMcsJobs {

  private String id;

  private String stateName;

  private String carrierId;

  private String actionName;

  private String fromPosition;

  private String toPosition;

  private String priority;

  private Date watchTime;

  private Date startTime;

  private Date endTime;

  private String comments;

  private String updatedUser;

  private Date updatedTime;

  private String createdUser;

  private Date createdTime;

  private String jobId;


  public RunMcsJobs() {
    this.id = UUID.randomUUID().toString();
  }

  public RunMcsJobs(RunMcsJobs data) {
    this.id = data.id;
    this.stateName = data.stateName;
    this.carrierId = data.carrierId;
    this.actionName = data.actionName;
    this.fromPosition = data.fromPosition;
    this.toPosition = data.toPosition;
    this.priority = data.priority;
    this.watchTime = data.watchTime;
    this.startTime = data.startTime;
    this.endTime = data.endTime;
    this.comments = data.comments;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.createdUser = data.createdUser;
    this.createdTime = data.createdTime;
    this.jobId = data.jobId;
  }

  public static RunMcsJobs createMcsTranJob(String carrierName, String fromPosition,
      String toPosition) {
    Date now = new Date();
    RunMcsJobs job = new RunMcsJobs();
    job.setCreatedTime(now);
    job.setCreatedUser("OHT");
    job.setStateName("NEW");
    job.setUpdatedUser("AUTO");
    job.setUpdatedTime(now);
    job.setFromPosition(fromPosition);
    job.setPriority("3");
    job.setActionName("MES001");
    job.setCarrierId(carrierName);
    job.setToPosition(toPosition);
    return job;
  }

  @Override
  public RunMcsJobs clone() {
    return new RunMcsJobs(this);
  }

  @Override
  public String toString() {
    return this.carrierId + ":" + this.fromPosition + " => " + this.toPosition;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCarrierId() {
    return this.carrierId;
  }

  public void setCarrierId(String carrierId) {
    this.carrierId = carrierId;
  }

  public String getActionName() {
    return this.actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getFromPosition() {
    return this.fromPosition;
  }

  public void setFromPosition(String fromPosition) {
    this.fromPosition = fromPosition;
  }

  public String getToPosition() {
    return this.toPosition;
  }

  public void setToPosition(String toPosition) {
    this.toPosition = toPosition;
  }

  public String getPriority() {
    return this.priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public Date getWatchTime() {
    return this.watchTime;
  }

  public void setWatchTime(Date watchTime) {
    this.watchTime = watchTime;
  }

  public Date getStartTime() {
    return this.startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
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

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getCreatedUser() {
    return createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public boolean isActive() {
    return "NEW".equals(this.stateName)
        || "WAIT".equals(this.stateName)
        || "WAIT_REPLY".equals(this.stateName)
        || "TRANSFERRING".equals(this.stateName);
  }

  public boolean isLock() {
    return "LOCK".equals(this.stateName);
  }
}
