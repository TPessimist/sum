package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PmcLocationDataLog {

    private String uuid;

    private String batchId;

    private String shopOrderBo;

    private String locationData;

    private String locationState;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PmcLocationDataLog() {
    }

    public PmcLocationDataLog(String uuid, String batchId, String shopOrderBo,
        String locationData, String locationState, String reversedField1,
        String reversedField2, String updatedUser, Date updatedTime) {
        this.uuid = uuid;
        this.batchId = batchId;
        this.shopOrderBo = shopOrderBo;
        this.locationData = locationData;
        this.locationState = locationState;
        this.reversedField1 = reversedField1;
        this.reversedField2 = reversedField2;
        this.updatedUser = updatedUser;
        this.updatedTime = updatedTime;
    }

    public PmcLocationDataLog(PmcLocationDataLog data) {
        this.uuid = data.uuid;
        this.batchId = data.batchId;
        this.shopOrderBo = data.shopOrderBo;
        this.locationData = data.locationData;
        this.locationState = data.locationState;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PmcLocationDataLog clone() {
    	return new PmcLocationDataLog(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
