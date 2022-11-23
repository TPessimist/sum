package ame.me.db.dao;

import ame.me.db.Sfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SfcDao {

  private static final String SQL_INS = "INSERT INTO sfc(handle,change_stamp,site,sfc,status_bo,shop_order_bo,qty,qty_done,qty_scrapped,qty_historical_min,qty_historical_max,item_bo,priority,location,rma_max_times_processed,lcc_bo,original_status_bo,qty_mult_performed,actual_comp_date,prev_site,original_transfer_key,immediate_archive,transfer_datetime,transfer_user,sn_done,created_date_time,modified_date_time,partition_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE sfc SET change_stamp=?,site=?,sfc=?,status_bo=?,shop_order_bo=?,qty=?,qty_done=?,qty_scrapped=?,qty_historical_min=?,qty_historical_max=?,item_bo=?,priority=?,location=?,rma_max_times_processed=?,lcc_bo=?,original_status_bo=?,qty_mult_performed=?,actual_comp_date=?,prev_site=?,original_transfer_key=?,immediate_archive=?,transfer_datetime=?,transfer_user=?,sn_done=?,created_date_time=?,modified_date_time=?,partition_date=? WHERE handle=?";

  private static final String SQL_UPD_QTY = "UPDATE sfc SET  qty=?   WHERE handle=?";

  private static final String SQL_UPD_STA = "UPDATE sfc SET  status_bo=?   WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,sfc,status_bo,shop_order_bo,qty,qty_done,qty_scrapped,qty_historical_min,qty_historical_max,item_bo,priority,location,rma_max_times_processed,lcc_bo,original_status_bo,qty_mult_performed,actual_comp_date,prev_site,original_transfer_key,immediate_archive,transfer_datetime,transfer_user,sn_done,created_date_time,modified_date_time,partition_date FROM sfc ";

  private final Connection conn;

  public SfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Sfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getSfc());
      ps.setString(5, data.getStatusBo());
      ps.setString(6, data.getShopOrderBo());
      ps.setBigDecimal(7, data.getQty());
      ps.setBigDecimal(8, data.getQtyDone());
      ps.setBigDecimal(9, data.getQtyScrapped());
      ps.setBigDecimal(10, data.getQtyHistoricalMin());
      ps.setBigDecimal(11, data.getQtyHistoricalMax());
      ps.setString(12, data.getItemBo());
      ps.setBigDecimal(13, data.getPriority());
      ps.setString(14, data.getLocation());
      ps.setBigDecimal(15, data.getRmaMaxTimesProcessed());
      ps.setString(16, data.getLccBo());
      ps.setString(17, data.getOriginalStatusBo());
      ps.setString(18, data.getQtyMultPerformed());
      ps.setTimestamp(19, new Timestamp(data.getActualCompDate().getTime()));
      ps.setString(20, data.getPrevSite());
      ps.setString(21, data.getOriginalTransferKey());
      ps.setString(22, data.getImmediateArchive());
      ps.setTimestamp(23, new Timestamp(data.getTransferDatetime().getTime()));
      ps.setString(24, data.getTransferUser());
      ps.setString(25, data.getSnDone());
      ps.setTimestamp(26, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(27, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setTimestamp(28, new Timestamp(data.getPartitionDate().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<Sfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Sfc data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setBigDecimal(2, data.getChangeStamp());
        ps.setString(3, data.getSite());
        ps.setString(4, data.getSfc());
        ps.setString(5, data.getStatusBo());
        ps.setString(6, data.getShopOrderBo());
        ps.setBigDecimal(7, data.getQty());
        ps.setBigDecimal(8, data.getQtyDone());
        ps.setBigDecimal(9, data.getQtyScrapped());
        ps.setBigDecimal(10, data.getQtyHistoricalMin());
        ps.setBigDecimal(11, data.getQtyHistoricalMax());
        ps.setString(12, data.getItemBo());
        ps.setBigDecimal(13, data.getPriority());
        ps.setString(14, data.getLocation());
        ps.setBigDecimal(15, data.getRmaMaxTimesProcessed());
        ps.setString(16, data.getLccBo());
        ps.setString(17, data.getOriginalStatusBo());
        ps.setString(18, data.getQtyMultPerformed());
        ps.setTimestamp(19, new Timestamp(data.getActualCompDate().getTime()));
        ps.setString(20, data.getPrevSite());
        ps.setString(21, data.getOriginalTransferKey());
        ps.setString(22, data.getImmediateArchive());
        ps.setTimestamp(23, new Timestamp(data.getTransferDatetime().getTime()));
        ps.setString(24, data.getTransferUser());
        ps.setString(25, data.getSnDone());
        ps.setTimestamp(26, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(27, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setTimestamp(28, new Timestamp(data.getPartitionDate().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Sfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getChangeStamp());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getSfc());
      ps.setString(4, data.getStatusBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setBigDecimal(6, data.getQty());
      ps.setBigDecimal(7, data.getQtyDone());
      ps.setBigDecimal(8, data.getQtyScrapped());
      ps.setBigDecimal(9, data.getQtyHistoricalMin());
      ps.setBigDecimal(10, data.getQtyHistoricalMax());
      ps.setString(11, data.getItemBo());
      ps.setBigDecimal(12, data.getPriority());
      ps.setString(13, data.getLocation());
      ps.setBigDecimal(14, data.getRmaMaxTimesProcessed());
      ps.setString(15, data.getLccBo());
      ps.setString(16, data.getOriginalStatusBo());
      ps.setString(17, data.getQtyMultPerformed());
      //ps.setTimestamp(18, new Timestamp(data.getActualCompDate().getTime()));
      ps.setString(19, data.getPrevSite());
      ps.setString(20, data.getOriginalTransferKey());
      ps.setString(21, data.getImmediateArchive());
      //ps.setTimestamp(22, new Timestamp(data.getTransferDatetime().getTime()));
      ps.setString(23, data.getTransferUser());
      ps.setString(24, data.getSnDone());
      //ps.setTimestamp(25, new Timestamp(data.getCreatedDateTime().getTime()));
      //ps.setTimestamp(26, new Timestamp(data.getModifiedDateTime().getTime()));
      //ps.setTimestamp(27, new Timestamp(data.getPartitionDate().getTime()));
      //ps.setString(28, data.getHandle());

      return ps.executeUpdate();
    }
  }


  public int updateQty(Sfc data) throws SQLException {

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_QTY)) {
      ps.setBigDecimal(1, data.getQty());
      ps.setString(2, data.getHandle());
      return ps.executeUpdate();
    }

  }

  public int updateState(String state, String handle) throws SQLException {

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_STA)) {
      ps.setString(1, state);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }

  }


  public int update(List<Sfc> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Sfc data : dataList) {
        ps.setBigDecimal(1, data.getChangeStamp());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getSfc());
        ps.setString(4, data.getStatusBo());
        ps.setString(5, data.getShopOrderBo());
        ps.setBigDecimal(6, data.getQty());
        ps.setBigDecimal(7, data.getQtyDone());
        ps.setBigDecimal(8, data.getQtyScrapped());
        ps.setBigDecimal(9, data.getQtyHistoricalMin());
        ps.setBigDecimal(10, data.getQtyHistoricalMax());
        ps.setString(11, data.getItemBo());
        ps.setBigDecimal(12, data.getPriority());
        ps.setString(13, data.getLocation());
        ps.setBigDecimal(14, data.getRmaMaxTimesProcessed());
        ps.setString(15, data.getLccBo());
        ps.setString(16, data.getOriginalStatusBo());
        ps.setString(17, data.getQtyMultPerformed());
        ps.setTimestamp(18, new Timestamp(data.getActualCompDate().getTime()));
        ps.setString(19, data.getPrevSite());
        ps.setString(20, data.getOriginalTransferKey());
        ps.setString(21, data.getImmediateArchive());
        ps.setTimestamp(22, new Timestamp(data.getTransferDatetime().getTime()));
        ps.setString(23, data.getTransferUser());
        ps.setString(24, data.getSnDone());
        ps.setTimestamp(25, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(26, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setTimestamp(27, new Timestamp(data.getPartitionDate().getTime()));
        ps.setString(28, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM sfc WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public int updateStatusBo(String handle, String statusBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE WIP.SFC SET STATUS_BO=? WHERE HANDLE=?")) {
      ps.setString(1, statusBo);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }
  }

  public List<Sfc> selectAll() throws SQLException {
    ArrayList<Sfc> result = new ArrayList<Sfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Sfc> selectByShopOrderBO(String shopOrderBO) throws SQLException {
    ArrayList<Sfc> result = new ArrayList<Sfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SHOP_ORDER_BO=?")) {
      ps.setString(1, shopOrderBO);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Sfc selectByPK(String handle) throws SQLException {
    Sfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Sfc convert(ResultSet rs) throws SQLException {
    Sfc data = new Sfc();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setQtyDone(rs.getBigDecimal(index++));
    data.setQtyScrapped(rs.getBigDecimal(index++));
    data.setQtyHistoricalMin(rs.getBigDecimal(index++));
    data.setQtyHistoricalMax(rs.getBigDecimal(index++));
    data.setItemBo(rs.getString(index++));
    data.setPriority(rs.getBigDecimal(index++));
    data.setLocation(rs.getString(index++));
    data.setRmaMaxTimesProcessed(rs.getBigDecimal(index++));
    data.setLccBo(rs.getString(index++));
    data.setOriginalStatusBo(rs.getString(index++));
    data.setQtyMultPerformed(rs.getString(index++));
    data.setActualCompDate(rs.getTimestamp(index++));
    data.setPrevSite(rs.getString(index++));
    data.setOriginalTransferKey(rs.getString(index++));
    data.setImmediateArchive(rs.getString(index++));
    data.setTransferDatetime(rs.getTimestamp(index++));
    data.setTransferUser(rs.getString(index++));
    data.setSnDone(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));
    data.setPartitionDate(rs.getTimestamp(index++));

    return data;
  }
}
