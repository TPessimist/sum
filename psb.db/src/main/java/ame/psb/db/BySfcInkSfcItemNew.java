package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class BySfcInkSfcItemNew {

    private String id;

    private String customerItemBo;

    private String binmapRuleBo;

    private BigDecimal sequence;

    private String inkRuleName;

    private String inkConfigJson;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public BySfcInkSfcItemNew() {
    }	

    public BySfcInkSfcItemNew(BySfcInkSfcItemNew data) {
        this.id = data.id;
        this.customerItemBo = data.customerItemBo;
        this.binmapRuleBo = data.binmapRuleBo;
        this.sequence = data.sequence;
        this.inkRuleName = data.inkRuleName;
        this.inkConfigJson = data.inkConfigJson;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public BySfcInkSfcItemNew clone() {
    	return new BySfcInkSfcItemNew(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
