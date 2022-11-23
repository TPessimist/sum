package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class McsLayoutContent {

    private String resourceBo;

    private String nextResourceBo;

    private String bayBo;

    private String id;

    private String slotNo;

    private String slotType;

    private String content;

    private BigDecimal capacity;

    private String rootResource;

    private String updatedUser;

    private Date updatedTime;

    private String ref;

    private String reserveFor;

    private String stateName;

    private String type;


    public McsLayoutContent() {
    }	

    public McsLayoutContent(McsLayoutContent data) {
        this.resourceBo = data.resourceBo;
        this.nextResourceBo = data.nextResourceBo;
        this.bayBo = data.bayBo;
        this.id = data.id;
        this.slotNo = data.slotNo;
        this.slotType = data.slotType;
        this.content = data.content;
        this.capacity = data.capacity;
        this.rootResource = data.rootResource;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
        this.ref = data.ref;
        this.reserveFor = data.reserveFor;
        this.stateName = data.stateName;
        this.type = data.type;
    }	

    @Override
    public McsLayoutContent clone() {
    	return new McsLayoutContent(this);
    }

    @Override
    public String toString() {
        return this.resourceBo;
    }
}
