package ame.psb.db;

public class InstrumentManufacturer {

  private String instrumentid; //仪器编号

  private String name; //计量器具名称

  private String alias; //别名

  private String manufacturer; //制造单位

  private String model; //仪器规格/型号

  private String calculateRange; //测量范围

  private String instrumentPrecision; //仪器精度

  private String tolerance; //产品公差

  private String acceptableStandard; //使用允收标准

  private String factoryNumber; //出厂编号

  private String machineNumber; //机台编号

  private String inputDate; //入厂日期

  private String checkCycle; //校验周期

  private String checkMode; //校验方式

  private String checkDate; //校正日期

  private String deadline; //截止有效日期

  private String userDepartment; //使用部门

  private String custodian; //保管人

  private String belongDepartment; //所属事业部

  private String checkState; //校验状态

  private String days; //距到期日天数

  private String calculateUnit; //计量单位

  private String remarks; //备注

  private String jobNumber; //保管人工号

  private String email; //保管人邮件

  private String stateDescription; //状态描述

  private String reserveField1; //备用列1

  private String reserveField2; //备用列2


  public InstrumentManufacturer() {
  }

  public InstrumentManufacturer(InstrumentManufacturer data) {
    this.instrumentid = data.instrumentid;
    this.name = data.name;
    this.alias = data.alias;
    this.manufacturer = data.manufacturer;
    this.model = data.model;
    this.calculateRange = data.calculateRange;
    this.instrumentPrecision = data.instrumentPrecision;
    this.tolerance = data.tolerance;
    this.acceptableStandard = data.acceptableStandard;
    this.factoryNumber = data.factoryNumber;
    this.machineNumber = data.machineNumber;
    this.inputDate = data.inputDate;
    this.checkCycle = data.checkCycle;
    this.checkMode = data.checkMode;
    this.checkDate = data.checkDate;
    this.deadline = data.deadline;
    this.userDepartment = data.userDepartment;
    this.custodian = data.custodian;
    this.belongDepartment = data.belongDepartment;
    this.checkState = data.checkState;
    this.days = data.days;
    this.calculateUnit = data.calculateUnit;
    this.remarks = data.remarks;
    this.jobNumber = data.jobNumber;
    this.email = data.email;
    this.stateDescription = data.stateDescription;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
  }

  @Override
  public InstrumentManufacturer clone() {
    return new InstrumentManufacturer(this);
  }

  @Override
  public String toString() {
    return this.instrumentid;
  }

  public String getInstrumentid() {
    return instrumentid;
  }

  public void setInstrumentid(String instrumentid) {
    this.instrumentid = instrumentid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getCalculateRange() {
    return calculateRange;
  }

  public void setCalculateRange(String calculateRange) {
    this.calculateRange = calculateRange;
  }

  public String getInstrumentPrecision() {
    return instrumentPrecision;
  }

  public void setInstrumentPrecision(String instrumentPrecision) {
    this.instrumentPrecision = instrumentPrecision;
  }

  public String getTolerance() {
    return tolerance;
  }

  public void setTolerance(String tolerance) {
    this.tolerance = tolerance;
  }

  public String getAcceptableStandard() {
    return acceptableStandard;
  }

  public void setAcceptableStandard(String acceptableStandard) {
    this.acceptableStandard = acceptableStandard;
  }

  public String getFactoryNumber() {
    return factoryNumber;
  }

  public void setFactoryNumber(String factoryNumber) {
    this.factoryNumber = factoryNumber;
  }

  public String getMachineNumber() {
    return machineNumber;
  }

  public void setMachineNumber(String machineNumber) {
    this.machineNumber = machineNumber;
  }

  public String getInputDate() {
    return inputDate;
  }

  public void setInputDate(String inputDate) {
    this.inputDate = inputDate;
  }

  public String getCheckCycle() {
    return checkCycle;
  }

  public void setCheckCycle(String checkCycle) {
    this.checkCycle = checkCycle;
  }

  public String getCheckMode() {
    return checkMode;
  }

  public void setCheckMode(String checkMode) {
    this.checkMode = checkMode;
  }

  public String getCheckDate() {
    return checkDate;
  }

  public void setCheckDate(String checkDate) {
    this.checkDate = checkDate;
  }

  public String getDeadline() {
    return deadline;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public String getUserDepartment() {
    return userDepartment;
  }

  public void setUserDepartment(String userDepartment) {
    this.userDepartment = userDepartment;
  }

  public String getCustodian() {
    return custodian;
  }

  public void setCustodian(String custodian) {
    this.custodian = custodian;
  }

  public String getBelongDepartment() {
    return belongDepartment;
  }

  public void setBelongDepartment(String belongDepartment) {
    this.belongDepartment = belongDepartment;
  }

  public String getCheckState() {
    return checkState;
  }

  public void setCheckState(String checkState) {
    this.checkState = checkState;
  }

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public String getCalculateUnit() {
    return calculateUnit;
  }

  public void setCalculateUnit(String calculateUnit) {
    this.calculateUnit = calculateUnit;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getJobNumber() {
    return jobNumber;
  }

  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStateDescription() {
    return stateDescription;
  }

  public void setStateDescription(String stateDescription) {
    this.stateDescription = stateDescription;
  }

  public String getReserveField1() {
    return reserveField1;
  }

  public void setReserveField1(String reserveField1) {
    this.reserveField1 = reserveField1;
  }

  public String getReserveField2() {
    return reserveField2;
  }

  public void setReserveField2(String reserveField2) {
    this.reserveField2 = reserveField2;
  }
}
