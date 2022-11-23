package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class LabelBuyOff {

  private String labelId;

  private String combineType;

  private String buyoffContainer;

  private String buyoffOperation;

  private String buyoffFlag;

  private String pe1Approved;

  private String pe1Comment;

  private String pe1PicturePath;

  private String pe1User;

  private Date pe1UpdatedTime;

  private String pe2Approved;

  private String pe2Comment;

  private String pe2PicturePath;

  private String pe2User;

  private Date pe2UpdatedTime;

  private String qeApproved;

  private String qeComment;

  private String qePicturePath;

  private String qeUser;

  private Date qeUpdatedTime;

  private String reversedField1;

  private String reversedField2;

  private String reversedField3;


  public LabelBuyOff() {
  }

  public LabelBuyOff(LabelBuyOff data) {
    this.labelId = data.labelId;
    this.combineType = data.combineType;
    this.buyoffContainer = data.buyoffContainer;
    this.buyoffOperation = data.buyoffOperation;
    this.buyoffFlag = data.buyoffFlag;
    this.pe1Approved = data.pe1Approved;
    this.pe1Comment = data.pe1Comment;
    this.pe1PicturePath = data.pe1PicturePath;
    this.pe1User = data.pe1User;
    this.pe1UpdatedTime = data.pe1UpdatedTime;
    this.pe2Approved = data.pe2Approved;
    this.pe2Comment = data.pe2Comment;
    this.pe2PicturePath = data.pe2PicturePath;
    this.pe2User = data.pe2User;
    this.pe2UpdatedTime = data.pe2UpdatedTime;
    this.qeApproved = data.qeApproved;
    this.qeComment = data.qeComment;
    this.qePicturePath = data.qePicturePath;
    this.qeUser = data.qeUser;
    this.qeUpdatedTime = data.qeUpdatedTime;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.reversedField3 = data.reversedField3;
  }

  @Override
  public LabelBuyOff clone() {
    return new LabelBuyOff(this);
  }

  @Override
  public String toString() {
    return this.labelId + ", " + this.combineType;
  }
}
