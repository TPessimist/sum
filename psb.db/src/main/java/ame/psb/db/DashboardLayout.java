package ame.psb.db;

import java.util.Date;

public class DashboardLayout {

  private String id;

  private String state;

  private String name;

  private String layoutData;

  private String memo;

  private String reserve1;

  private String reserve2;

  private String reserve3;

  private Date updatedTime;

  private String updatedUser;


  public DashboardLayout() {
  }

  public DashboardLayout(DashboardLayout data) {
    this.id = data.id;
    this.state = data.state;
    this.name = data.name;
    this.layoutData = data.layoutData;
    this.memo = data.memo;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
    this.reserve3 = data.reserve3;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }

  @Override
  public DashboardLayout clone() {
    return new DashboardLayout(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLayoutData() {
    return layoutData;
  }

  public void setLayoutData(String layoutData) {
    this.layoutData = layoutData;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getReserve1() {
    return reserve1;
  }

  public void setReserve1(String reserve1) {
    this.reserve1 = reserve1;
  }

  public String getReserve2() {
    return reserve2;
  }

  public void setReserve2(String reserve2) {
    this.reserve2 = reserve2;
  }

  public String getReserve3() {
    return reserve3;
  }

  public void setReserve3(String reserve3) {
    this.reserve3 = reserve3;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }
}
