package ame.psb.db;

public class UserGroupMember {

  private String handle;

  private String userGroupBo;

  private String userOrGroupGbo;


  public UserGroupMember() {
  }

  public UserGroupMember(UserGroupMember data) {
    this.handle = data.handle;
    this.userGroupBo = data.userGroupBo;
    this.userOrGroupGbo = data.userOrGroupGbo;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getUserGroupBo() {
    return userGroupBo;
  }

  public void setUserGroupBo(String userGroupBo) {
    this.userGroupBo = userGroupBo;
  }

  public String getUserOrGroupGbo() {
    return userOrGroupGbo;
  }

  public void setUserOrGroupGbo(String userOrGroupGbo) {
    this.userOrGroupGbo = userOrGroupGbo;
  }

  @Override
  public UserGroupMember clone() {
    return new UserGroupMember(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
