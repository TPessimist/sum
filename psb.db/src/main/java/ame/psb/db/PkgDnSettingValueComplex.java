package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PkgDnSettingValueComplex {

    private String reelId;

    private String actionName;

    private String labelTagValue;

    private String dnNo;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PkgDnSettingValueComplex() {
    }	

    public PkgDnSettingValueComplex(PkgDnSettingValueComplex data) {
        this.reelId = data.reelId;
        this.actionName = data.actionName;
        this.labelTagValue = data.labelTagValue;
        this.dnNo = data.dnNo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PkgDnSettingValueComplex clone() {
    	return new PkgDnSettingValueComplex(this);
    }

    @Override
    public String toString() {
        return this.reelId + ", " + this.actionName;
    }
}
