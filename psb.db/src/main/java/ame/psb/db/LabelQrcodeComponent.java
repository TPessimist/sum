package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class LabelQrcodeComponent {

  private String id;

  private String qrcode;

  private BigDecimal sequence;

  private String componentTag;

  private String reserveField1;

  private String reserveField2;

  private String updatedUser;

  private Date updatedTime;


  public LabelQrcodeComponent() {
  }

  public LabelQrcodeComponent(LabelQrcodeComponent data) {
    this.id = data.id;
    this.qrcode = data.qrcode;
    this.sequence = data.sequence;
    this.componentTag = data.componentTag;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public LabelQrcodeComponent clone() {
    return new LabelQrcodeComponent(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getQrcode() {
    return qrcode;
  }

  public void setQrcode(String qrcode) {
    this.qrcode = qrcode;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getComponentTag() {
    return componentTag;
  }

  public void setComponentTag(String componentTag) {
    this.componentTag = componentTag;
  }

  public String getReserveField1() {
    return reserveField1;
  }

  public void setReserveField1(String reserveField1) {
    this.reserveField1 = reserveField1;
  }

  public String getReserveField2() {
    return reserveField2;
  }

  public void setReserveField2(String reserveField2) {
    this.reserveField2 = reserveField2;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
