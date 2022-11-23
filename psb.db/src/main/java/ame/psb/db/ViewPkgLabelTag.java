package ame.psb.db;

public class ViewPkgLabelTag extends PkgLabelTag {

  private String valuePattern;

  private String valueScript;

  private String description;

  private String valueType;

  private String tagType;

  public String getValuePattern() {
    return this.valuePattern;
  }

  public void setValuePattern(String valuePattern) {
    this.valuePattern = valuePattern;
  }

  public String getValueScript() {
    return this.valueScript;
  }

  public void setValueScript(String valueScript) {
    this.valueScript = valueScript;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValueType() {
    return this.valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public String getTagType() {
    return this.tagType;
  }

  public void setTagType(String tagType) {
    this.tagType = tagType;
  }
}
