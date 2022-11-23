package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FOWaferPoHeader {

    private String uuid;

    private String cspWafer;

    private String cspShopOrder;

    private String cspPo;

    private String productWafer;

    private String productShopOrder;

    private String productPo;

    private String result;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public FOWaferPoHeader() {
    }	

    public FOWaferPoHeader(FOWaferPoHeader data) {
        this.uuid = data.uuid;
        this.cspWafer = data.cspWafer;
        this.cspShopOrder = data.cspShopOrder;
        this.cspPo = data.cspPo;
        this.productWafer = data.productWafer;
        this.productShopOrder = data.productShopOrder;
        this.productPo = data.productPo;
        this.result = data.result;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public FOWaferPoHeader clone() {
    	return new FOWaferPoHeader(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
