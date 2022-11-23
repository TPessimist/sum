package ame.psb.db;

import java.util.UUID;

public class BinMapGoodDieDef {

  private String id;

  private String binmapRuleBo;

  private Integer sequence;

  private String value;

  private String grade;

  public BinMapGoodDieDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapGoodDieDef(BinMapGoodDieDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.value = data.value;
    this.grade = data.grade;
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

  public String getGrade() {
    return this.grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  @Override
  public BinMapGoodDieDef clone() {
    return new BinMapGoodDieDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}