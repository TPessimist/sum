package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class CPEQCSamplingResult {

    private String id;

    private String eqcSamplingPlanBo;

    private String eqcSamplingPlanType;

    private String itemGroupBo;

    private String carrierBo;

    private String sfcBo;

    private String shopOrderBo;

    private String customerItemBo;

    private String customerItemName;

    private String operationBo;

    private String status;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public CPEQCSamplingResult() {
    }	

    public CPEQCSamplingResult(CPEQCSamplingResult data) {
        this.id = data.id;
        this.eqcSamplingPlanBo = data.eqcSamplingPlanBo;
        this.eqcSamplingPlanType = data.eqcSamplingPlanType;
        this.itemGroupBo = data.itemGroupBo;
        this.carrierBo = data.carrierBo;
        this.sfcBo = data.sfcBo;
        this.shopOrderBo = data.shopOrderBo;
        this.customerItemBo = data.customerItemBo;
        this.customerItemName = data.customerItemName;
        this.operationBo = data.operationBo;
        this.status = data.status;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public CPEQCSamplingResult clone() {
    	return new CPEQCSamplingResult(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
