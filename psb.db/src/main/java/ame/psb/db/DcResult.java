package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class DcResult {

  private String id;

  private Date dcTime;

  private String sfcBo;

  private String resourceBo;

  private String dcopBo;

  private String operationBo;

  private String dcPlanBo;

  private String runSfcBo;

  private String stateName;

  public DcResult() {
    this.id = UUID.randomUUID().toString();
    this.dcTime = new Date();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDcTime() {
    return this.dcTime;
  }

  public void setDcTime(Date dcTime) {
    this.dcTime = dcTime;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getDcopBo() {
    return this.dcopBo;
  }

  public void setDcopBo(String dcopBo) {
    this.dcopBo = dcopBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDcPlanBo() {
    return this.dcPlanBo;
  }

  public void setDcPlanBo(String dcPlanBo) {
    this.dcPlanBo = dcPlanBo;
  }

  public String getRunSfcBo() {
    return this.runSfcBo;
  }

  public void setRunSfcBo(String runSfcBo) {
    this.runSfcBo = runSfcBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public String toString() {
    return this.id + "," + this.sfcBo + "," + this.stateName;
  }
}
