package ame.psb.db;

public class ViewPmsCheckListParameter {

  private String handle;

  private String site;

  private String checklistBo;

  private String checkList;

  private String revision;

  private String enabled;

  private String parameterName;

  private String parameterDesc;


  public ViewPmsCheckListParameter() {
  }

  public ViewPmsCheckListParameter(ViewPmsCheckListParameter data) {
    this.handle = data.handle;
    this.site = data.site;
    this.checklistBo = data.checklistBo;
    this.checkList = data.checkList;
    this.revision = data.revision;
    this.enabled = data.enabled;
    this.parameterName = data.parameterName;
    this.parameterDesc = data.parameterDesc;
  }

  @Override
  public ViewPmsCheckListParameter clone() {
    return new ViewPmsCheckListParameter(this);
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

  public String getChecklistBo() {
    return checklistBo;
  }

  public void setChecklistBo(String checklistBo) {
    this.checklistBo = checklistBo;
  }

  public String getCheckList() {
    return checkList;
  }

  public void setCheckList(String checkList) {
    this.checkList = checkList;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
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
}