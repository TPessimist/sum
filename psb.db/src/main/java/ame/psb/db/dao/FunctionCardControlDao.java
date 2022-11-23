package ame.psb.db.dao;

import ame.psb.db.FunctionCardControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FunctionCardControlDao {

  private static final String SQL_INS = "INSERT INTO zr_function_card_control(function_id,function_name,function_state,update_user,update_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_function_card_control SET function_name=?,function_state=?,update_user=?,update_time=? WHERE function_id=?";

  private static final String SQL_SEL = "SELECT function_id,function_name,function_state,update_user,update_time FROM zr_function_card_control ";

  private final Connection conn;

  public FunctionCardControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FunctionCardControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getFunctionId());
      ps.setString(2, data.getFunctionName());
      ps.setString(3, data.getFunctionState());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FunctionCardControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FunctionCardControl data : dataList) {
        ps.setString(1, data.getFunctionId());
        ps.setString(2, data.getFunctionName());
        ps.setString(3, data.getFunctionState());
        ps.setString(4, data.getUpdateUser());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FunctionCardControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFunctionName());
      ps.setString(2, data.getFunctionState());
      ps.setString(3, data.getUpdateUser());
      DateUtils.setDateTz(ps, 4, data.getUpdateTime());
      ps.setString(5, data.getFunctionId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FunctionCardControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FunctionCardControl data : dataList) {
        ps.setString(1, data.getFunctionName());
        ps.setString(2, data.getFunctionState());
        ps.setString(3, data.getUpdateUser());
        DateUtils.setDateTz(ps, 4, data.getUpdateTime());
        ps.setString(5, data.getFunctionId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String functionId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_function_card_control WHERE function_id=?")) {
      ps.setString(1, functionId);

      return ps.executeUpdate();
    }
  }

  public List<FunctionCardControl> selectAll() throws SQLException {
    ArrayList<FunctionCardControl> result = new ArrayList<FunctionCardControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FunctionCardControl selectByPK(String functionId) throws SQLException {
    FunctionCardControl result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE function_id=?")) {
      ps.setString(1, functionId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public boolean isOpen(String functionId) throws SQLException {
    boolean result = false;
    FunctionCardControl flag = selectByPK(functionId);
    if (flag != null && "Y".equals(flag.getFunctionState())) {
      result = true;
    }
    return result;
  }

  private FunctionCardControl convert(ResultSet rs) throws SQLException {
    FunctionCardControl data = new FunctionCardControl();

    int index = 1;
    data.setFunctionId(rs.getString(index++));
    data.setFunctionName(rs.getString(index++));
    data.setFunctionState(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
