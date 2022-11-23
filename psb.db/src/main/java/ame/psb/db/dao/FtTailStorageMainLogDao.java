package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FtTailStorageMainLog;
import uia.utils.dao.DateUtils;

public class FtTailStorageMainLogDao {

    private static final String SQL_INS = "INSERT INTO zd_ft_tail_storage_main_log(uuid,unique_code,batch_id,reverse_field1,reverse_field2,update_user,update_time) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_ft_tail_storage_main_log SET unique_code=?,batch_id=?,reverse_field1=?,reverse_field2=?,update_user=?,update_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,unique_code,batch_id,reverse_field1,reverse_field2,update_user,update_time FROM zd_ft_tail_storage_main_log ";
    
    private final Connection conn;

    public FtTailStorageMainLogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FtTailStorageMainLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getUniqueCode());
            ps.setString(3, data.getBatchId());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getUpdateUser());
            DateUtils.setDateTz(ps, 7, data.getUpdateTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FtTailStorageMainLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FtTailStorageMainLog data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getUniqueCode());
            ps.setString(3, data.getBatchId());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getUpdateUser());
            DateUtils.setDateTz(ps, 7, data.getUpdateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FtTailStorageMainLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getUniqueCode());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getUpdateUser());
            DateUtils.setDateTz(ps, 6, data.getUpdateTime());
            ps.setString(7, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FtTailStorageMainLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FtTailStorageMainLog data : dataList) {
            ps.setString(1, data.getUniqueCode());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getUpdateUser());
            DateUtils.setDateTz(ps, 6, data.getUpdateTime());
            ps.setString(7, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_ft_tail_storage_main_log WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<FtTailStorageMainLog> selectAll() throws SQLException {
        ArrayList<FtTailStorageMainLog> result = new ArrayList<FtTailStorageMainLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FtTailStorageMainLog selectByPK(String uuid) throws SQLException {
        FtTailStorageMainLog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private FtTailStorageMainLog convert(ResultSet rs) throws SQLException {
        FtTailStorageMainLog data = new FtTailStorageMainLog();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setUniqueCode(rs.getString(index++));
        data.setBatchId(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setUpdateUser(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
