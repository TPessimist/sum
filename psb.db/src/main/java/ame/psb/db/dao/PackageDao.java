package ame.psb.db.dao;

import ame.psb.db.ViewPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PackageDao {

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,item_group,description,router_bo,bom_bo,mask_group_bo,created_date_time,modified_date_time FROM view_package ";

  private final Connection conn;

  public PackageDao(Connection conn) {
    this.conn = conn;
  }

  public ViewPackage selectByPK(String id) throws SQLException {
    ViewPackage result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewPackage selectByName(String site, String name) throws SQLException {
    ViewPackage result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND item_group=?")) {
      ps.setString(1, site);
      ps.setString(2, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewPackage> selectAll(String site) throws SQLException {
    ArrayList<ViewPackage> result = new ArrayList<ViewPackage>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY item_group")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPackage> selectByNamePrefix(String site, String name) throws SQLException {
    ArrayList<ViewPackage> result = new ArrayList<ViewPackage>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND item_group like ? ORDER BY item_group")) {
      ps.setString(1, site);
      ps.setString(2, name + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPackage convert(ResultSet rs) throws SQLException {
    ViewPackage data = new ViewPackage();

    data.setHandle(rs.getString(1));
    data.setChangeStamp(rs.getInt(2));
    data.setSite(rs.getString(3));
    data.setItemGroup(rs.getString(4));
    data.setDescription(rs.getString(5));
    data.setRouterBo(rs.getString(6));
    data.setBomBo(rs.getString(7));
    data.setMaskGroupBo(rs.getString(8));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, 9));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, 10));

    return data;
  }
}
