package ame.psb.db;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ZdPmsChecklistParameter {

  private String handle;

  private String checklist;

  private int seq;

  private String parameterName;

  private String parameterType;

  private String parameterRange;

  private String defaultValue;

  private String parameterUnit;

  private boolean valueRequired;

  private boolean fileRequired;

  private boolean scanBarcodeOnly;

  private String customConfig;

  private String controlTopLimit;

  private String controlLowerLimit;

  private String warnTopLimit;

  private String warnLowerLimit;

  private String guideFile;


  public ZdPmsChecklistParameter() {
  }

  public ZdPmsChecklistParameter(ZdPmsChecklistParameter data) {
    this.handle = data.handle;
    this.checklist = data.checklist;
    this.seq = data.seq;
    this.parameterName = data.parameterName;
    this.parameterType = data.parameterType;
    this.parameterRange = data.parameterRange;
    this.defaultValue = data.defaultValue;
    this.parameterUnit = data.parameterUnit;
    this.valueRequired = data.valueRequired;
    this.fileRequired = data.fileRequired;
    this.scanBarcodeOnly = data.scanBarcodeOnly;
    this.customConfig = data.customConfig;
    this.controlTopLimit = data.controlTopLimit;
    this.controlLowerLimit = data.controlLowerLimit;
    this.warnTopLimit = data.warnTopLimit;
    this.warnLowerLimit = data.warnLowerLimit;
    this.guideFile = data.guideFile;
  }

  public void checkSpec() throws Exception {
    if ("Selector".equals(this.parameterType)) {
      List<String> spec = Arrays.asList(this.controlTopLimit.split(","));
      List<String> range = Arrays.asList(this.parameterRange.split(","));
      if (range.containsAll(spec) && !spec.isEmpty()) {
        return;
      } else {
        throw new Exception("第" + this.seq + "行: 请检查范围设定!");
      }
    }
    BigDecimal top = null;
    BigDecimal lower = null;
    if (!Strings.isNullOrEmpty(this.controlTopLimit)) {
      try {
        top = new BigDecimal(this.controlTopLimit);
      } catch (NumberFormatException ex) {
        throw new Exception("第" + this.seq + "行: 上限不是数字!");
      }
    }

    if (!Strings.isNullOrEmpty(this.controlLowerLimit)) {
      try {
        lower = new BigDecimal(this.controlLowerLimit);
      } catch (NumberFormatException ex) {
        throw new Exception("第" + this.seq + "行: 下限不是数字!");
      }
    }
    if (top != null && lower != null) {
      if (top.compareTo(lower) <= 0) {
        throw new Exception("第" + this.seq + "行: 上限小于下限!");
      }
    }
  }

  @Override
  public ZdPmsChecklistParameter clone() {
    return new ZdPmsChecklistParameter(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getChecklist() {
    return this.checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public int getSeq() {
    return this.seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getParameterName() {
    return this.parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public String getParameterType() {
    return this.parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }

  public String getParameterRange() {
    return this.parameterRange;
  }

  public void setParameterRange(String parameterRange) {
    this.parameterRange = parameterRange;
  }

  public String getDefaultValue() {
    return this.defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public String getParameterUnit() {
    return this.parameterUnit;
  }

  public void setParameterUnit(String parameterUnit) {
    this.parameterUnit = parameterUnit;
  }

  public boolean isValueRequired() {
    return this.valueRequired;
  }

  public void setValueRequired(boolean valueRequired) {
    this.valueRequired = valueRequired;
  }

  public boolean isFileRequired() {
    return this.fileRequired;
  }

  public void setFileRequired(boolean fileRequired) {
    this.fileRequired = fileRequired;
  }

  public boolean isScanBarcodeOnly() {
    return this.scanBarcodeOnly;
  }

  public void setScanBarcodeOnly(boolean scanBarcodeOnly) {
    this.scanBarcodeOnly = scanBarcodeOnly;
  }

  public String getCustomConfig() {
    return this.customConfig;
  }

  public void setCustomConfig(String customConfig) {
    this.customConfig = customConfig;
  }

  public String getControlTopLimit() {
    return this.controlTopLimit;
  }

  public void setControlTopLimit(String controlTopLimit) {
    this.controlTopLimit = controlTopLimit;
  }

  public String getControlLowerLimit() {
    return this.controlLowerLimit;
  }

  public void setControlLowerLimit(String controlLowerLimit) {
    this.controlLowerLimit = controlLowerLimit;
  }

  public String getWarnTopLimit() {
    return this.warnTopLimit;
  }

  public void setWarnTopLimit(String warnTopLimit) {
    this.warnTopLimit = warnTopLimit;
  }

  public String getWarnLowerLimit() {
    return this.warnLowerLimit;
  }

  public void setWarnLowerLimit(String warnLowerLimit) {
    this.warnLowerLimit = warnLowerLimit;
  }

  public String getGuideFile() {
    return this.guideFile;
  }

  public void setGuideFile(String guideFile) {
    this.guideFile = guideFile;
  }
}
