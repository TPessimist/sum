package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.CPEQCSamplingResult;
import uia.utils.dao.DateUtils;

public class CPEQCSamplingResultDao {

    private static final String SQL_INS = "INSERT INTO zr_cp_eqc_sampling_result(id,eqc_sampling_plan_bo,eqc_sampling_plan_type,item_group_bo,carrier_bo,sfc_bo,shop_order_bo,customer_item_bo,customer_item_name,operation_bo,status,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_cp_eqc_sampling_result SET eqc_sampling_plan_bo=?,eqc_sampling_plan_type=?,item_group_bo=?,carrier_bo=?,sfc_bo=?,shop_order_bo=?,customer_item_bo=?,customer_item_name=?,operation_bo=?,status=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,eqc_sampling_plan_bo,eqc_sampling_plan_type,item_group_bo,carrier_bo,sfc_bo,shop_order_bo,customer_item_bo,customer_item_name,operation_bo,status,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_cp_eqc_sampling_result ";
    
    private final Connection conn;

    public CPEQCSamplingResultDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(CPEQCSamplingResult data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getEqcSamplingPlanBo());
            ps.setString(3, data.getEqcSamplingPlanType());
            ps.setString(4, data.getItemGroupBo());
            ps.setString(5, data.getCarrierBo());
            ps.setString(6, data.getSfcBo());
            ps.setString(7, data.getShopOrderBo());
            ps.setString(8, data.getCustomerItemBo());
            ps.setString(9, data.getCustomerItemName());
            ps.setString(10, data.getOperationBo());
            ps.setString(11, data.getStatus());
            ps.setString(12, data.getReversedField1());
            ps.setString(13, data.getReversedField2());
            ps.setString(14, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<CPEQCSamplingResult> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(CPEQCSamplingResult data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getEqcSamplingPlanBo());
            ps.setString(3, data.getEqcSamplingPlanType());
            ps.setString(4, data.getItemGroupBo());
            ps.setString(5, data.getCarrierBo());
            ps.setString(6, data.getSfcBo());
            ps.setString(7, data.getShopOrderBo());
            ps.setString(8, data.getCustomerItemBo());
            ps.setString(9, data.getCustomerItemName());
            ps.setString(10, data.getOperationBo());
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

    public int update(CPEQCSamplingResult data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getEqcSamplingPlanBo());
            ps.setString(2, data.getEqcSamplingPlanType());
            ps.setString(3, data.getItemGroupBo());
            ps.setString(4, data.getCarrierBo());
            ps.setString(5, data.getSfcBo());
            ps.setString(6, data.getShopOrderBo());
            ps.setString(7, data.getCustomerItemBo());
            ps.setString(8, data.getCustomerItemName());
            ps.setString(9, data.getOperationBo());
            ps.setString(10, data.getStatus());
            ps.setString(11, data.getReversedField1());
            ps.setString(12, data.getReversedField2());
            ps.setString(13, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
            ps.setString(15, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<CPEQCSamplingResult> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(CPEQCSamplingResult data : dataList) {
            ps.setString(1, data.getEqcSamplingPlanBo());
            ps.setString(2, data.getEqcSamplingPlanType());
            ps.setString(3, data.getItemGroupBo());
            ps.setString(4, data.getCarrierBo());
            ps.setString(5, data.getSfcBo());
            ps.setString(6, data.getShopOrderBo());
            ps.setString(7, data.getCustomerItemBo());
            ps.setString(8, data.getCustomerItemName());
            ps.setString(9, data.getOperationBo());
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
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_cp_eqc_sampling_result WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<CPEQCSamplingResult> selectAll() throws SQLException {
        ArrayList<CPEQCSamplingResult> result = new ArrayList<CPEQCSamplingResult>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    public List<CPEQCSamplingResult> selectByShopOrderBoAndCustomerItemBoAndOperationBo(String shopOrderBo, String customerItemBo, String operationBo) throws SQLException {
        ArrayList<CPEQCSamplingResult> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE SHOP_ORDER_BO = ? AND CUSTOMER_ITEM_BO = ? AND OPERATION_BO = ? AND STATUS = 'ENABLE'")) {
            ps.setString(1, shopOrderBo);
            ps.setString(2, customerItemBo);
            ps.setString(3, operationBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<CPEQCSamplingResult> selectByCarrierBoAndOperationBo(String carrierBo, String operationBo) throws SQLException {
        ArrayList<CPEQCSamplingResult> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE CARRIER_BO = ? AND OPERATION_BO = ? AND STATUS = 'ENABLE'")) {
            ps.setString(1, carrierBo);
            ps.setString(2, operationBo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public CPEQCSamplingResult selectByPK(String id) throws SQLException {
        CPEQCSamplingResult result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private CPEQCSamplingResult convert(ResultSet rs) throws SQLException {
        CPEQCSamplingResult data = new CPEQCSamplingResult();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setEqcSamplingPlanBo(rs.getString(index++));
        data.setEqcSamplingPlanType(rs.getString(index++));
        data.setItemGroupBo(rs.getString(index++));
        data.setCarrierBo(rs.getString(index++));
        data.setSfcBo(rs.getString(index++));
        data.setShopOrderBo(rs.getString(index++));
        data.setCustomerItemBo(rs.getString(index++));
        data.setCustomerItemName(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setStatus(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
