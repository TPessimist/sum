package ame.psb.db.dao;

import ame.psb.db.CustomerItemDefect;
import ame.psb.db.ViewCustomerItemDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerItemDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_customer_item_defect(customer_item_bo,nc_code_bo,nc_value,updated_user,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_customer_item_defect SET nc_value=?,updated_user=?,updated_time=? WHERE customer_item_bo=? AND nc_code_bo=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,nc_code_bo,nc_value,nc_code,description FROM view_customer_item_defect ";

  private static final String SQL_SEL_BYSFC = "SELECT customer_item_bo,nc_code_bo,nc_value,nc_code,description FROM VIEW_SFC_ITEM_DEFECT ";

  private static final String SQL_SEL_ORIG = "SELECT a.customer_item_bo,a.nc_code_bo,a.nc_value,b.nc_code,b.description FROM  ZR_CUSTOMER_ITEM_DEFECT a INNER JOIN NC_CODE b ON a.NC_CODE_BO = b.HANDLE ";

  private final Connection conn;

  public CustomerItemDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomerItemDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getNcCodeBo());
      ps.setInt(3, data.getNcValue());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(CustomerItemDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getNcValue());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getCustomerItemBo());
      ps.setString(5, data.getNcCodeBo());

      return ps.executeUpdate();
    }
  }

  public int delete(String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_customer_item_defect WHERE customer_item_bo=? ")) {
      ps.setString(1, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public ViewCustomerItemDefect selectByPK(String customerItemBo, String ncCodeBo)
      throws SQLException {
    ViewCustomerItemDefect result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? AND nc_code_bo=?")) {
      ps.setString(1, customerItemBo);
      ps.setString(2, ncCodeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewCustomerItemDefect> selectByCustomerItem(String customerItemBo)
      throws SQLException {
    ArrayList<ViewCustomerItemDefect> result = new ArrayList<ViewCustomerItemDefect>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_bo=? ORDER BY nc_code_bo")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemDefect> selectByBatchId(String batchId) throws SQLException {
    ArrayList<ViewCustomerItemDefect> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_ORIG + "WHERE customer_item_bo=? ORDER BY nc_code_bo")) {
      ps.setString(1, batchId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemDefect> selectBySfc(String sfcBo) throws SQLException {
    ArrayList<ViewCustomerItemDefect> result = new ArrayList<ViewCustomerItemDefect>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_BYSFC + "WHERE sfc_bo = ? ORDER BY nc_code_bo")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewCustomerItemDefect> selectAll() throws SQLException {
    ArrayList<ViewCustomerItemDefect> result = new ArrayList<ViewCustomerItemDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewCustomerItemDefect convert(ResultSet rs) throws SQLException {
    ViewCustomerItemDefect data = new ViewCustomerItemDefect();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setNcValue(rs.getInt(index++));
    data.setNcCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));

    return data;
  }
}
