package ame.htks.db;

public class MesReference {

  private String id;

  private String key1;

  private String key2;

  private String key3;

  private String propertyName;

  private String propertyValue;

  private String valueFlag;

  private String createdBy;

  private String createdTime;

  public MesReference() {
  }

  public MesReference(MesReference data) {
    this.id = data.id;
    this.key1 = data.key1;
    this.key2 = data.key2;
    this.key3 = data.key3;
    this.propertyName = data.propertyName;
    this.propertyValue = data.propertyValue;
    this.valueFlag = data.valueFlag;
    this.createdBy = data.createdBy;
    this.createdTime = data.createdTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKey1() {
    return this.key1;
  }

  public void setKey1(String key1) {
    this.key1 = key1;
  }

  public String getKey2() {
    return this.key2;
  }

  public void setKey2(String key2) {
    this.key2 = key2;
  }

  public String getKey3() {
    return this.key3;
  }

  public void setKey3(String key3) {
    this.key3 = key3;
  }

  public String getPropertyName() {
    return this.propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public String getPropertyValue() {
    return this.propertyValue;
  }

  public void setPropertyValue(String propertyValue) {
    this.propertyValue = propertyValue;
  }

  public String getValueFlag() {
    return this.valueFlag;
  }

  public void setValueFlag(String valueFlag) {
    this.valueFlag = valueFlag;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  @Override
  public MesReference clone() {
    return new MesReference(this);
  }

  @Override
  public String toString() {
    return this.propertyName + ":" + this.propertyValue;
  }
}
