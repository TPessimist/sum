package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class DeviceSetUpOperationBuyOffResult {

    private String itemGroupBo;

    private String setUpOperationBo;

    private String deviceBuyOffResult;

    private String currentBuyOffSfcType;

    private String currentBuyOffSfcType_result;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public DeviceSetUpOperationBuyOffResult() {
    }	

    public DeviceSetUpOperationBuyOffResult(DeviceSetUpOperationBuyOffResult data) {
        this.itemGroupBo = data.itemGroupBo;
        this.setUpOperationBo = data.setUpOperationBo;
        this.deviceBuyOffResult = data.deviceBuyOffResult;
        this.currentBuyOffSfcType = data.currentBuyOffSfcType;
        this.currentBuyOffSfcType_result = data.currentBuyOffSfcType_result;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }

    @Override
    public DeviceSetUpOperationBuyOffResult clone() {
    	return new DeviceSetUpOperationBuyOffResult(this);
    }

    @Override
    public String toString() {
        return this.itemGroupBo + ", " + this.setUpOperationBo;
    }
}
