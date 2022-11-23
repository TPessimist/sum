package ame.psb.db;

public class ViewProductMapCombineOperationDef extends ProductMapCombineOperationDef {

  private String operationName;

  private String ftpPath;

  private String ftpUser;

  private String ftpPassword;

  public String getOperationName() {
    return this.operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getFtpPath() {
    return ftpPath;
  }

  public void setFtpPath(String ftpPath) {
    this.ftpPath = ftpPath;
  }

  public String getFtpUser() {
    return ftpUser;
  }

  public void setFtpUser(String ftpUser) {
    this.ftpUser = ftpUser;
  }

  public String getFtpPassword() {
    return ftpPassword;
  }

  public void setFtpPassword(String ftpPassword) {
    this.ftpPassword = ftpPassword;
  }

}
