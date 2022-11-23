package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PkgPackingNewPlan;
import uia.utils.dao.DateUtils;

public class PkgPackingNewPlanDao {

    private static final String SQL_INS = "INSERT INTO zd_pkg_packing_new_plan(new_plan,main_plan,qty,unit,value,content,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_pkg_packing_new_plan SET main_plan=?,qty=?,unit=?,value=?,content=?,updated_user=?,updated_time=? WHERE new_plan=?";

    private static final String SQL_SEL = "SELECT new_plan,main_plan,qty,unit,value,content,updated_user,updated_time FROM zd_pkg_packing_new_plan ";
    
    private final Connection conn;

    public PkgPackingNewPlanDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PkgPackingNewPlan data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getNewPlan());
            ps.setString(2, data.getMainPlan());
            ps.setBigDecimal(3, data.getQty());
            ps.setString(4, data.getUnit());
            ps.setString(5, data.getValue());
            ps.setString(6, data.getContent());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PkgPackingNewPlan> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PkgPackingNewPlan data : dataList) {
            ps.setString(1, data.getNewPlan());
            ps.setString(2, data.getMainPlan());
            ps.setBigDecimal(3, data.getQty());
            ps.setString(4, data.getUnit());
            ps.setString(5, data.getValue());
            ps.setString(6, data.getContent());
            ps.setString(7, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PkgPackingNewPlan data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getMainPlan());
            ps.setBigDecimal(2, data.getQty());
            ps.setString(3, data.getUnit());
            ps.setString(4, data.getValue());
            ps.setString(5, data.getContent());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getNewPlan());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PkgPackingNewPlan> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PkgPackingNewPlan data : dataList) {
            ps.setString(1, data.getMainPlan());
            ps.setBigDecimal(2, data.getQty());
            ps.setString(3, data.getUnit());
            ps.setString(4, data.getValue());
            ps.setString(5, data.getContent());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
            ps.setString(8, data.getNewPlan());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String newPlan) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pkg_packing_new_plan WHERE new_plan=?")) {
            ps.setString(1, newPlan);

            return ps.executeUpdate();
        }
    }
    public int deleteMain(String mainPlan) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_pkg_packing_new_plan WHERE main_plan=?")) {
            ps.setString(1, mainPlan);

            return ps.executeUpdate();
        }
    }

    public List<PkgPackingNewPlan> selectAll() throws SQLException {
        ArrayList<PkgPackingNewPlan> result = new ArrayList<PkgPackingNewPlan>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<PkgPackingNewPlan> selectByMainPlan(String mainPlan) throws SQLException {
        ArrayList<PkgPackingNewPlan> result = new ArrayList<PkgPackingNewPlan>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL+ "WHERE main_plan=? order by NEW_PLAN")) {
            ps.setString(1, mainPlan);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


    public PkgPackingNewPlan selectByPK(String newPlan) throws SQLException {
        PkgPackingNewPlan result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE new_plan=?")) {
            ps.setString(1, newPlan);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private PkgPackingNewPlan convert(ResultSet rs) throws SQLException {
        PkgPackingNewPlan data = new PkgPackingNewPlan();
        
        int index = 1;
        data.setNewPlan(rs.getString(index++));
        data.setMainPlan(rs.getString(index++));
        data.setQty(rs.getBigDecimal(index++));
        data.setUnit(rs.getString(index++));
        data.setValue(rs.getString(index++));
        data.setContent(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
