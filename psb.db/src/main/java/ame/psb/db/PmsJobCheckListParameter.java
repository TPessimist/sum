package ame.psb.db;

public class PmsJobCheckListParameter {

  private String handle;

  private String site;

  private String jobBo;

  private String jobResourceBo;

  private String seq;

  private String parameterName;

  private String parameterDesc;

  private String parameterType;

  private String defaultValue;

  private String parameterUnit;

  private String valueRequired;


  public PmsJobCheckListParameter() {
  }

  public PmsJobCheckListParameter(PmsJobCheckListParameter data) {
    this.handle = data.handle;
    this.site = data.site;
    this.jobBo = data.jobBo;
    this.jobResourceBo = data.jobResourceBo;
    this.seq = data.seq;
    this.parameterName = data.parameterName;
    this.parameterDesc = data.parameterDesc;
    this.parameterType = data.parameterType;
    this.defaultValue = data.defaultValue;
    this.parameterUnit = data.parameterUnit;
    this.valueRequired = data.valueRequired;
  }

  @Override
  public PmsJobCheckListParameter clone() {
    return new PmsJobCheckListParameter(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getJobBo() {
    return jobBo;
  }

  public void setJobBo(String jobBo) {
    this.jobBo = jobBo;
  }

  public String getJobResourceBo() {
    return jobResourceBo;
  }

  public void setJobResourceBo(String jobResourceBo) {
    this.jobResourceBo = jobResourceBo;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getParameterDesc() {
    return parameterDesc;
  }

  public void setParameterDesc(String parameterDesc) {
    this.parameterDesc = parameterDesc;
  }

  public String getParameterType() {
    return parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public String getParameterUnit() {
    return parameterUnit;
  }

  public void setParameterUnit(String parameterUnit) {
    this.parameterUnit = parameterUnit;
  }

  public String getValueRequired() {
    return valueRequired;
  }

  public void setValueRequired(String valueRequired) {
    this.valueRequired = valueRequired;
  }

}