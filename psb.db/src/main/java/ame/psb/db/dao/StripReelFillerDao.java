package ame.psb.db.dao;

import ame.psb.db.StripReelFiller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class StripReelFillerDao {

  private static final String SQL_INS = "INSERT INTO zr_strip_reel_filler(customer_item_bo,filler_customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_strip_reel_filler SET die_qty=?,good_bad=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND filler_customer_item_bo=? AND grade_id=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,filler_customer_item_bo,grade_id,die_qty,good_bad,updated_user,updated_time FROM zr_strip_reel_filler ";

  private final Connection conn;

  public StripReelFillerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(StripReelFiller data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getFillerCustomerItemBo());
      ps.setString(3, data.getGradeId());
      ps.setInt(4, data.getDieQty());
      ps.setString(5, data.getGoodBad());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<StripReelFiller> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (StripReelFiller data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getFillerCustomerItemBo());
        ps.setString(3, data.getGradeId());
        ps.setInt(4, data.getDieQty());
        ps.setString(5, data.getGoodBad());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(StripReelFiller data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getDieQty());
      ps.setString(2, data.getGoodBad());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getCustomerItemBo());
      ps.setString(6, data.getFillerCustomerItemBo());
      ps.setString(7, data.getGradeId());

      return ps.executeUpdate();
    }
  }

  public int update(List<StripReelFiller> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (StripReelFiller data : dataList) {
        ps.setInt(1, data.getDieQty());
        ps.setString(2, data.getGoodBad());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getCustomerItemBo());
        ps.setString(6, data.getFillerCustomerItemBo());
        ps.setString(7, data.getGradeId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo, String fillerCustomerItemBo, String gradeId)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_strip_reel_filler WHERE customer_item_bo=? AND filler_customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, fillerCustomerItemBo);
      ps.setString(3, gradeId);

      return ps.executeUpdate();
    }
  }

  public List<StripReelFiller> selectAll() throws SQLException {
    ArrayList<StripReelFiller> result = new ArrayList<StripReelFiller>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public StripReelFiller selectByPK(String customerItemBo, String fillerCustomerItemBo,
      String gradeId) throws SQLException {
    StripReelFiller result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_bo=? AND filler_customer_item_bo=? AND grade_id=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, fillerCustomerItemBo);
      ps.setString(3, gradeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private StripReelFiller convert(ResultSet rs) throws SQLException {
    StripReelFiller data = new StripReelFiller();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setFillerCustomerItemBo(rs.getString(index++));
    data.setGradeId(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setGoodBad(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
