package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PkgRunSfcItem {

    private String id;

    private String runSfcBo;

    private String sfcBo;

    private String customerItemBo;

    private String stateName;

    private Date beginTime;

    private Date endTime;

    private String run;

    private String resourceBo;

    private String operationBo;

    private String routerBo;

    private String recipeName;

    private String remark;

    private String runUser;


    public PkgRunSfcItem() {
    }	

    public PkgRunSfcItem(PkgRunSfcItem data) {
        this.id = data.id;
        this.runSfcBo = data.runSfcBo;
        this.sfcBo = data.sfcBo;
        this.customerItemBo = data.customerItemBo;
        this.stateName = data.stateName;
        this.beginTime = data.beginTime;
        this.endTime = data.endTime;
        this.run = data.run;
        this.resourceBo = data.resourceBo;
        this.operationBo = data.operationBo;
        this.routerBo = data.routerBo;
        this.recipeName = data.recipeName;
        this.remark = data.remark;
        this.runUser = data.runUser;
    }	

    @Override
    public PkgRunSfcItem clone() {
    	return new PkgRunSfcItem(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
