package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.TestYkq;

public class TestYkqDao {

    private static final String SQL_INS = "INSERT INTO zr_test_ykq(id,name,test_column1,test_column2,test_column3,test_column4,test_column5,test_column6,test_column7,test_column8,test_column9,test_column10,test_column11,test_column12) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_test_ykq SET name=?,test_column1=?,test_column2=?,test_column3=?,test_column4=?,test_column5=?,test_column6=?,test_column7=?,test_column8=?,test_column9=?,test_column10=?,test_column11=?,test_column12=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,name,test_column1,test_column2,test_column3,test_column4,test_column5,test_column6,test_column7,test_column8,test_column9,test_column10,test_column11,test_column12 FROM zr_test_ykq ";
    
    private final Connection conn;

    public TestYkqDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(TestYkq data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getName());
            ps.setString(3, data.getTestColumn1());
            ps.setString(4, data.getTestColumn2());
            ps.setString(5, data.getTestColumn3());
            ps.setString(6, data.getTestColumn4());
            ps.setString(7, data.getTestColumn5());
            ps.setString(8, data.getTestColumn6());
            ps.setString(9, data.getTestColumn7());
            ps.setString(10, data.getTestColumn8());
            ps.setString(11, data.getTestColumn9());
            ps.setString(12, data.getTestColumn10());
            ps.setString(13, data.getTestColumn11());
            ps.setString(14, data.getTestColumn12());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<TestYkq> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(TestYkq data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getName());
            ps.setString(3, data.getTestColumn1());
            ps.setString(4, data.getTestColumn2());
            ps.setString(5, data.getTestColumn3());
            ps.setString(6, data.getTestColumn4());
            ps.setString(7, data.getTestColumn5());
            ps.setString(8, data.getTestColumn6());
            ps.setString(9, data.getTestColumn7());
            ps.setString(10, data.getTestColumn8());
            ps.setString(11, data.getTestColumn9());
            ps.setString(12, data.getTestColumn10());
            ps.setString(13, data.getTestColumn11());
            ps.setString(14, data.getTestColumn12());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(TestYkq data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getName());
            ps.setString(2, data.getTestColumn1());
            ps.setString(3, data.getTestColumn2());
            ps.setString(4, data.getTestColumn3());
            ps.setString(5, data.getTestColumn4());
            ps.setString(6, data.getTestColumn5());
            ps.setString(7, data.getTestColumn6());
            ps.setString(8, data.getTestColumn7());
            ps.setString(9, data.getTestColumn8());
            ps.setString(10, data.getTestColumn9());
            ps.setString(11, data.getTestColumn10());
            ps.setString(12, data.getTestColumn11());
            ps.setString(13, data.getTestColumn12());
            ps.setString(14, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<TestYkq> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(TestYkq data : dataList) {
            ps.setString(1, data.getName());
            ps.setString(2, data.getTestColumn1());
            ps.setString(3, data.getTestColumn2());
            ps.setString(4, data.getTestColumn3());
            ps.setString(5, data.getTestColumn4());
            ps.setString(6, data.getTestColumn5());
            ps.setString(7, data.getTestColumn6());
            ps.setString(8, data.getTestColumn7());
            ps.setString(9, data.getTestColumn8());
            ps.setString(10, data.getTestColumn9());
            ps.setString(11, data.getTestColumn10());
            ps.setString(12, data.getTestColumn11());
            ps.setString(13, data.getTestColumn12());
            ps.setString(14, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_test_ykq WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<TestYkq> selectAll() throws SQLException {
        ArrayList<TestYkq> result = new ArrayList<TestYkq>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public TestYkq selectByPK(String id) throws SQLException {
        TestYkq result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private TestYkq convert(ResultSet rs) throws SQLException {
        TestYkq data = new TestYkq();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setName(rs.getString(index++));
        data.setTestColumn1(rs.getString(index++));
        data.setTestColumn2(rs.getString(index++));
        data.setTestColumn3(rs.getString(index++));
        data.setTestColumn4(rs.getString(index++));
        data.setTestColumn5(rs.getString(index++));
        data.setTestColumn6(rs.getString(index++));
        data.setTestColumn7(rs.getString(index++));
        data.setTestColumn8(rs.getString(index++));
        data.setTestColumn9(rs.getString(index++));
        data.setTestColumn10(rs.getString(index++));
        data.setTestColumn11(rs.getString(index++));
        data.setTestColumn12(rs.getString(index++));

        return data;
    }
}
