package ame.psb.db.dao;

import ame.psb.db.DeviceOperationBuyoff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class DeviceOperationBuyoffDao {

  private static final String SQL_INS = "INSERT INTO zd_device_operation_buyoff(item_group_bo,operation_bo,hold_type,buyoff_flag,npi_approved,npi_comment,npi_picture_path,pe_approved,pe_comment,pe_picture_path,qe_approved,qe_comment,qe_picture_path,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_device_operation_buyoff SET buyoff_flag=?,npi_approved=?,npi_comment=?,npi_picture_path=?,pe_approved=?,pe_comment=?,pe_picture_path=?,qe_approved=?,qe_comment=?,qe_picture_path=?,updated_time=?,updated_user=? WHERE item_group_bo=? AND operation_bo=? AND hold_type=?";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,hold_type,buyoff_flag,npi_approved,npi_comment,npi_picture_path,pe_approved,pe_comment,pe_picture_path,qe_approved,qe_comment,qe_picture_path,updated_time,updated_user FROM zd_device_operation_buyoff ";

  private final Connection conn;

  public DeviceOperationBuyoffDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DeviceOperationBuyoff data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getHoldType());
      ps.setBoolean(4, data.getBuyoffFlag());
      ps.setBoolean(5, data.getNpiApproved());
      ps.setString(6, data.getNpiComment());
      ps.setString(7, data.getNpiPicturePath());
      ps.setBoolean(8, data.getPeApproved());
      ps.setString(9, data.getPeComment());
      ps.setString(10, data.getPePicturePath());
      ps.setBoolean(11, data.getQeApproved());
      ps.setString(12, data.getQeComment());
      ps.setString(13, data.getQePicturePath());
      DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
      ps.setString(15, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<DeviceOperationBuyoff> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (DeviceOperationBuyoff data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getHoldType());
        ps.setBoolean(4, data.getBuyoffFlag());
        ps.setBoolean(5, data.getNpiApproved());
        ps.setString(6, data.getNpiComment());
        ps.setString(7, data.getNpiPicturePath());
        ps.setBoolean(8, data.getPeApproved());
        ps.setString(9, data.getPeComment());
        ps.setString(10, data.getPePicturePath());
        ps.setBoolean(11, data.getQeApproved());
        ps.setString(12, data.getQeComment());
        ps.setString(13, data.getQePicturePath());
        DateUtils.setDateTz(ps, 14, data.getUpdatedTime());
        ps.setString(15, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(DeviceOperationBuyoff data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBoolean(1, data.getBuyoffFlag());
      ps.setBoolean(2, data.getNpiApproved());
      ps.setString(3, data.getNpiComment());
      ps.setString(4, data.getNpiPicturePath());
      ps.setBoolean(5, data.getPeApproved());
      ps.setString(6, data.getPeComment());
      ps.setString(7, data.getPePicturePath());
      ps.setBoolean(8, data.getQeApproved());
      ps.setString(9, data.getQeComment());
      ps.setString(10, data.getQePicturePath());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getUpdatedUser());
      ps.setString(13, data.getItemGroupBo());
      ps.setString(14, data.getOperationBo());
      ps.setString(15, data.getHoldType());

      return ps.executeUpdate();
    }
  }

  public int update(List<DeviceOperationBuyoff> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (DeviceOperationBuyoff data : dataList) {
        ps.setBoolean(1, data.getBuyoffFlag());
        ps.setBoolean(2, data.getNpiApproved());
        ps.setString(3, data.getNpiComment());
        ps.setString(4, data.getNpiPicturePath());
        ps.setBoolean(5, data.getPeApproved());
        ps.setString(6, data.getPeComment());
        ps.setString(7, data.getPePicturePath());
        ps.setBoolean(8, data.getQeApproved());
        ps.setString(9, data.getQeComment());
        ps.setString(10, data.getQePicturePath());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getUpdatedUser());
        ps.setString(13, data.getItemGroupBo());
        ps.setString(14, data.getOperationBo());
        ps.setString(15, data.getHoldType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo, String holdType) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_device_operation_buyoff WHERE item_group_bo=? AND operation_bo=? AND hold_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, holdType);

      return ps.executeUpdate();
    }
  }

  public List<DeviceOperationBuyoff> selectAll() throws SQLException {
    ArrayList<DeviceOperationBuyoff> result = new ArrayList<DeviceOperationBuyoff>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<DeviceOperationBuyoff> selectByNpiPath(String path) throws SQLException {
    ArrayList<DeviceOperationBuyoff> result = new ArrayList<DeviceOperationBuyoff>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where NPI_PICTURE_PATH = ? ")) {
      ps.setString(1, path);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<DeviceOperationBuyoff> selectByItemGroupBo(String itemGroupBo,String holdType) throws SQLException {
    ArrayList<DeviceOperationBuyoff> result = new ArrayList<DeviceOperationBuyoff>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where item_group_bo = ? and hold_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, holdType);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public DeviceOperationBuyoff selectByPK(String itemGroupBo, String operationBo, String holdType)
      throws SQLException {
    DeviceOperationBuyoff result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND hold_type=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, holdType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<DeviceOperationBuyoff> selectByPKItemGroupBoHoldType(String itemGroupBo, String holdType)
      throws SQLException {
    List<DeviceOperationBuyoff> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND hold_type=? order by UPDATED_TIME")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, holdType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<DeviceOperationBuyoff> selectByPKItemGroupBoHoldTypeBool(String itemGroupBo, String holdType,Boolean buyoffFlag)
      throws SQLException {
    List<DeviceOperationBuyoff> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND hold_type=? AND BUYOFF_FLAG = ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, holdType);
      ps.setBoolean(3, buyoffFlag);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  private DeviceOperationBuyoff convert(ResultSet rs) throws SQLException {
    DeviceOperationBuyoff data = new DeviceOperationBuyoff();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setHoldType(rs.getString(index++));
    data.setBuyoffFlag(rs.getBoolean(index++));
    data.setNpiApproved(rs.getBoolean(index++));
    data.setNpiComment(rs.getString(index++));
    data.setNpiPicturePath(rs.getString(index++));
    data.setPeApproved(rs.getBoolean(index++));
    data.setPeComment(rs.getString(index++));
    data.setPePicturePath(rs.getString(index++));
    data.setQeApproved(rs.getBoolean(index++));
    data.setQeComment(rs.getString(index++));
    data.setQePicturePath(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }

  public int selectCountByItemGroup(String itemGroupBoTo) throws SQLException {
    String selSql = "select count(1) from zd_device_operation_buyoff where item_group_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoTo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }

  public List<DeviceOperationBuyoff> select(Where where) throws SQLException {
    ArrayList<DeviceOperationBuyoff> result = new ArrayList<DeviceOperationBuyoff>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }
}
