package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ResourceMaterialLife;
import uia.utils.dao.DateUtils;

public class ResourceMaterialLifeDao {

    private static final String SQL_INS = "INSERT INTO zd_resource_material_life(resource_bo,item_bo,life_time,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zd_resource_material_life SET life_time=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE resource_bo=? AND item_bo=?";

    private static final String SQL_SEL = "SELECT resource_bo,item_bo,life_time,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_resource_material_life ";
    
    private final Connection conn;

    public ResourceMaterialLifeDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(ResourceMaterialLife data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getItemBo());
            ps.setBigDecimal(3, data.getLifeTime());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<ResourceMaterialLife> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(ResourceMaterialLife data : dataList) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getItemBo());
            ps.setBigDecimal(3, data.getLifeTime());
            ps.setString(4, data.getReversedField1());
            ps.setString(5, data.getReversedField2());
            ps.setString(6, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }
    public int update(ResourceMaterialLife data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getLifeTime());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getResourceBo());
            ps.setString(7, data.getItemBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<ResourceMaterialLife> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(ResourceMaterialLife data : dataList) {
            ps.setBigDecimal(1, data.getLifeTime());
            ps.setString(2, data.getReversedField1());
            ps.setString(3, data.getReversedField2());
            ps.setString(4, data.getUpdatedUser());
            DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
            ps.setString(6, data.getResourceBo());
            ps.setString(7, data.getItemBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String resourceBo, String itemBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_resource_material_life WHERE resource_bo=? AND item_bo=?")) {
            ps.setString(1, resourceBo);
            ps.setString(2, itemBo);

            return ps.executeUpdate();
        }
    }    

    public List<ResourceMaterialLife> selectAll() throws SQLException {
        ArrayList<ResourceMaterialLife> result = new ArrayList<ResourceMaterialLife>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public List<ResourceMaterialLife> selectByResource(String resourceBo) throws SQLException {
        ArrayList<ResourceMaterialLife> result = new ArrayList<ResourceMaterialLife>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=? ")) {
            ps.setString(1, resourceBo);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }

    public ResourceMaterialLife selectByPK(String resourceBo, String itemBo) throws SQLException {
        ResourceMaterialLife result = null;
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL  + "WHERE resource_bo=? AND item_bo=?")) {
            ps.setString(1, resourceBo);
            ps.setString(2, itemBo);

            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                result = convert(rs);
            }
            return result;
        }
    }    
    
    private ResourceMaterialLife convert(ResultSet rs) throws SQLException {
        ResourceMaterialLife data = new ResourceMaterialLife();
        
        int index = 1;
        data.setResourceBo(rs.getString(index++));
        data.setItemBo(rs.getString(index++));
        data.setLifeTime(rs.getBigDecimal(index++));
        data.setReversedField1(rs.getString(index++));
        data.setReversedField2(rs.getString(index++));
        data.setUpdatedUser(rs.getString(index++));
        data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

        return data;
    }
}
