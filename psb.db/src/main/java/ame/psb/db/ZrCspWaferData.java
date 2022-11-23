package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ZrCspWaferData {

    private String wafetName;

    private String operationBo;

    private String qty;

    private String detailsId;

    private String resourceName;

    private String sfcBo;

    private String shopOrderBo;

    private String state;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public ZrCspWaferData() {
    }	

    public ZrCspWaferData(ZrCspWaferData data) {
        this.wafetName = data.wafetName;
        this.operationBo = data.operationBo;
        this.qty = data.qty;
        this.detailsId = data.detailsId;
        this.resourceName = data.resourceName;
        this.sfcBo = data.sfcBo;
        this.shopOrderBo = data.shopOrderBo;
        this.state = data.state;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZrCspWaferData clone() {
    	return new ZrCspWaferData(this);
    }

    @Override
    public String toString() {
        return this.wafetName + ", " + this.operationBo;
    }
}
