package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class InStockContainerHandover {

    private String containerId;

    private String containerName;

    private String stateName;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public InStockContainerHandover() {
    }	

    public InStockContainerHandover(InStockContainerHandover data) {
        this.containerId = data.containerId;
        this.containerName = data.containerName;
        this.stateName = data.stateName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public InStockContainerHandover clone() {
    	return new InStockContainerHandover(this);
    }

    @Override
    public String toString() {
        return this.containerId;
    }
}
