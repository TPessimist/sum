package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.RunCustomerItemInk;
import uia.utils.dao.DateUtils;

public class RunCustomerItemInkDao {

    private static final String SQL_INS = "INSERT INTO zr_run_customer_item_ink(id,customer_item_bo,binmap_rule_bo,ink_rule_name,ink_config_json,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_run_customer_item_ink SET customer_item_bo=?,binmap_rule_bo=?,ink_rule_name=?,ink_config_json=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,customer_item_bo,binmap_rule_bo,ink_rule_name,ink_config_json,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_run_customer_item_ink ";
    
    private final Connection conn;

    public RunCustomerItemInkDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(RunCustomerItemInk data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getCustomerItemBo());
            ps.setString(3, data.getBinmapRuleBo());
            ps.setString(4, data.getInkRuleName());
            ps.setString(5, data.getInkConfigJson());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<RunCustomerItemInk> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(RunCustomerItemInk data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getCustomerItemBo());
            ps.setString(3, data.getBinmapRuleBo());
            ps.setString(4, data.getInkRuleName());
            ps.setString(5, data.getInkConfigJson());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(RunCustomerItemInk data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getCustomerItemBo());
            ps.setString(2, data.getBinmapRuleBo());
            ps.setString(3, data.getInkRuleName());
            ps.setString(4, data.getInkConfigJson());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<RunCustomerItemInk> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(RunCustomerItemInk data : dataList) {
            ps.setString(1, data.getCustomerItemBo());
            ps.setString(2, data.getBinmapRuleBo());
            ps.setString(3, data.getInkRuleName());
            ps.setString(4, data.getInkConfigJson());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_run_customer_item_ink WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<RunCustomerItemInk> selectAll() throws SQLException {
        ArrayList<RunCustomerItemInk> result = new ArrayList<RunCustomerItemInk>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public RunCustomerItemInk selectByPK(String id) throws SQLException {
        RunCustomerItemInk result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private RunCustomerItemInk convert(ResultSet rs) throws SQLException {
        RunCustomerItemInk data = new RunCustomerItemInk();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setCustomerItemBo(rs.getString(index++));
        data.setBinmapRuleBo(rs.getString(index++));
        data.setInkRuleName(rs.getString(index++));
        data.setInkConfigJson(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
