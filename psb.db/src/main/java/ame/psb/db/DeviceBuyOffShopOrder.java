package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class DeviceBuyOffShopOrder {

    private String itemGroupBo;

    private String shopOrderBo;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public DeviceBuyOffShopOrder() {
    }	

    public DeviceBuyOffShopOrder(DeviceBuyOffShopOrder data) {
        this.itemGroupBo = data.itemGroupBo;
        this.shopOrderBo = data.shopOrderBo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public DeviceBuyOffShopOrder clone() {
    	return new DeviceBuyOffShopOrder(this);
    }

    @Override
    public String toString() {
        return this.shopOrderBo;
    }
}
