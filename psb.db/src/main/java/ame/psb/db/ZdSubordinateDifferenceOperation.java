package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ZdSubordinateDifferenceOperation {

  private String subordinateDifferenceBo;

  private String operationBo;

  private String differenceBo;

  private String describe;

  private String reverseField1;

  private String reverseField2;

  private String updatedUser;

  private Date updatedTime;


  public ZdSubordinateDifferenceOperation() {
  }

  public ZdSubordinateDifferenceOperation(ZdSubordinateDifferenceOperation data) {
    this.subordinateDifferenceBo = data.subordinateDifferenceBo;
    this.operationBo = data.operationBo;
    this.differenceBo = data.differenceBo;
    this.describe = data.describe;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ZdSubordinateDifferenceOperation clone() {
    return new ZdSubordinateDifferenceOperation(this);
  }

  @Override
  public String toString() {
    return this.subordinateDifferenceBo + ", " + this.operationBo + ", " + this.differenceBo;
  }
}
