package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FCResourceRecordDetails;
import uia.utils.dao.DateUtils;

public class FCResourceRecordDetailsDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_resource_record_details(uuid,wafer_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_resource_record_details SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=? AND wafer_name=?";

    private static final String SQL_SEL = "SELECT uuid,wafer_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_fc_resource_record_details ";
    
    private final Connection conn;

    public FCResourceRecordDetailsDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FCResourceRecordDetails data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getWaferName());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FCResourceRecordDetails> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FCResourceRecordDetails data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getWaferName());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FCResourceRecordDetails data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getReversedField1());
            ps.setString(2, data.getReversedField2());
            ps.setString(3, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getUuid());
            ps.setString(6, data.getWaferName());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FCResourceRecordDetails> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FCResourceRecordDetails data : dataList) {
            ps.setString(1, data.getReversedField1());
            ps.setString(2, data.getReversedField2());
            ps.setString(3, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getUuid());
            ps.setString(6, data.getWaferName());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid, String waferName) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_resource_record_details WHERE uuid=? AND wafer_name=?")) {
            ps.setString(1, uuid);
            ps.setString(2, waferName);

            return ps.executeUpdate();
        }
    }    

    public List<FCResourceRecordDetails> selectAll() throws SQLException {
        ArrayList<FCResourceRecordDetails> result = new ArrayList<FCResourceRecordDetails>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FCResourceRecordDetails selectByPK(String uuid, String waferName) throws SQLException {
        FCResourceRecordDetails result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=? AND wafer_name=?")) {
            ps.setString(1, uuid);
            ps.setString(2, waferName);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private FCResourceRecordDetails convert(ResultSet rs) throws SQLException {
        FCResourceRecordDetails data = new FCResourceRecordDetails();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setWaferName(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
