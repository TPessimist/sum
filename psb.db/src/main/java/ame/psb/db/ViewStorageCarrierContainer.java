package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewStorageCarrierContainer {

    private String id;

    private String containerName;

    private String itemGroupBo;

    private String deviceName;

    private String customer;

    private String customerItemsetName;

    private String carrierBo;

    private String carrierName;

    private BigDecimal slotNo;

    private String positionBo;

    private Date bindingTime;

    private Date packingTime;

    private String state;


    public ViewStorageCarrierContainer() {
    }	

    public ViewStorageCarrierContainer(ViewStorageCarrierContainer data) {
        this.id = data.id;
        this.containerName = data.containerName;
        this.itemGroupBo = data.itemGroupBo;
        this.deviceName = data.deviceName;
        this.customer = data.customer;
        this.customerItemsetName = data.customerItemsetName;
        this.carrierBo = data.carrierBo;
        this.carrierName = data.carrierName;
        this.slotNo = data.slotNo;
        this.positionBo = data.positionBo;
        this.bindingTime = data.bindingTime;
        this.packingTime = data.packingTime;
        this.state = data.state;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getItemGroupBo() {
        return itemGroupBo;
    }

    public void setItemGroupBo(String itemGroupBo) {
        this.itemGroupBo = itemGroupBo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerItemsetName() {
        return customerItemsetName;
    }

    public void setCustomerItemsetName(String customerItemsetName) {
        this.customerItemsetName = customerItemsetName;
    }

    public String getCarrierBo() {
        return carrierBo;
    }

    public void setCarrierBo(String carrierBo) {
        this.carrierBo = carrierBo;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public BigDecimal getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(BigDecimal slotNo) {
        this.slotNo = slotNo;
    }

    public String getPositionBo() {
        return positionBo;
    }

    public void setPositionBo(String positionBo) {
        this.positionBo = positionBo;
    }

    public Date getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    public Date getPackingTime() {
        return packingTime;
    }

    public void setPackingTime(Date packingTime) {
        this.packingTime = packingTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public ViewStorageCarrierContainer clone() {
    	return new ViewStorageCarrierContainer(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
