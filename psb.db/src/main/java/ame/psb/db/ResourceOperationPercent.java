package ame.psb.db;

import java.util.Objects;

public class ResourceOperationPercent {

  private String resourceId;

  private String operation;

  private String calcHour;

  private String percent;

  private String comment;


  public ResourceOperationPercent() {
  }

  public ResourceOperationPercent(ResourceOperationPercent data) {
    this.resourceId = data.resourceId;
    this.operation = data.operation;
    this.calcHour = data.calcHour;
    this.percent = data.percent;
    this.comment = data.comment;
  }

  @Override
  public ResourceOperationPercent clone() {
    return new ResourceOperationPercent(this);
  }

  @Override
  public String toString() {
    return this.resourceId + ", " + this.operation;
  }

  public String getResourceId() {
    return this.resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getOperation() {
    return this.operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getCalcHour() {
    return this.calcHour;
  }

  public void setCalcHour(String calcHour) {
    this.calcHour = calcHour;
  }

  public String getPercent() {
    return this.percent;
  }

  public void setPercent(String percent) {
    this.percent = percent;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    ResourceOperationPercent that = (ResourceOperationPercent) o;
    return this.resourceId.equals(that.resourceId) &&
        this.operation.equals(that.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.resourceId, this.operation);
  }
}
