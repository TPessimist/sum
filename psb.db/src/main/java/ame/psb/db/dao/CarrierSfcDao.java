package ame.psb.db.dao;

import ame.psb.db.CarrierSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CarrierSfcDao {

  private Connection conn;

  public CarrierSfcDao(Connection conn) {
    this.conn = conn;
  }

  public String selectCarrier(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT carrier_bo FROM zd_carrier_sfc WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getString(1);
      } else {
        return null;
      }
    }
  }

  public CarrierSfc selectByPk(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT carrier_bo,sfc_bo,updated_user,updated_time FROM zd_carrier_sfc WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return this.convert(rs);
      } else {
        return null;
      }
    }
  }

  public List<String> selectSfcs(String carrierBo) throws SQLException {
    ArrayList<String> result = new ArrayList<String>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT sfc_bo FROM zd_carrier_sfc WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
    }
    return result;
  }

  public String selectByFoup(String foupId) throws SQLException {

    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT sfc_bo FROM zd_carrier_sfc WHERE carrier_bo like ?")) {
      ps.setString(1, "%" + foupId + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getString(1);
      } else {
        return null;
      }
    }
  }

  public int insert(String carrierBo, String sfcBo, String updatedUser, Date updatedTime)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "INSERT INTO zd_carrier_sfc(carrier_bo,sfc_bo,updated_user,updated_time) VALUES(?,?,?,?)")) {
      ps.setString(1, carrierBo);
      ps.setString(2, sfcBo);
      ps.setString(3, updatedUser);
      DateUtils.setDateTz(ps, 4, updatedTime);
      return ps.executeUpdate();
    }
  }

  public int delete(String carrierBo, String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_sfc WHERE carrier_bo=? AND sfc_bo=?")) {
      ps.setString(1, carrierBo);
      ps.setString(2, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int cleanCarrier(String carrierBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_sfc WHERE carrier_bo=?")) {
      ps.setString(1, carrierBo);
      return ps.executeUpdate();
    }
  }

  public int cleanSfc(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_carrier_sfc WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int update(String sfcBo, String carrierBo, String updatedUser, Date updatedTime)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_carrier_sfc SET carrier_bo=?,updated_user=?,updated_time=? WHERE sfc_bo=?")) {
      ps.setString(1, carrierBo);
      ps.setString(2, updatedUser);
      DateUtils.setDateTz(ps, 3, updatedTime);
      ps.setString(4, sfcBo);
      return ps.executeUpdate();
    }
  }

  public int insertOrUpdate(String sfcBo, String carrierBo, String updatedUser, Date updatedTime)
      throws SQLException {
    if (null == this.selectCarrier(sfcBo)) {
      return this.insert(carrierBo, sfcBo, updatedUser, updatedTime);
    } else {
      return this.update(sfcBo, carrierBo, updatedUser, updatedTime);
    }
  }

  public List<CarrierSfc> selectAll() throws SQLException {
    ArrayList<CarrierSfc> result = new ArrayList<CarrierSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT * FROM zd_carrier_sfc")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public CarrierSfc convert(ResultSet rs) throws SQLException {
    CarrierSfc carrierSfc = new CarrierSfc();
    int i = 1;
    carrierSfc.setCarrierBo(rs.getString(i++));
    carrierSfc.setSfcBo(rs.getString(i++));
    carrierSfc.setUpdatedUser(rs.getString(i++));
    carrierSfc.setUpdatedTime(DateUtils.getDateTz(rs, i++));
    return carrierSfc;
  }


}
