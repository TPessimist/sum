package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FcCompareResult {

    private String id;

    private String customerItemsetBo;

    private String itemsetName;

    private String origWaferId;

    private String waferId;

    private String stateName;

    private String sfcBo;

    private String sfc;

    private String shopOrderBo;

    private String shopOrder;

    private String customer;

    private String deviceName;

    private String itemName;

    private String updatedUser;

    private Date updatedTime;

    private String reserves1;

    private String reserves2;


    public FcCompareResult() {
    }	

    public FcCompareResult(FcCompareResult data) {
        this.id = data.id;
        this.customerItemsetBo = data.customerItemsetBo;
        this.itemsetName = data.itemsetName;
        this.origWaferId = data.origWaferId;
        this.waferId = data.waferId;
        this.stateName = data.stateName;
        this.sfcBo = data.sfcBo;
        this.sfc = data.sfc;
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrder = data.shopOrder;
        this.customer = data.customer;
        this.deviceName = data.deviceName;
        this.itemName = data.itemName;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
        this.reserves1 = data.reserves1;
        this.reserves2 = data.reserves2;
    }	

    @Override
    public FcCompareResult clone() {
    	return new FcCompareResult(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
