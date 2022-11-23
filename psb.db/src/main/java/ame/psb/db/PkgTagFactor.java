package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class PkgTagFactor {

  private String tagBo;

  private String tagFactorDefBo;

  private String driverArgs;

  private String script;

  public PkgTagFactor() {
  }

  public PkgTagFactor(PkgTagFactor data) {
    this.tagBo = data.tagBo;
    this.tagFactorDefBo = data.tagFactorDefBo;
    this.driverArgs = data.driverArgs;
    this.script = data.script;
  }

  public String getTagBo() {
    return this.tagBo;
  }

  public void setTagBo(String tagBo) {
    this.tagBo = tagBo;
  }

  public String getTagFactorDefBo() {
    return this.tagFactorDefBo;
  }

  public void setTagFactorDefBo(String tagFactorDefBo) {
    this.tagFactorDefBo = tagFactorDefBo;
  }

  public String getDriverArgs() {
    return this.driverArgs;
  }

  public void setDriverArgs(String driverArgs) {
    this.driverArgs = driverArgs;
  }

  public String getScript() {
    return this.script;
  }

  public void setScript(String script) {
    this.script = script;
  }

  @Override
  public String toString() {
    return this.tagBo + "," + this.tagFactorDefBo;
  }
}
