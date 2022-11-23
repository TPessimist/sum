package ame.psb.db.dao;

import ame.psb.db.E142XmlData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class E142XmlDataDao {

  private static final String SQL_INS = "INSERT INTO zr_e142_xml_data(id,item_name,item_name_orig,xml_data,updated_time) VALUES (?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_e142_xml_data SET item_name=?,item_name_orig=?,xml_data=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_name,item_name_orig,xml_data,updated_time FROM zr_e142_xml_data ";

  private final Connection conn;

  public E142XmlDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(E142XmlData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemName());
      ps.setString(3, data.getItemNameOrig());
      ps.setString(4, data.getXmlData());
      DateUtils.setDate(ps, 5, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<E142XmlData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (E142XmlData data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemName());
        ps.setString(3, data.getItemNameOrig());
        ps.setString(4, data.getXmlData());
        DateUtils.setDate(ps, 5, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(E142XmlData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setString(2, data.getItemNameOrig());
      ps.setString(3, data.getXmlData());
      DateUtils.setDate(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<E142XmlData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (E142XmlData data : dataList) {
        ps.setString(1, data.getItemName());
        ps.setString(2, data.getItemNameOrig());
        ps.setString(3, data.getXmlData());
        DateUtils.setDate(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_e142_xml_data WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<E142XmlData> selectAll() throws SQLException {
    ArrayList<E142XmlData> result = new ArrayList<E142XmlData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public E142XmlData selectByPK(String id) throws SQLException {
    E142XmlData result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private E142XmlData convert(ResultSet rs) throws SQLException {
    E142XmlData data = new E142XmlData();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setItemNameOrig(rs.getString(index++));
    data.setXmlData(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDate(rs, index++));

    return data;
  }
}
