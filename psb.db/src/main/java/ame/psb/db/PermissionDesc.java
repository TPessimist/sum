package ame.psb.db;

public class PermissionDesc {

    private String userGroupBo;

    private String description;

    public PermissionDesc() {
    }

    public PermissionDesc(PermissionDesc data) {
        this.description = data.description;
        this.userGroupBo = data.userGroupBo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserGroupBo() {
        return userGroupBo;
    }

    public void setUserGroupBo(String userGroupBo) {
        this.userGroupBo = userGroupBo;
    }
}
