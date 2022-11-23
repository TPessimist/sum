package ame.psb.db;

import java.math.BigDecimal;
import java.util.UUID;

public class FcResrcePlatingPrint {

  private String printId;

  private String slotNo;

  private String platingName;

  private String item;

  private String inventoryIds;

  private BigDecimal suggestedDosage;

  private String analysisUser;

  private String analysisTime;


  public FcResrcePlatingPrint() {
    this.printId = UUID.randomUUID().toString();
  }

  public FcResrcePlatingPrint(FcResrcePlatingPrint data) {
    this.slotNo = data.slotNo;
    this.platingName = data.platingName;
    this.item = data.item;
    this.inventoryIds = data.inventoryIds;
    this.suggestedDosage = data.suggestedDosage;
    this.analysisUser = data.analysisUser;
    this.analysisTime = data.analysisTime;
  }

  public String getPrintId() {
    return printId;
  }

  public void setPrintId(String printId) {
    this.printId = printId;
  }

  public String getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(String slotNo) {
    this.slotNo = slotNo;
  }

  public String getPlatingName() {
    return platingName;
  }

  public void setPlatingName(String platingName) {
    this.platingName = platingName;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getInventoryIds() {
    return inventoryIds;
  }

  public void setInventoryIds(String inventoryIds) {
    this.inventoryIds = inventoryIds;
  }

  public BigDecimal getSuggestedDosage() {
    return suggestedDosage;
  }

  public void setSuggestedDosage(BigDecimal suggestedDosage) {
    this.suggestedDosage = suggestedDosage;
  }

  public String getAnalysisUser() {
    return analysisUser;
  }

  public void setAnalysisUser(String analysisUser) {
    this.analysisUser = analysisUser;
  }

  public String getAnalysisTime() {
    return analysisTime;
  }

  public void setAnalysisTime(String analysisTime) {
    this.analysisTime = analysisTime;
  }

  @Override
  public FcResrcePlatingPrint clone() {
    return new FcResrcePlatingPrint(this);
  }

  @Override
  public String toString() {
    return this.printId;
  }
}
