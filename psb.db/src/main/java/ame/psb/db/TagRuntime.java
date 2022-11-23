package ame.psb.db;

public class TagRuntime {

  private String customerId; //客户代码

  private String packageType; //包装类型 T卷盘 B内包 C外箱

  private String dept; //部门

  private String factor; //FA1箱号 FA2流水号

  private String factorList; //通过流水规则得到的流水滚动依据

  private String seq; //流水号


  public TagRuntime() {
  }

  public TagRuntime(TagRuntime data) {
    this.customerId = data.customerId;
    this.packageType = data.packageType;
    this.dept = data.dept;
    this.factor = data.factor;
    this.factorList = data.factorList;
    this.seq = data.seq;
  }

  @Override
  public TagRuntime clone() {
    return new TagRuntime(this);
  }

  @Override
  public String toString() {
    return this.customerId + ", " + this.packageType + ", " + this.dept + ", " + this.factor + ", "
        + this.factorList;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getPackageType() {
    return packageType;
  }

  public void setPackageType(String packageType) {
    this.packageType = packageType;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getFactor() {
    return factor;
  }

  public void setFactor(String factor) {
    this.factor = factor;
  }

  public String getFactorList() {
    return factorList;
  }

  public void setFactorList(String factorList) {
    this.factorList = factorList;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }
}
