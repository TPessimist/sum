package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class CPBoardLog {

    private String uuid;

    private String type;

    private String testColumn1;

    private String testColumn2;

    private String testColumn3;

    private String testColumn4;

    private String reverseField1;

    private String reverseField2;

    private String reverseField3;

    private String reverseField4;

    private String updatedUser;

    private Date updatedTime;


    public CPBoardLog() {
    }

    public CPBoardLog( String type, String testColumn1, String testColumn2,
        String testColumn3, String testColumn4, String reverseField1, String reverseField2,
        String reverseField3, String reverseField4, String updatedUser) {
        this.uuid = UUID.randomUUID().toString();
        this.type = type;
        this.testColumn1 = testColumn1;
        this.testColumn2 = testColumn2;
        this.testColumn3 = testColumn3;
        this.testColumn4 = testColumn4;
        this.reverseField1 = reverseField1;
        this.reverseField2 = reverseField2;
        this.reverseField3 = reverseField3;
        this.reverseField4 = reverseField4;
        this.updatedUser = updatedUser;
        this.updatedTime = new Date();
    }

    public CPBoardLog(CPBoardLog data) {
        this.uuid = data.uuid;
        this.type = data.type;
        this.testColumn1 = data.testColumn1;
        this.testColumn2 = data.testColumn2;
        this.testColumn3 = data.testColumn3;
        this.testColumn4 = data.testColumn4;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.reverseField3 = data.reverseField3;
        this.reverseField4 = data.reverseField4;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public CPBoardLog clone() {
    	return new CPBoardLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
