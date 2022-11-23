package ame.psb.db.dao;

import ame.psb.db.SorterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SorterJobDao {

  private static final String SQL_INS = "INSERT INTO zr_sorter_job(id,resrce,action_name,sfcs,sorter_plan_id,mq_message,result,created_time,complete_time,cdm_message,eap_message,send_message_to_cdm) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sorter_job SET resrce=?,action_name=?,sfcs=?,sorter_plan_id=?,mq_message=?,result=?,created_time=?,complete_time=?,cdm_message=?,eap_message=?,send_message_to_cdm=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resrce,action_name,sfcs,sorter_plan_id,mq_message,result,created_time,complete_time,cdm_message,eap_message,send_message_to_cdm FROM zr_sorter_job ";

  private final Connection conn;

  public SorterJobDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SorterJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResrce());
      ps.setString(3, data.getActionName());
      ps.setString(4, data.getSfcs());
      ps.setString(5, data.getSorterPlanId());
      ps.setString(6, data.getMqMessage());
      ps.setString(7, data.getResult());
      DateUtils.setDateTz(ps, 8, data.getCreatedTime());
      DateUtils.setDateTz(ps, 9, data.getCompleteTime());
      ps.setString(10, data.getCdmMessage());
      ps.setString(11, data.getEapMessage());
      ps.setString(12, data.getSendMessageToCdm());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SorterJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SorterJob data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResrce());
        ps.setString(3, data.getActionName());
        ps.setString(4, data.getSfcs());
        ps.setString(5, data.getSorterPlanId());
        ps.setString(6, data.getMqMessage());
        ps.setString(7, data.getResult());
        DateUtils.setDateTz(ps, 8, data.getCreatedTime());
        DateUtils.setDateTz(ps, 9, data.getCompleteTime());
        ps.setString(10, data.getCdmMessage());
        ps.setString(11, data.getEapMessage());
        ps.setString(12, data.getSendMessageToCdm());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SorterJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResrce());
      ps.setString(2, data.getActionName());
      ps.setString(3, data.getSfcs());
      ps.setString(4, data.getSorterPlanId());
      ps.setString(5, data.getMqMessage());
      ps.setString(6, data.getResult());
      DateUtils.setDateTz(ps, 7, data.getCreatedTime());
      DateUtils.setDateTz(ps, 8, data.getCompleteTime());
      ps.setString(9, data.getCdmMessage());
      ps.setString(10, data.getEapMessage());
      ps.setString(11, data.getSendMessageToCdm());
      ps.setString(12, data.getId());
      return ps.executeUpdate();
    }
  }

  public int update(List<SorterJob> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SorterJob data : dataList) {
        ps.setString(1, data.getResrce());
        ps.setString(2, data.getActionName());
        ps.setString(3, data.getSfcs());
        ps.setString(4, data.getSorterPlanId());
        ps.setString(5, data.getMqMessage());
        ps.setString(6, data.getResult());
        DateUtils.setDateTz(ps, 7, data.getCreatedTime());
        DateUtils.setDateTz(ps, 8, data.getCompleteTime());
        ps.setString(9, data.getCdmMessage());
        ps.setString(10, data.getEapMessage());
        ps.setString(11, data.getSendMessageToCdm());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sorter_job WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SorterJob> selectAll() throws SQLException {
    ArrayList<SorterJob> result = new ArrayList<SorterJob>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public int change(SorterJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_sorter_job SET eap_message=?,send_message_to_cdm=?,complete_time=? WHERE id=?")) {
      ps.setString(1, data.getEapMessage());
      ps.setString(2, data.getSendMessageToCdm());
      DateUtils.setDateTz(ps, 3, data.getCompleteTime());
      ps.setString(4, data.getId());
      return ps.executeUpdate();
    }
  }

  public int updateSorterPlanId(SorterJob data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_sorter_job SET sorter_plan_id=? WHERE id=?")) {
      ps.setString(1, data.getSorterPlanId());
      ps.setString(2, data.getId());

      return ps.executeUpdate();
    }
  }

  /*
   * 根据resrce 查询
   * */
  public List<SorterJob> selectByResrce(String resrce) throws SQLException {
    ArrayList<SorterJob> result = new ArrayList<SorterJob>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE resrce=? order by created_time desc")) {
      ps.setString(1, resrce);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterJob selectByPK(String id) throws SQLException {
    SorterJob result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SorterJob convert(ResultSet rs) throws SQLException {
    SorterJob data = new SorterJob();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResrce(rs.getString(index++));
    data.setActionName(rs.getString(index++));
    data.setSfcs(rs.getString(index++));
    data.setSorterPlanId(rs.getString(index++));
    data.setMqMessage(rs.getString(index++));
    data.setResult(rs.getString(index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setCompleteTime(DateUtils.getDateTz(rs, index++));
    data.setCdmMessage(rs.getString(index++));
    data.setEapMessage(rs.getString(index++));
    data.setSendMessageToCdm(rs.getString(index++));

    return data;
  }
}
