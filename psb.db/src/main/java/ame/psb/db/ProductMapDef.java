package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class ProductMapDef {

  private String id;

  private String deviceBo;

  private String itemBo;

  private String incomingMapExists;

  private Integer incomingMapCount;

  private String incomingMapRuleBo;

  private String goldenMapRuleBo;

  private String cpMapRuleBo;

  private String outGoingMapRuleBo;

  private String incomingDefectFilter;

  private String alignmentFilter;

  private String goldenMapRuleTmpl;

  private String cpMapRuleTmpl;

  private String outGoingMapRuleTmpl;

  private String goldenMapFileName;

  private String outGoingMapFileName;

  private String updatedUser;

  private Date updatedTime;

  private String status;

  public ProductMapDef() {
    this.id = UUID.randomUUID().toString();
  }

  public ProductMapDef(ProductMapDef data) {
    this.id = data.id;
    this.deviceBo = data.deviceBo;
    this.itemBo = data.itemBo;
    this.incomingMapExists = data.incomingMapExists;
    this.incomingMapCount = data.incomingMapCount;
    this.incomingMapRuleBo = data.incomingMapRuleBo;
    this.goldenMapRuleBo = data.goldenMapRuleBo;
    this.cpMapRuleBo = data.cpMapRuleBo;
    this.outGoingMapRuleBo = data.outGoingMapRuleBo;
    this.incomingDefectFilter = data.incomingDefectFilter;
    this.alignmentFilter = data.alignmentFilter;
    this.goldenMapRuleTmpl = data.goldenMapRuleTmpl;
    this.cpMapRuleTmpl = data.cpMapRuleTmpl;
    this.outGoingMapRuleTmpl = data.outGoingMapRuleTmpl;
    this.goldenMapFileName = data.goldenMapFileName;
    this.outGoingMapFileName = data.outGoingMapFileName;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.status = data.status;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDeviceBo() {
    return this.deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getIncomingMapExists() {
    return this.incomingMapExists;
  }

  public void setIncomingMapExists(String incomingMapExists) {
    this.incomingMapExists = incomingMapExists;
  }

  public Integer getIncomingMapCount() {
    return this.incomingMapCount;
  }

  public void setIncomingMapCount(Integer incomingMapCount) {
    this.incomingMapCount = incomingMapCount;
  }

  public String getIncomingMapRuleBo() {
    return this.incomingMapRuleBo;
  }

  public void setIncomingMapRuleBo(String incomingMapRuleBo) {
    this.incomingMapRuleBo = incomingMapRuleBo;
  }

  public String getGoldenMapRuleBo() {
    return this.goldenMapRuleBo;
  }

  public void setGoldenMapRuleBo(String goldenMapRuleBo) {
    this.goldenMapRuleBo = goldenMapRuleBo;
  }

  public String getCpMapRuleBo() {
    return this.cpMapRuleBo;
  }

  public void setCpMapRuleBo(String cpMapRuleBo) {
    this.cpMapRuleBo = cpMapRuleBo;
  }

  public String getOutGoingMapRuleBo() {
    return this.outGoingMapRuleBo;
  }

  public void setOutGoingMapRuleBo(String outGoingMapRuleBo) {
    this.outGoingMapRuleBo = outGoingMapRuleBo;
  }

  public String getIncomingDefectFilter() {
    return this.incomingDefectFilter;
  }

  public void setIncomingDefectFilter(String incomingDefectFilter) {
    this.incomingDefectFilter = incomingDefectFilter;
  }

  public String getAlignmentFilter() {
    return this.alignmentFilter;
  }

  public void setAlignmentFilter(String alignmentFilter) {
    this.alignmentFilter = alignmentFilter;
  }

  public String getGoldenMapRuleTmpl() {
    return this.goldenMapRuleTmpl;
  }

  public void setGoldenMapRuleTmpl(String goldenMapRuleTmpl) {
    this.goldenMapRuleTmpl = goldenMapRuleTmpl;
  }

  public String getCpMapRuleTmpl() {
    return this.cpMapRuleTmpl;
  }

  public void setCpMapRuleTmpl(String cpMapRuleTmpl) {
    this.cpMapRuleTmpl = cpMapRuleTmpl;
  }

  public String getOutGoingMapRuleTmpl() {
    return this.outGoingMapRuleTmpl;
  }

  public void setOutGoingMapRuleTmpl(String outGoingMapRuleTmpl) {
    this.outGoingMapRuleTmpl = outGoingMapRuleTmpl;
  }

  public String getGoldenMapFileName() {
    return this.goldenMapFileName;
  }

  public void setGoldenMapFileName(String goldenMapFileName) {
    this.goldenMapFileName = goldenMapFileName;
  }

  public String getOutGoingMapFileName() {
    return this.outGoingMapFileName;
  }

  public void setOutGoingMapFileName(String outGoingMapFileName) {
    this.outGoingMapFileName = outGoingMapFileName;
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

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public ProductMapDef clone() {
    return new ProductMapDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
