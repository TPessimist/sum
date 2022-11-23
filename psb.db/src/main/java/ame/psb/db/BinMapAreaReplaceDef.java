package ame.psb.db;

import java.util.UUID;

public class BinMapAreaReplaceDef {

  private String id;

  private String binmapRuleBo;

  private int sequence;

  private String areaSymbol;

  private String oldSymbol;

  private String newSymbol;

  public BinMapAreaReplaceDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapAreaReplaceDef(BinMapAreaReplaceDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.areaSymbol = data.areaSymbol;
    this.oldSymbol = data.oldSymbol;
    this.newSymbol = data.newSymbol;
  }

  @Override
  public BinMapAreaReplaceDef clone() {
    return new BinMapAreaReplaceDef(this);
  }

  @Override
  public String toString() {
    return this.id;
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

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public String getAreaSymbol() {
    return areaSymbol;
  }

  public void setAreaSymbol(String areaSymbol) {
    this.areaSymbol = areaSymbol;
  }

  public String getOldSymbol() {
    return oldSymbol;
  }

  public void setOldSymbol(String oldSymbol) {
    this.oldSymbol = oldSymbol;
  }

  public String getNewSymbol() {
    return newSymbol;
  }

  public void setNewSymbol(String newSymbol) {
    this.newSymbol = newSymbol;
  }

}
