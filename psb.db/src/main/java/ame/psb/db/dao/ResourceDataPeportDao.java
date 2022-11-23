package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ResourceDataPeport;
import uia.utils.dao.DateUtils;

public class ResourceDataPeportDao {

    private static final String SQL_INS = "INSERT INTO zd_resource_data_report(uuid,resource_bo,report_type,report_name,report_value,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_resource_data_report SET resource_bo=?,report_type=?,report_name=?,report_value=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,resource_bo,report_type,report_name,report_value,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_resource_data_report ";
    
    private final Connection conn;

    public ResourceDataPeportDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ResourceDataPeport data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getResourceBo());
            ps.setString(3, data.getReportType());
            ps.setString(4, data.getReportName());
            ps.setString(5, data.getReportValue());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ResourceDataPeport> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ResourceDataPeport data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getResourceBo());
            ps.setString(3, data.getReportType());
            ps.setString(4, data.getReportName());
            ps.setString(5, data.getReportValue());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ResourceDataPeport data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getReportType());
            ps.setString(3, data.getReportName());
            ps.setString(4, data.getReportValue());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ResourceDataPeport> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ResourceDataPeport data : dataList) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getReportType());
            ps.setString(3, data.getReportName());
            ps.setString(4, data.getReportValue());
            ps.setString(5, data.getReversedField1());
            ps.setString(6, data.getReversedField2());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
            ps.setString(9, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_resource_data_report WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<ResourceDataPeport> selectAll() throws SQLException {
        ArrayList<ResourceDataPeport> result = new ArrayList<ResourceDataPeport>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ResourceDataPeport selectByPK(String uuid) throws SQLException {
        ResourceDataPeport result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }

    public ResourceDataPeport selectByResourceAndTypeAndName(String resourceBo,String peportType,String peportName) throws SQLException {
        ResourceDataPeport result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE RESOURCE_BO = ? AND REPORT_TYPE =?  AND REPORT_NAME =?")) {
            ps.setString(1, resourceBo);
            ps.setString(2, peportType);
            ps.setString(3, peportName);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<ResourceDataPeport> selectByResourceAndTypeAndName(String resourceBo,String peportType) throws SQLException {
        List<ResourceDataPeport> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE RESOURCE_BO = ? AND REPORT_TYPE =?  ")) {
            ps.setString(1, resourceBo);
            ps.setString(2, peportType);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    private ResourceDataPeport convert(ResultSet rs) throws SQLException {
        ResourceDataPeport data = new ResourceDataPeport();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setResourceBo(rs.getString(index++));
        data.setReportType(rs.getString(index++));
        data.setReportName(rs.getString(index++));
        data.setReportValue(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
