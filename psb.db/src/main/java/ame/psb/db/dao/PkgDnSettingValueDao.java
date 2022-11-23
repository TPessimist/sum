package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PkgDnSettingValue;
import uia.utils.dao.DateUtils;

public class PkgDnSettingValueDao {

    private static final String SQL_INS = "INSERT INTO zr_pkg_dn_setting_value(reel_id,action_name,label_id,label_tag_name,label_tag_value,dn_no,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_pkg_dn_setting_value SET label_tag_value=?,dn_no=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE reel_id=? AND action_name=? AND label_id=? AND label_tag_name=?";

    private static final String SQL_SEL = "SELECT reel_id,action_name,label_id,label_tag_name,label_tag_value,dn_no,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_pkg_dn_setting_value ";
    
    private final Connection conn;

    public PkgDnSettingValueDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PkgDnSettingValue data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getReelId());
            ps.setString(2, data.getActionName());
            ps.setString(3, data.getLabelId());
            ps.setString(4, data.getLabelTagName());
            ps.setString(5, data.getLabelTagValue());
            ps.setString(6, data.getDnNo());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PkgDnSettingValue> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PkgDnSettingValue data : dataList) {
            ps.setString(1, data.getReelId());
            ps.setString(2, data.getActionName());
            ps.setString(3, data.getLabelId());
            ps.setString(4, data.getLabelTagName());
            ps.setString(5, data.getLabelTagValue());
            ps.setString(6, data.getDnNo());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PkgDnSettingValue data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getLabelTagValue());
            ps.setString(2, data.getDnNo());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getReelId());
            ps.setString(8, data.getActionName());
            ps.setString(9, data.getLabelId());
            ps.setString(10, data.getLabelTagName());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PkgDnSettingValue> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PkgDnSettingValue data : dataList) {
            ps.setString(1, data.getLabelTagValue());
            ps.setString(2, data.getDnNo());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getReelId());
            ps.setString(8, data.getActionName());
            ps.setString(9, data.getLabelId());
            ps.setString(10, data.getLabelTagName());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String reelId, String actionName, String labelId, String labelTagName) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_pkg_dn_setting_value WHERE reel_id=? AND action_name=? AND label_id=? AND label_tag_name=?")) {
            ps.setString(1, reelId);
            ps.setString(2, actionName);
            ps.setString(3, labelId);
            ps.setString(4, labelTagName);

            return ps.executeUpdate();
        }
    }    

    public List<PkgDnSettingValue> selectAll() throws SQLException {
        ArrayList<PkgDnSettingValue> result = new ArrayList<PkgDnSettingValue>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<PkgDnSettingValue> selectByDn(String dnno) throws SQLException {
        ArrayList<PkgDnSettingValue> result = new ArrayList<PkgDnSettingValue>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where dn_no = ?")) {

            ps.setString(1, dnno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    public PkgDnSettingValue selectByPK(String reelId, String actionName, String labelId, String labelTagName) throws SQLException {
        PkgDnSettingValue result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE reel_id=? AND action_name=? AND label_id=? AND label_tag_name=?")) {
            ps.setString(1, reelId);
            ps.setString(2, actionName);
            ps.setString(3, labelId);
            ps.setString(4, labelTagName);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private PkgDnSettingValue convert(ResultSet rs) throws SQLException {
        PkgDnSettingValue data = new PkgDnSettingValue();
        
        int index = 1;
        data.setReelId(rs.getString(index++));
        data.setActionName(rs.getString(index++));
        data.setLabelId(rs.getString(index++));
        data.setLabelTagName(rs.getString(index++));
        data.setLabelTagValue(rs.getString(index++));
        data.setDnNo(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
