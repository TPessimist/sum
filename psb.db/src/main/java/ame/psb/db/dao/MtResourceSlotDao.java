package ame.psb.db.dao;

import ame.psb.db.MtResourceSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MtResourceSlotDao {

  private static final String SQL_INS = "INSERT INTO zd_mt_resource_slot(id,resource_bo,slot_name,slot_type,state_name) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mt_resource_slot SET resource_bo=?,slot_name=?,slot_type=?,state_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,slot_name,slot_type,state_name FROM zd_mt_resource_slot ";

  private final Connection conn;

  public MtResourceSlotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtResourceSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getSlotType());
      ps.setString(5, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int update(MtResourceSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getSlotName());
      ps.setString(3, data.getSlotType());
      ps.setString(4, data.getStateName());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_mt_resource_slot WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<MtResourceSlot> selectAll() throws SQLException {
    ArrayList<MtResourceSlot> result = new ArrayList<MtResourceSlot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public MtResourceSlot selectByPK(String id) throws SQLException {
    MtResourceSlot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MtResourceSlot convert(ResultSet rs) throws SQLException {
    MtResourceSlot data = new MtResourceSlot();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setSlotType(rs.getString(index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
