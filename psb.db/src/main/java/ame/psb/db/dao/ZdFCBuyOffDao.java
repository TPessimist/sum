package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdFCBuyOff;
import uia.utils.dao.DateUtils;

public class ZdFCBuyOffDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_buyoff(shop_order_bo,shop_order_name,operation_bo,operation,status_name,tooling1,tooling2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_buyoff SET shop_order_name=?,operation=?,status_name=?,tooling1=?,tooling2=?,updated_user=?,updated_time=? WHERE shop_order_bo=? AND operation_bo=?";

    private static final String SQL_SEL = "SELECT shop_order_bo,shop_order_name,operation_bo,operation,status_name,tooling1,tooling2,updated_user,updated_time FROM zd_fc_buyoff ";
    
    private final Connection conn;

    public ZdFCBuyOffDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ZdFCBuyOff data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getShopOrderName());
            ps.setString(3, data.getOperationBo());
            ps.setString(4, data.getOperation());
            ps.setString(5, data.getStatusName());
            ps.setString(6, data.getTooling1());
            ps.setString(7, data.getTooling2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ZdFCBuyOff> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ZdFCBuyOff data : dataList) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getShopOrderName());
            ps.setString(3, data.getOperationBo());
            ps.setString(4, data.getOperation());
            ps.setString(5, data.getStatusName());
            ps.setString(6, data.getTooling1());
            ps.setString(7, data.getTooling2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ZdFCBuyOff data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getShopOrderName());
            ps.setString(2, data.getOperation());
            ps.setString(3, data.getStatusName());
            ps.setString(4, data.getTooling1());
            ps.setString(5, data.getTooling2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getShopOrderBo());
            ps.setString(9, data.getOperationBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ZdFCBuyOff> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ZdFCBuyOff data : dataList) {
            ps.setString(1, data.getShopOrderName());
            ps.setString(2, data.getOperation());
            ps.setString(3, data.getStatusName());
            ps.setString(4, data.getTooling1());
            ps.setString(5, data.getTooling2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getShopOrderBo());
            ps.setString(9, data.getOperationBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String shopOrderBo, String operationBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_buyoff WHERE shop_order_bo=? AND operation_bo=?")) {
            ps.setString(1, shopOrderBo);
            ps.setString(2, operationBo);

            return ps.executeUpdate();
        }
    }    

    public List<ZdFCBuyOff> selectAll() throws SQLException {
        ArrayList<ZdFCBuyOff> result = new ArrayList<ZdFCBuyOff>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ZdFCBuyOff selectByPK(String shopOrderBo, String operationBo) throws SQLException {
        ZdFCBuyOff result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE shop_order_bo=? AND operation_bo=?")) {
            ps.setString(1, shopOrderBo);
            ps.setString(2, operationBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private ZdFCBuyOff convert(ResultSet rs) throws SQLException {
        ZdFCBuyOff data = new ZdFCBuyOff();
        
        int index = 1;
        data.setShopOrderBo(rs.getString(index++));
        data.setShopOrderName(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setOperation(rs.getString(index++));
        data.setStatusName(rs.getString(index++));
        data.setTooling1(rs.getString(index++));
        data.setTooling2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
