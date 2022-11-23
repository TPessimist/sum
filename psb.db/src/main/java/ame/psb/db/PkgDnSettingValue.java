package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PkgDnSettingValue {

    private String reelId;

    private String actionName;

    private String labelId;

    private String labelTagName;

    private String labelTagValue;

    private String dnNo;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PkgDnSettingValue() {
    }	

    public PkgDnSettingValue(PkgDnSettingValue data) {
        this.reelId = data.reelId;
        this.actionName = data.actionName;
        this.labelId = data.labelId;
        this.labelTagName = data.labelTagName;
        this.labelTagValue = data.labelTagValue;
        this.dnNo = data.dnNo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PkgDnSettingValue clone() {
    	return new PkgDnSettingValue(this);
    }

    @Override
    public String toString() {
        return this.reelId + ", " + this.actionName + ", " + this.labelId + ", " + this.labelTagName;
    }
}
