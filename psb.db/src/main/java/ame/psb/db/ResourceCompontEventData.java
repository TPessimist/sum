package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ResourceCompontEventData {

    private String uuid;

    private String id;

    private String resourceBo;

    private String waferId;

    private String sfc;

    private String componentId;

    private String eventName;

    private String eventMessage;

    private Date begingTime;

    private Date endTime;

    private Date eventTime;

    private String eventUser;

    private String operationBo;


    public ResourceCompontEventData() {
    }
    public void generateId() {
        if (this.resourceBo == null || this.componentId == null || this.eventName == null) {
            throw new NullPointerException("resourceBo||componentId||eventName is null");
        }
        this.id = this.resourceBo + "::" + this.componentId + "::" + this.eventName + "::" + System
            .currentTimeMillis();
    }
    public ResourceCompontEventData(ResourceCompontEventData data) {
        this.uuid = data.uuid;
        this.id = data.id;
        this.resourceBo = data.resourceBo;
        this.waferId = data.waferId;
        this.sfc = data.sfc;
        this.componentId = data.componentId;
        this.eventName = data.eventName;
        this.eventMessage = data.eventMessage;
        this.begingTime = data.begingTime;
        this.endTime = data.endTime;
        this.eventTime = data.eventTime;
        this.eventUser = data.eventUser;
        this.operationBo = data.operationBo;
    }	

    @Override
    public ResourceCompontEventData clone() {
    	return new ResourceCompontEventData(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
