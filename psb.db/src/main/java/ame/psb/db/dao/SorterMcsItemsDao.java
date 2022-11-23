package ame.psb.db.dao;

import ame.psb.db.SorterMcsItems;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class SorterMcsItemsDao {

  private static final String SQL_INS = "INSERT INTO zr_sorter_mcs_items(id,customer_item_bo,slot_no,carrier_bo_a,carrier_bo_b,carrier_bo_c,sfc_bo_a,sfc_bo_b,sfc_bo_c,new_flag_a,new_flag_b,new_flag_c,job_type,content_a,content_b,content_c,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sorter_mcs_items SET slot_no=?,carrier_bo_a=?,carrier_bo_b=?,carrier_bo_c=?,sfc_bo_a=?,sfc_bo_b=?,sfc_bo_c=?,new_flag_a=?,new_flag_b=?,new_flag_c=?,job_type=?,content_a=?,content_b=?,content_c=?,update_user=?,update_time=? WHERE id=? AND customer_item_bo=?";

  private static final String SQL_SEL = "SELECT id,customer_item_bo,slot_no,carrier_bo_a,carrier_bo_b,carrier_bo_c,sfc_bo_a,sfc_bo_b,sfc_bo_c,new_flag_a,new_flag_b,new_flag_c,job_type,content_a,content_b,content_c,update_user,update_time FROM zr_sorter_mcs_items ";

  private final Connection conn;

  public SorterMcsItemsDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SorterMcsItems data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getSlotNo());
      ps.setString(4, data.getCarrierBoA());
      ps.setString(5, data.getCarrierBoB());
      ps.setString(6, data.getCarrierBoC());
      ps.setString(7, data.getSfcBoA());
      ps.setString(8, data.getSfcBoB());
      ps.setString(9, data.getSfcBoC());
      ps.setString(10, data.getNewFlagA());
      ps.setString(11, data.getNewFlagB());
      ps.setString(12, data.getNewFlagC());
      ps.setString(13, data.getJobType());
      ps.setString(14, data.getContentA());
      ps.setString(15, data.getContentB());
      ps.setString(16, data.getContentC());
      ps.setString(17, data.getUpdateUser());
      DateUtils.setDateTz(ps, 18, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SorterMcsItems> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SorterMcsItems data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getCustomerItemBo());
        ps.setString(3, data.getSlotNo());
        ps.setString(4, data.getCarrierBoA());
        ps.setString(5, data.getCarrierBoB());
        ps.setString(6, data.getCarrierBoC());
        ps.setString(7, data.getSfcBoA());
        ps.setString(8, data.getSfcBoB());
        ps.setString(9, data.getSfcBoC());
        ps.setString(10, data.getNewFlagA());
        ps.setString(11, data.getNewFlagB());
        ps.setString(12, data.getNewFlagC());
        ps.setString(13, data.getJobType());
        ps.setString(14, data.getContentA());
        ps.setString(15, data.getContentB());
        ps.setString(16, data.getContentC());
        ps.setString(17, data.getUpdateUser());
        DateUtils.setDateTz(ps, 18, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SorterMcsItems data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSlotNo());
      ps.setString(2, data.getCarrierBoA());
      ps.setString(3, data.getCarrierBoB());
      ps.setString(4, data.getCarrierBoC());
      ps.setString(5, data.getSfcBoA());
      ps.setString(6, data.getSfcBoB());
      ps.setString(7, data.getSfcBoC());
      ps.setString(8, data.getNewFlagA());
      ps.setString(9, data.getNewFlagB());
      ps.setString(10, data.getNewFlagC());
      ps.setString(11, data.getJobType());
      ps.setString(12, data.getContentA());
      ps.setString(13, data.getContentB());
      ps.setString(14, data.getContentC());
      ps.setString(15, data.getUpdateUser());
      DateUtils.setDateTz(ps, 16, data.getUpdateTime());
      ps.setString(17, data.getId());
      ps.setString(18, data.getCustomerItemBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<SorterMcsItems> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SorterMcsItems data : dataList) {
        ps.setString(1, data.getSlotNo());
        ps.setString(2, data.getCarrierBoA());
        ps.setString(3, data.getCarrierBoB());
        ps.setString(4, data.getCarrierBoC());
        ps.setString(5, data.getSfcBoA());
        ps.setString(6, data.getSfcBoB());
        ps.setString(7, data.getSfcBoC());
        ps.setString(8, data.getNewFlagA());
        ps.setString(9, data.getNewFlagB());
        ps.setString(10, data.getNewFlagC());
        ps.setString(11, data.getJobType());
        ps.setString(12, data.getContentA());
        ps.setString(13, data.getContentB());
        ps.setString(14, data.getContentC());
        ps.setString(15, data.getUpdateUser());
        DateUtils.setDateTz(ps, 16, data.getUpdateTime());
        ps.setString(17, data.getId());
        ps.setString(18, data.getCustomerItemBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id, String customerItemBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sorter_mcs_items WHERE id=? AND customer_item_bo=?")) {
      ps.setString(1, id);
      ps.setString(2, customerItemBo);

      return ps.executeUpdate();
    }
  }

  public List<SorterMcsItems> selectAll() throws SQLException {
    ArrayList<SorterMcsItems> result = new ArrayList<SorterMcsItems>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SorterMcsItems> selectById(String id) throws SQLException {
    ArrayList<SorterMcsItems> result = new ArrayList<SorterMcsItems>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SorterMcsItems selectByPK(String id, String customerItemBo) throws SQLException {
    SorterMcsItems result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND customer_item_bo=?")) {
      ps.setString(1, id);
      ps.setString(2, customerItemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SorterMcsItems convert(ResultSet rs) throws SQLException {
    SorterMcsItems data = new SorterMcsItems();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setCarrierBoA(rs.getString(index++));
    data.setCarrierBoB(rs.getString(index++));
    data.setCarrierBoC(rs.getString(index++));
    data.setSfcBoA(rs.getString(index++));
    data.setSfcBoB(rs.getString(index++));
    data.setSfcBoC(rs.getString(index++));
    data.setNewFlagA(rs.getString(index++));
    data.setNewFlagB(rs.getString(index++));
    data.setNewFlagC(rs.getString(index++));
    data.setJobType(rs.getString(index++));
    data.setContentA(rs.getString(index++));
    data.setContentB(rs.getString(index++));
    data.setContentC(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
