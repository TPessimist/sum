package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FoMaintainLog {

  private String id;

  private String tableName;

  private String sfcName;

  private String shopOrder;

  private String resource;

  private String materialDescription;

  private String materialPo;

  private String waferId;

  private Integer sfcRemainNumbers;

  private String updateUser;

  private Date updateTime;


  public FoMaintainLog() {
  }

  public FoMaintainLog(FoMaintainLog data) {
    this.id = data.id;
    this.tableName = data.tableName;
    this.sfcName = data.sfcName;
    this.shopOrder = data.shopOrder;
    this.resource = data.resource;
    this.materialDescription = data.materialDescription;
    this.materialPo = data.materialPo;
    this.waferId = data.waferId;
    this.sfcRemainNumbers = data.sfcRemainNumbers;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  @Override
  public FoMaintainLog clone() {
    return new FoMaintainLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
