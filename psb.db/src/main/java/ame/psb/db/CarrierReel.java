package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CarrierReel {

  private String carrierBo;

  private BigDecimal slotNo;

  private String reelId;

  private String containerName;

  private String qrCode;

  private String stateName;

  private String reserveField1;

  private String reserveField2;

  private String createdUser;

  private Date createdTime;

  private String updatedUser;

  private Date updatedTime;

  private String bindingState;

  private String dn;

  public CarrierReel() {
    this.bindingState = "N";
  }

  public CarrierReel(BigDecimal slotNo, String carrierBo, String reelId, String containerName,
      String qrCode, String bindingState) {
    this.carrierBo = carrierBo;
    this.slotNo = slotNo;
    this.reelId = reelId;
    this.containerName = containerName;
    this.qrCode = qrCode;
    this.bindingState =bindingState;
    this.bindingState = bindingState;

  }

  public CarrierReel(CarrierReel data) {
    this.carrierBo = data.carrierBo;
    this.slotNo = data.slotNo;
    this.reelId = data.reelId;
    this.stateName = data.stateName;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.dn = data.dn;
  }

  @Override
  public CarrierReel clone() {
    return new CarrierReel(this);
  }

  @Override
  public String toString() {
    return this.carrierBo + ", " + this.slotNo;
  }


}
