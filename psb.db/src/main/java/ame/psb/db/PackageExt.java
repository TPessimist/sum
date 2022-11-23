package ame.psb.db;

import java.util.Date;

public class PackageExt {

  private String packageBo;

  private String packageName;

  private String recipeId;

  private String clamp;

  private String seal;

  private String createUser;

  private Date createTime;

  private String updatedUser;

  private Date updatedTime;

  private String packageRow;

  private String packageCol;


  public PackageExt() {
  }

  public PackageExt(PackageExt data) {
    this.packageBo = data.packageBo;
    this.packageName = data.packageName;
    this.recipeId = data.recipeId;
    this.clamp = data.clamp;
    this.seal = data.seal;
    this.createUser = data.createUser;
    this.createTime = data.createTime;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.packageRow = data.packageRow;
    this.packageCol = data.packageCol;
  }

  @Override
  public PackageExt clone() {
    return new PackageExt(this);
  }

  @Override
  public String toString() {
    return this.packageBo;
  }

  public String getPackageBo() {
    return packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }

  public String getClamp() {
    return clamp;
  }

  public void setClamp(String clamp) {
    this.clamp = clamp;
  }

  public String getSeal() {
    return seal;
  }

  public void setSeal(String seal) {
    this.seal = seal;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }


  public String getPackageRow() {
    return packageRow;
  }

  public void setPackageRow(String packageRow) {
    this.packageRow = packageRow;
  }


  public String getPackageCol() {
    return packageCol;
  }

  public void setPackageCol(String packageCol) {
    this.packageCol = packageCol;
  }
}
