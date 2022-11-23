package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class CancelSfc {

    private String itemGroupBo;

    private String itemGroupName;

    private String itemBo;

    private String itemName;

    private String shopOrderBo;

    private String shopOrderName;

    private String state;

    private String modifyUser;

    private Date modifyTime;

    private String createdUser;

    private Date createdTime;


    public CancelSfc() {
    }	

    public CancelSfc(CancelSfc data) {
        this.itemGroupBo = data.itemGroupBo;
        this.itemGroupName = data.itemGroupName;
        this.itemBo = data.itemBo;
        this.itemName = data.itemName;
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.state = data.state;
        this.modifyUser = data.modifyUser;
        this.modifyTime = data.modifyTime;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
    }	

    @Override
    public CancelSfc clone() {
    	return new CancelSfc(this);
    }

    @Override
    public String toString() {
        return this.shopOrderBo;
    }
}
