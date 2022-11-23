package ame.psb.db.dao;

import ame.psb.db.WaferDeductionSingle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaferDeductionSingleDao {

  private static final String SQL_INS = "INSERT INTO zr_wafer_deduction_single(uuid,sfc,wafer,devicename,lot,operation,waferid,qty,comment,description,value) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_wafer_deduction_single SET sfc=?,wafer=?,devicename=?,lot=?,operation=?,waferid=?,qty=?,comment=?,description=?,value=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,sfc,wafer,devicename,lot,operation,waferid,qty,comment,description,value FROM zr_wafer_deduction_single ";

  private final Connection conn;

  public WaferDeductionSingleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(WaferDeductionSingle data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getWafer());
      ps.setString(4, data.getDevicename());
      ps.setString(5, data.getLot());
      ps.setString(6, data.getOperation());
      ps.setString(7, data.getWaferid());
      ps.setString(8, data.getQty());
      ps.setString(9, data.getComment());
      ps.setString(10, data.getDescription());
      ps.setString(11, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<WaferDeductionSingle> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (WaferDeductionSingle data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getWafer());
        ps.setString(4, data.getDevicename());
        ps.setString(5, data.getLot());
        ps.setString(6, data.getOperation());
        ps.setString(7, data.getWaferid());
        ps.setString(8, data.getQty());
        ps.setString(9, data.getComment());
        ps.setString(10, data.getDescription());
        ps.setString(11, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(WaferDeductionSingle data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getWafer());
      ps.setString(3, data.getDevicename());
      ps.setString(4, data.getLot());
      ps.setString(5, data.getOperation());
      ps.setString(6, data.getWaferid());
      ps.setString(7, data.getQty());
      ps.setString(8, data.getComment());
      ps.setString(9, data.getDescription());
      ps.setString(10, data.getValue());
      ps.setString(11, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<WaferDeductionSingle> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (WaferDeductionSingle data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getWafer());
        ps.setString(3, data.getDevicename());
        ps.setString(4, data.getLot());
        ps.setString(5, data.getOperation());
        ps.setString(6, data.getWaferid());
        ps.setString(7, data.getQty());
        ps.setString(8, data.getComment());
        ps.setString(9, data.getDescription());
        ps.setString(10, data.getValue());
        ps.setString(11, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wafer_deduction_single WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public int deleteBySfcAndWafer(String sfc, String wafer) throws SQLException { //根据批号和wafer删记录
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_wafer_deduction_single WHERE sfc=? AND wafer=?")) {
      ps.setString(1, sfc);
      ps.setString(2, wafer);

      return ps.executeUpdate();
    }
  }

  public List<WaferDeductionSingle> selectAll() throws SQLException {
    ArrayList<WaferDeductionSingle> result = new ArrayList<WaferDeductionSingle>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public WaferDeductionSingle selectByPK(String uuid) throws SQLException {
    WaferDeductionSingle result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<WaferDeductionSingle> selectBySfcAndWafer(String sfc, String wafer)
      throws SQLException { //根据批次号和wafer查记录
    ArrayList<WaferDeductionSingle> result = new ArrayList<WaferDeductionSingle>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc=? AND wafer=?")) {
      ps.setString(1, sfc);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<WaferDeductionSingle> selectBySfc(String sfc)
      throws SQLException {
    ArrayList<WaferDeductionSingle> result = new ArrayList<WaferDeductionSingle>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc=? ")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private WaferDeductionSingle convert(ResultSet rs) throws SQLException {
    WaferDeductionSingle data = new WaferDeductionSingle();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setWafer(rs.getString(index++));
    data.setDevicename(rs.getString(index++));
    data.setLot(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setWaferid(rs.getString(index++));
    data.setQty(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValue(rs.getString(index++));

    return data;
  }
}
