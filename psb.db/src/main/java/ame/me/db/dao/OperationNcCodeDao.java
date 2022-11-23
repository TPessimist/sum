package ame.me.db.dao;

import ame.me.db.OperationNcCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationNcCodeDao {

  private static final String SQL_SEL = "SELECT operation_bo,nc_code_bo,description FROM view_operation_nc_code ";

  private final Connection conn;

  public OperationNcCodeDao(Connection conn) {
    this.conn = conn;
  }

  public List<OperationNcCode> select(String operationBo) throws SQLException {
    ArrayList<OperationNcCode> result = new ArrayList<OperationNcCode>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? ORDER BY nc_code_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<OperationNcCode> selectOrderByNcCodeSeq(String operationBo) throws SQLException {
    ArrayList<OperationNcCode> result = new ArrayList<OperationNcCode>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE operation_bo=? ORDER BY  SUBSTRING(NC_CODE_BO, LENGTH(NC_CODE_BO)-2, 3)  ")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private OperationNcCode convert(ResultSet rs) throws SQLException {
    OperationNcCode data = new OperationNcCode();

    int index = 1;
    data.setOperationBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setDescription(rs.getString(index++));

    return data;
  }
}
