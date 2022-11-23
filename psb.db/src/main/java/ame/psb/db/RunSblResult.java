package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import lombok.Data;

@Data
public class RunSblResult {

  private String customerItemBo;

  private String sfcBo;

  private String itemGroupBo;

  private String operationBo;

  private String ncCode;

  private BigDecimal ncValue;

  private BigDecimal waferUcl;

  private BigDecimal waferLcl;

  private BigDecimal lotUcl;

  private BigDecimal lotLcl;

  private String updatedUser;

  private Date updatedTime;

  private String remarks;


  public RunSblResult() {
  }

  public RunSblResult(RunSblResult data) {
    this.customerItemBo = data.customerItemBo;
    this.sfcBo = data.sfcBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.ncCode = data.ncCode;
    this.ncValue = data.ncValue;
    this.waferUcl = data.waferUcl;
    this.waferLcl = data.waferLcl;
    this.lotUcl = data.lotUcl;
    this.lotLcl = data.lotLcl;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.remarks = data.remarks;
  }

  @Override
  public RunSblResult clone() {
    return new RunSblResult(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo + ", " + this.ncCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunSblResult sblResult = (RunSblResult) o;
    return customerItemBo.equals(sblResult.customerItemBo) && sfcBo.equals(sblResult.sfcBo)
        && itemGroupBo.equals(sblResult.itemGroupBo) && operationBo.equals(sblResult.operationBo)
        && ncCode.equals(sblResult.ncCode) && ncValue.equals(sblResult.ncValue)
        && Objects.equals(waferUcl, sblResult.waferUcl) && Objects.equals(
        waferLcl, sblResult.waferLcl) && Objects.equals(lotUcl, sblResult.lotUcl)
        && Objects.equals(lotLcl, sblResult.lotLcl)
        && Objects.equals(remarks, sblResult.remarks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerItemBo, sfcBo, itemGroupBo, operationBo, ncCode, ncValue, waferUcl,
        waferLcl, lotUcl, lotLcl, remarks);
  }
}
