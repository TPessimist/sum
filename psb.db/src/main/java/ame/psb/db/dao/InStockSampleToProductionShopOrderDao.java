package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.InStockSampleToProductionShopOrder;
import uia.utils.dao.DateUtils;

public class InStockSampleToProductionShopOrderDao {

    private static final String SQL_INS = "INSERT INTO zd_instock_sample_to_production_shop_order(item_group_bo,oa_flag,shop_order_list,item_bo,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_instock_sample_to_production_shop_order SET oa_flag=?,shop_order_list=?,item_bo=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=?";

    private static final String SQL_SEL_TOP1 = "SELECT top 1 item_group_bo,oa_flag,shop_order_list,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_instock_sample_to_production_shop_order ";


    private static final String SQL_SEL = "SELECT item_group_bo,oa_flag,shop_order_list,item_bo,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_instock_sample_to_production_shop_order ";
    
    private final Connection conn;

    public InStockSampleToProductionShopOrderDao(Connection conn) {
        this.conn = conn;
    }


    public void insertOrUpdate(InStockSampleToProductionShopOrder data)
        throws SQLException {

        InStockSampleToProductionShopOrder inStockSampleToProductionShopOrder = selectByPK(
            data.getItemGroupBo()) ;

        if(null == inStockSampleToProductionShopOrder)
            insert(data);
        else
            update(data);

    }
    
    public int insert(InStockSampleToProductionShopOrder data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getItemGroupBo());
            ps.setString(2, data.getOaFlag());
            ps.setString(3, data.getShopOrderList());
            ps.setString(4, data.getItemBo());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<InStockSampleToProductionShopOrder> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(InStockSampleToProductionShopOrder data : dataList) {
            ps.setString(1, data.getItemGroupBo());
            ps.setString(2, data.getOaFlag());
            ps.setString(3, data.getShopOrderList());
            ps.setString(4, data.getItemBo());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(InStockSampleToProductionShopOrder data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getOaFlag());
            ps.setString(2, data.getShopOrderList());
            ps.setString(3, data.getItemBo());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getItemGroupBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<InStockSampleToProductionShopOrder> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(InStockSampleToProductionShopOrder data : dataList) {
            ps.setString(1, data.getOaFlag());
            ps.setString(2, data.getShopOrderList());
            ps.setString(3, data.getItemBo());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getItemGroupBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String itemGroupBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_instock_sample_to_production_shop_order WHERE item_group_bo=?")) {
            ps.setString(1, itemGroupBo);

            return ps.executeUpdate();
        }
    }    

    public List<InStockSampleToProductionShopOrder> selectAll() throws SQLException {
        ArrayList<InStockSampleToProductionShopOrder> result = new ArrayList<InStockSampleToProductionShopOrder>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public InStockSampleToProductionShopOrder selectByPK(String itemGroupBo) throws SQLException {
        InStockSampleToProductionShopOrder result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_group_bo=?")) {
            ps.setString(1, itemGroupBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public InStockSampleToProductionShopOrder selectTop1ByOaFlag(String flag) throws SQLException {
        InStockSampleToProductionShopOrder result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TOP1  + "WHERE oa_flag=?")) {
            ps.setString(1, flag);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }


    private InStockSampleToProductionShopOrder convert(ResultSet rs) throws SQLException {
        InStockSampleToProductionShopOrder data = new InStockSampleToProductionShopOrder();
        
        int index = 1;
        data.setItemGroupBo(rs.getString(index++));
        data.setOaFlag(rs.getString(index++));
        data.setShopOrderList(rs.getString(index++));
        data.setItemBo(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
