package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class CdmPoTime {

    private String custCode;

    private String sapCustCode;

    private String tradCustCode;

    private String poId;

    private String poType;

    private String poDate;

    private String bonded;

    private String customerDevice;

    private String fabDevice;

    private String custFabDevice1;

    private String custFabDevice2;

    private String htPn;

    private String productPn;

    private String sapProductPn;

    private String lotId;

    private String waferId;

    private String lotWaferId;

    private String passbinCount;

    private String failbinCount;

    private String markCode;

    private String add0;

    private String add1;

    private String add2;

    private String add3;

    private String add4;

    private String add5;

    private String add6;

    private String add7;

    private String add8;

    private String add9;

    private String add10;

    private String cdmId;

    private String cdmItem;

    private String soId;

    private String soItem;

    private String moId;

    private String moItem;

    private String flag;

    private String flag2;

    private String flag3;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String waferTimes;

    private String uploadId;

    private String waferSn;

    private String id;

    private String waferPcsPrice;

    private String waferDiePrice;

    private String waferHold;

    private String add11;

    private String add12;

    private String add13;

    private String add14;

    private String add15;

    private String add16;

    private String add17;

    private String add18;

    private String add19;

    private String add20;

    private String add21;

    private String add22;

    private String add23;

    private String add24;

    private String add25;

    private String add26;

    private String add27;

    private String add28;

    private String add29;

    private String add30;

    private String addressCode;

    private String baseSo;

    private String status;

    private String remark1;

    private String remark2;

    private String remark3;

    private String poH;

    private String flag4;

    private String flag5;

    private String remakr4;

    private String remakr5;


    public CdmPoTime() {
    }	

    public CdmPoTime(CdmPoTime data) {
        this.custCode = data.custCode;
        this.sapCustCode = data.sapCustCode;
        this.tradCustCode = data.tradCustCode;
        this.poId = data.poId;
        this.poType = data.poType;
        this.poDate = data.poDate;
        this.bonded = data.bonded;
        this.customerDevice = data.customerDevice;
        this.fabDevice = data.fabDevice;
        this.custFabDevice1 = data.custFabDevice1;
        this.custFabDevice2 = data.custFabDevice2;
        this.htPn = data.htPn;
        this.productPn = data.productPn;
        this.sapProductPn = data.sapProductPn;
        this.lotId = data.lotId;
        this.waferId = data.waferId;
        this.lotWaferId = data.lotWaferId;
        this.passbinCount = data.passbinCount;
        this.failbinCount = data.failbinCount;
        this.markCode = data.markCode;
        this.add0 = data.add0;
        this.add1 = data.add1;
        this.add2 = data.add2;
        this.add3 = data.add3;
        this.add4 = data.add4;
        this.add5 = data.add5;
        this.add6 = data.add6;
        this.add7 = data.add7;
        this.add8 = data.add8;
        this.add9 = data.add9;
        this.add10 = data.add10;
        this.cdmId = data.cdmId;
        this.cdmItem = data.cdmItem;
        this.soId = data.soId;
        this.soItem = data.soItem;
        this.moId = data.moId;
        this.moItem = data.moItem;
        this.flag = data.flag;
        this.flag2 = data.flag2;
        this.flag3 = data.flag3;
        this.createDate = data.createDate;
        this.createBy = data.createBy;
        this.updateDate = data.updateDate;
        this.updateBy = data.updateBy;
        this.waferTimes = data.waferTimes;
        this.uploadId = data.uploadId;
        this.waferSn = data.waferSn;
        this.id = data.id;
        this.waferPcsPrice = data.waferPcsPrice;
        this.waferDiePrice = data.waferDiePrice;
        this.waferHold = data.waferHold;
        this.add11 = data.add11;
        this.add12 = data.add12;
        this.add13 = data.add13;
        this.add14 = data.add14;
        this.add15 = data.add15;
        this.add16 = data.add16;
        this.add17 = data.add17;
        this.add18 = data.add18;
        this.add19 = data.add19;
        this.add20 = data.add20;
        this.add21 = data.add21;
        this.add22 = data.add22;
        this.add23 = data.add23;
        this.add24 = data.add24;
        this.add25 = data.add25;
        this.add26 = data.add26;
        this.add27 = data.add27;
        this.add28 = data.add28;
        this.add29 = data.add29;
        this.add30 = data.add30;
        this.addressCode = data.addressCode;
        this.baseSo = data.baseSo;
        this.status = data.status;
        this.remark1 = data.remark1;
        this.remark2 = data.remark2;
        this.remark3 = data.remark3;
        this.poH = data.poH;
        this.flag4 = data.flag4;
        this.flag5 = data.flag5;
        this.remakr4 = data.remakr4;
        this.remakr5 = data.remakr5;
    }	

    @Override
    public CdmPoTime clone() {
    	return new CdmPoTime(this);
    }

    @Override
    public String toString() {
        return this.waferSn;
    }
}
