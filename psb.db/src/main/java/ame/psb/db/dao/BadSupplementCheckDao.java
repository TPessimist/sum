package ame.psb.db.dao;

import ame.psb.db.BadSupplementCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BadSupplementCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_bad_supplement_check_table(wafer_bo,operation,check_sum,reason,description,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_bad_supplement_check_table SET check_sum=?,reason=?,description=?,updated_user=?,updated_time=? WHERE wafer_bo=? AND operation=?";

  private static final String SQL_SEL = "SELECT wafer_bo,operation,check_sum,reason,description,updated_user,updated_time FROM zr_bad_supplement_check_table ";

  private final Connection conn;

  public BadSupplementCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BadSupplementCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getWaferBo());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getCheckSum());
      ps.setString(4, data.getReason());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BadSupplementCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BadSupplementCheck data : dataList) {
        ps.setString(1, data.getWaferBo());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getCheckSum());
        ps.setString(4, data.getReason());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BadSupplementCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCheckSum());
      ps.setString(2, data.getReason());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getWaferBo());
      ps.setString(7, data.getOperation());

      return ps.executeUpdate();
    }
  }

  public int update(List<BadSupplementCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BadSupplementCheck data : dataList) {
        ps.setString(1, data.getCheckSum());
        ps.setString(2, data.getReason());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getWaferBo());
        ps.setString(7, data.getOperation());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferBo, String operation) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_bad_supplement_check_table WHERE wafer_bo=? AND operation=?")) {
      ps.setString(1, waferBo);
      ps.setString(2, operation);

      return ps.executeUpdate();
    }
  }

  public List<BadSupplementCheck> selectAll() throws SQLException {
    ArrayList<BadSupplementCheck> result = new ArrayList<BadSupplementCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BadSupplementCheck selectByPK(String waferBo, String operation) throws SQLException {
    BadSupplementCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE wafer_bo=? AND operation=?")) {
      ps.setString(1, waferBo);
      ps.setString(2, operation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BadSupplementCheck convert(ResultSet rs) throws SQLException {
    BadSupplementCheck data = new BadSupplementCheck();

    int index = 1;
    data.setWaferBo(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setCheckSum(rs.getString(index++));
    data.setReason(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
