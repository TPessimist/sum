package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PkgReelContainer {

  private String containerBo;

  private String reelSeq;

  private String type;

  private String memo;

  private String updatedUser;

  private Date updatedTime;

  private BigDecimal seq;


  public PkgReelContainer() {
  }

  public PkgReelContainer(PkgReelContainer data) {
    this.containerBo = data.containerBo;
    this.reelSeq = data.reelSeq;
    this.type = data.type;
    this.memo = data.memo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.seq = data.seq;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getReelSeq() {
    return reelSeq;
  }

  public void setReelSeq(String reelSeq) {
    this.reelSeq = reelSeq;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
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

  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
    this.seq = seq;
  }

  @Override
  public PkgReelContainer clone() {
    return new PkgReelContainer(this);
  }

  @Override
  public String toString() {
    return this.containerBo;
  }
}
