package ame.psb.db.dao;

import ame.psb.db.RunPmsJobParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RunPmsJobParameterDao {

  private static final String SQL_INS = "INSERT INTO zr_pms_job_parameter(handle,job_bo,seq,result,result_file,parameter_name,parameter_type,parameter_range,default_value,parameter_unit,value_required,file_required,scan_barcode_only,custom_config,control_top_limit,control_lower_limit,warn_top_limit,warn_lower_limit,guide_file) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pms_job_parameter SET job_bo=?,seq=?,result=?,result_file=?,parameter_name=?,parameter_type=?,parameter_range=?,default_value=?,parameter_unit=?,value_required=?,file_required=?,scan_barcode_only=?,custom_config=?,control_top_limit=?,control_lower_limit=?,warn_top_limit=?,warn_lower_limit=?,guide_file=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,job_bo,seq,result,result_file,parameter_name,parameter_type,parameter_range,default_value,parameter_unit,value_required,file_required,scan_barcode_only,custom_config,control_top_limit,control_lower_limit,warn_top_limit,warn_lower_limit,guide_file FROM zr_pms_job_parameter ";

  private static final String SQL_SEL_AUTO_SFC =
      "SELECT PARAMETER_RANGE, B.CHECKLIST, B.RESOURCE_BO, B.JOB_ID FROM\n" +
          "ZR_PMS_JOB_PARAMETER A\n" +
          "INNER JOIN ZR_PMS_JOB B ON A.JOB_BO  = B.JOB_ID \n" +
          "INNER JOIN ZD_PMS_CHECKLIST C ON B.CHECKLIST =  C.CHECKLIST \n" +
          "WHERE C.CHECK_TYPE = 'AUTO' \n" +
          "AND B.JOB_STATUS <> 'DONE' \n" +
          "AND A.PARAMETER_NAME = '自动SFC' ";

  private final Connection conn;

  public RunPmsJobParameterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunPmsJobParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getJobBo());
      ps.setInt(3, data.getSeq());
      ps.setString(4, data.getResult());
      ps.setString(5, data.getResultFile());
      ps.setString(6, data.getParameterName());
      ps.setString(7, data.getParameterType());
      ps.setString(8, data.getParameterRange());
      ps.setString(9, data.getDefaultValue());
      ps.setString(10, data.getParameterUnit());
      ps.setBoolean(11, data.isValueRequired());
      ps.setBoolean(12, data.isFileRequired());
      ps.setBoolean(13, data.isScanBarcodeOnly());
      ps.setString(14, data.getCustomConfig());
      ps.setString(15, data.getControlTopLimit());
      ps.setString(16, data.getControlLowerLimit());
      ps.setString(17, data.getWarnTopLimit());
      ps.setString(18, data.getWarnLowerLimit());
      ps.setString(19, data.getGuideFile());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunPmsJobParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunPmsJobParameter data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getJobBo());
        ps.setInt(3, data.getSeq());
        ps.setString(4, data.getResult());
        ps.setString(5, data.getResultFile());
        ps.setString(6, data.getParameterName());
        ps.setString(7, data.getParameterType());
        ps.setString(8, data.getParameterRange());
        ps.setString(9, data.getDefaultValue());
        ps.setString(10, data.getParameterUnit());
        ps.setBoolean(11, data.isValueRequired());
        ps.setBoolean(12, data.isFileRequired());
        ps.setBoolean(13, data.isScanBarcodeOnly());
        ps.setString(14, data.getCustomConfig());
        ps.setString(15, data.getControlTopLimit());
        ps.setString(16, data.getControlLowerLimit());
        ps.setString(17, data.getWarnTopLimit());
        ps.setString(18, data.getWarnLowerLimit());
        ps.setString(19, data.getGuideFile());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunPmsJobParameter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getJobBo());
      ps.setInt(2, data.getSeq());
      ps.setString(3, data.getResult());
      ps.setString(4, data.getResultFile());
      ps.setString(5, data.getParameterName());
      ps.setString(6, data.getParameterType());
      ps.setString(7, data.getParameterRange());
      ps.setString(8, data.getDefaultValue());
      ps.setString(9, data.getParameterUnit());
      ps.setBoolean(10, data.isValueRequired());
      ps.setBoolean(11, data.isFileRequired());
      ps.setBoolean(12, data.isScanBarcodeOnly());
      ps.setString(13, data.getCustomConfig());
      ps.setString(14, data.getControlTopLimit());
      ps.setString(15, data.getControlLowerLimit());
      ps.setString(16, data.getWarnTopLimit());
      ps.setString(17, data.getWarnLowerLimit());
      ps.setString(18, data.getGuideFile());
      ps.setString(19, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunPmsJobParameter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunPmsJobParameter data : dataList) {
        ps.setString(1, data.getJobBo());
        ps.setInt(2, data.getSeq());
        ps.setString(3, data.getResult());
        ps.setString(4, data.getResultFile());
        ps.setString(5, data.getParameterName());
        ps.setString(6, data.getParameterType());
        ps.setString(7, data.getParameterRange());
        ps.setString(8, data.getDefaultValue());
        ps.setString(9, data.getParameterUnit());
        ps.setBoolean(10, data.isValueRequired());
        ps.setBoolean(11, data.isFileRequired());
        ps.setBoolean(12, data.isScanBarcodeOnly());
        ps.setString(13, data.getCustomConfig());
        ps.setString(14, data.getControlTopLimit());
        ps.setString(15, data.getControlLowerLimit());
        ps.setString(16, data.getWarnTopLimit());
        ps.setString(17, data.getWarnLowerLimit());
        ps.setString(18, data.getGuideFile());
        ps.setString(19, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pms_job_parameter WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<RunPmsJobParameter> selectAll() throws SQLException {
    ArrayList<RunPmsJobParameter> result = new ArrayList<RunPmsJobParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<RunPmsJobParameter> selectByJobId(String jobId) throws SQLException {
    ArrayList<RunPmsJobParameter> result = new ArrayList<RunPmsJobParameter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where job_bo = ?")) {
      ps.setString(1, jobId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

/*    public Map<String, String> selectAutoJobs() throws SQLException {
        Map<String, String> result = new HashMap<>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_AUTO_SFC)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.put(rs.getString(1), rs.getString(2));
            }
            return result;
        }
    }*/

  public List<PmsAutoJob> selectAutoJobs() throws SQLException {
    List<PmsAutoJob> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_AUTO_SFC)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        PmsAutoJob job = new PmsAutoJob();
        job.sfcName = rs.getString(1);
        job.checklist = rs.getString(2);
        job.resourceBo = rs.getString(3);
        job.jobId = rs.getString(4);
        result.add(job);
      }
      return result;
    }
  }


  public RunPmsJobParameter selectByPK(String handle) throws SQLException {
    RunPmsJobParameter result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private RunPmsJobParameter convert(ResultSet rs) throws SQLException {
    RunPmsJobParameter data = new RunPmsJobParameter();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setJobBo(rs.getString(index++));
    data.setSeq(rs.getInt(index++));
    data.setResult(rs.getString(index++));
    data.setResultFile(rs.getString(index++));
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

  public static class PmsAutoJob {

    public String sfcName;

    public String jobId;

    public String resourceBo;

    public String checklist;
  }
}
