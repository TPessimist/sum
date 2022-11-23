package ame.htks.db.dao;

import ame.htks.db.PlatingMetal2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PlatingMetal2Dao {

  private static final String SQL_INS =
      "INSERT INTO ZH_PLATING_METAL_DEFINE2(RESOURCE_BO,METAL,A_LIMIT_AH,A_CURRENT_AH,A_NAFION_AH,A_NAFION_INSTALL,B_LIMIT_AH,B_CURRENT_AH,B_NAFION_AH,B_NAFION_INSTALL,UPDATE_TIME,UPDATE_USER) "
          + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT RESOURCE_BO,METAL,A_LIMIT_AH,A_CURRENT_AH,A_NAFION_AH,A_NAFION_INSTALL,B_LIMIT_AH,B_CURRENT_AH,B_NAFION_AH,B_NAFION_INSTALL,UPDATE_TIME,UPDATE_USER FROM ZH_PLATING_METAL_DEFINE2 ";

  private static final String SQL_UPD = "UPDATE ZH_PLATING_METAL_DEFINE2 SET A_CURRENT_AH=?, B_CURRENT_AH=? WHERE RESOURCE_BO=? AND METAL=?";
  private final Connection conn;

  public PlatingMetal2Dao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlatingMetal2 data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getMetal());

      ps.setBigDecimal(3, data.getaLimitAh());
      ps.setBigDecimal(4, data.getaCurrentAh());
      ps.setBigDecimal(5, data.getaNafionAh());
      DateUtils.setDate(ps, 6, data.getaNafionInstall());

      ps.setBigDecimal(7, data.getbLimitAh());
      ps.setBigDecimal(8, data.getbCurrentAh());
      ps.setBigDecimal(9, data.getbNafionAh());
      DateUtils.setDate(ps, 10, data.getbNafionInstall());

      DateUtils.setDate(ps, 11, data.getUpdateTime());
      ps.setString(12, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PlatingMetal2> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PlatingMetal2 data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getMetal());

        ps.setBigDecimal(3, data.getaLimitAh());
        ps.setBigDecimal(4, data.getaCurrentAh());
        ps.setBigDecimal(5, data.getaNafionAh());
        DateUtils.setDate(ps, 6, data.getaNafionInstall());

        ps.setBigDecimal(7, data.getbLimitAh());
        ps.setBigDecimal(8, data.getbCurrentAh());
        ps.setBigDecimal(9, data.getbNafionAh());
        DateUtils.setDate(ps, 10, data.getbNafionInstall());

        DateUtils.setDate(ps, 11, data.getUpdateTime());
        ps.setString(12, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PlatingMetal2 data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getaCurrentAh());
      ps.setBigDecimal(2, data.getbCurrentAh());
      ps.setString(3, data.getResourceBo());
      ps.setString(4, data.getMetal());
      return ps.executeUpdate();
    }
  }

  public int delete(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZH_PLATING_METAL_DEFINE2 WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }

  public ArrayList<PlatingMetal2> selectByResource(String resourceBo) throws SQLException {
    ArrayList<PlatingMetal2> result = new ArrayList<PlatingMetal2>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where resource_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;

    }

  }

  private PlatingMetal2 convert(ResultSet rs) throws SQLException {
    PlatingMetal2 data = new PlatingMetal2();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setMetal(rs.getString(index++));
    data.setaLimitAh(rs.getBigDecimal(index++));
    data.setaCurrentAh(rs.getBigDecimal(index++));
    data.setaNafionAh(rs.getBigDecimal(index++));
    data.setaNafionInstall(rs.getTimestamp(index++));
    data.setbLimitAh(rs.getBigDecimal(index++));
    data.setbCurrentAh(rs.getBigDecimal(index++));
    data.setbNafionAh(rs.getBigDecimal(index++));
    data.setbNafionInstall(rs.getTimestamp(index++));
    data.setUpdateTime(rs.getTimestamp(index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }

}
