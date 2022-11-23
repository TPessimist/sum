package ame.me.db.dao;

import ame.me.db.ParametricMeasure;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ParametricMeasureDao {

  private static final String SQL_INS = "INSERT INTO parametric_measure(handle,measure_name,measure_group,parametric_bo,sequence,description,component_bo,component_type,pin,measure_status,memo,measure_type,unit_of_meas,data_type,high_limit,low_limit,expected,actual,actual_num,dc_comment,dc_parameter_bo,used_limit_seq,test_date_time,elapsed_time,original_actual,original_dc_comment,original_test_date_time,edited,edited_user_bo,edited_date_time,internal_measure_id,transaction_id,para_context_gbo,first_sequence,override_user_bo,dc_group_revision,erp_sent,is_qm_accepted) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE parametric_measure SET measure_name=?,measure_group=?,parametric_bo=?,sequence=?,description=?,component_bo=?,component_type=?,pin=?,measure_status=?,memo=?,measure_type=?,unit_of_meas=?,data_type=?,high_limit=?,low_limit=?,expected=?,actual=?,actual_num=?,dc_comment=?,dc_parameter_bo=?,used_limit_seq=?,test_date_time=?,elapsed_time=?,original_actual=?,original_dc_comment=?,original_test_date_time=?,edited=?,edited_user_bo=?,edited_date_time=?,internal_measure_id=?,transaction_id=?,para_context_gbo=?,first_sequence=?,override_user_bo=?,dc_group_revision=?,erp_sent=?,is_qm_accepted=? WHERE handle=? ";

  private static final String SQL_SEL = "SELECT handle,measure_name,measure_group,parametric_bo,sequence,description,component_bo,component_type,pin,measure_status,memo,measure_type,unit_of_meas,data_type,high_limit,low_limit,expected,actual,actual_num,dc_comment,dc_parameter_bo,used_limit_seq,test_date_time,elapsed_time,original_actual,original_dc_comment,original_test_date_time,edited,edited_user_bo,edited_date_time,internal_measure_id,transaction_id,para_context_gbo,first_sequence,override_user_bo,dc_group_revision,erp_sent,is_qm_accepted FROM parametric_measure ";

  private static final String SQL_DEL = "DELETE FROM parametric_measure WHERE handle=? ";

  private final Connection conn;

  public ParametricMeasureDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ParametricMeasure data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getMeasureName());
      ps.setString(3, data.getMeasureGroup());
      ps.setString(4, data.getParametricBo());
      ps.setInt(5, data.getSequence());
      ps.setString(6, data.getDescription());
      ps.setString(7, data.getComponentBo());
      ps.setString(8, data.getComponentType());
      ps.setString(9, data.getPin());
      ps.setString(10, data.getMeasureStatus());
      ps.setString(11, data.getMemo());
      ps.setString(12, data.getMeasureType());
      ps.setString(13, data.getUnitOfMeas());
      ps.setString(14, data.getDataType());
      ps.setString(15, data.getHighLimit());
      ps.setString(16, data.getLowLimit());
      ps.setString(17, data.getExpected());
      ps.setString(18, data.getActual());
      if (data.getActualNum() != null) {
        ps.setBigDecimal(19, data.getActualNum());
      } else {
        ps.setNull(19, Types.NUMERIC);
      }
      ;
      ps.setString(20, data.getDcComment());
      ps.setString(21, data.getDcParameterBo());
      ps.setString(22, data.getUsedLimitSeq());
      ps.setTimestamp(23,
          data.getTestDateTime() == null ? null : new Timestamp(data.getTestDateTime().getTime()));
      if (data.getElapsedTime() != null) {
        ps.setInt(24, data.getElapsedTime());
      } else {
        ps.setNull(24, Types.INTEGER);
      }
      ;
      ps.setString(25, data.getOriginalActual());
      ps.setString(26, data.getOriginalDcComment());
      ps.setTimestamp(27, data.getOriginalTestDateTime() == null ? null
          : new Timestamp(data.getOriginalTestDateTime().getTime()));
      ps.setString(28, data.getEdited());
      ps.setString(29, data.getEditedUserBo());
      ps.setTimestamp(30, data.getEditedDateTime() == null ? null
          : new Timestamp(data.getEditedDateTime().getTime()));
      ps.setString(31, data.getInternalMeasureId());
      if (data.getTransactionId() != null) {
        ps.setBigDecimal(32, data.getTransactionId());
      } else {
        ps.setNull(32, Types.NUMERIC);
      }
      ps.setString(33, data.getParaContextGbo());
      if (data.getFirstSequence() != null) {
        ps.setInt(34, data.getFirstSequence());
      } else {
        ps.setNull(34, Types.INTEGER);
      }
      ps.setString(35, data.getOverrideUserBo());
      ps.setString(36, data.getDcGroupRevision());
      ps.setString(37, data.getErpSent());
      ps.setString(38, data.getIsQmAccepted());

      return ps.executeUpdate();
    }
  }

  public int update(ParametricMeasure data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getMeasureName());
      ps.setString(2, data.getMeasureGroup());
      ps.setString(3, data.getParametricBo());
      ps.setInt(4, data.getSequence());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getComponentBo());
      ps.setString(7, data.getComponentType());
      ps.setString(8, data.getPin());
      ps.setString(9, data.getMeasureStatus());
      ps.setString(10, data.getMemo());
      ps.setString(11, data.getMeasureType());
      ps.setString(12, data.getUnitOfMeas());
      ps.setString(13, data.getDataType());
      ps.setString(14, data.getHighLimit());
      ps.setString(15, data.getLowLimit());
      ps.setString(16, data.getExpected());
      ps.setString(17, data.getActual());
      ps.setBigDecimal(18, data.getActualNum());
      ps.setString(19, data.getDcComment());
      ps.setString(20, data.getDcParameterBo());
      ps.setString(21, data.getUsedLimitSeq());
      ps.setTimestamp(22,
          data.getTestDateTime() == null ? null : new Timestamp(data.getTestDateTime().getTime()));
      ps.setInt(23, data.getElapsedTime());
      ps.setString(24, data.getOriginalActual());
      ps.setString(25, data.getOriginalDcComment());
      ps.setTimestamp(26, data.getOriginalTestDateTime() == null ? null
          : new Timestamp(data.getOriginalTestDateTime().getTime()));
      ps.setString(27, data.getEdited());
      ps.setString(28, data.getEditedUserBo());
      ps.setTimestamp(29, data.getEditedDateTime() == null ? null
          : new Timestamp(data.getEditedDateTime().getTime()));
      ps.setString(30, data.getInternalMeasureId());
      ps.setBigDecimal(31, data.getTransactionId());
      ps.setString(32, data.getParaContextGbo());
      ps.setInt(33, data.getFirstSequence());
      ps.setString(34, data.getOverrideUserBo());
      ps.setString(35, data.getDcGroupRevision());
      ps.setString(36, data.getErpSent());
      ps.setString(37, data.getIsQmAccepted());
      ps.setString(38, data.getHandle());
      return ps.executeUpdate();
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_DEL)) {
      ps.setString(1, handle);
      return ps.executeUpdate();
    }
  }

  public ParametricMeasure selectByPk(String handle) throws SQLException {
    ParametricMeasure result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE handle=? ")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }
    return result;
  }

  public List<ParametricMeasure> selectAll() throws SQLException {
    ArrayList<ParametricMeasure> result = new ArrayList<ParametricMeasure>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ParametricMeasure> selectByParametric(String parametricBo) throws SQLException {
    ArrayList<ParametricMeasure> result = new ArrayList<ParametricMeasure>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE parametric_bo=? ")) {
      ps.setString(1, parametricBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  private ParametricMeasure convert(ResultSet rs) throws SQLException {
    ParametricMeasure data = new ParametricMeasure();

    data.setHandle(rs.getString(1));
    data.setMeasureName(rs.getString(2));
    data.setMeasureGroup(rs.getString(3));
    data.setParametricBo(rs.getString(4));
    data.setSequence(rs.getInt(5));
    data.setDescription(rs.getString(6));
    data.setComponentBo(rs.getString(7));
    data.setComponentType(rs.getString(8));
    data.setPin(rs.getString(9));
    data.setMeasureStatus(rs.getString(10));
    data.setMemo(rs.getString(11));
    data.setMeasureType(rs.getString(12));
    data.setUnitOfMeas(rs.getString(13));
    data.setDataType(rs.getString(14));
    data.setHighLimit(rs.getString(15));
    data.setLowLimit(rs.getString(16));
    data.setExpected(rs.getString(17));
    data.setActual(rs.getString(18));
    data.setActualNum(rs.getBigDecimal(19));
    data.setDcComment(rs.getString(20));
    data.setDcParameterBo(rs.getString(21));
    data.setUsedLimitSeq(rs.getString(22));
    data.setTestDateTime(rs.getTimestamp(23));
    data.setElapsedTime(rs.getInt(24));
    data.setOriginalActual(rs.getString(25));
    data.setOriginalDcComment(rs.getString(26));
    data.setOriginalTestDateTime(rs.getTimestamp(27));
    data.setEdited(rs.getString(28));
    data.setEditedUserBo(rs.getString(29));
    data.setEditedDateTime(rs.getTimestamp(30));
    data.setInternalMeasureId(rs.getString(31));
    data.setTransactionId(rs.getBigDecimal(32));
    data.setParaContextGbo(rs.getString(33));
    data.setFirstSequence(rs.getInt(34));
    data.setOverrideUserBo(rs.getString(35));
    data.setDcGroupRevision(rs.getString(36));
    data.setErpSent(rs.getString(37));
    data.setIsQmAccepted(rs.getString(38));

    return data;
  }
}