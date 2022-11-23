package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class BomComponent {

  private String handle;

  private String bomBo;

  private String componentGbo;

  private BigDecimal sequence;

  private String enabled;

  private Date validStart;

  private Date validEnd;

  private String useItemDefaults;

  private String preAssembled;

  private String assyDataTypeBo;

  private BigDecimal qty;

  private String testPart;

  private String bomTemplate;

  private String disassembleOperationBo;

  private String createTrackableSfc;

  private BigDecimal maximumUsage;

  private BigDecimal maximumNc;

  private String assembleAsReq;

  private String autoConsumeKit;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String bomComponentType;

  private BigDecimal parentSequence;

  private BigDecimal erpSequence;

  private String orderItemNumber;

  private String erpChangeNumber;


  public BomComponent() {
  }

  public BomComponent(BomComponent data) {
    this.handle = data.handle;
    this.bomBo = data.bomBo;
    this.componentGbo = data.componentGbo;
    this.sequence = data.sequence;
    this.enabled = data.enabled;
    this.validStart = data.validStart;
    this.validEnd = data.validEnd;
    this.useItemDefaults = data.useItemDefaults;
    this.preAssembled = data.preAssembled;
    this.assyDataTypeBo = data.assyDataTypeBo;
    this.qty = data.qty;
    this.testPart = data.testPart;
    this.bomTemplate = data.bomTemplate;
    this.disassembleOperationBo = data.disassembleOperationBo;
    this.createTrackableSfc = data.createTrackableSfc;
    this.maximumUsage = data.maximumUsage;
    this.maximumNc = data.maximumNc;
    this.assembleAsReq = data.assembleAsReq;
    this.autoConsumeKit = data.autoConsumeKit;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.bomComponentType = data.bomComponentType;
    this.parentSequence = data.parentSequence;
    this.erpSequence = data.erpSequence;
    this.orderItemNumber = data.orderItemNumber;
    this.erpChangeNumber = data.erpChangeNumber;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getBomBo() {
    return bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getComponentGbo() {
    return componentGbo;
  }

  public void setComponentGbo(String componentGbo) {
    this.componentGbo = componentGbo;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public Date getValidStart() {
    return validStart;
  }

  public void setValidStart(Date validStart) {
    this.validStart = validStart;
  }

  public Date getValidEnd() {
    return validEnd;
  }

  public void setValidEnd(Date validEnd) {
    this.validEnd = validEnd;
  }

  public String getUseItemDefaults() {
    return useItemDefaults;
  }

  public void setUseItemDefaults(String useItemDefaults) {
    this.useItemDefaults = useItemDefaults;
  }

  public String getPreAssembled() {
    return preAssembled;
  }

  public void setPreAssembled(String preAssembled) {
    this.preAssembled = preAssembled;
  }

  public String getAssyDataTypeBo() {
    return assyDataTypeBo;
  }

  public void setAssyDataTypeBo(String assyDataTypeBo) {
    this.assyDataTypeBo = assyDataTypeBo;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getTestPart() {
    return testPart;
  }

  public void setTestPart(String testPart) {
    this.testPart = testPart;
  }

  public String getBomTemplate() {
    return bomTemplate;
  }

  public void setBomTemplate(String bomTemplate) {
    this.bomTemplate = bomTemplate;
  }

  public String getDisassembleOperationBo() {
    return disassembleOperationBo;
  }

  public void setDisassembleOperationBo(String disassembleOperationBo) {
    this.disassembleOperationBo = disassembleOperationBo;
  }

  public String getCreateTrackableSfc() {
    return createTrackableSfc;
  }

  public void setCreateTrackableSfc(String createTrackableSfc) {
    this.createTrackableSfc = createTrackableSfc;
  }

  public BigDecimal getMaximumUsage() {
    return maximumUsage;
  }

  public void setMaximumUsage(BigDecimal maximumUsage) {
    this.maximumUsage = maximumUsage;
  }

  public BigDecimal getMaximumNc() {
    return maximumNc;
  }

  public void setMaximumNc(BigDecimal maximumNc) {
    this.maximumNc = maximumNc;
  }

  public String getAssembleAsReq() {
    return assembleAsReq;
  }

  public void setAssembleAsReq(String assembleAsReq) {
    this.assembleAsReq = assembleAsReq;
  }

  public String getAutoConsumeKit() {
    return autoConsumeKit;
  }

  public void setAutoConsumeKit(String autoConsumeKit) {
    this.autoConsumeKit = autoConsumeKit;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getBomComponentType() {
    return bomComponentType;
  }

  public void setBomComponentType(String bomComponentType) {
    this.bomComponentType = bomComponentType;
  }

  public BigDecimal getParentSequence() {
    return parentSequence;
  }

  public void setParentSequence(BigDecimal parentSequence) {
    this.parentSequence = parentSequence;
  }

  public BigDecimal getErpSequence() {
    return erpSequence;
  }

  public void setErpSequence(BigDecimal erpSequence) {
    this.erpSequence = erpSequence;
  }

  public String getOrderItemNumber() {
    return orderItemNumber;
  }

  public void setOrderItemNumber(String orderItemNumber) {
    this.orderItemNumber = orderItemNumber;
  }

  public String getErpChangeNumber() {
    return erpChangeNumber;
  }

  public void setErpChangeNumber(String erpChangeNumber) {
    this.erpChangeNumber = erpChangeNumber;
  }

  @Override
  public BomComponent clone() {
    return new BomComponent(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
