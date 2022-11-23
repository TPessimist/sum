package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.UtilMainQueue;
import uia.utils.dao.DateUtils;

public class UtilMainQueueDao {

    private static final String SQL_INS = "INSERT INTO zd_util_main_queue(id,queue_type,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_util_main_queue SET queue_type=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,queue_type,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_util_main_queue ";
    
    private final Connection conn;

    public UtilMainQueueDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(UtilMainQueue data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getQueueType());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<UtilMainQueue> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(UtilMainQueue data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getQueueType());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(UtilMainQueue data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getQueueType());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<UtilMainQueue> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(UtilMainQueue data : dataList) {
            ps.setString(1, data.getQueueType());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_util_main_queue WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<UtilMainQueue> selectAll() throws SQLException {
        ArrayList<UtilMainQueue> result = new ArrayList<UtilMainQueue>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public UtilMainQueue selectByPK(String id) throws SQLException {
        UtilMainQueue result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private UtilMainQueue convert(ResultSet rs) throws SQLException {
        UtilMainQueue data = new UtilMainQueue();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setQueueType(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
