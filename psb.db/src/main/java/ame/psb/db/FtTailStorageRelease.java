package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtTailStorageRelease {

    private String shopOrderBo;

    private String shopOrderName;

    private String bindingType;

    private String reversedField1;

    private String reversedField2;

    private Date modifyTime;

    private String modifyUser;

    private Date updatedTime;

    private String updatedUser;


    public FtTailStorageRelease() {
    }	

    public FtTailStorageRelease(FtTailStorageRelease data) {
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.bindingType = data.bindingType;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.modifyTime = data.modifyTime;
        this.modifyUser = data.modifyUser;
        this.updatedTime = data.updatedTime;
        this.updatedUser = data.updatedUser;
    }	

    @Override
    public FtTailStorageRelease clone() {
    	return new FtTailStorageRelease(this);
    }

    @Override
    public String toString() {
        return this.shopOrderBo + ", " + this.bindingType;
    }
}
