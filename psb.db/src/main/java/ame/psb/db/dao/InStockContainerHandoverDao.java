package ame.psb.db.dao;

import ame.psb.db.PkgInStockContainerSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.InStockContainerHandover;
import uia.utils.dao.DateUtils;

public class InStockContainerHandoverDao {

    private static final String SQL_INS = "INSERT INTO zr_in_stock_container_handover(container_id,container_name,state_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_in_stock_container_handover SET container_name=?,state_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE container_id=?";

    private static final String SQL_SEL = "SELECT container_id,container_name,state_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_in_stock_container_handover ";
    
    private final Connection conn;

    public InStockContainerHandoverDao(Connection conn) {
        this.conn = conn;
    }

    public int insertOrUpdate(InStockContainerHandover data) throws SQLException {
        InStockContainerHandover inStockContainerHandover = selectByPK(data.getContainerId());
        if (null != inStockContainerHandover) {
            return update(data);
        } else {
            return insert(data);
        }
    }
    
    public int insert(InStockContainerHandover data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getContainerId());
            ps.setString(2, data.getContainerName());
            ps.setString(3, data.getStateName());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<InStockContainerHandover> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(InStockContainerHandover data : dataList) {
            ps.setString(1, data.getContainerId());
            ps.setString(2, data.getContainerName());
            ps.setString(3, data.getStateName());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(InStockContainerHandover data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getContainerName());
            ps.setString(2, data.getStateName());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getContainerId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<InStockContainerHandover> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(InStockContainerHandover data : dataList) {
            ps.setString(1, data.getContainerName());
            ps.setString(2, data.getStateName());
            ps.setString(3, data.getReversedField1());
            ps.setString(4, data.getReversedField2());
            ps.setString(5, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
            ps.setString(7, data.getContainerId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String containerId) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_in_stock_container_handover WHERE container_id=?")) {
            ps.setString(1, containerId);

            return ps.executeUpdate();
        }
    }    

    public List<InStockContainerHandover> selectAll() throws SQLException {
        ArrayList<InStockContainerHandover> result = new ArrayList<InStockContainerHandover>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public InStockContainerHandover selectByPK(String containerId) throws SQLException {
        InStockContainerHandover result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE container_id=?")) {
            ps.setString(1, containerId);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private InStockContainerHandover convert(ResultSet rs) throws SQLException {
        InStockContainerHandover data = new InStockContainerHandover();
        
        int index = 1;
        data.setContainerId(rs.getString(index++));
        data.setContainerName(rs.getString(index++));
        data.setStateName(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
