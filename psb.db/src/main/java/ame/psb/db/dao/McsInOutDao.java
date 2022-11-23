package ame.psb.db.dao;

import ame.psb.db.McsInOut;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class McsInOutDao {

  private static final String SQL_SEL = "SELECT resource_bo,next_resource_bo,bay_bo,comment,updated_time,updated_user,restype,in_out FROM view_mcs_in_out ";

  private final Connection conn;

  public McsInOutDao(Connection conn) {
    this.conn = conn;
  }

  public List<McsInOut> selectAll() throws SQLException {
    ArrayList<McsInOut> result = new ArrayList<McsInOut>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<McsInOut> selectByLoadPort(String loadPortBo) throws SQLException {
    ArrayList<McsInOut> result = new ArrayList<McsInOut>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where resource_bo=? ")) {
      ps.setString(1, loadPortBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public McsInOut selectDummyOutByBay(String bayBo) throws SQLException {
    McsInOut result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where restype='DMLP' and in_out='O' and bay_bo=? ")) {
      ps.setString(1, bayBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private McsInOut convert(ResultSet rs) throws SQLException {
    McsInOut data = new McsInOut();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setNextResourceBo(rs.getString(index++));
    data.setBayBo(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setRestype(rs.getString(index++));
    data.setInOut(rs.getString(index++));

    return data;
  }
}
