package ame.psb.db;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.util.Date;

public class ResourceSlot {

  private String id;

  private String resourceBo;

  private int slotNo;

  private String slotType;

  private String content;

  private BigDecimal capacity;

  private String rootResource;

  private String updatedUser;

  private Date updatedTime;

  private String ref;

  private String stateName;

  private String reserveFor;


  public ResourceSlot() {
  }

  public ResourceSlot(ResourceSlot data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.slotNo = data.slotNo;
    this.slotType = data.slotType;
    this.content = data.content;
    this.capacity = data.capacity;
    this.rootResource = data.rootResource;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ResourceSlot clone() {
    return new ResourceSlot(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void generateId() {
    if (this.resourceBo == null || this.slotNo == 0) {
      throw new NullPointerException();
    }
    this.id = this.resourceBo + "::" + this.slotNo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public int getSlotNo() {
    return this.slotNo;
  }

  public void setSlotNo(int slotNo) {
    this.slotNo = slotNo;
  }

  public String getSlotType() {
    return this.slotType;
  }

  public void setSlotType(String slotType) {
    this.slotType = slotType;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public BigDecimal getCapacity() {
    return this.capacity;
  }

  public void setCapacity(BigDecimal capacity) {
    this.capacity = capacity;
  }

  public String getRootResource() {
    return this.rootResource;
  }

  public void setRootResource(String rootResource) {
    this.rootResource = rootResource;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getRef() {
    return this.ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getReserveFor() {
    return this.reserveFor;
  }

  public void setReserveFor(String reserveFor) {
    this.reserveFor = reserveFor;
  }

  public boolean isEnabled() {
    return "ENABLED".equals(this.stateName);
  }

  public boolean isReserved() {
    return "RESERVED".equals(this.stateName);
  }

  public boolean isDisabled() {
    return "DISABLED".equals(this.stateName);
  }

  public boolean isOccupied() {
    return !Strings.isNullOrEmpty(this.content);
  }

  public boolean isEmpty() {
    return !this.isOccupied();
  }
}
