package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class HtNpiOutMapInfo {

  private String infoId;

  private String customerGroup;

  private String deviceName;

  private String combineMapOperation;

  private String packageType;

  private String outFlag;

  private String outSampleId;

  private Integer symbolLength;

  private String mapFolderNameRule;

  private String mapFileNameRule;

  private String clientMapRule;

  private String mapUploadNode;

  private String compressedPackageFlag;

  private String outMode;

  private String alignmentDieSymbol;

  private String csvFlag;

  private String ftpHost;

  private String ftpPath;

  private String ftpUser;

  private String ftpPassword;

  private String customerMailAddress;

  private String receivingTerminal;

  private String specialRequestFlag;

  private String specialRequestId;

  private Date updatedTime;

  private String updatedUser;

  private String customerCodes;

  private Integer ftpPort;

  public HtNpiOutMapInfo() {
  }

  public HtNpiOutMapInfo(HtNpiOutMapInfo data) {
    this.infoId = data.infoId;
    this.customerGroup = data.customerGroup;
    this.deviceName = data.deviceName;
    this.combineMapOperation = data.combineMapOperation;
    this.packageType = data.packageType;
    this.outFlag = data.outFlag;
    this.outSampleId = data.outSampleId;
    this.symbolLength = data.symbolLength;
    this.mapFolderNameRule = data.mapFolderNameRule;
    this.mapFileNameRule = data.mapFileNameRule;
    this.clientMapRule = data.clientMapRule;
    this.mapUploadNode = data.mapUploadNode;
    this.compressedPackageFlag = data.compressedPackageFlag;
    this.outMode = data.outMode;
    this.alignmentDieSymbol = data.alignmentDieSymbol;
    this.csvFlag = data.csvFlag;
    this.ftpHost = data.ftpHost;
    this.ftpPath = data.ftpPath;
    this.ftpUser = data.ftpUser;
    this.ftpPassword = data.ftpPassword;
    this.customerMailAddress = data.customerMailAddress;
    this.receivingTerminal = data.receivingTerminal;
    this.specialRequestFlag = data.specialRequestFlag;
    this.specialRequestId = data.specialRequestId;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
    this.customerCodes = data.customerCodes;
    this.ftpPort = data.ftpPort;
  }

  @Override
  public HtNpiOutMapInfo clone() {
    return new HtNpiOutMapInfo(this);
  }

  @Override
  public String toString() {
    return this.infoId;
  }
}
