package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class CdmMoHeader {

    private String moType;

    private String moId;

    private String sapMoId;

    private String custCode;

    private String customerDevice;

    private String htPn;

    private String productPn;

    private String sapProductPn;

    private String fabDevice;

    private String waferPn;

    private String planStartDate;

    private String planEndDate;

    private String moPriority;

    private String moDc;

    private String lotQty;

    private String waferQty;

    private String dieQty;

    private String poId;

    private String poItem;

    private String soId;

    private String soItem;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String flag;

    private String flag2;

    private String remark1;

    private String remark2;

    private String remark3;

    private String requestJson;

    private String responseJson;

    private String id;

    private String firstCommitDate;

    private String requestContent;

    private String responseContent;


    public CdmMoHeader() {
    }	

    public CdmMoHeader(CdmMoHeader data) {
        this.moType = data.moType;
        this.moId = data.moId;
        this.sapMoId = data.sapMoId;
        this.custCode = data.custCode;
        this.customerDevice = data.customerDevice;
        this.htPn = data.htPn;
        this.productPn = data.productPn;
        this.sapProductPn = data.sapProductPn;
        this.fabDevice = data.fabDevice;
        this.waferPn = data.waferPn;
        this.planStartDate = data.planStartDate;
        this.planEndDate = data.planEndDate;
        this.moPriority = data.moPriority;
        this.moDc = data.moDc;
        this.lotQty = data.lotQty;
        this.waferQty = data.waferQty;
        this.dieQty = data.dieQty;
        this.poId = data.poId;
        this.poItem = data.poItem;
        this.soId = data.soId;
        this.soItem = data.soItem;
        this.createBy = data.createBy;
        this.createDate = data.createDate;
        this.updateBy = data.updateBy;
        this.updateDate = data.updateDate;
        this.flag = data.flag;
        this.flag2 = data.flag2;
        this.remark1 = data.remark1;
        this.remark2 = data.remark2;
        this.remark3 = data.remark3;
        this.requestJson = data.requestJson;
        this.responseJson = data.responseJson;
        this.id = data.id;
        this.firstCommitDate = data.firstCommitDate;
        this.requestContent = data.requestContent;
        this.responseContent = data.responseContent;
    }	

    @Override
    public CdmMoHeader clone() {
    	return new CdmMoHeader(this);
    }

    @Override
    public String toString() {
        return this.moId;
    }
}
