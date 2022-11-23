package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FtTailStorageRelease;
import uia.utils.dao.DateUtils;

public class FtTailStorageReleaseDao {

    private static final String SQL_INS = "INSERT INTO zd_ft_tail_storage_release(shop_order_bo,shop_order_name,binding_type,reversed_field1,reversed_field2,modify_time,modify_user,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_ft_tail_storage_release SET shop_order_name=?,reversed_field1=?,reversed_field2=?,modify_time=?,modify_user=?,updated_time=?,updated_user=? WHERE shop_order_bo=? AND binding_type=?";

    private static final String SQL_SEL = "SELECT shop_order_bo,shop_order_name,binding_type,reversed_field1,reversed_field2,modify_time,modify_user,updated_time,updated_user FROM zd_ft_tail_storage_release ";
    
    private final Connection conn;

    public FtTailStorageReleaseDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FtTailStorageRelease data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getShopOrderName());
            ps.setString(3, data.getBindingType());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            DateUtils.setDateTz(ps, 6, data.getModifyTime());
            ps.setString(7, data.getModifyUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUpdatedUser());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FtTailStorageRelease> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FtTailStorageRelease data : dataList) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getShopOrderName());
            ps.setString(3, data.getBindingType());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            DateUtils.setDateTz(ps, 6, data.getModifyTime());
            ps.setString(7, data.getModifyUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUpdatedUser());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FtTailStorageRelease data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getShopOrderName());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            DateUtils.setDateTz(ps, 4, data.getModifyTime());
            ps.setString(5, data.getModifyUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getUpdatedUser());
            ps.setString(8, data.getShopOrderBo());
            ps.setString(9, data.getBindingType());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FtTailStorageRelease> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FtTailStorageRelease data : dataList) {
            ps.setString(1, data.getShopOrderName());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            DateUtils.setDateTz(ps, 4, data.getModifyTime());
            ps.setString(5, data.getModifyUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getUpdatedUser());
            ps.setString(8, data.getShopOrderBo());
            ps.setString(9, data.getBindingType());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String shopOrderBo, String bindingType) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_ft_tail_storage_release WHERE shop_order_bo=? AND binding_type=?")) {
            ps.setString(1, shopOrderBo);
            ps.setString(2, bindingType);

            return ps.executeUpdate();
        }
    }    

    public List<FtTailStorageRelease> selectAll() throws SQLException {
        ArrayList<FtTailStorageRelease> result = new ArrayList<FtTailStorageRelease>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FtTailStorageRelease selectByPK(String shopOrderBo, String bindingType) throws SQLException {
        FtTailStorageRelease result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE shop_order_bo=? AND binding_type=?")) {
            ps.setString(1, shopOrderBo);
            ps.setString(2, bindingType);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<FtTailStorageRelease> selectByPKShopOrderBo(String shopOrderBo) throws SQLException {
        List<FtTailStorageRelease> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE shop_order_bo=? ")) {
            ps.setString(1, shopOrderBo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private FtTailStorageRelease convert(ResultSet rs) throws SQLException {
        FtTailStorageRelease data = new FtTailStorageRelease();
        
        int index = 1;
        data.setShopOrderBo(rs.getString(index++));
        data.setShopOrderName(rs.getString(index++));
        data.setBindingType(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setModifyTime(DateUtils.getDateTz(rs, index++));
        data.setModifyUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
        data.setUpdatedUser(rs.getString(index++));

        return data;
    }
}
