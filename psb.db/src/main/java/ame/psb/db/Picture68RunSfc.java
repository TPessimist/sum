package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class Picture68RunSfc {

  private String sfcBo;

  private String groupId;

  private BigDecimal groupSeq;

  private String rootSfc;

  private String pictureFlag;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public Picture68RunSfc() {
  }

  public Picture68RunSfc(Picture68RunSfc data) {
    this.sfcBo = data.sfcBo;
    this.groupId = data.groupId;
    this.groupSeq = data.groupSeq;
    this.rootSfc = data.rootSfc;
    this.pictureFlag = data.pictureFlag;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public BigDecimal getGroupSeq() {
    return groupSeq;
  }

  public void setGroupSeq(BigDecimal groupSeq) {
    this.groupSeq = groupSeq;
  }

  public String getRootSfc() {
    return rootSfc;
  }

  public void setRootSfc(String rootSfc) {
    this.rootSfc = rootSfc;
  }

  public String getPictureFlag() {
    return pictureFlag;
  }

  public void setPictureFlag(String pictureFlag) {
    this.pictureFlag = pictureFlag;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public Picture68RunSfc clone() {
    return new Picture68RunSfc(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }
}
