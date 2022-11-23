package ame.me.db;

public class DcParameter {

  private String handle;

  private String dcGroupBo;

  private String parameterName;

  private String dataType;

  private String prompt;

  private int sequence;

  private String parameterDescription;

  public DcParameter() {
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getDcGroupBo() {
    return this.dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public String getParameterName() {
    return this.parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getDataType() {
    return this.dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public String getPrompt() {
    return this.prompt;
  }

  public void setPrompt(String prompt) {
    this.prompt = prompt;
  }

  public int getSequence() {
    return this.sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public String getParameterDescription() {
    return this.parameterDescription;
  }

  public void setParameterDescription(String description) {
    this.parameterDescription = description;
  }

  @Override
  public String toString() {
    return this.parameterName + ", " + this.parameterDescription;
  }

}
