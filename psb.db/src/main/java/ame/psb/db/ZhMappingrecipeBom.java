package ame.psb.db;

public class ZhMappingrecipeBom {

  private String recipe;

  private String materiel;

  private String materielName;

  private String materialSpecifications;

  private String modle;

  private String consumeInch8;

  private String consumeInch12;

  private String wastage;

  private String unit;

  private String operationHint;

  private String materialProperties;

  public ZhMappingrecipeBom() {
  }

  public ZhMappingrecipeBom(ZhMappingrecipeBom data) {
    this.recipe = data.recipe;
    this.materiel = data.materiel;
    this.materielName = data.materielName;
    this.materialSpecifications = data.materialSpecifications;
    this.modle = data.modle;
    this.consumeInch8 = data.consumeInch8;
    this.consumeInch12 = data.consumeInch12;
    this.wastage = data.wastage;
    this.unit = data.unit;
    this.operationHint = data.operationHint;
    this.materialProperties = data.materialProperties;
  }

  public String getRecipe() {
    return recipe;
  }

  public void setRecipe(String recipe) {
    this.recipe = recipe;
  }

  public String getMateriel() {
    return materiel;
  }

  public void setMateriel(String materiel) {
    this.materiel = materiel;
  }

  public String getMaterielName() {
    return materielName;
  }

  public void setMaterielName(String materielName) {
    this.materielName = materielName;
  }

  public String getMaterialSpecifications() {
    return materialSpecifications;
  }

  public void setMaterialSpecifications(String materialSpecifications) {
    this.materialSpecifications = materialSpecifications;
  }

  public String getModle() {
    return modle;
  }

  public void setModle(String modle) {
    this.modle = modle;
  }

  public String getConsumeInch8() {
    return consumeInch8;
  }

  public void setConsumeInch8(String consumeInch8) {
    this.consumeInch8 = consumeInch8;
  }

  public String getConsumeInch12() {
    return consumeInch12;
  }

  public void setConsumeInch12(String consumeInch12) {
    this.consumeInch12 = consumeInch12;
  }

  public String getWastage() {
    return wastage;
  }

  public void setWastage(String wastage) {
    this.wastage = wastage;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getOperationHint() {
    return operationHint;
  }

  public void setOperationHint(String operationHint) {
    this.operationHint = operationHint;
  }

  public String getMaterialProperties() {
    return materialProperties;
  }

  public void setMaterialProperties(String materialProperties) {
    this.materialProperties = materialProperties;
  }

  @Override
  public ZhMappingrecipeBom clone() {
    return new ZhMappingrecipeBom(this);
  }

  @Override
  public String toString() {
    return this.recipe + ", " + this.materiel + ", " + this.operationHint;
  }
}
