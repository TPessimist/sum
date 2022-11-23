package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PdmProjectSAPMaterialNoRequestInfoV2;
import uia.utils.dao.DateUtils;

public class PdmProjectSAPMaterialNoRequestInfoV2Dao {

    private static final String SQL_INS = "INSERT INTO zm_pdm_project_sap_material_no_request_info_v2(uuid,oa_id,status,project_enginer_a,project_enginer_a_name,project_enginer_b,project_enginer_b_name,requester,requester_name,requester_dept,request_date,material_type_1,material_type_2,factory_device,cust_code,wafer_size,gross_die,division,profit_center_name,profit_center_code,industry_sector,original_group_name,original_group_code,trade_type,factory_code,sales_group,distribution_channels,z019_factory_material_no,z019_material_type,z019_material_group_code,z019_material_desc,z019_fabdevice_group,z019_fabdevice,z019_need_map,z019_need_marking,z019_external_procurement_storage_location,z019_storage_code,z019_outsource_type,z019_outsource_return_material_no,z019_need_pkg_work_order,z019_weather_cust_po_specifies_mat_no,z019_code,z019_wafer_factory,z013_015_factory_material_no,z013_015_material_type,z013_015_material_group_code,z013_015_type,z013_015_cust_device_group,z013_015_fabdevice_group,z013_015_terminal_app,z013_015_material_group_code_outside,z013_015_cust_device,z013_015_fabdevice,z013_015_material_desc,z013_015_code,z013_015_golden_routing_name,z013_015_process,z013_015_need_map,z013_015_need_marking,z013_015_package_type,z013_015_delivery_method,z013_015_need_pkg_work_order,z013_015_weather_cust_po_specifies_mat_no,z013_015_special_factory_mat_status,z013_015_outsource_type,z013_015_outsource_return_material_no,z013_015_app,dc_factory_material_no,dc_material_type,dc_material_group_code,dc_material_group_code_outside,dc_cust_device_group,dc_piece_type,dc_material_desc,dc_type,dc_cust_device,dc_fabdevice_group,dc_need_map,dc_need_marking,dc_golden_routing_name,dc_code,dc_need_pkg_work_order,dc_weather_cust_po_specifies_mat_no,dc_package_type,dc_process,dc_wafer_outsource_type,dc_delivery_method,dc_special_factory_mat_status,z019_cust_column1,z019_cust_column2,z019_cust_column3,z019_cust_column4,z013_015_cust_column1,z013_015_cust_column2,z013_015_cust_column3,z013_015_cust_column4,dc_cust_column1,dc_cust_column2,dc_cust_column3,dc_cust_column4,creater,create_time,updater,update_time,work_order_num,z019_sap_matnr,z013_015_sap_matnr,dc_sap_matnr) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zm_pdm_project_sap_material_no_request_info_v2 SET oa_id=?,status=?,project_enginer_a=?,project_enginer_a_name=?,project_enginer_b=?,project_enginer_b_name=?,requester=?,requester_name=?,requester_dept=?,request_date=?,material_type_1=?,material_type_2=?,factory_device=?,cust_code=?,wafer_size=?,gross_die=?,division=?,profit_center_name=?,profit_center_code=?,industry_sector=?,original_group_name=?,original_group_code=?,trade_type=?,factory_code=?,sales_group=?,distribution_channels=?,z019_factory_material_no=?,z019_material_type=?,z019_material_group_code=?,z019_material_desc=?,z019_fabdevice_group=?,z019_fabdevice=?,z019_need_map=?,z019_need_marking=?,z019_external_procurement_storage_location=?,z019_storage_code=?,z019_outsource_type=?,z019_outsource_return_material_no=?,z019_need_pkg_work_order=?,z019_weather_cust_po_specifies_mat_no=?,z019_code=?,z019_wafer_factory=?,z013_015_factory_material_no=?,z013_015_material_type=?,z013_015_material_group_code=?,z013_015_type=?,z013_015_cust_device_group=?,z013_015_fabdevice_group=?,z013_015_terminal_app=?,z013_015_material_group_code_outside=?,z013_015_cust_device=?,z013_015_fabdevice=?,z013_015_material_desc=?,z013_015_code=?,z013_015_golden_routing_name=?,z013_015_process=?,z013_015_need_map=?,z013_015_need_marking=?,z013_015_package_type=?,z013_015_delivery_method=?,z013_015_need_pkg_work_order=?,z013_015_weather_cust_po_specifies_mat_no=?,z013_015_special_factory_mat_status=?,z013_015_outsource_type=?,z013_015_outsource_return_material_no=?,z013_015_app=?,dc_factory_material_no=?,dc_material_type=?,dc_material_group_code=?,dc_material_group_code_outside=?,dc_cust_device_group=?,dc_piece_type=?,dc_material_desc=?,dc_type=?,dc_cust_device=?,dc_fabdevice_group=?,dc_need_map=?,dc_need_marking=?,dc_golden_routing_name=?,dc_code=?,dc_need_pkg_work_order=?,dc_weather_cust_po_specifies_mat_no=?,dc_package_type=?,dc_process=?,dc_wafer_outsource_type=?,dc_delivery_method=?,dc_special_factory_mat_status=?,z019_cust_column1=?,z019_cust_column2=?,z019_cust_column3=?,z019_cust_column4=?,z013_015_cust_column1=?,z013_015_cust_column2=?,z013_015_cust_column3=?,z013_015_cust_column4=?,dc_cust_column1=?,dc_cust_column2=?,dc_cust_column3=?,dc_cust_column4=?,creater=?,create_time=?,updater=?,update_time=?,work_order_num=?,z019_sap_matnr=?,z013_015_sap_matnr=?,dc_sap_matnr=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,oa_id,status,project_enginer_a,project_enginer_a_name,project_enginer_b,project_enginer_b_name,requester,requester_name,requester_dept,request_date,material_type_1,material_type_2,factory_device,cust_code,wafer_size,gross_die,division,profit_center_name,profit_center_code,industry_sector,original_group_name,original_group_code,trade_type,factory_code,sales_group,distribution_channels,z019_factory_material_no,z019_material_type,z019_material_group_code,z019_material_desc,z019_fabdevice_group,z019_fabdevice,z019_need_map,z019_need_marking,z019_external_procurement_storage_location,z019_storage_code,z019_outsource_type,z019_outsource_return_material_no,z019_need_pkg_work_order,z019_weather_cust_po_specifies_mat_no,z019_code,z019_wafer_factory,z013_015_factory_material_no,z013_015_material_type,z013_015_material_group_code,z013_015_type,z013_015_cust_device_group,z013_015_fabdevice_group,z013_015_terminal_app,z013_015_material_group_code_outside,z013_015_cust_device,z013_015_fabdevice,z013_015_material_desc,z013_015_code,z013_015_golden_routing_name,z013_015_process,z013_015_need_map,z013_015_need_marking,z013_015_package_type,z013_015_delivery_method,z013_015_need_pkg_work_order,z013_015_weather_cust_po_specifies_mat_no,z013_015_special_factory_mat_status,z013_015_outsource_type,z013_015_outsource_return_material_no,z013_015_app,dc_factory_material_no,dc_material_type,dc_material_group_code,dc_material_group_code_outside,dc_cust_device_group,dc_piece_type,dc_material_desc,dc_type,dc_cust_device,dc_fabdevice_group,dc_need_map,dc_need_marking,dc_golden_routing_name,dc_code,dc_need_pkg_work_order,dc_weather_cust_po_specifies_mat_no,dc_package_type,dc_process,dc_wafer_outsource_type,dc_delivery_method,dc_special_factory_mat_status,z019_cust_column1,z019_cust_column2,z019_cust_column3,z019_cust_column4,z013_015_cust_column1,z013_015_cust_column2,z013_015_cust_column3,z013_015_cust_column4,dc_cust_column1,dc_cust_column2,dc_cust_column3,dc_cust_column4,creater,create_time,updater,update_time,work_order_num,z019_sap_matnr,z013_015_sap_matnr,dc_sap_matnr FROM zm_pdm_project_sap_material_no_request_info_v2 ";
    
