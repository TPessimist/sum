package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ZrCspWaferDatails {

    private String uuid;

    private String detailsId;

    private String wafetName;

    private String qty;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public ZrCspWaferDatails() {
    }	

    public ZrCspWaferDatails(ZrCspWaferDatails data) {
        this.uuid = data.uuid;
        this.detailsId = data.detailsId;
        this.wafetName = data.wafetName;
        this.qty = data.qty;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZrCspWaferDatails clone() {
    	return new ZrCspWaferDatails(this);
    }

    @Override
    public String toString() {
        return this.uuid + ", " + this.detailsId;
    }
}
