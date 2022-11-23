package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FTTractionResult {

    private String sfcBo;

    private String sfc;

    private String shopOrderBo;

    private String shopOrderName;

    private String result;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public FTTractionResult() {
    }	

    public FTTractionResult(FTTractionResult data) {
        this.sfcBo = data.sfcBo;
        this.sfc = data.sfc;
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.result = data.result;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public FTTractionResult clone() {
    	return new FTTractionResult(this);
    }

    @Override
    public String toString() {
        return this.sfcBo;
    }
}
