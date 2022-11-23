package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PdmProjectAffiliateWlpProductInfoV2;
import uia.utils.dao.DateUtils;

public class PdmProjectAffiliateWlpProductInfoV2Dao {

    private static final String SQL_INS = "INSERT INTO zm_pdm_project_affiliate_repository_wlp_product_basic_info_main_v2(oa_id,factory_work_order_type,p_cust_device_name,device_difference,cust_code,cust_device_1,cust_device_2,cust_device_3,fab_device_1,fab_device_2,fab_device_3,factory_device_1,factory_device_2,factory_device_3,project_is_closed,basis_of_project_closed_file_path,creater,create_time,updater,update_time,status,uuid,project_engineer_a,project_engineer_name_a,project_engineer_b,project_engineer_name_b,first_workorder_end_station,second_workorder_end_station,cust_device,project_status,project_engineer_leader,project_engineer_leader_name,flag,bom_flag,mes_flag,fab_device,factory_device,ref_factory_device,ref_cust_device,ref_fab_device,pkg_type,pkg_structure,oa_flag,z019_factory_material_no,z013_015_factory_material_no,dc_factory_material_no,z019_sap_matnr,z013_015_sap_matnr,dc_sap_matnr) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zm_pdm_project_affiliate_repository_wlp_product_basic_info_main_v2 SET oa_id=?,factory_work_order_type=?,p_cust_device_name=?,device_difference=?,cust_code=?,cust_device_1=?,cust_device_2=?,cust_device_3=?,fab_device_1=?,fab_device_2=?,fab_device_3=?,factory_device_1=?,factory_device_2=?,factory_device_3=?,project_is_closed=?,basis_of_project_closed_file_path=?,creater=?,create_time=?,updater=?,update_time=?,status=?,project_engineer_a=?,project_engineer_name_a=?,project_engineer_b=?,project_engineer_name_b=?,first_workorder_end_station=?,second_workorder_end_station=?,cust_device=?,project_status=?,project_engineer_leader=?,project_engineer_leader_name=?,flag=?,bom_flag=?,mes_flag=?,fab_device=?,factory_device=?,ref_factory_device=?,ref_cust_device=?,ref_fab_device=?,pkg_type=?,pkg_structure=?,oa_flag=?,z019_factory_material_no=?,z013_015_factory_material_no=?,dc_factory_material_no=?,z019_sap_matnr=?,z013_015_sap_matnr=?,dc_sap_matnr=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT oa_id,factory_work_order_type,p_cust_device_name,device_difference,cust_code,cust_device_1,cust_device_2,cust_device_3,fab_device_1,fab_device_2,fab_device_3,factory_device_1,factory_device_2,factory_device_3,project_is_closed,basis_of_project_closed_file_path,creater,create_time,updater,update_time,status,uuid,project_engineer_a,project_engineer_name_a,project_engineer_b,project_engineer_name_b,first_workorder_end_station,second_workorder_end_station,cust_device,project_status,project_engineer_leader,project_engineer_leader_name,flag,bom_flag,mes_flag,fab_device,factory_device,ref_factory_device,ref_cust_device,ref_fab_device,pkg_type,pkg_structure,oa_flag,z019_factory_material_no,z013_015_factory_material_no,dc_factory_material_no,z019_sap_matnr,z013_015_sap_matnr,dc_sap_matnr FROM zm_pdm_project_affiliate_repository_wlp_product_basic_info_main_v2 ";
    
    private final Connection conn;

