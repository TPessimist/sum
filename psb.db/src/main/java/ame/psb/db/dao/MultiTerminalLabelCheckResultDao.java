package ame.psb.db.dao;

import ame.psb.db.MultiTerminalLabelCheckResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class MultiTerminalLabelCheckResultDao {

  private static final String SQL_INS = "INSERT INTO zd_multi_terminal_label_check_result(uuid,compare_container_bo,container_bo,container_name,container_type,qr_code,label_bo,tag_bo,tag_value,state_name,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_multi_terminal_label_check_result SET compare_container_bo=?,container_bo=?,container_name=?,container_type=?,qr_code=?,label_bo=?,tag_bo=?,tag_value=?,state_name=?,reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,compare_container_bo,container_bo,container_name,container_type,qr_code,label_bo,tag_bo,tag_value,state_name,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_multi_terminal_label_check_result ";

  private final Connection conn;

  public MultiTerminalLabelCheckResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(MultiTerminalLabelCheckResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getCompareContainerBo());
      ps.setString(3, data.getContainerBo());
      ps.setString(4, data.getContainerName());
      ps.setString(5, data.getContainerType());
      ps.setString(6, data.getQrCode());
      ps.setString(7, data.getLabelBo());
      ps.setString(8, data.getTagBo());
      ps.setString(9, data.getTagValue());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getReserveField1());
      ps.setString(12, data.getReserveField2());
      ps.setString(13, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<MultiTerminalLabelCheckResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (MultiTerminalLabelCheckResult data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getCompareContainerBo());
        ps.setString(3, data.getContainerBo());
        ps.setString(4, data.getContainerName());
        ps.setString(5, data.getContainerType());
        ps.setString(6, data.getQrCode());
        ps.setString(7, data.getLabelBo());
        ps.setString(8, data.getTagBo());
        ps.setString(9, data.getTagValue());
        ps.setString(10, data.getStateName());
        ps.setString(11, data.getReserveField1());
        ps.setString(12, data.getReserveField2());
        ps.setString(13, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 14, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(MultiTerminalLabelCheckResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCompareContainerBo());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getContainerName());
      ps.setString(4, data.getContainerType());
      ps.setString(5, data.getQrCode());
      ps.setString(6, data.getLabelBo());
      ps.setString(7, data.getTagBo());
      ps.setString(8, data.getTagValue());
      ps.setString(9, data.getStateName());
      ps.setString(10, data.getReserveField1());
      ps.setString(11, data.getReserveField2());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      ps.setString(14, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<MultiTerminalLabelCheckResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (MultiTerminalLabelCheckResult data : dataList) {
        ps.setString(1, data.getCompareContainerBo());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getContainerName());
        ps.setString(4, data.getContainerType());
        ps.setString(5, data.getQrCode());
        ps.setString(6, data.getLabelBo());
        ps.setString(7, data.getTagBo());
        ps.setString(8, data.getTagValue());
        ps.setString(9, data.getStateName());
        ps.setString(10, data.getReserveField1());
        ps.setString(11, data.getReserveField2());
        ps.setString(12, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
        ps.setString(14, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_multi_terminal_label_check_result WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public int deleteByContainer(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zd_multi_terminal_label_check_result WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByOuterContainer(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zd_multi_terminal_label_check_result WHERE compare_container_bo=?")) {
      ps.setString(1, containerBo);

      return ps.executeUpdate();
    }
  }

  public List<MultiTerminalLabelCheckResult> selectAll() throws SQLException {
    ArrayList<MultiTerminalLabelCheckResult> result = new ArrayList<MultiTerminalLabelCheckResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MultiTerminalLabelCheckResult selectByPK(String uuid) throws SQLException {
    MultiTerminalLabelCheckResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckResult> selectByQrCode(String qrCode) throws SQLException {
    ArrayList<MultiTerminalLabelCheckResult> result = new ArrayList<MultiTerminalLabelCheckResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE qr_code=?")) {
      ps.setString(1, qrCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckResult> selectByOuterContainer(String compareContainerBo)
      throws SQLException {
    ArrayList<MultiTerminalLabelCheckResult> result = new ArrayList<MultiTerminalLabelCheckResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE compare_container_bo=? AND STATE_NAME='Y' ")) {
      ps.setString(1, compareContainerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MultiTerminalLabelCheckResult> selectByContainer(String containerBo)
      throws SQLException {
    ArrayList<MultiTerminalLabelCheckResult> result = new ArrayList<MultiTerminalLabelCheckResult>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND STATE_NAME='Y' ")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public MultiTerminalLabelCheckResult selectByTempLabel(String tempContent) throws SQLException {
    MultiTerminalLabelCheckResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE label_bo='TEMP-LABEL' AND tag_bo='TEMP-TAG' AND tag_value=? ")) {
      ps.setString(1, tempContent);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private MultiTerminalLabelCheckResult convert(ResultSet rs) throws SQLException {
    MultiTerminalLabelCheckResult data = new MultiTerminalLabelCheckResult();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setCompareContainerBo(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setQrCode(rs.getString(index++));
    data.setLabelBo(rs.getString(index++));
    data.setTagBo(rs.getString(index++));
    data.setTagValue(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
