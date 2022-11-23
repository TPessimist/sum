package ame.psb.db;

import java.math.BigDecimal;

public class ViewDcopParameter extends DcopParameter {

  private String dcGroup;

  private String collectionType;

  private String dcGroupBo;

  private String parameterName;

  private String dataType;

  private String checkFlag;

  private BigDecimal dieCount;

  private String parameterDescription;

  private BigDecimal point;

  private String verificationtype;

  public BigDecimal getPoint() {
    return point;
  }

  public void setPoint(BigDecimal point) {
    this.point = point;
  }

  public String getVerificationtype() {
    return verificationtype;
  }

  public void setVerificationtype(String verificationtype) {
    this.verificationtype = verificationtype;
  }

  public String getDcGroup() {
    return this.dcGroup;
  }

  public void setDcGroup(String dcGroup) {
    this.dcGroup = dcGroup;
  }

  public String getCollectionType() {
    return this.collectionType;
  }

  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
  }

  public String getDcGroupBo() {
    return this.dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public String getParameterName() {
    return this.parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getDataType() {
    return this.dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public String getParameterDescription() {
    return this.parameterDescription;
  }

  public void setParameterDescription(String parameterDescription) {
    this.parameterDescription = parameterDescription;
  }

  public String getCheckFlag() {
    return checkFlag;
  }

  public void setCheckFlag(String checkFlag) {
    this.checkFlag = checkFlag;
  }

  public BigDecimal getDieCount() {
    return dieCount;
  }

  public void setDieCount(BigDecimal dieCount) {
    this.dieCount = dieCount;
  }
}
