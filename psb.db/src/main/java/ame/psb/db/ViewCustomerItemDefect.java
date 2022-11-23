package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewCustomerItemDefect extends CustomerItemDefect {

  private String ncCode;

  private String description;

  public String getNcCode() {
    return this.ncCode;
  }

  public void setNcCode(String ncCode) {
    this.ncCode = ncCode;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return super.toString() + ", " + this.description;
  }

}
