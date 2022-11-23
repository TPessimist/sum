package ame.me.db;

public class OperationNcCode {

  private String operationBo;

  private String ncCodeBo;

  private String description;

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getNcCodeBo() {
    return this.ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return this.operationBo + "," + this.ncCodeBo + "," + this.description;
  }
}