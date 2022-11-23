package ame.psb.db.dao;

import ame.psb.db.ZmCdmInventoryPointer;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZmCdmInventoryPointerDao {

  private static final String SQL_INS = "INSERT INTO zm_cdm_inventory_pointer(mandt,zseq,werks,charg,matnr,zwafer_lot,zwafer_id,zout_box,zbin_no,zbin,zdie_qty_rm,zdie_qty_gi,mo_id,mo_wafer_id,mo_wafer_sn,mo_flag,id,create_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zm_cdm_inventory_pointer SET mandt=?,zseq=?,werks=?,charg=?,matnr=?,zwafer_lot=?,zwafer_id=?,zout_box=?,zbin_no=?,zbin=?,zdie_qty_rm=?,zdie_qty_gi=?,mo_id=?,mo_wafer_id=?,mo_wafer_sn=?,mo_flag=?,create_date=? WHERE id=?";

  private static final String SQL_SEL = "SELECT mandt,zseq,werks,charg,matnr,zwafer_lot,zwafer_id,zout_box,zbin_no,zbin,zdie_qty_rm,zdie_qty_gi,mo_id,mo_wafer_id,mo_wafer_sn,mo_flag,id,create_date FROM zm_cdm_inventory_pointer ";

  private final Connection conn;

  public ZmCdmInventoryPointerDao(Connection conn) {
    this.conn = conn;
  }

  public ZmCdmInventoryPointerDao() throws SQLException {
    this.conn = Hana.createDw();
  }

  public int insert(ZmCdmInventoryPointer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getMandt());
      ps.setString(2, data.getZseq());
      ps.setString(3, data.getWerks());
      ps.setString(4, data.getCharg());
      ps.setString(5, data.getMatnr());
      ps.setString(6, data.getZwaferLot());
      ps.setString(7, data.getZwaferId());
      ps.setString(8, data.getZoutBox());
      ps.setString(9, data.getZbinNo());
      ps.setString(10, data.getZbin());
      ps.setString(11, data.getZdieQtyRm());
      ps.setString(12, data.getZdieQtyGi());
      ps.setString(13, data.getMoId());
      ps.setString(14, data.getMoWaferId());
      ps.setString(15, data.getMoWaferSn());
      ps.setString(16, data.getMoFlag());
      ps.setString(17, data.getId());
      DateUtils.setDateTz(ps, 18, data.getCreateDate());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZmCdmInventoryPointer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZmCdmInventoryPointer data : dataList) {
        ps.setString(1, data.getMandt());
        ps.setString(2, data.getZseq());
        ps.setString(3, data.getWerks());
        ps.setString(4, data.getCharg());
        ps.setString(5, data.getMatnr());
        ps.setString(6, data.getZwaferLot());
        ps.setString(7, data.getZwaferId());
        ps.setString(8, data.getZoutBox());
        ps.setString(9, data.getZbinNo());
        ps.setString(10, data.getZbin());
        ps.setString(11, data.getZdieQtyRm());
        ps.setString(12, data.getZdieQtyGi());
        ps.setString(13, data.getMoId());
        ps.setString(14, data.getMoWaferId());
        ps.setString(15, data.getMoWaferSn());
        ps.setString(16, data.getMoFlag());
        ps.setString(17, data.getId());
        DateUtils.setDateTz(ps, 18, data.getCreateDate());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZmCdmInventoryPointer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getMandt());
      ps.setString(2, data.getZseq());
      ps.setString(3, data.getWerks());
      ps.setString(4, data.getCharg());
      ps.setString(5, data.getMatnr());
      ps.setString(6, data.getZwaferLot());
      ps.setString(7, data.getZwaferId());
      ps.setString(8, data.getZoutBox());
      ps.setString(9, data.getZbinNo());
      ps.setString(10, data.getZbin());
      ps.setString(11, data.getZdieQtyRm());
      ps.setString(12, data.getZdieQtyGi());
      ps.setString(13, data.getMoId());
      ps.setString(14, data.getMoWaferId());
      ps.setString(15, data.getMoWaferSn());
      ps.setString(16, data.getMoFlag());
      DateUtils.setDateTz(ps, 17, data.getCreateDate());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZmCdmInventoryPointer> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZmCdmInventoryPointer data : dataList) {
        ps.setString(1, data.getMandt());
        ps.setString(2, data.getZseq());
        ps.setString(3, data.getWerks());
        ps.setString(4, data.getCharg());
        ps.setString(5, data.getMatnr());
        ps.setString(6, data.getZwaferLot());
        ps.setString(7, data.getZwaferId());
        ps.setString(8, data.getZoutBox());
        ps.setString(9, data.getZbinNo());
        ps.setString(10, data.getZbin());
        ps.setString(11, data.getZdieQtyRm());
        ps.setString(12, data.getZdieQtyGi());
        ps.setString(13, data.getMoId());
        ps.setString(14, data.getMoWaferId());
        ps.setString(15, data.getMoWaferSn());
        ps.setString(16, data.getMoFlag());
        DateUtils.setDateTz(ps, 17, data.getCreateDate());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zm_cdm_inventory_pointer WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZmCdmInventoryPointer> selectAll() throws SQLException {
    ArrayList<ZmCdmInventoryPointer> result = new ArrayList<ZmCdmInventoryPointer>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZmCdmInventoryPointer selectByPK(String id) throws SQLException {
    ZmCdmInventoryPointer result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZmCdmInventoryPointer> selectByMoIdAndMoWaferId(String shopOrder, String waferId)
      throws SQLException {
    ArrayList<ZmCdmInventoryPointer> result = new ArrayList<ZmCdmInventoryPointer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE mo_id=? AND mo_wafer_id=?")) {
      ps.setString(1, shopOrder);
      ps.setString(2, waferId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZmCdmInventoryPointer> selectByShopOrder(String shopOrder)
      throws SQLException {
    ArrayList<ZmCdmInventoryPointer> result = new ArrayList<ZmCdmInventoryPointer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE mo_id=?")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZmCdmInventoryPointer convert(ResultSet rs) throws SQLException {
    ZmCdmInventoryPointer data = new ZmCdmInventoryPointer();

    int index = 1;
    data.setMandt(rs.getString(index++));
    data.setZseq(rs.getString(index++));
    data.setWerks(rs.getString(index++));
    data.setCharg(rs.getString(index++));
    data.setMatnr(rs.getString(index++));
    data.setZwaferLot(rs.getString(index++));
    data.setZwaferId(rs.getString(index++));
    data.setZoutBox(rs.getString(index++));
    data.setZbinNo(rs.getString(index++));
    data.setZbin(rs.getString(index++));
    data.setZdieQtyRm(rs.getString(index++));
    data.setZdieQtyGi(rs.getString(index++));
    data.setMoId(rs.getString(index++));
    data.setMoWaferId(rs.getString(index++));
    data.setMoWaferSn(rs.getString(index++));
    data.setMoFlag(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setCreateDate(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
