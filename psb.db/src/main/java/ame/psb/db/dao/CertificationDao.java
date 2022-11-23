package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.Certification;
import uia.utils.dao.DateUtils;

public class CertificationDao {

    private static final String SQL_INS = "INSERT INTO certification(handle,change_stamp,site,certification,description,renewal_days,warning_days,warning_alarm_bo,expiration_alarm_bo,certification_type_bo,duration_type,duration,duration_units,status_bo,num_of_extensions,max_extension_duration,extension_units,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE certification SET change_stamp=?,site=?,certification=?,description=?,renewal_days=?,warning_days=?,warning_alarm_bo=?,expiration_alarm_bo=?,certification_type_bo=?,duration_type=?,duration=?,duration_units=?,status_bo=?,num_of_extensions=?,max_extension_duration=?,extension_units=?,created_date_time=?,modified_date_time=? WHERE handle=?";

    private static final String SQL_SEL = "SELECT handle,change_stamp,site,certification,description,renewal_days,warning_days,warning_alarm_bo,expiration_alarm_bo,certification_type_bo,duration_type,duration,duration_units,status_bo,num_of_extensions,max_extension_duration,extension_units,created_date_time,modified_date_time FROM certification ";
    
    private final Connection conn;

    public CertificationDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(Certification data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getHandle());
            ps.setBigDecimal(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getCertification());
            ps.setString(5, data.getDescription());
            ps.setBigDecimal(6, data.getRenewalDays());
            ps.setBigDecimal(7, data.getWarningDays());
            ps.setString(8, data.getWarningAlarmBo());
            ps.setString(9, data.getExpirationAlarmBo());
            ps.setString(10, data.getCertificationTypeBo());
            ps.setString(11, data.getDurationType());
            ps.setBigDecimal(12, data.getDuration());
            ps.setString(13, data.getDurationUnits());
            ps.setString(14, data.getStatusBo());
            ps.setBigDecimal(15, data.getNumOfExtensions());
            ps.setBigDecimal(16, data.getMaxExtensionDuration());
            ps.setString(17, data.getExtensionUnits());
            DateUtils.setDateTz(ps, 18, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 19, data.getModifiedDateTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<Certification> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(Certification data : dataList) {
            ps.setString(1, data.getHandle());
            ps.setBigDecimal(2, data.getChangeStamp());
            ps.setString(3, data.getSite());
            ps.setString(4, data.getCertification());
            ps.setString(5, data.getDescription());
            ps.setBigDecimal(6, data.getRenewalDays());
            ps.setBigDecimal(7, data.getWarningDays());
            ps.setString(8, data.getWarningAlarmBo());
            ps.setString(9, data.getExpirationAlarmBo());
            ps.setString(10, data.getCertificationTypeBo());
            ps.setString(11, data.getDurationType());
            ps.setBigDecimal(12, data.getDuration());
            ps.setString(13, data.getDurationUnits());
            ps.setString(14, data.getStatusBo());
            ps.setBigDecimal(15, data.getNumOfExtensions());
            ps.setBigDecimal(16, data.getMaxExtensionDuration());
            ps.setString(17, data.getExtensionUnits());
            DateUtils.setDateTz(ps, 18, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 19, data.getModifiedDateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(Certification data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getChangeStamp());
            ps.setString(2, data.getSite());
            ps.setString(3, data.getCertification());
            ps.setString(4, data.getDescription());
            ps.setBigDecimal(5, data.getRenewalDays());
            ps.setBigDecimal(6, data.getWarningDays());
            ps.setString(7, data.getWarningAlarmBo());
            ps.setString(8, data.getExpirationAlarmBo());
            ps.setString(9, data.getCertificationTypeBo());
            ps.setString(10, data.getDurationType());
            ps.setBigDecimal(11, data.getDuration());
            ps.setString(12, data.getDurationUnits());
            ps.setString(13, data.getStatusBo());
            ps.setBigDecimal(14, data.getNumOfExtensions());
            ps.setBigDecimal(15, data.getMaxExtensionDuration());
            ps.setString(16, data.getExtensionUnits());
            DateUtils.setDateTz(ps, 17, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 18, data.getModifiedDateTime());
            ps.setString(19, data.getHandle());

            return ps.executeUpdate();
        }
    }    

    public int update(List<Certification> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(Certification data : dataList) {
            ps.setBigDecimal(1, data.getChangeStamp());
            ps.setString(2, data.getSite());
            ps.setString(3, data.getCertification());
            ps.setString(4, data.getDescription());
            ps.setBigDecimal(5, data.getRenewalDays());
            ps.setBigDecimal(6, data.getWarningDays());
            ps.setString(7, data.getWarningAlarmBo());
            ps.setString(8, data.getExpirationAlarmBo());
            ps.setString(9, data.getCertificationTypeBo());
            ps.setString(10, data.getDurationType());
            ps.setBigDecimal(11, data.getDuration());
            ps.setString(12, data.getDurationUnits());
            ps.setString(13, data.getStatusBo());
            ps.setBigDecimal(14, data.getNumOfExtensions());
            ps.setBigDecimal(15, data.getMaxExtensionDuration());
            ps.setString(16, data.getExtensionUnits());
            DateUtils.setDateTz(ps, 17, data.getCreatedDateTime());
            DateUtils.setDateTz(ps, 18, data.getModifiedDateTime());
            ps.setString(19, data.getHandle());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String handle) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM certification WHERE handle=?")) {
            ps.setString(1, handle);

            return ps.executeUpdate();
        }
    }    

    public List<Certification> selectAll() throws SQLException {
        ArrayList<Certification> result = new ArrayList<Certification>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public Certification selectByPK(String handle) throws SQLException {
        Certification result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE handle=?")) {
            ps.setString(1, handle);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private Certification convert(ResultSet rs) throws SQLException {
        Certification data = new Certification();
        
        int index = 1;
        data.setHandle(rs.getString(index++));
        data.setChangeStamp(rs.getBigDecimal(index++));
        data.setSite(rs.getString(index++));
        data.setCertification(rs.getString(index++));
        data.setDescription(rs.getString(index++));
        data.setRenewalDays(rs.getBigDecimal(index++));
        data.setWarningDays(rs.getBigDecimal(index++));
        data.setWarningAlarmBo(rs.getString(index++));
        data.setExpirationAlarmBo(rs.getString(index++));
        data.setCertificationTypeBo(rs.getString(index++));
        data.setDurationType(rs.getString(index++));
        data.setDuration(rs.getBigDecimal(index++));
        data.setDurationUnits(rs.getString(index++));
        data.setStatusBo(rs.getString(index++));
        data.setNumOfExtensions(rs.getBigDecimal(index++));
        data.setMaxExtensionDuration(rs.getBigDecimal(index++));
        data.setExtensionUnits(rs.getString(index++));
        data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
        data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
