package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FCResourceRecord {

    private String uuid;

    private String resourceBo;

    private String lastResourceState;

    private String nowResourceState;

    private String sfcBo;

    private String shopOrderBo;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public FCResourceRecord() {
    }	

    public FCResourceRecord(FCResourceRecord data) {
        this.uuid = data.uuid;
        this.resourceBo = data.resourceBo;
        this.lastResourceState = data.lastResourceState;
        this.nowResourceState = data.nowResourceState;
        this.sfcBo = data.sfcBo;
        this.shopOrderBo = data.shopOrderBo;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public FCResourceRecord clone() {
    	return new FCResourceRecord(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
