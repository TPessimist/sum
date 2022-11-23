package ame.psb.db;

import java.util.Date;

public class Job37Runtime { //ZH_37_JOB_RUNTIME_TABLE表的实体类

  private String containerBo; //容器编号

  private String jobid; //job号

  private String seq; //流水号

  private String containerName; //箱号

  private String labelLink; //标签内容

  private String updatedUser; //更新人员

  private Date updatedTime; //更新时间

  private String value; //备用数据列1

  private String description; //备用数据列2


  public Job37Runtime() {
  }

  public Job37Runtime(Job37Runtime data) {
    this.containerBo = data.containerBo;
    this.jobid = data.jobid;
    this.seq = data.seq;
    this.containerName = data.containerName;
    this.labelLink = data.labelLink;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.value = data.value;
    this.description = data.description;
  }

  @Override
  public Job37Runtime clone() {
    return new Job37Runtime(this);
  }

  @Override
  public String toString() {
    return this.containerBo + ", " + this.jobid;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getJobid() {
    return jobid;
  }

  public void setJobid(String jobid) {
    this.jobid = jobid;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getContainerName() {
    return containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getLabelLink() {
    return labelLink;
  }

  public void setLabelLink(String labelLink) {
    this.labelLink = labelLink;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
