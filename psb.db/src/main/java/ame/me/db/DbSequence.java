package ame.me.db;

import java.math.BigDecimal;

public class DbSequence {

  private String handle;

  private String site;

  private String sequenceName;

  private BigDecimal value;


  public DbSequence() {
  }

  public DbSequence(DbSequence data) {
    this.handle = data.handle;
    this.site = data.site;
    this.sequenceName = data.sequenceName;
    this.value = data.value;
  }

  @Override
  public DbSequence clone() {
    return new DbSequence(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getSequenceName() {
    return sequenceName;
  }

  public void setSequenceName(String sequenceName) {
    this.sequenceName = sequenceName;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }
}
