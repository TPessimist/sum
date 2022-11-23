package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FCResourceRecord;
import uia.utils.dao.DateUtils;

public class FCResourceRecordDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_resource_record(uuid,resource_bo,last_resource_state,now_resource_state,sfc_bo,shop_order_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_resource_record SET resource_bo=?,last_resource_state=?,now_resource_state=?,sfc_bo=?,shop_order_bo=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,resource_bo,last_resource_state,now_resource_state,sfc_bo,shop_order_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_fc_resource_record ";

    private static final String SQL_SEL_TOP = "SELECT top 1 uuid,resource_bo,last_resource_state,now_resource_state,sfc_bo,shop_order_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_fc_resource_record ";

    private final Connection conn;

    public FCResourceRecordDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FCResourceRecord data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getResourceBo());
            ps.setString(3, data.getLastResourceState());
            ps.setString(4, data.getNowResourceState());
            ps.setString(5, data.getSfcBo());
            ps.setString(6, data.getShopOrderBo());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FCResourceRecord> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FCResourceRecord data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getResourceBo());
            ps.setString(3, data.getLastResourceState());
            ps.setString(4, data.getNowResourceState());
            ps.setString(5, data.getSfcBo());
            ps.setString(6, data.getShopOrderBo());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FCResourceRecord data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getLastResourceState());
            ps.setString(3, data.getNowResourceState());
            ps.setString(4, data.getSfcBo());
            ps.setString(5, data.getShopOrderBo());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
            ps.setString(10, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FCResourceRecord> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FCResourceRecord data : dataList) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getLastResourceState());
            ps.setString(3, data.getNowResourceState());
            ps.setString(4, data.getSfcBo());
            ps.setString(5, data.getShopOrderBo());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
            ps.setString(10, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_resource_record WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<FCResourceRecord> selectAll() throws SQLException {
        ArrayList<FCResourceRecord> result = new ArrayList<FCResourceRecord>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FCResourceRecord selectByPK(String uuid) throws SQLException {
        FCResourceRecord result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public FCResourceRecord selectByResourceBo(String resourceBo) throws SQLException {
        FCResourceRecord result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE RESOURCE_BO = ? ORDER BY UPDATED_TIME DESC")) {
            ps.setString(1, resourceBo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public FCResourceRecord selectByResourceBoTop1(String resourceBo) throws SQLException {
        FCResourceRecord result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TOP  + "WHERE RESOURCE_BO = ? ORDER BY UPDATED_TIME DESC")) {
            ps.setString(1, resourceBo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<FCResourceRecord> selectByResourceBoAll(String resourceBo) throws SQLException {
        List<FCResourceRecord> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE RESOURCE_BO = ?  ORDER BY UPDATED_TIME DESC")) {
            ps.setString(1, resourceBo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    private FCResourceRecord convert(ResultSet rs) throws SQLException {
        FCResourceRecord data = new FCResourceRecord();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setResourceBo(rs.getString(index++));
        data.setLastResourceState(rs.getString(index++));
        data.setNowResourceState(rs.getString(index++));
        data.setSfcBo(rs.getString(index++));
        data.setShopOrderBo(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
