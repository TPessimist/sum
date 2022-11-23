package ame.psb.db;

import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;

@Entity
public class DispatchSfc {

  private String sfcStepBo;

  private String stateName;

  private String dptNo;

  private String lotType;

  private Date inTime;

  private Date outTime;

  private Date inMinTime;

  private Date inMaxTime;

  private Date outMinTime;

  private Date outMaxTime;

  private int hotLevel;

  private String rework;

  private String queueTimeFlag;

  private String holdFlag;

  private int cycleTime;

  private String recipeType;

  private String recipeName;

  private String capability;

  private String assignRecipeName;

  private String assignResources;

  private int trackInCount;

  private int trackOutCount;

  private String assignInstruction;

  private String sfcBo;

  private int cycleTimeTotal;

  private String hotLevelFlag;

  private String hotLevelReason;

  private Date receiveDateTime;

  public DispatchSfc() {
    this.stateName = "WAIT";
    this.dptNo = "B";
    this.lotType = "E";
    this.hotLevel = 3;
    this.rework = "N";
    this.queueTimeFlag = "N";
    this.holdFlag = "Y";
    this.cycleTime = 120;       // second
    this.recipeType = "M";
    this.hotLevelFlag = "Y";
  }

  public DispatchSfc(DispatchSfc data) {
    this.sfcStepBo = data.sfcStepBo;
    this.stateName = data.stateName;
    this.dptNo = data.dptNo;
    this.lotType = data.lotType;
    this.inTime = data.inTime;
    this.outTime = data.outTime;
    this.inMinTime = data.inMinTime;
    this.inMaxTime = data.inMaxTime;
    this.outMinTime = data.outMinTime;
    this.outMaxTime = data.outMaxTime;
    this.hotLevel = data.hotLevel;
    this.rework = data.rework;
    this.queueTimeFlag = data.queueTimeFlag;
    this.holdFlag = data.holdFlag;
    this.cycleTime = data.cycleTime;
    this.recipeType = data.recipeType;
    this.recipeName = data.recipeName;
    this.capability = data.capability;
    this.assignRecipeName = data.assignRecipeName;
    this.assignResources = data.assignResources;
    this.trackInCount = data.trackInCount;
    this.trackOutCount = data.trackOutCount;
    this.assignInstruction = data.assignInstruction;
    this.sfcBo = data.sfcBo;
    this.cycleTimeTotal = data.cycleTimeTotal;
    this.hotLevelFlag = data.hotLevelFlag;
    this.hotLevelReason = data.hotLevelReason;
    this.receiveDateTime = data.receiveDateTime;
  }

