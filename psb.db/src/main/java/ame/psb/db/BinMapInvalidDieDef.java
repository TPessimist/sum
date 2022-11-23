package ame.psb.db;

import java.util.UUID;

public class BinMapInvalidDieDef {

  private String id;

  private String binmapRuleBo;

  private Integer sequence;

  private String value;

  public BinMapInvalidDieDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapInvalidDieDef(BinMapInvalidDieDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.value = data.value;
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

  @Override
  public BinMapInvalidDieDef clone() {
    return new BinMapInvalidDieDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}