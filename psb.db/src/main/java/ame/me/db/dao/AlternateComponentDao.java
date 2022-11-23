package ame.me.db.dao;

import ame.me.db.AlternateComponent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AlternateComponentDao {

  private static final String SQL_INS = "INSERT INTO alternate_component(handle,bom_component_bo,item_bo,substitute,required_substitute,valid_start,valid_end) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE alternate_component SET bom_component_bo=?,item_bo=?,substitute=?,required_substitute=?,valid_start=?,valid_end=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,bom_component_bo,item_bo,substitute,required_substitute,valid_start,valid_end FROM alternate_component ";

  private final Connection conn;

  public AlternateComponentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AlternateComponent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getBomComponentBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getSubstitute());
      ps.setString(5, data.getRequiredSubstitute());
      DateUtils.setDateTz(ps, 6, data.getValidStart());
      DateUtils.setDateTz(ps, 7, data.getValidEnd());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AlternateComponent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AlternateComponent data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getBomComponentBo());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getSubstitute());
        ps.setString(5, data.getRequiredSubstitute());
        DateUtils.setDateTz(ps, 6, data.getValidStart());
        DateUtils.setDateTz(ps, 7, data.getValidEnd());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AlternateComponent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBomComponentBo());
      ps.setString(2, data.getItemBo());
      ps.setString(3, data.getSubstitute());
      ps.setString(4, data.getRequiredSubstitute());
      DateUtils.setDateTz(ps, 5, data.getValidStart());
      DateUtils.setDateTz(ps, 6, data.getValidEnd());
      ps.setString(7, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<AlternateComponent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AlternateComponent data : dataList) {
        ps.setString(1, data.getBomComponentBo());
        ps.setString(2, data.getItemBo());
        ps.setString(3, data.getSubstitute());
        ps.setString(4, data.getRequiredSubstitute());
        DateUtils.setDateTz(ps, 5, data.getValidStart());
        DateUtils.setDateTz(ps, 6, data.getValidEnd());
        ps.setString(7, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM alternate_component WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<AlternateComponent> selectAll() throws SQLException {
    ArrayList<AlternateComponent> result = new ArrayList<AlternateComponent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<AlternateComponent> selectByBomComponentBo(String bomComponentBo)
      throws SQLException {
    ArrayList<AlternateComponent> result = new ArrayList<AlternateComponent>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where bom_component_bo=? ")) {

      ps.setString(1, bomComponentBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public AlternateComponent selectByPK(String handle) throws SQLException {
    AlternateComponent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private AlternateComponent convert(ResultSet rs) throws SQLException {
    AlternateComponent data = new AlternateComponent();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setBomComponentBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setSubstitute(rs.getString(index++));
    data.setRequiredSubstitute(rs.getString(index++));
    data.setValidStart(DateUtils.getDateTz(rs, index++));
    data.setValidEnd(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
