package ame.psb.db.dao;

import ame.htks.db.ToolMaintainLog;
import ame.htks.db.ViewTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewOperationTool;
import uia.utils.dao.DateUtils;

public class ViewOperationToolDao {

    private static final String SQL_INS = "INSERT INTO view_operation_tool(tool_number_bo,operation_bo,tool_number,status_bo,tool_group_bo,description,calibration_type,exp_date,tool_limit_times,tool_usage,sum_limit_times,sum_usage,update_user,event_datetime,current_status,comments,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE view_operation_tool SET operation_bo=?,tool_number=?,status_bo=?,tool_group_bo=?,description=?,calibration_type=?,exp_date=?,tool_limit_times=?,tool_usage=?,sum_limit_times=?,sum_usage=?,update_user=?,event_datetime=?,current_status=?,comments=?,update_time=? WHERE tool_number_bo=?";

    private static final String SQL_SEL = "SELECT tool_number_bo,operation_bo,tool_number,status_bo,tool_group_bo,description,calibration_type,exp_date,tool_limit_times,tool_usage,sum_limit_times,sum_usage,update_user,event_datetime,current_status,comments,update_time FROM view_operation_tool ";
    
    private final Connection conn;

    public ViewOperationToolDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ViewOperationTool data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getToolNumberBo());
            ps.setString(2, data.getOperationBo());
            ps.setString(3, data.getToolNumber());
            ps.setString(4, data.getStatusBo());
            ps.setString(5, data.getToolGroupBo());
            ps.setString(6, data.getDescription());
            ps.setString(7, data.getCalibrationType());
            DateUtils.setDateTz(ps, 8, data.getExpDate());
            ps.setBigDecimal(9, data.getToolLimitTimes());
            ps.setBigDecimal(10, data.getToolUsage());
            ps.setBigDecimal(11, data.getSumLimitTimes());
            ps.setBigDecimal(12, data.getSumUsage());
            ps.setString(13, data.getUpdateUser());
            DateUtils.setDateTz(ps, 14, data.getEventDatetime());
            ps.setString(15, data.getCurrentStatus());
            ps.setString(16, data.getComments());
            DateUtils.setDateTz(ps, 17, data.getUpdateTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ViewOperationTool> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ViewOperationTool data : dataList) {
            ps.setString(1, data.getToolNumberBo());
            ps.setString(2, data.getOperationBo());
            ps.setString(3, data.getToolNumber());
            ps.setString(4, data.getStatusBo());
            ps.setString(5, data.getToolGroupBo());
            ps.setString(6, data.getDescription());
            ps.setString(7, data.getCalibrationType());
            DateUtils.setDateTz(ps, 8, data.getExpDate());
            ps.setBigDecimal(9, data.getToolLimitTimes());
            ps.setBigDecimal(10, data.getToolUsage());
            ps.setBigDecimal(11, data.getSumLimitTimes());
            ps.setBigDecimal(12, data.getSumUsage());
            ps.setString(13, data.getUpdateUser());
            DateUtils.setDateTz(ps, 14, data.getEventDatetime());
            ps.setString(15, data.getCurrentStatus());
            ps.setString(16, data.getComments());
            DateUtils.setDateTz(ps, 17, data.getUpdateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ViewOperationTool data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getOperationBo());
            ps.setString(2, data.getToolNumber());
            ps.setString(3, data.getStatusBo());
            ps.setString(4, data.getToolGroupBo());
            ps.setString(5, data.getDescription());
            ps.setString(6, data.getCalibrationType());
            DateUtils.setDateTz(ps, 7, data.getExpDate());
            ps.setBigDecimal(8, data.getToolLimitTimes());
            ps.setBigDecimal(9, data.getToolUsage());
            ps.setBigDecimal(10, data.getSumLimitTimes());
            ps.setBigDecimal(11, data.getSumUsage());
            ps.setString(12, data.getUpdateUser());
            DateUtils.setDateTz(ps, 13, data.getEventDatetime());
            ps.setString(14, data.getCurrentStatus());
            ps.setString(15, data.getComments());
            DateUtils.setDateTz(ps, 16, data.getUpdateTime());
            ps.setString(17, data.getToolNumberBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ViewOperationTool> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ViewOperationTool data : dataList) {
            ps.setString(1, data.getOperationBo());
            ps.setString(2, data.getToolNumber());
            ps.setString(3, data.getStatusBo());
            ps.setString(4, data.getToolGroupBo());
            ps.setString(5, data.getDescription());
            ps.setString(6, data.getCalibrationType());
            DateUtils.setDateTz(ps, 7, data.getExpDate());
            ps.setBigDecimal(8, data.getToolLimitTimes());
            ps.setBigDecimal(9, data.getToolUsage());
            ps.setBigDecimal(10, data.getSumLimitTimes());
            ps.setBigDecimal(11, data.getSumUsage());
            ps.setString(12, data.getUpdateUser());
            DateUtils.setDateTz(ps, 13, data.getEventDatetime());
            ps.setString(14, data.getCurrentStatus());
            ps.setString(15, data.getComments());
            DateUtils.setDateTz(ps, 16, data.getUpdateTime());
            ps.setString(17, data.getToolNumberBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String toolNumberBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM view_operation_tool WHERE tool_number_bo=?")) {
            ps.setString(1, toolNumberBo);

            return ps.executeUpdate();
        }
    }    

    public List<ViewOperationTool> selectAll() throws SQLException {
        ArrayList<ViewOperationTool> result = new ArrayList<ViewOperationTool>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    public ViewOperationTool selectByToolNumberBoAndOperationBo(String toolNumberBo,String operationBo) throws SQLException {
        ViewOperationTool result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE tool_number_bo=? and OPERATION_BO =?")) {
            ps.setString(1, toolNumberBo);
            ps.setString(2, operationBo);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public ViewOperationTool selectByPK(String toolNumberBo) throws SQLException {
        ViewOperationTool result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE tool_number_bo=?")) {
            ps.setString(1, toolNumberBo);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<ViewOperationTool> selectByPKList(String toolNumberBo) throws SQLException {
        List<ViewOperationTool> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE tool_number_bo=?")) {
            ps.setString(1, toolNumberBo);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private ViewOperationTool convert(ResultSet rs) throws SQLException {
        ViewOperationTool data = new ViewOperationTool();
        
        int index = 1;
        data.setToolNumberBo(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setToolNumber(rs.getString(index++));
        data.setStatusBo(rs.getString(index++));
        data.setToolGroupBo(rs.getString(index++));
        data.setDescription(rs.getString(index++));
        data.setCalibrationType(rs.getString(index++));
        data.setExpDate(DateUtils.getDateTz(rs, index++));
        data.setToolLimitTimes(rs.getBigDecimal(index++));
        data.setToolUsage(rs.getBigDecimal(index++));
        data.setSumLimitTimes(rs.getBigDecimal(index++));
        data.setSumUsage(rs.getBigDecimal(index++));
        data.setUpdateUser(rs.getString(index++));
        data.setEventDatetime(DateUtils.getDateTz(rs, index++));
        data.setCurrentStatus(rs.getString(index++));
        data.setComments(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
