package ame.psb.db.dao;

import ame.psb.db.CancelEapCardControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CancelEapCardControlDao {

  private static final String SQL_INS = "INSERT INTO cancel_eap_card_control(sfc_bo,sfc,operation_bo,reason,other,update_user,update_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE cancel_eap_card_control SET sfc=?,operation_bo=?,reason=?,other=?,update_user=?,update_time=? WHERE sfc_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,sfc,operation_bo,reason,other,update_user,update_time FROM cancel_eap_card_control ";

  private final Connection conn;

  public CancelEapCardControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CancelEapCardControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getReason());
      ps.setString(5, data.getOther());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CancelEapCardControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CancelEapCardControl data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getReason());
        ps.setString(5, data.getOther());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CancelEapCardControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getReason());
      ps.setString(4, data.getOther());
      ps.setString(5, data.getUpdateUser());
      DateUtils.setDateTz(ps, 6, data.getUpdateTime());
      ps.setString(7, data.getSfcBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<CancelEapCardControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CancelEapCardControl data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getReason());
        ps.setString(4, data.getOther());
        ps.setString(5, data.getUpdateUser());
        DateUtils.setDateTz(ps, 6, data.getUpdateTime());
        ps.setString(7, data.getSfcBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM cancel_eap_card_control WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      return ps.executeUpdate();
    }
  }

  public List<CancelEapCardControl> selectAll() throws SQLException {
    ArrayList<CancelEapCardControl> result = new ArrayList<CancelEapCardControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CancelEapCardControl selectByPK(String sfcBo) throws SQLException {
    CancelEapCardControl result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<CancelEapCardControl> selectBySfcBo(String sfcBo) throws SQLException {
    List<CancelEapCardControl> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public CancelEapCardControl selectBySfcOperationBo(String sfcBo, String operationBo)
      throws SQLException {
    CancelEapCardControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SFC_BO = ?  AND OPERATION_BO = ?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, operationBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CancelEapCardControl convert(ResultSet rs) throws SQLException {
    CancelEapCardControl data = new CancelEapCardControl();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setReason(rs.getString(index++));
    data.setOther(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
