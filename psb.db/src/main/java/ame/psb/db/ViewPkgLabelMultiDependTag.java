package ame.psb.db;

public class ViewPkgLabelMultiDependTag {

  private String labelBo;

  private String tagBo;

  private String valuePattern;

  private String valueScript;

  private String description;

  private String valueType;

  private String tagType;


  public ViewPkgLabelMultiDependTag() {
  }

  public ViewPkgLabelMultiDependTag(ViewPkgLabelMultiDependTag data) {
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
    this.valuePattern = data.valuePattern;
    this.valueScript = data.valueScript;
    this.description = data.description;
    this.valueType = data.valueType;
    this.tagType = data.tagType;
  }

  public String getLabelBo() {
    return labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  public String getTagBo() {
    return tagBo;
  }

  public void setTagBo(String tagBo) {
    this.tagBo = tagBo;
  }

  public String getValuePattern() {
    return valuePattern;
  }

  public void setValuePattern(String valuePattern) {
    this.valuePattern = valuePattern;
  }

  public String getValueScript() {
    return valueScript;
  }

  public void setValueScript(String valueScript) {
    this.valueScript = valueScript;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public String getTagType() {
    return tagType;
  }

  public void setTagType(String tagType) {
    this.tagType = tagType;
  }

  @Override
  public ViewPkgLabelMultiDependTag clone() {
    return new ViewPkgLabelMultiDependTag(this);
  }

  @Override
  public String toString() {
    return this.labelBo;
  }
}
