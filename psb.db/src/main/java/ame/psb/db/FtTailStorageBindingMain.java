package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtTailStorageBindingMain {

    private String shopOrderBo;

    private String shopOrderName;

    private String uniqueCode; 

    private String uniqueCodeShopOrder;

    private String uniqueCodeShopOrderName;

    private String bindingType;

    private String reversedField1;

    private String reversedField2;

    private Date modifyTime;

    private String modifyUser;


    public FtTailStorageBindingMain() {
    }	

    public FtTailStorageBindingMain(FtTailStorageBindingMain data) {
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.uniqueCode = data.uniqueCode;
        this.uniqueCodeShopOrder = data.uniqueCodeShopOrder;
        this.uniqueCodeShopOrderName = data.uniqueCodeShopOrderName;
        this.bindingType = data.bindingType;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.modifyTime = data.modifyTime;
        this.modifyUser = data.modifyUser;
    }	

    @Override
    public FtTailStorageBindingMain clone() {
    	return new FtTailStorageBindingMain(this);
    }

    @Override
    public String toString() {
        return this.shopOrderBo + ", " + this.uniqueCode;
    }
}
