package ame.psb.db;

import java.util.UUID;

public class BinMapCombineOperation {

  private String id;

  private String binmapCombineBo;

  private String operationBo;

  private String fileName;

  public BinMapCombineOperation() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapCombineOperation(BinMapCombineOperation data) {
    this.id = data.id;
    this.binmapCombineBo = data.binmapCombineBo;
    this.operationBo = data.operationBo;
    this.fileName = data.fileName;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBinmapCombineBo() {
    return this.binmapCombineBo;
  }

  public void setBinmapCombineBo(String binmapCombineBo) {
    this.binmapCombineBo = binmapCombineBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public BinMapCombineOperation clone() {
    return new BinMapCombineOperation(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
