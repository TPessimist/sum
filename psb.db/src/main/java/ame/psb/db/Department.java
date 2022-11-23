package ame.psb.db;


import javax.persistence.Entity;

@Entity
public class Department {

  private String id;

  private String subid;

  private String value;

  private String groupname;


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

  public String getGroupname() {
    return this.groupname;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }

}