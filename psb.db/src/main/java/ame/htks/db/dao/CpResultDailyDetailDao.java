package ame.htks.db.dao;

import ame.htks.db.CpResultDetailDaily;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CpResultDailyDetailDao {

  private static final String SQL_INS = "INSERT INTO zh_cp_result_detail_daily(result_id,bin_code,bin_qty,updated_time,operation_bo) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_cp_result_detail_daily SET bin_code=?,bin_qty=?,updated_time=?,operation_bo=? WHERE result_id=?";

  private static final String SQL_SEL = "SELECT result_id,bin_code,bin_qty,updated_time,operation_bo FROM zh_cp_result_detail_daily ";

  private final Connection conn;

  public CpResultDailyDetailDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CpResultDetailDaily data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResultId());
      ps.setString(2, data.getBinCode());
      ps.setString(3, data.getBinQty());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CpResultDetailDaily> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CpResultDetailDaily data : dataList) {
        ps.setString(1, data.getResultId());
        ps.setString(2, data.getBinCode());
        ps.setString(3, data.getBinQty());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CpResultDetailDaily data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinCode());
      ps.setString(2, data.getBinQty());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getResultId());

      return ps.executeUpdate();
    }
  }

  public int update(List<CpResultDetailDaily> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CpResultDetailDaily data : dataList) {
        ps.setString(1, data.getBinCode());
        ps.setString(2, data.getBinQty());
        DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getResultId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resultId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_cp_result_detail_daily WHERE result_id=?")) {
      ps.setString(1, resultId);

      return ps.executeUpdate();
    }
  }

  public List<CpResultDetailDaily> selectAll() throws SQLException {
    ArrayList<CpResultDetailDaily> result = new ArrayList<CpResultDetailDaily>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CpResultDetailDaily selectByPK(String resultId) throws SQLException {
    CpResultDetailDaily result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE result_id=?")) {
      ps.setString(1, resultId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CpResultDetailDaily convert(ResultSet rs) throws SQLException {
    CpResultDetailDaily data = new CpResultDetailDaily();

    int index = 1;
    data.setResultId(rs.getString(index++));
    data.setBinCode(rs.getString(index++));
    data.setBinQty(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