    private final Connection conn;

    public PdmProjectSAPMaterialNoRequestInfoV2Dao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PdmProjectSAPMaterialNoRequestInfoV2 data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setBigDecimal(2, data.getOaId());
            ps.setString(3, data.getStatus());
            ps.setString(4, data.getProjectEnginerA());
            ps.setString(5, data.getProjectEnginerAName());
            ps.setString(6, data.getProjectEnginerB());
            ps.setString(7, data.getProjectEnginerBName());
            ps.setString(8, data.getRequester());
            ps.setString(9, data.getRequesterName());
            ps.setString(10, data.getRequesterDept());
            ps.setString(11, data.getRequestDate());
            ps.setString(12, data.getMaterialType1());
            ps.setString(13, data.getMaterialType2());
            ps.setString(14, data.getFactoryDevice());
            ps.setString(15, data.getCustCode());
            ps.setString(16, data.getWaferSize());
            ps.setBigDecimal(17, data.getGrossDie());
            ps.setString(18, data.getDivision());
            ps.setString(19, data.getProfitCenterName());
            ps.setString(20, data.getProfitCenterCode());
            ps.setString(21, data.getIndustrySector());
            ps.setString(22, data.getOriginalGroupName());
            ps.setString(23, data.getOriginalGroupCode());
            ps.setString(24, data.getTradeType());
            ps.setString(25, data.getFactoryCode());
            ps.setString(26, data.getSalesGroup());
            ps.setString(27, data.getDistributionChannels());
            ps.setString(28, data.getZ019FactoryMaterialNo());
            ps.setString(29, data.getZ019MaterialType());
            ps.setString(30, data.getZ019MaterialGroupCode());
            ps.setString(31, data.getZ019MaterialDesc());
            ps.setString(32, data.getZ019FabdeviceGroup());
            ps.setString(33, data.getZ019Fabdevice());
            ps.setString(34, data.getZ019NeedMap());
            ps.setString(35, data.getZ019NeedMarking());
            ps.setString(36, data.getZ019ExternalProcurementStorageLocation());
            ps.setString(37, data.getZ019StorageCode());
            ps.setString(38, data.getZ019OutsourceType());
            ps.setString(39, data.getZ019OutsourceReturnMaterialNo());
            ps.setString(40, data.getZ019NeedPkgWorkOrder());
            ps.setString(41, data.getZ019WeatherCustPoSpecifiesMatNo());
            ps.setString(42, data.getZ019Code());
            ps.setString(43, data.getZ019WaferFactory());
            ps.setString(44, data.getZ013015FactoryMaterialNo());
            ps.setString(45, data.getZ013015MaterialType());
            ps.setString(46, data.getZ013015MaterialGroupCode());
            ps.setString(47, data.getZ013015Type());
            ps.setString(48, data.getZ013015CustDeviceGroup());
            ps.setString(49, data.getZ013015FabdeviceGroup());
            ps.setString(50, data.getZ013015TerminalApp());
            ps.setString(51, data.getZ013015MaterialGroupCodeOutside());
            ps.setString(52, data.getZ013015CustDevice());
            ps.setString(53, data.getZ013015Fabdevice());
            ps.setString(54, data.getZ013015MaterialDesc());
            ps.setString(55, data.getZ013015Code());
            ps.setString(56, data.getZ013015GoldenRoutingName());
            ps.setString(57, data.getZ013015Process());
            ps.setString(58, data.getZ013015NeedMap());
            ps.setString(59, data.getZ013015NeedMarking());
            ps.setString(60, data.getZ013015PackageType());
            ps.setString(61, data.getZ013015DeliveryMethod());
            ps.setString(62, data.getZ013015NeedPkgWorkOrder());
            ps.setString(63, data.getZ013015WeatherCustPoSpecifiesMatNo());
            ps.setString(64, data.getZ013015SpecialFactoryMatStatus());
            ps.setString(65, data.getZ013015OutsourceType());
            ps.setString(66, data.getZ013015OutsourceReturnMaterialNo());
            ps.setString(67, data.getZ013015App());
            ps.setString(68, data.getDcFactoryMaterialNo());
            ps.setString(69, data.getDcMaterialType());
            ps.setString(70, data.getDcMaterialGroupCode());
            ps.setString(71, data.getDcMaterialGroupCodeOutside());
            ps.setString(72, data.getDcCustDeviceGroup());
            ps.setString(73, data.getDcPieceType());
            ps.setString(74, data.getDcMaterialDesc());
            ps.setString(75, data.getDcType());
            ps.setString(76, data.getDcCustDevice());
            ps.setString(77, data.getDcFabdeviceGroup());
            ps.setString(78, data.getDcNeedMap());
            ps.setString(79, data.getDcNeedMarking());
            ps.setString(80, data.getDcGoldenRoutingName());
            ps.setString(81, data.getDcCode());
            ps.setString(82, data.getDcNeedPkgWorkOrder());
            ps.setString(83, data.getDcWeatherCustPoSpecifiesMatNo());
            ps.setString(84, data.getDcPackageType());
            ps.setString(85, data.getDcProcess());
            ps.setString(86, data.getDcWaferOutsourceType());
            ps.setString(87, data.getDcDeliveryMethod());
            ps.setString(88, data.getDcSpecialFactoryMatStatus());
            ps.setString(89, data.getZ019CustColumn1());
            ps.setString(90, data.getZ019CustColumn2());
            ps.setString(91, data.getZ019CustColumn3());
            ps.setString(92, data.getZ019CustColumn4());
            ps.setString(93, data.getZ013015CustColumn1());
            ps.setString(94, data.getZ013015CustColumn2());
            ps.setString(95, data.getZ013015CustColumn3());
            ps.setString(96, data.getZ013015CustColumn4());
            ps.setString(97, data.getDcCustColumn1());
            ps.setString(98, data.getDcCustColumn2());
            ps.setString(99, data.getDcCustColumn3());
            ps.setString(100, data.getDcCustColumn4());
            ps.setString(101, data.getCreater());
            DateUtils.setDateTz(ps, 102, data.getCreateTime());
            ps.setString(103, data.getUpdater());
            DateUtils.setDateTz(ps, 104, data.getUpdateTime());
            ps.setBigDecimal(105, data.getWorkOrderNum());
            ps.setString(106, data.getZ019SapMatnr());
            ps.setString(107, data.getZ013015SapMatnr());
            ps.setString(108, data.getDcSapMatnr());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PdmProjectSAPMaterialNoRequestInfoV2> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PdmProjectSAPMaterialNoRequestInfoV2 data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setBigDecimal(2, data.getOaId());
            ps.setString(3, data.getStatus());
            ps.setString(4, data.getProjectEnginerA());
            ps.setString(5, data.getProjectEnginerAName());
            ps.setString(6, data.getProjectEnginerB());
            ps.setString(7, data.getProjectEnginerBName());
            ps.setString(8, data.getRequester());
            ps.setString(9, data.getRequesterName());
            ps.setString(10, data.getRequesterDept());
            ps.setString(11, data.getRequestDate());
            ps.setString(12, data.getMaterialType1());
            ps.setString(13, data.getMaterialType2());
            ps.setString(14, data.getFactoryDevice());
            ps.setString(15, data.getCustCode());
            ps.setString(16, data.getWaferSize());
            ps.setBigDecimal(17, data.getGrossDie());
            ps.setString(18, data.getDivision());
            ps.setString(19, data.getProfitCenterName());
            ps.setString(20, data.getProfitCenterCode());
            ps.setString(21, data.getIndustrySector());
            ps.setString(22, data.getOriginalGroupName());
            ps.setString(23, data.getOriginalGroupCode());
            ps.setString(24, data.getTradeType());
            ps.setString(25, data.getFactoryCode());
            ps.setString(26, data.getSalesGroup());
            ps.setString(27, data.getDistributionChannels());
            ps.setString(28, data.getZ019FactoryMaterialNo());
            ps.setString(29, data.getZ019MaterialType());
            ps.setString(30, data.getZ019MaterialGroupCode());
            ps.setString(31, data.getZ019MaterialDesc());
            ps.setString(32, data.getZ019FabdeviceGroup());
            ps.setString(33, data.getZ019Fabdevice());
            ps.setString(34, data.getZ019NeedMap());
            ps.setString(35, data.getZ019NeedMarking());
            ps.setString(36, data.getZ019ExternalProcurementStorageLocation());
            ps.setString(37, data.getZ019StorageCode());
            ps.setString(38, data.getZ019OutsourceType());
            ps.setString(39, data.getZ019OutsourceReturnMaterialNo());
            ps.setString(40, data.getZ019NeedPkgWorkOrder());
            ps.setString(41, data.getZ019WeatherCustPoSpecifiesMatNo());
            ps.setString(42, data.getZ019Code());
            ps.setString(43, data.getZ019WaferFactory());
            ps.setString(44, data.getZ013015FactoryMaterialNo());
            ps.setString(45, data.getZ013015MaterialType());
            ps.setString(46, data.getZ013015MaterialGroupCode());
            ps.setString(47, data.getZ013015Type());
            ps.setString(48, data.getZ013015CustDeviceGroup());
            ps.setString(49, data.getZ013015FabdeviceGroup());
            ps.setString(50, data.getZ013015TerminalApp());
            ps.setString(51, data.getZ013015MaterialGroupCodeOutside());
            ps.setString(52, data.getZ013015CustDevice());
            ps.setString(53, data.getZ013015Fabdevice());
            ps.setString(54, data.getZ013015MaterialDesc());
            ps.setString(55, data.getZ013015Code());
            ps.setString(56, data.getZ013015GoldenRoutingName());
            ps.setString(57, data.getZ013015Process());
            ps.setString(58, data.getZ013015NeedMap());
            ps.setString(59, data.getZ013015NeedMarking());
            ps.setString(60, data.getZ013015PackageType());
            ps.setString(61, data.getZ013015DeliveryMethod());
            ps.setString(62, data.getZ013015NeedPkgWorkOrder());
            ps.setString(63, data.getZ013015WeatherCustPoSpecifiesMatNo());
            ps.setString(64, data.getZ013015SpecialFactoryMatStatus());
            ps.setString(65, data.getZ013015OutsourceType());
            ps.setString(66, data.getZ013015OutsourceReturnMaterialNo());
            ps.setString(67, data.getZ013015App());
            ps.setString(68, data.getDcFactoryMaterialNo());
            ps.setString(69, data.getDcMaterialType());
            ps.setString(70, data.getDcMaterialGroupCode());
            ps.setString(71, data.getDcMaterialGroupCodeOutside());
            ps.setString(72, data.getDcCustDeviceGroup());
            ps.setString(73, data.getDcPieceType());
            ps.setString(74, data.getDcMaterialDesc());
            ps.setString(75, data.getDcType());
            ps.setString(76, data.getDcCustDevice());
            ps.setString(77, data.getDcFabdeviceGroup());
            ps.setString(78, data.getDcNeedMap());
            ps.setString(79, data.getDcNeedMarking());
            ps.setString(80, data.getDcGoldenRoutingName());
            ps.setString(81, data.getDcCode());
            ps.setString(82, data.getDcNeedPkgWorkOrder());
            ps.setString(83, data.getDcWeatherCustPoSpecifiesMatNo());
            ps.setString(84, data.getDcPackageType());
            ps.setString(85, data.getDcProcess());
            ps.setString(86, data.getDcWaferOutsourceType());
            ps.setString(87, data.getDcDeliveryMethod());
            ps.setString(88, data.getDcSpecialFactoryMatStatus());
            ps.setString(89, data.getZ019CustColumn1());
            ps.setString(90, data.getZ019CustColumn2());
            ps.setString(91, data.getZ019CustColumn3());
            ps.setString(92, data.getZ019CustColumn4());
            ps.setString(93, data.getZ013015CustColumn1());
            ps.setString(94, data.getZ013015CustColumn2());
            ps.setString(95, data.getZ013015CustColumn3());
            ps.setString(96, data.getZ013015CustColumn4());
            ps.setString(97, data.getDcCustColumn1());
            ps.setString(98, data.getDcCustColumn2());
            ps.setString(99, data.getDcCustColumn3());
            ps.setString(100, data.getDcCustColumn4());
            ps.setString(101, data.getCreater());
            DateUtils.setDateTz(ps, 102, data.getCreateTime());
            ps.setString(103, data.getUpdater());
            DateUtils.setDateTz(ps, 104, data.getUpdateTime());
            ps.setBigDecimal(105, data.getWorkOrderNum());
            ps.setString(106, data.getZ019SapMatnr());
            ps.setString(107, data.getZ013015SapMatnr());
            ps.setString(108, data.getDcSapMatnr());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PdmProjectSAPMaterialNoRequestInfoV2 data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getOaId());
            ps.setString(2, data.getStatus());
            ps.setString(3, data.getProjectEnginerA());
            ps.setString(4, data.getProjectEnginerAName());
            ps.setString(5, data.getProjectEnginerB());
            ps.setString(6, data.getProjectEnginerBName());
            ps.setString(7, data.getRequester());
            ps.setString(8, data.getRequesterName());
            ps.setString(9, data.getRequesterDept());
            ps.setString(10, data.getRequestDate());
            ps.setString(11, data.getMaterialType1());
            ps.setString(12, data.getMaterialType2());
            ps.setString(13, data.getFactoryDevice());
            ps.setString(14, data.getCustCode());
            ps.setString(15, data.getWaferSize());
            ps.setBigDecimal(16, data.getGrossDie());
            ps.setString(17, data.getDivision());
            ps.setString(18, data.getProfitCenterName());
            ps.setString(19, data.getProfitCenterCode());
            ps.setString(20, data.getIndustrySector());
            ps.setString(21, data.getOriginalGroupName());
            ps.setString(22, data.getOriginalGroupCode());
            ps.setString(23, data.getTradeType());
            ps.setString(24, data.getFactoryCode());
            ps.setString(25, data.getSalesGroup());
            ps.setString(26, data.getDistributionChannels());
            ps.setString(27, data.getZ019FactoryMaterialNo());
            ps.setString(28, data.getZ019MaterialType());
            ps.setString(29, data.getZ019MaterialGroupCode());
            ps.setString(30, data.getZ019MaterialDesc());
            ps.setString(31, data.getZ019FabdeviceGroup());
            ps.setString(32, data.getZ019Fabdevice());
            ps.setString(33, data.getZ019NeedMap());
            ps.setString(34, data.getZ019NeedMarking());
            ps.setString(35, data.getZ019ExternalProcurementStorageLocation());
            ps.setString(36, data.getZ019StorageCode());
            ps.setString(37, data.getZ019OutsourceType());
            ps.setString(38, data.getZ019OutsourceReturnMaterialNo());
            ps.setString(39, data.getZ019NeedPkgWorkOrder());
            ps.setString(40, data.getZ019WeatherCustPoSpecifiesMatNo());
            ps.setString(41, data.getZ019Code());
            ps.setString(42, data.getZ019WaferFactory());
            ps.setString(43, data.getZ013015FactoryMaterialNo());
            ps.setString(44, data.getZ013015MaterialType());
            ps.setString(45, data.getZ013015MaterialGroupCode());
            ps.setString(46, data.getZ013015Type());
            ps.setString(47, data.getZ013015CustDeviceGroup());
            ps.setString(48, data.getZ013015FabdeviceGroup());
            ps.setString(49, data.getZ013015TerminalApp());
            ps.setString(50, data.getZ013015MaterialGroupCodeOutside());
            ps.setString(51, data.getZ013015CustDevice());
            ps.setString(52, data.getZ013015Fabdevice());
            ps.setString(53, data.getZ013015MaterialDesc());
            ps.setString(54, data.getZ013015Code());
            ps.setString(55, data.getZ013015GoldenRoutingName());
            ps.setString(56, data.getZ013015Process());
            ps.setString(57, data.getZ013015NeedMap());
            ps.setString(58, data.getZ013015NeedMarking());
            ps.setString(59, data.getZ013015PackageType());
            ps.setString(60, data.getZ013015DeliveryMethod());
            ps.setString(61, data.getZ013015NeedPkgWorkOrder());
            ps.setString(62, data.getZ013015WeatherCustPoSpecifiesMatNo());
            ps.setString(63, data.getZ013015SpecialFactoryMatStatus());
            ps.setString(64, data.getZ013015OutsourceType());
            ps.setString(65, data.getZ013015OutsourceReturnMaterialNo());
            ps.setString(66, data.getZ013015App());
            ps.setString(67, data.getDcFactoryMaterialNo());
            ps.setString(68, data.getDcMaterialType());
            ps.setString(69, data.getDcMaterialGroupCode());
            ps.setString(70, data.getDcMaterialGroupCodeOutside());
            ps.setString(71, data.getDcCustDeviceGroup());
            ps.setString(72, data.getDcPieceType());
            ps.setString(73, data.getDcMaterialDesc());
            ps.setString(74, data.getDcType());
            ps.setString(75, data.getDcCustDevice());
            ps.setString(76, data.getDcFabdeviceGroup());
            ps.setString(77, data.getDcNeedMap());
            ps.setString(78, data.getDcNeedMarking());
            ps.setString(79, data.getDcGoldenRoutingName());
            ps.setString(80, data.getDcCode());
            ps.setString(81, data.getDcNeedPkgWorkOrder());
            ps.setString(82, data.getDcWeatherCustPoSpecifiesMatNo());
            ps.setString(83, data.getDcPackageType());
            ps.setString(84, data.getDcProcess());
            ps.setString(85, data.getDcWaferOutsourceType());
            ps.setString(86, data.getDcDeliveryMethod());
            ps.setString(87, data.getDcSpecialFactoryMatStatus());
            ps.setString(88, data.getZ019CustColumn1());
            ps.setString(89, data.getZ019CustColumn2());
            ps.setString(90, data.getZ019CustColumn3());
            ps.setString(91, data.getZ019CustColumn4());
            ps.setString(92, data.getZ013015CustColumn1());
            ps.setString(93, data.getZ013015CustColumn2());
            ps.setString(94, data.getZ013015CustColumn3());
            ps.setString(95, data.getZ013015CustColumn4());
            ps.setString(96, data.getDcCustColumn1());
            ps.setString(97, data.getDcCustColumn2());
            ps.setString(98, data.getDcCustColumn3());
            ps.setString(99, data.getDcCustColumn4());
            ps.setString(100, data.getCreater());
            DateUtils.setDateTz(ps, 101, data.getCreateTime());
            ps.setString(102, data.getUpdater());
            DateUtils.setDateTz(ps, 103, data.getUpdateTime());
            ps.setBigDecimal(104, data.getWorkOrderNum());
            ps.setString(105, data.getZ019SapMatnr());
            ps.setString(106, data.getZ013015SapMatnr());
            ps.setString(107, data.getDcSapMatnr());
            ps.setString(108, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PdmProjectSAPMaterialNoRequestInfoV2> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PdmProjectSAPMaterialNoRequestInfoV2 data : dataList) {
            ps.setBigDecimal(1, data.getOaId());
            ps.setString(2, data.getStatus());
            ps.setString(3, data.getProjectEnginerA());
            ps.setString(4, data.getProjectEnginerAName());
            ps.setString(5, data.getProjectEnginerB());
            ps.setString(6, data.getProjectEnginerBName());
            ps.setString(7, data.getRequester());
            ps.setString(8, data.getRequesterName());
            ps.setString(9, data.getRequesterDept());
            ps.setString(10, data.getRequestDate());
            ps.setString(11, data.getMaterialType1());
            ps.setString(12, data.getMaterialType2());
            ps.setString(13, data.getFactoryDevice());
            ps.setString(14, data.getCustCode());
            ps.setString(15, data.getWaferSize());
            ps.setBigDecimal(16, data.getGrossDie());
            ps.setString(17, data.getDivision());
            ps.setString(18, data.getProfitCenterName());
            ps.setString(19, data.getProfitCenterCode());
            ps.setString(20, data.getIndustrySector());
            ps.setString(21, data.getOriginalGroupName());
            ps.setString(22, data.getOriginalGroupCode());
            ps.setString(23, data.getTradeType());
            ps.setString(24, data.getFactoryCode());
            ps.setString(25, data.getSalesGroup());
            ps.setString(26, data.getDistributionChannels());
            ps.setString(27, data.getZ019FactoryMaterialNo());
            ps.setString(28, data.getZ019MaterialType());
            ps.setString(29, data.getZ019MaterialGroupCode());
            ps.setString(30, data.getZ019MaterialDesc());
            ps.setString(31, data.getZ019FabdeviceGroup());
            ps.setString(32, data.getZ019Fabdevice());
            ps.setString(33, data.getZ019NeedMap());
            ps.setString(34, data.getZ019NeedMarking());
            ps.setString(35, data.getZ019ExternalProcurementStorageLocation());
            ps.setString(36, data.getZ019StorageCode());
            ps.setString(37, data.getZ019OutsourceType());
            ps.setString(38, data.getZ019OutsourceReturnMaterialNo());
            ps.setString(39, data.getZ019NeedPkgWorkOrder());
            ps.setString(40, data.getZ019WeatherCustPoSpecifiesMatNo());
            ps.setString(41, data.getZ019Code());
            ps.setString(42, data.getZ019WaferFactory());
            ps.setString(43, data.getZ013015FactoryMaterialNo());
            ps.setString(44, data.getZ013015MaterialType());
            ps.setString(45, data.getZ013015MaterialGroupCode());
            ps.setString(46, data.getZ013015Type());
            ps.setString(47, data.getZ013015CustDeviceGroup());
            ps.setString(48, data.getZ013015FabdeviceGroup());
            ps.setString(49, data.getZ013015TerminalApp());
            ps.setString(50, data.getZ013015MaterialGroupCodeOutside());
            ps.setString(51, data.getZ013015CustDevice());
            ps.setString(52, data.getZ013015Fabdevice());
            ps.setString(53, data.getZ013015MaterialDesc());
            ps.setString(54, data.getZ013015Code());
            ps.setString(55, data.getZ013015GoldenRoutingName());
            ps.setString(56, data.getZ013015Process());
            ps.setString(57, data.getZ013015NeedMap());
            ps.setString(58, data.getZ013015NeedMarking());
            ps.setString(59, data.getZ013015PackageType());
            ps.setString(60, data.getZ013015DeliveryMethod());
            ps.setString(61, data.getZ013015NeedPkgWorkOrder());
            ps.setString(62, data.getZ013015WeatherCustPoSpecifiesMatNo());
            ps.setString(63, data.getZ013015SpecialFactoryMatStatus());
            ps.setString(64, data.getZ013015OutsourceType());
            ps.setString(65, data.getZ013015OutsourceReturnMaterialNo());
            ps.setString(66, data.getZ013015App());
            ps.setString(67, data.getDcFactoryMaterialNo());
            ps.setString(68, data.getDcMaterialType());
            ps.setString(69, data.getDcMaterialGroupCode());
            ps.setString(70, data.getDcMaterialGroupCodeOutside());
            ps.setString(71, data.getDcCustDeviceGroup());
            ps.setString(72, data.getDcPieceType());
            ps.setString(73, data.getDcMaterialDesc());
            ps.setString(74, data.getDcType());
            ps.setString(75, data.getDcCustDevice());
            ps.setString(76, data.getDcFabdeviceGroup());
            ps.setString(77, data.getDcNeedMap());
            ps.setString(78, data.getDcNeedMarking());
            ps.setString(79, data.getDcGoldenRoutingName());
            ps.setString(80, data.getDcCode());
            ps.setString(81, data.getDcNeedPkgWorkOrder());
            ps.setString(82, data.getDcWeatherCustPoSpecifiesMatNo());
            ps.setString(83, data.getDcPackageType());
            ps.setString(84, data.getDcProcess());
            ps.setString(85, data.getDcWaferOutsourceType());
            ps.setString(86, data.getDcDeliveryMethod());
            ps.setString(87, data.getDcSpecialFactoryMatStatus());
            ps.setString(88, data.getZ019CustColumn1());
            ps.setString(89, data.getZ019CustColumn2());
            ps.setString(90, data.getZ019CustColumn3());
            ps.setString(91, data.getZ019CustColumn4());
            ps.setString(92, data.getZ013015CustColumn1());
            ps.setString(93, data.getZ013015CustColumn2());
            ps.setString(94, data.getZ013015CustColumn3());
            ps.setString(95, data.getZ013015CustColumn4());
            ps.setString(96, data.getDcCustColumn1());
            ps.setString(97, data.getDcCustColumn2());
            ps.setString(98, data.getDcCustColumn3());
            ps.setString(99, data.getDcCustColumn4());
            ps.setString(100, data.getCreater());
            DateUtils.setDateTz(ps, 101, data.getCreateTime());
            ps.setString(102, data.getUpdater());
            DateUtils.setDateTz(ps, 103, data.getUpdateTime());
            ps.setBigDecimal(104, data.getWorkOrderNum());
            ps.setString(105, data.getZ019SapMatnr());
            ps.setString(106, data.getZ013015SapMatnr());
            ps.setString(107, data.getDcSapMatnr());
            ps.setString(108, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zm_pdm_project_sap_material_no_request_info_v2 WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<PdmProjectSAPMaterialNoRequestInfoV2> selectAll() throws SQLException {
        ArrayList<PdmProjectSAPMaterialNoRequestInfoV2> result = new ArrayList<PdmProjectSAPMaterialNoRequestInfoV2>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PdmProjectSAPMaterialNoRequestInfoV2 selectByPK(String uuid) throws SQLException {
        PdmProjectSAPMaterialNoRequestInfoV2 result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public PdmProjectSAPMaterialNoRequestInfoV2 selectByItemBo(String itemBo) throws SQLException {
        PdmProjectSAPMaterialNoRequestInfoV2 result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE Z013_015_FACTORY_MATERIAL_NO=?")) {
            ps.setString(1, itemBo);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    
    private PdmProjectSAPMaterialNoRequestInfoV2 convert(ResultSet rs) throws SQLException {
        PdmProjectSAPMaterialNoRequestInfoV2 data = new PdmProjectSAPMaterialNoRequestInfoV2();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setOaId(rs.getBigDecimal(index++));
        data.setStatus(rs.getString(index++));
        data.setProjectEnginerA(rs.getString(index++));
        data.setProjectEnginerAName(rs.getString(index++));
        data.setProjectEnginerB(rs.getString(index++));
        data.setProjectEnginerBName(rs.getString(index++));
        data.setRequester(rs.getString(index++));
        data.setRequesterName(rs.getString(index++));
        data.setRequesterDept(rs.getString(index++));
        data.setRequestDate(rs.getString(index++));
        data.setMaterialType1(rs.getString(index++));
        data.setMaterialType2(rs.getString(index++));
        data.setFactoryDevice(rs.getString(index++));
        data.setCustCode(rs.getString(index++));
        data.setWaferSize(rs.getString(index++));
        data.setGrossDie(rs.getBigDecimal(index++));
        data.setDivision(rs.getString(index++));
        data.setProfitCenterName(rs.getString(index++));
        data.setProfitCenterCode(rs.getString(index++));
        data.setIndustrySector(rs.getString(index++));
        data.setOriginalGroupName(rs.getString(index++));
        data.setOriginalGroupCode(rs.getString(index++));
        data.setTradeType(rs.getString(index++));
        data.setFactoryCode(rs.getString(index++));
        data.setSalesGroup(rs.getString(index++));
        data.setDistributionChannels(rs.getString(index++));
        data.setZ019FactoryMaterialNo(rs.getString(index++));
        data.setZ019MaterialType(rs.getString(index++));
        data.setZ019MaterialGroupCode(rs.getString(index++));
        data.setZ019MaterialDesc(rs.getString(index++));
        data.setZ019FabdeviceGroup(rs.getString(index++));
        data.setZ019Fabdevice(rs.getString(index++));
        data.setZ019NeedMap(rs.getString(index++));
        data.setZ019NeedMarking(rs.getString(index++));
        data.setZ019ExternalProcurementStorageLocation(rs.getString(index++));
        data.setZ019StorageCode(rs.getString(index++));
        data.setZ019OutsourceType(rs.getString(index++));
        data.setZ019OutsourceReturnMaterialNo(rs.getString(index++));
        data.setZ019NeedPkgWorkOrder(rs.getString(index++));
        data.setZ019WeatherCustPoSpecifiesMatNo(rs.getString(index++));
        data.setZ019Code(rs.getString(index++));
        data.setZ019WaferFactory(rs.getString(index++));
        data.setZ013015FactoryMaterialNo(rs.getString(index++));
        data.setZ013015MaterialType(rs.getString(index++));
        data.setZ013015MaterialGroupCode(rs.getString(index++));
        data.setZ013015Type(rs.getString(index++));
        data.setZ013015CustDeviceGroup(rs.getString(index++));
        data.setZ013015FabdeviceGroup(rs.getString(index++));
        data.setZ013015TerminalApp(rs.getString(index++));
        data.setZ013015MaterialGroupCodeOutside(rs.getString(index++));
        data.setZ013015CustDevice(rs.getString(index++));
        data.setZ013015Fabdevice(rs.getString(index++));
        data.setZ013015MaterialDesc(rs.getString(index++));
        data.setZ013015Code(rs.getString(index++));
        data.setZ013015GoldenRoutingName(rs.getString(index++));
        data.setZ013015Process(rs.getString(index++));
        data.setZ013015NeedMap(rs.getString(index++));
        data.setZ013015NeedMarking(rs.getString(index++));
        data.setZ013015PackageType(rs.getString(index++));
        data.setZ013015DeliveryMethod(rs.getString(index++));
        data.setZ013015NeedPkgWorkOrder(rs.getString(index++));
        data.setZ013015WeatherCustPoSpecifiesMatNo(rs.getString(index++));
        data.setZ013015SpecialFactoryMatStatus(rs.getString(index++));
        data.setZ013015OutsourceType(rs.getString(index++));
        data.setZ013015OutsourceReturnMaterialNo(rs.getString(index++));
        data.setZ013015App(rs.getString(index++));
        data.setDcFactoryMaterialNo(rs.getString(index++));
        data.setDcMaterialType(rs.getString(index++));
        data.setDcMaterialGroupCode(rs.getString(index++));
        data.setDcMaterialGroupCodeOutside(rs.getString(index++));
        data.setDcCustDeviceGroup(rs.getString(index++));
        data.setDcPieceType(rs.getString(index++));
        data.setDcMaterialDesc(rs.getString(index++));
        data.setDcType(rs.getString(index++));
        data.setDcCustDevice(rs.getString(index++));
        data.setDcFabdeviceGroup(rs.getString(index++));
        data.setDcNeedMap(rs.getString(index++));
        data.setDcNeedMarking(rs.getString(index++));
        data.setDcGoldenRoutingName(rs.getString(index++));
        data.setDcCode(rs.getString(index++));
        data.setDcNeedPkgWorkOrder(rs.getString(index++));
        data.setDcWeatherCustPoSpecifiesMatNo(rs.getString(index++));
        data.setDcPackageType(rs.getString(index++));
        data.setDcProcess(rs.getString(index++));
        data.setDcWaferOutsourceType(rs.getString(index++));
        data.setDcDeliveryMethod(rs.getString(index++));
        data.setDcSpecialFactoryMatStatus(rs.getString(index++));
        data.setZ019CustColumn1(rs.getString(index++));
        data.setZ019CustColumn2(rs.getString(index++));
        data.setZ019CustColumn3(rs.getString(index++));
        data.setZ019CustColumn4(rs.getString(index++));
        data.setZ013015CustColumn1(rs.getString(index++));
        data.setZ013015CustColumn2(rs.getString(index++));
        data.setZ013015CustColumn3(rs.getString(index++));
        data.setZ013015CustColumn4(rs.getString(index++));
        data.setDcCustColumn1(rs.getString(index++));
        data.setDcCustColumn2(rs.getString(index++));
        data.setDcCustColumn3(rs.getString(index++));
        data.setDcCustColumn4(rs.getString(index++));
        data.setCreater(rs.getString(index++));
        data.setCreateTime(DateUtils.getDateTz(rs, index++));
        data.setUpdater(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));
        data.setWorkOrderNum(rs.getBigDecimal(index++));
        data.setZ019SapMatnr(rs.getString(index++));
        data.setZ013015SapMatnr(rs.getString(index++));
        data.setDcSapMatnr(rs.getString(index++));

        return data;
    }
}
