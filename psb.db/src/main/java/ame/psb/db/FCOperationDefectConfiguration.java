package ame.psb.db;

import lombok.Data;

import java.util.Date;
@Data
public class FCOperationDefectConfiguration {

    private String packageName;

    private String configurationType;

    private String seq;

    private String operationBo;

    private String reversedField1;

    private String reversedField2;

    private String modifyUser;

    private Date modifyTime;

    private String updateUser;

    private Date updateTime;


    public FCOperationDefectConfiguration() {
    }	

    public FCOperationDefectConfiguration(FCOperationDefectConfiguration data) {
        this.packageName = data.packageName;
        this.configurationType = data.configurationType;
        this.seq = data.seq;
        this.operationBo = data.operationBo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.modifyUser = data.modifyUser;
        this.modifyTime = data.modifyTime;
        this.updateUser = data.updateUser;
        this.updateTime = data.updateTime;
    }	

    @Override
    public FCOperationDefectConfiguration clone() {
    	return new FCOperationDefectConfiguration(this);
    }

    @Override
    public String toString() {
        return this.packageName + ", " + this.configurationType + ", " + this.seq;
    }
}
