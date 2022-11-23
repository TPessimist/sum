package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ViewSubordinateOperation {

    private String masterDeviceBo;

    private String assistantDeviceBo;

    private String subordinateType;

    private String operationBo;

    private String differenceBo;

    private String describe;


    public ViewSubordinateOperation() {
    }	

    public ViewSubordinateOperation(ViewSubordinateOperation data) {
        this.masterDeviceBo = data.masterDeviceBo;
        this.assistantDeviceBo = data.assistantDeviceBo;
        this.subordinateType = data.subordinateType;
        this.operationBo = data.operationBo;
        this.differenceBo = data.differenceBo;
        this.describe = data.describe;
    }	

    @Override
    public ViewSubordinateOperation clone() {
    	return new ViewSubordinateOperation(this);
    }

    @Override
    public String toString() {
        return this.masterDeviceBo;
    }
}
