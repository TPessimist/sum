package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class RmsMatrixRecipe {

  private String id;

  private String recipeName;

  private String matrixBo;

  private int priority;

  private String updatedUser;

  private Date updatedTime;

  public RmsMatrixRecipe() {
    this.id = UUID.randomUUID().toString();
    this.priority = 1;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getMatrixBo() {
    return this.matrixBo;
  }

  public void setMatrixBo(String matrixBo) {
    this.matrixBo = matrixBo;
  }

  public int getPriority() {
    return this.priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
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
    return this.recipeName;
  }

}
