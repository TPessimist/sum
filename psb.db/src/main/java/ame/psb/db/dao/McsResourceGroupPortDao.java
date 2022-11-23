package ame.psb.db.dao;

import ame.psb.db.McsResourceGroupPort;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class McsResourceGroupPortDao {

  private static final String SQL_SEL = "SELECT handle,resource_type_bo,resource_bo,resource_id,mcs_state_name,next_resource_bo,bay_bo,updated_time FROM view_mcs_resource_group_resource ";

  private final Connection conn;

  public McsResourceGroupPortDao(Connection conn) {
    this.conn = conn;
  }

  public List<McsResourceGroupPort> selectAll() throws SQLException {
    ArrayList<McsResourceGroupPort> result = new ArrayList<McsResourceGroupPort>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<McsResourceGroupPort> selectByOperation(String operationBoVA) throws SQLException {
    ArrayList<McsResourceGroupPort> result = new ArrayList<McsResourceGroupPort>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where handle = ? ")) {
      ps.setString(1, operationBoVA);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  private McsResourceGroupPort convert(ResultSet rs) throws SQLException {
    McsResourceGroupPort data = new McsResourceGroupPort();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setResourceTypeBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setResourceId(rs.getString(index++));
    data.setMcsStateName(rs.getString(index++));
    data.setNextResourceBo(rs.getString(index++));
    data.setBayBo(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
