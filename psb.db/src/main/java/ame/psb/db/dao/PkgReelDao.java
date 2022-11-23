package ame.psb.db.dao;

import ame.psb.db.PkgReel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgReelDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_reel(uuid,id,type,customer_item_name,reel_seq,grade_id,good_bad,die_qty,label_info,memo,updated_user,updated_time, seq,shop_order_bo,remarks) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_reel SET id=?,type=?,customer_item_name=?,reel_seq=?,grade_id=?,good_bad=?,die_qty=?,label_info=?,memo=?,updated_user=?,updated_time=?,shop_order_bo=?,remarks=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,id,type,customer_item_name,reel_seq,grade_id,good_bad,die_qty,label_info,memo,updated_user,updated_time, seq,shop_order_bo,remarks FROM zr_pkg_reel ";

  private static final String SQL_SEL_REEL_INFO = "SELECT a.id ,String_agg(a.CUSTOMER_ITEM_NAME, '&'),String_agg(a.DIE_QTY, '&')  FROM ZR_PKG_REEL a INNER JOIN VIEW_CUSTOMER_ITEM b ON a.CUSTOMER_ITEM_NAME = b.ITEM_NAME ";


  private final Connection conn;

  public PkgReelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgReel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getId());
      ps.setString(3, data.getType());
      ps.setString(4, data.getCustomerItemName());
      ps.setBigDecimal(5, data.getReelSeq());
      ps.setString(6, data.getGradeId());
      ps.setString(7, data.getGoodBad());
      ps.setBigDecimal(8, new BigDecimal(data.getDieQty()));
      ps.setString(9, data.getLabelInfo());
      ps.setString(10, data.getMemo());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setBigDecimal(13, new BigDecimal(1));
      ps.setString(14, data.getShopOrderBo());
      ps.setString(15, data.getRemarks());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgReel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      int i = 0;
      for (PkgReel data : dataList) {

        ps.setString(1, data.getUuid());
        ps.setString(2, data.getId());
        ps.setString(3, data.getType());
        ps.setString(4, data.getCustomerItemName());
        ps.setBigDecimal(5, data.getReelSeq());
        ps.setString(6, data.getGradeId());
        ps.setString(7, data.getGoodBad());
        ps.setBigDecimal(8, new BigDecimal(data.getDieQty()));
        ps.setString(9, data.getLabelInfo());
        ps.setString(10, data.getMemo());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setBigDecimal(13, new BigDecimal(++i));
        ps.setString(14, data.getShopOrderBo());
        ps.setString(15, data.getRemarks());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgReel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getType());
      ps.setString(3, data.getCustomerItemName());
      ps.setBigDecimal(4, data.getReelSeq());
      ps.setString(5, data.getGradeId());
      ps.setString(6, data.getGoodBad());
      ps.setBigDecimal(7, new BigDecimal(data.getDieQty()));
      ps.setString(8, data.getLabelInfo());
      ps.setString(9, data.getMemo());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getShopOrderBo());
      ps.setString(13, data.getRemarks());
      ps.setString(14, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgReel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgReel data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getType());
        ps.setString(3, data.getCustomerItemName());
        ps.setBigDecimal(4, data.getReelSeq());
        ps.setString(5, data.getGradeId());
        ps.setString(6, data.getGoodBad());
        ps.setBigDecimal(7, new BigDecimal(data.getDieQty()));
        ps.setString(8, data.getLabelInfo());
        ps.setString(9, data.getMemo());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getShopOrderBo());
        ps.setString(13, data.getRemarks());
        ps.setString(14, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_reel WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<PkgReel> selectAll() throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<PkgReel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<PkgReel> selectByItemName(String waferid, String type, String binCode)
      throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where CUSTOMER_ITEM_NAME = ? and TYPE != ?  and grade_id = ?")) {
      ps.setString(1, waferid);
      ps.setString(2, type);
      ps.setString(3, binCode);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByItemNameAndShopOrder(String waferid, String shopOrder, String type,
      String binCode) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where CUSTOMER_ITEM_NAME = ? and shop_order_bo = ? and TYPE != ?  and grade_id = ?")) {
      ps.setString(1, waferid);
      ps.setString(2, shopOrder);
      ps.setString(3, type);
      ps.setString(4, binCode);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByItemName(String waferid, String type) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where CUSTOMER_ITEM_NAME = ? and TYPE != ?")) {
      ps.setString(1, waferid);
      ps.setString(2, type);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByWafer(String waferid, String type) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where CUSTOMER_ITEM_NAME = ? and TYPE = ? ")) {
      ps.setString(1, waferid);
      ps.setString(2, type);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByReelId(String reelId) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where id = ? ")) {
      ps.setString(1, reelId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByReelIdAndState(String reelId) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where id = ? AND type != 'REEL_DELETE'AND type != 'REEL_SCRAP'AND type != 'REEL_HOLD' ")) {
      ps.setString(1, reelId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByReelIdAndState(String reelId, String stateName) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where id = ? AND type = ? order by seq")) {
      ps.setString(1, reelId);
      ps.setString(2, stateName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByReelIdReelCheck(String reelId) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where id = ? AND type IN( 'REEL_CHECK', 'REEL_WAIT')")) {
      ps.setString(1, reelId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgReel> selectByUUID(String reelId) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where uuid = ? ")) {
      ps.setString(1, reelId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<PkgReel> selectByLotName(String lotName) throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where CUSTOMER_ITEM_NAME like ?  ")) {
      ps.setString(1, "%" + lotName + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<PkgReel> selectByLot(String lotName)
      throws SQLException { //xf20201023 不采用上面方法的like，而是直接等于
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where CUSTOMER_ITEM_NAME = ?  ")) {
      ps.setString(1, lotName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /*
   * @author cong.chen
   * @param sfc、type
   * */
  public List<PkgReel> selectByLotAndType(String lotName, String type)
      throws SQLException {
    ArrayList<PkgReel> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "where CUSTOMER_ITEM_NAME = ? and  TYPE = ? ORDER BY UPDATED_TIME DESC")) {
      ps.setString(1, lotName);
      ps.setString(2, type);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ReelInfo> selectReelInfoByLotName(String lotName) throws SQLException {
    ArrayList<ReelInfo> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_REEL_INFO
        + " WHERE b.ITEMSET_NAME = ? and a.type in( 'REEL_WAIT',  'REEL_CHECK') AND b.SFC_TYPE = 'S' GROUP BY a.id  ORDER  BY a.id  ")) {
      ps.setString(1, lotName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertReelInfo(rs));
      }
      return result;
    }
  }

  public List<ReelInfo> selectReelInfoBySfc(String sfcName) throws SQLException {
    ArrayList<ReelInfo> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_REEL_INFO
        + " WHERE b.SFC_NAME = ? and a.type in( 'REEL_WAIT',  'REEL_CHECK') AND b.SFC_TYPE = 'S' GROUP BY a.id  ORDER  BY a.id  ")) {
      ps.setString(1, sfcName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertReelInfo(rs));
      }
      return result;
    }
  }

  public List<ReelInfo> selectReelInfoByBatchSfc(String sfcName) throws SQLException {
    ArrayList<ReelInfo> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_REEL_INFO
        + " WHERE b.SFC_NAME = ? and a.type in( 'REEL_WAIT',  'REEL_CHECK') GROUP BY a.id  ORDER  BY a.id  ")) {
      ps.setString(1, sfcName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertReelInfo(rs));
      }
      return result;
    }
  }


  public PkgReel selectByPK(String uuid) throws SQLException {
    PkgReel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgReel selectByReel(String id) throws SQLException {
    PkgReel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgReel selectByIdAndType(String reelId) throws SQLException {
    PkgReel result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "where id = ? AND type IN('REEL_CHECK', 'REEL_WAIT') AND DIE_QTY != 0  ")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgReel convert(ResultSet rs) throws SQLException {
    PkgReel data = new PkgReel();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setCustomerItemName(rs.getString(index++));
    data.setReelSeq(rs.getBigDecimal(index++));
    data.setGradeId(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setDieQty(rs.getBigDecimal(index++));
    data.setLabelInfo(rs.getString(index++));
    data.setMemo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setSeq(rs.getBigDecimal(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setRemarks(rs.getString(index++));

    return data;
  }

  private ReelInfo convertReelInfo(ResultSet rs) throws SQLException {
    ReelInfo data = new ReelInfo();

    int index = 1;
    data.id = rs.getString(index++);
    data.complexWaferId = "'" + rs.getString(index++).replaceAll("&", "','") + "'";
    data.complexQty = "'" + rs.getString(index++).replaceAll("&", "','") + "'";

    return data;
  }

  public static class ReelInfo {

    public String id;
    public String complexWaferId;
    public String complexQty;
  }
}
