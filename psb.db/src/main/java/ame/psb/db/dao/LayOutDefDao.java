package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.LayOutDef;
import uia.utils.dao.DateUtils;

public class LayOutDefDao {

    private static final String SQL_INS = "INSERT INTO zd_layout_def(state_name,state_describe,color1,color2,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_layout_def SET state_describe=?,color1=?,color2=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE state_name=?";

    private static final String SQL_SEL = "SELECT state_name,state_describe,color1,color2,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_layout_def ";
    
    private final Connection conn;

    public LayOutDefDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(LayOutDef data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getStateName());
            ps.setString(2, data.getStateDescribe());
            ps.setString(3, data.getColor1());
            ps.setString(4, data.getColor2());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<LayOutDef> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(LayOutDef data : dataList) {
            ps.setString(1, data.getStateName());
            ps.setString(2, data.getStateDescribe());
            ps.setString(3, data.getColor1());
            ps.setString(4, data.getColor2());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(LayOutDef data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getStateDescribe());
            ps.setString(2, data.getColor1());
            ps.setString(3, data.getColor2());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getStateName());

            return ps.executeUpdate();
        }
    }    

    public int update(List<LayOutDef> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(LayOutDef data : dataList) {
            ps.setString(1, data.getStateDescribe());
            ps.setString(2, data.getColor1());
            ps.setString(3, data.getColor2());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getStateName());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String stateName) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_layout_def WHERE state_name=?")) {
            ps.setString(1, stateName);

            return ps.executeUpdate();
        }
    }    

    public List<LayOutDef> selectAll() throws SQLException {
        ArrayList<LayOutDef> result = new ArrayList<LayOutDef>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public LayOutDef selectByPK(String stateName) throws SQLException {
        LayOutDef result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE state_name=?")) {
            ps.setString(1, stateName);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private LayOutDef convert(ResultSet rs) throws SQLException {
        LayOutDef data = new LayOutDef();
        
        int index = 1;
        data.setStateName(rs.getString(index++));
        data.setStateDescribe(rs.getString(index++));
        data.setColor1(rs.getString(index++));
        data.setColor2(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
