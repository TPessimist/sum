package ame.htks.db.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReportMapDao {

  private String SQL;
  private Connection conn;

  public ReportMapDao(String sql, Connection conn) {
    this.SQL = sql;
    this.conn = conn;

  }

  public List<Map<String, Object>> queryByParameter(List<Parameter> parameters)
      throws SQLException {
    List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL)) {
      for (int i = 0; i < parameters.size(); i++) {
        switch (parameters.get(i).type) {
          case "number":
            try {
              ps.setBigDecimal(i + 1, new BigDecimal(parameters.get(i).value.toString()));
            } catch (Exception ex) {
              ps.setBigDecimal(i + 1, null);
            }

            break;
          case "datetime":
          case "datetime-local":
            try {
              ps.setTimestamp(i + 1, Timestamp.valueOf(parameters.get(i).value.toString()));
            } catch (Exception ex) {
              ps.setTimestamp(i + 1, null);
            }
            break;
          default:
            ps.setString(i + 1, "" + parameters.get(i).value);


        }
        //ps.setString(i+1, parameters.get(i));
      }

      ResultSet rs = ps.executeQuery();

      ResultSetMetaData md = rs.getMetaData();

      int columnCount = md.getColumnCount();
      int rowCount = 0;
      while (rs.next()) {
        rowCount++;
        if (rowCount > 5000) {
          throw new SQLException("行数超过" + rowCount + "行,请缩小检索范围");
        }
        result.add(convert(rs, md, columnCount));
      }
      return result;
    }

  }

  private Map<String, Object> convert(ResultSet rs, ResultSetMetaData md, int columnCount)
      throws SQLException {
    Map<String, Object> rowData = new HashMap<String, Object>();
    for (int i = 1; i <= columnCount; i++) {

      rowData.put(md.getColumnName(i).toLowerCase(), rs.getObject(i));

    }

    return rowData;
  }

  public static class Parameter {

    public String name;
    public String value;
    public String type;
    public String desc;
  }

  public static class Column {

    public String name;
    public String desc;
  }


}
