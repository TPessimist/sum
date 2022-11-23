package ame.psb.db;

import java.util.UUID;

public class ShiftAlignmentDieDef {

  private String id;

  private String binmapRuleBo;

  private Integer sequence;

  private Integer xCoordinate;

  private Integer yCoordinate;

  private String value;


  public ShiftAlignmentDieDef() {
    this.id = UUID.randomUUID().toString();
  }

  public ShiftAlignmentDieDef(ShiftAlignmentDieDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.xCoordinate = data.xCoordinate;
    this.yCoordinate = data.yCoordinate;
    this.value = data.value;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBinmapRuleBo() {
    return binmapRuleBo;
  }

  public void setBinmapRuleBo(String binmapRuleBo) {
    this.binmapRuleBo = binmapRuleBo;
  }

  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public Integer getxCoordinate() {
    return xCoordinate;
  }

  public void setxCoordinate(Integer xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public Integer getyCoordinate() {
    return yCoordinate;
  }

  public void setyCoordinate(Integer yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public ShiftAlignmentDieDef clone() {
    return new ShiftAlignmentDieDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
