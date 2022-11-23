package ame.psb.db.dao;

import ame.psb.db.ZrCustomerItemGradeMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZrCustomerItemGradeMapDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_grade_map(customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_grade_map SET die_qty=?,good_bad=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND grade_id=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time FROM zr_customer_item_grade_map ";

  private final Connection conn;

  public ZrCustomerItemGradeMapDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrCustomerItemGradeMap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getGradeId());
      ps.setInt(3, data.getDieQty());
      ps.setString(4, data.getGoodBad());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrCustomerItemGradeMap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrCustomerItemGradeMap data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getGradeId());
        ps.setInt(3, data.getDieQty());
        ps.setString(4, data.getGoodBad());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrCustomerItemGradeMap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getDieQty());
      ps.setString(2, data.getGoodBad());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getGradeId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrCustomerItemGradeMap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrCustomerItemGradeMap data : dataList) {
        ps.setInt(1, data.getDieQty());
        ps.setString(2, data.getGoodBad());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getGradeId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String gradeId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_customer_item_grade_map WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      return ps.executeUpdate();
    }
  }

  public List<ZrCustomerItemGradeMap> selectAll() throws SQLException {
    ArrayList<ZrCustomerItemGradeMap> result = new ArrayList<ZrCustomerItemGradeMap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrCustomerItemGradeMap selectByPK(String customerItemBo, String gradeId)
      throws SQLException {
    ZrCustomerItemGradeMap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZrCustomerItemGradeMap convert(ResultSet rs) throws SQLException {
    ZrCustomerItemGradeMap data = new ZrCustomerItemGradeMap();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setGoodBad(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
