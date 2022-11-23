package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewZdInventory;
import uia.utils.dao.DateUtils;

public class ViewZdInventoryDao {

    private static final String SQL_INS = "INSERT INTO view_zd_inventory(handle,change_stamp,site,inventory_id,item_bo,inventory_context_gbo,description,qty_on_hand,assy_data_type_bo,usage_count,maximum_usage,status_bo,original_qty,work_center_loc_bo,work_center_loc_res,operation_loc_bo,operation_loc_res,resource_loc_bo,resource_loc_res,shop_order_loc_bo,shop_order_loc_res,shop_order_set_by_erp,original_user_bo,storage_location_bo,has_been_used,receive_date_time,created_date_time,modified_date_time,partition_date,parent_inventory_bo,erp_inventory,type,state_name,resource_slot_id,picked_user,updated_user,updated_time,install_user,install_time,valid_to,resource,sup_sn,prd_date,eff_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE view_zd_inventory SET change_stamp=?,site=?,inventory_id=?,item_bo=?,inventory_context_gbo=?,description=?,qty_on_hand=?,assy_data_type_bo=?,usage_count=?,maximum_usage=?,status_bo=?,original_qty=?,work_center_loc_bo=?,work_center_loc_res=?,operation_loc_bo=?,operation_loc_res=?,resource_loc_bo=?,resource_loc_res=?,shop_order_loc_bo=?,shop_order_loc_res=?,shop_order_set_by_erp=?,original_user_bo=?,storage_location_bo=?,has_been_used=?,receive_date_time=?,created_date_time=?,modified_date_time=?,partition_date=?,parent_inventory_bo=?,erp_inventory=?,type=?,state_name=?,resource_slot_id=?,picked_user=?,updated_user=?,updated_time=?,install_user=?,install_time=?,valid_to=?,resource=?,sup_sn=?,prd_date=?,eff_date=? WHERE handle=?";

    private static final String SQL_SEL = "SELECT handle,change_stamp,site,inventory_id,item_bo,inventory_context_gbo,description,qty_on_hand,assy_data_type_bo,usage_count,maximum_usage,status_bo,original_qty,work_center_loc_bo,work_center_loc_res,operation_loc_bo,operation_loc_res,resource_loc_bo,resource_loc_res,shop_order_loc_bo,shop_order_loc_res,shop_order_set_by_erp,original_user_bo,storage_location_bo,has_been_used,receive_date_time,created_date_time,modified_date_time,partition_date,parent_inventory_bo,erp_inventory,type,state_name,resource_slot_id,picked_user,updated_user,updated_time,install_user,install_time,valid_to,resource,sup_sn,prd_date,eff_date FROM view_zd_inventory ";
    
    private final Connection conn;

