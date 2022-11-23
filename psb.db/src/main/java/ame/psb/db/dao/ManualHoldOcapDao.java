package ame.psb.db.dao;

import ame.psb.db.ManualHoldOcap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ManualHoldOcapDao {

  private static final String SQL_INS = "INSERT INTO zr_manual_hold_ocap(hold_detail_bo,sfc_bo,value,request_id,process_flag,hold_user,hold_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_manual_hold_ocap SET sfc_bo=?,value=?,request_id=?,process_flag=?,hold_user=?,hold_time=? WHERE hold_detail_bo=?";

  private static final String SQL_SEL = "SELECT hold_detail_bo,sfc_bo,value,request_id,process_flag,hold_user,hold_time FROM zr_manual_hold_ocap ";

  private final Connection conn;

  public ManualHoldOcapDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ManualHoldOcap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHoldDetailBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getValue());
      ps.setString(4, data.getRequestId());
      ps.setString(5, data.getProcessFlag());
      ps.setString(6, data.getHoldUser());
      DateUtils.setDateTz(ps, 7, data.getHoldTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ManualHoldOcap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ManualHoldOcap data : dataList) {
        ps.setString(1, data.getHoldDetailBo());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getValue());
        ps.setString(4, data.getRequestId());
        ps.setString(5, data.getProcessFlag());
        ps.setString(6, data.getHoldUser());
        DateUtils.setDateTz(ps, 7, data.getHoldTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ManualHoldOcap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getValue());
      ps.setString(3, data.getRequestId());
      ps.setString(4, data.getProcessFlag());
      ps.setString(5, data.getHoldUser());
      DateUtils.setDateTz(ps, 6, data.getHoldTime());
      ps.setString(7, data.getHoldDetailBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ManualHoldOcap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ManualHoldOcap data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getValue());
        ps.setString(3, data.getRequestId());
        ps.setString(4, data.getProcessFlag());
        ps.setString(5, data.getHoldUser());
        DateUtils.setDateTz(ps, 6, data.getHoldTime());
        ps.setString(7, data.getHoldDetailBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String holdDetailBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_manual_hold_ocap WHERE hold_detail_bo=?")) {
      ps.setString(1, holdDetailBo);

      return ps.executeUpdate();
    }
  }

  public List<ManualHoldOcap> selectAll() throws SQLException {
    ArrayList<ManualHoldOcap> result = new ArrayList<ManualHoldOcap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ManualHoldOcap selectByPK(String holdDetailBo) throws SQLException {
    ManualHoldOcap result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_detail_bo=?")) {
      ps.setString(1, holdDetailBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ManualHoldOcap selectByPKLike(String holdLogBo) throws SQLException {
    ManualHoldOcap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE hold_detail_bo like ?")) {
      ps.setString(1, "%" + holdLogBo + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ManualHoldOcap convert(ResultSet rs) throws SQLException {
    ManualHoldOcap data = new ManualHoldOcap();

    int index = 1;
    data.setHoldDetailBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setRequestId(rs.getString(index++));
    data.setProcessFlag(rs.getString(index++));
    data.setHoldUser(rs.getString(index++));
    data.setHoldTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
