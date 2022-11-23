package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CarrierComparison {

    private String carrierBo;

    private String carrierName;

    private String comparisonState;

    private String reason;

    private String carrierState;

    private String useState;

    private BigDecimal carrierQty;

    private BigDecimal comparisonQty;

    private String reversedField1;

    private String reversedField2;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;


    public CarrierComparison() {
    }	

    public CarrierComparison(CarrierComparison data) {
        this.carrierBo = data.carrierBo;
        this.carrierName = data.carrierName;
        this.comparisonState = data.comparisonState;
        this.reason = data.reason;
        this.carrierState = data.carrierState;
        this.useState = data.useState;
        this.carrierQty = data.carrierQty;
        this.comparisonQty = data.comparisonQty;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
        this.modifiedUser = data.modifiedUser;
        this.modifiedTime = data.modifiedTime;
    }	

    @Override
    public CarrierComparison clone() {
    	return new CarrierComparison(this);
    }

    @Override
    public String toString() {
        return this.carrierBo;
    }
}
