package ame.psb.db.dao;

import ame.psb.db.BaddiePackingPass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BaddiePackingPassDao {

  private static final String SQL_INS = "INSERT INTO zd_baddie_packing_pass(operation,customer_id,code,update_user,update_time,comment,description,message) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_baddie_packing_pass SET code=?,update_user=?,update_time=?,comment=?,description=?,message=? WHERE operation=? AND customer_id=?";

  private static final String SQL_SEL = "SELECT operation,customer_id,code,update_user,update_time,comment,description,message FROM zd_baddie_packing_pass ";

  private final Connection conn;

  public BaddiePackingPassDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BaddiePackingPass data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getOperation());
      ps.setString(2, data.getCustomerId());
      ps.setString(3, data.getCode());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getComment());
      ps.setString(7, data.getDescription());
      ps.setString(8, data.getMessage());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BaddiePackingPass> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BaddiePackingPass data : dataList) {
        ps.setString(1, data.getOperation());
        ps.setString(2, data.getCustomerId());
        ps.setString(3, data.getCode());
        ps.setString(4, data.getUpdateUser());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());
        ps.setString(6, data.getComment());
        ps.setString(7, data.getDescription());
        ps.setString(8, data.getMessage());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BaddiePackingPass data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCode());
      ps.setString(2, data.getUpdateUser());
      DateUtils.setDateTz(ps, 3, data.getUpdateTime());
      ps.setString(4, data.getComment());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getMessage());
      ps.setString(7, data.getOperation());
      ps.setString(8, data.getCustomerId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BaddiePackingPass> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BaddiePackingPass data : dataList) {
        ps.setString(1, data.getCode());
        ps.setString(2, data.getUpdateUser());
        DateUtils.setDateTz(ps, 3, data.getUpdateTime());
        ps.setString(4, data.getComment());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getMessage());
        ps.setString(7, data.getOperation());
        ps.setString(8, data.getCustomerId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String operation, String customerId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_baddie_packing_pass WHERE operation=? AND customer_id=?")) {
      ps.setString(1, operation);
      ps.setString(2, customerId);

      return ps.executeUpdate();
    }
  }

  public int deleteByCustomer(String customerId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_baddie_packing_pass WHERE customer_id=?")) {
      ps.setString(1, customerId);

      return ps.executeUpdate();
    }
  }

  public List<BaddiePackingPass> selectAll() throws SQLException {
    ArrayList<BaddiePackingPass> result = new ArrayList<BaddiePackingPass>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BaddiePackingPass selectByPK(String operation, String customerId) throws SQLException {
    BaddiePackingPass result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation=? AND customer_id=?")) {
      ps.setString(1, operation);
      ps.setString(2, customerId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<BaddiePackingPass> selectByOperation(String operation)
      throws SQLException { //根据站点查询记录
    ArrayList<BaddiePackingPass> result = new ArrayList<BaddiePackingPass>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE operation=? ")) {
      ps.setString(1, operation);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BaddiePackingPass> selectByCustomer(String customerId)
      throws SQLException { //根据客户查询记录
    ArrayList<BaddiePackingPass> result = new ArrayList<BaddiePackingPass>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE customer_id=? ")) {
      ps.setString(1, customerId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private BaddiePackingPass convert(ResultSet rs) throws SQLException {
    BaddiePackingPass data = new BaddiePackingPass();

    int index = 1;
    data.setOperation(rs.getString(index++));
    data.setCustomerId(rs.getString(index++));
    data.setCode(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setMessage(rs.getString(index++));

    return data;
  }
}
