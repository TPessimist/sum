package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class PdmProjectAffiliateWlpProductInfoV2 {

    private BigDecimal oaId;

    private String factoryWorkOrderType;

    private String pCustDeviceName;

    private String deviceDifference;

    private String custCode;

    private String custDevice1;

    private String custDevice2;

    private String custDevice3;

    private String fabDevice1;

    private String fabDevice2;

    private String fabDevice3;

    private String factoryDevice1;

    private String factoryDevice2;

    private String factoryDevice3;

    private String projectIsClosed;

    private String basisOfProjectClosedFilePath;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private String status;

    private String uuid;

    private String projectEngineerA;

    private String projectEngineerNameA;

    private String projectEngineerB;

    private String projectEngineerNameB;

    private String firstWorkorderEndStation;

    private String secondWorkorderEndStation;

    private String custDevice;

    private String projectStatus;

    private String projectEngineerLeader;

    private String projectEngineerLeaderName;

    private String flag;

    private String bomFlag;

    private String mesFlag;

    private String fabDevice;

    private String factoryDevice;

    private String refFactoryDevice;

    private String refCustDevice;

    private String refFabDevice;

    private String pkgType;

    private String pkgStructure;

    private String oaFlag;

    private String z019FactoryMaterialNo;

    private String z013015FactoryMaterialNo;

    private String dcFactoryMaterialNo;

    private String z019SapMatnr;

    private String z013015SapMatnr;

    private String dcSapMatnr;


    public PdmProjectAffiliateWlpProductInfoV2() {
    }	

    public PdmProjectAffiliateWlpProductInfoV2(PdmProjectAffiliateWlpProductInfoV2 data) {
        this.oaId = data.oaId;
        this.factoryWorkOrderType = data.factoryWorkOrderType;
        this.pCustDeviceName = data.pCustDeviceName;
        this.deviceDifference = data.deviceDifference;
        this.custCode = data.custCode;
        this.custDevice1 = data.custDevice1;
        this.custDevice2 = data.custDevice2;
        this.custDevice3 = data.custDevice3;
        this.fabDevice1 = data.fabDevice1;
        this.fabDevice2 = data.fabDevice2;
        this.fabDevice3 = data.fabDevice3;
        this.factoryDevice1 = data.factoryDevice1;
        this.factoryDevice2 = data.factoryDevice2;
        this.factoryDevice3 = data.factoryDevice3;
        this.projectIsClosed = data.projectIsClosed;
        this.basisOfProjectClosedFilePath = data.basisOfProjectClosedFilePath;
        this.creater = data.creater;
        this.createTime = data.createTime;
        this.updater = data.updater;
        this.updateTime = data.updateTime;
        this.status = data.status;
        this.uuid = data.uuid;
        this.projectEngineerA = data.projectEngineerA;
        this.projectEngineerNameA = data.projectEngineerNameA;
        this.projectEngineerB = data.projectEngineerB;
        this.projectEngineerNameB = data.projectEngineerNameB;
        this.firstWorkorderEndStation = data.firstWorkorderEndStation;
        this.secondWorkorderEndStation = data.secondWorkorderEndStation;
        this.custDevice = data.custDevice;
        this.projectStatus = data.projectStatus;
        this.projectEngineerLeader = data.projectEngineerLeader;
        this.projectEngineerLeaderName = data.projectEngineerLeaderName;
        this.flag = data.flag;
        this.bomFlag = data.bomFlag;
        this.mesFlag = data.mesFlag;
        this.fabDevice = data.fabDevice;
        this.factoryDevice = data.factoryDevice;
        this.refFactoryDevice = data.refFactoryDevice;
        this.refCustDevice = data.refCustDevice;
        this.refFabDevice = data.refFabDevice;
        this.pkgType = data.pkgType;
        this.pkgStructure = data.pkgStructure;
        this.oaFlag = data.oaFlag;
        this.z019FactoryMaterialNo = data.z019FactoryMaterialNo;
        this.z013015FactoryMaterialNo = data.z013015FactoryMaterialNo;
        this.dcFactoryMaterialNo = data.dcFactoryMaterialNo;
        this.z019SapMatnr = data.z019SapMatnr;
        this.z013015SapMatnr = data.z013015SapMatnr;
        this.dcSapMatnr = data.dcSapMatnr;
    }	

    @Override
    public PdmProjectAffiliateWlpProductInfoV2 clone() {
    	return new PdmProjectAffiliateWlpProductInfoV2(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
