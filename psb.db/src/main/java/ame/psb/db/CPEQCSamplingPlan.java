package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CPEQCSamplingPlan {

    private String id;

    private String eqcSamplingPlanType;

    private String itemGroupBo;

    private String lotType;

    private String operationBo;

    private BigDecimal beginQty;

    private BigDecimal centerQty;

    private BigDecimal endQty;

    private String shopOrderBo;

    private String customerItemBo;

    private String status;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public CPEQCSamplingPlan() {
    }	

    public CPEQCSamplingPlan(CPEQCSamplingPlan data) {
        this.id = data.id;
        this.eqcSamplingPlanType = data.eqcSamplingPlanType;
        this.itemGroupBo = data.itemGroupBo;
        this.lotType = data.lotType;
        this.operationBo = data.operationBo;
        this.beginQty = data.beginQty;
        this.centerQty = data.centerQty;
        this.endQty = data.endQty;
        this.shopOrderBo = data.shopOrderBo;
        this.customerItemBo = data.customerItemBo;
        this.status = data.status;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public CPEQCSamplingPlan clone() {
    	return new CPEQCSamplingPlan(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
