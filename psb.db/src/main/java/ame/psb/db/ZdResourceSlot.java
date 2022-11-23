package ame.psb.db;

import java.util.Date;

public class ZdResourceSlot {

  //  private final static String SQL_SEL = "SELECT * FROM ZD_RESOURCE_SLOT WHERE RESERVE_FOR IS NOT NULL AND RESERVE_FOR <> ''";
//SELECT ID, RESOURCE_BO, SLOT_NO, SLOT_TYPE, CONTENT, CAPACITY, ROOT_RESOURCE, UPDATED_USER, UPDATED_TIME, "REF", RESERVE_FOR, STATE_NAME
//FROM WIP.ZD_RESOURCE_SLOT
//WHERE ID='ResourceBO:1020,OHB-204G::1';
  private String id;
  private String resourceBo;
  private String slotNo;
  private String slotType;
  private String content;
  private String capacity;
  private String rootResource;
  private String updateUser;
  private Date updateTime;
  private String ref;
  private String reserveFor;
  private String stateName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(String slotNo) {
    this.slotNo = slotNo;
  }

  public String getSlotType() {
    return slotType;
  }

  public void setSlotType(String slotType) {
    this.slotType = slotType;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCapacity() {
    return capacity;
  }

  public void setCapacity(String capacity) {
    this.capacity = capacity;
  }

  public String getRootResource() {
    return rootResource;
  }

  public void setRootResource(String rootResource) {
    this.rootResource = rootResource;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getReserveFor() {
    return reserveFor;
  }

  public void setReserveFor(String reserveFor) {
    this.reserveFor = reserveFor;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }
}
