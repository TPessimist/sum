package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class ChartSetUp {

  private String operation;

  private String dcGroup;

  private String dcParameter;

  private String tolerance;

  private String point;

  private String chartId;

  private String tooling1;

  private String tooling2;

  private String updatedUser;

  private Date updatedTime;


  public ChartSetUp() {
  }

  public ChartSetUp(ChartSetUp data) {
    this.operation = data.operation;
    this.dcGroup = data.dcGroup;
    this.dcParameter = data.dcParameter;
    this.tolerance = data.tolerance;
    this.point = data.point;
    this.chartId = data.chartId;
    this.tooling1 = data.tooling1;
    this.tooling2 = data.tooling2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ChartSetUp clone() {
    return new ChartSetUp(this);
  }

  @Override
  public String toString() {
    return this.operation + ", " + this.dcGroup + ", " + this.dcParameter + ", " + this.tolerance
        + ", " + this.point;
  }
}
