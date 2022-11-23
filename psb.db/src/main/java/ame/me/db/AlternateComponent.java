package ame.me.db;

import java.util.Date;

public class AlternateComponent {

  private String handle;

  private String bomComponentBo;

  private String itemBo;

  private String substitute;

  private String requiredSubstitute;

  private Date validStart;

  private Date validEnd;


  public AlternateComponent() {
  }

  public AlternateComponent(AlternateComponent data) {
    this.handle = data.handle;
    this.bomComponentBo = data.bomComponentBo;
    this.itemBo = data.itemBo;
    this.substitute = data.substitute;
    this.requiredSubstitute = data.requiredSubstitute;
    this.validStart = data.validStart;
    this.validEnd = data.validEnd;
  }

  @Override
  public AlternateComponent clone() {
    return new AlternateComponent(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getBomComponentBo() {
    return bomComponentBo;
  }

  public void setBomComponentBo(String bomComponentBo) {
    this.bomComponentBo = bomComponentBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getSubstitute() {
    return substitute;
  }

  public void setSubstitute(String substitute) {
    this.substitute = substitute;
  }

  public String getRequiredSubstitute() {
    return requiredSubstitute;
  }

  public void setRequiredSubstitute(String requiredSubstitute) {
    this.requiredSubstitute = requiredSubstitute;
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
}
