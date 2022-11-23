package ame.psb.db.dao;

import ame.psb.db.Zr68CustReply;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Zr68CustReplyDao {

  private static final String SQL_INS = "INSERT INTO zr_68_cust_reply(test_house,product_name,mps_lot_id,lot_id,revision,current_stage,category,disposition,stage_to_retest,stage_to_rehold_pte,stage_to_rehold_pye,creater,create_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_68_cust_reply SET product_name=?,mps_lot_id=?,lot_id=?,revision=?,current_stage=?,category=?,disposition=?,stage_to_retest=?,stage_to_rehold_pte=?,stage_to_rehold_pye=?,creater=?,create_time=? WHERE test_house=?";

  private static final String SQL_SEL = "SELECT test_house,product_name,mps_lot_id,lot_id,revision,current_stage,category,disposition,stage_to_retest,stage_to_rehold_pte,stage_to_rehold_pye,creater,create_time FROM zr_68_cust_reply ";

  private final Connection conn;

  public Zr68CustReplyDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Zr68CustReply data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getTestHouse());
      ps.setString(2, data.getProductName());
      ps.setString(3, data.getMpsLotId());
      ps.setString(4, data.getLotId());
      ps.setString(5, data.getRevision());
      ps.setString(6, data.getCurrentStage());
      ps.setString(7, data.getCategory());
      ps.setString(8, data.getDisposition());
      ps.setString(9, data.getStageToRetest());
      ps.setString(10, data.getStageToReholdPte());
      ps.setString(11, data.getStageToReholdPye());
      ps.setString(12, data.getCreater());
      DateUtils.setDateTz(ps, 13, data.getCreateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Zr68CustReply> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Zr68CustReply data : dataList) {
        ps.setString(1, data.getTestHouse());
        ps.setString(2, data.getProductName());
        ps.setString(3, data.getMpsLotId());
        ps.setString(4, data.getLotId());
        ps.setString(5, data.getRevision());
        ps.setString(6, data.getCurrentStage());
        ps.setString(7, data.getCategory());
        ps.setString(8, data.getDisposition());
        ps.setString(9, data.getStageToRetest());
        ps.setString(10, data.getStageToReholdPte());
        ps.setString(11, data.getStageToReholdPye());
        ps.setString(12, data.getCreater());
        DateUtils.setDateTz(ps, 13, data.getCreateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Zr68CustReply data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getProductName());
      ps.setString(2, data.getMpsLotId());
      ps.setString(3, data.getLotId());
      ps.setString(4, data.getRevision());
      ps.setString(5, data.getCurrentStage());
      ps.setString(6, data.getCategory());
      ps.setString(7, data.getDisposition());
      ps.setString(8, data.getStageToRetest());
      ps.setString(9, data.getStageToReholdPte());
      ps.setString(10, data.getStageToReholdPye());
      ps.setString(11, data.getCreater());
      DateUtils.setDateTz(ps, 12, data.getCreateTime());
      ps.setString(13, data.getTestHouse());

      return ps.executeUpdate();
    }
  }

  public int update(List<Zr68CustReply> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Zr68CustReply data : dataList) {
        ps.setString(1, data.getProductName());
        ps.setString(2, data.getMpsLotId());
        ps.setString(3, data.getLotId());
        ps.setString(4, data.getRevision());
        ps.setString(5, data.getCurrentStage());
        ps.setString(6, data.getCategory());
        ps.setString(7, data.getDisposition());
        ps.setString(8, data.getStageToRetest());
        ps.setString(9, data.getStageToReholdPte());
        ps.setString(10, data.getStageToReholdPye());
        ps.setString(11, data.getCreater());
        DateUtils.setDateTz(ps, 12, data.getCreateTime());
        ps.setString(13, data.getTestHouse());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String testHouse) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_68_cust_reply WHERE test_house=?")) {
      ps.setString(1, testHouse);

      return ps.executeUpdate();
    }
  }

  public List<Zr68CustReply> selectAll() throws SQLException {
    ArrayList<Zr68CustReply> result = new ArrayList<Zr68CustReply>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Zr68CustReply selectByPK(String testHouse) throws SQLException {
    Zr68CustReply result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE test_house=?")) {
      ps.setString(1, testHouse);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<Zr68CustReply> selectByShopOrder(String shopOrder) throws SQLException {
    ArrayList<Zr68CustReply> result = new ArrayList<Zr68CustReply>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE lot_id=? ")) {
      ps.setString(1, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private Zr68CustReply convert(ResultSet rs) throws SQLException {
    Zr68CustReply data = new Zr68CustReply();

    int index = 1;
    data.setTestHouse(rs.getString(index++));
    data.setProductName(rs.getString(index++));
    data.setMpsLotId(rs.getString(index++));
    data.setLotId(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setCurrentStage(rs.getString(index++));
    data.setCategory(rs.getString(index++));
    data.setDisposition(rs.getString(index++));
    data.setStageToRetest(rs.getString(index++));
    data.setStageToReholdPte(rs.getString(index++));
    data.setStageToReholdPye(rs.getString(index++));
    data.setCreater(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
