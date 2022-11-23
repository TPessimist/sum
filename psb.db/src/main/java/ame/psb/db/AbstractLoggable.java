package ame.psb.db;

import com.google.gson.Gson;
import java.util.Date;
import java.util.UUID;

public abstract class AbstractLoggable {

  private String batchId;

  public AbstractLoggable() {
    this.batchId = UUID.randomUUID().toString();
  }

  public AbstractLoggable(String batchId) {
    this.batchId = batchId;
  }

  public abstract String getTableName();

  public abstract String getLogUser();

  public abstract Date getLogDateTime();

  public String getBatchId() {
    return this.batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getContent() {
    return new Gson().toJson(this);
  }

}
