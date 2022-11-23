package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.Usr;
import uia.utils.dao.DateUtils;

public class UsrDao {

    private static final String SQL_INS = "INSERT INTO usr(handle,change_stamp,site,user_id,current_operation_bo,current_resource_bo,created_date_time,modified_date_time,badge_number,employee_number,hire_date,termination_date,allow_clock_in_non_prod,action_clock_out_sfc,clock_in_out_range,allow_sup_time_edit_appr,appr_req_for_export,auto_clock_out,clock_in_control,default_work_center_bo,erp_personnel_number,erp_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE usr SET change_stamp=?,site=?,user_id=?,current_operation_bo=?,current_resource_bo=?,created_date_time=?,modified_date_time=?,badge_number=?,employee_number=?,hire_date=?,termination_date=?,allow_clock_in_non_prod=?,action_clock_out_sfc=?,clock_in_out_range=?,allow_sup_time_edit_appr=?,appr_req_for_export=?,auto_clock_out=?,clock_in_control=?,default_work_center_bo=?,erp_personnel_number=?,erp_user=? WHERE handle=?";

    private static final String SQL_SEL = "SELECT handle,change_stamp,site,user_id,current_operation_bo,current_resource_bo,created_date_time,modified_date_time,badge_number,employee_number,hire_date,termination_date,allow_clock_in_non_prod,action_clock_out_sfc,clock_in_out_range,allow_sup_time_edit_appr,appr_req_for_export,auto_clock_out,clock_in_control,default_work_center_bo,erp_personnel_number,erp_user FROM usr ";
    
    private final Connection conn;

    public UsrDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(Usr data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getHandle());
            ps.setBigDecimal(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getUserId());
            ps.setString(5, data.getCurrentOperationBo());
            ps.setString(6, data.getCurrentResourceBo());
            DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
            ps.setString(9, data.getBadgeNumber());
            ps.setString(10, data.getEmployeeNumber());
            ps.setString(11, data.getHireDate());
            ps.setString(12, data.getTerminationDate());
            ps.setString(13, data.getAllowClockInNonProd());
            ps.setString(14, data.getActionClockOutSfc());
            ps.setString(15, data.getClockInOutRange());
            ps.setString(16, data.getAllowSupTimeEditAppr());
            ps.setString(17, data.getApprReqForExport());
            ps.setString(18, data.getAutoClockOut());
            ps.setString(19, data.getClockInControl());
            ps.setString(20, data.getDefaultWorkCenterBo());
            ps.setString(21, data.getErpPersonnelNumber());
            ps.setString(22, data.getErpUser());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<Usr> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(Usr data : dataList) {
            ps.setString(1, data.getHandle());
            ps.setBigDecimal(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getUserId());
            ps.setString(5, data.getCurrentOperationBo());
            ps.setString(6, data.getCurrentResourceBo());
            DateUtils.setDateTz(ps, 7, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());
            ps.setString(9, data.getBadgeNumber());
            ps.setString(10, data.getEmployeeNumber());
            ps.setString(11, data.getHireDate());
            ps.setString(12, data.getTerminationDate());
            ps.setString(13, data.getAllowClockInNonProd());
            ps.setString(14, data.getActionClockOutSfc());
            ps.setString(15, data.getClockInOutRange());
            ps.setString(16, data.getAllowSupTimeEditAppr());
            ps.setString(17, data.getApprReqForExport());
            ps.setString(18, data.getAutoClockOut());
            ps.setString(19, data.getClockInControl());
            ps.setString(20, data.getDefaultWorkCenterBo());
            ps.setString(21, data.getErpPersonnelNumber());
            ps.setString(22, data.getErpUser());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(Usr data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getChangeStamp());
            ps.setString(2, data.getSite());
            ps.setString(3, data.getUserId());
            ps.setString(4, data.getCurrentOperationBo());
            ps.setString(5, data.getCurrentResourceBo());
            DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
            ps.setString(8, data.getBadgeNumber());
            ps.setString(9, data.getEmployeeNumber());
            ps.setString(10, data.getHireDate());
            ps.setString(11, data.getTerminationDate());
            ps.setString(12, data.getAllowClockInNonProd());
            ps.setString(13, data.getActionClockOutSfc());
            ps.setString(14, data.getClockInOutRange());
            ps.setString(15, data.getAllowSupTimeEditAppr());
            ps.setString(16, data.getApprReqForExport());
            ps.setString(17, data.getAutoClockOut());
            ps.setString(18, data.getClockInControl());
            ps.setString(19, data.getDefaultWorkCenterBo());
            ps.setString(20, data.getErpPersonnelNumber());
            ps.setString(21, data.getErpUser());
            ps.setString(22, data.getHandle());

            return ps.executeUpdate();
        }
    }    

    public int update(List<Usr> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(Usr data : dataList) {
            ps.setBigDecimal(1, data.getChangeStamp());
            ps.setString(2, data.getSite());
            ps.setString(3, data.getUserId());
            ps.setString(4, data.getCurrentOperationBo());
            ps.setString(5, data.getCurrentResourceBo());
            DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
            ps.setString(8, data.getBadgeNumber());
            ps.setString(9, data.getEmployeeNumber());
            ps.setString(10, data.getHireDate());
            ps.setString(11, data.getTerminationDate());
            ps.setString(12, data.getAllowClockInNonProd());
            ps.setString(13, data.getActionClockOutSfc());
            ps.setString(14, data.getClockInOutRange());
            ps.setString(15, data.getAllowSupTimeEditAppr());
            ps.setString(16, data.getApprReqForExport());
            ps.setString(17, data.getAutoClockOut());
            ps.setString(18, data.getClockInControl());
            ps.setString(19, data.getDefaultWorkCenterBo());
            ps.setString(20, data.getErpPersonnelNumber());
            ps.setString(21, data.getErpUser());
            ps.setString(22, data.getHandle());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String handle) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usr WHERE handle=?")) {
            ps.setString(1, handle);

            return ps.executeUpdate();
        }
    }    

    public List<Usr> selectAll() throws SQLException {
        ArrayList<Usr> result = new ArrayList<Usr>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public Usr selectByPK(String handle) throws SQLException {
        Usr result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE handle=?")) {
            ps.setString(1, handle);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private Usr convert(ResultSet rs) throws SQLException {
        Usr data = new Usr();
        
        int index = 1;
        data.setHandle(rs.getString(index++));
        data.setChangeStamp(rs.getBigDecimal(index++));
        data.setSite(rs.getString(index++));
        data.setUserId(rs.getString(index++));
        data.setCurrentOperationBo(rs.getString(index++));
        data.setCurrentResourceBo(rs.getString(index++));
        data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
        data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
        data.setBadgeNumber(rs.getString(index++));
        data.setEmployeeNumber(rs.getString(index++));
        data.setHireDate(rs.getString(index++));
        data.setTerminationDate(rs.getString(index++));
        data.setAllowClockInNonProd(rs.getString(index++));
        data.setActionClockOutSfc(rs.getString(index++));
        data.setClockInOutRange(rs.getString(index++));
        data.setAllowSupTimeEditAppr(rs.getString(index++));
        data.setApprReqForExport(rs.getString(index++));
        data.setAutoClockOut(rs.getString(index++));
        data.setClockInControl(rs.getString(index++));
        data.setDefaultWorkCenterBo(rs.getString(index++));
        data.setErpPersonnelNumber(rs.getString(index++));
        data.setErpUser(rs.getString(index++));

        return data;
    }
}
