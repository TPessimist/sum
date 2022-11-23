package ame.psb.db;

public class PkgLabelTag {

  private String labelBo;

  private String tagBo;

  public PkgLabelTag() {
  }

  public PkgLabelTag(PkgLabelTag data) {
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
  }

  public String getLabelBo() {
    return this.labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  public String getTagBo() {
    return this.tagBo;
  }

  public void setTagBo(String tagBo) {
    this.tagBo = tagBo;
  }

  @Override
  public String toString() {
    return this.labelBo + "," + this.tagBo;
  }
}
