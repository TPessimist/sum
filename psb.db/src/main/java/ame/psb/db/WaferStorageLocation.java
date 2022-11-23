package ame.psb.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaferStorageLocation {

  private String handle;
  private String code;
  private Integer level;
  private String parent;
  private Date createdTime;
  private Date updatedTime;
  private List<WaferStorageLocation> children = new ArrayList<WaferStorageLocation>();

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public List<WaferStorageLocation> getChildren() {
    return children;
  }

  public void setChildren(List<WaferStorageLocation> children) {
    this.children = children;
  }
}
