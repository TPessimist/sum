package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.CdmMoHeader;
import uia.utils.dao.DateUtils;

public class CdmMoHeaderDao {

    private static final String SQL_INS = "INSERT INTO zm_cdm_mo_header(mo_type,mo_id,sap_mo_id,cust_code,customer_device,ht_pn,product_pn,sap_product_pn,fab_device,wafer_pn,plan_start_date,plan_end_date,mo_priority,mo_dc,lot_qty,wafer_qty,die_qty,po_id,po_item,so_id,so_item,create_by,create_date,update_by,update_date,flag,flag2,remark1,remark2,remark3,request_json,response_json,id,first_commit_date,request_content,response_content) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zm_cdm_mo_header SET mo_type=?,sap_mo_id=?,cust_code=?,customer_device=?,ht_pn=?,product_pn=?,sap_product_pn=?,fab_device=?,wafer_pn=?,plan_start_date=?,plan_end_date=?,mo_priority=?,mo_dc=?,lot_qty=?,wafer_qty=?,die_qty=?,po_id=?,po_item=?,so_id=?,so_item=?,create_by=?,create_date=?,update_by=?,update_date=?,flag=?,flag2=?,remark1=?,remark2=?,remark3=?,request_json=?,response_json=?,id=?,first_commit_date=?,request_content=?,response_content=? WHERE mo_id=?";

    private static final String SQL_SEL = "SELECT mo_type,mo_id,sap_mo_id,cust_code,customer_device,ht_pn,product_pn,sap_product_pn,fab_device,wafer_pn,plan_start_date,plan_end_date,mo_priority,mo_dc,lot_qty,wafer_qty,die_qty,po_id,po_item,so_id,so_item,create_by,create_date,update_by,update_date,flag,flag2,remark1,remark2,remark3,request_json,response_json,id,first_commit_date,request_content,response_content FROM zm_cdm_mo_header ";
    
    private final Connection conn;

