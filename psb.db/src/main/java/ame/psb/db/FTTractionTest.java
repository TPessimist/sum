package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * FT拉力测试实体类
 */
@Data
public class FTTractionTest {

    private String uuid;

    private String sfc;

    private BigDecimal max;

    private BigDecimal min;

    private BigDecimal average;

    private BigDecimal cpk;

    private String result;

    private String opportunity;

    private String mode;

    private String customer;

    private String zdSupplier;

    private String zdSfc;

    private String gdSupplier;

    private String gdSfc;

    private String user;

    private Date time;

    private String resource;

    private String packageName;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public FTTractionTest() {
    }	

    public FTTractionTest(FTTractionTest data) {
        this.uuid = data.uuid;
        this.sfc = data.sfc;
        this.max = data.max;
        this.min = data.min;
        this.average = data.average;
        this.cpk = data.cpk;
        this.result = data.result;
        this.opportunity = data.opportunity;
        this.mode = data.mode;
        this.customer = data.customer;
        this.zdSupplier = data.zdSupplier;
        this.zdSfc = data.zdSfc;
        this.gdSupplier = data.gdSupplier;
        this.gdSfc = data.gdSfc;
        this.user = data.user;
        this.time = data.time;
        this.resource = data.resource;
        this.packageName = data.packageName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public FTTractionTest clone() {
    	return new FTTractionTest(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
