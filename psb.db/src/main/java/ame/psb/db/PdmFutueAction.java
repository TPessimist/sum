package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PdmFutueAction {

    private String uuid;

    private String stateName;

    private String itemBo;

    private String operationBo;

    private String reverseField1;

    private String reverseField2;

    private String reverseField3;

    private String updatedUser;

    private Date updatedTime;


    public PdmFutueAction() {
    }	

    public PdmFutueAction(PdmFutueAction data) {
        this.uuid = data.uuid;
        this.stateName = data.stateName;
        this.itemBo = data.itemBo;
        this.operationBo = data.operationBo;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.reverseField3 = data.reverseField3;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PdmFutueAction clone() {
    	return new PdmFutueAction(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