  public String getSfcStepBo() {
    return this.sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getDptNo() {
    return this.dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public Date getInTime() {
    return this.inTime;
  }

  public void setInTime(Date inTime) {
    this.inTime = inTime;
  }

  public Date getOutTime() {
    return this.outTime;
  }

  public void setOutTime(Date outTime) {
    this.outTime = outTime;
  }

  /**
   * 取得不得早於進站時間。
   *
   * @return 不得早於進站時間。
   */
  public Date getInMinTime() {
    return this.inMinTime;
  }

  public void setInMinTime(Date inMinTime) {
    this.inMinTime = inMinTime;
  }

  /**
   * 取得不得晚於進站時間。
   *
   * @return 不得晚於進站時間。
   */
  public Date getInMaxTime() {
    return this.inMaxTime;
  }

  public void setInMaxTime(Date inMaxTime) {
    this.inMaxTime = inMaxTime;
  }

  /**
   * 取得不得早於出站時間。
   *
   * @return 不得早於出站時間。
   */
  public Date getOutMinTime() {
    return this.outMinTime;
  }

  public void setOutMinTime(Date outMinTime) {
    this.outMinTime = outMinTime;
  }

  /**
   * 取得不得晚於出站時間。
   *
   * @return 不得晚於出站時間。
   */
  public Date getOutMaxTime() {
    return this.outMaxTime;
  }

  public void setOutMaxTime(Date outMaxTime) {
    this.outMaxTime = outMaxTime;
  }

  public int getHotLevel() {
    return this.hotLevel;
  }

  public void setHotLevel(int hotLevel) {
    this.hotLevel = hotLevel;
  }

  public String getRework() {
    return this.rework;
  }

  public void setRework(String rework) {
    this.rework = rework;
  }

  public String getQueueTimeFlag() {
    return this.queueTimeFlag;
  }

  public void setQueueTimeFlag(String queueTimeFlag) {
    this.queueTimeFlag = queueTimeFlag;
  }

  public String getHoldFlag() {
    return this.holdFlag;
  }

  public void setHoldFlag(String holdFlag) {
    this.holdFlag = holdFlag;
  }

  /**
   * 取得工藝時間，秒。
   *
   * @return 工藝時間。
   */
  public int getCycleTime() {
    return this.cycleTime;
  }

  /**
   * 設定工藝時間，秒。
   *
   * @param cycleTime 工藝時間。
   */
  public void setCycleTime(int cycleTime) {
    this.cycleTime = cycleTime;
  }

  public String getRecipeType() {
    return this.recipeType;
  }

  public void setRecipeType(String recipeType) {
    this.recipeType = recipeType;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getCapability() {
    return this.capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public String getAssignRecipeName() {
    return this.assignRecipeName;
  }

  public void setAssignRecipeName(String assignRecipeName) {
    this.assignRecipeName = assignRecipeName;
  }

  public String getAssignResources() {
    return this.assignResources;
  }

  public void setAssignResources(String assignResources) {
    this.assignResources = assignResources;
  }

  public int getTrackInCount() {
    return this.trackInCount;
  }

  public void setTrackInCount(int trackInCount) {
    this.trackInCount = trackInCount;
  }

  public int getTrackOutCount() {
    return this.trackOutCount;
  }

  public void setTrackOutCount(int trackOutCount) {
    this.trackOutCount = trackOutCount;
  }

  public String getAssignInstruction() {
    return this.assignInstruction;
  }

  public void setAssignInstruction(String assignInstruction) {
    this.assignInstruction = assignInstruction;
  }

  public boolean checkQueueTimeAvaiable() {
    return "Y".equals(this.queueTimeFlag) &&
        (this.inMaxTime != null || this.inMinTime != null || this.outMaxTime != null
            || this.outMinTime != null);
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public int getCycleTimeTotal() {
    return this.cycleTimeTotal;
  }

  public void setCycleTimeTotal(int cycleTimeTotal) {
    this.cycleTimeTotal = cycleTimeTotal;
  }

  public String getHotLevelFlag() {
    return this.hotLevelFlag;
  }

  public void setHotLevelFlag(String hotLevelFlag) {
    this.hotLevelFlag = hotLevelFlag;
  }

  public String getHotLevelReason() {
    return this.hotLevelReason;
  }

  public void setHotLevelReason(String hotLevelReason) {
    this.hotLevelReason = hotLevelReason;
  }

  public Date getReceiveDateTime() {
    return this.receiveDateTime;
  }

  public void setReceiveDateTime(Date receiveDateTime) {
    this.receiveDateTime = receiveDateTime;
  }

  @Override
  public String toString() {
    return String.format("%-106s, hot:%-4s, rework:%s, qtFlag:%s, cycleTime: %5s/%7s",
        this.sfcStepBo,
        this.hotLevel,
        this.rework,
        this.queueTimeFlag,
        this.cycleTime,
        this.cycleTimeTotal);
  }

  /**
   * 檢查LOT是否具備特定工作特性。
   *
   * @param capability 工作特性。
   * @return
   */
  public boolean match(String capability) {

    if (Strings.isNullOrEmpty(capability)) {
      return true;
    }
    if (Strings.isNullOrEmpty(this.capability)) {
      return false;
    }

    List<String> cs = Arrays.asList(this.capability.split(","));
    if (cs.size() == 0) {
      return true;
    }
    for (String key : capability.split(",")) {
      if (!cs.contains(key)) {
        return false;
      }
    }
    return true;
  }

  public boolean priorityCheck() {
    return "Y".equals(this.hotLevelFlag);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DispatchSfc that = (DispatchSfc) o;
    return sfcStepBo.equals(that.sfcStepBo) && stateName.equals(that.stateName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sfcStepBo, stateName);
  }
}
