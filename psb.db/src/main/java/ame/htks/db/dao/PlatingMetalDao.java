package ame.htks.db.dao;

import ame.htks.db.PlatingMetal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uia.utils.dao.DateUtils;

public class PlatingMetalDao {

  private static final String SQL_INS =
      "INSERT INTO ZH_PLATING_METAL_DEFINE(RESOURCE_BO,METAL1_BO,METAL2_BO,A1_LIMIT_AH,A1_CURRENT_AH,B1_LIMIT_AH,B1_CURRENT_AH,A2_LIMIT_AH,A2_CURRENT_AH,B2_LIMIT_AH,B2_CURRENT_AH,UPDATE_TIME,UPDATE_USER,A1_NAFION_AH,A1_NAFION_INSTALL,B1_NAFION_AH,B1_NAFION_INSTALL,A2_NAFION_AH,A2_NAFION_INSTALL,B2_NAFION_AH,B2_NAFION_INSTALL) "
          + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE ZH_PLATING_METAL_DEFINE SET METAL1_BO=?,METAL2_BO=?,A1_LIMIT_AH=?,A1_CURRENT_AH=?,B1_LIMIT_AH=?,B1_CURRENT_AH=?,A2_LIMIT_AH=?,A2_CURRENT_AH=?,B2_LIMIT_AH=?,B2_CURRENT_AH=?,UPDATE_TIME=?,UPDATE_USER=?,A1_NAFION_AH=?,A1_NAFION_INSTALL=?,B1_NAFION_AH=?,B1_NAFION_INSTALL=?,A2_NAFION_AH=?,A2_NAFION_INSTALL=?,B2_NAFION_AH=?,B2_NAFION_INSTALL=? WHERE RESOURCE_BO=?";

  private static final String SQL_SEL = "SELECT RESOURCE_BO,METAL1_BO,METAL2_BO,A1_LIMIT_AH,A1_CURRENT_AH,B1_LIMIT_AH,B1_CURRENT_AH,A2_LIMIT_AH,A2_CURRENT_AH,B2_LIMIT_AH,B2_CURRENT_AH,UPDATE_TIME,UPDATE_USER,A1_NAFION_AH,A1_NAFION_INSTALL,B1_NAFION_AH,B1_NAFION_INSTALL,A2_NAFION_AH,A2_NAFION_INSTALL,B2_NAFION_AH,B2_NAFION_INSTALL FROM ZH_PLATING_METAL_DEFINE ";

  private final Connection conn;

  public PlatingMetalDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PlatingMetal data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getMetal1());
      ps.setString(3, data.getMetal2());

      ps.setBigDecimal(4, data.getA1LimitAh());
      ps.setBigDecimal(5, data.getA1CurrentAh());
      ps.setBigDecimal(6, data.getB1LimitAh());
      ps.setBigDecimal(7, data.getB1CurrentAh());

      ps.setBigDecimal(8, data.getA2LimitAh());
      ps.setBigDecimal(9, data.getA2CurrentAh());
      ps.setBigDecimal(10, data.getB2LimitAh());
      ps.setBigDecimal(11, data.getB2CurrentAh());

      DateUtils.setDate(ps, 12, data.getUpdateTime());
      ps.setString(13, data.getUpdateUser());

      ps.setBigDecimal(14, data.getA1NafionAh());
      DateUtils.setDate(ps, 15, data.getA1NafionInstall());
      ps.setBigDecimal(16, data.getB1NafionAh());
      DateUtils.setDate(ps, 17, data.getB1NafionInstall());
      ps.setBigDecimal(18, data.getA2NafionAh());
      DateUtils.setDate(ps, 19, data.getA2NafionInstall());
      ps.setBigDecimal(20, data.getB2NafionAh());
      DateUtils.setDate(ps, 21, data.getB2NafionInstall());
      return ps.executeUpdate();
    }
  }

  public int update(PlatingMetal data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {

      ps.setString(1, data.getMetal1());
      ps.setString(2, data.getMetal2());
      ps.setBigDecimal(3, data.getA1LimitAh());
      ps.setBigDecimal(4, data.getA1CurrentAh());
      ps.setBigDecimal(5, data.getB1LimitAh());
      ps.setBigDecimal(6, data.getB1CurrentAh());
      ps.setBigDecimal(7, data.getA2LimitAh());
      ps.setBigDecimal(8, data.getA2CurrentAh());
      ps.setBigDecimal(9, data.getB2LimitAh());
      ps.setBigDecimal(10, data.getB2CurrentAh());
      //ps.setTimestamp(11, new Timestamp(data.getUpdateTime().getTime()));
      DateUtils.setDate(ps, 11, data.getUpdateTime());
      ps.setString(12, data.getUpdateUser());
      ps.setBigDecimal(13, data.getA1NafionAh());
      DateUtils.setDate(ps, 14, data.getA1NafionInstall());
      ps.setBigDecimal(15, data.getB1NafionAh());
      DateUtils.setDate(ps, 16, data.getB1NafionInstall());
      ps.setBigDecimal(17, data.getA2NafionAh());
      DateUtils.setDate(ps, 18, data.getA2NafionInstall());
      ps.setBigDecimal(19, data.getB2NafionAh());
      DateUtils.setDate(ps, 20, data.getB2NafionInstall());
      ps.setString(21, data.getResourceBo());
      return ps.executeUpdate();
    }
  }

  public int delete(String resourceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM ZH_PLATING_METAL_DEFINE WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      return ps.executeUpdate();
    }
  }


  public PlatingMetal selectByPK(String resourceBo) throws SQLException {
    PlatingMetal result = new PlatingMetal();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=?")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PlatingMetal convert(ResultSet rs) throws SQLException {
    PlatingMetal data = new PlatingMetal();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setMetal1(rs.getString(index++));
    data.setMetal2(rs.getString(index++));
    data.setA1LimitAh(rs.getBigDecimal(index++));
    data.setA1CurrentAh(rs.getBigDecimal(index++));
    data.setB1LimitAh(rs.getBigDecimal(index++));
    data.setB1CurrentAh(rs.getBigDecimal(index++));
    data.setA2LimitAh(rs.getBigDecimal(index++));
    data.setA2CurrentAh(rs.getBigDecimal(index++));
    data.setB2LimitAh(rs.getBigDecimal(index++));
    data.setB2CurrentAh(rs.getBigDecimal(index++));

    data.setUpdateTime(rs.getTimestamp(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setA1NafionAh(rs.getBigDecimal(index++));
    data.setA1NafionInstall(rs.getTimestamp(index++));
    data.setB1NafionAh(rs.getBigDecimal(index++));
    data.setB1NafionInstall(rs.getTimestamp(index++));
    data.setA2NafionAh(rs.getBigDecimal(index++));
    data.setA2NafionInstall(rs.getTimestamp(index++));
    data.setB2NafionAh(rs.getBigDecimal(index++));
    data.setB2NafionInstall(rs.getTimestamp(index++));
    return data;
  }
}
