package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.CPEQCSamplingPlan;
import uia.utils.dao.DateUtils;

public class CPEQCSamplingPlanDao {

    private static final String SQL_INS = "INSERT INTO zd_cp_eqc_sampling_plan(id,eqc_sampling_plan_type,item_group_bo,lot_type,operation_bo,begin_qty,center_qty,end_qty,shop_order_bo,customer_item_bo,status,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_cp_eqc_sampling_plan SET eqc_sampling_plan_type=?,item_group_bo=?,lot_type=?,operation_bo=?,begin_qty=?,center_qty=?,end_qty=?,shop_order_bo=?,customer_item_bo=?,status=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,eqc_sampling_plan_type,item_group_bo,lot_type,operation_bo,begin_qty,center_qty,end_qty,shop_order_bo,customer_item_bo,status,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_cp_eqc_sampling_plan ";
    
    private final Connection conn;

    public CPEQCSamplingPlanDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(CPEQCSamplingPlan data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getEqcSamplingPlanType());
            ps.setString(3, data.getItemGroupBo());
            ps.setString(4, data.getLotType());
            ps.setString(5, data.getOperationBo());
            ps.setBigDecimal(6, data.getBeginQty());
            ps.setBigDecimal(7, data.getCenterQty());
            ps.setBigDecimal(8, data.getEndQty());
            ps.setString(9, data.getShopOrderBo());
            ps.setString(10, data.getCustomerItemBo());
            ps.setString(11, data.getStatus());
            ps.setString(12, data.getReversedField1());
            ps.setString(13, data.getReversedField2());
            ps.setString(14, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<CPEQCSamplingPlan> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(CPEQCSamplingPlan data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getEqcSamplingPlanType());
            ps.setString(3, data.getItemGroupBo());
            ps.setString(4, data.getLotType());
            ps.setString(5, data.getOperationBo());
            ps.setBigDecimal(6, data.getBeginQty());
            ps.setBigDecimal(7, data.getCenterQty());
            ps.setBigDecimal(8, data.getEndQty());
            ps.setString(9, data.getShopOrderBo());
            ps.setString(10, data.getCustomerItemBo());
            ps.setString(11, data.getStatus());
            ps.setString(12, data.getReversedField1());
            ps.setString(13, data.getReversedField2());
            ps.setString(14, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(CPEQCSamplingPlan data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getEqcSamplingPlanType());
            ps.setString(2, data.getItemGroupBo());
            ps.setString(3, data.getLotType());
            ps.setString(4, data.getOperationBo());
            ps.setBigDecimal(5, data.getBeginQty());
            ps.setBigDecimal(6, data.getCenterQty());
            ps.setBigDecimal(7, data.getEndQty());
            ps.setString(8, data.getShopOrderBo());
            ps.setString(9, data.getCustomerItemBo());
            ps.setString(10, data.getStatus());
            ps.setString(11, data.getReversedField1());
            ps.setString(12, data.getReversedField2());
            ps.setString(13, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
            ps.setString(15, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<CPEQCSamplingPlan> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(CPEQCSamplingPlan data : dataList) {
            ps.setString(1, data.getEqcSamplingPlanType());
            ps.setString(2, data.getItemGroupBo());
            ps.setString(3, data.getLotType());
            ps.setString(4, data.getOperationBo());
            ps.setBigDecimal(5, data.getBeginQty());
            ps.setBigDecimal(6, data.getCenterQty());
            ps.setBigDecimal(7, data.getEndQty());
            ps.setString(8, data.getShopOrderBo());
            ps.setString(9, data.getCustomerItemBo());
            ps.setString(10, data.getStatus());
            ps.setString(11, data.getReversedField1());
            ps.setString(12, data.getReversedField2());
            ps.setString(13, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
            ps.setString(15, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_cp_eqc_sampling_plan WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<CPEQCSamplingPlan> selectAll() throws SQLException {
        ArrayList<CPEQCSamplingPlan> result = new ArrayList<CPEQCSamplingPlan>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<CPEQCSamplingPlan> selectByShopOrderBoAndCustomerItemBo(
        String type, String shopOrderBo, String customerItemBo) throws SQLException {
        ArrayList<CPEQCSamplingPlan> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
         + " where EQC_SAMPLING_PLAN_TYPE = ? AND SHOP_ORDER_BO = ? AND CUSTOMER_ITEM_BO = ? AND STATUS = 'ENABLE'")) {
            ps.setString(1, type);
            ps.setString(2, shopOrderBo);
            ps.setString(3, customerItemBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<CPEQCSamplingPlan> selectByItemGroupBoAndLotTypeAndOperationBo(
        String type, String itemGroupBo, String lotType, String operationBo) throws SQLException {
        ArrayList<CPEQCSamplingPlan> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
            + " where EQC_SAMPLING_PLAN_TYPE = ? AND ITEM_GROUP_BO = ? AND LOT_TYPE = ? AND OPERATION_BO = ? AND STATUS = 'ENABLE'")) {
            ps.setString(1, type);
            ps.setString(2, itemGroupBo);
            ps.setString(3, lotType);
            ps.setString(4, operationBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public List<CPEQCSamplingPlan> selectByItemGroupBo(String type, String itemGroupBo) throws SQLException {
        ArrayList<CPEQCSamplingPlan> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
            + " where EQC_SAMPLING_PLAN_TYPE = ? AND ITEM_GROUP_BO = ? ")) {
            ps.setString(1, type);
            ps.setString(2, itemGroupBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public List<CPEQCSamplingPlan> selectByShopOrderBo(String type, String shopOrderBo) throws SQLException {
        ArrayList<CPEQCSamplingPlan> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
            + " where EQC_SAMPLING_PLAN_TYPE = ? AND SHOP_ORDER_BO = ? ")) {
            ps.setString(1, type);
            ps.setString(2, shopOrderBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public CPEQCSamplingPlan selectByPK(String id) throws SQLException {
        CPEQCSamplingPlan result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private CPEQCSamplingPlan convert(ResultSet rs) throws SQLException {
        CPEQCSamplingPlan data = new CPEQCSamplingPlan();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setEqcSamplingPlanType(rs.getString(index++));
        data.setItemGroupBo(rs.getString(index++));
        data.setLotType(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setBeginQty(rs.getBigDecimal(index++));
        data.setCenterQty(rs.getBigDecimal(index++));
        data.setEndQty(rs.getBigDecimal(index++));
        data.setShopOrderBo(rs.getString(index++));
        data.setCustomerItemBo(rs.getString(index++));
        data.setStatus(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
