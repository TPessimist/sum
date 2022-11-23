package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class InStockContainerHandoverLog {

    private String id;

    private String containerId;

    private String containerName;

    private String actionName;

    private String requestContent;

    private String responseContent;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public InStockContainerHandoverLog() {
    }	

    public InStockContainerHandoverLog(InStockContainerHandoverLog data) {
        this.id = data.id;
        this.containerId = data.containerId;
        this.containerName = data.containerName;
        this.actionName = data.actionName;
        this.requestContent = data.requestContent;
        this.responseContent = data.responseContent;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public InStockContainerHandoverLog clone() {
    	return new InStockContainerHandoverLog(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
