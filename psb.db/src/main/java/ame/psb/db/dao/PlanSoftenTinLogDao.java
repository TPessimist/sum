package ame.psb.db.dao;

import ame.psb.db.PlanSoftenTinLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PlanSoftenTinLogDao {

  private static final String SQL_INS = "INSERT INTO zd_plan_soften_tin_log(id,name,content,log_user,log_time,reversed1,reversed2,reversed3) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_plan_soften_tin_log SET name=?,content=?,log_user=?,log_time=?,reversed1=?,reversed2=?,reversed3=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,name,content,log_user,log_time,reversed1,reversed2,reversed3 FROM zd_plan_soften_tin_log ";

  private final Connection conn;

  public PlanSoftenTinLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlanSoftenTinLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getName());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getLogUser());
      DateUtils.setDateTz(ps, 5, data.getLogTime());
      ps.setString(6, data.getReversed1());
      ps.setString(7, data.getReversed2());
      ps.setString(8, data.getReversed3());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlanSoftenTinLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlanSoftenTinLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getName());
        ps.setString(3, data.getContent());
        ps.setString(4, data.getLogUser());
        DateUtils.setDateTz(ps, 5, data.getLogTime());
        ps.setString(6, data.getReversed1());
        ps.setString(7, data.getReversed2());
        ps.setString(8, data.getReversed3());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlanSoftenTinLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getName());
      ps.setString(2, data.getContent());
      ps.setString(3, data.getLogUser());
      DateUtils.setDateTz(ps, 4, data.getLogTime());
      ps.setString(5, data.getReversed1());
      ps.setString(6, data.getReversed2());
      ps.setString(7, data.getReversed3());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PlanSoftenTinLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PlanSoftenTinLog data : dataList) {
        ps.setString(1, data.getName());
        ps.setString(2, data.getContent());
        ps.setString(3, data.getLogUser());
        DateUtils.setDateTz(ps, 4, data.getLogTime());
        ps.setString(5, data.getReversed1());
        ps.setString(6, data.getReversed2());
        ps.setString(7, data.getReversed3());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_plan_soften_tin_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PlanSoftenTinLog> selectAll() throws SQLException {
    ArrayList<PlanSoftenTinLog> result = new ArrayList<PlanSoftenTinLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PlanSoftenTinLog selectByPK(String id) throws SQLException {
    PlanSoftenTinLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PlanSoftenTinLog convert(ResultSet rs) throws SQLException {
    PlanSoftenTinLog data = new PlanSoftenTinLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setLogUser(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));
    data.setReversed1(rs.getString(index++));
    data.setReversed2(rs.getString(index++));
    data.setReversed3(rs.getString(index++));

    return data;
  }
}
