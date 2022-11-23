package ame.psb.db;

public class MtResourceSlot {

  private String id;

  private String resourceBo;

  private String slotName;

  private String slotType;

  private String stateName;

  public MtResourceSlot() {
  }

  public MtResourceSlot(MtResourceSlot data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.slotName = data.slotName;
    this.slotType = data.slotType;
    this.stateName = data.stateName;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getSlotType() {
    return this.slotType;
  }

  public void setSlotType(String slotType) {
    this.slotType = slotType;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public MtResourceSlot clone() {
    return new MtResourceSlot(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
