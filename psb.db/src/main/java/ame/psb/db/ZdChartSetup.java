package ame.psb.db;

import java.util.Date;

public class ZdChartSetup {

    private String uuid;

    private String chartId;

    private String operation;

    private String dcGroup;

    private String dcParameter;

    private String tolerance;

    private String point;

    private String tooling1;

    private String tooling2;

    private String updatedUser;

    private Date updatedTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDcGroup() {
        return dcGroup;
    }

    public void setDcGroup(String dcGroup) {
        this.dcGroup = dcGroup;
    }

    public String getDcParameter() {
        return dcParameter;
    }

    public void setDcParameter(String dcParameter) {
        this.dcParameter = dcParameter;
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTooling1() {
        return tooling1;
    }

    public void setTooling1(String tooling1) {
        this.tooling1 = tooling1;
    }

    public String getTooling2() {
        return tooling2;
    }

    public void setTooling2(String tooling2) {
        this.tooling2 = tooling2;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public ZdChartSetup() {
    }	

    public ZdChartSetup(ZdChartSetup data) {
        this.uuid = data.uuid;
        this.chartId = data.chartId;
        this.operation = data.operation;
        this.dcGroup = data.dcGroup;
        this.dcParameter = data.dcParameter;
        this.tolerance = data.tolerance;
        this.point = data.point;
        this.tooling1 = data.tooling1;
        this.tooling2 = data.tooling2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZdChartSetup clone() {
    	return new ZdChartSetup(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
