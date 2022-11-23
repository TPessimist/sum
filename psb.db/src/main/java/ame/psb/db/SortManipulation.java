package ame.psb.db;

import java.util.Date;

public class SortManipulation {

  private String resource;

  private String foupId1;

  private String foupId2;

  private String foupId3;

  private String foupId4;

  private String eapRequest;

  private String flag;

  private String logUser;

  private Date logTime;


  public SortManipulation() {
  }

  public SortManipulation(SortManipulation data) {
    this.resource = data.resource;
    this.foupId1 = data.foupId1;
    this.foupId2 = data.foupId2;
    this.foupId3 = data.foupId3;
    this.foupId4 = data.foupId4;
    this.eapRequest = data.eapRequest;
    this.flag = data.flag;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
  }

  @Override
  public SortManipulation clone() {
    return new SortManipulation(this);
  }

  @Override
  public String toString() {
    return this.resource;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getFoupId1() {
    return foupId1;
  }

  public void setFoupId1(String foupId1) {
    this.foupId1 = foupId1;
  }

  public String getFoupId2() {
    return foupId2;
  }

  public void setFoupId2(String foupId2) {
    this.foupId2 = foupId2;
  }

  public String getFoupId3() {
    return foupId3;
  }

  public void setFoupId3(String foupId3) {
    this.foupId3 = foupId3;
  }

  public String getFoupId4() {
    return foupId4;
  }

  public void setFoupId4(String foupId4) {
    this.foupId4 = foupId4;
  }

  public String getEapRequest() {
    return eapRequest;
  }

  public void setEapRequest(String eapRequest) {
    this.eapRequest = eapRequest;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getLogUser() {
    return logUser;
  }

  public void setLogUser(String logUser) {
    this.logUser = logUser;
  }

  public Date getLogTime() {
    return logTime;
  }

  public void setLogTime(Date logTime) {
    this.logTime = logTime;
  }

}
