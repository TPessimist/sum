package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FCResourceDataReport {

    private String resourceBo;

    private String reportName;

    private String reportValue;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public FCResourceDataReport() {
    }	

    public FCResourceDataReport(FCResourceDataReport data) {
        this.resourceBo = data.resourceBo;
        this.reportName = data.reportName;
        this.reportValue = data.reportValue;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public FCResourceDataReport clone() {
    	return new FCResourceDataReport(this);
    }

    @Override
    public String toString() {
        return this.resourceBo + ", " + this.reportName;
    }
}
