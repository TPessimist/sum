package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class CarrierFoup extends Carrier {

  private String stateName;

  public CarrierFoup() {
    super("FOUP");
  }

  @Override
  public String getStateName() {
    return this.stateName;
  }

  @Override
  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

}
