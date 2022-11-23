package ame.psb.db.dao;

import ame.psb.db.Picture68DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Picture68DataSourceDao {

  private static final String SQL_INS = "INSERT INTO zr_68_picture_data_source(customer_item_bo,customer_itemset_bo,frequency,file_path,device_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_68_picture_data_source SET customer_itemset_bo=?,frequency=?,file_path=?,device_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE customer_item_bo=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,customer_itemset_bo,frequency,file_path,device_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_68_picture_data_source ";

  private static final String SQL_SEL_TOP1 = "SELECT top 1  customer_item_bo,customer_itemset_bo,frequency,file_path,device_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_68_picture_data_source ";


  private final Connection conn;

  public Picture68DataSourceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Picture68DataSource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getCustomerItemsetBo());
      ps.setBigDecimal(3, data.getFrequency());
      ps.setString(4, data.getFilePath());
      ps.setString(5, data.getDeviceName());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Picture68DataSource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Picture68DataSource data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getCustomerItemsetBo());
        ps.setBigDecimal(3, data.getFrequency());
        ps.setString(4, data.getFilePath());
        ps.setString(5, data.getDeviceName());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Picture68DataSource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerItemsetBo());
      ps.setBigDecimal(2, data.getFrequency());
      ps.setString(3, data.getFilePath());
      ps.setString(4, data.getDeviceName());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<Picture68DataSource> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Picture68DataSource data : dataList) {
        ps.setString(1, data.getCustomerItemsetBo());
        ps.setBigDecimal(2, data.getFrequency());
        ps.setString(3, data.getFilePath());
        ps.setString(4, data.getDeviceName());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getCustomerItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_68_picture_data_source WHERE customer_item_bo=?")) {
      ps.setString(1, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public int deleteBackup() throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_68_picture_data_source WHERE REVERSED_FIELD1=?")) {
      ps.setString(1, "BACKUP");

      return ps.executeUpdate();
    }
  }

  public int deleteInTime() throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_68_picture_data_source WHERE REVERSED_FIELD1=?")) {
      ps.setString(1, "INTIME");

      return ps.executeUpdate();
    }
  }

  public List<Picture68DataSource> selectAll() throws SQLException {
    ArrayList<Picture68DataSource> result = new ArrayList<Picture68DataSource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Picture68DataSource> selectByLot(String lot) throws SQLException {
    ArrayList<Picture68DataSource> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where CUSTOMER_ITEMSET_BO like ?")) {
      ps.setString(1, "%" + lot + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Picture68DataSource selectByPK(String customerItemBo) throws SQLException {
    Picture68DataSource result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer_item_bo=?")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<Picture68DataSource> selectTop1(String deviceName) throws SQLException {
    ArrayList<Picture68DataSource> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_TOP1 + " where device_name = ? order by FREQUENCY asc")) {
      ps.setString(1, deviceName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Picture68DataSource> selectByDeviceName(String deviceName) throws SQLException {
    ArrayList<Picture68DataSource> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where device_name = ? order by FREQUENCY asc")) {
      ps.setString(1, deviceName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<Picture68DataSource> selectByFrequency(int fre) throws SQLException {
    ArrayList<Picture68DataSource> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where FREQUENCY = ?")) {
      ps.setInt(1, fre);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private Picture68DataSource convert(ResultSet rs) throws SQLException {
    Picture68DataSource data = new Picture68DataSource();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setFrequency(rs.getBigDecimal(index++));
    data.setFilePath(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
