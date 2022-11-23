package ame.psb.db.dao;

import ame.psb.db.PmsJobCheckListParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PmsJobCheckListParameterDao {

  private static final String SQL_INS = "INSERT INTO z_pms_job_checklist_parameter(handle,site,job_bo,job_resource_bo,seq,parameter_name,parameter_desc,parameter_type,default_value,parameter_unit,value_required) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE z_pms_job_checklist_parameter SET site=?,job_bo=?,job_resource_bo=?,seq=?,parameter_name=?,parameter_desc=?,parameter_type=?,default_value=?,parameter_unit=?,value_required=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,job_bo,job_resource_bo,seq,parameter_name,parameter_desc,parameter_type,default_value,parameter_unit,value_required FROM z_pms_job_checklist_parameter ";

  private final Connection conn;

  public PmsJobCheckListParameterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PmsJobCheckListParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getJobBo());
      ps.setString(4, data.getJobResourceBo());
      ps.setString(5, data.getSeq());
      ps.setString(6, data.getParameterName());
      ps.setString(7, data.getParameterDesc());
      ps.setString(8, data.getParameterType());
      ps.setString(9, data.getDefaultValue());
      ps.setString(10, data.getParameterUnit());
      ps.setString(11, data.getValueRequired());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PmsJobCheckListParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PmsJobCheckListParameter data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getJobBo());
        ps.setString(4, data.getJobResourceBo());
        ps.setString(5, data.getSeq());
        ps.setString(6, data.getParameterName());
        ps.setString(7, data.getParameterDesc());
        ps.setString(8, data.getParameterType());
        ps.setString(9, data.getDefaultValue());
        ps.setString(10, data.getParameterUnit());
        ps.setString(11, data.getValueRequired());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PmsJobCheckListParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getJobBo());
      ps.setString(3, data.getJobResourceBo());
      ps.setString(4, data.getSeq());
      ps.setString(5, data.getParameterName());
      ps.setString(6, data.getParameterDesc());
      ps.setString(7, data.getParameterType());
      ps.setString(8, data.getDefaultValue());
      ps.setString(9, data.getParameterUnit());
      ps.setString(10, data.getValueRequired());
      ps.setString(11, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<PmsJobCheckListParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PmsJobCheckListParameter data : dataList) {
        ps.setString(1, data.getSite());
        ps.setString(2, data.getJobBo());
        ps.setString(3, data.getJobResourceBo());
        ps.setString(4, data.getSeq());
        ps.setString(5, data.getParameterName());
        ps.setString(6, data.getParameterDesc());
        ps.setString(7, data.getParameterType());
        ps.setString(8, data.getDefaultValue());
        ps.setString(9, data.getParameterUnit());
        ps.setString(10, data.getValueRequired());
        ps.setString(11, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM z_pms_job_checklist_parameter WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<PmsJobCheckListParameter> selectAll() throws SQLException {
    ArrayList<PmsJobCheckListParameter> result = new ArrayList<PmsJobCheckListParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PmsJobCheckListParameter selectByPK(String handle) throws SQLException {
    PmsJobCheckListParameter result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PmsJobCheckListParameter selectForPad(String jobBo, String jobResourceBo, String seq)
      throws SQLException {
    PmsJobCheckListParameter result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE job_bo = ? AND  job_resource_bo = ? AND seq =  ? ")) {
      ps.setString(1, jobBo);
      ps.setString(2, jobResourceBo);
      ps.setString(3, seq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PmsJobCheckListParameter convert(ResultSet rs) throws SQLException {
    PmsJobCheckListParameter data = new PmsJobCheckListParameter();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setJobBo(rs.getString(index++));
    data.setJobResourceBo(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setParameterName(rs.getString(index++));
    data.setParameterDesc(rs.getString(index++));
    data.setParameterType(rs.getString(index++));
    data.setDefaultValue(rs.getString(index++));
    data.setParameterUnit(rs.getString(index++));
    data.setValueRequired(rs.getString(index++));

    return data;
  }
}

