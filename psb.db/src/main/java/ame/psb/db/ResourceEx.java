package ame.psb.db;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class ResourceEx {

  public static final String RUN_TYPE_AT = "AUTO_TRACKIN";

  public static final String RUN_TYPE_MT = "MANUAL_TRACKIN";

  public static final String RESOURCE_TYPE_PROCESS = "P";

  public static final String RESOURCE_TYPE_METROLOGY = "M";

  private String resourceBo;

  private int moveInMax;

  private int moveInCount;

  private int trackInMax;

  private int trackInCount;

  private String stateName;

  private String capability;

  private boolean eapSupport;

  private String runType;

  private String priorityCheck;

  private String virtual;

  private String toolingBinding;

  private String moveInType;

  private String moveOutType;

  private String trackInType;

  private String trackOutType;

  private String resourceType;

  private String downStateName;

  private String updatedUser;

  private Date updatedTime;

  private int waitSfcCount;

  private int waitWaferCount;

  private String mcsStateName;

  private String eapStateName;

  private boolean rmsSupport;

  private String functionDesc;

  private String typeDesc;

  private String combineResource;

  private String controlStatus;

  private String ohtFlag;

  private String rmsFlag;

  private Date heartBeat;

  private String forceDeliverState;

  public ResourceEx() {
    this.moveInMax = 1;
    this.trackInMax = 1;
    this.stateName = "WAIT";
    this.eapSupport = false;
    this.toolingBinding = "N";
    this.runType = RUN_TYPE_MT;
    this.trackInType = "M";
    this.priorityCheck = "Y";
    this.virtual = "N";
    this.rmsSupport = false;
    this.resourceType = RESOURCE_TYPE_PROCESS;
    this.updatedTime = new Date();
  }

  public static String getRunTypeAt() {
    return RUN_TYPE_AT;
  }

  public static String getRunTypeMt() {
    return RUN_TYPE_MT;
  }

  public static String getResourceTypeProcess() {
    return RESOURCE_TYPE_PROCESS;
  }

  public static String getResourceTypeMetrology() {
    return RESOURCE_TYPE_METROLOGY;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  /**
   * 取得可以 MoveIn 最大數。
   *
   * @return 可以 MoveIn 最大數。
   */
  public int getMoveInMax() {
    return this.moveInMax;
  }

  /**
   * 設定可以 MoveIn 最大數。
   *
   * @param moveInMax 可以 MoveIn 最大數。
   */
  public void setMoveInMax(int moveInMax) {
    this.moveInMax = moveInMax;
  }

  /**
   * 取得當前 MoveIn 數。
   *
   * @return 當前 MoveIn 數。
   */
  public int getMoveInCount() {
    return this.moveInCount;
  }

  /**
   * 設定當前 MoveIn 數。
   *
   * @param moveInCount 當前 MoveIn 數。
   */
  public void setMoveInCount(int moveInCount) {
    this.moveInCount = moveInCount;
  }

  public int getTrackInMax() {
    return this.trackInMax;
  }

  public void setTrackInMax(int trackInMax) {
    this.trackInMax = trackInMax;
  }

  public int getTrackInCount() {
    return this.trackInCount;
  }

  public void setTrackInCount(int trackInCount) {
    this.trackInCount = trackInCount;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCapability() {
    return this.capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  /**
   * 檢查機台是否具備特定工作特性。
   *
   * @param capability 工作特性。
   * @return
   */
  public boolean match(String capability) {
    if (this.capability == null || capability == null) {
      return true;
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

  /**
   * 取得是否此機台支援 EAP。
   *
   * @return 是否此機台支援 EAP。
   */
  public boolean isEapSupport() {
    return this.eapSupport;
  }

  /**
   * 設定是否此機台支援 EAP。
   *
   * @param eapSupport 是否此機台支援 EAP。
   */
  public void setEapSupport(boolean eapSupport) {
    this.eapSupport = eapSupport;
  }

  /**
   * 取得機台 TRACKIN 方式。
   *
   * @return AUTO_TRACKIN/MANUAL_TRACKIN。
   */
  public String getRunType() {
    return this.runType;
  }

  /**
   * 設定機台 TRACKIN 方式。
   *
   * @param runType AUTO_TRACKIN/MANUAL_TRACKIN。
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }

  /**
   * 取得是否進行優先級檢查。
   *
   * @return 是否進行優先級檢查。
   */
  public String getPriorityCheck() {
    return this.priorityCheck;
  }

  /**
   * 設定是否進行優先級檢查。
   *
   * @param priorityCheck 是否進行優先級檢查。
   */
  public void setPriorityCheck(String priorityCheck) {
    this.priorityCheck = priorityCheck;
  }

  /**
   * 取得是否為虛擬機台。
   *
   * @return 是否為虛擬機台。
   */
  public String getVirtual() {
    return this.virtual;
  }

  /**
   * 設定是否為虛擬機台。
   *
   * @param virtual 是否為虛擬機台。
   */
  public void setVirtual(String virtual) {
    this.virtual = virtual;
  }

  public String getToolingBinding() {
    return this.toolingBinding;
  }

  public void setToolingBinding(String toolingBinding) {
    this.toolingBinding = toolingBinding;
  }

  /**
   * @return
   */
  public String getMoveInType() {
    return this.moveInType;
  }

  /**
   * @param moveInType
   */
  public void setMoveInType(String moveInType) {
    this.moveInType = moveInType;
  }

  /**
   * 取得 MoveOut 方式。<br> C：一定要更換載具。<br>
   *
   * @return MoveOut 方式。
   */
  public String getMoveOutType() {
    return this.moveOutType;
  }

  /**
   * 設定 MoveOut 方式。<br> C：一定要更換載具。<br>
   *
   * @param moveOutType MoveOut 方式。
   */
  public void setMoveOutType(String moveOutType) {
    this.moveOutType = moveOutType;
  }

  /**
   * 取得 TrackIn 方式。
   *
   * @return A / M。
   */
  public String getTrackInType() {
    return this.trackInType;
  }

  /**
   * 設定 TrackIn 方式。
   *
   * @param trackInType A / M。
   */
  public void setTrackInType(String trackInType) {
    this.trackInType = trackInType;
  }

  /**
   * @return
   */
  public String getTrackOutType() {
    return this.trackOutType;
  }

  /**
   * @param trackOutType
   */
  public void setTrackOutType(String trackOutType) {
    this.trackOutType = trackOutType;
  }

  /**
   * 取得機台為製程或量測機台。
   *
   * @return RESOURCE_TYPE_PROCESS / RESOURCE_TYPE_METROLOGY。
   */
  public String getResourceType() {
    return this.resourceType;
  }

  /**
   * 設定機台為製程或量測機台。
   *
   * @param resourceType RESOURCE_TYPE_PROCESS / RESOURCE_TYPE_METROLOGY。
   */
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getDownStateName() {
    return this.downStateName;
  }

  public void setDownStateName(String downStateName) {
    this.downStateName = downStateName;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  /**
   * 判斷是否在 UP TIME。
   *
   * @return 是否在 UP TIME。
   */
  public boolean isUp() {
    return "WAIT".equals(this.stateName)
        || "DUMMY".equals(this.stateName)
        || "HOLD".equals(this.stateName);
  }

  /**
   * 判斷是否在 HOLD。
   *
   * @return 是否在 HOLD。
   */
  public boolean isHold() {
    return "HOLD".equals(this.stateName);
  }

  /**
   * 判斷是否在 Dummy。
   *
   * @return 是否在 Dummy。
   */
  public boolean isDummy() {
    return "DUMMY".equals(this.stateName);
  }

  public boolean isDown() {
    String[] downState = {"DOWN", "PLAN DOWN", "PE DOWN", "DOWN_EER(EE)", "DOWN_FACR(FAC)",
        "DOWN_IT(IT)", "DOWN_PENG(PE)", "FAC_PM(FAC)", "QCCFM(QC)", "TEST_EE(EE)", "TEST_EER(EE)",
        "TEST_PE(PE)", "TEST_PER(PE)", "WAIT_EENG(FAC)", "WAIT_EENG(IT)", "WAIT_EENG(MFG)",
        "WAIT_EENG(PE)", "WAIT_EENG(QC)", "WAIT_FAC(EE)", "WAIT_IT(EE)", "WAIT_PENG(EE)",
        "WAIT_QC(EE)", "WAIT_QC(FAC)", "WAIT_QC(PE)"};

    return Arrays.asList(downState).contains(this.downStateName);
  }

  public boolean isMa() {
    String[] maState = {"MON_D", "PM", "DOSING(MFG)", "DOSING(PE)", "MON_D(MFG)", "MON_PM(EE)"};

    return Arrays.asList(maState).contains(this.downStateName);
  }

  public boolean isFull() {
    return this.moveInCount >= this.moveInMax || this.trackInCount >= this.trackInMax;
  }

  public boolean isIdle() {
    return "IDLE".equals(this.downStateName);
  }

  public boolean isRun() {
    return "RUN".equals(this.downStateName);
  }

  public boolean isOff() {
    return "BACKUP(MFG)".equals(this.downStateName);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }

  public int getWaitSfcCount() {
    return this.waitSfcCount;
  }

  public void setWaitSfcCount(int waitSfcCount) {
    this.waitSfcCount = waitSfcCount;
  }

  public int getWaitWaferCount() {
    return this.waitWaferCount;
  }

  public void setWaitWaferCount(int waitWaferCount) {
    this.waitWaferCount = waitWaferCount;
  }

  public String getMcsStateName() {
    return this.mcsStateName;
  }

  public void setMcsStateName(String mcsStateName) {
    this.mcsStateName = mcsStateName;
  }

  public String getEapStateName() {
    return this.eapStateName;
  }

  public void setEapStateName(String eapStateName) {
    this.eapStateName = eapStateName;
  }

  public boolean isRmsSupport() {
    return this.rmsSupport;
  }

  public void setRmsSupport(boolean rmsSupport) {
    this.rmsSupport = rmsSupport;
  }

  public String getFunctionDesc() {
    return this.functionDesc;
  }

  public void setFunctionDesc(String functionDesc) {
    this.functionDesc = functionDesc;
  }

  public String getTypeDesc() {
    return this.typeDesc;
  }

  public void setTypeDesc(String typeDesc) {
    this.typeDesc = typeDesc;
  }

  public String getCombineResource() {
    return this.combineResource;
  }

  public void setCombineResource(String combineResource) {
    this.combineResource = combineResource;
  }

  public String getControlStatus() {
    return controlStatus;
  }

  public void setControlStatus(String controlStatus) {
    this.controlStatus = controlStatus;
  }

  public String getOhtFlag() {
    return ohtFlag;
  }

  public void setOhtFlag(String ohtFlag) {
    this.ohtFlag = ohtFlag;
  }

  public String getRmsFlag() {
    return rmsFlag;
  }

  public void setRmsFlag(String rmsFlag) {
    this.rmsFlag = rmsFlag;
  }

  public Date getHeartBeat() {
    return heartBeat;
  }

  public void setHeartBeat(Date heartBeat) {
    this.heartBeat = heartBeat;
  }

  public String getForceDeliverState() {
    return forceDeliverState;
  }

  public void setForceDeliverState(String forceDeliverState) {
    this.forceDeliverState = forceDeliverState;
  }

  public boolean isOnlineRemote() {
    return "REMOTE".equalsIgnoreCase(this.controlStatus) && this.heartBeatValid();
  }

  public boolean isOnlineLocal() {
    return "LOCAL".equalsIgnoreCase(this.controlStatus) && this.heartBeatValid();
  }

  public boolean isOffline() {
    return !this.isOnlineLocal() && !this.isOnlineRemote();
  }

  //心跳包有效的条件: 上次心跳包时间不为空并且是在五分钟内的
  public boolean heartBeatValid() {
    return this.heartBeat != null
        && System.currentTimeMillis() - this.heartBeat.getTime() <= 1000 * 60 * 5;
  }


}
