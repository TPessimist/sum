package ame.psb.db;

import java.util.Date;

/**
 * ykq
 */
public class FcOperatinWeight {

  private String uuid;

  private String shopOrderBo;


  private String shopOrder;

  private String operationBo;

  private String erserve1;

  private String erserve2;

  private String updateUser;

  private Date updateTime;

  public FcOperatinWeight() {
  }

  public FcOperatinWeight(FcOperatinWeight data) {
    this.uuid = data.uuid;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrder = data.shopOrder;
    this.operationBo = data.operationBo;
    this.erserve1 = data.erserve1;
    this.erserve2 = data.erserve2;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getErserve1() {
    return erserve1;
  }

  public void setErserve1(String erserve1) {
    this.erserve1 = erserve1;
  }

  public String getErserve2() {
    return erserve2;
  }

  public void setErserve2(String erserve2) {
    this.erserve2 = erserve2;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public FcOperatinWeight clone() {
    return new FcOperatinWeight(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
