package ame.psb.db;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.util.Arrays;

public class RunPmsJobParameter {

  private String handle;

  private String jobBo;

  private int seq;

  private String result;

  private String resultFile;

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

  public RunPmsJobParameter() {
  }

  public RunPmsJobParameter(RunPmsJobParameter data) {
    this.handle = data.handle;
    this.jobBo = data.jobBo;
    this.seq = data.seq;
    this.result = data.result;
    this.resultFile = data.resultFile;
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

  public boolean isEnough() {
    if (this.isValueRequired() && Strings.isNullOrEmpty(this.result)) {
      return false;
    }
    if (this.isFileRequired() && Strings.isNullOrEmpty(this.resultFile)) {
      return false;
    }

    return true;
  }

  public void checkSpec() throws Exception {
    if ("Selector".equals(this.parameterType) && !Strings.isNullOrEmpty(this.controlTopLimit)) {
      if (!Arrays.asList(this.controlTopLimit.split(",")).contains(this.result)) {
        throw new Exception("参数值'" + this.result + "' 不在可选择范围内[" + this.controlTopLimit + "]");
      }

    }
    if (!"Number".equals(this.parameterType)) {
      return;
    }
    if (Strings.isNullOrEmpty(this.result)) {
      return;
    }
    BigDecimal r = null;
    try {
      r = new BigDecimal(this.result);
    } catch (NumberFormatException ex) {
      throw new Exception(this.result + "不符合数字格式!!!");
    }
    if (!Strings.isNullOrEmpty(this.controlTopLimit)) {
      BigDecimal top = new BigDecimal(this.controlTopLimit);
      if (r.compareTo(top) > 0) {
        throw new Exception(this.result + "超出上限" + this.controlTopLimit);
      }
    }
    if (!Strings.isNullOrEmpty(this.controlLowerLimit)) {
      BigDecimal lower = new BigDecimal(this.controlLowerLimit);
      if (r.compareTo(lower) < 0) {
        throw new Exception(this.result + "超出下限" + this.controlLowerLimit);
      }
    }


  }

  @Override
  public RunPmsJobParameter clone() {
    return new RunPmsJobParameter(this);
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

  public String getJobBo() {
    return this.jobBo;
  }

  public void setJobBo(String jobBo) {
    this.jobBo = jobBo;
  }

  public int getSeq() {
    return this.seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getResult() {
    return this.result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getResultFile() {
    return this.resultFile;
  }

  public void setResultFile(String resultFile) {
    this.resultFile = resultFile;
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
