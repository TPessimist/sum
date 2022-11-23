package ame.psb.db.dao;

import ame.psb.db.ZdPmsChecklistParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZdPmsChecklistParameterDao {

  private static final String SQL_INS = "INSERT INTO zd_pms_checklist_parameter(handle,checklist,seq,parameter_name,parameter_type,parameter_range,default_value,parameter_unit,value_required,file_required,scan_barcode_only,custom_config,control_top_limit,control_lower_limit,warn_top_limit,warn_lower_limit,guide_file) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pms_checklist_parameter SET checklist=?,seq=?,parameter_name=?,parameter_type=?,parameter_range=?,default_value=?,parameter_unit=?,value_required=?,file_required=?,scan_barcode_only=?,custom_config=?,control_top_limit=?,control_lower_limit=?,warn_top_limit=?,warn_lower_limit=?,guide_file=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,checklist,seq,parameter_name,parameter_type,parameter_range,default_value,parameter_unit,value_required,file_required,scan_barcode_only,custom_config,control_top_limit,control_lower_limit,warn_top_limit,warn_lower_limit,guide_file FROM zd_pms_checklist_parameter ";

  private final Connection conn;

  public ZdPmsChecklistParameterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdPmsChecklistParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getChecklist());
      ps.setInt(3, data.getSeq());
      ps.setString(4, data.getParameterName());
      ps.setString(5, data.getParameterType());
      ps.setString(6, data.getParameterRange());
      ps.setString(7, data.getDefaultValue());
      ps.setString(8, data.getParameterUnit());
      ps.setBoolean(9, data.isValueRequired());
      ps.setBoolean(10, data.isFileRequired());
      ps.setBoolean(11, data.isScanBarcodeOnly());
      ps.setString(12, data.getCustomConfig());
      ps.setString(13, data.getControlTopLimit());
      ps.setString(14, data.getControlLowerLimit());
      ps.setString(15, data.getWarnTopLimit());
      ps.setString(16, data.getWarnLowerLimit());
      ps.setString(17, data.getGuideFile());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdPmsChecklistParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdPmsChecklistParameter data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getChecklist());
        ps.setInt(3, data.getSeq());
        ps.setString(4, data.getParameterName());
        ps.setString(5, data.getParameterType());
        ps.setString(6, data.getParameterRange());
        ps.setString(7, data.getDefaultValue());
        ps.setString(8, data.getParameterUnit());
        ps.setBoolean(9, data.isValueRequired());
        ps.setBoolean(10, data.isFileRequired());
        ps.setBoolean(11, data.isScanBarcodeOnly());
        ps.setString(12, data.getCustomConfig());
        ps.setString(13, data.getControlTopLimit());
        ps.setString(14, data.getControlLowerLimit());
        ps.setString(15, data.getWarnTopLimit());
        ps.setString(16, data.getWarnLowerLimit());
        ps.setString(17, data.getGuideFile());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdPmsChecklistParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getChecklist());
      ps.setInt(2, data.getSeq());
      ps.setString(3, data.getParameterName());
      ps.setString(4, data.getParameterType());
      ps.setString(5, data.getParameterRange());
      ps.setString(6, data.getDefaultValue());
      ps.setString(7, data.getParameterUnit());
      ps.setBoolean(8, data.isValueRequired());
      ps.setBoolean(9, data.isFileRequired());
      ps.setBoolean(10, data.isScanBarcodeOnly());
      ps.setString(11, data.getCustomConfig());
      ps.setString(12, data.getControlTopLimit());
      ps.setString(13, data.getControlLowerLimit());
      ps.setString(14, data.getWarnTopLimit());
      ps.setString(15, data.getWarnLowerLimit());
      ps.setString(16, data.getGuideFile());
      ps.setString(17, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdPmsChecklistParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdPmsChecklistParameter data : dataList) {
        ps.setString(1, data.getChecklist());
        ps.setInt(2, data.getSeq());
        ps.setString(3, data.getParameterName());
        ps.setString(4, data.getParameterType());
        ps.setString(5, data.getParameterRange());
        ps.setString(6, data.getDefaultValue());
        ps.setString(7, data.getParameterUnit());
        ps.setBoolean(8, data.isValueRequired());
        ps.setBoolean(9, data.isFileRequired());
        ps.setBoolean(10, data.isScanBarcodeOnly());
        ps.setString(11, data.getCustomConfig());
        ps.setString(12, data.getControlTopLimit());
        ps.setString(13, data.getControlLowerLimit());
        ps.setString(14, data.getWarnTopLimit());
        ps.setString(15, data.getWarnLowerLimit());
        ps.setString(16, data.getGuideFile());
        ps.setString(17, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pms_checklist_parameter WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  @Deprecated
  public List<ZdPmsChecklistParameter> selectAll() throws SQLException {
    ArrayList<ZdPmsChecklistParameter> result = new ArrayList<ZdPmsChecklistParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ZdPmsChecklistParameter> selectByCheckList(String checklist) throws SQLException {
    ArrayList<ZdPmsChecklistParameter> result = new ArrayList<ZdPmsChecklistParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where checklist=? ")) {
      ps.setString(1, checklist);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ZdPmsChecklistParameter selectByPK(String handle) throws SQLException {
    ZdPmsChecklistParameter result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ZdPmsChecklistParameter convert(ResultSet rs) throws SQLException {
    ZdPmsChecklistParameter data = new ZdPmsChecklistParameter();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChecklist(rs.getString(index++));
    data.setSeq(rs.getInt(index++));
    data.setParameterName(rs.getString(index++));
    data.setParameterType(rs.getString(index++));
    data.setParameterRange(rs.getString(index++));
    data.setDefaultValue(rs.getString(index++));
    data.setParameterUnit(rs.getString(index++));
    data.setValueRequired(rs.getBoolean(index++));
    data.setFileRequired(rs.getBoolean(index++));
    data.setScanBarcodeOnly(rs.getBoolean(index++));
    data.setCustomConfig(rs.getString(index++));
    data.setControlTopLimit(rs.getString(index++));
    data.setControlLowerLimit(rs.getString(index++));
    data.setWarnTopLimit(rs.getString(index++));
    data.setWarnLowerLimit(rs.getString(index++));
    data.setGuideFile(rs.getString(index++));

    return data;
  }
}
