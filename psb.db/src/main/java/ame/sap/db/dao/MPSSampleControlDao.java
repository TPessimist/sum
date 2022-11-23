package ame.sap.db.dao;

import ame.psb.db.MPSSampleControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MPSSampleControlDao {

  private static final String SQL_INS = "INSERT INTO zr_mps_sample_control(customer_itemset_name,shop_order_name,customer_file_result,customer_file_test_site,customer_file_part,customer_file_mes_lot,customer_file_sub_lot,customer_file_dc,customer_file_date,customer_file_qty,customer_rel_test_site,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_mps_sample_control SET customer_file_result=?,customer_file_test_site=?,customer_file_part=?,customer_file_mes_lot=?,customer_file_sub_lot=?,customer_file_dc=?,customer_file_date=?,customer_file_qty=?,customer_rel_test_site=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE customer_itemset_name=? AND shop_order_name=?";

  private static final String SQL_SEL = "SELECT customer_itemset_name,shop_order_name,customer_file_result,customer_file_test_site,customer_file_part,customer_file_mes_lot,customer_file_sub_lot,customer_file_dc,customer_file_date,customer_file_qty,customer_rel_test_site,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_mps_sample_control ";

  private final Connection conn;

  public MPSSampleControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MPSSampleControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemsetName());
      ps.setString(2, data.getShopOrderName());
      ps.setString(3, data.getCustomerFileResult());
      ps.setString(4, data.getCustomerFileTestSite());
      ps.setString(5, data.getCustomerFilePart());
      ps.setString(6, data.getCustomerFileMesLot());
      ps.setString(7, data.getCustomerFileSubLot());
      ps.setString(8, data.getCustomerFileDc());
      ps.setString(9, data.getCustomerFileDate());
      ps.setString(10, data.getCustomerFileQty());
      ps.setString(11, data.getCustomerRelTestSite());
      ps.setString(12, data.getReversedField1());
      ps.setString(13, data.getReversedField2());
      ps.setString(14, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MPSSampleControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MPSSampleControl data : dataList) {
        ps.setString(1, data.getCustomerItemsetName());
        ps.setString(2, data.getShopOrderName());
        ps.setString(3, data.getCustomerFileResult());
        ps.setString(4, data.getCustomerFileTestSite());
        ps.setString(5, data.getCustomerFilePart());
        ps.setString(6, data.getCustomerFileMesLot());
        ps.setString(7, data.getCustomerFileSubLot());
        ps.setString(8, data.getCustomerFileDc());
        ps.setString(9, data.getCustomerFileDate());
        ps.setString(10, data.getCustomerFileQty());
        ps.setString(11, data.getCustomerRelTestSite());
        ps.setString(12, data.getReversedField1());
        ps.setString(13, data.getReversedField2());
        ps.setString(14, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 15, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MPSSampleControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerFileResult());
      ps.setString(2, data.getCustomerFileTestSite());
      ps.setString(3, data.getCustomerFilePart());
      ps.setString(4, data.getCustomerFileMesLot());
      ps.setString(5, data.getCustomerFileSubLot());
      ps.setString(6, data.getCustomerFileDc());
      ps.setString(7, data.getCustomerFileDate());
      ps.setString(8, data.getCustomerFileQty());
      ps.setString(9, data.getCustomerRelTestSite());
      ps.setString(10, data.getReversedField1());
      ps.setString(11, data.getReversedField2());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      ps.setString(14, data.getCustomerItemsetName());
      ps.setString(15, data.getShopOrderName());

      return ps.executeUpdate();
    }
  }

  public int update(List<MPSSampleControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MPSSampleControl data : dataList) {
        ps.setString(1, data.getCustomerFileResult());
        ps.setString(2, data.getCustomerFileTestSite());
        ps.setString(3, data.getCustomerFilePart());
        ps.setString(4, data.getCustomerFileMesLot());
        ps.setString(5, data.getCustomerFileSubLot());
        ps.setString(6, data.getCustomerFileDc());
        ps.setString(7, data.getCustomerFileDate());
        ps.setString(8, data.getCustomerFileQty());
        ps.setString(9, data.getCustomerRelTestSite());
        ps.setString(10, data.getReversedField1());
        ps.setString(11, data.getReversedField2());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
        ps.setString(14, data.getCustomerItemsetName());
        ps.setString(15, data.getShopOrderName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemsetName, String shopOrderName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_mps_sample_control WHERE customer_itemset_name=? AND shop_order_name=?")) {
      ps.setString(1, customerItemsetName);
      ps.setString(2, shopOrderName);

      return ps.executeUpdate();
    }
  }

  public List<MPSSampleControl> selectAll() throws SQLException {
    ArrayList<MPSSampleControl> result = new ArrayList<MPSSampleControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MPSSampleControl selectByPK(String customerItemsetName, String shopOrderName)
      throws SQLException {
    MPSSampleControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_itemset_name=? AND shop_order_name=?")) {
      ps.setString(1, customerItemsetName);
      ps.setString(2, shopOrderName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MPSSampleControl convert(ResultSet rs) throws SQLException {
    MPSSampleControl data = new MPSSampleControl();

    int index = 1;
    data.setCustomerItemsetName(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setCustomerFileResult(rs.getString(index++));
    data.setCustomerFileTestSite(rs.getString(index++));
    data.setCustomerFilePart(rs.getString(index++));
    data.setCustomerFileMesLot(rs.getString(index++));
    data.setCustomerFileSubLot(rs.getString(index++));
    data.setCustomerFileDc(rs.getString(index++));
    data.setCustomerFileDate(rs.getString(index++));
    data.setCustomerFileQty(rs.getString(index++));
    data.setCustomerRelTestSite(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
