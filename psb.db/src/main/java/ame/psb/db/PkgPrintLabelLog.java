package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class PkgPrintLabelLog {

  private String id;

  private String containerBo;

  private String containerName;

  private String seq;

  private String dateCode;

  private String content;

  private boolean reprintFlag;

  private int printQty;

  private String reserveField1;

  private String reserveField2;

  private Date printTime;

  private String printUser;

  private String qrcode;

  private String newestPrint;


  public PkgPrintLabelLog() {
    this.id = UUID.randomUUID().toString();
  }

  public PkgPrintLabelLog(PkgPrintLabelLog data) {
    this.id = data.id;
    this.containerBo = data.containerBo;
    this.containerName = data.containerName;
    this.seq = data.seq;
    this.content = data.content;
    this.reprintFlag = data.reprintFlag;
    this.printQty = data.printQty;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.printTime = data.printTime;
    this.printUser = data.printUser;
    this.qrcode = data.qrcode;
  }

  public PkgPrintLabelLog(String id, String containerBo, String containerName, String seq,
      String dateCode, String content, boolean reprintFlag, int printQty, String reserveField1,
      String reserveField2, Date printTime, String printUser, String qrcode) {
    this.id = id;
    this.containerBo = containerBo;
    this.containerName = containerName;
    this.seq = seq;
    this.dateCode = dateCode;
    this.content = content;
    this.reprintFlag = reprintFlag;
    this.printQty = printQty;
    this.reserveField1 = reserveField1;
    this.reserveField2 = reserveField2;
    this.printTime = printTime;
    this.printUser = printUser;
    this.qrcode = qrcode;
  }

  @Override
  public PkgPrintLabelLog clone() {
    return new PkgPrintLabelLog(this);
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

  public String getContainerBo() {
    return this.containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getContainerName() {
    return this.containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getSeq() {
    return this.seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isReprint() {
    return this.reprintFlag;
  }

  public int getPrintQty() {
    return this.printQty;
  }

  public void setPrintQty(int printQty) {
    this.printQty = printQty;
  }

  public String getReserveField1() {
    return this.reserveField1;
  }

  public void setReserveField1(String reserveField1) {
    this.reserveField1 = reserveField1;
  }

  public String getReserveField2() {
    return this.reserveField2;
  }

  public void setReserveField2(String reserveField2) {
    this.reserveField2 = reserveField2;
  }

  public Date getPrintTime() {
    return this.printTime;
  }

  public void setPrintTime(Date printTime) {
    this.printTime = printTime;
  }

  public String getPrintUser() {
    return this.printUser;
  }

  public void setPrintUser(String printUser) {
    this.printUser = printUser;
  }

  public String getDateCode() {
    return dateCode;
  }

  public void setDateCode(String dateCode) {
    this.dateCode = dateCode;
  }

  public boolean isReprintFlag() {
    return reprintFlag;
  }

  public void setReprintFlag(boolean reprintFlag) {
    this.reprintFlag = reprintFlag;
  }

  public String getQrcode() {
    return qrcode;
  }

  public void setQrcode(String qrcode) {
    this.qrcode = qrcode;
  }

  public String getNewestPrint() {
    return newestPrint;
  }

  public void setNewestPrint(String newestPrint) {
    this.newestPrint = newestPrint;
  }
}
