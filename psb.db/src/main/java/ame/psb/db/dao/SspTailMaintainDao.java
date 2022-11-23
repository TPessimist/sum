package ame.psb.db.dao;

import ame.psb.db.SspTailMaintain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SspTailMaintainDao {

  private static final String SQL_INS = "INSERT INTO zd_ssp_tail_maintain(uuid,sfc_bo,item_group_bo,date_code,tail_qty,state_name,secondary_sfc_bo,secondary_tail_qty,reversed_field1,reversed_field2,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ssp_tail_maintain SET sfc_bo=?,item_group_bo=?,date_code=?,tail_qty=?,state_name=?,secondary_sfc_bo=?,secondary_tail_qty=?,reversed_field1=?,reversed_field2=?,updated_time=?,updated_user=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,sfc_bo,item_group_bo,date_code,tail_qty,state_name,secondary_sfc_bo,secondary_tail_qty,reversed_field1,reversed_field2,updated_time,updated_user FROM zd_ssp_tail_maintain ";

  private final Connection conn;

  public SspTailMaintainDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SspTailMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getDateCode());
      ps.setBigDecimal(5, data.getTailQty());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getSecondarySfcBo());
      ps.setBigDecimal(8, data.getSecondaryTailQty());
      ps.setString(9, data.getReversedField1());
      ps.setString(10, data.getReversedField2());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SspTailMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SspTailMaintain data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getDateCode());
        ps.setBigDecimal(5, data.getTailQty());
        ps.setString(6, data.getStateName());
        ps.setString(7, data.getSecondarySfcBo());
        ps.setBigDecimal(8, data.getSecondaryTailQty());
        ps.setString(9, data.getReversedField1());
        ps.setString(10, data.getReversedField2());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SspTailMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getDateCode());
      ps.setBigDecimal(4, data.getTailQty());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getSecondarySfcBo());
      ps.setBigDecimal(7, data.getSecondaryTailQty());
      ps.setString(8, data.getReversedField1());
      ps.setString(9, data.getReversedField2());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getUpdatedUser());
      ps.setString(12, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<SspTailMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SspTailMaintain data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getDateCode());
        ps.setBigDecimal(4, data.getTailQty());
        ps.setString(5, data.getStateName());
        ps.setString(6, data.getSecondarySfcBo());
        ps.setBigDecimal(7, data.getSecondaryTailQty());
        ps.setString(8, data.getReversedField1());
        ps.setString(9, data.getReversedField2());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getUpdatedUser());
        ps.setString(12, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ssp_tail_maintain WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<SspTailMaintain> selectAll() throws SQLException {
    ArrayList<SspTailMaintain> result = new ArrayList<SspTailMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SspTailMaintain selectByPK(String uuid) throws SQLException {
    SspTailMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SspTailMaintain selectBySfc(String sfcBo) throws SQLException {
    SspTailMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SFC_BO=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SspTailMaintain> selectAllExceptSfc(String sfcBo, String itemGroupBo)
      throws SQLException {
    ArrayList<SspTailMaintain> result = new ArrayList<SspTailMaintain>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE SFC_BO !=? AND item_group_bo =? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SspTailMaintain> selectAllDoneSfc() throws SQLException {
    ArrayList<SspTailMaintain> result = new ArrayList<SspTailMaintain>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE STATE_NAME = 'DONE' ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SspTailMaintain selectBySecondarySfc(String sfcBo) throws SQLException {
    SspTailMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SECONDARY_SFC_BO=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SspTailMaintain convert(ResultSet rs) throws SQLException {
    SspTailMaintain data = new SspTailMaintain();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setDateCode(rs.getString(index++));
    data.setTailQty(rs.getBigDecimal(index++));
    data.setStateName(rs.getString(index++));
    data.setSecondarySfcBo(rs.getString(index++));
    data.setSecondaryTailQty(rs.getBigDecimal(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
