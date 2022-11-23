package ame.me.db;

public class ItemGroupMember {

  private String handle;

  private String itemGroupBo;

  private String itemBo;


  public ItemGroupMember() {
  }

  public ItemGroupMember(ItemGroupMember data) {
    this.handle = data.handle;
    this.itemGroupBo = data.itemGroupBo;
    this.itemBo = data.itemBo;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  @Override
  public ItemGroupMember clone() {
    return new ItemGroupMember(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}