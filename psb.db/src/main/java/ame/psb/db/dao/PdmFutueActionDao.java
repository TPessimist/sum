package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PdmFutueAction;
import uia.utils.dao.DateUtils;

public class PdmFutueActionDao {

    private static final String SQL_INS = "INSERT INTO zd_pdm_futureaction(uuid,state_name,item_bo,operation_bo,reverse_field1,reverse_field2,reverse_field3,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_pdm_futureaction SET state_name=?,item_bo=?,operation_bo=?,reverse_field1=?,reverse_field2=?,reverse_field3=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,state_name,item_bo,operation_bo,reverse_field1,reverse_field2,reverse_field3,updated_user,updated_time FROM zd_pdm_futureaction ";
    
    private final Connection conn;

    public PdmFutueActionDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PdmFutueAction data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getStateName());
            ps.setString(3, data.getItemBo());
            ps.setString(4, data.getOperationBo());
            ps.setString(5, data.getReverseField1());
            ps.setString(6, data.getReverseField2());
            ps.setString(7, data.getReverseField3());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PdmFutueAction> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PdmFutueAction data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getStateName());
            ps.setString(3, data.getItemBo());
            ps.setString(4, data.getOperationBo());
            ps.setString(5, data.getReverseField1());
            ps.setString(6, data.getReverseField2());
            ps.setString(7, data.getReverseField3());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PdmFutueAction data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getStateName());
            ps.setString(2, data.getItemBo());
            ps.setString(3, data.getOperationBo());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getReverseField3());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PdmFutueAction> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PdmFutueAction data : dataList) {
            ps.setString(1, data.getStateName());
            ps.setString(2, data.getItemBo());
            ps.setString(3, data.getOperationBo());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getReverseField3());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pdm_futureaction WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<PdmFutueAction> selectAll() throws SQLException {
        ArrayList<PdmFutueAction> result = new ArrayList<PdmFutueAction>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PdmFutueAction selectByPK(String uuid) throws SQLException {
        PdmFutueAction result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<PdmFutueAction> selectByItemAndOperation(String itemBo,String operationBo,String stateName) throws SQLException {
        List<PdmFutueAction> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE  item_bo = ? AND operation_bo =? and state_name = ?")) {
            ps.setString(1, itemBo);
            ps.setString(2, operationBo);
            ps.setString(3, stateName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private PdmFutueAction convert(ResultSet rs) throws SQLException {
        PdmFutueAction data = new PdmFutueAction();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setStateName(rs.getString(index++));
        data.setItemBo(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setReverseField3(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
