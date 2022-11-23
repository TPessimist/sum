package ame.htks.db.dao;

import ame.htks.db.NpiStage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class NpiStageDao {

  private static final String SQL_INS = "INSERT INTO zh_npi_stage(handle,stage,description,stage_operations,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_npi_stage SET stage=?,description=?,stage_operations=?,updated_user=?,updated_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,stage,description,stage_operations,updated_user,updated_time FROM zh_npi_stage ";

  private final Connection conn;

  public NpiStageDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(NpiStage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getStage());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getStageOperations());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<NpiStage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (NpiStage data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getStage());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getStageOperations());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(NpiStage data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getStage());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getStageOperations());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<NpiStage> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (NpiStage data : dataList) {
        ps.setString(1, data.getStage());
        ps.setString(2, data.getDescription());
        ps.setString(3, data.getStageOperations());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zh_npi_stage WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<NpiStage> selectAll() throws SQLException {
    ArrayList<NpiStage> result = new ArrayList<NpiStage>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public NpiStage selectByPK(String handle) throws SQLException {
    NpiStage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private NpiStage convert(ResultSet rs) throws SQLException {
    NpiStage data = new NpiStage();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setStage(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStageOperations(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
