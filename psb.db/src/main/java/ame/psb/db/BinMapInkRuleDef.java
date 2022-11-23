package ame.psb.db;

import java.util.UUID;

public class BinMapInkRuleDef {

  private String id;

  private String binmapRuleBo;

  private Integer sequence;

  private String inkConfigClass;

  private String configJson;


  public BinMapInkRuleDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapInkRuleDef(BinMapInkRuleDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.sequence = data.sequence;
    this.inkConfigClass = data.inkConfigClass;
    this.configJson = data.configJson;
  }

  @Override
  public BinMapInkRuleDef clone() {
    return new BinMapInkRuleDef(this);
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

  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public String getInkConfigClass() {
    return inkConfigClass;
  }

  public void setInkConfigClass(String inkConfigClass) {
    this.inkConfigClass = inkConfigClass;
  }

  public String getConfigJson() {
    return configJson;
  }

  public void setConfigJson(String configJson) {
    this.configJson = configJson;
  }

}
