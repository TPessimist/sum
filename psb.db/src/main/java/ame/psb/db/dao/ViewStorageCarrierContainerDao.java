package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewStorageCarrierContainer;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ViewStorageCarrierContainerDao {

    private static final String SQL_INS = "INSERT INTO view_storage_carrier_container(id,container_name,item_group_bo,device_name,customer,customer_itemset_name,carrier_bo,carrier_name,slot_no,position_bo,binding_time,packing_time,state) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE view_storage_carrier_container SET container_name=?,item_group_bo=?,device_name=?,customer=?,customer_itemset_name=?,carrier_bo=?,carrier_name=?,slot_no=?,position_bo=?,binding_time=?,packing_time=?,state=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,container_name,item_group_bo,device_name,customer,customer_itemset_name,carrier_bo,carrier_name,slot_no,position_bo,binding_time,packing_time,state FROM view_storage_carrier_container ";
    
    private final Connection conn;

    public ViewStorageCarrierContainerDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ViewStorageCarrierContainer data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getContainerName());
            ps.setString(3, data.getItemGroupBo());
            ps.setString(4, data.getDeviceName());
            ps.setString(5, data.getCustomer());
            ps.setString(6, data.getCustomerItemsetName());
            ps.setString(7, data.getCarrierBo());
            ps.setString(8, data.getCarrierName());
            ps.setBigDecimal(9, data.getSlotNo());
            ps.setString(10, data.getPositionBo());
            DateUtils.setDateTz(ps, 11, data.getBindingTime());
            DateUtils.setDateTz(ps, 12, data.getPackingTime());
            ps.setString(13, data.getState());

            return ps.executeUpdate();
        }
    }

    public List<ViewStorageCarrierContainer> select(Where where) throws SQLException {
        ArrayList<ViewStorageCarrierContainer> result = new ArrayList<ViewStorageCarrierContainer>();

        try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(this.convert(rs));
            }
        }
        return result;
    }


    public int insert(List<ViewStorageCarrierContainer> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ViewStorageCarrierContainer data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getContainerName());
            ps.setString(3, data.getItemGroupBo());
            ps.setString(4, data.getDeviceName());
            ps.setString(5, data.getCustomer());
            ps.setString(6, data.getCustomerItemsetName());
            ps.setString(7, data.getCarrierBo());
            ps.setString(8, data.getCarrierName());
            ps.setBigDecimal(9, data.getSlotNo());
            ps.setString(10, data.getPositionBo());
            DateUtils.setDateTz(ps, 11, data.getBindingTime());
            DateUtils.setDateTz(ps, 12, data.getPackingTime());
            ps.setString(13, data.getState());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ViewStorageCarrierContainer data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getContainerName());
            ps.setString(2, data.getItemGroupBo());
            ps.setString(3, data.getDeviceName());
            ps.setString(4, data.getCustomer());
            ps.setString(5, data.getCustomerItemsetName());
            ps.setString(6, data.getCarrierBo());
            ps.setString(7, data.getCarrierName());
            ps.setBigDecimal(8, data.getSlotNo());
            ps.setString(9, data.getPositionBo());
            DateUtils.setDateTz(ps, 10, data.getBindingTime());
            DateUtils.setDateTz(ps, 11, data.getPackingTime());
            ps.setString(12, data.getState());
            ps.setString(13, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ViewStorageCarrierContainer> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ViewStorageCarrierContainer data : dataList) {
            ps.setString(1, data.getContainerName());
            ps.setString(2, data.getItemGroupBo());
            ps.setString(3, data.getDeviceName());
            ps.setString(4, data.getCustomer());
            ps.setString(5, data.getCustomerItemsetName());
            ps.setString(6, data.getCarrierBo());
            ps.setString(7, data.getCarrierName());
            ps.setBigDecimal(8, data.getSlotNo());
            ps.setString(9, data.getPositionBo());
            DateUtils.setDateTz(ps, 10, data.getBindingTime());
            DateUtils.setDateTz(ps, 11, data.getPackingTime());
            ps.setString(12, data.getState());
            ps.setString(13, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM view_storage_carrier_container WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<ViewStorageCarrierContainer> selectAll() throws SQLException {
        ArrayList<ViewStorageCarrierContainer> result = new ArrayList<ViewStorageCarrierContainer>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ViewStorageCarrierContainer selectByPK(String id) throws SQLException {
        ViewStorageCarrierContainer result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private ViewStorageCarrierContainer convert(ResultSet rs) throws SQLException {
        ViewStorageCarrierContainer data = new ViewStorageCarrierContainer();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setContainerName(rs.getString(index++));
        data.setItemGroupBo(rs.getString(index++));
        data.setDeviceName(rs.getString(index++));
        data.setCustomer(rs.getString(index++));
        data.setCustomerItemsetName(rs.getString(index++));
        data.setCarrierBo(rs.getString(index++));
        data.setCarrierName(rs.getString(index++));
        data.setSlotNo(rs.getBigDecimal(index++));
        data.setPositionBo(rs.getString(index++));
        data.setBindingTime(DateUtils.getDateTz(rs, index++));
        data.setPackingTime(DateUtils.getDateTz(rs, index++));
        data.setState(rs.getString(index++));

        return data;
    }
}
