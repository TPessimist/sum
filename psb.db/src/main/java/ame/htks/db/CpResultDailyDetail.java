package ame.htks.db;

import java.util.Date;

public class CpResultDailyDetail {

  private String resultId;

  private String binCode;

  private String binQty;

  private Date updatedTime;

  private String operationBo;


  public CpResultDailyDetail() {
  }

  public CpResultDailyDetail(CpResultDailyDetail data) {
    this.resultId = data.resultId;
    this.binCode = data.binCode;
    this.binQty = data.binQty;
    this.updatedTime = data.updatedTime;
    this.operationBo = data.operationBo;
  }

  @Override
  public CpResultDailyDetail clone() {
    return new CpResultDailyDetail(this);
  }

  @Override
  public String toString() {
    return this.resultId;
  }
}
