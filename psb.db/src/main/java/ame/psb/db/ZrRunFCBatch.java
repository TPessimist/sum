package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ZrRunFCBatch {

    private String batchId;

    private String operationBo;

    private String operationName;

    private String shopOrderBo;

    private String shopOrderName;

    private String finalBatch;

    private Date runTime;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public ZrRunFCBatch() {
    }	

    public ZrRunFCBatch(ZrRunFCBatch data) {
        this.batchId = data.batchId;
        this.operationBo = data.operationBo;
        this.operationName = data.operationName;
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.finalBatch = data.finalBatch;
        this.runTime = data.runTime;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZrRunFCBatch clone() {
    	return new ZrRunFCBatch(this);
    }

    @Override
    public String toString() {
        return this.batchId + ", " + this.operationBo;
    }
}
