package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PdmLog {

    private String uuid;

    private String pdmType;

    private String batchId;

    private String reverseField1;

    private String reverseField2;

    private String reverseField3;

    private String reverseField4;

    private String updateUser;

    private Date updateTime;


    public PdmLog() {
    }

    public PdmLog(String uuid, String pdmType, String batchId, String reverseField1,
        String reverseField2, String reverseField3, String reverseField4, String updateUser,
        Date updateTime) {
        this.uuid = uuid;
        this.pdmType = pdmType;
        this.batchId = batchId;
        this.reverseField1 = reverseField1;
        this.reverseField2 = reverseField2;
        this.reverseField3 = reverseField3;
        this.reverseField4 = reverseField4;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public PdmLog(PdmLog data) {
        this.uuid = data.uuid;
        this.pdmType = data.pdmType;
        this.batchId = data.batchId;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.reverseField3 = data.reverseField3;
        this.reverseField4 = data.reverseField4;
        this.updateUser = data.updateUser;
        this.updateTime = data.updateTime;
    }	

    @Override
    public PdmLog clone() {
    	return new PdmLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
