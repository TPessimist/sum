package ame.psb.db.dao;

import ame.psb.db.ViewHoldReason;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class HoldReasonDao {

  private static final String SQL_SEL = "SELECT handle,site,reason_code,description,category,status_bo,message_type_bo,modified_date_time,created_date_time,group_name,wafer_validation,oa,hold_level,release_level FROM view_hold_reason ";

  private final Connection conn;

  public HoldReasonDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewHoldReason> selectAll(String site) throws SQLException {
    ArrayList<ViewHoldReason> result = new ArrayList<ViewHoldReason>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? ORDER BY reason_code")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewHoldReason selectByPK(String site, String name) throws SQLException {
    ViewHoldReason result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND reason_code=?")) {
      ps.setString(1, site);
      ps.setString(2, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewHoldReason selectByPK(String reasonCodeBo) throws SQLException {
    ViewHoldReason result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE handle=?")) {
      ps.setString(1, reasonCodeBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewHoldReason convert(ResultSet rs) throws SQLException {
    ViewHoldReason data = new ViewHoldReason();

    data.setHandle(rs.getString(1));
    data.setSite(rs.getString(2));
    data.setReasonCode(rs.getString(3));
    data.setDescription(rs.getString(4));
    data.setCategory(rs.getString(5));
    data.setStatusBo(rs.getString(6));
    data.setMessageTypeBo(rs.getString(7));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, 8));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, 9));
    data.setGroupName(rs.getString(10));
    data.setWaferValidation(rs.getString(11));
    data.setOa(rs.getString(12));
    data.setHoldLevel(rs.getString(13));
    data.setReleaseLevel(rs.getString(14));

    return data;
  }
}