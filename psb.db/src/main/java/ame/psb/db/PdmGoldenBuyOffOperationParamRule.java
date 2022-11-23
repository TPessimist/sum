package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PdmGoldenBuyOffOperationParamRule {

    private String recipeBuyOffOperationBo;

    private String recipeSetupOperationBo;

    private String processType;

    private String processOperation;

    private String recipeDescription;

    private String recipeBuyOffParam;

    private String recipeBuyOffWaferType;

    private String remark;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PdmGoldenBuyOffOperationParamRule() {
    }	

    public PdmGoldenBuyOffOperationParamRule(PdmGoldenBuyOffOperationParamRule data) {
        this.recipeBuyOffOperationBo = data.recipeBuyOffOperationBo;
        this.recipeSetupOperationBo = data.recipeSetupOperationBo;
        this.processType = data.processType;
        this.processOperation = data.processOperation;
        this.recipeDescription = data.recipeDescription;
        this.recipeBuyOffParam = data.recipeBuyOffParam;
        this.recipeBuyOffWaferType = data.recipeBuyOffWaferType;
        this.remark = data.remark;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PdmGoldenBuyOffOperationParamRule clone() {
    	return new PdmGoldenBuyOffOperationParamRule(this);
    }

    @Override
    public String toString() {
        return this.recipeBuyOffOperationBo + ", " + this.recipeSetupOperationBo;
    }
}
