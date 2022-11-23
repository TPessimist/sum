package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ExposureConfigure {

    private String waferInch;

    private String waferType;

    private String glueType;

    private String weeEnergy;

    private String weeDistance;

    private String weeWidth;

    private String wepEnergy;

    private String reversedField1;

    private String reversedField2;

    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;


    public ExposureConfigure() {
    }	

    public ExposureConfigure(ExposureConfigure data) {
        this.waferInch = data.waferInch;
        this.waferType = data.waferType;
        this.glueType = data.glueType;
        this.weeEnergy = data.weeEnergy;
        this.weeDistance = data.weeDistance;
        this.weeWidth = data.weeWidth;
        this.wepEnergy = data.wepEnergy;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
        this.modifiedUser = data.modifiedUser;
        this.modifiedTime = data.modifiedTime;
    }	

    @Override
    public ExposureConfigure clone() {
    	return new ExposureConfigure(this);
    }

    @Override
    public String toString() {
        return this.waferInch;
    }
}
