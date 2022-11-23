package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PDMBuyOffOperationParamValue;
import uia.utils.dao.DateUtils;

public class PDMBuyOffOperationParamValueDao {

    private static final String SQL_INS = "INSERT INTO zd_pdm_buy_off_operation_param_value(item_group_bo,operation_bo,param_name,param_value,param_type,param_description,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_pdm_buy_off_operation_param_value SET param_value=?,param_type=?,param_description=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND operation_bo=? AND param_name=?";

    private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,param_name,param_value,param_type,param_description,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_pdm_buy_off_operation_param_value ";
    
    private final Connection conn;

    public PDMBuyOffOperationParamValueDao(Connection conn) {
        this.conn = conn;
    }


    public void insertOrUpdate(PDMBuyOffOperationParamValue pdmBuyOffOperationParamValue)
        throws SQLException {

        PDMBuyOffOperationParamValue pdmBuyOffOperationParamValue1 = selectByPK(
            pdmBuyOffOperationParamValue.getItemGroupBo(),
            pdmBuyOffOperationParamValue.getOperationBo(),
            pdmBuyOffOperationParamValue.getParamName());

        if(null == pdmBuyOffOperationParamValue1)
            insert(pdmBuyOffOperationParamValue);
        else
            update(pdmBuyOffOperationParamValue);

    }

    public int insert(PDMBuyOffOperationParamValue data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getItemGroupBo());
            ps.setString(2, data.getOperationBo());
            ps.setString(3, data.getParamName());
            ps.setString(4, data.getParamValue());
            ps.setString(5, data.getParamType());
            ps.setString(6, data.getParamDescription());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PDMBuyOffOperationParamValue> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PDMBuyOffOperationParamValue data : dataList) {
            ps.setString(1, data.getItemGroupBo());
            ps.setString(2, data.getOperationBo());
            ps.setString(3, data.getParamName());
            ps.setString(4, data.getParamValue());
            ps.setString(5, data.getParamType());
            ps.setString(6, data.getParamDescription());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PDMBuyOffOperationParamValue data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getParamValue());
            ps.setString(2, data.getParamType());
            ps.setString(3, data.getParamDescription());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getItemGroupBo());
            ps.setString(9, data.getOperationBo());
            ps.setString(10, data.getParamName());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PDMBuyOffOperationParamValue> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PDMBuyOffOperationParamValue data : dataList) {
            ps.setString(1, data.getParamValue());
            ps.setString(2, data.getParamType());
            ps.setString(3, data.getParamDescription());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getItemGroupBo());
            ps.setString(9, data.getOperationBo());
            ps.setString(10, data.getParamName());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String itemGroupBo, String operationBo, String paramName) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pdm_buy_off_operation_param_value WHERE item_group_bo=? AND operation_bo=? AND param_name=?")) {
            ps.setString(1, itemGroupBo);
            ps.setString(2, operationBo);
            ps.setString(3, paramName);

            return ps.executeUpdate();
        }
    }    

    public List<PDMBuyOffOperationParamValue> selectAll() throws SQLException {
        ArrayList<PDMBuyOffOperationParamValue> result = new ArrayList<PDMBuyOffOperationParamValue>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PDMBuyOffOperationParamValue selectByPK(String itemGroupBo, String operationBo, String paramName) throws SQLException {
        PDMBuyOffOperationParamValue result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_group_bo=? AND operation_bo=? AND param_name=?")) {
            ps.setString(1, itemGroupBo);
            ps.setString(2, operationBo);
            ps.setString(3, paramName);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<PDMBuyOffOperationParamValue> selectByPKItemGroupBo(String itemGroupBo) throws SQLException {
        List<PDMBuyOffOperationParamValue> result = new ArrayList<PDMBuyOffOperationParamValue>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_group_bo=? ")) {
            ps.setString(1, itemGroupBo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private PDMBuyOffOperationParamValue convert(ResultSet rs) throws SQLException {
        PDMBuyOffOperationParamValue data = new PDMBuyOffOperationParamValue();
        
        int index = 1;
        data.setItemGroupBo(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setParamName(rs.getString(index++));
        data.setParamValue(rs.getString(index++));
        data.setParamType(rs.getString(index++));
        data.setParamDescription(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
