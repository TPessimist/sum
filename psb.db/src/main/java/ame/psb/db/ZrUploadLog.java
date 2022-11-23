package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ZrUploadLog {

  private String id;

  private String subid;

  private String value;

  private String groupName;

  private String groupName1;

  public ZrUploadLog() {
  }

  public ZrUploadLog(String id, String subid, String value, String groupName) {
    this.id = id;
    this.subid = subid;
    this.value = value;
    this.groupName = groupName;
  }

  public String getGroupName1() {
    return groupName1;
  }

  public void setGroupName1(String groupName1) {
    this.groupName1 = groupName1;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubid() {
    return this.subid;
  }

  public void setSubid(String subid) {
    this.subid = subid;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getGroupName() {
    return this.groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  @Override
  public String toString() {
    return this.id + "," + this.subid + "=" + this.value;
  }

}
