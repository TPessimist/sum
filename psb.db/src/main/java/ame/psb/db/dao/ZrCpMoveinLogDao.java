package ame.psb.db.dao;

import ame.psb.db.ZrCpMoveinLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZrCpMoveinLogDao {

  private static final String SQL_INS = "INSERT INTO zr_cp_movein_log(wafer_bo,customer_lot,group_id,update_user,update_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_cp_movein_log SET customer_lot=?,group_id=?,update_user=?,update_time=? WHERE wafer_bo=?";

  private static final String SQL_SEL = "SELECT wafer_bo,customer_lot,group_id,update_user,update_time FROM zr_cp_movein_log ";

  private final Connection conn;

  public ZrCpMoveinLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrCpMoveinLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getWaferBo());
      ps.setString(2, data.getCustomerLot());
      ps.setString(3, data.getGroupId());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrCpMoveinLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrCpMoveinLog data : dataList) {
        ps.setString(1, data.getWaferBo());
        ps.setString(2, data.getCustomerLot());
        ps.setString(3, data.getGroupId());
        ps.setString(4, data.getUpdateUser());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrCpMoveinLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerLot());
      ps.setString(2, data.getGroupId());
      ps.setString(3, data.getUpdateUser());
      DateUtils.setDateTz(ps, 4, data.getUpdateTime());
      ps.setString(5, data.getWaferBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrCpMoveinLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrCpMoveinLog data : dataList) {
        ps.setString(1, data.getCustomerLot());
        ps.setString(2, data.getGroupId());
        ps.setString(3, data.getUpdateUser());
        DateUtils.setDateTz(ps, 4, data.getUpdateTime());
        ps.setString(5, data.getWaferBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_cp_movein_log WHERE wafer_bo=?")) {
      ps.setString(1, waferBo);

      return ps.executeUpdate();
    }
  }

  public List<ZrCpMoveinLog> selectAll() throws SQLException {
    ArrayList<ZrCpMoveinLog> result = new ArrayList<ZrCpMoveinLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZrCpMoveinLog> selectBylot(String customerLot) throws SQLException {
    ArrayList<ZrCpMoveinLog> result = new ArrayList<ZrCpMoveinLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer_lot=?")) {
      ps.setString(1, customerLot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZrCpMoveinLog> selectBygroup(String group) throws SQLException {
    ArrayList<ZrCpMoveinLog> result = new ArrayList<ZrCpMoveinLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE group_id=?")) {
      ps.setString(1, group);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ZrCpMoveinLog> selectBygroupAndCustomerLot(String group, String custlot)
      throws SQLException {
    ArrayList<ZrCpMoveinLog> result = new ArrayList<ZrCpMoveinLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE group_id=? AND customer_lot=?")) {
      ps.setString(1, group);
      ps.setString(2, custlot);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrCpMoveinLog selectByPK(String waferBo) throws SQLException {
    ZrCpMoveinLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE wafer_bo=?")) {
      ps.setString(1, waferBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZrCpMoveinLog convert(ResultSet rs) throws SQLException {
    ZrCpMoveinLog data = new ZrCpMoveinLog();

    int index = 1;
    data.setWaferBo(rs.getString(index++));
    data.setCustomerLot(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
