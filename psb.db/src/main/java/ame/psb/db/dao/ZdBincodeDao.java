package ame.psb.db.dao;

import ame.psb.db.ZdBincode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdBincodeDao {

  private static final String SQL_INS = "INSERT INTO zd_bincode(id,item_group_bo,item_group_name,bin_type,bin_code,bin_name,operation_bo,operation_name,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_bincode SET item_group_bo=?,item_group_name=?,bin_type=?,bin_code=?,bin_name=?,operation_bo=?,operation_name=?,update_user=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,item_group_name,bin_type,bin_code,bin_name,operation_bo,operation_name,update_user,update_time FROM zd_bincode ";

  private final Connection conn;

  public ZdBincodeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdBincode data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getItemGroupName());
      ps.setString(4, data.getBinType());
      ps.setString(5, data.getBinCode());
      ps.setString(6, data.getBinName());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getOperationName());
      ps.setString(9, data.getUpdateUser());
      DateUtils.setDateTz(ps, 10, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdBincode> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdBincode data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getItemGroupName());
        ps.setString(4, data.getBinType());
        ps.setString(5, data.getBinCode());
        ps.setString(6, data.getBinName());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getOperationName());
        ps.setString(9, data.getUpdateUser());
        DateUtils.setDateTz(ps, 10, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdBincode data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getItemGroupName());
      ps.setString(3, data.getBinType());
      ps.setString(4, data.getBinCode());
      ps.setString(5, data.getBinName());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getOperationName());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdBincode> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdBincode data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getItemGroupName());
        ps.setString(3, data.getBinType());
        ps.setString(4, data.getBinCode());
        ps.setString(5, data.getBinName());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getOperationName());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zd_bincode WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDeviceBo(String deviceName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_bincode WHERE item_group_bo=?")) {
      ps.setString(1, deviceName);

      return ps.executeUpdate();
    }
  }

  public List<ZdBincode> selectAll() throws SQLException {
    ArrayList<ZdBincode> result = new ArrayList<ZdBincode>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdBincode> select(String deviceBo) throws SQLException {
    ArrayList<ZdBincode> result = new ArrayList<ZdBincode>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=?")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdBincode selectByPK(String id) throws SQLException {
    ZdBincode result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdBincode convert(ResultSet rs) throws SQLException {
    ZdBincode data = new ZdBincode();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setBinType(rs.getString(index++));
    data.setBinCode(rs.getString(index++));
    data.setBinName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
