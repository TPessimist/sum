package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PdmLog;
import uia.utils.dao.DateUtils;

public class PdmLogDao {

    private static final String SQL_INS = "INSERT INTO zd_pdm_log(uuid,pdm_type,batch_id,reverse_field1,reverse_field2,reverse_field3,reverse_field4,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_pdm_log SET pdm_type=?,batch_id=?,reverse_field1=?,reverse_field2=?,reverse_field3=?,reverse_field4=?,update_user=?,update_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,pdm_type,batch_id,reverse_field1,reverse_field2,reverse_field3,reverse_field4,update_user,update_time FROM zd_pdm_log ";
    
    private final Connection conn;

    public PdmLogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PdmLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getPdmType());
            ps.setString(3, data.getBatchId());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getReverseField3());
            ps.setString(7, data.getReverseField4());
            ps.setString(8, data.getUpdateUser());
            DateUtils.setDateTz(ps, 9, data.getUpdateTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PdmLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PdmLog data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getPdmType());
            ps.setString(3, data.getBatchId());
            ps.setString(4, data.getReverseField1());
            ps.setString(5, data.getReverseField2());
            ps.setString(6, data.getReverseField3());
            ps.setString(7, data.getReverseField4());
            ps.setString(8, data.getUpdateUser());
            DateUtils.setDateTz(ps, 9, data.getUpdateTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PdmLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getPdmType());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getReverseField3());
            ps.setString(6, data.getReverseField4());
            ps.setString(7, data.getUpdateUser());
            DateUtils.setDateTz(ps, 8, data.getUpdateTime());
            ps.setString(9, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PdmLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PdmLog data : dataList) {
            ps.setString(1, data.getPdmType());
            ps.setString(2, data.getBatchId());
            ps.setString(3, data.getReverseField1());
            ps.setString(4, data.getReverseField2());
            ps.setString(5, data.getReverseField3());
            ps.setString(6, data.getReverseField4());
            ps.setString(7, data.getUpdateUser());
            DateUtils.setDateTz(ps, 8, data.getUpdateTime());
            ps.setString(9, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pdm_log WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<PdmLog> selectAll() throws SQLException {
        ArrayList<PdmLog> result = new ArrayList<PdmLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public PdmLog selectByPK(String uuid) throws SQLException {
        PdmLog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private PdmLog convert(ResultSet rs) throws SQLException {
        PdmLog data = new PdmLog();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setPdmType(rs.getString(index++));
        data.setBatchId(rs.getString(index++));
        data.setReverseField1(rs.getString(index++));
        data.setReverseField2(rs.getString(index++));
        data.setReverseField3(rs.getString(index++));
        data.setReverseField4(rs.getString(index++));
        data.setUpdateUser(rs.getString(index++));
        data.setUpdateTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
