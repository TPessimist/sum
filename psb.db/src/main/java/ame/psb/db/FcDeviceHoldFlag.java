package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FcDeviceHoldFlag {

    private String itemGroupBo;

    private String operationBo;

    private Boolean holdFlag;

    private String reversedField1;

    private String reversedField2;

    private Date updatedTime;

    private String updatedUser;


    public FcDeviceHoldFlag() {
    }	

    public FcDeviceHoldFlag(FcDeviceHoldFlag data) {
        this.itemGroupBo = data.itemGroupBo;
        this.operationBo = data.operationBo;
        this.holdFlag = data.holdFlag;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedTime = data.updatedTime;
        this.updatedUser = data.updatedUser;
    }	

    @Override
    public FcDeviceHoldFlag clone() {
    	return new FcDeviceHoldFlag(this);
    }

    @Override
    public String toString() {
        return this.itemGroupBo + ", " + this.operationBo;
    }
}
