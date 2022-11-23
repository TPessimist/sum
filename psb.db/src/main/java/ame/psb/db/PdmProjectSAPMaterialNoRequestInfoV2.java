package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class PdmProjectSAPMaterialNoRequestInfoV2 {

    private String uuid;

    private BigDecimal oaId;

    private String status;

    private String projectEnginerA;

    private String projectEnginerAName;

    private String projectEnginerB;

    private String projectEnginerBName;

    private String requester;

    private String requesterName;

    private String requesterDept;

    private String requestDate;

    private String materialType1;

    private String materialType2;

    private String factoryDevice;

    private String custCode;

    private String waferSize;

    private BigDecimal grossDie;

    private String division;

    private String profitCenterName;

    private String profitCenterCode;

    private String industrySector;

    private String originalGroupName;

    private String originalGroupCode;

    private String tradeType;

    private String factoryCode;

    private String salesGroup;

    private String distributionChannels;

    private String z019FactoryMaterialNo;

    private String z019MaterialType;

    private String z019MaterialGroupCode;

    private String z019MaterialDesc;

    private String z019FabdeviceGroup;

    private String z019Fabdevice;

    private String z019NeedMap;

    private String z019NeedMarking;

    private String z019ExternalProcurementStorageLocation;

    private String z019StorageCode;

    private String z019OutsourceType;

    private String z019OutsourceReturnMaterialNo;

    private String z019NeedPkgWorkOrder;

    private String z019WeatherCustPoSpecifiesMatNo;

    private String z019Code;

    private String z019WaferFactory;

    private String z013015FactoryMaterialNo;

    private String z013015MaterialType;

    private String z013015MaterialGroupCode;

    private String z013015Type;

    private String z013015CustDeviceGroup;

    private String z013015FabdeviceGroup;

    private String z013015TerminalApp;

    private String z013015MaterialGroupCodeOutside;

    private String z013015CustDevice;

    private String z013015Fabdevice;

    private String z013015MaterialDesc;

    private String z013015Code;

    private String z013015GoldenRoutingName;

    private String z013015Process;

    private String z013015NeedMap;

    private String z013015NeedMarking;

    private String z013015PackageType;

    private String z013015DeliveryMethod;

    private String z013015NeedPkgWorkOrder;

    private String z013015WeatherCustPoSpecifiesMatNo;

    private String z013015SpecialFactoryMatStatus;

    private String z013015OutsourceType;

    private String z013015OutsourceReturnMaterialNo;

    private String z013015App;

    private String dcFactoryMaterialNo;

    private String dcMaterialType;

    private String dcMaterialGroupCode;

    private String dcMaterialGroupCodeOutside;

    private String dcCustDeviceGroup;

    private String dcPieceType;

    private String dcMaterialDesc;

    private String dcType;

    private String dcCustDevice;

    private String dcFabdeviceGroup;

    private String dcNeedMap;

    private String dcNeedMarking;

    private String dcGoldenRoutingName;

    private String dcCode;

    private String dcNeedPkgWorkOrder;

    private String dcWeatherCustPoSpecifiesMatNo;

    private String dcPackageType;

    private String dcProcess;

    private String dcWaferOutsourceType;

    private String dcDeliveryMethod;

    private String dcSpecialFactoryMatStatus;

    private String z019CustColumn1;

    private String z019CustColumn2;

    private String z019CustColumn3;

    private String z019CustColumn4;

    private String z013015CustColumn1;

    private String z013015CustColumn2;

    private String z013015CustColumn3;

    private String z013015CustColumn4;

    private String dcCustColumn1;

    private String dcCustColumn2;

    private String dcCustColumn3;

    private String dcCustColumn4;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private BigDecimal workOrderNum;

    private String z019SapMatnr;

    private String z013015SapMatnr;

    private String dcSapMatnr;


    public PdmProjectSAPMaterialNoRequestInfoV2() {
    }	

    public PdmProjectSAPMaterialNoRequestInfoV2(PdmProjectSAPMaterialNoRequestInfoV2 data) {
        this.uuid = data.uuid;
        this.oaId = data.oaId;
        this.status = data.status;
        this.projectEnginerA = data.projectEnginerA;
        this.projectEnginerAName = data.projectEnginerAName;
        this.projectEnginerB = data.projectEnginerB;
        this.projectEnginerBName = data.projectEnginerBName;
        this.requester = data.requester;
        this.requesterName = data.requesterName;
        this.requesterDept = data.requesterDept;
        this.requestDate = data.requestDate;
        this.materialType1 = data.materialType1;
        this.materialType2 = data.materialType2;
        this.factoryDevice = data.factoryDevice;
        this.custCode = data.custCode;
        this.waferSize = data.waferSize;
        this.grossDie = data.grossDie;
        this.division = data.division;
        this.profitCenterName = data.profitCenterName;
        this.profitCenterCode = data.profitCenterCode;
        this.industrySector = data.industrySector;
        this.originalGroupName = data.originalGroupName;
        this.originalGroupCode = data.originalGroupCode;
        this.tradeType = data.tradeType;
        this.factoryCode = data.factoryCode;
        this.salesGroup = data.salesGroup;
        this.distributionChannels = data.distributionChannels;
        this.z019FactoryMaterialNo = data.z019FactoryMaterialNo;
        this.z019MaterialType = data.z019MaterialType;
        this.z019MaterialGroupCode = data.z019MaterialGroupCode;
        this.z019MaterialDesc = data.z019MaterialDesc;
        this.z019FabdeviceGroup = data.z019FabdeviceGroup;
        this.z019Fabdevice = data.z019Fabdevice;
        this.z019NeedMap = data.z019NeedMap;
        this.z019NeedMarking = data.z019NeedMarking;
        this.z019ExternalProcurementStorageLocation = data.z019ExternalProcurementStorageLocation;
        this.z019StorageCode = data.z019StorageCode;
        this.z019OutsourceType = data.z019OutsourceType;
        this.z019OutsourceReturnMaterialNo = data.z019OutsourceReturnMaterialNo;
        this.z019NeedPkgWorkOrder = data.z019NeedPkgWorkOrder;
        this.z019WeatherCustPoSpecifiesMatNo = data.z019WeatherCustPoSpecifiesMatNo;
        this.z019Code = data.z019Code;
        this.z019WaferFactory = data.z019WaferFactory;
        this.z013015FactoryMaterialNo = data.z013015FactoryMaterialNo;
        this.z013015MaterialType = data.z013015MaterialType;
        this.z013015MaterialGroupCode = data.z013015MaterialGroupCode;
        this.z013015Type = data.z013015Type;
        this.z013015CustDeviceGroup = data.z013015CustDeviceGroup;
        this.z013015FabdeviceGroup = data.z013015FabdeviceGroup;
        this.z013015TerminalApp = data.z013015TerminalApp;
        this.z013015MaterialGroupCodeOutside = data.z013015MaterialGroupCodeOutside;
        this.z013015CustDevice = data.z013015CustDevice;
        this.z013015Fabdevice = data.z013015Fabdevice;
        this.z013015MaterialDesc = data.z013015MaterialDesc;
        this.z013015Code = data.z013015Code;
        this.z013015GoldenRoutingName = data.z013015GoldenRoutingName;
        this.z013015Process = data.z013015Process;
        this.z013015NeedMap = data.z013015NeedMap;
        this.z013015NeedMarking = data.z013015NeedMarking;
        this.z013015PackageType = data.z013015PackageType;
        this.z013015DeliveryMethod = data.z013015DeliveryMethod;
        this.z013015NeedPkgWorkOrder = data.z013015NeedPkgWorkOrder;
        this.z013015WeatherCustPoSpecifiesMatNo = data.z013015WeatherCustPoSpecifiesMatNo;
        this.z013015SpecialFactoryMatStatus = data.z013015SpecialFactoryMatStatus;
        this.z013015OutsourceType = data.z013015OutsourceType;
        this.z013015OutsourceReturnMaterialNo = data.z013015OutsourceReturnMaterialNo;
        this.z013015App = data.z013015App;
        this.dcFactoryMaterialNo = data.dcFactoryMaterialNo;
        this.dcMaterialType = data.dcMaterialType;
        this.dcMaterialGroupCode = data.dcMaterialGroupCode;
        this.dcMaterialGroupCodeOutside = data.dcMaterialGroupCodeOutside;
        this.dcCustDeviceGroup = data.dcCustDeviceGroup;
        this.dcPieceType = data.dcPieceType;
        this.dcMaterialDesc = data.dcMaterialDesc;
        this.dcType = data.dcType;
        this.dcCustDevice = data.dcCustDevice;
        this.dcFabdeviceGroup = data.dcFabdeviceGroup;
        this.dcNeedMap = data.dcNeedMap;
        this.dcNeedMarking = data.dcNeedMarking;
        this.dcGoldenRoutingName = data.dcGoldenRoutingName;
        this.dcCode = data.dcCode;
        this.dcNeedPkgWorkOrder = data.dcNeedPkgWorkOrder;
        this.dcWeatherCustPoSpecifiesMatNo = data.dcWeatherCustPoSpecifiesMatNo;
        this.dcPackageType = data.dcPackageType;
        this.dcProcess = data.dcProcess;
        this.dcWaferOutsourceType = data.dcWaferOutsourceType;
        this.dcDeliveryMethod = data.dcDeliveryMethod;
        this.dcSpecialFactoryMatStatus = data.dcSpecialFactoryMatStatus;
        this.z019CustColumn1 = data.z019CustColumn1;
        this.z019CustColumn2 = data.z019CustColumn2;
        this.z019CustColumn3 = data.z019CustColumn3;
        this.z019CustColumn4 = data.z019CustColumn4;
        this.z013015CustColumn1 = data.z013015CustColumn1;
        this.z013015CustColumn2 = data.z013015CustColumn2;
        this.z013015CustColumn3 = data.z013015CustColumn3;
        this.z013015CustColumn4 = data.z013015CustColumn4;
        this.dcCustColumn1 = data.dcCustColumn1;
        this.dcCustColumn2 = data.dcCustColumn2;
        this.dcCustColumn3 = data.dcCustColumn3;
        this.dcCustColumn4 = data.dcCustColumn4;
        this.creater = data.creater;
        this.createTime = data.createTime;
        this.updater = data.updater;
        this.updateTime = data.updateTime;
        this.workOrderNum = data.workOrderNum;
        this.z019SapMatnr = data.z019SapMatnr;
        this.z013015SapMatnr = data.z013015SapMatnr;
        this.dcSapMatnr = data.dcSapMatnr;
    }	

    @Override
    public PdmProjectSAPMaterialNoRequestInfoV2 clone() {
    	return new PdmProjectSAPMaterialNoRequestInfoV2(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
