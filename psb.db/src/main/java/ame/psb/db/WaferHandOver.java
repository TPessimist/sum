package ame.psb.db;

public class WaferHandOver {

  private String waferBo;
  private String handoverLog;

  public WaferHandOver() {
  }

  public WaferHandOver(WaferHandOver data) {
    this.waferBo = data.waferBo;
    this.handoverLog = data.handoverLog;
  }

  public String getWaferBo() {
    return waferBo;
  }

  public void setWaferBo(String waferBo) {
    this.waferBo = waferBo;
  }

  public String getHandoverLog() {
    return handoverLog;
  }

  public void setHandoverLog(String handoverLog) {
    this.handoverLog = handoverLog;
  }

  @Override
  public WaferHandOver clone() {
    return new WaferHandOver(this);
  }

  @Override
  public String toString() {
    return this.waferBo;
  }


}

