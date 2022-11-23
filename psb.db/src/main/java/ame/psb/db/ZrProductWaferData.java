package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ZrProductWaferData {

    private String uuid;

    private String resourceName;

    private String wafetName;

    private String qty;

    private String state;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public ZrProductWaferData() {
    }	

    public ZrProductWaferData(ZrProductWaferData data) {
        this.uuid = data.uuid;
        this.resourceName = data.resourceName;
        this.wafetName = data.wafetName;
        this.qty = data.qty;
        this.state = data.state;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZrProductWaferData clone() {
    	return new ZrProductWaferData(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