    public ViewZdInventoryDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ViewZdInventory data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getHandle());
            ps.setBigDecimal(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getInventoryId());
            ps.setString(5, data.getItemBo());
            ps.setString(6, data.getInventoryContextGbo());
            ps.setString(7, data.getDescription());
            ps.setBigDecimal(8, data.getQtyOnHand());
            ps.setString(9, data.getAssyDataTypeBo());
            ps.setBigDecimal(10, data.getUsageCount());
            ps.setBigDecimal(11, data.getMaximumUsage());
            ps.setString(12, data.getStatusBo());
            ps.setBigDecimal(13, data.getOriginalQty());
            ps.setString(14, data.getWorkCenterLocBo());
            ps.setString(15, data.getWorkCenterLocRes());
            ps.setString(16, data.getOperationLocBo());
            ps.setString(17, data.getOperationLocRes());
            ps.setString(18, data.getResourceLocBo());
            ps.setString(19, data.getResourceLocRes());
            ps.setString(20, data.getShopOrderLocBo());
            ps.setString(21, data.getShopOrderLocRes());
            ps.setString(22, data.getShopOrderSetByErp());
            ps.setString(23, data.getOriginalUserBo());
            ps.setString(24, data.getStorageLocationBo());
            ps.setString(25, data.getHasBeenUsed());
            DateUtils.setDateTz(ps, 26, data.getReceiveDateTime());
            DateUtils.setDateTz(ps, 27, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 28, data.getModifiedDateTime());
            DateUtils.setDateTz(ps, 29, data.getPartitionDate());
            ps.setString(30, data.getParentInventoryBo());
            ps.setString(31, data.getErpInventory());
            ps.setString(32, data.getType());
            ps.setString(33, data.getStateName());
            ps.setString(34, data.getResourceSlotId());
            ps.setString(35, data.getPickedUser());
            ps.setString(36, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 37, data.getUpdatedTime());
            ps.setString(38, data.getInstallUser());
            DateUtils.setDateTz(ps, 39, data.getInstallTime());
            DateUtils.setDateTz(ps, 40, data.getValidTo());
            ps.setString(41, data.getResource());
            ps.setString(42, data.getSupSn());
            ps.setString(43, data.getPrdDate());
            ps.setString(44, data.getEffDate());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ViewZdInventory> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ViewZdInventory data : dataList) {
            ps.setString(1, data.getHandle());
            ps.setBigDecimal(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getInventoryId());
            ps.setString(5, data.getItemBo());
            ps.setString(6, data.getInventoryContextGbo());
            ps.setString(7, data.getDescription());
            ps.setBigDecimal(8, data.getQtyOnHand());
            ps.setString(9, data.getAssyDataTypeBo());
            ps.setBigDecimal(10, data.getUsageCount());
            ps.setBigDecimal(11, data.getMaximumUsage());
            ps.setString(12, data.getStatusBo());
            ps.setBigDecimal(13, data.getOriginalQty());
            ps.setString(14, data.getWorkCenterLocBo());
            ps.setString(15, data.getWorkCenterLocRes());
            ps.setString(16, data.getOperationLocBo());
            ps.setString(17, data.getOperationLocRes());
            ps.setString(18, data.getResourceLocBo());
            ps.setString(19, data.getResourceLocRes());
            ps.setString(20, data.getShopOrderLocBo());
            ps.setString(21, data.getShopOrderLocRes());
            ps.setString(22, data.getShopOrderSetByErp());
            ps.setString(23, data.getOriginalUserBo());
            ps.setString(24, data.getStorageLocationBo());
            ps.setString(25, data.getHasBeenUsed());
            DateUtils.setDateTz(ps, 26, data.getReceiveDateTime());
            DateUtils.setDateTz(ps, 27, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 28, data.getModifiedDateTime());
            DateUtils.setDateTz(ps, 29, data.getPartitionDate());
            ps.setString(30, data.getParentInventoryBo());
            ps.setString(31, data.getErpInventory());
            ps.setString(32, data.getType());
            ps.setString(33, data.getStateName());
            ps.setString(34, data.getResourceSlotId());
            ps.setString(35, data.getPickedUser());
            ps.setString(36, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 37, data.getUpdatedTime());
            ps.setString(38, data.getInstallUser());
            DateUtils.setDateTz(ps, 39, data.getInstallTime());
            DateUtils.setDateTz(ps, 40, data.getValidTo());
            ps.setString(41, data.getResource());
            ps.setString(42, data.getSupSn());
            ps.setString(43, data.getPrdDate());
            ps.setString(44, data.getEffDate());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ViewZdInventory data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getChangeStamp());
            ps.setString(2, data.getSite());
            ps.setString(3, data.getInventoryId());
            ps.setString(4, data.getItemBo());
            ps.setString(5, data.getInventoryContextGbo());
            ps.setString(6, data.getDescription());
            ps.setBigDecimal(7, data.getQtyOnHand());
            ps.setString(8, data.getAssyDataTypeBo());
            ps.setBigDecimal(9, data.getUsageCount());
            ps.setBigDecimal(10, data.getMaximumUsage());
            ps.setString(11, data.getStatusBo());
            ps.setBigDecimal(12, data.getOriginalQty());
            ps.setString(13, data.getWorkCenterLocBo());
            ps.setString(14, data.getWorkCenterLocRes());
            ps.setString(15, data.getOperationLocBo());
            ps.setString(16, data.getOperationLocRes());
            ps.setString(17, data.getResourceLocBo());
            ps.setString(18, data.getResourceLocRes());
            ps.setString(19, data.getShopOrderLocBo());
            ps.setString(20, data.getShopOrderLocRes());
            ps.setString(21, data.getShopOrderSetByErp());
            ps.setString(22, data.getOriginalUserBo());
            ps.setString(23, data.getStorageLocationBo());
            ps.setString(24, data.getHasBeenUsed());
            DateUtils.setDateTz(ps, 25, data.getReceiveDateTime());
            DateUtils.setDateTz(ps, 26, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 27, data.getModifiedDateTime());
            DateUtils.setDateTz(ps, 28, data.getPartitionDate());
            ps.setString(29, data.getParentInventoryBo());
            ps.setString(30, data.getErpInventory());
            ps.setString(31, data.getType());
            ps.setString(32, data.getStateName());
            ps.setString(33, data.getResourceSlotId());
            ps.setString(34, data.getPickedUser());
            ps.setString(35, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 36, data.getUpdatedTime());
            ps.setString(37, data.getInstallUser());
            DateUtils.setDateTz(ps, 38, data.getInstallTime());
            DateUtils.setDateTz(ps, 39, data.getValidTo());
            ps.setString(40, data.getResource());
            ps.setString(41, data.getSupSn());
            ps.setString(42, data.getPrdDate());
            ps.setString(43, data.getEffDate());
            ps.setString(44, data.getHandle());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ViewZdInventory> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ViewZdInventory data : dataList) {
            ps.setBigDecimal(1, data.getChangeStamp());
            ps.setString(2, data.getSite());
            ps.setString(3, data.getInventoryId());
            ps.setString(4, data.getItemBo());
            ps.setString(5, data.getInventoryContextGbo());
            ps.setString(6, data.getDescription());
            ps.setBigDecimal(7, data.getQtyOnHand());
            ps.setString(8, data.getAssyDataTypeBo());
            ps.setBigDecimal(9, data.getUsageCount());
            ps.setBigDecimal(10, data.getMaximumUsage());
            ps.setString(11, data.getStatusBo());
            ps.setBigDecimal(12, data.getOriginalQty());
            ps.setString(13, data.getWorkCenterLocBo());
            ps.setString(14, data.getWorkCenterLocRes());
            ps.setString(15, data.getOperationLocBo());
            ps.setString(16, data.getOperationLocRes());
            ps.setString(17, data.getResourceLocBo());
            ps.setString(18, data.getResourceLocRes());
            ps.setString(19, data.getShopOrderLocBo());
            ps.setString(20, data.getShopOrderLocRes());
            ps.setString(21, data.getShopOrderSetByErp());
            ps.setString(22, data.getOriginalUserBo());
            ps.setString(23, data.getStorageLocationBo());
            ps.setString(24, data.getHasBeenUsed());
            DateUtils.setDateTz(ps, 25, data.getReceiveDateTime());
            DateUtils.setDateTz(ps, 26, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 27, data.getModifiedDateTime());
            DateUtils.setDateTz(ps, 28, data.getPartitionDate());
            ps.setString(29, data.getParentInventoryBo());
            ps.setString(30, data.getErpInventory());
            ps.setString(31, data.getType());
            ps.setString(32, data.getStateName());
            ps.setString(33, data.getResourceSlotId());
            ps.setString(34, data.getPickedUser());
            ps.setString(35, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 36, data.getUpdatedTime());
            ps.setString(37, data.getInstallUser());
            DateUtils.setDateTz(ps, 38, data.getInstallTime());
            DateUtils.setDateTz(ps, 39, data.getValidTo());
            ps.setString(40, data.getResource());
            ps.setString(41, data.getSupSn());
            ps.setString(42, data.getPrdDate());
            ps.setString(43, data.getEffDate());
            ps.setString(44, data.getHandle());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String handle) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM view_zd_inventory WHERE handle=?")) {
            ps.setString(1, handle);

            return ps.executeUpdate();
        }
    }    

    public List<ViewZdInventory> selectAll() throws SQLException {
        ArrayList<ViewZdInventory> result = new ArrayList<ViewZdInventory>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ViewZdInventory selectByPK(String handle) throws SQLException {
        ViewZdInventory result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE handle=?")) {
            ps.setString(1, handle);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public ViewZdInventory selectByNeedFristPick(String itemBo , String now) throws SQLException {
        ViewZdInventory result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_bo=? AND eff_date IS NOT NULL AND eff_date >? AND (state_name = 'STORE' OR state_name = 'STORELINE' )  order by eff_date , handle")) {
            ps.setString(1, itemBo);
            ps.setString(2, now);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }


    public ViewZdInventory selectByItemAndStorageLocation(String itemBo ,String now,  String Location) throws SQLException {
        ViewZdInventory result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_bo=? AND eff_date IS NOT NULL AND eff_date >? AND (state_name = 'STORE' OR state_name = 'STORELINE' ) AND storage_location_bo =? order by eff_date , handle")) {
            ps.setString(1, itemBo);
            ps.setString(2, now);
            ps.setString(3, Location);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public List<ViewZdInventory> selectFristPickList(String itemBo ,String now,  String Location) throws SQLException {
        ArrayList<ViewZdInventory> result = new ArrayList<ViewZdInventory>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL +"WHERE item_bo=? AND eff_date = ? AND (state_name = 'STORE' OR state_name = 'STORELINE' ) AND storage_location_bo =? order by eff_date , handle")) {
            ps.setString(1, itemBo);
            ps.setString(2, now);
            ps.setString(3, Location);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private ViewZdInventory convert(ResultSet rs) throws SQLException {
        ViewZdInventory data = new ViewZdInventory();
        
        int index = 1;
        data.setHandle(rs.getString(index++));
        data.setChangeStamp(rs.getBigDecimal(index++));
        data.setSite(rs.getString(index++));
        data.setInventoryId(rs.getString(index++));
        data.setItemBo(rs.getString(index++));
        data.setInventoryContextGbo(rs.getString(index++));
        data.setDescription(rs.getString(index++));
        data.setQtyOnHand(rs.getBigDecimal(index++));
        data.setAssyDataTypeBo(rs.getString(index++));
        data.setUsageCount(rs.getBigDecimal(index++));
        data.setMaximumUsage(rs.getBigDecimal(index++));
        data.setStatusBo(rs.getString(index++));
        data.setOriginalQty(rs.getBigDecimal(index++));
        data.setWorkCenterLocBo(rs.getString(index++));
        data.setWorkCenterLocRes(rs.getString(index++));
        data.setOperationLocBo(rs.getString(index++));
        data.setOperationLocRes(rs.getString(index++));
        data.setResourceLocBo(rs.getString(index++));
        data.setResourceLocRes(rs.getString(index++));
        data.setShopOrderLocBo(rs.getString(index++));
        data.setShopOrderLocRes(rs.getString(index++));
        data.setShopOrderSetByErp(rs.getString(index++));
        data.setOriginalUserBo(rs.getString(index++));
        data.setStorageLocationBo(rs.getString(index++));
        data.setHasBeenUsed(rs.getString(index++));
        data.setReceiveDateTime(DateUtils.getDateTz(rs, index++));
        data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
        data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
        data.setPartitionDate(DateUtils.getDateTz(rs, index++));
        data.setParentInventoryBo(rs.getString(index++));
        data.setErpInventory(rs.getString(index++));
        data.setType(rs.getString(index++));
        data.setStateName(rs.getString(index++));
        data.setResourceSlotId(rs.getString(index++));
        data.setPickedUser(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
        data.setInstallUser(rs.getString(index++));
        data.setInstallTime(DateUtils.getDateTz(rs, index++));
        data.setValidTo(DateUtils.getDateTz(rs, index++));
        data.setResource(rs.getString(index++));
        data.setSupSn(rs.getString(index++));
        data.setPrdDate(rs.getString(index++));
        data.setEffDate(rs.getString(index++));

        return data;
    }
}