    public PdmProjectAffiliateWlpProductInfoV2Dao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PdmProjectAffiliateWlpProductInfoV2 data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setBigDecimal(1, data.getOaId());
            ps.setString(2, data.getFactoryWorkOrderType());
            ps.setString(3, data.getPCustDeviceName());
            ps.setString(4, data.getDeviceDifference());
            ps.setString(5, data.getCustCode());
            ps.setString(6, data.getCustDevice1());
            ps.setString(7, data.getCustDevice2());
            ps.setString(8, data.getCustDevice3());
            ps.setString(9, data.getFabDevice1());
            ps.setString(10, data.getFabDevice2());
            ps.setString(11, data.getFabDevice3());
            ps.setString(12, data.getFactoryDevice1());
            ps.setString(13, data.getFactoryDevice2());
            ps.setString(14, data.getFactoryDevice3());
            ps.setString(15, data.getProjectIsClosed());
            ps.setString(16, data.getBasisOfProjectClosedFilePath());
            ps.setString(17, data.getCreater());
            DateUtils.setDateTz(ps, 18, data.getCreateTime());
            ps.setString(19, data.getUpdater());
            DateUtils.setDateTz(ps, 20, data.getUpdateTime());
            ps.setString(21, data.getStatus());
            ps.setString(22, data.getUuid());
            ps.setString(23, data.getProjectEngineerA());
            ps.setString(24, data.getProjectEngineerNameA());
            ps.setString(25, data.getProjectEngineerB());
            ps.setString(26, data.getProjectEngineerNameB());
            ps.setString(27, data.getFirstWorkorderEndStation());
            ps.setString(28, data.getSecondWorkorderEndStation());
            ps.setString(29, data.getCustDevice());
            ps.setString(30, data.getProjectStatus());
            ps.setString(31, data.getProjectEngineerLeader());
            ps.setString(32, data.getProjectEngineerLeaderName());
            ps.setString(33, data.getFlag());
            ps.setString(34, data.getBomFlag());
            ps.setString(35, data.getMesFlag());
            ps.setString(36, data.getFabDevice());
            ps.setString(37, data.getFactoryDevice());
            ps.setString(38, data.getRefFactoryDevice());
            ps.setString(39, data.getRefCustDevice());
            ps.setString(40, data.getRefFabDevice());
            ps.setString(41, data.getPkgType());
            ps.setString(42, data.getPkgStructure());
            ps.setString(43, data.getOaFlag());
            ps.setString(44, data.getZ019FactoryMaterialNo());
            ps.setString(45, data.getZ013015FactoryMaterialNo());
            ps.setString(46, data.getDcFactoryMaterialNo());
            ps.setString(47, data.getZ019SapMatnr());
            ps.setString(48, data.getZ013015SapMatnr());
            ps.setString(49, data.getDcSapMatnr());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PdmProjectAffiliateWlpProductInfoV2> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PdmProjectAffiliateWlpProductInfoV2 data : dataList) {
            ps.setBigDecimal(1, data.getOaId());
            ps.setString(2, data.getFactoryWorkOrderType());
            ps.setString(3, data.getPCustDeviceName());
            ps.setString(4, data.getDeviceDifference());
            ps.setString(5, data.getCustCode());
            ps.setString(6, data.getCustDevice1());
            ps.setString(7, data.getCustDevice2());
            ps.setString(8, data.getCustDevice3());
            ps.setString(9, data.getFabDevice1());
            ps.setString(10, data.getFabDevice2());
            ps.setString(11, data.getFabDevice3());
            ps.setString(12, data.getFactoryDevice1());
            ps.setString(13, data.getFactoryDevice2());
            ps.setString(14, data.getFactoryDevice3());
            ps.setString(15, data.getProjectIsClosed());
            ps.setString(16, data.getBasisOfProjectClosedFilePath());
            ps.setString(17, data.getCreater());
            DateUtils.setDateTz(ps, 18, data.getCreateTime());
            ps.setString(19, data.getUpdater());
            DateUtils.setDateTz(ps, 20, data.getUpdateTime());
            ps.setString(21, data.getStatus());
            ps.setString(22, data.getUuid());
            ps.setString(23, data.getProjectEngineerA());
            ps.setString(24, data.getProjectEngineerNameA());
            ps.setString(25, data.getProjectEngineerB());
            ps.setString(26, data.getProjectEngineerNameB());
            ps.setString(27, data.getFirstWorkorderEndStation());
            ps.setString(28, data.getSecondWorkorderEndStation());
            ps.setString(29, data.getCustDevice());
            ps.setString(30, data.getProjectStatus());
            ps.setString(31, data.getProjectEngineerLeader());
            ps.setString(32, data.getProjectEngineerLeaderName());
            ps.setString(33, data.getFlag());
            ps.setString(34, data.getBomFlag());
            ps.setString(35, data.getMesFlag());
            ps.setString(36, data.getFabDevice());
            ps.setString(37, data.getFactoryDevice());
            ps.setString(38, data.getRefFactoryDevice());
            ps.setString(39, data.getRefCustDevice());
            ps.setString(40, data.getRefFabDevice());
            ps.setString(41, data.getPkgType());
            ps.setString(42, data.getPkgStructure());
            ps.setString(43, data.getOaFlag());
            ps.setString(44, data.getZ019FactoryMaterialNo());
            ps.setString(45, data.getZ013015FactoryMaterialNo());
            ps.setString(46, data.getDcFactoryMaterialNo());
            ps.setString(47, data.getZ019SapMatnr());
            ps.setString(48, data.getZ013015SapMatnr());
            ps.setString(49, data.getDcSapMatnr());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PdmProjectAffiliateWlpProductInfoV2 data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getOaId());
            ps.setString(2, data.getFactoryWorkOrderType());
            ps.setString(3, data.getPCustDeviceName());
            ps.setString(4, data.getDeviceDifference());
            ps.setString(5, data.getCustCode());
            ps.setString(6, data.getCustDevice1());
            ps.setString(7, data.getCustDevice2());
            ps.setString(8, data.getCustDevice3());
            ps.setString(9, data.getFabDevice1());
            ps.setString(10, data.getFabDevice2());
            ps.setString(11, data.getFabDevice3());
            ps.setString(12, data.getFactoryDevice1());
            ps.setString(13, data.getFactoryDevice2());
            ps.setString(14, data.getFactoryDevice3());
            ps.setString(15, data.getProjectIsClosed());
            ps.setString(16, data.getBasisOfProjectClosedFilePath());
            ps.setString(17, data.getCreater());
            DateUtils.setDateTz(ps, 18, data.getCreateTime());
            ps.setString(19, data.getUpdater());
            DateUtils.setDateTz(ps, 20, data.getUpdateTime());
            ps.setString(21, data.getStatus());
            ps.setString(22, data.getProjectEngineerA());
            ps.setString(23, data.getProjectEngineerNameA());
            ps.setString(24, data.getProjectEngineerB());
            ps.setString(25, data.getProjectEngineerNameB());
            ps.setString(26, data.getFirstWorkorderEndStation());
            ps.setString(27, data.getSecondWorkorderEndStation());
            ps.setString(28, data.getCustDevice());
            ps.setString(29, data.getProjectStatus());
            ps.setString(30, data.getProjectEngineerLeader());
            ps.setString(31, data.getProjectEngineerLeaderName());
            ps.setString(32, data.getFlag());
            ps.setString(33, data.getBomFlag());
            ps.setString(34, data.getMesFlag());
            ps.setString(35, data.getFabDevice());
            ps.setString(36, data.getFactoryDevice());
            ps.setString(37, data.getRefFactoryDevice());
            ps.setString(38, data.getRefCustDevice());
            ps.setString(39, data.getRefFabDevice());
            ps.setString(40, data.getPkgType());
            ps.setString(41, data.getPkgStructure());
            ps.setString(42, data.getOaFlag());
            ps.setString(43, data.getZ019FactoryMaterialNo());
            ps.setString(44, data.getZ013015FactoryMaterialNo());
            ps.setString(45, data.getDcFactoryMaterialNo());
            ps.setString(46, data.getZ019SapMatnr());
            ps.setString(47, data.getZ013015SapMatnr());
            ps.setString(48, data.getDcSapMatnr());
            ps.setString(49, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PdmProjectAffiliateWlpProductInfoV2> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PdmProjectAffiliateWlpProductInfoV2 data : dataList) {
            ps.setBigDecimal(1, data.getOaId());
            ps.setString(2, data.getFactoryWorkOrderType());
            ps.setString(3, data.getPCustDeviceName());
            ps.setString(4, data.getDeviceDifference());
            ps.setString(5, data.getCustCode());
            ps.setString(6, data.getCustDevice1());
            ps.setString(7, data.getCustDevice2());
            ps.setString(8, data.getCustDevice3());
            ps.setString(9, data.getFabDevice1());
            ps.setString(10, data.getFabDevice2());
            ps.setString(11, data.getFabDevice3());
            ps.setString(12, data.getFactoryDevice1());
            ps.setString(13, data.getFactoryDevice2());
            ps.setString(14, data.getFactoryDevice3());
            ps.setString(15, data.getProjectIsClosed());
            ps.setString(16, data.getBasisOfProjectClosedFilePath());
            ps.setString(17, data.getCreater());
            DateUtils.setDateTz(ps, 18, data.getCreateTime());
            ps.setString(19, data.getUpdater());
            DateUtils.setDateTz(ps, 20, data.getUpdateTime());
            ps.setString(21, data.getStatus());
            ps.setString(22, data.getProjectEngineerA());
            ps.setString(23, data.getProjectEngineerNameA());
            ps.setString(24, data.getProjectEngineerB());
            ps.setString(25, data.getProjectEngineerNameB());
            ps.setString(26, data.getFirstWorkorderEndStation());
            ps.setString(27, data.getSecondWorkorderEndStation());
            ps.setString(28, data.getCustDevice());
            ps.setString(29, data.getProjectStatus());
            ps.setString(30, data.getProjectEngineerLeader());
            ps.setString(31, data.getProjectEngineerLeaderName());
            ps.setString(32, data.getFlag());
            ps.setString(33, data.getBomFlag());
            ps.setString(34, data.getMesFlag());
            ps.setString(35, data.getFabDevice());
            ps.setString(36, data.getFactoryDevice());
            ps.setString(37, data.getRefFactoryDevice());
            ps.setString(38, data.getRefCustDevice());
            ps.setString(39, data.getRefFabDevice());
            ps.setString(40, data.getPkgType());
            ps.setString(41, data.getPkgStructure());
            ps.setString(42, data.getOaFlag());
            ps.setString(43, data.getZ019FactoryMaterialNo());
            ps.setString(44, data.getZ013015FactoryMaterialNo());
            ps.setString(45, data.getDcFactoryMaterialNo());
            ps.setString(46, data.getZ019SapMatnr());
            ps.setString(47, data.getZ013015SapMatnr());
            ps.setString(48, data.getDcSapMatnr());
            ps.setString(49, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zm_pdm_project_affiliate_repository_wlp_product_basic_info_main_v2 WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<PdmProjectAffiliateWlpProductInfoV2> selectAll() throws SQLException {
        ArrayList<PdmProjectAffiliateWlpProductInfoV2> result = new ArrayList<PdmProjectAffiliateWlpProductInfoV2>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PdmProjectAffiliateWlpProductInfoV2 selectByPK(String uuid) throws SQLException {
        PdmProjectAffiliateWlpProductInfoV2 result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }


    public PdmProjectAffiliateWlpProductInfoV2 selectByItemBo(String itemBo) throws SQLException {
        PdmProjectAffiliateWlpProductInfoV2 result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE Z013_015_FACTORY_MATERIAL_NO=?")) {
            ps.setString(1, itemBo);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    private PdmProjectAffiliateWlpProductInfoV2 convert(ResultSet rs) throws SQLException {
        PdmProjectAffiliateWlpProductInfoV2 data = new PdmProjectAffiliateWlpProductInfoV2();
        
        int index = 1;
        data.setOaId(rs.getBigDecimal(index++));
        data.setFactoryWorkOrderType(rs.getString(index++));
        data.setPCustDeviceName(rs.getString(index++));
        data.setDeviceDifference(rs.getString(index++));
        data.setCustCode(rs.getString(index++));
        data.setCustDevice1(rs.getString(index++));
        data.setCustDevice2(rs.getString(index++));
        data.setCustDevice3(rs.getString(index++));
        data.setFabDevice1(rs.getString(index++));
        data.setFabDevice2(rs.getString(index++));
        data.setFabDevice3(rs.getString(index++));
        data.setFactoryDevice1(rs.getString(index++));
        data.setFactoryDevice2(rs.getString(index++));
        data.setFactoryDevice3(rs.getString(index++));
        data.setProjectIsClosed(rs.getString(index++));
        data.setBasisOfProjectClosedFilePath(rs.getString(index++));
        data.setCreater(rs.getString(index++));
        data.setCreateTime(DateUtils.getDateTz(rs, index++));
        data.setUpdater(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));
        data.setStatus(rs.getString(index++));
        data.setUuid(rs.getString(index++));
        data.setProjectEngineerA(rs.getString(index++));
        data.setProjectEngineerNameA(rs.getString(index++));
        data.setProjectEngineerB(rs.getString(index++));
        data.setProjectEngineerNameB(rs.getString(index++));
        data.setFirstWorkorderEndStation(rs.getString(index++));
        data.setSecondWorkorderEndStation(rs.getString(index++));
        data.setCustDevice(rs.getString(index++));
        data.setProjectStatus(rs.getString(index++));
        data.setProjectEngineerLeader(rs.getString(index++));
        data.setProjectEngineerLeaderName(rs.getString(index++));
        data.setFlag(rs.getString(index++));
        data.setBomFlag(rs.getString(index++));
        data.setMesFlag(rs.getString(index++));
        data.setFabDevice(rs.getString(index++));
        data.setFactoryDevice(rs.getString(index++));
        data.setRefFactoryDevice(rs.getString(index++));
        data.setRefCustDevice(rs.getString(index++));
        data.setRefFabDevice(rs.getString(index++));
        data.setPkgType(rs.getString(index++));
        data.setPkgStructure(rs.getString(index++));
        data.setOaFlag(rs.getString(index++));
        data.setZ019FactoryMaterialNo(rs.getString(index++));
        data.setZ013015FactoryMaterialNo(rs.getString(index++));
        data.setDcFactoryMaterialNo(rs.getString(index++));
        data.setZ019SapMatnr(rs.getString(index++));
        data.setZ013015SapMatnr(rs.getString(index++));
        data.setDcSapMatnr(rs.getString(index++));

        return data;
    }
}
