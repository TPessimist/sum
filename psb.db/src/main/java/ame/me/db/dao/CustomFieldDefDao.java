package ame.me.db.dao;

import ame.me.db.CustomFieldDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CustomFieldDefDao {

  private static final String SQL_INS = "INSERT INTO custom_field_def(handle,table_name,field_name,field_label,required,sequence,site,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE custom_field_def SET table_name=?,field_name=?,field_label=?,required=?,sequence=?,site=?,created_date_time=?,modified_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,table_name,field_name,field_label,required,sequence,site,created_date_time,modified_date_time FROM custom_field_def ";

  private final Connection conn;

  public CustomFieldDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustomFieldDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getTableName());
      ps.setString(3, data.getFieldName());
      ps.setString(4, data.getFieldLabel());
      ps.setString(5, data.getRequired());
      ps.setBigDecimal(6, data.getSequence());
      ps.setString(7, data.getSite());
      ps.setTimestamp(8, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(9, new Timestamp(data.getModifiedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustomFieldDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustomFieldDef data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getTableName());
        ps.setString(3, data.getFieldName());
        ps.setString(4, data.getFieldLabel());
        ps.setString(5, data.getRequired());
        ps.setBigDecimal(6, data.getSequence());
        ps.setString(7, data.getSite());
        ps.setTimestamp(8, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(9, new Timestamp(data.getModifiedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustomFieldDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getTableName());
      ps.setString(2, data.getFieldName());
      ps.setString(3, data.getFieldLabel());
      ps.setString(4, data.getRequired());
      ps.setBigDecimal(5, data.getSequence());
      ps.setString(6, data.getSite());
      ps.setTimestamp(7, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(8, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(9, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustomFieldDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustomFieldDef data : dataList) {
        ps.setString(1, data.getTableName());
        ps.setString(2, data.getFieldName());
        ps.setString(3, data.getFieldLabel());
        ps.setString(4, data.getRequired());
        ps.setBigDecimal(5, data.getSequence());
        ps.setString(6, data.getSite());
        ps.setTimestamp(7, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(8, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(9, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM custom_field_def WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<CustomFieldDef> selectAll() throws SQLException {
    ArrayList<CustomFieldDef> result = new ArrayList<CustomFieldDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CustomFieldDef> selectByTableName(String tableName) throws SQLException {
    ArrayList<CustomFieldDef> result = new ArrayList<CustomFieldDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE TABLE_NAME=?")) {
      ps.setString(1, tableName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CustomFieldDef selectByPK(String handle) throws SQLException {
    CustomFieldDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustomFieldDef convert(ResultSet rs) throws SQLException {
    CustomFieldDef data = new CustomFieldDef();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setTableName(rs.getString(index++));
    data.setFieldName(rs.getString(index++));
    data.setFieldLabel(rs.getString(index++));
    data.setRequired(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));

    return data;
  }
}
