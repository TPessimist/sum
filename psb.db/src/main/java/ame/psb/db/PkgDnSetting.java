package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PkgDnSetting {

    private String itemGroupBo;

    private String actionName;

    private String labelBo;

    private String labelTagName;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PkgDnSetting() {
    }	

    public PkgDnSetting(PkgDnSetting data) {
        this.itemGroupBo = data.itemGroupBo;
        this.actionName = data.actionName;
        this.labelBo = data.labelBo;
        this.labelTagName = data.labelTagName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PkgDnSetting clone() {
    	return new PkgDnSetting(this);
    }

    @Override
    public String toString() {
        return this.itemGroupBo + ", " + this.actionName + ", " + this.labelBo + ", " + this.labelTagName;
    }

    public String value() {
        return this.actionName + ", " + this.labelBo + ", " + this.labelTagName;
    }
}
