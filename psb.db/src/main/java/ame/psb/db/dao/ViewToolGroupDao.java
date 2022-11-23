package ame.psb.db.dao;

import ame.psb.db.ViewToolGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewToolGroupDao {

  private static final String SQL_SEL = "SELECT handle,site,status_bo,description,qty,exp_date,tool_group,criteria1,criteria2,criteria3,qty_req FROM view_tool_group ";

  private final Connection conn;

  public ViewToolGroupDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewToolGroup> selectAll() throws SQLException {
    ArrayList<ViewToolGroup> result = new ArrayList<ViewToolGroup>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewToolGroup> selectByProductAndOperation(String itemBo, String operationBo)
      throws SQLException {
    ArrayList<ViewToolGroup> result = new ArrayList<ViewToolGroup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where criteria1 = ? and criteria2 = ? ")) {
      ps.setString(1, itemBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewToolGroup convert(ResultSet rs) throws SQLException {
    ViewToolGroup data = new ViewToolGroup();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setExpDate(rs.getTimestamp(index++));
    data.setToolGroup(rs.getString(index++));
    data.setCriteria1(rs.getString(index++));
    data.setCriteria2(rs.getString(index++));
    data.setCriteria3(rs.getString(index++));
    data.setRequiredQty(rs.getString(index++));

    return data;
  }
}
