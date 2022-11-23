package ame.psb.db.dao;

import ame.psb.db.FutureActionDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FutureActionDefDao {

  private static final String SQL_UPD = "UPDATE zd_future_action_def SET oa=?,oa_handle=?,oa_hold_code=?,oa_hold_comments=?,oa_hold_release=? WHERE action_name=? and config_group=?";

  private static final String SQL_SEL = "SELECT action_name,config_group,oa,oa_handle,oa_hold_code,oa_hold_comments,oa_hold_release FROM zd_future_action_def ";

  private final Connection conn;

  public FutureActionDefDao(Connection conn) {
    this.conn = conn;
  }

  public int update(FutureActionDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOa());
      ps.setString(2, data.getOaHandle());
      ps.setString(3, data.getOaHoldCode());
      ps.setString(4, data.getOaHoldComments());
      ps.setString(5, data.getOaHoldRelease());
      ps.setString(6, data.getActionName());
      ps.setString(7, data.getConfigGroup());

      return ps.executeUpdate();
    }
  }

  public List<FutureActionDef> selectAll() throws SQLException {
    ArrayList<FutureActionDef> result = new ArrayList<FutureActionDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FutureActionDef convert(ResultSet rs) throws SQLException {
    FutureActionDef data = new FutureActionDef();

    data.setActionName(rs.getString(1));
    data.setConfigGroup(rs.getString(2));
    data.setOa(rs.getString(3));
    data.setOaHandle(rs.getString(4));
    data.setOaHoldCode(rs.getString(5));
    data.setOaHoldComments(rs.getString(6));
    data.setOaHoldRelease(rs.getString(7));

    return data;
  }
}
