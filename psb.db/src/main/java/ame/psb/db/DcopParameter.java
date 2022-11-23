package ame.psb.db;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity
public class DcopParameter {

  private String dcopBo;

  private String dcParameterBo;

  private BigDecimal warnUcl;

  private BigDecimal warnLcl;

  private BigDecimal alarmUcl;

  private BigDecimal alarmLcl;

  private String verify;

  private BigDecimal targetValue;

  private String spcDisplayTemplate;

  private String spcQueryTemplate;

  private String compareDcopBo;

  private String compareDcGroupBo;

  private int sequence;

  private BigDecimal point;

  private String verificationtype;

  public String getVerificationtype() {
    return verificationtype;
  }

  public void setVerificationtype(String verificationtype) {
    this.verificationtype = verificationtype;
  }

  public BigDecimal getPoint() {
    return point;
  }

  public void setPoint(BigDecimal point) {
    this.point = point;
  }

  public String getCompareDcopBo() {
    return compareDcopBo;
  }

  public void setCompareDcopBo(String compareDcopBo) {
    this.compareDcopBo = compareDcopBo;
  }

  public String getCompareDcGroupBo() {
    return compareDcGroupBo;
  }

  public void setCompareDcGroupBo(String compareDcGroupBo) {
    this.compareDcGroupBo = compareDcGroupBo;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public String getDcopBo() {
    return this.dcopBo;
  }

  public void setDcopBo(String dcopBo) {
    this.dcopBo = dcopBo;
  }

  public String getDcParameterBo() {
    return this.dcParameterBo;
  }

  public void setDcParameterBo(String dcParameterBo) {
    this.dcParameterBo = dcParameterBo;
  }

  public BigDecimal getWarnUcl() {
    return this.warnUcl;
  }

  public void setWarnUcl(BigDecimal warnUcl) {
    this.warnUcl = warnUcl;
  }

  public BigDecimal getWarnLcl() {
    return this.warnLcl;
  }

  public void setWarnLcl(BigDecimal warnLcl) {
    this.warnLcl = warnLcl;
  }

  public BigDecimal getAlarmUcl() {
    return this.alarmUcl;
  }

  public void setAlarmUcl(BigDecimal alarmUcl) {
    this.alarmUcl = alarmUcl;
  }

  public BigDecimal getAlarmLcl() {
    return this.alarmLcl;
  }

  public void setAlarmLcl(BigDecimal alarmLcl) {
    this.alarmLcl = alarmLcl;
  }

  public String getVerify() {
    return this.verify;
  }

  public void setVerify(String verify) {
    this.verify = verify;
  }

  public BigDecimal getTargetValue() {
    return this.targetValue;
  }

  public void setTargetValue(BigDecimal targetValue) {
    this.targetValue = targetValue;
  }

  public String getSpcDisplayTemplate() {
    return this.spcDisplayTemplate;
  }

  public void setSpcDisplayTemplate(String spcDisplayTemplate) {
    this.spcDisplayTemplate = spcDisplayTemplate;
  }

  public String getSpcQueryTemplate() {
    return this.spcQueryTemplate;
  }

  public void setSpcQueryTemplate(String spcQueryTemplate) {
    this.spcQueryTemplate = spcQueryTemplate;
  }

  @Override
  public String toString() {
    return this.dcopBo + this.dcParameterBo;
  }
}