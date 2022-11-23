package ame.psb.db.dao;

import ame.psb.db.ViewToolingMask;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uia.utils.dao.DateUtils;

public class ToolingMaskDao {

  private static final String SQL_SEL = "SELECT handle,site,status_bo,description,qty,exp_date,tool_group,criteria1,criteria2 FROM view_tooling_mask ";

  private final Connection conn;

  public ToolingMaskDao(Connection conn) {
    this.conn = conn;
  }

  public ViewToolingMask selectByPK(String itemBo, String operationBo) throws SQLException {
    ViewToolingMask result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE (criteria1=? AND criteria2=?) OR (criteria1=? AND criteria2=?)")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);
      ps.setString(3, operationBo);
      ps.setString(4, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewToolingMask convert(ResultSet rs) throws SQLException {
    ViewToolingMask data = new ViewToolingMask();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setExpDate(DateUtils.getDateTz(rs, index++));
    data.setToolGroup(rs.getString(index++));
    data.setCriteria1(rs.getString(index++));
    data.setCriteria2(rs.getString(index++));

    return data;
  }
}
