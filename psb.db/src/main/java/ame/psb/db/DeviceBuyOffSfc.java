package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class DeviceBuyOffSfc {

    private String sfcBo;

    private String opertionBo;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public DeviceBuyOffSfc() {
    }	

    public DeviceBuyOffSfc(DeviceBuyOffSfc data) {
        this.sfcBo = data.sfcBo;
        this.opertionBo = data.opertionBo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public DeviceBuyOffSfc clone() {
    	return new DeviceBuyOffSfc(this);
    }

    @Override
    public String toString() {
        return this.sfcBo + ", " + this.opertionBo;
    }
}
