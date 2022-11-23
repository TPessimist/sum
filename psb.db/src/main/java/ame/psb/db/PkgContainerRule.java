package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class PkgContainerRule {

  private String itemGroupBo;

  private String operationBo;

  private String itemLevel;

  private String updatedUser;

  private Date updatedTime;

  //新增tag限制
  private String pkgLimitTagBo;

  public PkgContainerRule() {
  }

  public PkgContainerRule(PkgContainerRule data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.itemLevel = data.itemLevel;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    //新增tag限制
    this.pkgLimitTagBo = data.pkgLimitTagBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getItemLevel() {
    return this.itemLevel;
  }

  public void setItemLevel(String itemLevel) {
    this.itemLevel = itemLevel;
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


  public String getPkgLimitTagBo() {
    return pkgLimitTagBo;
  }

  public void setPkgLimitTagBo(String pkgLimitTagBo) {
    this.pkgLimitTagBo = pkgLimitTagBo;
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo + ", Level:" + this.itemLevel
        + this.pkgLimitTagBo;
  }
}
