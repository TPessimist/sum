package ame.psb.db.dao;

import ame.psb.db.FtTailStorage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FtTailStorageMain;
import uia.utils.dao.DateUtils;

public class FtTailStorageMainDao {

    private static final String SQL_INS = "INSERT INTO zd_ft_tail_storage_main(uuid,shop_order_bo,unique_code,sfc_bo,tail_qty,tail_location,tail_customer_device,tail_state,reversed_field1,reversed_field2,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_ft_tail_storage_main SET shop_order_bo=?,unique_code=?,sfc_bo=?,tail_qty=?,tail_location=?,tail_customer_device=?,tail_state=?,reversed_field1=?,reversed_field2=?,updated_time=?,updated_user=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,shop_order_bo,unique_code,sfc_bo,tail_qty,tail_location,tail_customer_device,tail_state,reversed_field1,reversed_field2,updated_time,updated_user FROM zd_ft_tail_storage_main ";
    
    private final Connection conn;

    public FtTailStorageMainDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FtTailStorageMain data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getShopOrderBo());
            ps.setString(3, data.getUniqueCode());
            ps.setString(4, data.getSfcBo());
            ps.setBigDecimal(5, data.getTailQty());
            ps.setString(6, data.getTailLocation());
            ps.setString(7, data.getTailCustomerDevice());
            ps.setString(8, data.getTailState());
            ps.setString(9, data.getReversedField1());
            ps.setString(10, data.getReversedField2());
            DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
            ps.setString(12, data.getUpdatedUser());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FtTailStorageMain> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FtTailStorageMain data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getShopOrderBo());
            ps.setString(3, data.getUniqueCode());
            ps.setString(4, data.getSfcBo());
            ps.setBigDecimal(5, data.getTailQty());
            ps.setString(6, data.getTailLocation());
            ps.setString(7, data.getTailCustomerDevice());
            ps.setString(8, data.getTailState());
            ps.setString(9, data.getReversedField1());
            ps.setString(10, data.getReversedField2());
            DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
            ps.setString(12, data.getUpdatedUser());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FtTailStorageMain data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getUniqueCode());
            ps.setString(3, data.getSfcBo());
            ps.setBigDecimal(4, data.getTailQty());
            ps.setString(5, data.getTailLocation());
            ps.setString(6, data.getTailCustomerDevice());
            ps.setString(7, data.getTailState());
            ps.setString(8, data.getReversedField1());
            ps.setString(9, data.getReversedField2());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
            ps.setString(11, data.getUpdatedUser());
            ps.setString(12, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FtTailStorageMain> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FtTailStorageMain data : dataList) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getUniqueCode());
            ps.setString(3, data.getSfcBo());
            ps.setBigDecimal(4, data.getTailQty());
            ps.setString(5, data.getTailLocation());
            ps.setString(6, data.getTailCustomerDevice());
            ps.setString(7, data.getTailState());
            ps.setString(8, data.getReversedField1());
            ps.setString(9, data.getReversedField2());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
            ps.setString(11, data.getUpdatedUser());
            ps.setString(12, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_ft_tail_storage_main WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<FtTailStorageMain> selectAll() throws SQLException {
        ArrayList<FtTailStorageMain> result = new ArrayList<FtTailStorageMain>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public  List<FtTailStorageMain> selectByLocation(String location) throws SQLException {
        ArrayList<FtTailStorageMain> result = new ArrayList<FtTailStorageMain>();
        try (PreparedStatement ps = this.conn
            .prepareStatement(SQL_SEL + "  WHERE TAIL_LOCATION = ? and TAIL_STATE = 'ENABLE'  ")) {
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public  List<FtTailStorageMain> selectByCustomerDevice(String customerDevice,String shopOrderBo) throws SQLException {
        ArrayList<FtTailStorageMain> result = new ArrayList<FtTailStorageMain>();
        try (PreparedStatement ps = this.conn
            .prepareStatement(SQL_SEL + "   WHERE TAIL_CUSTOMER_DEVICE = ? and SHOP_ORDER_BO != ? and TAIL_STATE = 'ENABLE'   ")) {
            ps.setString(1, customerDevice);
            ps.setString(2, shopOrderBo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public  List<FtTailStorageMain> selectByshopOrderBo(String shopOrderBo) throws SQLException {
        ArrayList<FtTailStorageMain> result = new ArrayList<FtTailStorageMain>();
        try (PreparedStatement ps = this.conn
            .prepareStatement(SQL_SEL + "   WHERE  SHOP_ORDER_BO =? and TAIL_STATE = 'ENABLE'")) {
            ps.setString(1, shopOrderBo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public FtTailStorageMain selectByPK(String uuid) throws SQLException {
        FtTailStorageMain result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=? and TAIL_STATE = 'ENABLE'")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public List<FtTailStorageMain> selectByUniqueCode(String uniqueCode) throws SQLException {
        List<FtTailStorageMain> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE unique_code=? and TAIL_STATE = 'ENABLE'")) {
            ps.setString(1, uniqueCode);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<FtTailStorageMain> selectByUniqueCodeAll(String uniqueCode) throws SQLException {
        List<FtTailStorageMain> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE unique_code=? ")) {
            ps.setString(1, uniqueCode);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    private FtTailStorageMain convert(ResultSet rs) throws SQLException {
        FtTailStorageMain data = new FtTailStorageMain();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setShopOrderBo(rs.getString(index++));
        data.setUniqueCode(rs.getString(index++));
        data.setSfcBo(rs.getString(index++));
        data.setTailQty(rs.getBigDecimal(index++));
        data.setTailLocation(rs.getString(index++));
        data.setTailCustomerDevice(rs.getString(index++));
        data.setTailState(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
        data.setUpdatedUser(rs.getString(index++));

        return data;
    }
}
