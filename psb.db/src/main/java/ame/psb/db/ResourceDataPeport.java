package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ResourceDataPeport {

    private String uuid;

    private String resourceBo;

    private String reportType;

    private String reportName;

    private String reportValue;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public ResourceDataPeport() {
    }	

    public ResourceDataPeport(ResourceDataPeport data) {
        this.uuid = data.uuid;
        this.resourceBo = data.resourceBo;
        this.reportType = data.reportType;
        this.reportName = data.reportName;
        this.reportValue = data.reportValue;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ResourceDataPeport clone() {
    	return new ResourceDataPeport(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
