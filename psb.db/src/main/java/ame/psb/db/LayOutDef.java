package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class LayOutDef {

    private String stateName;

    private String stateDescribe;

    private String color1;

    private String color2;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public LayOutDef() {
    }	

    public LayOutDef(LayOutDef data) {
        this.stateName = data.stateName;
        this.stateDescribe = data.stateDescribe;
        this.color1 = data.color1;
        this.color2 = data.color2;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public LayOutDef clone() {
    	return new LayOutDef(this);
    }

    @Override
    public String toString() {
        return this.stateName;
    }
}
