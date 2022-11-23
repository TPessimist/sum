package ame.psb.db;

import javax.persistence.Entity;

/**
 * Table: SFC 在特定站點的執行紀錄。
 *
 * @author Kyle K. Lin
 */
@Entity
public class RunSfc extends Run {

  private String sfcStepBo;

  private String sfcBo;

  private String runCarrierBo;

  private int itemQty;

  private int sfcQty;

  private String holdCode;

  private String holdComment;

  public RunSfc() {
    super("SFC");
  }

  public RunSfc(RunSfc data) {
    super("SFC", data);
    this.sfcStepBo = data.sfcStepBo;
    this.sfcBo = data.sfcBo;
    this.runCarrierBo = data.runCarrierBo;
    this.itemQty = data.itemQty;
    this.sfcQty = data.sfcQty;
    this.holdCode = data.holdCode;
    this.holdComment = data.holdComment;
  }

  public String getSfcStepBo() {
    return this.sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getRunCarrierBo() {
    return this.runCarrierBo;
  }

  public void setRunCarrierBo(String runCarrierBo) {
    this.runCarrierBo = runCarrierBo;
  }

  public int getItemQty() {
    return this.itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }

  public int getSfcQty() {
    return this.sfcQty;
  }

  public void setSfcQty(int sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getHoldCode() {
    return holdCode;
  }

  public void setHoldCode(String holdCode) {
    this.holdCode = holdCode;
  }

  public String getHoldComment() {
    return holdComment;
  }

  public void setHoldComment(String holdComment) {
    this.holdComment = holdComment;
  }

  @Override
  public String toString() {
    return String.format("%-40s, %-35s @ %-35s - %s",
        getId(),
        this.runCarrierBo,
        getOperationBo(),
        getStateName());
  }

  @Override
  public RunSfc clone() throws CloneNotSupportedException {
    return (RunSfc) super.clone();
  }
}
