package ame.psb.db.dao;

import ame.psb.db.SfcItemGrade;
import ame.psb.db.ViewSfcItemGrade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SfcItemGradeDao {

  private static final String SQL_INS = "INSERT INTO zd_sfc_item_grade(sfc_bo,customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_sfc_item_grade SET die_qty=?,good_bad=?,updated_user=?,updated_time=? WHERE sfc_bo=? AND customer_item_bo=? AND grade_id=?";

  private static final String SQL_SEL = "SELECT sfc_bo,customer_item_bo,grade_id,die_qty,good_bad,customer_item_name,sfc_name FROM view_sfc_item_grade ";

  private final Connection conn;

  public SfcItemGradeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcItemGrade data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getGradeId());
      ps.setInt(4, data.getDieQty());
      ps.setString(5, data.getGoodBad());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(SfcItemGrade data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getDieQty());
      ps.setString(2, data.getGoodBad());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getSfcBo());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getGradeId());

      return ps.executeUpdate();
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_sfc_item_grade WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      return ps.executeUpdate();
    }
  }

  public int delete(String sfcBo, String customerItemBo, String gradeId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_sfc_item_grade WHERE sfc_bo=? AND customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, customerItemBo);
      ps.setString(3, gradeId);

      return ps.executeUpdate();
    }
  }

  public List<ViewSfcItemGrade> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewSfcItemGrade> result = new ArrayList<ViewSfcItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? ORDER BY customer_item_bo,grade_id")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSfcItemGrade> selectByCustomerItem(String customerItemBo) throws SQLException {
    ArrayList<ViewSfcItemGrade> result = new ArrayList<ViewSfcItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? ORDER BY sfc_bo,grade_id")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSfcItemGrade> selectByCustomerItem(String customerItemBo, String gradeId)
      throws SQLException {
    ArrayList<ViewSfcItemGrade> result = new ArrayList<ViewSfcItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND grade_id=? ORDER BY sfc_bo")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, gradeId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewSfcItemGrade> selectBySfc(String sfcBo, String customerItemBo)
      throws SQLException {
    ArrayList<ViewSfcItemGrade> result = new ArrayList<ViewSfcItemGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND customer_item_bo=? ORDER BY grade_id")) {
      ps.setString(1, sfcBo);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewSfcItemGrade selectByPK(String sfcBo, String customerItemBo, String gradeId)
      throws SQLException {
    ViewSfcItemGrade result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, customerItemBo);
      ps.setString(3, gradeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewSfcItemGrade convert(ResultSet rs) throws SQLException {
    ViewSfcItemGrade data = new ViewSfcItemGrade();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setGoodBad(rs.getString(index++));
    data.setCustomerItemName(rs.getString(index++));
    data.setSfcName(rs.getString(index++));

    return data;
  }
}
