package ame.psb.db;

import java.util.Date;

public class PkgWarmupPrintLabel {

  private String id;

  private Date startTime;

  private Date endTime;

  private Date cutoffTime;

  private String partnoSeq;

  private String content;

  private Date printTime;

  private String value1;

  private String value2;

  public PkgWarmupPrintLabel() {
  }

  public PkgWarmupPrintLabel(PkgWarmupPrintLabel data) {
    this.id = data.id;
    this.startTime = data.startTime;
    this.endTime = data.endTime;
    this.cutoffTime = data.cutoffTime;
    this.partnoSeq = data.partnoSeq;
    this.content = data.content;
    this.printTime = data.printTime;
    this.value1 = data.value1;
    this.value2 = data.value2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getCutoffTime() {
    return cutoffTime;
  }

  public void setCutoffTime(Date cutoffTime) {
    this.cutoffTime = cutoffTime;
  }

  public String getPartnoSeq() {
    return partnoSeq;
  }

  public void setPartnoSeq(String partnoSeq) {
    this.partnoSeq = partnoSeq;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getPrintTime() {
    return printTime;
  }

  public void setPrintTime(Date printTime) {
    this.printTime = printTime;
  }

  public String getValue1() {
    return value1;
  }

  public void setValue1(String value1) {
    this.value1 = value1;
  }

  public String getValue2() {
    return value2;
  }

  public void setValue2(String value2) {
    this.value2 = value2;
  }

  @Override
  public PkgWarmupPrintLabel clone() {
    return new PkgWarmupPrintLabel(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
