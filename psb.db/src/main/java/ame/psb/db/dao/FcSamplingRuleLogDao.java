package ame.psb.db.dao;

import ame.psb.db.FcSamplingRuleLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcSamplingRuleLogDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_sampling_rule_log(id,resource_bo,content,hours,state,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_sampling_rule_log SET resource_bo=?,content=?,hours=?,state=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,content,hours,state,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_fc_sampling_rule_log ";

  private final Connection conn;

  public FcSamplingRuleLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcSamplingRuleLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getContent());
      ps.setBigDecimal(4, data.getHours());
      ps.setString(5, data.getState());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcSamplingRuleLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcSamplingRuleLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getContent());
        ps.setBigDecimal(4, data.getHours());
        ps.setString(5, data.getState());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcSamplingRuleLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getContent());
      ps.setBigDecimal(3, data.getHours());
      ps.setString(4, data.getState());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcSamplingRuleLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcSamplingRuleLog data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getContent());
        ps.setBigDecimal(3, data.getHours());
        ps.setString(4, data.getState());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_sampling_rule_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FcSamplingRuleLog> selectAll() throws SQLException {
    ArrayList<FcSamplingRuleLog> result = new ArrayList<FcSamplingRuleLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FcSamplingRuleLog> selectResourceAndState(String resourceBo, String state,
      String action) throws SQLException {
    ArrayList<FcSamplingRuleLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where resource_bo = ? and state = ? and reversed_field1 = ? order by updated_time desc ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, state);
      ps.setString(3, action);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FcSamplingRuleLog selectByPK(String id) throws SQLException {
    FcSamplingRuleLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FcSamplingRuleLog convert(ResultSet rs) throws SQLException {
    FcSamplingRuleLog data = new FcSamplingRuleLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setHours(rs.getBigDecimal(index++));
    data.setState(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
