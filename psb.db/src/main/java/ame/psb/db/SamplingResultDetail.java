package ame.psb.db;

import java.util.UUID;

public class SamplingResultDetail {

  private String id;

  private String samplingResultBo;

  private String customerItemBo;

  private Integer position;

  private String status;

  public SamplingResultDetail() {
    this.id = UUID.randomUUID().toString();
  }

  public SamplingResultDetail(SamplingResultDetail data) {
    this.id = data.id;
    this.samplingResultBo = data.samplingResultBo;
    this.customerItemBo = data.customerItemBo;
    this.position = data.position;
    this.status = data.status;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSamplingResultBo() {
    return this.samplingResultBo;
  }

  public void setSamplingResultBo(String samplingResultBo) {
    this.samplingResultBo = samplingResultBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public Integer getPosition() {
    return this.position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public SamplingResultDetail clone() {
    return new SamplingResultDetail(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}