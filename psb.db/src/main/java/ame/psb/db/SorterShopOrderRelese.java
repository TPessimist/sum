package ame.psb.db;

public class SorterShopOrderRelese {

    private String shopOrder;

    private String carrierId;

    private String waferId;

    private String slotId;

    private String content1;

    private String content2;


    public SorterShopOrderRelese() {
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(String shopOrder) {
        this.shopOrder = shopOrder;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getWaferId() {
        return waferId;
    }

    public void setWaferId(String waferId) {
        this.waferId = waferId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public SorterShopOrderRelese(SorterShopOrderRelese data) {
        this.shopOrder = data.shopOrder;
        this.carrierId = data.carrierId;
        this.waferId = data.waferId;
        this.slotId = data.slotId;
        this.content1 = data.content1;
        this.content2 = data.content2;
    }	

    @Override
    public SorterShopOrderRelese clone() {
    	return new SorterShopOrderRelese(this);
    }

    @Override
    public String toString() {
        return this.shopOrder + ", " + this.carrierId + ", " + this.waferId;
    }
}
