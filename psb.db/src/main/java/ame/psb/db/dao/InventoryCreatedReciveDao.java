package ame.psb.db.dao;

import ame.psb.db.InventoryCreatedRecive;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InventoryCreatedReciveDao {

  private static final String SQL_INS = "INSERT INTO zr_inventory_created_recive(item,seq,job,type,state,message,qty,prd_date,eff_date,spare_value,spare_value2,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_inventory_created_recive SET job=?,type=?,state=?,message=?,qty=?,prd_date=?,eff_date=?,spare_value=?,spare_value2=?,update_user=?,update_time=? WHERE item=? AND seq=?";

  private static final String SQL_SEL = "SELECT item,seq,job,type,state,message,qty,prd_date,eff_date,spare_value,spare_value2,update_user,update_time FROM zr_inventory_created_recive ";

  private final Connection conn;

  public InventoryCreatedReciveDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InventoryCreatedRecive data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItem());
      ps.setString(2, data.getSeq());
      ps.setString(3, data.getJob());
      ps.setString(4, data.getType());
      ps.setString(5, data.getState());
      ps.setString(6, data.getMessage());
      ps.setString(7, data.getQty());
      ps.setString(8, data.getPrdDate());
      ps.setString(9, data.getEffDate());
      ps.setString(10, data.getSpareValue());
      ps.setString(11, data.getSpareValue2());
      ps.setString(12, data.getUpdateUser());
      DateUtils.setDateTz(ps, 13, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InventoryCreatedRecive> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InventoryCreatedRecive data : dataList) {
        ps.setString(1, data.getItem());
        ps.setString(2, data.getSeq());
        ps.setString(3, data.getJob());
        ps.setString(4, data.getType());
        ps.setString(5, data.getState());
        ps.setString(6, data.getMessage());
        ps.setString(7, data.getQty());
        ps.setString(8, data.getPrdDate());
        ps.setString(9, data.getEffDate());
        ps.setString(10, data.getSpareValue());
        ps.setString(11, data.getSpareValue2());
        ps.setString(12, data.getUpdateUser());
        DateUtils.setDateTz(ps, 13, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InventoryCreatedRecive data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getJob());
      ps.setString(2, data.getType());
      ps.setString(3, data.getState());
      ps.setString(4, data.getMessage());
      ps.setString(5, data.getQty());
      ps.setString(6, data.getPrdDate());
      ps.setString(7, data.getEffDate());
      ps.setString(8, data.getSpareValue());
      ps.setString(9, data.getSpareValue2());
      ps.setString(10, data.getUpdateUser());
      DateUtils.setDateTz(ps, 11, data.getUpdateTime());
      ps.setString(12, data.getItem());
      ps.setString(13, data.getSeq());

      return ps.executeUpdate();
    }
  }

  public int update(List<InventoryCreatedRecive> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InventoryCreatedRecive data : dataList) {
        ps.setString(1, data.getJob());
        ps.setString(2, data.getType());
        ps.setString(3, data.getState());
        ps.setString(4, data.getMessage());
        ps.setString(5, data.getQty());
        ps.setString(6, data.getPrdDate());
        ps.setString(7, data.getEffDate());
        ps.setString(8, data.getSpareValue());
        ps.setString(9, data.getSpareValue2());
        ps.setString(10, data.getUpdateUser());
        DateUtils.setDateTz(ps, 11, data.getUpdateTime());
        ps.setString(12, data.getItem());
        ps.setString(13, data.getSeq());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String item, String seq) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_inventory_created_recive WHERE item=? AND seq=?")) {
      ps.setString(1, item);
      ps.setString(2, seq);

      return ps.executeUpdate();
    }
  }

  public List<InventoryCreatedRecive> selectWait() throws SQLException {
    ArrayList<InventoryCreatedRecive> result = new ArrayList<InventoryCreatedRecive>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT TOP 50  * FROM zr_inventory_created_recive WHERE JOB='NEW_PDA_CREATED_RECIVE' AND STATE= 'WAIT' ORDER BY update_time")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<InventoryCreatedRecive> selectError() throws SQLException {
    ArrayList<InventoryCreatedRecive> result = new ArrayList<InventoryCreatedRecive>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT  * FROM zr_inventory_created_recive WHERE JOB='NEW_PDA_CREATED_RECIVE' AND STATE= 'ERROR' AND MESSAGE LIKE 'org.apache.axis.InternalException%' ORDER BY update_time")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public InventoryCreatedRecive selectByPK(String item, String seq) throws SQLException {
    InventoryCreatedRecive result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item=? AND seq=?")) {
      ps.setString(1, item);
      ps.setString(2, seq);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InventoryCreatedRecive convert(ResultSet rs) throws SQLException {
    InventoryCreatedRecive data = new InventoryCreatedRecive();

    int index = 1;
    data.setItem(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setJob(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setQty(rs.getString(index++));
    data.setPrdDate(rs.getString(index++));
    data.setEffDate(rs.getString(index++));
    data.setSpareValue(rs.getString(index++));
    data.setSpareValue2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
