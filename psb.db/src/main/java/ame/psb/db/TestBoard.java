package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class TestBoard {

    private String uuid;

    private String testModle;
    /**
     * 板卡类型
     */
    private String slotType;
    /**
     * 位置
     */
    private String slotNo;
    /**
     *
     */
    private String boardName;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public TestBoard() {
    }	

    public TestBoard(TestBoard data) {
        this.uuid = data.uuid;
        this.testModle = data.testModle;
        this.slotType = data.slotType;
        this.slotNo = data.slotNo;
        this.boardName = data.boardName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public TestBoard clone() {
    	return new TestBoard(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
