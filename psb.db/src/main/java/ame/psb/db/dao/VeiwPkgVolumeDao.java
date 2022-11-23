package ame.psb.db.dao;

import ame.psb.db.VeiwPkgVolume;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class VeiwPkgVolumeDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_volume(customer,operation_bo,outer_box,volume_size,erserve1,erserve2,update_user,update_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_volume SET outer_box=?,erserve1=?,erserve2=?,update_user=?,update_time=? WHERE customer=? AND operation_bo=? AND volume_size=?";

  private static final String SQL_SEL = "SELECT customer,operation_bo,outer_box,volume_size,erserve1,erserve2,update_user,update_time FROM zd_pkg_volume ";

  private final Connection conn;

  public VeiwPkgVolumeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(VeiwPkgVolume data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustomer());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getOuterBox());
      ps.setString(4, data.getVolumeSize());
      ps.setString(5, data.getErserve1());
      ps.setString(6, data.getErserve2());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<VeiwPkgVolume> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (VeiwPkgVolume data : dataList) {
        ps.setString(1, data.getCustomer());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getOuterBox());
        ps.setString(4, data.getVolumeSize());
        ps.setString(5, data.getErserve1());
        ps.setString(6, data.getErserve2());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(VeiwPkgVolume data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOuterBox());
      ps.setString(2, data.getErserve1());
      ps.setString(3, data.getErserve2());
      ps.setString(4, data.getUpdateUser());
      DateUtils.setDateTz(ps, 5, data.getUpdateTime());
      ps.setString(6, data.getCustomer());
      ps.setString(7, data.getOperationBo());
      ps.setString(8, data.getVolumeSize());

      return ps.executeUpdate();
    }
  }

  public int update(List<VeiwPkgVolume> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (VeiwPkgVolume data : dataList) {
        ps.setString(1, data.getOuterBox());
        ps.setString(2, data.getErserve1());
        ps.setString(3, data.getErserve2());
        ps.setString(4, data.getUpdateUser());
        DateUtils.setDateTz(ps, 5, data.getUpdateTime());
        ps.setString(6, data.getCustomer());
        ps.setString(7, data.getOperationBo());
        ps.setString(8, data.getVolumeSize());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String customer, String operationBo, String volumeSize) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pkg_volume WHERE customer=? AND operation_bo=? AND volume_size=?")) {
      ps.setString(1, customer);
      ps.setString(2, operationBo);
      ps.setString(3, volumeSize);

      return ps.executeUpdate();
    }
  }

  public List<VeiwPkgVolume> selectAll() throws SQLException {
    ArrayList<VeiwPkgVolume> result = new ArrayList<VeiwPkgVolume>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public VeiwPkgVolume selectByPK(String customer, String operationBo, String volumeSize)
      throws SQLException {
    VeiwPkgVolume result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer=? AND operation_bo=? AND volume_size=?")) {
      ps.setString(1, customer);
      ps.setString(2, operationBo);
      ps.setString(3, volumeSize);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<VeiwPkgVolume> selectByCustomer(String customer, String operationBo)
      throws SQLException {
    List<VeiwPkgVolume> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer=?  and operation_bo like ? ")) {
      ps.setString(1, customer);
      ps.setString(2, operationBo + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<VeiwPkgVolume> selectByCustomerList(String customer) throws SQLException {
    List<VeiwPkgVolume> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer=? ")) {
      ps.setString(1, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private VeiwPkgVolume convert(ResultSet rs) throws SQLException {
    VeiwPkgVolume data = new VeiwPkgVolume();

    int index = 1;
    data.setCustomer(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOuterBox(rs.getString(index++));
    data.setVolumeSize(rs.getString(index++));
    data.setErserve1(rs.getString(index++));
    data.setErserve2(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
