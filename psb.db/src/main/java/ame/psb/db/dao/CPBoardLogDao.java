package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.CPBoardLog;
import uia.utils.dao.DateUtils;

public class CPBoardLogDao {

    private static final String SQL_INS = "INSERT INTO zr_cp_board_log(uuid,type,test_column1,test_column2,test_column3,test_column4,reverse_field1,reverse_field2,reverse_field3,reverse_field4,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_cp_board_log SET type=?,test_column1=?,test_column2=?,test_column3=?,test_column4=?,reverse_field1=?,reverse_field2=?,reverse_field3=?,reverse_field4=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,type,test_column1,test_column2,test_column3,test_column4,reverse_field1,reverse_field2,reverse_field3,reverse_field4,updated_user,updated_time FROM zr_cp_board_log ";
    
    private final Connection conn;

    public CPBoardLogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(CPBoardLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getType());
            ps.setString(3, data.getTestColumn1());
            ps.setString(4, data.getTestColumn2());
            ps.setString(5, data.getTestColumn3());
            ps.setString(6, data.getTestColumn4());
            ps.setString(7, data.getReverseField1());
            ps.setString(8, data.getReverseField2());
            ps.setString(9, data.getReverseField3());
            ps.setString(10, data.getReverseField4());
            ps.setString(11, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<CPBoardLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(CPBoardLog data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getType());
            ps.setString(3, data.getTestColumn1());
            ps.setString(4, data.getTestColumn2());
            ps.setString(5, data.getTestColumn3());
            ps.setString(6, data.getTestColumn4());
            ps.setString(7, data.getReverseField1());
            ps.setString(8, data.getReverseField2());
            ps.setString(9, data.getReverseField3());
            ps.setString(10, data.getReverseField4());
            ps.setString(11, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(CPBoardLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getType());
            ps.setString(2, data.getTestColumn1());
            ps.setString(3, data.getTestColumn2());
            ps.setString(4, data.getTestColumn3());
            ps.setString(5, data.getTestColumn4());
            ps.setString(6, data.getReverseField1());
            ps.setString(7, data.getReverseField2());
            ps.setString(8, data.getReverseField3());
            ps.setString(9, data.getReverseField4());
            ps.setString(10, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
            ps.setString(12, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<CPBoardLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(CPBoardLog data : dataList) {
            ps.setString(1, data.getType());
            ps.setString(2, data.getTestColumn1());
            ps.setString(3, data.getTestColumn2());
            ps.setString(4, data.getTestColumn3());
            ps.setString(5, data.getTestColumn4());
            ps.setString(6, data.getReverseField1());
            ps.setString(7, data.getReverseField2());
            ps.setString(8, data.getReverseField3());
            ps.setString(9, data.getReverseField4());
            ps.setString(10, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
            ps.setString(12, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_cp_board_log WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<CPBoardLog> selectAll() throws SQLException {
        ArrayList<CPBoardLog> result = new ArrayList<CPBoardLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public CPBoardLog selectByPK(String uuid) throws SQLException {
        CPBoardLog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private CPBoardLog convert(ResultSet rs) throws SQLException {
        CPBoardLog data = new CPBoardLog();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setType(rs.getString(index++));
        data.setTestColumn1(rs.getString(index++));
        data.setTestColumn2(rs.getString(index++));
        data.setTestColumn3(rs.getString(index++));
        data.setTestColumn4(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setReverseField3(rs.getString(index++));
        data.setReverseField4(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
