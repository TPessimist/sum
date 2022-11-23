package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class MapShiftSetUp {

  public String id;

  public String deviceName;

  public String operationName;

  public String alignmentFlag;

  public Integer sequence;

  public Integer xCoordinate;

  public Integer yCoordinate;

  public String symbolStr;

  public String updatedUser;

  public Date updatedDateTime;

  public MapShiftSetUp() {
    this.id = UUID.randomUUID().toString();
  }

  public MapShiftSetUp(MapShiftSetUp data) {
    this.id = data.id;
    this.deviceName = data.deviceName;
    this.operationName = data.operationName;
    this.alignmentFlag = data.alignmentFlag;
    this.sequence = data.sequence;
    this.xCoordinate = data.xCoordinate;
    this.yCoordinate = data.yCoordinate;
    this.symbolStr = data.symbolStr;
    this.updatedUser = data.updatedUser;
    this.updatedDateTime = data.updatedDateTime;
  }

  @Override
  public MapShiftSetUp clone() {
    return new MapShiftSetUp(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
