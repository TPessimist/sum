package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Usr {

    private String handle;

    private BigDecimal changeStamp;

    private String site;

    private String userId;

    private String currentOperationBo;

    private String currentResourceBo;

    private Date createdDateTime;

    private Date modifiedDateTime;

    private String badgeNumber;

    private String employeeNumber;

    private String hireDate;

    private String terminationDate;

    private String allowClockInNonProd;

    private String actionClockOutSfc;

    private String clockInOutRange;

    private String allowSupTimeEditAppr;

    private String apprReqForExport;

    private String autoClockOut;

    private String clockInControl;

    private String defaultWorkCenterBo;

    private String erpPersonnelNumber;

    private String erpUser;


    public Usr() {
    }	

    public Usr(Usr data) {
        this.handle = data.handle;
        this.changeStamp = data.changeStamp;
        this.site = data.site;
        this.userId = data.userId;
        this.currentOperationBo = data.currentOperationBo;
        this.currentResourceBo = data.currentResourceBo;
        this.createdDateTime = data.createdDateTime;
        this.modifiedDateTime = data.modifiedDateTime;
        this.badgeNumber = data.badgeNumber;
        this.employeeNumber = data.employeeNumber;
        this.hireDate = data.hireDate;
        this.terminationDate = data.terminationDate;
        this.allowClockInNonProd = data.allowClockInNonProd;
        this.actionClockOutSfc = data.actionClockOutSfc;
        this.clockInOutRange = data.clockInOutRange;
        this.allowSupTimeEditAppr = data.allowSupTimeEditAppr;
        this.apprReqForExport = data.apprReqForExport;
        this.autoClockOut = data.autoClockOut;
        this.clockInControl = data.clockInControl;
        this.defaultWorkCenterBo = data.defaultWorkCenterBo;
        this.erpPersonnelNumber = data.erpPersonnelNumber;
        this.erpUser = data.erpUser;
    }	

    @Override
    public Usr clone() {
    	return new Usr(this);
    }

    @Override
    public String toString() {
        return this.handle;
    }
}
