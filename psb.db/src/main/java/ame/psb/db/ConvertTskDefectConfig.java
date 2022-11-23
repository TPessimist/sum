package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class ConvertTskDefectConfig {

  private String id;

  private String convertId;

  private String binmapRuleBo;

  private String symbol;

  private int defect;

  private String convertSymbol;

  private int convertDefect;


  public ConvertTskDefectConfig() {
    this.id = UUID.randomUUID().toString();
  }

  public ConvertTskDefectConfig(ConvertTskDefectConfig data) {
    this.id = data.getId();
    this.convertId = data.getConvertId();
    this.binmapRuleBo = data.getBinmapRuleBo();
    this.symbol = data.getSymbol();
    this.defect = data.getDefect();
    this.convertSymbol = data.getConvertSymbol();
    this.convertDefect = data.getConvertDefect();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getConvertId() {
    return convertId;
  }

  public void setConvertId(String convertId) {
    this.convertId = convertId;
  }

  public String getBinmapRuleBo() {
    return binmapRuleBo;
  }

  public void setBinmapRuleBo(String binmapRuleBo) {
    this.binmapRuleBo = binmapRuleBo;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public int getDefect() {
    return defect;
  }

  public void setDefect(int defect) {
    this.defect = defect;
  }

  public String getConvertSymbol() {
    return convertSymbol;
  }

  public void setConvertSymbol(String convertSymbol) {
    this.convertSymbol = convertSymbol;
  }

  public int getConvertDefect() {
    return convertDefect;
  }

  public void setConvertDefect(int convertDefect) {
    this.convertDefect = convertDefect;
  }

  @Override
  public ConvertTskDefectConfig clone() {
    return new ConvertTskDefectConfig(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
