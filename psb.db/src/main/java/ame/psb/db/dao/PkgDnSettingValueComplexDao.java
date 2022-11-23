package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PkgDnSettingValueComplex;
import uia.utils.dao.DateUtils;

public class PkgDnSettingValueComplexDao {

    private static final String SQL_INS = "INSERT INTO zr_pkg_dn_setting_value_complex(reel_id,action_name,label_tag_value,dn_no,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_pkg_dn_setting_value_complex SET label_tag_value=?,dn_no=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE reel_id=? AND action_name=?";

    private static final String SQL_SEL = "SELECT reel_id,action_name,label_tag_value,dn_no,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_pkg_dn_setting_value_complex ";
    
    private final Connection conn;

    public PkgDnSettingValueComplexDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PkgDnSettingValueComplex data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getReelId());
            ps.setString(2, data.getActionName());
            ps.setString(3, data.getLabelTagValue());
            ps.setString(4, data.getDnNo());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PkgDnSettingValueComplex> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PkgDnSettingValueComplex data : dataList) {
            ps.setString(1, data.getReelId());
            ps.setString(2, data.getActionName());
            ps.setString(3, data.getLabelTagValue());
            ps.setString(4, data.getDnNo());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PkgDnSettingValueComplex data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getLabelTagValue());
            ps.setString(2, data.getDnNo());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getReelId());
            ps.setString(8, data.getActionName());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PkgDnSettingValueComplex> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PkgDnSettingValueComplex data : dataList) {
            ps.setString(1, data.getLabelTagValue());
            ps.setString(2, data.getDnNo());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getReelId());
            ps.setString(8, data.getActionName());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String reelId, String actionName) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_pkg_dn_setting_value_complex WHERE reel_id=? AND action_name=?")) {
            ps.setString(1, reelId);
            ps.setString(2, actionName);

            return ps.executeUpdate();
        }
    }    

    public List<PkgDnSettingValueComplex> selectAll() throws SQLException {
        ArrayList<PkgDnSettingValueComplex> result = new ArrayList<PkgDnSettingValueComplex>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<PkgDnSettingValueComplex> selectByDn(String dn) throws SQLException {
        ArrayList<PkgDnSettingValueComplex> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE DN_NO = ? order by LABEL_TAG_VALUE asc")) {
            ps.setString(1, dn);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<PkgDnSettingValueComplex> selectByLabelTagVale(String labelTagVale, String actionName) throws SQLException {
        ArrayList<PkgDnSettingValueComplex> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE　LABEL_TAG_VALUE = ? and ACTION_NAME = ?")) {
            ps.setString(1, labelTagVale);
            ps.setString(2, actionName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    public PkgDnSettingValueComplex selectByPK(String reelId, String actionName) throws SQLException {
        PkgDnSettingValueComplex result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE reel_id=? AND action_name=?")) {
            ps.setString(1, reelId);
            ps.setString(2, actionName);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private PkgDnSettingValueComplex convert(ResultSet rs) throws SQLException {
        PkgDnSettingValueComplex data = new PkgDnSettingValueComplex();
        
        int index = 1;
        data.setReelId(rs.getString(index++));
        data.setActionName(rs.getString(index++));
        data.setLabelTagValue(rs.getString(index++));
        data.setDnNo(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
