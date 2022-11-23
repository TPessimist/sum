package ame.psb.db.dao;

import ame.psb.db.WaferScrap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class WaferScrapDao {

  private static final String SQL_INS = "INSERT INTO zd_sfc_wafer_scrap(sfc_bo,sfc,item_bo,die_qty,bad_qty,good_qty,reason,update_user,update_time,extend) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_sfc_wafer_scrap SET sfc=?,die_qty=?,bad_qty=?,good_qty=?,reason=?,update_user=?,update_time=?,extend=? WHERE sfc_bo=? AND item_bo=?";

  private static final String SQL_SEL = "SELECT sfc_bo,sfc,item_bo,die_qty,bad_qty,good_qty,reason,update_user,update_time,extend FROM zd_sfc_wafer_scrap ";

  private final Connection conn;

  public WaferScrapDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(WaferScrap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getItemBo());
      ps.setBigDecimal(4, data.getDieQty());
      ps.setBigDecimal(5, data.getBadQty());
      ps.setBigDecimal(6, data.getGoodQty());
      ps.setString(7, data.getReason());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getExtend());

      return ps.executeUpdate();
    }
  }

  public int insert(List<WaferScrap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (WaferScrap data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getItemBo());
        ps.setBigDecimal(4, data.getDieQty());
        ps.setBigDecimal(5, data.getBadQty());
        ps.setBigDecimal(6, data.getGoodQty());
        ps.setString(7, data.getReason());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getExtend());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(WaferScrap data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setBigDecimal(2, data.getDieQty());
      ps.setBigDecimal(3, data.getBadQty());
      ps.setBigDecimal(4, data.getGoodQty());
      ps.setString(5, data.getReason());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getExtend());
      ps.setString(9, data.getSfcBo());
      ps.setString(10, data.getItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<WaferScrap> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (WaferScrap data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setBigDecimal(2, data.getDieQty());
        ps.setBigDecimal(3, data.getBadQty());
        ps.setBigDecimal(4, data.getGoodQty());
        ps.setString(5, data.getReason());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getExtend());
        ps.setString(9, data.getSfcBo());
        ps.setString(10, data.getItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcBo, String itemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_sfc_wafer_scrap WHERE sfc_bo=? AND item_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, itemBo);

      return ps.executeUpdate();
    }
  }

  public List<WaferScrap> selectAll() throws SQLException {
    ArrayList<WaferScrap> result = new ArrayList<WaferScrap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public WaferScrap selectByPK(String sfcBo, String itemBo) throws SQLException {
    WaferScrap result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND item_bo=?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<WaferScrap> selectBySfcBo(String sfcBo) throws SQLException {
    List<WaferScrap> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=? ")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private WaferScrap convert(ResultSet rs) throws SQLException {
    WaferScrap data = new WaferScrap();

    int index = 1;
    data.setSfcBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setDieQty(rs.getBigDecimal(index++));
    data.setBadQty(rs.getBigDecimal(index++));
    data.setGoodQty(rs.getBigDecimal(index++));
    data.setReason(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setExtend(rs.getString(index++));

    return data;
  }
}
