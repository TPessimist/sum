package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PmcLocationData {

    private String batchId;

    private String locationData;

    private String shopOrderBo;

    private String locationState;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public PmcLocationData() {
    }	

    public PmcLocationData(PmcLocationData data) {
        this.batchId = data.batchId;
        this.locationData = data.locationData;
        this.shopOrderBo = data.shopOrderBo;
        this.locationState = data.locationState;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PmcLocationData clone() {
    	return new PmcLocationData(this);
    }

    @Override
    public String toString() {
        return this.batchId + ", " + this.locationData;
    }
}
