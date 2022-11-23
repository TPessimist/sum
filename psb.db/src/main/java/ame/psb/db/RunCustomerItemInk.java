package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class RunCustomerItemInk {

    private String id;

    private String customerItemBo;

    private String binmapRuleBo;

    private String inkRuleName;

    private String inkConfigJson;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public RunCustomerItemInk() {
    }	

    public RunCustomerItemInk(RunCustomerItemInk data) {
        this.id = data.id;
        this.customerItemBo = data.customerItemBo;
        this.binmapRuleBo = data.binmapRuleBo;
        this.inkRuleName = data.inkRuleName;
        this.inkConfigJson = data.inkConfigJson;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public RunCustomerItemInk clone() {
    	return new RunCustomerItemInk(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
