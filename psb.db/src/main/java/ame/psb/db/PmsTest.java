package ame.psb.db;

public class PmsTest {

  private String handle;

  private String site;

  private String checklistBo;

  private String seq;

  private String enabled;

  private String parameterName;

  private String parameterDesc;

  private String parameterType;

  private String defaultValue;

  private String parameterUnit;

  private String valueRequired;

  private String controlTopLimit;

  private String controlLowerLimit;

  private String warnTopLimit;

  private String warnLowerLimit;

  private String piclink;


  public PmsTest() {
  }

  public PmsTest(PmsTest data) {
    this.handle = data.handle;
    this.site = data.site;
    this.checklistBo = data.checklistBo;
    this.seq = data.seq;
    this.enabled = data.enabled;
    this.parameterName = data.parameterName;
    this.parameterDesc = data.parameterDesc;
    this.parameterType = data.parameterType;
    this.defaultValue = data.defaultValue;
    this.parameterUnit = data.parameterUnit;
    this.valueRequired = data.valueRequired;
    this.controlTopLimit = data.controlTopLimit;
    this.controlLowerLimit = data.controlLowerLimit;
    this.warnTopLimit = data.warnTopLimit;
    this.warnLowerLimit = data.warnLowerLimit;
    this.piclink = data.piclink;
  }

  @Override
  public PmsTest clone() {
    return new PmsTest(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getChecklistBo() {
    return this.checklistBo;
  }

  public void setChecklistBo(String checklistBo) {
    this.checklistBo = checklistBo;
  }

  public String getSeq() {
    return this.seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getEnabled() {
    return this.enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public String getParameterName() {
    return this.parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getParameterDesc() {
    return this.parameterDesc;
  }

  public void setParameterDesc(String parameterDesc) {
    this.parameterDesc = parameterDesc;
  }

  public String getParameterType() {
    return this.parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }

  public String getDefaultValue() {
    return this.defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public String getParameterUnit() {
    return this.parameterUnit;
  }

  public void setParameterUnit(String parameterUnit) {
    this.parameterUnit = parameterUnit;
  }

  public String getValueRequired() {
    return this.valueRequired;
  }

  public void setValueRequired(String valueRequired) {
    this.valueRequired = valueRequired;
  }

  public String getControlTopLimit() {
    return this.controlTopLimit;
  }

  public void setControlTopLimit(String controlTopLimit) {
    this.controlTopLimit = controlTopLimit;
  }

  public String getControlLowerLimit() {
    return this.controlLowerLimit;
  }

  public void setControlLowerLimit(String controlLowerLimit) {
    this.controlLowerLimit = controlLowerLimit;
  }

  public String getWarnTopLimit() {
    return this.warnTopLimit;
  }

  public void setWarnTopLimit(String warnTopLimit) {
    this.warnTopLimit = warnTopLimit;
  }

  public String getWarnLowerLimit() {
    return this.warnLowerLimit;
  }

  public void setWarnLowerLimit(String warnLowerLimit) {
    this.warnLowerLimit = warnLowerLimit;
  }

  public String getPiclink() {
    return this.piclink;
  }

  public void setPiclink(String piclink) {
    this.piclink = piclink;
  }
}
