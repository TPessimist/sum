package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewCustomerLot extends CustomerLot implements Comparable<ViewCustomerLot> {

  private String customer;

  private String customerName;

  public String getCustomer() {
    return this.customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  @Override
  public boolean equals(Object o) {
    return o != null && o instanceof CustomerLot && ((CustomerLot) o).getId().equals(getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  @Override
  public int compareTo(ViewCustomerLot lot) {
    return getId().compareTo(lot.getId());
  }

}
