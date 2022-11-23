package ame.htks.db.dao;

import ame.htks.db.CpResultDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CpResultDetailDao {

  private static final String SQL_INS = "INSERT INTO zh_cp_result_detail(result_id,bin_code,bin_qty,updated_time,operation_bo) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_cp_result_detail SET bin_code=?,bin_qty=?,updated_time=?,operation_bo=? WHERE result_id=?";

  private static final String SQL_SEL = "SELECT result_id,bin_code,bin_qty,updated_time,operation_bo FROM zh_cp_result_detail ";

  private final Connection conn;

  public CpResultDetailDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CpResultDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResultId());
      ps.setString(2, data.getBinCode());
      ps.setInt(3, data.getBinQty());
      ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(5, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CpResultDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CpResultDetail data : dataList) {
        ps.setString(1, data.getResultId());
        ps.setString(2, data.getBinCode());
        ps.setInt(3, data.getBinQty());
        ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(5, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int deleteByResultId(String resultId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_cp_result_detail WHERE result_id=?")) {
      ps.setString(1, resultId);

      return ps.executeUpdate();
    }
  }

  public int deleteByResultId(String resultId, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_cp_result_detail WHERE result_id=? and operation_bo=?")) {
      ps.setString(1, resultId);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<CpResultDetail> selectAll() throws SQLException {
    ArrayList<CpResultDetail> result = new ArrayList<CpResultDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private CpResultDetail convert(ResultSet rs) throws SQLException {
    CpResultDetail data = new CpResultDetail();

    int index = 1;
    data.setResultId(rs.getString(index++));
    data.setBinCode(rs.getString(index++));
    data.setBinQty(rs.getInt(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));
    data.setOperationBo(rs.getString(index++));

    return data;
  }
}
