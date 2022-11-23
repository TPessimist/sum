package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdBuyOffAssignSfc;
import uia.utils.dao.DateUtils;

public class ZdBuyOffAssignSfcDao {

    private static final String SQL_INS = "INSERT INTO zd_buyoff_assign_sfc(sfc_bo,sfc_name,operation_bo,operation_name,reverse_field1,reverse_field2,created_user,created_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_buyoff_assign_sfc SET sfc_name=?,operation_name=?,reverse_field1=?,reverse_field2=?,created_user=?,created_time=? WHERE sfc_bo=? AND operation_bo=?";

    private static final String SQL_SEL = "SELECT sfc_bo,sfc_name,operation_bo,operation_name,reverse_field1,reverse_field2,created_user,created_time FROM zd_buyoff_assign_sfc ";
    
    private final Connection conn;

    public ZdBuyOffAssignSfcDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ZdBuyOffAssignSfc data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getSfcBo());
            ps.setString(2, data.getSfcName());
            ps.setString(3, data.getOperationBo());
            ps.setString(4, data.getOperationName());
            ps.setString(5, data.getReverseField1());
            ps.setString(6, data.getReverseField2());
            ps.setString(7, data.getCreatedUser());
            DateUtils.setDateTz(ps, 8, data.getCreatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ZdBuyOffAssignSfc> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ZdBuyOffAssignSfc data : dataList) {
            ps.setString(1, data.getSfcBo());
            ps.setString(2, data.getSfcName());
            ps.setString(3, data.getOperationBo());
            ps.setString(4, data.getOperationName());
            ps.setString(5, data.getReverseField1());
            ps.setString(6, data.getReverseField2());
            ps.setString(7, data.getCreatedUser());
            DateUtils.setDateTz(ps, 8, data.getCreatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ZdBuyOffAssignSfc data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getSfcName());
            ps.setString(2, data.getOperationName());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getCreatedUser());
            DateUtils.setDateTz(ps, 6, data.getCreatedTime());
            ps.setString(7, data.getSfcBo());
            ps.setString(8, data.getOperationBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ZdBuyOffAssignSfc> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ZdBuyOffAssignSfc data : dataList) {
            ps.setString(1, data.getSfcName());
            ps.setString(2, data.getOperationName());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getCreatedUser());
            DateUtils.setDateTz(ps, 6, data.getCreatedTime());
            ps.setString(7, data.getSfcBo());
            ps.setString(8, data.getOperationBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String sfcBo, String operationBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_buyoff_assign_sfc WHERE sfc_bo=? AND operation_bo=?")) {
            ps.setString(1, sfcBo);
            ps.setString(2, operationBo);

            return ps.executeUpdate();
        }
    }    

    public List<ZdBuyOffAssignSfc> selectAll() throws SQLException {
        ArrayList<ZdBuyOffAssignSfc> result = new ArrayList<ZdBuyOffAssignSfc>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ZdBuyOffAssignSfc selectByPK(String sfcBo, String operationBo) throws SQLException {
        ZdBuyOffAssignSfc result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE sfc_bo=? AND operation_bo=?")) {
            ps.setString(1, sfcBo);
            ps.setString(2, operationBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<ZdBuyOffAssignSfc>  selectByOperationAndRevf2(String operationBo,String reverseField2) throws SQLException {
        List<ZdBuyOffAssignSfc> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE operation_bo=? and reverse_field2 = ?")) {
            ps.setString(1, operationBo);
            ps.setString(2, reverseField2);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private ZdBuyOffAssignSfc convert(ResultSet rs) throws SQLException {
        ZdBuyOffAssignSfc data = new ZdBuyOffAssignSfc();
        
        int index = 1;
        data.setSfcBo(rs.getString(index++));
        data.setSfcName(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setOperationName(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setCreatedUser(rs.getString(index++));
        data.setCreatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
