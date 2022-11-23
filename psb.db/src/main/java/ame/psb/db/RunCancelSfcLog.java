package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class RunCancelSfcLog {

    private String uuid;

    private String itemGroupBo;

    private String itemGroupName;

    private String itemBo;

    private String itemName;

    private String shopOrderBo;

    private String shopOrderName;

    private String state;

    private String describe;

    private String reversedField1;

    private String reversedField2;

    private String modifyUser;

    private Date modifyTime;

    private String createdUser;

    private Date createdTime;


    public RunCancelSfcLog() {
    }	

    public RunCancelSfcLog(RunCancelSfcLog data) {
        this.uuid = data.uuid;
        this.itemGroupBo = data.itemGroupBo;
        this.itemGroupName = data.itemGroupName;
        this.itemBo = data.itemBo;
        this.itemName = data.itemName;
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.state = data.state;
        this.describe = data.describe;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.modifyUser = data.modifyUser;
        this.modifyTime = data.modifyTime;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
    }	

    @Override
    public RunCancelSfcLog clone() {
    	return new RunCancelSfcLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
