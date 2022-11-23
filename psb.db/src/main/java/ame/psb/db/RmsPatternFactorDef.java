package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class RmsPatternFactorDef {

  private String id;

  private String driverClass;

  private String driverArgsDef;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDriverClass() {
    return this.driverClass;
  }

  public void setDriverClass(String driverClass) {
    this.driverClass = driverClass;
  }

  public String getDriverArgsDef() {
    return this.driverArgsDef;
  }

  public void setDriverArgsDef(String driverArgsDef) {
    this.driverArgsDef = driverArgsDef;
  }

  @Override
  public String toString() {
    return String.format("%-20s, %s", this.id, this.driverArgsDef);
  }

}
