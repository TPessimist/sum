package ame.psb.db.dao;

import ame.psb.db.FCResourceDataReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.FCResourceDataReport;
import uia.utils.dao.DateUtils;

public class FCResourceDataReportDao {

    private static final String SQL_INS = "INSERT INTO zd_fc_resource_data_report(resource_bo,report_name,report_value,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_fc_resource_data_report SET report_value=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE resource_bo=? AND report_name=?";

    private static final String SQL_SEL = "SELECT resource_bo,report_name,report_value,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_fc_resource_data_report ";
    
    private final Connection conn;

    public FCResourceDataReportDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(FCResourceDataReport data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getReportName());
            ps.setString(3, data.getReportValue());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<FCResourceDataReport> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(FCResourceDataReport data : dataList) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getReportName());
            ps.setString(3, data.getReportValue());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(FCResourceDataReport data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getReportValue());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getResourceBo());
            ps.setString(7, data.getReportName());

            return ps.executeUpdate();
        }
    }    

    public int update(List<FCResourceDataReport> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(FCResourceDataReport data : dataList) {
            ps.setString(1, data.getReportValue());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getResourceBo());
            ps.setString(7, data.getReportName());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String resourceBo, String peportName) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_fc_resource_data_peport WHERE resource_bo=? AND report_name=?")) {
            ps.setString(1, resourceBo);
            ps.setString(2, peportName);

            return ps.executeUpdate();
        }
    }    

    public List<FCResourceDataReport> selectAll() throws SQLException {
        ArrayList<FCResourceDataReport> result = new ArrayList<FCResourceDataReport>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public FCResourceDataReport selectByPK(String resourceBo, String peportName) throws SQLException {
        FCResourceDataReport result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE resource_bo=? AND report_name=?")) {
            ps.setString(1, resourceBo);
            ps.setString(2, peportName);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<FCResourceDataReport>  selectByResourceBo(String resourceBo) throws SQLException {
        List<FCResourceDataReport>  result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE resource_bo=? ")) {
            ps.setString(1, resourceBo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private FCResourceDataReport convert(ResultSet rs) throws SQLException {
        FCResourceDataReport data = new FCResourceDataReport();
        
        int index = 1;
        data.setResourceBo(rs.getString(index++));
        data.setReportName(rs.getString(index++));
        data.setReportValue(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
