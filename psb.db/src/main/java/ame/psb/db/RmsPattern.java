package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class RmsPattern {

  private String id;

  private String recipePattern;

  private String updatedUser;

  private Date updatedTime;

  public RmsPattern() {
  }

  public RmsPattern(RmsPattern data) {
    this.id = data.id;
    this.recipePattern = data.recipePattern;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRecipePattern() {
    return this.recipePattern;
  }

  public void setRecipePattern(String recipePattern) {
    this.recipePattern = recipePattern;
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

  @Override
  public String toString() {
    return this.recipePattern + "@" + this.id;
  }

}
