package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ViewDeviceBuyOffOperation {

    private String itemGroupBo;

    private String startOperationBo;

    private String endOperationBo;

    private String recipeOperationBo;

    private String stateName;

    private BigDecimal sfcQty;

    private String sfcType;

    private String processType;

    private String processOperation;

    private String recipeBuyOffParam;

    private String remark;

    private String id;

    private String reversedField1;

    private String reversedField2;


    public ViewDeviceBuyOffOperation() {
    }	

    public ViewDeviceBuyOffOperation(ViewDeviceBuyOffOperation data) {
        this.itemGroupBo = data.itemGroupBo;
        this.startOperationBo = data.startOperationBo;
        this.endOperationBo = data.endOperationBo;
        this.recipeOperationBo = data.recipeOperationBo;
        this.sfcQty = data.sfcQty;
        this.sfcType = data.sfcType;
        this.processType = data.processType;
        this.processOperation = data.processOperation;
        this.recipeBuyOffParam = data.recipeBuyOffParam;
        this.remark = data.remark;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
    }	

    @Override
    public ViewDeviceBuyOffOperation clone() {
    	return new ViewDeviceBuyOffOperation(this);
    }

    @Override
    public String toString() {
        return this.itemGroupBo;
    }
}
