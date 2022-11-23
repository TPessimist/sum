package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtSblValueLog {

  private String uuid;

  private String sfcBo;

  private String itemGroupBo;

  private String operationBo;

  private String ncCodeBo;

  private String ncCodeValue;

  private String sblParamBo;

  private String sblValue;

  private String updatedUser;

  private Date updatedTime;


  public FtSblValueLog() {
  }

  public FtSblValueLog(FtSblValueLog data) {
    this.uuid = data.uuid;
    this.sfcBo = data.sfcBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.ncCodeBo = data.ncCodeBo;
    this.ncCodeValue = data.ncCodeValue;
    this.sblParamBo = data.sblParamBo;
    this.sblValue = data.sblValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public FtSblValueLog(String uuid, String sfcBo, String itemGroupBo, String operationBo,
      String ncCodeBo, String ncCodeValue, String sblParamBo, String sblValue,
      String updatedUser, Date updatedTime) {
    this.uuid = uuid;
    this.sfcBo = sfcBo;
    this.itemGroupBo = itemGroupBo;
    this.operationBo = operationBo;
    this.ncCodeBo = ncCodeBo;
    this.ncCodeValue = ncCodeValue;
    this.sblParamBo = sblParamBo;
    this.sblValue = sblValue;
    this.updatedUser = updatedUser;
    this.updatedTime = updatedTime;
  }

  @Override
  public FtSblValueLog clone() {
    return new FtSblValueLog(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
