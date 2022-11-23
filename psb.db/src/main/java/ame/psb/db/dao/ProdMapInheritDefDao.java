package ame.psb.db.dao;

import ame.psb.db.ProdMapInheritDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdMapInheritDefDao {

  private static final String SQL_INS = "INSERT INTO zd_prod_map_inherit_def(id,device_name,operation,inherit_operation,inherit_device) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_prod_map_inherit_def SET device_name=?,operation=?,inherit_operation=?,inherit_device=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device_name,operation,inherit_operation,inherit_device FROM zd_prod_map_inherit_def ";

  private final Connection conn;

  public ProdMapInheritDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ProdMapInheritDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getInheritOperation());
      ps.setString(5, data.getInheritDevice());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ProdMapInheritDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ProdMapInheritDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getInheritOperation());
        ps.setString(5, data.getInheritDevice());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ProdMapInheritDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getInheritOperation());
      ps.setString(4, data.getInheritDevice());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ProdMapInheritDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ProdMapInheritDef data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getInheritOperation());
        ps.setString(4, data.getInheritDevice());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_prod_map_inherit_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDevice(String device) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_prod_map_inherit_def WHERE device_name=? ")) {
      ps.setString(1, device);

      return ps.executeUpdate();
    }
  }

  public List<ProdMapInheritDef> selectAll() throws SQLException {
    ArrayList<ProdMapInheritDef> result = new ArrayList<ProdMapInheritDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ProdMapInheritDef> selectByDevice(String device) throws SQLException {
    ArrayList<ProdMapInheritDef> result = new ArrayList<ProdMapInheritDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where device_name=? ")) {
      ps.setString(1, device);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ProdMapInheritDef> selectByInherDevice(String inheritDevice) throws SQLException {
    ArrayList<ProdMapInheritDef> result = new ArrayList<ProdMapInheritDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where INHERIT_DEVICE=? ")) {
      ps.setString(1, inheritDevice);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ProdMapInheritDef> selectByDeAndOp(String deviceName, String operation)
      throws SQLException {
    ArrayList<ProdMapInheritDef> result = new ArrayList<ProdMapInheritDef>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where device_name=? AND operation = ? ")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ProdMapInheritDef selectByPK(String id) throws SQLException {
    ProdMapInheritDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ProdMapInheritDef selectByPK(String deviceName, String operation,
      String inheritDevice, String inheritOperation) throws SQLException {
    ProdMapInheritDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE DEVICE_NAME = ? AND OPERATION = ? AND INHERIT_DEVICE = ? AND INHERIT_OPERATION = ? ")) {
      ps.setString(1, deviceName);
      ps.setString(2, operation);
      ps.setString(3, inheritDevice);
      ps.setString(4, inheritOperation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ProdMapInheritDef> selectByInherit(String inheritDevice, String inheritOperation)
      throws SQLException {
    ArrayList<ProdMapInheritDef> result = new ArrayList<ProdMapInheritDef>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where INHERIT_DEVICE=? AND INHERIT_OPERATION = ? ")) {
      ps.setString(1, inheritDevice);
      ps.setString(2, inheritOperation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ProdMapInheritDef convert(ResultSet rs) throws SQLException {
    ProdMapInheritDef data = new ProdMapInheritDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setInheritOperation(rs.getString(index++));
    data.setInheritDevice(rs.getString(index++));

    return data;
  }
}
