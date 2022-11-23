package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdFcSetBatch;
import uia.utils.dao.DateUtils;

public class ZdFcSetBatchDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_set_batch(shop_order_bo,batch_id,state,content,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_set_batch SET batch_id=?,state=?,content=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE shop_order_bo=?";

    private static final String SQL_SEL = "SELECT shop_order_bo,batch_id,state,content,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_fc_set_batch ";
    
    private final Connection conn;

    public ZdFcSetBatchDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ZdFcSetBatch data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getState());
            ps.setString(4, data.getContent());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ZdFcSetBatch> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ZdFcSetBatch data : dataList) {
            ps.setString(1, data.getShopOrderBo());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getState());
            ps.setString(4, data.getContent());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ZdFcSetBatch data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getBatchId());
            ps.setString(2, data.getState());
            ps.setString(3, data.getContent());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getShopOrderBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ZdFcSetBatch> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ZdFcSetBatch data : dataList) {
            ps.setString(1, data.getBatchId());
            ps.setString(2, data.getState());
            ps.setString(3, data.getContent());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getShopOrderBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String shopOrderBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_set_batch WHERE shop_order_bo=?")) {
            ps.setString(1, shopOrderBo);

            return ps.executeUpdate();
        }
    }    

    public List<ZdFcSetBatch> selectAll() throws SQLException {
        ArrayList<ZdFcSetBatch> result = new ArrayList<ZdFcSetBatch>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ZdFcSetBatch selectByPK(String shopOrderBo) throws SQLException {
        ZdFcSetBatch result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE shop_order_bo=?")) {
            ps.setString(1, shopOrderBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public ZdFcSetBatch selectByPKTop() throws SQLException {
        ZdFcSetBatch result = null;
        try (PreparedStatement ps = this.conn.prepareStatement( "SELECT TOP 1 shop_order_bo,batch_id,state,content,reversed_field1,reversed_field2,updated_user,updated_time  FROM ZD_FC_SET_BATCH  WHERE state = 'WAIT'  ")) {
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    private ZdFcSetBatch convert(ResultSet rs) throws SQLException {
        ZdFcSetBatch data = new ZdFcSetBatch();
        
        int index = 1;
        data.setShopOrderBo(rs.getString(index++));
        data.setBatchId(rs.getString(index++));
        data.setState(rs.getString(index++));
        data.setContent(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
