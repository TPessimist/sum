package ame.psb.db;

/**
 * @program: IDEA
 * @description:
 * @author: qingchun
 * @create: 2020-03-31 11:40
 */
public class ViewPmsResourceSetting extends PmsResourceSetting {

  private String description;

  private String remark;

  private String checkType;

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCheckType() {
    return this.checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }
}
