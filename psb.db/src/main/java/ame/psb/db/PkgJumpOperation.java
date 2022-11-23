package ame.psb.db;

public class PkgJumpOperation { //容器跳站表

  private String containerType;

  private String dept;

  private String operation;

  private String seq;

  private String description;

  private String remarks;

  private String note;


  public PkgJumpOperation() {
  }

  public PkgJumpOperation(PkgJumpOperation data) {
    this.containerType = data.containerType;
    this.dept = data.dept;
    this.operation = data.operation;
    this.seq = data.seq;
    this.description = data.description;
    this.remarks = data.remarks;
    this.note = data.note;
  }

  @Override
  public PkgJumpOperation clone() {
    return new PkgJumpOperation(this);
  }

  @Override
  public String toString() {
    return this.containerType;
  }

  public String getContainerType() {
    return containerType;
  }

  public void setContainerType(String containerType) {
    this.containerType = containerType;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
