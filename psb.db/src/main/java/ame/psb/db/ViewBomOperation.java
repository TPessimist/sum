package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewBomOperation {

    private String itemBo;

    private String operationBo;

    private String bomBo;

    private String bomComponentBo;

    private String bomComponentItemBo;

    private String site;

    private String itemDescription;

    private String bomDescription;

    private String item;

    private String itemType;

    private String itemStatusBo;

    private String componentGroupBo;

    private BigDecimal qty;

    public String getItemBo() {
        return itemBo;
    }

    public void setItemBo(String itemBo) {
        this.itemBo = itemBo;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo(String operationBo) {
        this.operationBo = operationBo;
    }

    public String getBomBo() {
        return bomBo;
    }

    public void setBomBo(String bomBo) {
        this.bomBo = bomBo;
    }

    public String getBomComponentBo() {
        return bomComponentBo;
    }

    public void setBomComponentBo(String bomComponentBo) {
        this.bomComponentBo = bomComponentBo;
    }

    public String getBomComponentItemBo() {
        return bomComponentItemBo;
    }

    public void setBomComponentItemBo(String bomComponentItemBo) {
        this.bomComponentItemBo = bomComponentItemBo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getBomDescription() {
        return bomDescription;
    }

    public void setBomDescription(String bomDescription) {
        this.bomDescription = bomDescription;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemStatusBo() {
        return itemStatusBo;
    }

    public void setItemStatusBo(String itemStatusBo) {
        this.itemStatusBo = itemStatusBo;
    }

    public String getComponentGroupBo() {
        return componentGroupBo;
    }

    public void setComponentGroupBo(String componentGroupBo) {
        this.componentGroupBo = componentGroupBo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public ViewBomOperation() {
    }	

    public ViewBomOperation(ViewBomOperation data) {
        this.itemBo = data.itemBo;
        this.operationBo = data.operationBo;
        this.bomBo = data.bomBo;
        this.bomComponentBo = data.bomComponentBo;
        this.bomComponentItemBo = data.bomComponentItemBo;
        this.site = data.site;
        this.itemDescription = data.itemDescription;
        this.bomDescription = data.bomDescription;
        this.item = data.item;
        this.itemType = data.itemType;
        this.itemStatusBo = data.itemStatusBo;
        this.componentGroupBo = data.componentGroupBo;
        this.qty = data.qty;
    }	

    @Override
    public ViewBomOperation clone() {
    	return new ViewBomOperation(this);
    }

    @Override
    public String toString() {
        return this.itemBo;
    }
}
