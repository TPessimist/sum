package ame.psb.db.dao;

import ame.psb.db.CdmMoItem;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CdmMoItemDao {

  private static final String SQL_INS = "INSERT INTO zm_cdm_mo_item(mo_id,mo_item,lot_id,wafer_id,lot_wafer_id,wafer_sn,gross_die_qty,good_die_qty,ng_die_qty,mark_code,flag,flag2,remark,remark2,remark3,remark4,remark5,id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zm_cdm_mo_item SET mo_item=?,lot_id=?,wafer_id=?,lot_wafer_id=?,wafer_sn=?,gross_die_qty=?,good_die_qty=?,ng_die_qty=?,mark_code=?,flag=?,flag2=?,remark=?,remark2=?,remark3=?,remark4=?,remark5=?,id=? WHERE mo_id=?";

  private static final String SQL_SEL = "SELECT mo_id,mo_item,lot_id,wafer_id,lot_wafer_id,wafer_sn,gross_die_qty,good_die_qty,ng_die_qty,mark_code,flag,flag2,remark,remark2,remark3,remark4,remark5,id FROM zm_cdm_mo_item ";

  private final Connection conn;

  public CdmMoItemDao(Connection conn) {
    this.conn = conn;
  }

  public CdmMoItemDao() throws SQLException {
    this.conn = Hana.createDw();
  }

  public int insert(CdmMoItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getMoId());
      ps.setString(2, data.getMoItem());
      ps.setString(3, data.getLotId());
      ps.setString(4, data.getWaferId());
      ps.setString(5, data.getLotWaferId());
      ps.setString(6, data.getWaferSn());
      ps.setString(7, data.getGrossDieQty());
      ps.setString(8, data.getGoodDieQty());
      ps.setString(9, data.getNgDieQty());
      ps.setString(10, data.getMarkCode());
      ps.setString(11, data.getFlag());
      ps.setString(12, data.getFlag2());
      ps.setString(13, data.getRemark());
      ps.setString(14, data.getRemark2());
      ps.setString(15, data.getRemark3());
      ps.setString(16, data.getRemark4());
      ps.setString(17, data.getRemark5());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CdmMoItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CdmMoItem data : dataList) {
        ps.setString(1, data.getMoId());
        ps.setString(2, data.getMoItem());
        ps.setString(3, data.getLotId());
        ps.setString(4, data.getWaferId());
        ps.setString(5, data.getLotWaferId());
        ps.setString(6, data.getWaferSn());
        ps.setString(7, data.getGrossDieQty());
        ps.setString(8, data.getGoodDieQty());
        ps.setString(9, data.getNgDieQty());
        ps.setString(10, data.getMarkCode());
        ps.setString(11, data.getFlag());
        ps.setString(12, data.getFlag2());
        ps.setString(13, data.getRemark());
        ps.setString(14, data.getRemark2());
        ps.setString(15, data.getRemark3());
        ps.setString(16, data.getRemark4());
        ps.setString(17, data.getRemark5());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CdmMoItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getMoItem());
      ps.setString(2, data.getLotId());
      ps.setString(3, data.getWaferId());
      ps.setString(4, data.getLotWaferId());
      ps.setString(5, data.getWaferSn());
      ps.setString(6, data.getGrossDieQty());
      ps.setString(7, data.getGoodDieQty());
      ps.setString(8, data.getNgDieQty());
      ps.setString(9, data.getMarkCode());
      ps.setString(10, data.getFlag());
      ps.setString(11, data.getFlag2());
      ps.setString(12, data.getRemark());
      ps.setString(13, data.getRemark2());
      ps.setString(14, data.getRemark3());
      ps.setString(15, data.getRemark4());
      ps.setString(16, data.getRemark5());
      ps.setString(17, data.getId());
      ps.setString(18, data.getMoId());

      return ps.executeUpdate();
    }
  }

  public int update(List<CdmMoItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CdmMoItem data : dataList) {
        ps.setString(1, data.getMoItem());
        ps.setString(2, data.getLotId());
        ps.setString(3, data.getWaferId());
        ps.setString(4, data.getLotWaferId());
        ps.setString(5, data.getWaferSn());
        ps.setString(6, data.getGrossDieQty());
        ps.setString(7, data.getGoodDieQty());
        ps.setString(8, data.getNgDieQty());
        ps.setString(9, data.getMarkCode());
        ps.setString(10, data.getFlag());
        ps.setString(11, data.getFlag2());
        ps.setString(12, data.getRemark());
        ps.setString(13, data.getRemark2());
        ps.setString(14, data.getRemark3());
        ps.setString(15, data.getRemark4());
        ps.setString(16, data.getRemark5());
        ps.setString(17, data.getId());
        ps.setString(18, data.getMoId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String moId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zm_cdm_mo_item WHERE mo_id=?")) {
      ps.setString(1, moId);

      return ps.executeUpdate();
    }
  }

  public List<CdmMoItem> selectAll() throws SQLException {
    ArrayList<CdmMoItem> result = new ArrayList<CdmMoItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CdmMoItem selectByPK(String moId) throws SQLException {
    CdmMoItem result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE mo_id=?")) {
      ps.setString(1, moId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CdmMoItem selectByShopOrderAndWafer(String moId, String wafer)
      throws SQLException { //通过工单和生产批号查
    CdmMoItem result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE mo_id=? and LOT_WAFER_ID=? ")) {
      ps.setString(1, moId);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CdmMoItem convert(ResultSet rs) throws SQLException {
    CdmMoItem data = new CdmMoItem();

    int index = 1;
    data.setMoId(rs.getString(index++));
    data.setMoItem(rs.getString(index++));
    data.setLotId(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setLotWaferId(rs.getString(index++));
    data.setWaferSn(rs.getString(index++));
    data.setGrossDieQty(rs.getString(index++));
    data.setGoodDieQty(rs.getString(index++));
    data.setNgDieQty(rs.getString(index++));
    data.setMarkCode(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setFlag2(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setRemark2(rs.getString(index++));
    data.setRemark3(rs.getString(index++));
    data.setRemark4(rs.getString(index++));
    data.setRemark5(rs.getString(index++));
    data.setId(rs.getString(index++));

    return data;
  }
}
