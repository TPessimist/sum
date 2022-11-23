package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtTailStorageMainLog {

    private String uuid;

    private String uniqueCode;

    private String batchId;

    private String reverseField1;

    private String reverseField2;

    private String updateUser;

    private Date updateTime;


    public FtTailStorageMainLog() {
    }

    public FtTailStorageMainLog(String uuid, String uniqueCode, String batchId,
        String reverseField1, String reverseField2, String updateUser, Date updateTime) {
        this.uuid = uuid;
        this.uniqueCode = uniqueCode;
        this.batchId = batchId;
        this.reverseField1 = reverseField1;
        this.reverseField2 = reverseField2;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public FtTailStorageMainLog(FtTailStorageMainLog data) {
        this.uuid = data.uuid;
        this.uniqueCode = data.uniqueCode;
        this.batchId = data.batchId;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.updateUser = data.updateUser;
        this.updateTime = data.updateTime;
    }	

    @Override
    public FtTailStorageMainLog clone() {
    	return new FtTailStorageMainLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
