package ame.psb.db.dao;

import ame.psb.db.PmsTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PmsTestDao {

  private static final String SQL_INS = "INSERT INTO z_pms_checklist_parameter(handle,site,checklist_bo,seq,enabled,parameter_name,parameter_desc,parameter_type,default_value,parameter_unit,value_required,control_top_limit,control_lower_limit,warn_top_limit,warn_lower_limit,piclink) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_checklist_parameter SET site=?,checklist_bo=?,seq=?,enabled=?,parameter_name=?,parameter_desc=?,parameter_type=?,default_value=?,parameter_unit=?,value_required=?,control_top_limit=?,control_lower_limit=?,warn_top_limit=?,warn_lower_limit=?,piclink=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,checklist_bo,seq,enabled,parameter_name,parameter_desc,parameter_type,default_value,parameter_unit,value_required,control_top_limit,control_lower_limit,warn_top_limit,warn_lower_limit,piclink FROM z_pms_checklist_parameter ";

  private final Connection conn;

  public PmsTestDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsTest data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getChecklistBo());
      ps.setString(4, data.getSeq());
      ps.setString(5, data.getEnabled());
      ps.setString(6, data.getParameterName());
      ps.setString(7, data.getParameterDesc());
      ps.setString(8, data.getParameterType());
      ps.setString(9, data.getDefaultValue());
      ps.setString(10, data.getParameterUnit());
      ps.setString(11, data.getValueRequired());
      ps.setString(12, data.getControlTopLimit());
      ps.setString(13, data.getControlLowerLimit());
      ps.setString(14, data.getWarnTopLimit());
      ps.setString(15, data.getWarnLowerLimit());
      ps.setString(16, data.getPiclink());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsTest> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsTest data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getChecklistBo());
        ps.setString(4, data.getSeq());
        ps.setString(5, data.getEnabled());
        ps.setString(6, data.getParameterName());
        ps.setString(7, data.getParameterDesc());
        ps.setString(8, data.getParameterType());
        ps.setString(9, data.getDefaultValue());
        ps.setString(10, data.getParameterUnit());
        ps.setString(11, data.getValueRequired());
        ps.setString(12, data.getControlTopLimit());
        ps.setString(13, data.getControlLowerLimit());
        ps.setString(14, data.getWarnTopLimit());
        ps.setString(15, data.getWarnLowerLimit());
        ps.setString(16, data.getPiclink());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsTest data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getChecklistBo());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getEnabled());
      ps.setString(5, data.getParameterName());
      ps.setString(6, data.getParameterDesc());
      ps.setString(7, data.getParameterType());
      ps.setString(8, data.getDefaultValue());
      ps.setString(9, data.getParameterUnit());
      ps.setString(10, data.getValueRequired());
      ps.setString(11, data.getControlTopLimit());
      ps.setString(12, data.getControlLowerLimit());
      ps.setString(13, data.getWarnTopLimit());
      ps.setString(14, data.getWarnLowerLimit());
      ps.setString(15, data.getPiclink());
      ps.setString(16, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsTest> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsTest data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getChecklistBo());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getEnabled());
        ps.setString(5, data.getParameterName());
        ps.setString(6, data.getParameterDesc());
        ps.setString(7, data.getParameterType());
        ps.setString(8, data.getDefaultValue());
        ps.setString(9, data.getParameterUnit());
        ps.setString(10, data.getValueRequired());
        ps.setString(11, data.getControlTopLimit());
        ps.setString(12, data.getControlLowerLimit());
        ps.setString(13, data.getWarnTopLimit());
        ps.setString(14, data.getWarnLowerLimit());
        ps.setString(15, data.getPiclink());
        ps.setString(16, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_checklist_parameter WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PmsTest> selectAll() throws SQLException {
    ArrayList<PmsTest> result = new ArrayList<PmsTest>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PmsTest> selectByChecklistBo(String checklistBo) throws SQLException {
    ArrayList<PmsTest> result = new ArrayList<PmsTest>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where checklist_bo=?")) {
      ps.setString(1, checklistBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public PmsTest selectByPK(String handle) throws SQLException {
    PmsTest result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private PmsTest convert(ResultSet rs) throws SQLException {
    PmsTest data = new PmsTest();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setChecklistBo(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setEnabled(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setParameterDesc(rs.getString(index++));
    data.setParameterType(rs.getString(index++));
    data.setDefaultValue(rs.getString(index++));
    data.setParameterUnit(rs.getString(index++));
    data.setValueRequired(rs.getString(index++));
    data.setControlTopLimit(rs.getString(index++));
    data.setControlLowerLimit(rs.getString(index++));
    data.setWarnTopLimit(rs.getString(index++));
    data.setWarnLowerLimit(rs.getString(index++));
    data.setPiclink(rs.getString(index++));

    return data;
  }
}
