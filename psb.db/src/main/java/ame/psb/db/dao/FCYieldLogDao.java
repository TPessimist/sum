package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FCYieldLog;
import uia.utils.dao.DateUtils;

public class FCYieldLogDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_yield_log(id,shop_order_name,batch_id,reverse_field1,reverse_field2,reverse_field3,reverse_field4,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_yield_log SET shop_order_name=?,batch_id=?,reverse_field1=?,reverse_field2=?,reverse_field3=?,reverse_field4=?,update_user=?,update_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,shop_order_name,batch_id,reverse_field1,reverse_field2,reverse_field3,reverse_field4,update_user,update_time FROM zd_fc_yield_log ";
    
    private final Connection conn;

    public FCYieldLogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FCYieldLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getShopOrderName());
            ps.setString(3, data.getBatchId());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getReverseField3());
            ps.setString(7, data.getReverseField4());
            ps.setString(8, data.getUpdateUser());
            DateUtils.setDateTz(ps, 9, data.getUpdateTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FCYieldLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FCYieldLog data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getShopOrderName());
            ps.setString(3, data.getBatchId());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getReverseField3());
            ps.setString(7, data.getReverseField4());
            ps.setString(8, data.getUpdateUser());
            DateUtils.setDateTz(ps, 9, data.getUpdateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FCYieldLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getShopOrderName());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getReverseField3());
            ps.setString(6, data.getReverseField4());
            ps.setString(7, data.getUpdateUser());
            DateUtils.setDateTz(ps, 8, data.getUpdateTime());
            ps.setString(9, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FCYieldLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FCYieldLog data : dataList) {
            ps.setString(1, data.getShopOrderName());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getReverseField3());
            ps.setString(6, data.getReverseField4());
            ps.setString(7, data.getUpdateUser());
            DateUtils.setDateTz(ps, 8, data.getUpdateTime());
            ps.setString(9, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_yield_log WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<FCYieldLog> selectAll() throws SQLException {
        ArrayList<FCYieldLog> result = new ArrayList<FCYieldLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FCYieldLog selectByPK(String id) throws SQLException {
        FCYieldLog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private FCYieldLog convert(ResultSet rs) throws SQLException {
        FCYieldLog data = new FCYieldLog();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setShopOrderName(rs.getString(index++));
        data.setBatchId(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setReverseField3(rs.getString(index++));
        data.setReverseField4(rs.getString(index++));
        data.setUpdateUser(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
