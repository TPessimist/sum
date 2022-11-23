package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.Da69GoldenWaferCheck;
import uia.utils.dao.DateUtils;

public class Da69GoldenWaferCheckDao {

    private static final String SQL_INS = "INSERT INTO zr_da69_golden_wafer_check(id,sfc_bo,sfc_name,flag,updated_user,updated_time,value1,value2) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_da69_golden_wafer_check SET sfc_bo=?,sfc_name=?,flag=?,updated_user=?,updated_time=?,value1=?,value2=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,sfc_bo,sfc_name,flag,updated_user,updated_time,value1,value2 FROM zr_da69_golden_wafer_check ";
    
    private final Connection conn;

    public Da69GoldenWaferCheckDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(Da69GoldenWaferCheck data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getSfcBo());
            ps.setString(3, data.getSfcName());
            ps.setString(4, data.getFlag());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getValue1());
            ps.setString(8, data.getValue2());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<Da69GoldenWaferCheck> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(Da69GoldenWaferCheck data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getSfcBo());
            ps.setString(3, data.getSfcName());
            ps.setString(4, data.getFlag());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getValue1());
            ps.setString(8, data.getValue2());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(Da69GoldenWaferCheck data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getSfcBo());
            ps.setString(2, data.getSfcName());
            ps.setString(3, data.getFlag());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getValue1());
            ps.setString(7, data.getValue2());
            ps.setString(8, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<Da69GoldenWaferCheck> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(Da69GoldenWaferCheck data : dataList) {
            ps.setString(1, data.getSfcBo());
            ps.setString(2, data.getSfcName());
            ps.setString(3, data.getFlag());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getValue1());
            ps.setString(7, data.getValue2());
            ps.setString(8, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_da69_golden_wafer_check WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<Da69GoldenWaferCheck> selectAll() throws SQLException {
        ArrayList<Da69GoldenWaferCheck> result = new ArrayList<Da69GoldenWaferCheck>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public List<Da69GoldenWaferCheck> selectBySfc(String sfcName) throws SQLException {
        ArrayList<Da69GoldenWaferCheck> result = new ArrayList<Da69GoldenWaferCheck>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL+ "WHERE sfc_name=? ORDER BY updated_time DESC ")) {
            ps.setString(1, sfcName);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public Da69GoldenWaferCheck selectBySfcBo(String sfcBo) throws SQLException {
        Da69GoldenWaferCheck result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE sfc_bo=?  ORDER BY updated_time DESC")) {
            ps.setString(1, sfcBo);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public Da69GoldenWaferCheck selectByPK(String id) throws SQLException {
        Da69GoldenWaferCheck result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private Da69GoldenWaferCheck convert(ResultSet rs) throws SQLException {
        Da69GoldenWaferCheck data = new Da69GoldenWaferCheck();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setSfcBo(rs.getString(index++));
        data.setSfcName(rs.getString(index++));
        data.setFlag(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
        data.setValue1(rs.getString(index++));
        data.setValue2(rs.getString(index++));

        return data;
    }
}
