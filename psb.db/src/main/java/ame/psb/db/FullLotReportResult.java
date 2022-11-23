package ame.psb.db;

public class FullLotReportResult {

  public String batchId;

  public int routId;//rout序号

  public String fcdaBathId; //FCDABatchId

  public String toolId; // toolId

  public String state; //状态

  public String productionGroups; //班别

  public String startTime; //开始时间

  public String endTime; // 结束时间

  public int movenInQty; //进站数量

  public int movenOutQty; //出站数量

  public int badQty; //bad数量

  public String qTime; //Q-TIME时间


  public ActivityLog activityLogs;

  public RunSfc runSfcs;

  public RunSfcItem runSfcItem;

  public RunSfcTest runSfcTest;

  public ViewSfcItem viewSfcItem;

  public String custOperation;

  public FullLotReportResult() {
    this.activityLogs = new ActivityLog();
    this.runSfcs = new RunSfc();
    this.runSfcItem = new RunSfcItem();
    this.viewSfcItem = new ViewSfcItem();
    this.runSfcTest = new RunSfcTest();
  }

}
