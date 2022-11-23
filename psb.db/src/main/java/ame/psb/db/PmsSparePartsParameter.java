package ame.psb.db;

public class PmsSparePartsParameter {

  private String resrce;

  private String sparePart;

  private String validity;

  private String description;


  public PmsSparePartsParameter() {
  }

  public PmsSparePartsParameter(PmsSparePartsParameter data) {
    this.resrce = data.resrce;
    this.sparePart = data.sparePart;
    this.validity = data.validity;
    this.description = data.description;
  }

  @Override
  public PmsSparePartsParameter clone() {
    return new PmsSparePartsParameter(this);
  }

  @Override
  public String toString() {
    return this.resrce + ", " + this.sparePart;
  }

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getSparePart() {
    return sparePart;
  }

  public void setSparePart(String sparePart) {
    this.sparePart = sparePart;
  }

  public String getValidity() {
    return validity;
  }

  public void setValidity(String validity) {
    this.validity = validity;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}