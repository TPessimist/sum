package ame.psb.db.dao;

import ame.psb.db.WaferHandOver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaferDeliverDao {

  private static final String SQL_INS = "INSERT INTO zr_wafer_deliver(wafer_bo,handover_log) VALUES (?,?)";

  private static final String SQL_UPD = "UPDATE zr_wafer_deliver SET handover_log=? WHERE wafer_bo=?";

  private static final String SQL_SEL = "SELECT wafer_bo,handover_log FROM zr_wafer_deliver ";

  private final Connection conn;

  public WaferDeliverDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(WaferHandOver data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getWaferBo());
      ps.setString(2, data.getHandoverLog());

      return ps.executeUpdate();
    }
  }

  public int insert(List<WaferHandOver> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (WaferHandOver data : dataList) {
        ps.setString(1, data.getWaferBo());
        ps.setString(2, data.getHandoverLog());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(WaferHandOver data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getHandoverLog());
      ps.setString(2, data.getWaferBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<WaferHandOver> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (WaferHandOver data : dataList) {
        ps.setString(1, data.getHandoverLog());
        ps.setString(2, data.getWaferBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wafer_deliver WHERE wafer_bo=?")) {
      ps.setString(1, waferBo);

      return ps.executeUpdate();
    }
  }

  public List<WaferHandOver> selectAll() throws SQLException {
    ArrayList<WaferHandOver> result = new ArrayList<WaferHandOver>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public WaferHandOver selectByPK(String waferBo) throws SQLException {
    WaferHandOver result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE wafer_bo=?")) {
      ps.setString(1, waferBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private WaferHandOver convert(ResultSet rs) throws SQLException {
    WaferHandOver data = new WaferHandOver();

    int index = 1;
    data.setWaferBo(rs.getString(index++));
    data.setHandoverLog(rs.getString(index++));

    return data;
  }
}
