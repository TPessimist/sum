package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class IncomingMapFileLocation {

  private String id;

  private String deviceName;

  private String operationName;

  private String mapFileLotLocation;

  private String origWaferLotLocation;

  private String mapFileIdLocationLeft;

  private String mapFileIdLocationRight;

  private String origWaferIdLocation;

  private String updatedUser;

  private Date updatedTime;


  public IncomingMapFileLocation() {
    this.id = UUID.randomUUID().toString();
  }

  public IncomingMapFileLocation(IncomingMapFileLocation data) {
    this.id = data.id;
    this.deviceName = data.deviceName;
    this.operationName = data.operationName;
    this.mapFileLotLocation = data.mapFileLotLocation;
    this.origWaferLotLocation = data.origWaferLotLocation;
    this.mapFileIdLocationLeft = data.mapFileIdLocationLeft;
    this.mapFileIdLocationRight = data.mapFileIdLocationRight;
    this.origWaferIdLocation = data.origWaferIdLocation;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public IncomingMapFileLocation clone() {
    return new IncomingMapFileLocation(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
