package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class PdmTestSummaryProcess {

    private String factoryMatnr;

    private String factoryDevice;

    private String factoryProcess;

    private String custProcess;

    private String testingFrequency;

    private String creater;

    private Date createTime;


    public PdmTestSummaryProcess() {
    }	

    public PdmTestSummaryProcess(PdmTestSummaryProcess data) {
        this.factoryMatnr = data.factoryMatnr;
        this.factoryDevice = data.factoryDevice;
        this.factoryProcess = data.factoryProcess;
        this.custProcess = data.custProcess;
        this.testingFrequency = data.testingFrequency;
        this.creater = data.creater;
        this.createTime = data.createTime;
    }	

    @Override
    public PdmTestSummaryProcess clone() {
    	return new PdmTestSummaryProcess(this);
    }

    @Override
    public String toString() {
        return this.factoryMatnr;
    }
}
