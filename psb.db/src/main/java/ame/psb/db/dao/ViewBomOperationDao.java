package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewBomOperation;

public class ViewBomOperationDao {

    private static final String SQL_INS = "INSERT INTO view_bom_operation(item_bo,operation_bo,bom_bo,bom_component_bo,bom_component_item_bo,site,item_description,bom_description,item,item_type,item_status_bo,component_group_bo,qty) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE view_bom_operation SET operation_bo=?,bom_bo=?,bom_component_bo=?,bom_component_item_bo=?,site=?,item_description=?,bom_description=?,item=?,item_type=?,item_status_bo=?,component_group_bo=?,qty=? WHERE item_bo=?";

    private static final String SQL_SEL = "SELECT item_bo,operation_bo,bom_bo,bom_component_bo,bom_component_item_bo,site,item_description,bom_description,item,item_type,item_status_bo,component_group_bo,qty FROM view_bom_operation ";
    
    private final Connection conn;

    public ViewBomOperationDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ViewBomOperation data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getItemBo());
            ps.setString(2, data.getOperationBo());
            ps.setString(3, data.getBomBo());
            ps.setString(4, data.getBomComponentBo());
            ps.setString(5, data.getBomComponentItemBo());
            ps.setString(6, data.getSite());
            ps.setString(7, data.getItemDescription());
            ps.setString(8, data.getBomDescription());
            ps.setString(9, data.getItem());
            ps.setString(10, data.getItemType());
            ps.setString(11, data.getItemStatusBo());
            ps.setString(12, data.getComponentGroupBo());
            ps.setBigDecimal(13, data.getQty());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ViewBomOperation> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ViewBomOperation data : dataList) {
            ps.setString(1, data.getItemBo());
            ps.setString(2, data.getOperationBo());
            ps.setString(3, data.getBomBo());
            ps.setString(4, data.getBomComponentBo());
            ps.setString(5, data.getBomComponentItemBo());
            ps.setString(6, data.getSite());
            ps.setString(7, data.getItemDescription());
            ps.setString(8, data.getBomDescription());
            ps.setString(9, data.getItem());
            ps.setString(10, data.getItemType());
            ps.setString(11, data.getItemStatusBo());
            ps.setString(12, data.getComponentGroupBo());
            ps.setBigDecimal(13, data.getQty());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(ViewBomOperation data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setString(1, data.getOperationBo());
            ps.setString(2, data.getBomBo());
            ps.setString(3, data.getBomComponentBo());
            ps.setString(4, data.getBomComponentItemBo());
            ps.setString(5, data.getSite());
            ps.setString(6, data.getItemDescription());
            ps.setString(7, data.getBomDescription());
            ps.setString(8, data.getItem());
            ps.setString(9, data.getItemType());
            ps.setString(10, data.getItemStatusBo());
            ps.setString(11, data.getComponentGroupBo());
            ps.setBigDecimal(12, data.getQty());
            ps.setString(13, data.getItemBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ViewBomOperation> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ViewBomOperation data : dataList) {
            ps.setString(1, data.getOperationBo());
            ps.setString(2, data.getBomBo());
            ps.setString(3, data.getBomComponentBo());
            ps.setString(4, data.getBomComponentItemBo());
            ps.setString(5, data.getSite());
            ps.setString(6, data.getItemDescription());
            ps.setString(7, data.getBomDescription());
            ps.setString(8, data.getItem());
            ps.setString(9, data.getItemType());
            ps.setString(10, data.getItemStatusBo());
            ps.setString(11, data.getComponentGroupBo());
            ps.setBigDecimal(12, data.getQty());
            ps.setString(13, data.getItemBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String itemBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM view_bom_operation WHERE item_bo=?")) {
            ps.setString(1, itemBo);

            return ps.executeUpdate();
        }
    }    

    public List<ViewBomOperation> selectAll() throws SQLException {
        ArrayList<ViewBomOperation> result = new ArrayList<ViewBomOperation>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    

    public ViewBomOperation selectByPK(String itemBo) throws SQLException {
        ViewBomOperation result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_bo=?")) {
            ps.setString(1, itemBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }
    public List<ViewBomOperation> selectByPK(String itemBo,String operationBo) throws SQLException {
        List<ViewBomOperation> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE item_bo=? and operation_bo = ? ")) {
            ps.setString(1, itemBo);
            ps.setString(2, operationBo);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }
    private ViewBomOperation convert(ResultSet rs) throws SQLException {
        ViewBomOperation data = new ViewBomOperation();
        
        int index = 1;
        data.setItemBo(rs.getString(index++));
        data.setOperationBo(rs.getString(index++));
        data.setBomBo(rs.getString(index++));
        data.setBomComponentBo(rs.getString(index++));
        data.setBomComponentItemBo(rs.getString(index++));
        data.setSite(rs.getString(index++));
        data.setItemDescription(rs.getString(index++));
        data.setBomDescription(rs.getString(index++));
        data.setItem(rs.getString(index++));
        data.setItemType(rs.getString(index++));
        data.setItemStatusBo(rs.getString(index++));
        data.setComponentGroupBo(rs.getString(index++));
        data.setQty(rs.getBigDecimal(index++));

        return data;
    }
}
