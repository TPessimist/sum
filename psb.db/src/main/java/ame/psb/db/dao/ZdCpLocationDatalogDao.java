package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdCpLocationDatalog;
import uia.utils.dao.DateUtils;

public class ZdCpLocationDatalogDao {

    private static final String SQL_INS = "INSERT INTO zd_cp_location_data_log(uuid,customer_item_bo,custom1,custom2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_cp_location_data_log SET custom1=?,custom2=?,updated_user=?,updated_time=? WHERE uuid=? AND customer_item_bo=?";

    private static final String SQL_SEL = "SELECT uuid,customer_item_bo,custom1,custom2,updated_user,updated_time FROM zd_cp_location_data_log ";
    
    private final Connection conn;

    public ZdCpLocationDatalogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ZdCpLocationDatalog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getCustomerItemBo());
            ps.setString(3, data.getCustom1());
            ps.setString(4, data.getCustom2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ZdCpLocationDatalog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ZdCpLocationDatalog data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getCustomerItemBo());
            ps.setString(3, data.getCustom1());
            ps.setString(4, data.getCustom2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ZdCpLocationDatalog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getCustom1());
            ps.setString(2, data.getCustom2());
            ps.setString(3, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getUuid());
            ps.setString(6, data.getCustomerItemBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ZdCpLocationDatalog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ZdCpLocationDatalog data : dataList) {
            ps.setString(1, data.getCustom1());
            ps.setString(2, data.getCustom2());
            ps.setString(3, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
            ps.setString(5, data.getUuid());
            ps.setString(6, data.getCustomerItemBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid, String customerItemBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_cp_location_data_log WHERE uuid=? AND customer_item_bo=?")) {
            ps.setString(1, uuid);
            ps.setString(2, customerItemBo);

            return ps.executeUpdate();
        }
    }    

    public List<ZdCpLocationDatalog> selectAll() throws SQLException {
        ArrayList<ZdCpLocationDatalog> result = new ArrayList<ZdCpLocationDatalog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ZdCpLocationDatalog selectByPK(String uuid, String customerItemBo) throws SQLException {
        ZdCpLocationDatalog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=? AND customer_item_bo=?")) {
            ps.setString(1, uuid);
            ps.setString(2, customerItemBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<ZdCpLocationDatalog>  selectByPKUuid(String uuid) throws SQLException {
        List<ZdCpLocationDatalog> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=? ")) {
            ps.setString(1, uuid);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    private ZdCpLocationDatalog convert(ResultSet rs) throws SQLException {
        ZdCpLocationDatalog data = new ZdCpLocationDatalog();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setCustomerItemBo(rs.getString(index++));
        data.setCustom1(rs.getString(index++));
        data.setCustom2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
