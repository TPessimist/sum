package ame.me.db.dao;

import ame.me.db.NcCode;
import ame.me.db.NcCodeGrade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NcCodeDao {

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,nc_code,description,status_bo,created_date_time,modified_date_time,nc_category,dpmo_category_bo FROM nc_code ";

  private static final String SQL_SEL_NC_LEVEL = "SELECT handle,change_stamp,site,nc_code,description,status_bo,created_date_time,modified_date_time,nc_category,dpmo_category_bo,nc_level FROM view_nc_code_level ";

  private final Connection conn;

  public NcCodeDao(Connection conn) {
    this.conn = conn;
  }

  public List<NcCode> selectAll(String site) throws SQLException {
    ArrayList<NcCode> result = new ArrayList<NcCode>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY handle")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<NcCodeGrade> selectLevelAll(String site) throws SQLException {
    ArrayList<NcCodeGrade> result = new ArrayList<NcCodeGrade>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_NC_LEVEL + "WHERE site=? ORDER BY handle")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertLevel(rs));
      }
      return result;
    }
  }

  public NcCode selectByPK(String handle) throws SQLException {
    NcCode result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public NcCode selectByNc(String handle) throws SQLException {
    NcCode result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE NC_CODE=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private NcCode convert(ResultSet rs) throws SQLException {
    NcCode data = new NcCode();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setNcCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));
    data.setNcCategory(rs.getString(index++));
    data.setDpmoCategoryBo(rs.getString(index++));

    return data;
  }

  private NcCodeGrade convertLevel(ResultSet rs) throws SQLException {
    NcCodeGrade data = new NcCodeGrade();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setNcCode(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));
    data.setNcCategory(rs.getString(index++));
    data.setDpmoCategoryBo(rs.getString(index++));
    data.setNcLevel(rs.getString(index++));

    return data;
  }
}
