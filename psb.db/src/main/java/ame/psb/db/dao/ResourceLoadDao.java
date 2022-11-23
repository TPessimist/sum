package ame.psb.db.dao;

import ame.psb.db.ResourceLoad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceLoadDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_load(resource_bo,wip_load,mcs_load,mcs_bay_load,load_detail,wip_load_ucl,wip_load_lcl,mcs_load_ucl,mcs_load_lcl,mcs_bay_load_ucl,mcs_bay_load_lcl,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_load SET wip_load=?,mcs_load=?,mcs_bay_load=?,load_detail=?,wip_load_ucl=?,wip_load_lcl=?,mcs_load_ucl=?,mcs_load_lcl=?,mcs_bay_load_ucl=?,mcs_bay_load_lcl=?,updated_user=?,updated_time=? WHERE resource_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,wip_load,mcs_load,mcs_bay_load,load_detail,wip_load_ucl,wip_load_lcl,mcs_load_ucl,mcs_load_lcl,mcs_bay_load_ucl,mcs_bay_load_lcl,updated_user,updated_time FROM zd_resource_load ";

  private final Connection conn;

  public ResourceLoadDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceLoad data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setBigDecimal(2, data.getWipLoad());
      ps.setBigDecimal(3, data.getMcsLoad());
      ps.setBigDecimal(4, data.getMcsBayLoad());
      ps.setString(5, data.getLoadDetail());
      ps.setBigDecimal(6, data.getWipLoadUcl());
      ps.setBigDecimal(7, data.getWipLoadLcl());
      ps.setBigDecimal(8, data.getMcsLoadUcl());
      ps.setBigDecimal(9, data.getMcsLoadLcl());
      ps.setBigDecimal(10, data.getMcsBayLoadUcl());
      ps.setBigDecimal(11, data.getMcsBayLoadLcl());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceLoad> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceLoad data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setBigDecimal(2, data.getWipLoad());
        ps.setBigDecimal(3, data.getMcsLoad());
        ps.setBigDecimal(4, data.getMcsBayLoad());
        ps.setString(5, data.getLoadDetail());
        ps.setBigDecimal(6, data.getWipLoadUcl());
        ps.setBigDecimal(7, data.getWipLoadLcl());
        ps.setBigDecimal(8, data.getMcsLoadUcl());
        ps.setBigDecimal(9, data.getMcsLoadLcl());
        ps.setBigDecimal(10, data.getMcsBayLoadUcl());
        ps.setBigDecimal(11, data.getMcsBayLoadLcl());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceLoad data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getWipLoad());
      ps.setBigDecimal(2, data.getMcsLoad());
      ps.setBigDecimal(3, data.getMcsBayLoad());
      ps.setString(4, data.getLoadDetail());
      ps.setBigDecimal(5, data.getWipLoadUcl());
      ps.setBigDecimal(6, data.getWipLoadLcl());
      ps.setBigDecimal(7, data.getMcsLoadUcl());
      ps.setBigDecimal(8, data.getMcsLoadLcl());
      ps.setBigDecimal(9, data.getMcsBayLoadUcl());
      ps.setBigDecimal(10, data.getMcsBayLoadLcl());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setString(13, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceLoad> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceLoad data : dataList) {
        ps.setBigDecimal(1, data.getWipLoad());
        ps.setBigDecimal(2, data.getMcsLoad());
        ps.setBigDecimal(3, data.getMcsBayLoad());
        ps.setString(4, data.getLoadDetail());
        ps.setBigDecimal(5, data.getWipLoadUcl());
        ps.setBigDecimal(6, data.getWipLoadLcl());
        ps.setBigDecimal(7, data.getMcsLoadUcl());
        ps.setBigDecimal(8, data.getMcsLoadLcl());
        ps.setBigDecimal(9, data.getMcsBayLoadUcl());
        ps.setBigDecimal(10, data.getMcsBayLoadLcl());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setString(13, data.getResourceBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_load WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public List<ResourceLoad> selectAll() throws SQLException {
    ArrayList<ResourceLoad> result = new ArrayList<ResourceLoad>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceLoad> selectByPrefix(String prefix) throws SQLException {
    ArrayList<ResourceLoad> result = new ArrayList<ResourceLoad>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where resource_bo like 'ResourceBO:1020,'||?||'%' ")) {

      ps.setString(1, prefix);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ResourceLoad selectByPK(String resourceBo) throws SQLException {
    ResourceLoad result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ResourceLoad convert(ResultSet rs) throws SQLException {
    ResourceLoad data = new ResourceLoad();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setWipLoad(rs.getBigDecimal(index++));
    data.setMcsLoad(rs.getBigDecimal(index++));
    data.setMcsBayLoad(rs.getBigDecimal(index++));
    data.setLoadDetail(rs.getString(index++));
    data.setWipLoadUcl(rs.getBigDecimal(index++));
    data.setWipLoadLcl(rs.getBigDecimal(index++));
    data.setMcsLoadUcl(rs.getBigDecimal(index++));
    data.setMcsLoadLcl(rs.getBigDecimal(index++));
    data.setMcsBayLoadUcl(rs.getBigDecimal(index++));
    data.setMcsBayLoadLcl(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
