package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class RunCarrier extends Run {

  private String carrierBo;

  private int itemQty;

  private int sfcQty;

  public RunCarrier() {
    super("CARRIER");
  }

  public RunCarrier(RunCarrier data) {
    super("CARRIER", data);
    this.carrierBo = data.carrierBo;
    this.itemQty = data.itemQty;
    this.sfcQty = data.sfcQty;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public int getItemQty() {
    return this.itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }

  public int getSfcQty() {
    return this.sfcQty;
  }

  public void setSfcQty(int sfcQty) {
    this.sfcQty = sfcQty;
  }

  @Override
  public String toString() {
    return getId() + "," + getStateName();
  }
}
