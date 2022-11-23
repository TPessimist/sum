package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class UtilMainQueueJob {

    private String id;

    private String mainQueueBo;

    private BigDecimal queueJobSeq;

    private String queueJobContent;

    private String queueJobStatus;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public UtilMainQueueJob() {
    }	

    public UtilMainQueueJob(UtilMainQueueJob data) {
        this.id = data.id;
        this.mainQueueBo = data.mainQueueBo;
        this.queueJobSeq = data.queueJobSeq;
        this.queueJobContent = data.queueJobContent;
        this.queueJobStatus = data.queueJobStatus;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public UtilMainQueueJob clone() {
    	return new UtilMainQueueJob(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
