package ame.psb.db;

public class PkgHoldDetail {

  private String handle;

  private String holdLogBo;

  private String holdContextGBo;

  private String sfcBo;

  private String originalStatus;

  private String holdStatus;

  private String released;

  private String releasedDateTime;

  private String releasedByBo;

  private String releaseComments;

  private String reasonCodeBo;


  public PkgHoldDetail() {
  }

  public PkgHoldDetail(PkgHoldDetail data) {
    this.handle = data.handle;
    this.holdLogBo = data.holdLogBo;
    this.holdContextGBo = data.holdContextGBo;
    this.sfcBo = data.sfcBo;
    this.originalStatus = data.originalStatus;
    this.holdStatus = data.holdStatus;
    this.released = data.released;
    this.releasedDateTime = data.releasedDateTime;
    this.releasedByBo = data.releasedByBo;
    this.releaseComments = data.releaseComments;
    this.reasonCodeBo = data.reasonCodeBo;
  }

  @Override
  public PkgHoldDetail clone() {
    return new PkgHoldDetail(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getHoldLogBo() {
    return holdLogBo;
  }

  public void setHoldLogBo(String holdLogBo) {
    this.holdLogBo = holdLogBo;
  }

  public String getHoldContextGBo() {
    return holdContextGBo;
  }

  public void setHoldContextGBo(String holdContextGBo) {
    this.holdContextGBo = holdContextGBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOriginalStatus() {
    return originalStatus;
  }

  public void setOriginalStatus(String originalStatus) {
    this.originalStatus = originalStatus;
  }

  public String getHoldStatus() {
    return holdStatus;
  }

  public void setHoldStatus(String holdStatus) {
    this.holdStatus = holdStatus;
  }

  public String getReleased() {
    return released;
  }

  public void setReleased(String released) {
    this.released = released;
  }

  public String getReleasedDateTime() {
    return releasedDateTime;
  }

  public void setReleasedDateTime(String releasedDateTime) {
    this.releasedDateTime = releasedDateTime;
  }

  public String getReleasedByBo() {
    return releasedByBo;
  }

  public void setReleasedByBo(String releasedByBo) {
    this.releasedByBo = releasedByBo;
  }

  public String getReleaseComments() {
    return releaseComments;
  }

  public void setReleaseComments(String releaseComments) {
    this.releaseComments = releaseComments;
  }

  public String getReasonCodeBo() {
    return reasonCodeBo;
  }

  public void setReasonCodeBo(String reasonCodeBo) {
    this.reasonCodeBo = reasonCodeBo;
  }
}