    public CdmMoHeaderDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(CdmMoHeader data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getMoType());
            ps.setString(2, data.getMoId());
            ps.setString(3, data.getSapMoId());
            ps.setString(4, data.getCustCode());
            ps.setString(5, data.getCustomerDevice());
            ps.setString(6, data.getHtPn());
            ps.setString(7, data.getProductPn());
            ps.setString(8, data.getSapProductPn());
            ps.setString(9, data.getFabDevice());
            ps.setString(10, data.getWaferPn());
            ps.setString(11, data.getPlanStartDate());
            ps.setString(12, data.getPlanEndDate());
            ps.setString(13, data.getMoPriority());
            ps.setString(14, data.getMoDc());
            ps.setString(15, data.getLotQty());
            ps.setString(16, data.getWaferQty());
            ps.setString(17, data.getDieQty());
            ps.setString(18, data.getPoId());
            ps.setString(19, data.getPoItem());
            ps.setString(20, data.getSoId());
            ps.setString(21, data.getSoItem());
            ps.setString(22, data.getCreateBy());
            DateUtils.setDateTz(ps, 23, data.getCreateDate());
            ps.setString(24, data.getUpdateBy());
            DateUtils.setDateTz(ps, 25, data.getUpdateDate());
            ps.setString(26, data.getFlag());
            ps.setString(27, data.getFlag2());
            ps.setString(28, data.getRemark1());
            ps.setString(29, data.getRemark2());
            ps.setString(30, data.getRemark3());
            ps.setString(31, data.getRequestJson());
            ps.setString(32, data.getResponseJson());
            ps.setString(33, data.getId());
            ps.setString(34, data.getFirstCommitDate());
            ps.setString(35, data.getRequestContent());
            ps.setString(36, data.getResponseContent());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<CdmMoHeader> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(CdmMoHeader data : dataList) {
            ps.setString(1, data.getMoType());
            ps.setString(2, data.getMoId());
            ps.setString(3, data.getSapMoId());
            ps.setString(4, data.getCustCode());
            ps.setString(5, data.getCustomerDevice());
            ps.setString(6, data.getHtPn());
            ps.setString(7, data.getProductPn());
            ps.setString(8, data.getSapProductPn());
            ps.setString(9, data.getFabDevice());
            ps.setString(10, data.getWaferPn());
            ps.setString(11, data.getPlanStartDate());
            ps.setString(12, data.getPlanEndDate());
            ps.setString(13, data.getMoPriority());
            ps.setString(14, data.getMoDc());
            ps.setString(15, data.getLotQty());
            ps.setString(16, data.getWaferQty());
            ps.setString(17, data.getDieQty());
            ps.setString(18, data.getPoId());
            ps.setString(19, data.getPoItem());
            ps.setString(20, data.getSoId());
            ps.setString(21, data.getSoItem());
            ps.setString(22, data.getCreateBy());
            DateUtils.setDateTz(ps, 23, data.getCreateDate());
            ps.setString(24, data.getUpdateBy());
            DateUtils.setDateTz(ps, 25, data.getUpdateDate());
            ps.setString(26, data.getFlag());
            ps.setString(27, data.getFlag2());
            ps.setString(28, data.getRemark1());
            ps.setString(29, data.getRemark2());
            ps.setString(30, data.getRemark3());
            ps.setString(31, data.getRequestJson());
            ps.setString(32, data.getResponseJson());
            ps.setString(33, data.getId());
            ps.setString(34, data.getFirstCommitDate());
            ps.setString(35, data.getRequestContent());
            ps.setString(36, data.getResponseContent());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(CdmMoHeader data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getMoType());
            ps.setString(2, data.getSapMoId());
            ps.setString(3, data.getCustCode());
            ps.setString(4, data.getCustomerDevice());
            ps.setString(5, data.getHtPn());
            ps.setString(6, data.getProductPn());
            ps.setString(7, data.getSapProductPn());
            ps.setString(8, data.getFabDevice());
            ps.setString(9, data.getWaferPn());
            ps.setString(10, data.getPlanStartDate());
            ps.setString(11, data.getPlanEndDate());
            ps.setString(12, data.getMoPriority());
            ps.setString(13, data.getMoDc());
            ps.setString(14, data.getLotQty());
            ps.setString(15, data.getWaferQty());
            ps.setString(16, data.getDieQty());
            ps.setString(17, data.getPoId());
            ps.setString(18, data.getPoItem());
            ps.setString(19, data.getSoId());
            ps.setString(20, data.getSoItem());
            ps.setString(21, data.getCreateBy());
            DateUtils.setDateTz(ps, 22, data.getCreateDate());
            ps.setString(23, data.getUpdateBy());
            DateUtils.setDateTz(ps, 24, data.getUpdateDate());
            ps.setString(25, data.getFlag());
            ps.setString(26, data.getFlag2());
            ps.setString(27, data.getRemark1());
            ps.setString(28, data.getRemark2());
            ps.setString(29, data.getRemark3());
            ps.setString(30, data.getRequestJson());
            ps.setString(31, data.getResponseJson());
            ps.setString(32, data.getId());
            ps.setString(33, data.getFirstCommitDate());
            ps.setString(34, data.getRequestContent());
            ps.setString(35, data.getResponseContent());
            ps.setString(36, data.getMoId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<CdmMoHeader> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(CdmMoHeader data : dataList) {
            ps.setString(1, data.getMoType());
            ps.setString(2, data.getSapMoId());
            ps.setString(3, data.getCustCode());
            ps.setString(4, data.getCustomerDevice());
            ps.setString(5, data.getHtPn());
            ps.setString(6, data.getProductPn());
            ps.setString(7, data.getSapProductPn());
            ps.setString(8, data.getFabDevice());
            ps.setString(9, data.getWaferPn());
            ps.setString(10, data.getPlanStartDate());
            ps.setString(11, data.getPlanEndDate());
            ps.setString(12, data.getMoPriority());
            ps.setString(13, data.getMoDc());
            ps.setString(14, data.getLotQty());
            ps.setString(15, data.getWaferQty());
            ps.setString(16, data.getDieQty());
            ps.setString(17, data.getPoId());
            ps.setString(18, data.getPoItem());
            ps.setString(19, data.getSoId());
            ps.setString(20, data.getSoItem());
            ps.setString(21, data.getCreateBy());
            DateUtils.setDateTz(ps, 22, data.getCreateDate());
            ps.setString(23, data.getUpdateBy());
            DateUtils.setDateTz(ps, 24, data.getUpdateDate());
            ps.setString(25, data.getFlag());
            ps.setString(26, data.getFlag2());
            ps.setString(27, data.getRemark1());
            ps.setString(28, data.getRemark2());
            ps.setString(29, data.getRemark3());
            ps.setString(30, data.getRequestJson());
            ps.setString(31, data.getResponseJson());
            ps.setString(32, data.getId());
            ps.setString(33, data.getFirstCommitDate());
            ps.setString(34, data.getRequestContent());
            ps.setString(35, data.getResponseContent());
            ps.setString(36, data.getMoId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String moId) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zm_cdm_mo_header WHERE mo_id=?")) {
            ps.setString(1, moId);

            return ps.executeUpdate();
        }
    }    

    public List<CdmMoHeader> selectAll() throws SQLException {
        ArrayList<CdmMoHeader> result = new ArrayList<CdmMoHeader>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public CdmMoHeader selectByPK(String moId) throws SQLException {
        CdmMoHeader result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE mo_id=?")) {
            ps.setString(1, moId);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private CdmMoHeader convert(ResultSet rs) throws SQLException {
        CdmMoHeader data = new CdmMoHeader();
        
        int index = 1;
        data.setMoType(rs.getString(index++));
        data.setMoId(rs.getString(index++));
        data.setSapMoId(rs.getString(index++));
        data.setCustCode(rs.getString(index++));
        data.setCustomerDevice(rs.getString(index++));
        data.setHtPn(rs.getString(index++));
        data.setProductPn(rs.getString(index++));
        data.setSapProductPn(rs.getString(index++));
        data.setFabDevice(rs.getString(index++));
        data.setWaferPn(rs.getString(index++));
        data.setPlanStartDate(rs.getString(index++));
        data.setPlanEndDate(rs.getString(index++));
        data.setMoPriority(rs.getString(index++));
        data.setMoDc(rs.getString(index++));
        data.setLotQty(rs.getString(index++));
        data.setWaferQty(rs.getString(index++));
        data.setDieQty(rs.getString(index++));
        data.setPoId(rs.getString(index++));
        data.setPoItem(rs.getString(index++));
        data.setSoId(rs.getString(index++));
        data.setSoItem(rs.getString(index++));
        data.setCreateBy(rs.getString(index++));
        data.setCreateDate(DateUtils.getDateTz(rs, index++));
        data.setUpdateBy(rs.getString(index++));
        data.setUpdateDate(DateUtils.getDateTz(rs, index++));
        data.setFlag(rs.getString(index++));
        data.setFlag2(rs.getString(index++));
        data.setRemark1(rs.getString(index++));
        data.setRemark2(rs.getString(index++));
        data.setRemark3(rs.getString(index++));
        data.setRequestJson(rs.getString(index++));
        data.setResponseJson(rs.getString(index++));
        data.setId(rs.getString(index++));
        data.setFirstCommitDate(rs.getString(index++));
        data.setRequestContent(rs.getString(index++));
        data.setResponseContent(rs.getString(index++));

        return data;
    }
}
