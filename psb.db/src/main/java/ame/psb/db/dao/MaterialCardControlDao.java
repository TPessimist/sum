package ame.psb.db.dao;

import ame.psb.db.MaterialCardControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MaterialCardControlDao {

  private static final String SQL_INS = "INSERT INTO zr_material_card_control(id,resource_bo,item_bo,type,state,updated_user,updated_time,reverse_field1,reverse_field2) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_material_card_control SET resource_bo=?,item_bo=?,type=?,state=?,updated_user=?,updated_time=?,reverse_field1=?,reverse_field2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,item_bo,type,state,updated_user,updated_time,reverse_field1,reverse_field2 FROM zr_material_card_control ";

  private final Connection conn;

  public MaterialCardControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MaterialCardControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getType());
      ps.setString(5, data.getState());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getReverseField1());
      ps.setString(9, data.getReverseField2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MaterialCardControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MaterialCardControl data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getType());
        ps.setString(5, data.getState());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getReverseField1());
        ps.setString(9, data.getReverseField2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MaterialCardControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getItemBo());
      ps.setString(3, data.getType());
      ps.setString(4, data.getState());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getReverseField1());
      ps.setString(8, data.getReverseField2());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<MaterialCardControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MaterialCardControl data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getItemBo());
        ps.setString(3, data.getType());
        ps.setString(4, data.getState());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getReverseField1());
        ps.setString(8, data.getReverseField2());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_material_card_control WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<MaterialCardControl> selectAll() throws SQLException {
    ArrayList<MaterialCardControl> result = new ArrayList<MaterialCardControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MaterialCardControl> selectByResource(String resource, String state)
      throws SQLException {
    ArrayList<MaterialCardControl> result = new ArrayList<MaterialCardControl>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resource_bo=? and state=? ")) {
      ps.setString(1, resource);
      ps.setString(2, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public MaterialCardControl selectByPK(String id) throws SQLException {
    MaterialCardControl result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public MaterialCardControl selectByResourceAndItemBo(String resource, String itemBo, String state)
      throws SQLException {
    MaterialCardControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? and item_bo=? and state=? ")) {
      ps.setString(1, resource);
      ps.setString(2, itemBo);
      ps.setString(3, state);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MaterialCardControl convert(ResultSet rs) throws SQLException {
    MaterialCardControl data = new MaterialCardControl();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));

    return data;
  }
}
