package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class FtTailStorageMain {

    private String uuid;

    private String shopOrderBo;

    private String uniqueCode;

    private String sfcBo;

    private BigDecimal tailQty;

    private String tailLocation;

    private String tailCustomerDevice;

    private String tailState;

    private String reversedField1;

    private String reversedField2;

    private Date updatedTime;

    private String updatedUser;


    public FtTailStorageMain() {
    }	

    public FtTailStorageMain(FtTailStorageMain data) {
        this.uuid = data.uuid;
        this.shopOrderBo = data.shopOrderBo;
        this.uniqueCode = data.uniqueCode;
        this.sfcBo = data.sfcBo;
        this.tailQty = data.tailQty;
        this.tailLocation = data.tailLocation;
        this.tailCustomerDevice = data.tailCustomerDevice;
        this.tailState = data.tailState;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedTime = data.updatedTime;
        this.updatedUser = data.updatedUser;
    }	

    @Override
    public FtTailStorageMain clone() {
    	return new FtTailStorageMain(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
