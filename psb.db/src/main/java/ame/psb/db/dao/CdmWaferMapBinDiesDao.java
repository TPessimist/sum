package ame.psb.db.dao;

import ame.psb.db.CdmWaferMapBinDies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CdmWaferMapBinDiesDao {

  private static final String SQL_INS = "INSERT INTO zm_cdm_wafer_map_bin_dies(source_type,wafer_id,wafer_gross_dies,wafer_good_dies,wafer_ng_dies,flag,create_date,create_by,CUST_CODE,LOT_ID,ID,WAFER_NO,MAP_PATH,MES_GROSS_DIES, MES_NG_DIES, MES_GOOD_DIES) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zm_cdm_wafer_map_bin_dies SET source_type=?,wafer_gross_dies=?,wafer_good_dies=?,wafer_ng_dies=?,flag=?,create_date=?,create_by=?,CUST_CODE=?,LOT_ID = ? ,ID = ?,WAFER_NO=?,MAP_PATH=? ,MES_GROSS_DIES=?, MES_NG_DIES=?, MES_GOOD_DIESWHERE=? where wafer_id=?";

  private static final String SQL_SEL = "SELECT source_type,wafer_id,wafer_gross_dies,wafer_good_dies,wafer_ng_dies,flag,create_date,create_by,CUST_CODE,LOT_ID ,ID, WAFER_NO, MAP_PATH,MES_GROSS_DIES, MES_NG_DIES, MES_GOOD_DIES FROM zm_cdm_wafer_map_bin_dies ";

  private final Connection conn;

  public CdmWaferMapBinDiesDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CdmWaferMapBinDies data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSourceType());
      ps.setString(2, data.getWaferId());
      ps.setString(3, data.getWaferGrossDies());
      ps.setString(4, data.getWaferGoodDies());
      ps.setString(5, data.getWaferNgDies());
      ps.setString(6, data.getFlag());
      DateUtils.setDateTz(ps, 7, data.getCreateDate());
      ps.setString(8, data.getCreateBy());
      ps.setString(9, data.getCostCode());
      ps.setString(10, data.getLotId());
      ps.setString(11, data.getId());
      ps.setString(12, data.getWaferNo());
      ps.setString(13, data.getMapPath());
      ps.setString(14, data.getMesGrossDies());
      ps.setString(15, data.getMesNGDies());
      ps.setString(16, data.getMesGoodDies());
      return ps.executeUpdate();
    }
  }

  public int insert(List<CdmWaferMapBinDies> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CdmWaferMapBinDies data : dataList) {
        ps.setString(1, data.getSourceType());
        ps.setString(2, data.getWaferId());
        ps.setString(3, data.getWaferGrossDies());
        ps.setString(4, data.getWaferGoodDies());
        ps.setString(5, data.getWaferNgDies());
        ps.setString(6, data.getFlag());
        DateUtils.setDateTz(ps, 7, data.getCreateDate());
        ps.setString(8, data.getCreateBy());
        ps.setString(9, data.getCostCode());
        ps.setString(10, data.getLotId());
        ps.setString(11, data.getId());
        ps.setString(12, data.getWaferNo());
        ps.setString(13, data.getMapPath());
        ps.setString(14, data.getMesGrossDies());
        ps.setString(15, data.getMesNGDies());
        ps.setString(16, data.getMesGoodDies());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CdmWaferMapBinDies data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSourceType());
      ps.setString(2, data.getWaferGrossDies());
      ps.setString(3, data.getWaferGoodDies());
      ps.setString(4, data.getWaferNgDies());
      ps.setString(5, data.getFlag());
      DateUtils.setDateTz(ps, 6, data.getCreateDate());
      ps.setString(7, data.getCreateBy());
      ps.setString(8, data.getCostCode());
      ps.setString(9, data.getLotId());
      ps.setString(10, data.getId());
      ps.setString(11, data.getWaferNo());
      ps.setString(12, data.getMapPath());
      ps.setString(13, data.getMesGrossDies());
      ps.setString(14, data.getMesNGDies());
      ps.setString(15, data.getMesGoodDies());
      ps.setString(16, data.getWaferId());
      return ps.executeUpdate();
    }
  }

  public int update(List<CdmWaferMapBinDies> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CdmWaferMapBinDies data : dataList) {
        ps.setString(1, data.getSourceType());
        ps.setString(2, data.getWaferGrossDies());
        ps.setString(3, data.getWaferGoodDies());
        ps.setString(4, data.getWaferNgDies());
        ps.setString(5, data.getFlag());
        DateUtils.setDateTz(ps, 6, data.getCreateDate());
        ps.setString(7, data.getCreateBy());
        ps.setString(8, data.getCostCode());
        ps.setString(9, data.getLotId());
        ps.setString(10, data.getId());
        ps.setString(11, data.getWaferNo());
        ps.setString(12, data.getMapPath());
        ps.setString(13, data.getMesGrossDies());
        ps.setString(14, data.getMesNGDies());
        ps.setString(15, data.getMesGoodDies());
        ps.setString(16, data.getWaferId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zm_cdm_wafer_map_bin_dies WHERE wafer_id=?")) {
      ps.setString(1, waferId);

      return ps.executeUpdate();
    }
  }
  public int update(String waferId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zm_cdm_wafer_map_bin_dies SET flag= '0' where wafer_id=?")) {
      ps.setString(1, waferId);

      return ps.executeUpdate();
    }
  }
  public String nextSeq() throws SQLException {
    String result = "";
    try (PreparedStatement ps = this.conn
        .prepareStatement("SELECT zm_cdm_MAP_SEQ.nextval FROM dummy")) {

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getString(1);
      }
      return result;
    }
  }

  public List<CdmWaferMapBinDies> selectAll() throws SQLException {
    ArrayList<CdmWaferMapBinDies> result = new ArrayList<CdmWaferMapBinDies>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CdmWaferMapBinDies selectByPK(String waferId, String flag) throws SQLException {
    CdmWaferMapBinDies result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE wafer_id=? and FLAG =?")) {
      ps.setString(1, waferId);
      ps.setString(2, flag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CdmWaferMapBinDies convert(ResultSet rs) throws SQLException {
    CdmWaferMapBinDies data = new CdmWaferMapBinDies();

    int index = 1;
    data.setSourceType(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setWaferGrossDies(rs.getString(index++));
    data.setWaferGoodDies(rs.getString(index++));
    data.setWaferNgDies(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setCreateDate(DateUtils.getDateTz(rs, index++));
    data.setCreateBy(rs.getString(index++));
    data.setCostCode(rs.getString(index++));
    data.setLotId(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setWaferNo(rs.getString(index++));
    data.setMapPath(rs.getString(index++));
    data.setMesGrossDies(rs.getString(index++));
    data.setMesNGDies(rs.getString(index++));
    data.setMesGoodDies(rs.getString(index++));

    return data;
  }
}
