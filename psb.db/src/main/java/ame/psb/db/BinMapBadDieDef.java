package ame.psb.db;

import java.util.UUID;

public class BinMapBadDieDef {

  private String id;

  private String binmapRuleBo;

  private Integer sequence;

  private String value;

  private String deffectCode;

  private String nonRecyclable;

  public BinMapBadDieDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapBadDieDef(BinMapBadDieDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.value = data.value;
    this.deffectCode = data.deffectCode;
    this.nonRecyclable = data.nonRecyclable;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBinmapRuleBo() {
    return this.binmapRuleBo;
  }

  public void setBinmapRuleBo(String binmapRuleBo) {
    this.binmapRuleBo = binmapRuleBo;
  }

  public Integer getSequence() {
    return this.sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDeffectCode() {
    return this.deffectCode;
  }

  public void setDeffectCode(String deffectCode) {
    this.deffectCode = deffectCode;
  }

  public String getNonRecyclable() {
    return nonRecyclable;
  }

  public void setNonRecyclable(String nonRecyclable) {
    this.nonRecyclable = nonRecyclable;
  }

  @Override
  public BinMapBadDieDef clone() {
    return new BinMapBadDieDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}