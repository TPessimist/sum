package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class PkgTagFactorDef {

  private String id;

  private String driverClass;

  private String driverArgsDef;

  private String category;

  private String description;

  private String paramType;

  private String resultType;

  public PkgTagFactorDef() {
  }

  public PkgTagFactorDef(PkgTagFactorDef data) {
    this.id = data.id;
    this.driverClass = data.driverClass;
    this.driverArgsDef = data.driverArgsDef;
    this.category = data.category;
    this.description = data.description;
    this.paramType = data.paramType;
    this.resultType = data.resultType;
  }

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

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getParamType() {
    return this.paramType;
  }

  public void setParamType(String paramType) {
    this.paramType = paramType;
  }

  public String getResultType() {
    return this.resultType;
  }

  public void setResultType(String resultType) {
    this.resultType = resultType;
  }

  @Override
  public PkgTagFactorDef clone() {
    return new PkgTagFactorDef(this);
  }

  @Override
  public String toString() {
    return this.id + ", " + this.driverArgsDef;
  }
}
