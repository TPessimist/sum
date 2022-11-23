package ame.psb.db;

import java.util.Date;

public class RunOa {

    private String oaId;

    private String actionName;

    private String actionContent;

    private String updatedUser;

    private Date updatedTime;

    private String stateName;

    private String sfcs; //sfc状态


    public RunOa() {
    }

    public RunOa(RunOa data) {
        this.oaId = data.oaId;
        this.actionName = data.actionName;
        this.actionContent = data.actionContent;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
        this.stateName = data.stateName;
        this.sfcs = data.sfcs;
    }


    public String getSfcs() {
        return this.sfcs;
    }

    public void setSfcs(String sfcs) {
        this.sfcs = sfcs;
    }

    public String getOaId() {
        return this.oaId;
    }

    public void setOaId(String oaId) {
        this.oaId = oaId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionContent() {
        return this.actionContent;
    }

    public void setActionContent(String actionContent) {
        this.actionContent = actionContent;
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

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public RunOa clone() {
        return new RunOa(this);
    }

    @Override
    public String toString() {
        return String.join("::", this.oaId, this.actionName, this.actionContent, this.stateName);
    }
}
