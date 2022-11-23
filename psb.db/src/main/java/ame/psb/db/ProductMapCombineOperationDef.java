package ame.psb.db;

import com.google.gson.GsonBuilder;
import java.util.UUID;

public class ProductMapCombineOperationDef {

  private String id;

  private int sequence;

  private String prodMapDefBo;

  private String operationBo;

  private String operationType;

  private String fileType;

  private String filePath;

  private String mapRuleBo;

  private String forceFlag;

  private String goldenType;

  private String oGoldenMapRuleBo;

  private String oGoldenMapFileName;

  private String oGoldenMapRuleTmpl;

  private String eapLoadMapOperation;

  private String inheritDeviceBo;

  private String inheritOperationBo;

  private String inheritMapRuleBo;

  private String combineFlag;

  public ProductMapCombineOperationDef() {
    this.id = UUID.randomUUID().toString();
  }

  public ProductMapCombineOperationDef(ProductMapCombineOperationDef data) {
    this.id = data.id;
    this.sequence = data.sequence;
    this.prodMapDefBo = data.prodMapDefBo;
    this.operationBo = data.operationBo;
    this.operationType = data.operationType;
    this.fileType = data.fileType;
    this.filePath = data.filePath;
    this.forceFlag = data.forceFlag;
    this.goldenType = data.goldenType;
    this.oGoldenMapRuleBo = data.oGoldenMapRuleBo;
    this.oGoldenMapFileName = data.oGoldenMapFileName;
    this.oGoldenMapRuleTmpl = data.oGoldenMapRuleTmpl;
    this.eapLoadMapOperation = data.eapLoadMapOperation;
    this.inheritOperationBo = data.inheritOperationBo;
    this.inheritDeviceBo = data.inheritDeviceBo;
    this.inheritMapRuleBo = data.inheritMapRuleBo;
    this.combineFlag = data.combineFlag;
  }

  @Override
  public ProductMapCombineOperationDef clone() {
    return new ProductMapCombineOperationDef(this);
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

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public String getProdMapDefBo() {
    return prodMapDefBo;
  }

  public void setProdMapDefBo(String prodMapDefBo) {
    this.prodMapDefBo = prodMapDefBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOperationType() {
    return operationType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getMapRuleBo() {
    return mapRuleBo;
  }

  public void setMapRuleBo(String mapRuleBo) {
    this.mapRuleBo = mapRuleBo;
  }

  public String getForceFlag() {
    return forceFlag;
  }

  public void setForceFlag(String forceFlag) {
    this.forceFlag = forceFlag;
  }

  public String getGoldenType() {
    return goldenType;
  }

  public void setGoldenType(String goldenType) {
    this.goldenType = goldenType;
  }

  public String getoGoldenMapRuleBo() {
    return oGoldenMapRuleBo;
  }

  public void setoGoldenMapRuleBo(String oGoldenMapRuleBo) {
    this.oGoldenMapRuleBo = oGoldenMapRuleBo;
  }

  public String getoGoldenMapFileName() {
    return oGoldenMapFileName;
  }

  public void setoGoldenMapFileName(String oGoldenMapFileName) {
    this.oGoldenMapFileName = oGoldenMapFileName;
  }

  public String getoGoldenMapRuleTmpl() {
    return oGoldenMapRuleTmpl;
  }

  public void setoGoldenMapRuleTmpl(String oGoldenMapRuleTmpl) {
    this.oGoldenMapRuleTmpl = oGoldenMapRuleTmpl;
  }

  public String getEapLoadMapOperation() {
    return eapLoadMapOperation;
  }

  public void setEapLoadMapOperation(String eapLoadMapOperation) {
    this.eapLoadMapOperation = eapLoadMapOperation;
  }

  public String getInheritDeviceBo() {
    return inheritDeviceBo;
  }

  public void setInheritDeviceBo(String inheritDeviceBo) {
    this.inheritDeviceBo = inheritDeviceBo;
  }

  public String getInheritOperationBo() {
    return inheritOperationBo;
  }

  public void setInheritOperationBo(String inheritOperationBo) {
    this.inheritOperationBo = inheritOperationBo;
  }

  public String getInheritMapRuleBo() {
    return inheritMapRuleBo;
  }

  public void setInheritMapRuleBo(String inheritMapRuleBo) {
    this.inheritMapRuleBo = inheritMapRuleBo;
  }

  public String getCombineFlag() {
    return combineFlag;
  }

  public void setCombineFlag(String combineFlag) {
    this.combineFlag = combineFlag;
  }

  public int[] customerItemIndexs() {
    if (!isIndexRuleDefined()) {
      return new int[0];
    }
    String tmp = this.filePath.split(";")[0];

    return new GsonBuilder().create().fromJson(tmp, int[].class);
  }

  public int[] fileNameIndexs() {
    if (!isIndexRuleDefined()) {
      return new int[0];
    }
    String tmp = this.filePath.split(";")[1];
    return new GsonBuilder().create().fromJson(tmp, int[].class);
  }

  private boolean isIndexRuleDefined() {
    if (this.filePath == null || this.filePath.trim().isEmpty()) {
      return false;
    }
    return true;
  }

  public boolean validate() {
    if (!isIndexRuleDefined()) {
      return true;
    }
    try {
      if (customerItemIndexs().length == fileNameIndexs().length) {
        return true;
      }
      return false;
    } catch (Exception ex) {
      return false;
    }
  }


}
