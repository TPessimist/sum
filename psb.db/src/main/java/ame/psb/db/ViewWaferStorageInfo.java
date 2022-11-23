package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ViewWaferStorageInfo {

    private String handle;

    private String sfc;

    private String deviceName;

    private String customer;

    private String waferId;

    private BigDecimal balanceQty;

    private Date filmTime;

    private Date expireTime;

    private String membranceType;

    private String storageLocation1;

    private String storageLocation2;

    private String storageLocation3;

    private String createdUser;

    private Date createdTime;

    private String claimedUser;

    private Date claimedTime;

    private String id;

    private String remainWaferCarrierBo;

    private String normalWaferCarrierBo;

    private String remainWaferDoneFlag;

    private String normalWaferDoneFlag;

    private String reverseField1;

    private String reverseField2;

    private String updatedUser;

    private Date updatedTime;


    public ViewWaferStorageInfo() {
    }	

    public ViewWaferStorageInfo(ViewWaferStorageInfo data) {
        this.handle = data.handle;
        this.sfc = data.sfc;
        this.deviceName = data.deviceName;
        this.customer = data.customer;
        this.waferId = data.waferId;
        this.balanceQty = data.balanceQty;
        this.filmTime = data.filmTime;
        this.expireTime = data.expireTime;
        this.membranceType = data.membranceType;
        this.storageLocation1 = data.storageLocation1;
        this.storageLocation2 = data.storageLocation2;
        this.storageLocation3 = data.storageLocation3;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
        this.claimedUser = data.claimedUser;
        this.claimedTime = data.claimedTime;
        this.id = data.id;
        this.remainWaferCarrierBo = data.remainWaferCarrierBo;
        this.normalWaferCarrierBo = data.normalWaferCarrierBo;
        this.remainWaferDoneFlag = data.remainWaferDoneFlag;
        this.normalWaferDoneFlag = data.normalWaferDoneFlag;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ViewWaferStorageInfo clone() {
    	return new ViewWaferStorageInfo(this);
    }

    @Override
    public String toString() {
        return this.handle;
    }
}
