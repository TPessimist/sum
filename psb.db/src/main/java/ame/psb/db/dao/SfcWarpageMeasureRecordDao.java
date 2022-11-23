package ame.psb.db.dao;

import ame.psb.db.SfcWarpageMeasureRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SfcWarpageMeasureRecordDao {

    private static final String SQL_INS = "INSERT INTO zd_sfc_warpage_measure_record(sfc_bo,measure_data1,measure_data2,measure_data3,measure_data4,measure_data5,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_sfc_warpage_measure_record SET measure_data1=?,measure_data2=?,measure_data3=?,measure_data4=?,measure_data5=?,reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE sfc_bo=?";

    private static final String SQL_SEL = "SELECT sfc_bo,measure_data1,measure_data2,measure_data3,measure_data4,measure_data5,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_sfc_warpage_measure_record ";
    
    private final Connection conn;

    public SfcWarpageMeasureRecordDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(SfcWarpageMeasureRecord data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getSfcBo());
            ps.setBigDecimal(2, data.getMeasureData1());
            ps.setBigDecimal(3, data.getMeasureData2());
            ps.setBigDecimal(4, data.getMeasureData3());
            ps.setBigDecimal(5, data.getMeasureData4());
            ps.setBigDecimal(6, data.getMeasureData5());
            ps.setString(7, data.getReserveField1());
            ps.setString(8, data.getReserveField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<SfcWarpageMeasureRecord> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(SfcWarpageMeasureRecord data : dataList) {
            ps.setString(1, data.getSfcBo());
            ps.setBigDecimal(2, data.getMeasureData1());
            ps.setBigDecimal(3, data.getMeasureData2());
            ps.setBigDecimal(4, data.getMeasureData3());
            ps.setBigDecimal(5, data.getMeasureData4());
            ps.setBigDecimal(6, data.getMeasureData5());
            ps.setString(7, data.getReserveField1());
            ps.setString(8, data.getReserveField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(SfcWarpageMeasureRecord data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getMeasureData1());
            ps.setBigDecimal(2, data.getMeasureData2());
            ps.setBigDecimal(3, data.getMeasureData3());
            ps.setBigDecimal(4, data.getMeasureData4());
            ps.setBigDecimal(5, data.getMeasureData5());
            ps.setString(6, data.getReserveField1());
            ps.setString(7, data.getReserveField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
            ps.setString(10, data.getSfcBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<SfcWarpageMeasureRecord> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(SfcWarpageMeasureRecord data : dataList) {
            ps.setBigDecimal(1, data.getMeasureData1());
            ps.setBigDecimal(2, data.getMeasureData2());
            ps.setBigDecimal(3, data.getMeasureData3());
            ps.setBigDecimal(4, data.getMeasureData4());
            ps.setBigDecimal(5, data.getMeasureData5());
            ps.setString(6, data.getReserveField1());
            ps.setString(7, data.getReserveField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
            ps.setString(10, data.getSfcBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String sfcBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_sfc_warpage_measure_record WHERE sfc_bo=?")) {
            ps.setString(1, sfcBo);

            return ps.executeUpdate();
        }
    }    

    public List<SfcWarpageMeasureRecord> selectAll() throws SQLException {
        ArrayList<SfcWarpageMeasureRecord> result = new ArrayList<SfcWarpageMeasureRecord>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public SfcWarpageMeasureRecord selectByPK(String sfcBo) throws SQLException {
        SfcWarpageMeasureRecord result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE sfc_bo=?")) {
            ps.setString(1, sfcBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private SfcWarpageMeasureRecord convert(ResultSet rs) throws SQLException {
        SfcWarpageMeasureRecord data = new SfcWarpageMeasureRecord();
        
        int index = 1;
        data.setSfcBo(rs.getString(index++));
        data.setMeasureData1(rs.getBigDecimal(index++));
        data.setMeasureData2(rs.getBigDecimal(index++));
        data.setMeasureData3(rs.getBigDecimal(index++));
        data.setMeasureData4(rs.getBigDecimal(index++));
        data.setMeasureData5(rs.getBigDecimal(index++));
        data.setReserveField1(rs.getString(index++));
        data.setReserveField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
