package ame.psb.db.dao;

import ame.psb.db.RunSplitMergeItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunSplitMergeItemDao {

  private static final String SQL_INS = "INSERT INTO zr_run_split_merge_item(id,run_bo,sfc_bo,customer_item_bo,slot_no,run_time,run_user) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id,run_bo,sfc_bo,customer_item_bo,slot_no,run_time,run_user FROM zr_run_split_merge_item ";

  private final Connection conn;

  public RunSplitMergeItemDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunSplitMergeItem data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getRunBo());
      ps.setString(3, data.getSfcBo());
      ps.setString(4, data.getCustomerItemBo());
      ps.setBigDecimal(5, data.getSlotNo());
      DateUtils.setDateTz(ps, 6, data.getRunTime());
      ps.setString(7, data.getRunUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunSplitMergeItem> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunSplitMergeItem data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getRunBo());
        ps.setString(3, data.getSfcBo());
        ps.setString(4, data.getCustomerItemBo());
        ps.setBigDecimal(5, data.getSlotNo());
        DateUtils.setDateTz(ps, 6, data.getRunTime());
        ps.setString(7, data.getRunUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public List<RunSplitMergeItem> selectAll() throws SQLException {
    ArrayList<RunSplitMergeItem> result = new ArrayList<RunSplitMergeItem>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public RunSplitMergeItem selectByPK(String id) throws SQLException {
    RunSplitMergeItem result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private RunSplitMergeItem convert(ResultSet rs) throws SQLException {
    RunSplitMergeItem data = new RunSplitMergeItem();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setRunBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setSlotNo(rs.getBigDecimal(index++));
    data.setRunTime(DateUtils.getDateTz(rs, index++));
    data.setRunUser(rs.getString(index++));

    return data;
  }
}