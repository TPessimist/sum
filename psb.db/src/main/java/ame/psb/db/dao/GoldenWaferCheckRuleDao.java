package ame.psb.db.dao;

import ame.psb.db.GoldenWaferCheckRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class GoldenWaferCheckRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_golden_wafer_check_rule(device_name,file_type,line_qty,x_col,y_col,bin_col,num_from_col,num_to_col,value_one,value_two,value_three,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_golden_wafer_check_rule SET file_type=?,line_qty=?,x_col=?,y_col=?,bin_col=?,num_from_col=?,num_to_col=?,value_one=?,value_two=?,value_three=?,update_user=?,update_time=? WHERE device_name=?";

  private static final String SQL_SEL = "SELECT device_name,file_type,line_qty,x_col,y_col,bin_col,num_from_col,num_to_col,value_one,value_two,value_three,update_user,update_time FROM zd_golden_wafer_check_rule ";

  private final Connection conn;

  public GoldenWaferCheckRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(GoldenWaferCheckRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDeviceName());
      ps.setString(2, data.getFileType());
      ps.setBigDecimal(3, data.getLineQty());
      ps.setBigDecimal(4, data.getXCol());
      ps.setBigDecimal(5, data.getYCol());
      ps.setBigDecimal(6, data.getBinCol());
      ps.setBigDecimal(7, data.getNumFromCol());
      ps.setBigDecimal(8, data.getNumToCol());
      ps.setString(9, data.getValueOne());
      ps.setString(10, data.getValueTwo());
      ps.setString(11, data.getValueThree());
      ps.setString(12, data.getUpdateUser());
      DateUtils.setDateTz(ps, 13, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<GoldenWaferCheckRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (GoldenWaferCheckRule data : dataList) {
        ps.setString(1, data.getDeviceName());
        ps.setString(2, data.getFileType());
        ps.setBigDecimal(3, data.getLineQty());
        ps.setBigDecimal(4, data.getXCol());
        ps.setBigDecimal(5, data.getYCol());
        ps.setBigDecimal(6, data.getBinCol());
        ps.setBigDecimal(7, data.getNumFromCol());
        ps.setBigDecimal(8, data.getNumToCol());
        ps.setString(9, data.getValueOne());
        ps.setString(10, data.getValueTwo());
        ps.setString(11, data.getValueThree());
        ps.setString(12, data.getUpdateUser());
        DateUtils.setDateTz(ps, 13, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(GoldenWaferCheckRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFileType());
      ps.setBigDecimal(2, data.getLineQty());
      ps.setBigDecimal(3, data.getXCol());
      ps.setBigDecimal(4, data.getYCol());
      ps.setBigDecimal(5, data.getBinCol());
      ps.setBigDecimal(6, data.getNumFromCol());
      ps.setBigDecimal(7, data.getNumToCol());
      ps.setString(8, data.getValueOne());
      ps.setString(9, data.getValueTwo());
      ps.setString(10, data.getValueThree());
      ps.setString(11, data.getUpdateUser());
      DateUtils.setDateTz(ps, 12, data.getUpdateTime());
      ps.setString(13, data.getDeviceName());

      return ps.executeUpdate();
    }
  }

  public int update(List<GoldenWaferCheckRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (GoldenWaferCheckRule data : dataList) {
        ps.setString(1, data.getFileType());
        ps.setBigDecimal(2, data.getLineQty());
        ps.setBigDecimal(3, data.getXCol());
        ps.setBigDecimal(4, data.getYCol());
        ps.setBigDecimal(5, data.getBinCol());
        ps.setBigDecimal(6, data.getNumFromCol());
        ps.setBigDecimal(7, data.getNumToCol());
        ps.setString(8, data.getValueOne());
        ps.setString(9, data.getValueTwo());
        ps.setString(10, data.getValueThree());
        ps.setString(11, data.getUpdateUser());
        DateUtils.setDateTz(ps, 12, data.getUpdateTime());
        ps.setString(13, data.getDeviceName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String deviceName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_golden_wafer_check_rule WHERE device_name=?")) {
      ps.setString(1, deviceName);

      return ps.executeUpdate();
    }
  }

  public List<GoldenWaferCheckRule> selectAll() throws SQLException {
    ArrayList<GoldenWaferCheckRule> result = new ArrayList<GoldenWaferCheckRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public GoldenWaferCheckRule selectByPK(String deviceName) throws SQLException {
    GoldenWaferCheckRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device_name=?")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private GoldenWaferCheckRule convert(ResultSet rs) throws SQLException {
    GoldenWaferCheckRule data = new GoldenWaferCheckRule();

    int index = 1;
    data.setDeviceName(rs.getString(index++));
    data.setFileType(rs.getString(index++));
    data.setLineQty(rs.getBigDecimal(index++));
    data.setXCol(rs.getBigDecimal(index++));
    data.setYCol(rs.getBigDecimal(index++));
    data.setBinCol(rs.getBigDecimal(index++));
    data.setNumFromCol(rs.getBigDecimal(index++));
    data.setNumToCol(rs.getBigDecimal(index++));
    data.setValueOne(rs.getString(index++));
    data.setValueTwo(rs.getString(index++));
    data.setValueThree(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
