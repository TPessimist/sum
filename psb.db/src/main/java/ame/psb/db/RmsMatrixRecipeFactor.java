package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class RmsMatrixRecipeFactor {

  private String matrixRecipeBo;

  private int seqNo;

  private String matrixFactorDefBo;

  private String driverArgs;

  public String getMatrixRecipeBo() {
    return this.matrixRecipeBo;
  }

  public void setMatrixRecipeBo(String matrixRecipeBo) {
    this.matrixRecipeBo = matrixRecipeBo;
  }

  public int getSeqNo() {
    return this.seqNo;
  }

  public void setSeqNo(int seqNo) {
    this.seqNo = seqNo;
  }

  public String getMatrixFactorDefBo() {
    return this.matrixFactorDefBo;
  }

  public void setMatrixFactorDefBo(String matrixFactorDefBo) {
    this.matrixFactorDefBo = matrixFactorDefBo;
  }

  public String getDriverArgs() {
    return this.driverArgs;
  }

  public void setDriverArgs(String driverArgs) {
    this.driverArgs = driverArgs;
  }

  @Override
  public String toString() {
    return this.matrixRecipeBo + "," + this.seqNo + "," + this.driverArgs;
  }
}
