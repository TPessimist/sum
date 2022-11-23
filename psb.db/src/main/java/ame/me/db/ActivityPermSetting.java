package ame.me.db;


public class ActivityPermSetting {

  private String userOrGroupGbo;

  private String activityOrGroupGbo;

  private String permission;

  private String permissionSetting;

  public ActivityPermSetting() {
  }

  public ActivityPermSetting(ActivityPermSetting data) {
    this.userOrGroupGbo = data.userOrGroupGbo;
    this.activityOrGroupGbo = data.activityOrGroupGbo;
    this.permission = data.permission;
    this.permissionSetting = data.permissionSetting;
  }

  @Override
  public ActivityPermSetting clone() {
    return new ActivityPermSetting(this);
  }

  @Override
  public String toString() {
    return this.userOrGroupGbo;
  }

  public String getUserOrGroupGbo() {
    return this.userOrGroupGbo;
  }

  public void setUserOrGroupGbo(String userOrGroupGbo) {
    this.userOrGroupGbo = userOrGroupGbo;
  }

  public String getActivityOrGroupGbo() {
    return this.activityOrGroupGbo;
  }

  public void setActivityOrGroupGbo(String activityOrGroupGbo) {
    this.activityOrGroupGbo = activityOrGroupGbo;
  }

  public String getPermission() {
    return this.permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public String getPermissionSetting() {
    return this.permissionSetting;
  }

  public void setPermissionSetting(String permissionSetting) {
    this.permissionSetting = permissionSetting;
  }

}