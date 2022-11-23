package ame.me.db.dao;

import ame.me.db.ZdWtrQcGate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdWtrQcGateDao {

  private static final String SQL_INS = "INSERT INTO zd_wtr_qc_gate(id,sfc_bo,sfc,comparison_results,remarks1,remarks2,remarks3,remarks4,remarks5,remarks6,remarks7,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_wtr_qc_gate SET sfc=?,comparison_results=?,remarks1=?,remarks2=?,remarks3=?,remarks4=?,remarks5=?,remarks6=?,remarks7=?,updated_user=?,updated_time=? WHERE id=? AND sfc_bo=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,sfc,comparison_results,remarks1,remarks2,remarks3,remarks4,remarks5,remarks6,remarks7,updated_user,updated_time FROM zd_wtr_qc_gate ";

  private final Connection conn;

  public ZdWtrQcGateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdWtrQcGate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getSfc());
      ps.setString(4, data.getComparisonResults());
      ps.setString(5, data.getRemarks1());
      ps.setString(6, data.getRemarks2());
      ps.setString(7, data.getRemarks3());
      ps.setString(8, data.getRemarks4());
      ps.setString(9, data.getRemarks5());
      ps.setString(10, data.getRemarks6());
      ps.setString(11, data.getRemarks7());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdWtrQcGate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdWtrQcGate data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getSfc());
        ps.setString(4, data.getComparisonResults());
        ps.setString(5, data.getRemarks1());
        ps.setString(6, data.getRemarks2());
        ps.setString(7, data.getRemarks3());
        ps.setString(8, data.getRemarks4());
        ps.setString(9, data.getRemarks5());
        ps.setString(10, data.getRemarks6());
        ps.setString(11, data.getRemarks7());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdWtrQcGate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getComparisonResults());
      ps.setString(3, data.getRemarks1());
      ps.setString(4, data.getRemarks2());
      ps.setString(5, data.getRemarks3());
      ps.setString(6, data.getRemarks4());
      ps.setString(7, data.getRemarks5());
      ps.setString(8, data.getRemarks6());
      ps.setString(9, data.getRemarks7());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getId());
      ps.setString(13, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdWtrQcGate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdWtrQcGate data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getComparisonResults());
        ps.setString(3, data.getRemarks1());
        ps.setString(4, data.getRemarks2());
        ps.setString(5, data.getRemarks3());
        ps.setString(6, data.getRemarks4());
        ps.setString(7, data.getRemarks5());
        ps.setString(8, data.getRemarks6());
        ps.setString(9, data.getRemarks7());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getId());
        ps.setString(13, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_wtr_qc_gate WHERE id=? AND sfc_bo=?")) {
      ps.setString(1, id);
      ps.setString(2, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<ZdWtrQcGate> selectAll() throws SQLException {
    ArrayList<ZdWtrQcGate> result = new ArrayList<ZdWtrQcGate>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdWtrQcGate selectByPK(String id, String sfcBo) throws SQLException {
    ZdWtrQcGate result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=? AND sfc_bo=?")) {
      ps.setString(1, id);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZdWtrQcGate> selectByPKSfc(String sfcBo) throws SQLException {
    List<ZdWtrQcGate> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZdWtrQcGate convert(ResultSet rs) throws SQLException {
    ZdWtrQcGate data = new ZdWtrQcGate();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setComparisonResults(rs.getString(index++));
    data.setRemarks1(rs.getString(index++));
    data.setRemarks2(rs.getString(index++));
    data.setRemarks3(rs.getString(index++));
    data.setRemarks4(rs.getString(index++));
    data.setRemarks5(rs.getString(index++));
    data.setRemarks6(rs.getString(index++));
    data.setRemarks7(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
