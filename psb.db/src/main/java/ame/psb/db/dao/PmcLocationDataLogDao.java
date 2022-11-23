package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PmcLocationDataLog;
import uia.utils.dao.DateUtils;

public class PmcLocationDataLogDao {

    private static final String SQL_INS = "INSERT INTO zd_pmc_location_data_log(uuid,batch_id,shop_order_bo,location_data,location_state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_pmc_location_data_log SET batch_id=?,shop_order_bo=?,location_data=?,location_state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,batch_id,shop_order_bo,location_data,location_state,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_pmc_location_data_log ";
    
    private final Connection conn;

    public PmcLocationDataLogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PmcLocationDataLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getShopOrderBo());
            ps.setString(4, data.getLocationData());
            ps.setString(5, data.getLocationState());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PmcLocationDataLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PmcLocationDataLog data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getShopOrderBo());
            ps.setString(4, data.getLocationData());
            ps.setString(5, data.getLocationState());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PmcLocationDataLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getBatchId());
            ps.setString(2, data.getShopOrderBo());
            ps.setString(3, data.getLocationData());
            ps.setString(4, data.getLocationState());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PmcLocationDataLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PmcLocationDataLog data : dataList) {
            ps.setString(1, data.getBatchId());
            ps.setString(2, data.getShopOrderBo());
            ps.setString(3, data.getLocationData());
            ps.setString(4, data.getLocationState());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pmc_location_data_log WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<PmcLocationDataLog> selectAll() throws SQLException {
        ArrayList<PmcLocationDataLog> result = new ArrayList<PmcLocationDataLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public List<PmcLocationDataLog> selectByBatchId(String batchId) throws SQLException {
        ArrayList<PmcLocationDataLog> result = new ArrayList<PmcLocationDataLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +"WHERE BATCH_ID=?")) {
            ps.setString(1, batchId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public List<PmcLocationDataLog> selectByLocationData(String locationData) throws SQLException {
        ArrayList<PmcLocationDataLog> result = new ArrayList<PmcLocationDataLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +"WHERE LOCATION_DATA=?")) {
            ps.setString(1, locationData);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public PmcLocationDataLog selectByPK(String uuid) throws SQLException {
        PmcLocationDataLog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private PmcLocationDataLog convert(ResultSet rs) throws SQLException {
        PmcLocationDataLog data = new PmcLocationDataLog();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setBatchId(rs.getString(index++));
        data.setShopOrderBo(rs.getString(index++));
        data.setLocationData(rs.getString(index++));
        data.setLocationState(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
