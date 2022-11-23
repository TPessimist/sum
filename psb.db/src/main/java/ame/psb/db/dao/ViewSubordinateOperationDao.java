package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewSubordinateOperation;

/**
 * 从属站点视图
 */
public class ViewSubordinateOperationDao {

    private static final String SQL_SEL = "SELECT master_device_bo,assistant_device_bo,subordinate_type,operation_bo,difference_bo,describe FROM view_subordinate_operation ";
    
    private final Connection conn;

    public ViewSubordinateOperationDao(Connection conn) {
        this.conn = conn;
    }

    public List<ViewSubordinateOperation> selectAll() throws SQLException {
        ArrayList<ViewSubordinateOperation> result = new ArrayList<ViewSubordinateOperation>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<ViewSubordinateOperation> selectByAssistantItemGroupBoAndOperation(String itemGroupBo, String operationBo) throws SQLException {
        ArrayList<ViewSubordinateOperation> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where ASSISTANT_DEVICE_BO = ? and OPERATION_BO = ? ")) {

            ps.setString(1, itemGroupBo);
            ps.setString(2, operationBo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    private ViewSubordinateOperation convert(ResultSet rs) throws SQLException {
        ViewSubordinateOperation data = new ViewSubordinateOperation();
        
        int index = 1;
        data.setMasterDeviceBo(rs.getString(index++));
        data.setAssistantDeviceBo(rs.getString(index++));
        data.setSubordinateType(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setDifferenceBo(rs.getString(index++));
        data.setDescribe(rs.getString(index++));

        return data;
    }
}
