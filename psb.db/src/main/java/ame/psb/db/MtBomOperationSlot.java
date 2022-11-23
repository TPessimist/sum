package ame.psb.db;

public class MtBomOperationSlot {

  private String bomOperationBo;

  private String resourceBo;

  private String slotName;

  private String stateName;

  public MtBomOperationSlot() {
  }

  public MtBomOperationSlot(MtBomOperationSlot data) {
    this.bomOperationBo = data.bomOperationBo;
    this.resourceBo = data.resourceBo;
    this.slotName = data.slotName;
    this.stateName = data.stateName;
  }

  public String getBomOperationBo() {
    return this.bomOperationBo;
  }

  public void setBomOperationBo(String bomOperationBo) {
    this.bomOperationBo = bomOperationBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getSlotName() {
    return this.slotName;
  }

  public void setSlotName(String slotName) {
    this.slotName = slotName;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public MtBomOperationSlot clone() {
    return new MtBomOperationSlot(this);
  }

  @Override
  public String toString() {
    return this.bomOperationBo;
  }
}
