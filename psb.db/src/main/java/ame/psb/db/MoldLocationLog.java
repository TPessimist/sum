package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class MoldLocationLog {

  private String batchId;

  private String location;

  private String tableName;

  private String content;

  private String logUser;

  private Date logTime;

  private String reserve1;

  private String reserve2;


  public MoldLocationLog() {
  }

  public MoldLocationLog(MoldLocationLog data) {
    this.batchId = data.batchId;
    this.location = data.location;
    this.tableName = data.tableName;
    this.content = data.content;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
  }

  @Override
  public MoldLocationLog clone() {
    return new MoldLocationLog(this);
  }

  @Override
  public String toString() {
    return this.batchId;
  }
}
