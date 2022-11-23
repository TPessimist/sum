package ame.psb.db.dao;

import ame.psb.db.InStockContainerHandover;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.InStockContainerHandoverLog;
import java.util.UUID;
import uia.utils.dao.DateUtils;

public class InStockContainerHandoverLogDao {

    private static final String SQL_INS = "INSERT INTO zr_in_stock_container_handover_log(id,container_id,container_name,action_name,request_content,response_content,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zr_in_stock_container_handover_log SET container_id=?,container_name=?,action_name=?,request_content=?,response_content=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

    private static final String SQL_SEL = "SELECT id,container_id,container_name,action_name,request_content,response_content,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_in_stock_container_handover_log ";
    
    private final Connection conn;

    public InStockContainerHandoverLogDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(InStockContainerHandoverLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getContainerId());
            ps.setString(3, data.getContainerName());
            ps.setString(4, data.getActionName());
            ps.setString(5, data.getRequestContent());
            ps.setString(6, data.getResponseContent());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }

    public int log(InStockContainerHandover data,String actionName, String field1, String request, String response) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, data.getContainerId());
            ps.setString(3, data.getContainerName());
            ps.setString(4, actionName);
            ps.setString(5, request);
            ps.setString(6, response);
            ps.setString(7, field1);
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }
    
    public int insert(List<InStockContainerHandoverLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(InStockContainerHandoverLog data : dataList) {
            ps.setString(1, data.getId());
            ps.setString(2, data.getContainerId());
            ps.setString(3, data.getContainerName());
            ps.setString(4, data.getActionName());
            ps.setString(5, data.getRequestContent());
            ps.setString(6, data.getResponseContent());
            ps.setString(7, data.getReversedField1());
            ps.setString(8, data.getReversedField2());
            ps.setString(9, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(InStockContainerHandoverLog data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getContainerId());
            ps.setString(2, data.getContainerName());
            ps.setString(3, data.getActionName());
            ps.setString(4, data.getRequestContent());
            ps.setString(5, data.getResponseContent());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
            ps.setString(10, data.getId());

            return ps.executeUpdate();
        }
    }    

    public int update(List<InStockContainerHandoverLog> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(InStockContainerHandoverLog data : dataList) {
            ps.setString(1, data.getContainerId());
            ps.setString(2, data.getContainerName());
            ps.setString(3, data.getActionName());
            ps.setString(4, data.getRequestContent());
            ps.setString(5, data.getResponseContent());
            ps.setString(6, data.getReversedField1());
            ps.setString(7, data.getReversedField2());
            ps.setString(8, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
            ps.setString(10, data.getId());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_in_stock_container_handover_log WHERE id=?")) {
            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }    

    public List<InStockContainerHandoverLog> selectAll() throws SQLException {
        ArrayList<InStockContainerHandoverLog> result = new ArrayList<InStockContainerHandoverLog>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public InStockContainerHandoverLog selectByPK(String id) throws SQLException {
        InStockContainerHandoverLog result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE id=?")) {
            ps.setString(1, id);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private InStockContainerHandoverLog convert(ResultSet rs) throws SQLException {
        InStockContainerHandoverLog data = new InStockContainerHandoverLog();
        
        int index = 1;
        data.setId(rs.getString(index++));
        data.setContainerId(rs.getString(index++));
        data.setContainerName(rs.getString(index++));
        data.setActionName(rs.getString(index++));
        data.setRequestContent(rs.getString(index++));
        data.setResponseContent(rs.getString(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
