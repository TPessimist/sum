package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PkgRunSfcItem;
import uia.utils.dao.DateUtils;

public class PkgRunSfcItemDao {

    private static final String SQL_INS = "INSERT INTO zr_pkg_run_sfc_item(id,run_sfc_bo,sfc_bo,customer_item_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,router_bo,recipe_name,remark,run_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_pkg_run_sfc_item SET run_sfc_bo=?,sfc_bo=?,customer_item_bo=?,state_name=?,begin_time=?,end_time=?,run=?,resource_bo=?,operation_bo=?,router_bo=?,recipe_name=?,remark=?,run_user=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,run_sfc_bo,sfc_bo,customer_item_bo,state_name,begin_time,end_time,run,resource_bo,operation_bo,router_bo,recipe_name,remark,run_user FROM zr_pkg_run_sfc_item ";
    
    private final Connection conn;

    public PkgRunSfcItemDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PkgRunSfcItem data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getRunSfcBo());
            ps.setString(3, data.getSfcBo());
            ps.setString(4, data.getCustomerItemBo());
            ps.setString(5, data.getStateName());
            DateUtils.setDateTz(ps, 6, data.getBeginTime());
            DateUtils.setDateTz(ps, 7, data.getEndTime());
            ps.setString(8, data.getRun());
            ps.setString(9, data.getResourceBo());
            ps.setString(10, data.getOperationBo());
            ps.setString(11, data.getRouterBo());
            ps.setString(12, data.getRecipeName());
            ps.setString(13, data.getRemark());
            ps.setString(14, data.getRunUser());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PkgRunSfcItem> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PkgRunSfcItem data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getRunSfcBo());
            ps.setString(3, data.getSfcBo());
            ps.setString(4, data.getCustomerItemBo());
            ps.setString(5, data.getStateName());
            DateUtils.setDateTz(ps, 6, data.getBeginTime());
            DateUtils.setDateTz(ps, 7, data.getEndTime());
            ps.setString(8, data.getRun());
            ps.setString(9, data.getResourceBo());
            ps.setString(10, data.getOperationBo());
            ps.setString(11, data.getRouterBo());
            ps.setString(12, data.getRecipeName());
            ps.setString(13, data.getRemark());
            ps.setString(14, data.getRunUser());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PkgRunSfcItem data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getRunSfcBo());
            ps.setString(2, data.getSfcBo());
            ps.setString(3, data.getCustomerItemBo());
            ps.setString(4, data.getStateName());
            DateUtils.setDateTz(ps, 5, data.getBeginTime());
            DateUtils.setDateTz(ps, 6, data.getEndTime());
            ps.setString(7, data.getRun());
            ps.setString(8, data.getResourceBo());
            ps.setString(9, data.getOperationBo());
            ps.setString(10, data.getRouterBo());
            ps.setString(11, data.getRecipeName());
            ps.setString(12, data.getRemark());
            ps.setString(13, data.getRunUser());
            ps.setString(14, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PkgRunSfcItem> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PkgRunSfcItem data : dataList) {
            ps.setString(1, data.getRunSfcBo());
            ps.setString(2, data.getSfcBo());
            ps.setString(3, data.getCustomerItemBo());
            ps.setString(4, data.getStateName());
            DateUtils.setDateTz(ps, 5, data.getBeginTime());
            DateUtils.setDateTz(ps, 6, data.getEndTime());
            ps.setString(7, data.getRun());
            ps.setString(8, data.getResourceBo());
            ps.setString(9, data.getOperationBo());
            ps.setString(10, data.getRouterBo());
            ps.setString(11, data.getRecipeName());
            ps.setString(12, data.getRemark());
            ps.setString(13, data.getRunUser());
            ps.setString(14, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_pkg_run_sfc_item WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<PkgRunSfcItem> selectAll() throws SQLException {
        ArrayList<PkgRunSfcItem> result = new ArrayList<PkgRunSfcItem>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PkgRunSfcItem selectByPK(String id) throws SQLException {
        PkgRunSfcItem result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private PkgRunSfcItem convert(ResultSet rs) throws SQLException {
        PkgRunSfcItem data = new PkgRunSfcItem();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setRunSfcBo(rs.getString(index++));
        data.setSfcBo(rs.getString(index++));
        data.setCustomerItemBo(rs.getString(index++));
        data.setStateName(rs.getString(index++));
        data.setBeginTime(DateUtils.getDateTz(rs, index++));
        data.setEndTime(DateUtils.getDateTz(rs, index++));
        data.setRun(rs.getString(index++));
        data.setResourceBo(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setRouterBo(rs.getString(index++));
        data.setRecipeName(rs.getString(index++));
        data.setRemark(rs.getString(index++));
        data.setRunUser(rs.getString(index++));

        return data;
    }
}
