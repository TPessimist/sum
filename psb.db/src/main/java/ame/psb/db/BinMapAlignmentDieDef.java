package ame.psb.db;

import java.util.UUID;

public class BinMapAlignmentDieDef {

  private String id;

  private String binmapRuleBo;

  private Integer sequence;

  private Integer xCoordinate;

  private Integer yCoordinate;

  public BinMapAlignmentDieDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapAlignmentDieDef(BinMapAlignmentDieDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.xCoordinate = data.xCoordinate;
    this.yCoordinate = data.yCoordinate;
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

  public Integer getxCoordinate() {
    return this.xCoordinate;
  }

  public void setxCoordinate(Integer xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public Integer getyCoordinate() {
    return this.yCoordinate;
  }

  public void setyCoordinate(Integer yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  @Override
  public BinMapAlignmentDieDef clone() {
    return new BinMapAlignmentDieDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}