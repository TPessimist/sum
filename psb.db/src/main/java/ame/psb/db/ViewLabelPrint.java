package ame.psb.db;

public class ViewLabelPrint {

  private String zzykhh;

  private String wadat;

  private String boxId;

  private String goodBad;


  public ViewLabelPrint() {
  }

  public ViewLabelPrint(ViewLabelPrint data) {
    this.zzykhh = data.zzykhh;
    this.wadat = data.wadat;
    this.boxId = data.boxId;
    this.goodBad = data.goodBad;
  }

  public String getZzykhh() {
    return zzykhh;
  }

  public void setZzykhh(String zzykhh) {
    this.zzykhh = zzykhh;
  }

  public String getWadat() {
    return wadat;
  }

  public void setWadat(String wadat) {
    this.wadat = wadat;
  }

  public String getBoxId() {
    return boxId;
  }

  public void setBoxId(String boxId) {
    this.boxId = boxId;
  }

  public String getGoodBad() {
    return goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  @Override
  public ViewLabelPrint clone() {
    return new ViewLabelPrint(this);
  }

  @Override
  public String toString() {
    return this.zzykhh;
  }
}
