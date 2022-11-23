package ame.psb.db;

import java.util.Date;

public class UserGroup {

    private String handle;

    private String changeStamp;

    private String site;

    private String userGroup;

    private String description;

    private String workstationBo;

    private Date createdDateTime;

    private Date modifiedDateTime;

    public UserGroup() {
    }

    public UserGroup(UserGroup data) {
        this.handle = data.handle;
        this.changeStamp = data.changeStamp;
        this.site = data.site;
        this.userGroup = data.userGroup;
        this.description = data.description;
        this.workstationBo = data.workstationBo;
        this.createdDateTime = data.createdDateTime;
        this.modifiedDateTime = data.modifiedDateTime;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getChangeStamp() {
        return changeStamp;
    }

    public void setChangeStamp(String changeStamp) {
        this.changeStamp = changeStamp;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkstationBo() {
        return workstationBo;
    }

    public void setWorkstationBo(String workstationBo) {
        this.workstationBo = workstationBo;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    @Override
    public UserGroup clone() {
        return new UserGroup(this);
    }

    @Override
    public String toString() {
        return this.handle;
    }
}
