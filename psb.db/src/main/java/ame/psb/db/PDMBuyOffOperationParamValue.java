package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PDMBuyOffOperationParamValue {

    private String itemGroupBo;

    private String operationBo;

    private String paramName;

    private String paramValue;

    private String paramType;

    private String paramDescription;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PDMBuyOffOperationParamValue() {
    }	

    public PDMBuyOffOperationParamValue(PDMBuyOffOperationParamValue data) {
        this.itemGroupBo = data.itemGroupBo;
        this.operationBo = data.operationBo;
        this.paramName = data.paramName;
        this.paramValue = data.paramValue;
        this.paramType = data.paramType;
        this.paramDescription = data.paramDescription;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PDMBuyOffOperationParamValue clone() {
    	return new PDMBuyOffOperationParamValue(this);
    }

    @Override
    public String toString() {
        return this.itemGroupBo + ", " + this.operationBo + ", " + this.paramName;
    }
}
