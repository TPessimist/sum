package ame.psb.db.dao;

import ame.psb.db.FtPassHoldRelease;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtPassHoldReleaseDao {

  private static final String SQL_INS = "INSERT INTO zr_ft_pass_hold_release(id,sfc_bo,shop_order_bo,sfc_name,shop_order_name,operation_bo,qe_pass_flag,engineer_pass_flag,qe_pass_user,engineer_pass_user,customer_pass_flag,custoemr,update_user,update_time,reserve1,reserve2,status,hold_code,hold_comment) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_ft_pass_hold_release SET sfc_bo=?,shop_order_bo=?,sfc_name=?,shop_order_name=?,operation_bo=?,qe_pass_flag=?,engineer_pass_flag=?,qe_pass_user=?,engineer_pass_user=?,customer_pass_flag=?,custoemr=?,update_user=?,update_time=?,reserve1=?,reserve2=?,status=?,hold_code=?,hold_comment=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,shop_order_bo,sfc_name,shop_order_name,operation_bo,qe_pass_flag,engineer_pass_flag,qe_pass_user,engineer_pass_user,customer_pass_flag,custoemr,update_user,update_time,reserve1,reserve2,status,hold_code,hold_comment FROM zr_ft_pass_hold_release ";

  private final Connection conn;

  public FtPassHoldReleaseDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtPassHoldRelease data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getSfcName());
      ps.setString(5, data.getShopOrderName());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getQePassFlag());
      ps.setString(8, data.getEngineerPassFlag());
      ps.setString(9, data.getQePassUser());
      ps.setString(10, data.getEngineerPassUser());
      ps.setString(11, data.getCustomerPassFlag());
      ps.setString(12, data.getCustoemr());
      ps.setString(13, data.getUpdateUser());
      DateUtils.setDateTz(ps, 14, data.getUpdateTime());
      ps.setString(15, data.getReserve1());
      ps.setString(16, data.getReserve2());
      ps.setString(17, data.getStatus());
      ps.setString(18, data.getHoldCode());
      ps.setString(19, data.getHoldComment());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FtPassHoldRelease> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtPassHoldRelease data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getSfcName());
        ps.setString(5, data.getShopOrderName());
        ps.setString(6, data.getOperationBo());
        ps.setString(7, data.getQePassFlag());
        ps.setString(8, data.getEngineerPassFlag());
        ps.setString(9, data.getQePassUser());
        ps.setString(10, data.getEngineerPassUser());
        ps.setString(11, data.getCustomerPassFlag());
        ps.setString(12, data.getCustoemr());
        ps.setString(13, data.getUpdateUser());
        DateUtils.setDateTz(ps, 14, data.getUpdateTime());
        ps.setString(15, data.getReserve1());
        ps.setString(16, data.getReserve2());
        ps.setString(17, data.getStatus());
        ps.setString(18, data.getHoldCode());
        ps.setString(19, data.getHoldComment());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtPassHoldRelease data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getSfcName());
      ps.setString(4, data.getShopOrderName());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getQePassFlag());
      ps.setString(7, data.getEngineerPassFlag());
      ps.setString(8, data.getQePassUser());
      ps.setString(9, data.getEngineerPassUser());
      ps.setString(10, data.getCustomerPassFlag());
      ps.setString(11, data.getCustoemr());
      ps.setString(12, data.getUpdateUser());
      DateUtils.setDateTz(ps, 13, data.getUpdateTime());
      ps.setString(14, data.getReserve1());
      ps.setString(15, data.getReserve2());
      ps.setString(16, data.getStatus());
      ps.setString(17, data.getHoldCode());
      ps.setString(18, data.getHoldComment());
      ps.setString(19, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FtPassHoldRelease> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtPassHoldRelease data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getSfcName());
        ps.setString(4, data.getShopOrderName());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getQePassFlag());
        ps.setString(7, data.getEngineerPassFlag());
        ps.setString(8, data.getQePassUser());
        ps.setString(9, data.getEngineerPassUser());
        ps.setString(10, data.getCustomerPassFlag());
        ps.setString(11, data.getCustoemr());
        ps.setString(12, data.getUpdateUser());
        DateUtils.setDateTz(ps, 13, data.getUpdateTime());
        ps.setString(14, data.getReserve1());
        ps.setString(15, data.getReserve2());
        ps.setString(16, data.getStatus());
        ps.setString(17, data.getHoldCode());
        ps.setString(18, data.getHoldComment());
        ps.setString(19, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_ft_pass_hold_release WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int updateSetStatus(String status, String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_ft_pass_hold_release SET status =? WHERE id=?")) {
      ps.setString(1, status);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public int updateById(String engineerPassFlag, String engineerPassUser, Date updateTime,
      String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zr_ft_pass_hold_release SET engineer_pass_flag=?, engineer_pass_user =?,update_time=? WHERE id=?")) {
      ps.setString(1, engineerPassFlag);
      ps.setString(2, engineerPassUser);
      DateUtils.setDateTz(ps, 3, updateTime);
      ps.setString(4, id);
      return ps.executeUpdate();
    }
  }

  public List<FtPassHoldRelease> selectAll() throws SQLException {
    ArrayList<FtPassHoldRelease> result = new ArrayList<FtPassHoldRelease>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtPassHoldRelease selectByPK(String id) throws SQLException {
    FtPassHoldRelease result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtPassHoldRelease selectBySfcAndShopOrderAndTwoFlag(String sfc, String shopOrder,
      String engineerPassFlag, String qeFlag)
      throws SQLException {
    FtPassHoldRelease result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE sfc_bo=? and shop_order_bo=? and engineer_pass_flag=? and qe_pass_flag=? order by update_time desc ")) {
      ps.setString(1, sfc);
      ps.setString(2, shopOrder);
      ps.setString(3, engineerPassFlag);
      ps.setString(4, qeFlag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtPassHoldRelease selectBySfcAndShopOrderAndEngineerFlag(String sfc, String shopOrder,
      String engineerPassFlag)
      throws SQLException {
    FtPassHoldRelease result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE sfc_bo=? and shop_order_bo=? and engineer_pass_flag=? and qe_pass_flag is null order by update_time desc ")) {
      ps.setString(1, sfc);
      ps.setString(2, shopOrder);
      ps.setString(3, engineerPassFlag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public FtPassHoldRelease selectBySfcAndShopOrder(String sfcBo, String shopOrderBo)
      throws SQLException {
    FtPassHoldRelease result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE sfc_bo=? and shop_order_bo=? order by update_time desc ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FtPassHoldRelease> selectAllByFlag(String engineerFlag)
      throws SQLException {
    ArrayList<FtPassHoldRelease> result = new ArrayList<FtPassHoldRelease>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE engineer_pass_flag=? AND qe_pass_flag is null ")) {
      ps.setString(1, engineerFlag);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FtPassHoldRelease convert(ResultSet rs) throws SQLException {
    FtPassHoldRelease data = new FtPassHoldRelease();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setQePassFlag(rs.getString(index++));
    data.setEngineerPassFlag(rs.getString(index++));
    data.setQePassUser(rs.getString(index++));
    data.setEngineerPassUser(rs.getString(index++));
    data.setCustomerPassFlag(rs.getString(index++));
    data.setCustoemr(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setHoldCode(rs.getString(index++));
    data.setHoldComment(rs.getString(index++));

    return data;
  }
}
