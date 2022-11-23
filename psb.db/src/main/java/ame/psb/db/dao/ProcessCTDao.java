package ame.psb.db.dao;

import ame.psb.db.ProcessCT;
import ame.psb.db.SODUpdateDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ProcessCTDao {

  private static final String SQL_INS = "INSERT INTO zd_process_ct(shop_order_bo,bumping_sod,cp_sod,wlp_sod,fc_sod,created_time,updated_time,updated_user) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_process_ct SET bumping_sod=?,cp_sod=?,wlp_sod=?,fc_sod=?,created_time=?,updated_time=?,updated_user=? WHERE shop_order_bo=?";

  private static final String SQL_SEL = "SELECT shop_order_bo,bumping_sod,cp_sod,wlp_sod,fc_sod,created_time,updated_time,updated_user FROM zd_process_ct ";

  private final Connection conn;

  public ProcessCTDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ProcessCT data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getShopOrderBo());
      DateUtils.setDateTz(ps, 2, data.getBumpingSod());
      DateUtils.setDateTz(ps, 3, data.getCpSod());
      DateUtils.setDateTz(ps, 4, data.getWlpSod());
      DateUtils.setDateTz(ps, 5, data.getFcSod());
      DateUtils.setDateTz(ps, 6, data.getCreatedTime());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getUpdatedUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ProcessCT> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ProcessCT data : dataList) {
        ps.setString(1, data.getShopOrderBo());
        DateUtils.setDateTz(ps, 2, data.getBumpingSod());
        DateUtils.setDateTz(ps, 3, data.getCpSod());
        DateUtils.setDateTz(ps, 4, data.getWlpSod());
        DateUtils.setDateTz(ps, 5, data.getFcSod());
        DateUtils.setDateTz(ps, 6, data.getCreatedTime());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getUpdatedUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ProcessCT data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      DateUtils.setDateTz(ps, 1, data.getBumpingSod());
      DateUtils.setDateTz(ps, 2, data.getCpSod());
      DateUtils.setDateTz(ps, 3, data.getWlpSod());
      DateUtils.setDateTz(ps, 4, data.getFcSod());
      DateUtils.setDateTz(ps, 5, data.getCreatedTime());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getUpdatedUser());
      ps.setString(8, data.getShopOrderBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<ProcessCT> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ProcessCT data : dataList) {
        DateUtils.setDateTz(ps, 1, data.getBumpingSod());
        DateUtils.setDateTz(ps, 2, data.getCpSod());
        DateUtils.setDateTz(ps, 3, data.getWlpSod());
        DateUtils.setDateTz(ps, 4, data.getFcSod());
        DateUtils.setDateTz(ps, 5, data.getCreatedTime());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getUpdatedUser());
        ps.setString(8, data.getShopOrderBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String shopOrderBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_process_ct WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      return ps.executeUpdate();
    }
  }

  public List<ProcessCT> selectAll() throws SQLException {
    ArrayList<ProcessCT> result = new ArrayList<ProcessCT>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ProcessCT selectByPK(String shopOrderBo) throws SQLException {
    ProcessCT result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE shop_order_bo=?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  //UPDATE ZD_PROCESS_CT SET BUMPING_SOD = ' EXCEL里面的SOD ' WHERE SHOP_ORDER_BO  IN (SELECT SHOP_ORDER_BO FROM VIEW_SFC WHERE SFC_NAME IN (EXCEL里面的SFC))

  public int updateSod2(List<SODUpdateDetail> details) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE ZD_PROCESS_CT SET BUMPING_SOD = ? WHERE SHOP_ORDER_BO = (SELECT SHOP_ORDER_BO FROM VIEW_SFC WHERE SFC_NAME = ?)")) {
      for (SODUpdateDetail detail : details) {
        DateUtils.setDateTz(ps, 1, detail.getSod());
        ps.setString(2, detail.getSfc());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  private ProcessCT convert(ResultSet rs) throws SQLException {
    ProcessCT data = new ProcessCT();

    int index = 1;
    data.setShopOrderBo(rs.getString(index++));
    data.setBumpingSod(DateUtils.getDateTz(rs, index++));
    data.setCpSod(DateUtils.getDateTz(rs, index++));
    data.setWlpSod(DateUtils.getDateTz(rs, index++));
    data.setFcSod(DateUtils.getDateTz(rs, index++));
    data.setCreatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));

    return data;
  }
}
