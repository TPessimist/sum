package ame.psb.db;

public class CustDeviceCt {

  private String custDevice;

  private String process;

  private String htksCt;

  private String fixed;

  private String special;

  private String createBy;

  private String createDate;


  public CustDeviceCt() {
  }

  public CustDeviceCt(CustDeviceCt data) {
    this.custDevice = data.custDevice;
    this.process = data.process;
    this.htksCt = data.htksCt;
    this.fixed = data.fixed;
    this.special = data.special;
    this.createBy = data.createBy;
    this.createDate = data.createDate;
  }

  public String getCustDevice() {
    return custDevice;
  }

  public void setCustDevice(String custDevice) {
    this.custDevice = custDevice;
  }

  public String getProcess() {
    return process;
  }

  public void setProcess(String process) {
    this.process = process;
  }

  public String getHtksCt() {
    return htksCt;
  }

  public void setHtksCt(String htksCt) {
    this.htksCt = htksCt;
  }

  public String getFixed() {
    return fixed;
  }

  public void setFixed(String fixed) {
    this.fixed = fixed;
  }

  public String getSpecial() {
    return special;
  }

  public void setSpecial(String special) {
    this.special = special;
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  @Override
  public CustDeviceCt clone() {
    return new CustDeviceCt(this);
  }

  @Override
  public String toString() {
    return this.custDevice;
  }
}
