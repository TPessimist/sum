package ame.htks.db;

public class ReportDef {

  private String name;

  private String desc;

  private String comment;

  private String sqlString;

  private String para;

  private String col;

  private Integer seq;


  public ReportDef() {
  }

  public ReportDef(ReportDef data) {
    this.name = data.name;
    this.desc = data.desc;
    this.comment = data.comment;
    this.sqlString = data.sqlString;
    this.para = data.para;
    this.col = data.col;
    this.seq = data.seq;
  }

  @Override
  public ReportDef clone() {
    return new ReportDef(this);
  }

  @Override
  public String toString() {
    return this.name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getSqlString() {
    return sqlString;
  }

  public void setSqlString(String sqlString) {
    this.sqlString = sqlString;
  }

  public String getPara() {
    return para;
  }

  public void setPara(String para) {
    this.para = para;
  }

  public String getCol() {
    return col;
  }

  public void setCol(String col) {
    this.col = col;
  }

  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

}
