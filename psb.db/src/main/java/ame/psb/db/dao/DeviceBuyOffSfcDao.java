package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.DeviceBuyOffSfc;
import uia.utils.dao.DateUtils;

public class DeviceBuyOffSfcDao {

    private static final String SQL_INS = "INSERT INTO zr_device_buyoff_sfc(sfc_bo,opertion_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_device_buyoff_sfc SET reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE sfc_bo=? AND opertion_bo=?";

    private static final String SQL_SEL = "SELECT sfc_bo,opertion_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_device_buyoff_sfc ";
    
    private final Connection conn;

    public DeviceBuyOffSfcDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(DeviceBuyOffSfc data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getSfcBo());
            ps.setString(2, data.getOpertionBo());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<DeviceBuyOffSfc> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(DeviceBuyOffSfc data : dataList) {
            ps.setString(1, data.getSfcBo());
            ps.setString(2, data.getOpertionBo());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(DeviceBuyOffSfc data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getReversedField1());
            ps.setString(2, data.getReversedField2());
            ps.setString(3, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getSfcBo());
            ps.setString(6, data.getOpertionBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<DeviceBuyOffSfc> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(DeviceBuyOffSfc data : dataList) {
            ps.setString(1, data.getReversedField1());
            ps.setString(2, data.getReversedField2());
            ps.setString(3, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getSfcBo());
            ps.setString(6, data.getOpertionBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String sfcBo, String opertionBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_device_buyoff_sfc WHERE sfc_bo=? AND opertion_bo=?")) {
            ps.setString(1, sfcBo);
            ps.setString(2, opertionBo);

            return ps.executeUpdate();
        }
    }    

    public List<DeviceBuyOffSfc> selectAll() throws SQLException {
        ArrayList<DeviceBuyOffSfc> result = new ArrayList<DeviceBuyOffSfc>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public DeviceBuyOffSfc selectByPK(String sfcBo, String opertionBo) throws SQLException {
        DeviceBuyOffSfc result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE sfc_bo=? AND opertion_bo=?")) {
            ps.setString(1, sfcBo);
            ps.setString(2, opertionBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private DeviceBuyOffSfc convert(ResultSet rs) throws SQLException {
        DeviceBuyOffSfc data = new DeviceBuyOffSfc();
        
        int index = 1;
        data.setSfcBo(rs.getString(index++));
        data.setOpertionBo(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
