package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class RmsMatrix {

  private String id;

  private String matrixName;

  private String updatedUser;

  private Date updatedTime;

  public RmsMatrix() {
  }

  public RmsMatrix(RmsMatrix data) {
    this.id = data.id;
    this.matrixName = data.matrixName;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMatrixName() {
    return this.matrixName;
  }

  public void setMatrixName(String matrixName) {
    this.matrixName = matrixName;
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
    return this.matrixName + "@" + this.id;
  }

}
