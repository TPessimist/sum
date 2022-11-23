package ame.psb.db.dao;

import ame.psb.db.MtBomOperationSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MtBomOperationSlotDao {

  private static final String SQL_INS = "INSERT INTO zd_mt_bom_operation_slot(bom_operation_bo,resource_bo,slot_name,state_name) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mt_bom_operation_slot SET resource_bo=?,slot_name=?,state_name=? WHERE bom_operation_bo=?";

  private static final String SQL_SEL = "SELECT bom_operation_bo,resource_bo,slot_name,state_name FROM zd_mt_bom_operation_slot ";

  private final Connection conn;

  public MtBomOperationSlotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MtBomOperationSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBomOperationBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getSlotName());
      ps.setString(4, data.getStateName());

      return ps.executeUpdate();
    }
  }

  public int update(MtBomOperationSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getSlotName());
      ps.setString(3, data.getStateName());
      ps.setString(4, data.getBomOperationBo());

      return ps.executeUpdate();
    }
  }

  public int delete(String bomOperationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_mt_bom_operation_slot WHERE bom_operation_bo=?")) {
      ps.setString(1, bomOperationBo);

      return ps.executeUpdate();
    }
  }

  public List<MtBomOperationSlot> selectAll() throws SQLException {
    ArrayList<MtBomOperationSlot> result = new ArrayList<MtBomOperationSlot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public MtBomOperationSlot selectByPK(String bomOperationBo) throws SQLException {
    MtBomOperationSlot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE bom_operation_bo=?")) {
      ps.setString(1, bomOperationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MtBomOperationSlot convert(ResultSet rs) throws SQLException {
    MtBomOperationSlot data = new MtBomOperationSlot();

    int index = 1;
    data.setBomOperationBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotName(rs.getString(index++));
    data.setStateName(rs.getString(index++));

    return data;
  }
}
