package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FcDeviceHoldFlag;
import uia.utils.dao.DateUtils;

public class FcDeviceHoldFlagDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_device_hold_flag(item_group_bo,operation_bo,hold_flag,reversed_field1,reversed_field2,updated_time,updated_user) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_device_hold_flag SET hold_flag=?,reversed_field1=?,reversed_field2=?,updated_time=?,updated_user=? WHERE item_group_bo=? AND operation_bo=?";

    private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,hold_flag,reversed_field1,reversed_field2,updated_time,updated_user FROM zd_fc_device_hold_flag ";
    
    private final Connection conn;

    public FcDeviceHoldFlagDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FcDeviceHoldFlag data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getItemGroupBo());
            ps.setString(2, data.getOperationBo());
            ps.setBoolean(3, data.getHoldFlag());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getUpdatedUser());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FcDeviceHoldFlag> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FcDeviceHoldFlag data : dataList) {
            ps.setString(1, data.getItemGroupBo());
            ps.setString(2, data.getOperationBo());
            ps.setBoolean(3, data.getHoldFlag());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getUpdatedUser());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FcDeviceHoldFlag data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBoolean(1, data.getHoldFlag());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getUpdatedUser());
            ps.setString(6, data.getItemGroupBo());
            ps.setString(7, data.getOperationBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FcDeviceHoldFlag> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FcDeviceHoldFlag data : dataList) {
            ps.setBoolean(1, data.getHoldFlag());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getUpdatedUser());
            ps.setString(6, data.getItemGroupBo());
            ps.setString(7, data.getOperationBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String itemGroupBo, String operationBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_device_hold_flag WHERE item_group_bo=? AND operation_bo=?")) {
            ps.setString(1, itemGroupBo);
            ps.setString(2, operationBo);

            return ps.executeUpdate();
        }
    }    

    public List<FcDeviceHoldFlag> selectAll() throws SQLException {
        ArrayList<FcDeviceHoldFlag> result = new ArrayList<FcDeviceHoldFlag>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FcDeviceHoldFlag selectByPK(String itemGroupBo, String operationBo) throws SQLException {
        FcDeviceHoldFlag result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_group_bo=? AND operation_bo=?")) {
            ps.setString(1, itemGroupBo);
            ps.setString(2, operationBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private FcDeviceHoldFlag convert(ResultSet rs) throws SQLException {
        FcDeviceHoldFlag data = new FcDeviceHoldFlag();
        
        int index = 1;
        data.setItemGroupBo(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setHoldFlag(rs.getBoolean(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
        data.setUpdatedUser(rs.getString(index++));

        return data;
    }
}
