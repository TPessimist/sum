package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ZdChartSetup;
import uia.utils.dao.DateUtils;

public class ZdChartSetupDao {

    private static final String SQL_INS = "INSERT INTO zd_chart_setup(uuid,chart_id,operation,dc_group,dc_parameter,tolerance,point,tooling1,tooling2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_chart_setup SET chart_id=?,operation=?,dc_group=?,dc_parameter=?,tolerance=?,point=?,tooling1=?,tooling2=?,updated_user=?,updated_time=? WHERE uuid=?";

    private static final String SQL_SEL = "SELECT uuid,chart_id,operation,dc_group,dc_parameter,tolerance,point,tooling1,tooling2,updated_user,updated_time FROM zd_chart_setup ";
    
    private final Connection conn;

    public ZdChartSetupDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ZdChartSetup data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getChartId());
            ps.setString(3, data.getOperation());
            ps.setString(4, data.getDcGroup());
            ps.setString(5, data.getDcParameter());
            ps.setString(6, data.getTolerance());
            ps.setString(7, data.getPoint());
            ps.setString(8, data.getTooling1());
            ps.setString(9, data.getTooling2());
            ps.setString(10, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ZdChartSetup> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ZdChartSetup data : dataList) {
            ps.setString(1, data.getUuid());
            ps.setString(2, data.getChartId());
            ps.setString(3, data.getOperation());
            ps.setString(4, data.getDcGroup());
            ps.setString(5, data.getDcParameter());
            ps.setString(6, data.getTolerance());
            ps.setString(7, data.getPoint());
            ps.setString(8, data.getTooling1());
            ps.setString(9, data.getTooling2());
            ps.setString(10, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ZdChartSetup data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getChartId());
            ps.setString(2, data.getOperation());
            ps.setString(3, data.getDcGroup());
            ps.setString(4, data.getDcParameter());
            ps.setString(5, data.getTolerance());
            ps.setString(6, data.getPoint());
            ps.setString(7, data.getTooling1());
            ps.setString(8, data.getTooling2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
            ps.setString(11, data.getUuid());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ZdChartSetup> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ZdChartSetup data : dataList) {
            ps.setString(1, data.getChartId());
            ps.setString(2, data.getOperation());
            ps.setString(3, data.getDcGroup());
            ps.setString(4, data.getDcParameter());
            ps.setString(5, data.getTolerance());
            ps.setString(6, data.getPoint());
            ps.setString(7, data.getTooling1());
            ps.setString(8, data.getTooling2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
            ps.setString(11, data.getUuid());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String uuid) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_chart_setup WHERE uuid=?")) {
            ps.setString(1, uuid);

            return ps.executeUpdate();
        }
    }    

    public List<ZdChartSetup> selectAll() throws SQLException {
        ArrayList<ZdChartSetup> result = new ArrayList<ZdChartSetup>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ZdChartSetup selectByPK(String uuid) throws SQLException {
        ZdChartSetup result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
            ps.setString(1, uuid);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
//    public ZdChartSetup selectByPK(String uuid) throws SQLException {
//        ZdChartSetup result = null;
//        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE uuid=?")) {
//            ps.setString(1, uuid);
//
//
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()) {
//                result = convert(rs);
//            }
//            return result;
//        }
//    }
    private ZdChartSetup convert(ResultSet rs) throws SQLException {
        ZdChartSetup data = new ZdChartSetup();
        
        int index = 1;
        data.setUuid(rs.getString(index++));
        data.setChartId(rs.getString(index++));
        data.setOperation(rs.getString(index++));
        data.setDcGroup(rs.getString(index++));
        data.setDcParameter(rs.getString(index++));
        data.setTolerance(rs.getString(index++));
        data.setPoint(rs.getString(index++));
        data.setTooling1(rs.getString(index++));
        data.setTooling2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
