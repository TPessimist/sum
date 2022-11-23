package ame.psb.db.dao;

import ame.psb.db.TestSod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class TestSodDao {

  private static final String SQL_INS = "INSERT INTO zr_test_sod(shop_order,device,size,sfc,iqc_out_time,bumping_ct,bumping_sod,fin_ct,fin_sod) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_test_sod SET device=?,size=?,sfc=?,iqc_out_time=?,bumping_ct=?,bumping_sod=?,fin_ct=?,fin_sod=? WHERE shop_order=?";

  private static final String SQL_SEL = "SELECT shop_order,device,size,sfc,iqc_out_time,bumping_ct,bumping_sod,fin_ct,fin_sod FROM zr_test_sod ";

  private final Connection conn;

  public TestSodDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TestSod data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrder());
      ps.setString(2, data.getDevice());
      ps.setString(3, data.getSize());
      ps.setString(4, data.getSfc());
      DateUtils.setDateTz(ps, 5, data.getIqcOutTime());
      ps.setString(6, data.getBumpingCt());
      DateUtils.setDateTz(ps, 7, data.getBumpingSod());
      ps.setString(8, data.getFinCt());
      DateUtils.setDateTz(ps, 9, data.getFinSod());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TestSod> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TestSod data : dataList) {
        ps.setString(1, data.getShopOrder());
        ps.setString(2, data.getDevice());
        ps.setString(3, data.getSize());
        ps.setString(4, data.getSfc());
        DateUtils.setDateTz(ps, 5, data.getIqcOutTime());
        ps.setString(6, data.getBumpingCt());
        DateUtils.setDateTz(ps, 7, data.getBumpingSod());
        ps.setString(8, data.getFinCt());
        DateUtils.setDateTz(ps, 9, data.getFinSod());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TestSod data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDevice());
      ps.setString(2, data.getSize());
      ps.setString(3, data.getSfc());
      DateUtils.setDateTz(ps, 4, data.getIqcOutTime());
      ps.setString(5, data.getBumpingCt());
      DateUtils.setDateTz(ps, 6, data.getBumpingSod());
      ps.setString(7, data.getFinCt());
      DateUtils.setDateTz(ps, 8, data.getFinSod());
      ps.setString(9, data.getShopOrder());

      return ps.executeUpdate();
    }
  }

  public int update(List<TestSod> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TestSod data : dataList) {
        ps.setString(1, data.getDevice());
        ps.setString(2, data.getSize());
        ps.setString(3, data.getSfc());
        DateUtils.setDateTz(ps, 4, data.getIqcOutTime());
        ps.setString(5, data.getBumpingCt());
        DateUtils.setDateTz(ps, 6, data.getBumpingSod());
        ps.setString(7, data.getFinCt());
        DateUtils.setDateTz(ps, 8, data.getFinSod());
        ps.setString(9, data.getShopOrder());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrder) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_test_sod WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      return ps.executeUpdate();
    }
  }

  public List<TestSod> selectAll() throws SQLException {
    ArrayList<TestSod> result = new ArrayList<TestSod>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public TestSod selectByPK(String shopOrder) throws SQLException {
    TestSod result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order=?")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private TestSod convert(ResultSet rs) throws SQLException {
    TestSod data = new TestSod();

    int index = 1;
    data.setShopOrder(rs.getString(index++));
    data.setDevice(rs.getString(index++));
    data.setSize(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setIqcOutTime(DateUtils.getDateTz(rs, index++));
    data.setBumpingCt(rs.getString(index++));
    data.setBumpingSod(DateUtils.getDateTz(rs, index++));
    data.setFinCt(rs.getString(index++));
    data.setFinSod(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
