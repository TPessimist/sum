package ame.psb.db;

public class PkgContainerSfc {

  private String containerBo;

  private String sfcBo;

  private String goodBad;

  private String grades;

  private int dieQty;

  private String customerItemName;

  private int goodDie;

  private int badDie1;

  private int badDie2;

  public PkgContainerSfc() {
  }

  public PkgContainerSfc(PkgContainerSfc data) {
    this.containerBo = data.containerBo;
    this.sfcBo = data.sfcBo;
    this.goodBad = data.goodBad;
    this.grades = data.grades;
    this.dieQty = data.dieQty;
    this.customerItemName = data.customerItemName;
    this.goodDie = data.goodDie;
    this.badDie1 = data.badDie1;
    this.badDie2 = data.badDie2;
  }

  public String getContainerBo() {
    return this.containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getGoodBad() {
    return this.goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  public String getGrades() {
    return this.grades;
  }

  public void setGrades(String grades) {
    this.grades = grades;
  }

  public int getDieQty() {
    return this.dieQty;
  }

  public void setDieQty(int dieQty) {
    this.dieQty = dieQty;
  }

  public String getCustomerItemName() {
    return this.customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public int getGoodDie() {
    return this.goodDie;
  }

  public void setGoodDie(int goodDie) {
    this.goodDie = goodDie;
  }

  public int getBadDie1() {
    return this.badDie1;
  }

  public void setBadDie1(int badDie1) {
    this.badDie1 = badDie1;
  }

  public int getBadDie2() {
    return this.badDie2;
  }

  public void setBadDie2(int badDie2) {
    this.badDie2 = badDie2;
  }

  @Override
  public PkgContainerSfc clone() {
    return new PkgContainerSfc(this);
  }

  @Override
  public String toString() {
    return this.sfcBo + ", " + this.customerItemName + ", " + this.goodBad + ", " + this.grades
        + ", " + this.dieQty;
  }
}
