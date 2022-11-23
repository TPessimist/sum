package ame.psb.db.dao;

import ame.psb.db.PmsSparePartsParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PmsSparePartsParameterDao {

  private static final String SQL_INS = "INSERT INTO z_pms_spareparts_parameter(resrce,spare_part,validity,description) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_spareparts_parameter SET validity=?,description=? WHERE resrce=? AND spare_part=?";

  private static final String SQL_SEL = "SELECT resrce,spare_part,validity,description FROM z_pms_spareparts_parameter ";

  private final Connection conn;

  public PmsSparePartsParameterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsSparePartsParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResrce());
      ps.setString(2, data.getSparePart());
      ps.setString(3, data.getValidity());
      ps.setString(4, data.getDescription());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsSparePartsParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsSparePartsParameter data : dataList) {
        ps.setString(1, data.getResrce());
        ps.setString(2, data.getSparePart());
        ps.setString(3, data.getValidity());
        ps.setString(4, data.getDescription());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsSparePartsParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getValidity());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getResrce());
      ps.setString(4, data.getSparePart());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsSparePartsParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsSparePartsParameter data : dataList) {
        ps.setString(1, data.getValidity());
        ps.setString(2, data.getDescription());
        ps.setString(3, data.getResrce());
        ps.setString(4, data.getSparePart());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resrce, String sparePart) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM z_pms_spareparts_parameter WHERE resrce=? AND spare_part=?")) {
      ps.setString(1, resrce);
      ps.setString(2, sparePart);

      return ps.executeUpdate();
    }
  }

  public int delete(String resrce) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_spareparts_parameter WHERE resrce=?")) {
      ps.setString(1, resrce);

      return ps.executeUpdate();
    }
  }

  public List<PmsSparePartsParameter> selectAll() throws SQLException {
    ArrayList<PmsSparePartsParameter> result = new ArrayList<PmsSparePartsParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PmsSparePartsParameter> selectByResource(String resourceName) throws SQLException {
    ArrayList<PmsSparePartsParameter> result = new ArrayList<PmsSparePartsParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resrce=?")) {
      ps.setString(1, resourceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PmsSparePartsParameter> selectBySparePart(String sparePart) throws SQLException {
    ArrayList<PmsSparePartsParameter> result = new ArrayList<PmsSparePartsParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE spare_part=?")) {
      ps.setString(1, sparePart);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PmsSparePartsParameter selectByPK(String resrce, String sparePart) throws SQLException {
    PmsSparePartsParameter result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resrce=? AND spare_part=?")) {
      ps.setString(1, resrce);
      ps.setString(2, sparePart);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PmsSparePartsParameter convert(ResultSet rs) throws SQLException {
    PmsSparePartsParameter data = new PmsSparePartsParameter();

    int index = 1;
    data.setResrce(rs.getString(index++));
    data.setSparePart(rs.getString(index++));
    data.setValidity(rs.getString(index++));
    data.setDescription(rs.getString(index++));

    return data;
  }
}