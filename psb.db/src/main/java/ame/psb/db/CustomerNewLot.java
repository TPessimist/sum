package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CustomerNewLot {

  private String id;

  private String shopOrderBo;

  private String customerItemsetBo;

  private String operationBo;

  private BigDecimal dieQty;

  private String newLot;

  private String state;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public CustomerNewLot() {
  }

  public CustomerNewLot(CustomerNewLot data) {
    this.id = data.id;
    this.shopOrderBo = data.shopOrderBo;
    this.customerItemsetBo = data.customerItemsetBo;
    this.operationBo = data.operationBo;
    this.dieQty = data.dieQty;
    this.newLot = data.newLot;
    this.state = data.state;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public CustomerNewLot clone() {
    return new CustomerNewLot(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
