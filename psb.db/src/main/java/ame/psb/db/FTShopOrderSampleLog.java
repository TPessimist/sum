package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FTShopOrderSampleLog {

    private String uuid;

    private String shopOrder;

    private String testerType;

    private String handlerType;

    private String testTime;

    private String siteCount;

    private String uph;

    private String siliconRev;

    private String reversedField1;

    private String reversedField2;

    private String createUser;

    private Date createTime;


    public FTShopOrderSampleLog() {
    }	

    public FTShopOrderSampleLog(FTShopOrderSampleLog data) {
        this.uuid = data.uuid;
        this.shopOrder = data.shopOrder;
        this.testerType = data.testerType;
        this.handlerType = data.handlerType;
        this.testTime = data.testTime;
        this.siteCount = data.siteCount;
        this.uph = data.uph;
        this.siliconRev = data.siliconRev;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.createUser = data.createUser;
        this.createTime = data.createTime;
    }	

    @Override
    public FTShopOrderSampleLog clone() {
    	return new FTShopOrderSampleLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
