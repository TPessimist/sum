package ame.psb.db;

public class Mail {

  private String handle;

  private String modules;

  private String timeFlag;

  private String numberFlag;


  public Mail() {
  }

  public Mail(Mail data) {
    this.handle = data.handle;
    this.modules = data.modules;
    this.timeFlag = data.timeFlag;
    this.numberFlag = data.numberFlag;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getModules() {
    return modules;
  }

  public void setModules(String modules) {
    this.modules = modules;
  }

  public String getTimeFlag() {
    return timeFlag;
  }

  public void setTimeFlag(String timeFlag) {
    this.timeFlag = timeFlag;
  }

  public String getNumberFlag() {
    return numberFlag;
  }

  public void setNumberFlag(String numberFlag) {
    this.numberFlag = numberFlag;
  }

  @Override
  public Mail clone() {
    return new Mail(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
