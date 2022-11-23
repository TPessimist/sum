package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class InStockSampleToProductionShopOrder {

    private String itemGroupBo;

    private String oaFlag;

    private String shopOrderList;

    private String itemBo;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public InStockSampleToProductionShopOrder() {
    }	

    public InStockSampleToProductionShopOrder(InStockSampleToProductionShopOrder data) {
        this.itemGroupBo = data.itemGroupBo;
        this.oaFlag = data.oaFlag;
        this.shopOrderList = data.shopOrderList;
        this.itemBo = data.itemBo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public InStockSampleToProductionShopOrder clone() {
    	return new InStockSampleToProductionShopOrder(this);
    }

    @Override
    public String toString() {
        return this.itemGroupBo;
    }
}
