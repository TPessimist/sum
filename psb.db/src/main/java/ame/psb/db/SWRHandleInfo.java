package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class SWRHandleInfo {

    private String id;

    private String sfcBo;

    private String customerItemBo;

    private String holdCode;

    private String operationBo;

    private String itemGroupBo;

    private String oaId;

    private String oaStatus;

    private String releaseFlag;

    private String rerlId;

    private String innerBoxId;

    private String outerBoxId;

    private String reverseField1;

    private String reverseField2;

    private String updatedUser;

    private Date updatedTime;

    private String custItemGroup;

    private String lotId;

    private String grossDiesl;


    public SWRHandleInfo() {
    }	

    public SWRHandleInfo(SWRHandleInfo data) {
        this.id = data.id;
        this.sfcBo = data.sfcBo;
        this.customerItemBo = data.customerItemBo;
        this.holdCode = data.holdCode;
        this.operationBo = data.operationBo;
        this.itemGroupBo = data.itemGroupBo;
        this.oaId = data.oaId;
        this.oaStatus = data.oaStatus;
        this.releaseFlag = data.releaseFlag;
        this.rerlId = data.rerlId;
        this.innerBoxId = data.innerBoxId;
        this.outerBoxId = data.outerBoxId;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public SWRHandleInfo clone() {
    	return new SWRHandleInfo(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
