package ame.psb.db;

import java.util.Date;

public class ZrTestTimeRecord {

    private String id;

    private String custCode;

    private String customerDevice;

    private String device;

    private String testerType;

    private String operation;

    private String testTimePerWaferHour;

    private String testTimePerWafer;

    private String testTimePerDown;

    private Date createtime;

    private String te;

    private String requestid;


    public ZrTestTimeRecord() {
    }	

    public ZrTestTimeRecord(ZrTestTimeRecord data) {
        this.id = data.id;
        this.custCode = data.custCode;
        this.customerDevice = data.customerDevice;
        this.device = data.device;
        this.testerType = data.testerType;
        this.operation = data.operation;
        this.testTimePerWaferHour = data.testTimePerWaferHour;
        this.testTimePerWafer = data.testTimePerWafer;
        this.testTimePerDown = data.testTimePerDown;
        this.createtime = data.createtime;
        this.te = data.te;
        this.requestid = data.requestid;
    }	
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustomerDevice() {
		return customerDevice;
	}

	public void setCustomerDevice(String customerDevice) {
		this.customerDevice = customerDevice;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getTesterType() {
		return testerType;
	}

	public void setTesterType(String testerType) {
		this.testerType = testerType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTestTimePerWaferHour() {
		return testTimePerWaferHour;
	}

	public void setTestTimePerWaferHour(String testTimePerWaferHour) {
		this.testTimePerWaferHour = testTimePerWaferHour;
	}

	public String getTestTimePerWafer() {
		return testTimePerWafer;
	}

	public void setTestTimePerWafer(String testTimePerWafer) {
		this.testTimePerWafer = testTimePerWafer;
	}

	public String getTestTimePerDown() {
		return testTimePerDown;
	}

	public void setTestTimePerDown(String testTimePerDown) {
		this.testTimePerDown = testTimePerDown;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	@Override
    public ZrTestTimeRecord clone() {
    	return new ZrTestTimeRecord(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
