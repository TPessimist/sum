package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ReelCarrierLog {

    private String uuid;

    private String carrierBo;

    private String carrierState;

    private String reelId;

    private String containerName;

    private String itemGroupName;

    private String itemName;

    private String custLot;

    private String cust;

    private String wafers;

    private String reason;

    private String reverseField1;

    private String reverseField2;

    private String reverseField3;

    private String reverseField4;

    private String reverseField5;

    private String modifiedUser;

    private Date modifiedTime;


    public ReelCarrierLog() {
    }	

    public ReelCarrierLog(ReelCarrierLog data) {
        this.uuid = data.uuid;
        this.carrierBo = data.carrierBo;
        this.carrierState = data.carrierState;
        this.reelId = data.reelId;
        this.containerName = data.containerName;
        this.itemGroupName = data.itemGroupName;
        this.itemName = data.itemName;
        this.custLot = data.custLot;
        this.cust = data.cust;
        this.wafers = data.wafers;
        this.reason = data.reason;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.reverseField3 = data.reverseField3;
        this.reverseField4 = data.reverseField4;
        this.reverseField5 = data.reverseField5;
        this.modifiedUser = data.modifiedUser;
        this.modifiedTime = data.modifiedTime;
    }	

    @Override
    public ReelCarrierLog clone() {
    	return new ReelCarrierLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
