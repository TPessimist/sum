package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class WaferStorageInfo {

  private String id;

  private String waferStorageBo;

  private String remainWaferCarrierBo;

  private String normalWaferCarrierBo;

  private String remainWaferDoneFlag;

  private String normalWaferDoneFlag;

  private String reverseField1;

  private String reverseField2;

  private String updatedUser;

  private Date updatedTime;


  public WaferStorageInfo() {
  }

  public WaferStorageInfo(WaferStorageInfo data) {
    this.id = data.id;
    this.waferStorageBo = data.waferStorageBo;
    this.remainWaferCarrierBo = data.remainWaferCarrierBo;
    this.normalWaferCarrierBo = data.normalWaferCarrierBo;
    this.remainWaferDoneFlag = data.remainWaferDoneFlag;
    this.normalWaferDoneFlag = data.normalWaferDoneFlag;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public WaferStorageInfo clone() {
    return new WaferStorageInfo(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
