package ame.psb.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class HoldRelease {

  private String id;

  private String planName;

  private Date planTime;

  private String stateName;

  private String oa;

  private String oaFormNo;

  private String releaseType;

  private String updatedUser;

  private Date updatedTime;

  private Set<String> sfcNames;

  private List<ViewHoldReleaseSfcItem> releaseSfcItems;

  public HoldRelease() {
    this.id = UUID.randomUUID().toString();
    this.planTime = new Date();
    this.stateName = "EDIT";
    this.oa = "Y";
    this.releaseSfcItems = new ArrayList<ViewHoldReleaseSfcItem>();
    this.sfcNames = new TreeSet<String>();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPlanName() {
    return this.planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
  }

  public Date getPlanTime() {
    return this.planTime;
  }

  public void setPlanTime(Date planTime) {
    this.planTime = planTime;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getOa() {
    return this.oa;
  }

  public void setOa(String oa) {
    this.oa = oa;
  }

  public String getOaFormNo() {
    return this.oaFormNo;
  }

  public void setOaFormNo(String oaFormNo) {
    this.oaFormNo = oaFormNo;
  }

  public String getReleaseType() {
    return this.releaseType;
  }

  public void setReleaseType(String releaseType) {
    this.releaseType = releaseType;
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

  public List<ViewHoldReleaseSfcItem> getReleaseSfcItems() {
    return this.releaseSfcItems;
  }

  public void setReleaseSfcItems(List<ViewHoldReleaseSfcItem> releaseSfcItems) {
    this.releaseSfcItems = releaseSfcItems;
  }

  public Set<String> getSfcNames() {
    return this.sfcNames;
  }

  public void setSfcNames(Set<String> sfcNames) {
    this.sfcNames = sfcNames;
  }

  @Override
  public String toString() {
    return this.id;
  }
}