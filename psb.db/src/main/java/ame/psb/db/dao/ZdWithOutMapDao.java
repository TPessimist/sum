package ame.psb.db.dao;

import ame.psb.db.ZdWithOutMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdWithOutMapDao {

  private static final String SQL_INS = "INSERT INTO zd_without_map(operation_bo,sfc_bo,updated_user,updated_time, customer_item_bo) VALUES (?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT operation_bo,sfc_bo,updated_user,updated_time,customer_item_bo FROM zd_without_map ";

  private final Connection conn;

  public ZdWithOutMapDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdWithOutMap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdWithOutMap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdWithOutMap data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCustomerItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String operationBo, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_without_map WHERE operation_bo=? AND sfc_bo = ?")) {
      ps.setString(1, operationBo);
      ps.setString(2, sfcBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByWafer(String operationBo, String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_without_map WHERE operation_bo=? AND customer_item_bo = ?")) {
      ps.setString(1, operationBo);
      ps.setString(2, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdWithOutMap> selectAll() throws SQLException {
    ArrayList<ZdWithOutMap> result = new ArrayList<ZdWithOutMap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ZdWithOutMap selectByPK(String operationBo, String sfcBo) throws SQLException {
    ZdWithOutMap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? AND sfc_bo=?")) {
      ps.setString(1, operationBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ZdWithOutMap selectByWafer(String operationBo, String customerItemBo) throws SQLException {
    ZdWithOutMap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo = ? AND customer_item_bo = ?")) {
      ps.setString(1, operationBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ZdWithOutMap convert(ResultSet rs) throws SQLException {
    ZdWithOutMap data = new ZdWithOutMap();

    int index = 1;
    data.setOperationBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setCustomerItemBo(rs.getString(index++));

    return data;
  }
}
