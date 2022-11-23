package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class UtilMainQueue {

    private String id;

    private String queueType;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public UtilMainQueue() {
    }	

    public UtilMainQueue(UtilMainQueue data) {
        this.id = data.id;
        this.queueType = data.queueType;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public UtilMainQueue clone() {
    	return new UtilMainQueue(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
