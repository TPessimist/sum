package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class IssueRecipe {

    private String id;

    private String customerDevice;

    private String customerLot;

    private String operationBo;

    private String deviceName;

    private String sfcBo;

    private String itemName;

    private String toolNumberBo;

    private String recipeName;

    private String updatedUser;

    private Date updatedTime;

    private String requestId;

    private String active;

    private String boardId;

    private String testModle;


    public IssueRecipe() {
    }	

    public IssueRecipe(IssueRecipe data) {
        this.id = data.id;
        this.customerDevice = data.customerDevice;
        this.customerLot = data.customerLot;
        this.operationBo = data.operationBo;
        this.deviceName = data.deviceName;
        this.sfcBo = data.sfcBo;
        this.itemName = data.itemName;
        this.toolNumberBo = data.toolNumberBo;
        this.recipeName = data.recipeName;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
        this.requestId = data.requestId;
        this.active = data.active;
    }	

    @Override
    public IssueRecipe clone() {
    	return new IssueRecipe(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
