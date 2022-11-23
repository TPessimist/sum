package ame.psb.db;

import java.util.Date;

public class E142XmlData {

  private String id;

  private String itemName;

  private String itemNameOrig;

  private String xmlData;

  private Date updatedTime;


  public E142XmlData() {
  }

  public E142XmlData(E142XmlData data) {
    this.id = data.id;
    this.itemName = data.itemName;
    this.itemNameOrig = data.itemNameOrig;
    this.xmlData = data.xmlData;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public E142XmlData clone() {
    return new E142XmlData(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemNameOrig() {
    return itemNameOrig;
  }

  public void setItemNameOrig(String itemNameOrig) {
    this.itemNameOrig = itemNameOrig;
  }

  public String getXmlData() {
    return xmlData;
  }

  public void setXmlData(String xmlData) {
    this.xmlData = xmlData;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }


}
