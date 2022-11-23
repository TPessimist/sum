package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ResourceLoad {

  private String resourceBo;

  private BigDecimal wipLoad;

  private BigDecimal mcsLoad;

  private BigDecimal mcsBayLoad;

  private String loadDetail;

  private BigDecimal wipLoadUcl;

  private BigDecimal wipLoadLcl;

  private BigDecimal mcsLoadUcl;

  private BigDecimal mcsLoadLcl;

  private BigDecimal mcsBayLoadUcl;

  private BigDecimal mcsBayLoadLcl;

  private String updatedUser;

  private Date updatedTime;


  public ResourceLoad() {
  }

  public ResourceLoad(ResourceLoad data) {
    this.resourceBo = data.resourceBo;
    this.wipLoad = data.wipLoad;
    this.mcsLoad = data.mcsLoad;
    this.mcsBayLoad = data.mcsBayLoad;
    this.loadDetail = data.loadDetail;
    this.wipLoadUcl = data.wipLoadUcl;
    this.wipLoadLcl = data.wipLoadLcl;
    this.mcsLoadUcl = data.mcsLoadUcl;
    this.mcsLoadLcl = data.mcsLoadLcl;
    this.mcsBayLoadUcl = data.mcsBayLoadUcl;
    this.mcsBayLoadLcl = data.mcsBayLoadLcl;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ResourceLoad clone() {
    return new ResourceLoad(this);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public BigDecimal getWipLoad() {
    return this.wipLoad;
  }

  public void setWipLoad(BigDecimal wipLoad) {
    this.wipLoad = wipLoad;
  }

  public BigDecimal getMcsLoad() {
    return this.mcsLoad;
  }

  public void setMcsLoad(BigDecimal mcsLoad) {
    this.mcsLoad = mcsLoad;
  }

  public BigDecimal getMcsBayLoad() {
    return this.mcsBayLoad;
  }

  public void setMcsBayLoad(BigDecimal mcsBayLoad) {
    this.mcsBayLoad = mcsBayLoad;
  }

  public String getLoadDetail() {
    return this.loadDetail;
  }

  public void setLoadDetail(String loadDetail) {
    this.loadDetail = loadDetail;
  }

  public BigDecimal getWipLoadUcl() {
    return this.wipLoadUcl;
  }

  public void setWipLoadUcl(BigDecimal wipLoadUcl) {
    this.wipLoadUcl = wipLoadUcl;
  }

  public BigDecimal getWipLoadLcl() {
    return this.wipLoadLcl;
  }

  public void setWipLoadLcl(BigDecimal wipLoadLcl) {
    this.wipLoadLcl = wipLoadLcl;
  }

  public BigDecimal getMcsLoadUcl() {
    return this.mcsLoadUcl;
  }

  public void setMcsLoadUcl(BigDecimal mcsLoadUcl) {
    this.mcsLoadUcl = mcsLoadUcl;
  }

  public BigDecimal getMcsLoadLcl() {
    return this.mcsLoadLcl;
  }

  public void setMcsLoadLcl(BigDecimal mcsLoadLcl) {
    this.mcsLoadLcl = mcsLoadLcl;
  }

  public BigDecimal getMcsBayLoadUcl() {
    return this.mcsBayLoadUcl;
  }

  public void setMcsBayLoadUcl(BigDecimal mcsBayLoadUcl) {
    this.mcsBayLoadUcl = mcsBayLoadUcl;
  }

  public BigDecimal getMcsBayLoadLcl() {
    return this.mcsBayLoadLcl;
  }

  public void setMcsBayLoadLcl(BigDecimal mcsBayLoadLcl) {
    this.mcsBayLoadLcl = mcsBayLoadLcl;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
