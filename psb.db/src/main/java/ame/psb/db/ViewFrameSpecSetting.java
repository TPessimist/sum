package ame.psb.db;

public class ViewFrameSpecSetting extends FrameSpecSetting {

  private String itemDescription;


  public ViewFrameSpecSetting() {
  }

  public ViewFrameSpecSetting(ViewFrameSpecSetting data) {
    super(data);
    this.itemDescription = data.itemDescription;
  }

  @Override
  public ViewFrameSpecSetting clone() {
    return new ViewFrameSpecSetting(this);
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }
}