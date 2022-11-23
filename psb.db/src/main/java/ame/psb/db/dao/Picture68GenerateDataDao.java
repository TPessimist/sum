package ame.psb.db.dao;

import ame.psb.db.Picture68GenerateData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Picture68GenerateDataDao {

  private static final String SQL_INS = "INSERT INTO zr_68_picture_generate_data(customer_item_bo,customer_itemset_bo,sfc_bo,source_customer_item_bo,source_file_path,destination_file_path,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_68_picture_generate_data SET customer_itemset_bo=?,sfc_bo=?,source_customer_item_bo=?,source_file_path=?,destination_file_path=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE customer_item_bo=?";

  private static final String SQL_SEL = "SELECT customer_item_bo,customer_itemset_bo,sfc_bo,source_customer_item_bo,source_file_path,destination_file_path,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_68_picture_generate_data ";

  private final Connection conn;

  public Picture68GenerateDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Picture68GenerateData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomerItemBo());
      ps.setString(2, data.getCustomerItemsetBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getSourceCustomerItemBo());
      ps.setString(5, data.getSourceFilePath());
      ps.setString(6, data.getDestinationFilePath());
      ps.setString(7, data.getReversedField1());
      ps.setString(8, data.getReversedField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Picture68GenerateData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Picture68GenerateData data : dataList) {
        ps.setString(1, data.getCustomerItemBo());
        ps.setString(2, data.getCustomerItemsetBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getSourceCustomerItemBo());
        ps.setString(5, data.getSourceFilePath());
        ps.setString(6, data.getDestinationFilePath());
        ps.setString(7, data.getReversedField1());
        ps.setString(8, data.getReversedField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Picture68GenerateData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerItemsetBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getSourceCustomerItemBo());
      ps.setString(4, data.getSourceFilePath());
      ps.setString(5, data.getDestinationFilePath());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<Picture68GenerateData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Picture68GenerateData data : dataList) {
        ps.setString(1, data.getCustomerItemsetBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getSourceCustomerItemBo());
        ps.setString(4, data.getSourceFilePath());
        ps.setString(5, data.getDestinationFilePath());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getCustomerItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_68_picture_generate_data WHERE customer_item_bo=?")) {
      ps.setString(1, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public List<Picture68GenerateData> selectAll() throws SQLException {
    ArrayList<Picture68GenerateData> result = new ArrayList<Picture68GenerateData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Picture68GenerateData> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<Picture68GenerateData> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where sfc_bo = ? ORDER BY CUSTOMER_ITEM_BO")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Picture68GenerateData selectByPK(String customerItemBo) throws SQLException {
    Picture68GenerateData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer_item_bo=?")) {
      ps.setString(1, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Picture68GenerateData convert(ResultSet rs) throws SQLException {
    Picture68GenerateData data = new Picture68GenerateData();

    int index = 1;
    data.setCustomerItemBo(rs.getString(index++));
    data.setCustomerItemsetBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSourceCustomerItemBo(rs.getString(index++));
    data.setSourceFilePath(rs.getString(index++));
    data.setDestinationFilePath(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
