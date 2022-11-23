package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PdmGoldenBuyOffOperationParamRule;
import uia.utils.dao.DateUtils;

public class PdmGoldenBuyOffOperationParamRuleDao {

    private static final String SQL_INS = "INSERT INTO zd_pdm_golden_buy_off_operation_param_rule(recipe_buy_off_operation_bo,recipe_setup_operation_bo,process_type,process_operation,recipe_description,recipe_buy_off_param,recipe_buy_off_wafer_type,remark,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_pdm_golden_buy_off_operation_param_rule SET process_type=?,process_operation=?,recipe_description=?,recipe_buy_off_param=?,recipe_buy_off_wafer_type=?,remark=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE recipe_buy_off_operation_bo=? AND recipe_setup_operation_bo=?";

    private static final String SQL_SEL = "SELECT recipe_buy_off_operation_bo,recipe_setup_operation_bo,process_type,process_operation,recipe_description,recipe_buy_off_param,recipe_buy_off_wafer_type,remark,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_pdm_golden_buy_off_operation_param_rule ";
    
    private final Connection conn;

    public PdmGoldenBuyOffOperationParamRuleDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PdmGoldenBuyOffOperationParamRule data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getRecipeBuyOffOperationBo());
            ps.setString(2, data.getRecipeSetupOperationBo());
            ps.setString(3, data.getProcessType());
            ps.setString(4, data.getProcessOperation());
            ps.setString(5, data.getRecipeDescription());
            ps.setString(6, data.getRecipeBuyOffParam());
            ps.setString(7, data.getRecipeBuyOffWaferType());
            ps.setString(8, data.getRemark());
            ps.setString(9, data.getReversedField1());
            ps.setString(10, data.getReversedField2());
            ps.setString(11, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PdmGoldenBuyOffOperationParamRule> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PdmGoldenBuyOffOperationParamRule data : dataList) {
            ps.setString(1, data.getRecipeBuyOffOperationBo());
            ps.setString(2, data.getRecipeSetupOperationBo());
            ps.setString(3, data.getProcessType());
            ps.setString(4, data.getProcessOperation());
            ps.setString(5, data.getRecipeDescription());
            ps.setString(6, data.getRecipeBuyOffParam());
            ps.setString(7, data.getRecipeBuyOffWaferType());
            ps.setString(8, data.getRemark());
            ps.setString(9, data.getReversedField1());
            ps.setString(10, data.getReversedField2());
            ps.setString(11, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PdmGoldenBuyOffOperationParamRule data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getProcessType());
            ps.setString(2, data.getProcessOperation());
            ps.setString(3, data.getRecipeDescription());
            ps.setString(4, data.getRecipeBuyOffParam());
            ps.setString(5, data.getRecipeBuyOffWaferType());
            ps.setString(6, data.getRemark());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
            ps.setString(11, data.getRecipeBuyOffOperationBo());
            ps.setString(12, data.getRecipeSetupOperationBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PdmGoldenBuyOffOperationParamRule> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PdmGoldenBuyOffOperationParamRule data : dataList) {
            ps.setString(1, data.getProcessType());
            ps.setString(2, data.getProcessOperation());
            ps.setString(3, data.getRecipeDescription());
            ps.setString(4, data.getRecipeBuyOffParam());
            ps.setString(5, data.getRecipeBuyOffWaferType());
            ps.setString(6, data.getRemark());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
            ps.setString(11, data.getRecipeBuyOffOperationBo());
            ps.setString(12, data.getRecipeSetupOperationBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String recipeBuyOffOperationBo, String recipeSetupOperationBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pdm_golden_buy_off_operation_param_rule WHERE recipe_buy_off_operation_bo=? AND recipe_setup_operation_bo=?")) {
            ps.setString(1, recipeBuyOffOperationBo);
            ps.setString(2, recipeSetupOperationBo);

            return ps.executeUpdate();
        }
    }    

    public List<PdmGoldenBuyOffOperationParamRule> selectAll() throws SQLException {
        ArrayList<PdmGoldenBuyOffOperationParamRule> result = new ArrayList<PdmGoldenBuyOffOperationParamRule>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PdmGoldenBuyOffOperationParamRule selectByPK(String recipeBuyOffOperationBo, String recipeSetupOperationBo) throws SQLException {
        PdmGoldenBuyOffOperationParamRule result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE recipe_buy_off_operation_bo=? AND recipe_setup_operation_bo=?")) {
            ps.setString(1, recipeBuyOffOperationBo);
            ps.setString(2, recipeSetupOperationBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public PdmGoldenBuyOffOperationParamRule selectByRecipeBuyOffOperationBo(String recipeBuyOffOperationBo) throws SQLException {
        PdmGoldenBuyOffOperationParamRule result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE recipe_buy_off_operation_bo=? ")) {
            ps.setString(1, recipeBuyOffOperationBo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    /**
     * ykq
     * 2021年11月8日14:44:50
     * @param operationType
     * @return
     * @throws SQLException
     */
    public List<PdmGoldenBuyOffOperationParamRule> selectByPKOperation(String operationType) throws SQLException {
        ArrayList<PdmGoldenBuyOffOperationParamRule> result = new ArrayList<PdmGoldenBuyOffOperationParamRule>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE PROCESS_OPERATION=?")) {
            ps.setString(1, operationType);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    public PdmGoldenBuyOffOperationParamRule selectByPKRecipeBuyoffOperationBo(String recipeBuyoffOperationBo) throws SQLException {
       PdmGoldenBuyOffOperationParamRule result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE RECIPE_BUY_OFF_OPERATION_BO=?")) {
            ps.setString(1, recipeBuyoffOperationBo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result= convert(rs);
            }
            return result;
        }
    }


    public List<PdmGoldenBuyOffOperationParamRule> selectBySetUpOperationBo(String recipeBuyOffSetUpOperationBo) throws SQLException {
        ArrayList<PdmGoldenBuyOffOperationParamRule> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE RECIPE_SETUP_OPERATION_BO=?")) {
            ps.setString(1, recipeBuyOffSetUpOperationBo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    private PdmGoldenBuyOffOperationParamRule convert(ResultSet rs) throws SQLException {
        PdmGoldenBuyOffOperationParamRule data = new PdmGoldenBuyOffOperationParamRule();
        
        int index = 1;
        data.setRecipeBuyOffOperationBo(rs.getString(index++));
        data.setRecipeSetupOperationBo(rs.getString(index++));
        data.setProcessType(rs.getString(index++));
        data.setProcessOperation(rs.getString(index++));
        data.setRecipeDescription(rs.getString(index++));
        data.setRecipeBuyOffParam(rs.getString(index++));
        data.setRecipeBuyOffWaferType(rs.getString(index++));
        data.setRemark(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
