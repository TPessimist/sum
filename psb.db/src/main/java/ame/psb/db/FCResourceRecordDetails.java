package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FCResourceRecordDetails {

    private String uuid;

    private String waferName;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public FCResourceRecordDetails() {
    }	

    public FCResourceRecordDetails(FCResourceRecordDetails data) {
        this.uuid = data.uuid;
        this.waferName = data.waferName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public FCResourceRecordDetails clone() {
    	return new FCResourceRecordDetails(this);
    }

    @Override
    public String toString() {
        return this.uuid + ", " + this.waferName;
    }
}
