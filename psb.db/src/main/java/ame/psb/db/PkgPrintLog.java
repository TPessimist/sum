package ame.psb.db;

import java.util.Date;

public class PkgPrintLog {

  private String containerBo;

  private String printUser;

  private String printUserGroup;

  private Date printTime;


  public PkgPrintLog() {
  }

  public PkgPrintLog(PkgPrintLog data) {
    this.containerBo = data.containerBo;
    this.printUser = data.printUser;
    this.printUserGroup = data.printUserGroup;
    this.printTime = data.printTime;
  }

  @Override
  public PkgPrintLog clone() {
    return new PkgPrintLog(this);
  }

  @Override
  public String toString() {
    return this.containerBo;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getPrintUser() {
    return printUser;
  }

  public void setPrintUser(String printUser) {
    this.printUser = printUser;
  }

  public String getPrintUserGroup() {
    return printUserGroup;
  }

  public void setPrintUserGroup(String printUserGroup) {
    this.printUserGroup = printUserGroup;
  }

  public Date getPrintTime() {
    return printTime;
  }

  public void setPrintTime(Date printTime) {
    this.printTime = printTime;
  }
}
