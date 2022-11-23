package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtCreateContainerInfo {

  private String sfc;

  private String reelNumber;

  private String uniqueId;

  private String rootSfc;

  private String containerBo;

  private String content;

  private String updateUser;

  private Date updateTime;

  private String reserve1;

  private String reserve2;


  public FtCreateContainerInfo() {
  }

  public FtCreateContainerInfo(FtCreateContainerInfo data) {
    this.sfc = data.sfc;
    this.reelNumber = data.reelNumber;
    this.uniqueId = data.uniqueId;
    this.rootSfc = data.rootSfc;
    this.containerBo = data.containerBo;
    this.content = data.content;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
  }

  @Override
  public FtCreateContainerInfo clone() {
    return new FtCreateContainerInfo(this);
  }

  @Override
  public String toString() {
    return this.sfc + ", " + this.reelNumber;
  }
}
