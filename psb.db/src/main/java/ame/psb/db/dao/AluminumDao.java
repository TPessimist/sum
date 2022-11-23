package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.Aluminum;
import uia.utils.dao.DateUtils;

public class AluminumDao {

    private static final String SQL_INS = "INSERT INTO zr_aluminum(customer,bind_condition,update_user,update_time) VALUES (?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_aluminum SET bind_condition=?,update_user=?,update_time=? WHERE customer=?";

    private static final String SQL_SEL = "SELECT customer,bind_condition,update_user,update_time FROM zr_aluminum ";
    
    private final Connection conn;

    public AluminumDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(Aluminum data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getCustomer());
            ps.setString(2, data.getBindCondition());
            ps.setString(3, data.getUpdateUser());
            DateUtils.setDateTz(ps, 4, data.getUpdateTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<Aluminum> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(Aluminum data : dataList) {
            ps.setString(1, data.getCustomer());
            ps.setString(2, data.getBindCondition());
            ps.setString(3, data.getUpdateUser());
            DateUtils.setDateTz(ps, 4, data.getUpdateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(Aluminum data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getBindCondition());
            ps.setString(2, data.getUpdateUser());
            DateUtils.setDateTz(ps, 3, data.getUpdateTime());
            ps.setString(4, data.getCustomer());

            return ps.executeUpdate();
        }
    }    

    public int update(List<Aluminum> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(Aluminum data : dataList) {
            ps.setString(1, data.getBindCondition());
            ps.setString(2, data.getUpdateUser());
            DateUtils.setDateTz(ps, 3, data.getUpdateTime());
            ps.setString(4, data.getCustomer());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String customer) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_aluminum WHERE customer=?")) {
            ps.setString(1, customer);

            return ps.executeUpdate();
        }
    }    

    public List<Aluminum> selectAll() throws SQLException {
        ArrayList<Aluminum> result = new ArrayList<Aluminum>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public Aluminum selectByPK(String customer) throws SQLException {
        Aluminum result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE customer=?")) {
            ps.setString(1, customer);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private Aluminum convert(ResultSet rs) throws SQLException {
        Aluminum data = new Aluminum();
        
        int index = 1;
        data.setCustomer(rs.getString(index++));
        data.setBindCondition(rs.getString(index++));
        data.setUpdateUser(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
