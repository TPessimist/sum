package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FCSpecialOperationDefectConfigure {

    private String id;

    private String operationBo;

    private String hostNcCode;

    private String lastNcCode;

    private String stateName;

    private String reversedField1;

    private String reversedField2;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;


    public FCSpecialOperationDefectConfigure() {
    }	

    public FCSpecialOperationDefectConfigure(FCSpecialOperationDefectConfigure data) {
        this.id = data.id;
        this.operationBo = data.operationBo;
        this.hostNcCode = data.hostNcCode;
        this.lastNcCode = data.lastNcCode;
        this.stateName = data.stateName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
        this.modifiedUser = data.modifiedUser;
        this.modifiedTime = data.modifiedTime;
    }	

    @Override
    public FCSpecialOperationDefectConfigure clone() {
    	return new FCSpecialOperationDefectConfigure(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
