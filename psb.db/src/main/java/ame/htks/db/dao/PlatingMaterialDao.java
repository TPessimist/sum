package ame.htks.db.dao;

import ame.htks.db.PlatingMaterial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PlatingMaterialDao {

  private static final String SQL_INS = "INSERT INTO zh_plating_material_define(resource_bo,item_bo,desc,qty,seq,demo,update_time,update_user) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_plating_material_define SET desc=?,qty=?,seq=?,demo=?,update_time=?,update_user=? WHERE resource_bo=? AND item_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,item_bo,desc,qty,seq,demo,update_time,update_user FROM zh_plating_material_define ";

  private final Connection conn;

  public PlatingMaterialDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlatingMaterial data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getItemBo());
      ps.setString(3, data.getDesc());
      ps.setBigDecimal(4, data.getQty());
      ps.setString(5, data.getSeq());
      ps.setString(6, data.getDemo());
      ps.setTimestamp(7, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(8, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlatingMaterial> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlatingMaterial data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getItemBo());
        ps.setString(3, data.getDesc());
        ps.setBigDecimal(4, data.getQty());
        ps.setString(5, data.getSeq());
        ps.setString(6, data.getDemo());
        ps.setTimestamp(7, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(8, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlatingMaterial data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDesc());
      ps.setBigDecimal(2, data.getQty());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getDemo());
      ps.setTimestamp(5, new Timestamp(data.getUpdateTime().getTime()));
      ps.setString(6, data.getUpdateUser());
      ps.setString(7, data.getResourceBo());
      ps.setString(8, data.getItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlatingMaterial> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlatingMaterial data : dataList) {
        ps.setString(1, data.getDesc());
        ps.setBigDecimal(2, data.getQty());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getDemo());
        ps.setTimestamp(5, new Timestamp(data.getUpdateTime().getTime()));
        ps.setString(6, data.getUpdateUser());
        ps.setString(7, data.getResourceBo());
        ps.setString(8, data.getItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo, String itemBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zh_plating_material_define WHERE resource_bo=? AND item_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemBo);

      return ps.executeUpdate();
    }
  }


  public List<PlatingMaterial> selectByResource(String resourceBo) throws SQLException {
    ArrayList<PlatingMaterial> result = new ArrayList<PlatingMaterial>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where resource_bo=? order by cast(seq as int)")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;

    }

  }

  public List<PlatingMaterial> selectAll() throws SQLException {
    ArrayList<PlatingMaterial> result = new ArrayList<PlatingMaterial>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PlatingMaterial selectByPK(String resourceBo, String itemBo) throws SQLException {
    PlatingMaterial result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND item_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PlatingMaterial convert(ResultSet rs) throws SQLException {
    PlatingMaterial data = new PlatingMaterial();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setDesc(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setSeq(rs.getString(index++));
    data.setDemo(rs.getString(index++));
    data.setUpdateTime(rs.getTimestamp(index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }
}

/*package ame.htks.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.htks.db.PlatingMaterial;

public class PlatingMaterialDao {

    private static final String SQL_INS = "INSERT INTO zh_plating_material_define(resource_bo,item_bo,qty,seq,demo,update_time,update_user) VALUES (?,?,?,?,?,?,?)";

    private static final String SQL_UPD = "UPDATE zh_plating_material_define SET qty=?,seq=?,demo=?,update_time=?,update_user=? WHERE resource_bo=? AND item_bo=?";

    private static final String SQL_SEL = "SELECT resource_bo,item_bo,qty,seq,demo,update_time,update_user FROM zh_plating_material_define ";
    
    private final Connection conn;

    public PlatingMaterialDao(Connection conn) {
        this.conn = conn;
    }
    
    public int insert(PlatingMaterial data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getItemBo());
            ps.setBigDecimal(3, data.getQty());
            ps.setString(4, data.getSeq());
            ps.setString(5, data.getDemo());
            ps.setTimestamp(6, new Timestamp(data.getUpdateTime().getTime()));
            ps.setString(7, data.getUpdateUser());

            return ps.executeUpdate();
        }
    }    
    
    public int insert(List<PlatingMaterial> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
            for(PlatingMaterial data : dataList) {
            ps.setString(1, data.getResourceBo());
            ps.setString(2, data.getItemBo());
            ps.setBigDecimal(3, data.getQty());
            ps.setString(4, data.getSeq());
            ps.setString(5, data.getDemo());
            ps.setTimestamp(6, new Timestamp(data.getUpdateTime().getTime()));
            ps.setString(7, data.getUpdateUser());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int update(PlatingMaterial data) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            ps.setBigDecimal(1, data.getQty());
            ps.setString(2, data.getSeq());
            ps.setString(3, data.getDemo());
            ps.setTimestamp(4, new Timestamp(data.getUpdateTime().getTime()));
            ps.setString(5, data.getUpdateUser());
            ps.setString(6, data.getResourceBo());
            ps.setString(7, data.getItemBo());

            return ps.executeUpdate();
        }
    }    

    public int update(List<PlatingMaterial> dataList) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for(PlatingMaterial data : dataList) {
            ps.setBigDecimal(1, data.getQty());
            ps.setString(2, data.getSeq());
            ps.setString(3, data.getDemo());
            ps.setTimestamp(4, new Timestamp(data.getUpdateTime().getTime()));
            ps.setString(5, data.getUpdateUser());
            ps.setString(6, data.getResourceBo());
            ps.setString(7, data.getItemBo());

                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }    

    public int delete(String resourceBo, String itemBo) throws SQLException {
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zh_plating_material_define WHERE resource_bo=? AND item_bo=?")) {
            ps.setString(1, resourceBo);
            ps.setString(2, itemBo);

            return ps.executeUpdate();
        }
    }    

    public List<PlatingMaterial> selectAll() throws SQLException {
        ArrayList<PlatingMaterial> result = new ArrayList<PlatingMaterial>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }    
    
    public List<PlatingMaterial> selectByResource(String resourceBo) throws SQLException{
    	ArrayList<PlatingMaterial> result = new ArrayList<PlatingMaterial>();
    	try(PreparedStatement ps = this.conn.prepareStatement(SQL_SEL+" where resource_bo=? order by cast(seq as int)")){
    		ps.setString(1, resourceBo);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
    		
    	}
    	
    }

    public PlatingMaterial selectByPK(String resourceBo, String itemBo) throws SQLException {
        PlatingMaterial result = null;
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
    
    private PlatingMaterial convert(ResultSet rs) throws SQLException {
        PlatingMaterial data = new PlatingMaterial();
        
        int index = 1;
        data.setResourceBo(rs.getString(index++));
        data.setItemBo(rs.getString(index++));
        data.setQty(rs.getBigDecimal(index++));
        data.setSeq(rs.getString(index++));
        data.setDemo(rs.getString(index++));
        data.setUpdateTime(rs.getTimestamp(index++));
        data.setUpdateUser(rs.getString(index++));

        return data;
    }
}

*/