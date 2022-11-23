package ame.psb.db.dao;

import ame.psb.db.ReelCarrierLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ReelCarrierLogDao {

  private static final String SQL_INS = "INSERT INTO zr_reel_carrier_log(uuid,carrier_bo,carrier_state,reel_id,container_name,item_group_name,item_name,cust_lot,cust,wafers,reason,reverse_field1,reverse_field2,reverse_field3,reverse_field4,reverse_field5,modified_user,modified_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_reel_carrier_log SET carrier_bo=?,carrier_state=?,reel_id=?,container_name=?,item_group_name=?,item_name=?,cust_lot=?,cust=?,wafers=?,reason=?,reverse_field1=?,reverse_field2=?,reverse_field3=?,reverse_field4=?,reverse_field5=?,modified_user=?,modified_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,carrier_bo,carrier_state,reel_id,container_name,item_group_name,item_name,cust_lot,cust,wafers,reason,reverse_field1,reverse_field2,reverse_field3,reverse_field4,reverse_field5,modified_user,modified_time FROM zr_reel_carrier_log ";

  private final Connection conn;

  public ReelCarrierLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReelCarrierLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getCarrierBo());
      ps.setString(3, data.getCarrierState());
      ps.setString(4, data.getReelId());
      ps.setString(5, data.getContainerName());
      ps.setString(6, data.getItemGroupName());
      ps.setString(7, data.getItemName());
      ps.setString(8, data.getCustLot());
      ps.setString(9, data.getCust());
      ps.setString(10, data.getWafers());
      ps.setString(11, data.getReason());
      ps.setString(12, data.getReverseField1());
      ps.setString(13, data.getReverseField2());
      ps.setString(14, data.getReverseField3());
      ps.setString(15, data.getReverseField4());
      ps.setString(16, data.getReverseField5());
      ps.setString(17, data.getModifiedUser());
      DateUtils.setDateTz(ps, 18, data.getModifiedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReelCarrierLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReelCarrierLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getCarrierBo());
        ps.setString(3, data.getCarrierState());
        ps.setString(4, data.getReelId());
        ps.setString(5, data.getContainerName());
        ps.setString(6, data.getItemGroupName());
        ps.setString(7, data.getItemName());
        ps.setString(8, data.getCustLot());
        ps.setString(9, data.getCust());
        ps.setString(10, data.getWafers());
        ps.setString(11, data.getReason());
        ps.setString(12, data.getReverseField1());
        ps.setString(13, data.getReverseField2());
        ps.setString(14, data.getReverseField3());
        ps.setString(15, data.getReverseField4());
        ps.setString(16, data.getReverseField5());
        ps.setString(17, data.getModifiedUser());
        DateUtils.setDateTz(ps, 18, data.getModifiedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReelCarrierLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCarrierBo());
      ps.setString(2, data.getCarrierState());
      ps.setString(3, data.getReelId());
      ps.setString(4, data.getContainerName());
      ps.setString(5, data.getItemGroupName());
      ps.setString(6, data.getItemName());
      ps.setString(7, data.getCustLot());
      ps.setString(8, data.getCust());
      ps.setString(9, data.getWafers());
      ps.setString(10, data.getReason());
      ps.setString(11, data.getReverseField1());
      ps.setString(12, data.getReverseField2());
      ps.setString(13, data.getReverseField3());
      ps.setString(14, data.getReverseField4());
      ps.setString(15, data.getReverseField5());
      ps.setString(16, data.getModifiedUser());
      DateUtils.setDateTz(ps, 17, data.getModifiedTime());
      ps.setString(18, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReelCarrierLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReelCarrierLog data : dataList) {
        ps.setString(1, data.getCarrierBo());
        ps.setString(2, data.getCarrierState());
        ps.setString(3, data.getReelId());
        ps.setString(4, data.getContainerName());
        ps.setString(5, data.getItemGroupName());
        ps.setString(6, data.getItemName());
        ps.setString(7, data.getCustLot());
        ps.setString(8, data.getCust());
        ps.setString(9, data.getWafers());
        ps.setString(10, data.getReason());
        ps.setString(11, data.getReverseField1());
        ps.setString(12, data.getReverseField2());
        ps.setString(13, data.getReverseField3());
        ps.setString(14, data.getReverseField4());
        ps.setString(15, data.getReverseField5());
        ps.setString(16, data.getModifiedUser());
        DateUtils.setDateTz(ps, 17, data.getModifiedTime());
        ps.setString(18, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_reel_carrier_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<ReelCarrierLog> selectAll() throws SQLException {
    ArrayList<ReelCarrierLog> result = new ArrayList<ReelCarrierLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReelCarrierLog selectByPK(String uuid) throws SQLException {
    ReelCarrierLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ReelCarrierLog> selectByReelId(String reelId) throws SQLException {
    ArrayList<ReelCarrierLog> result = new ArrayList<ReelCarrierLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reel_id=? AND carrier_state in('IN','OUT') ")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ReelCarrierLog convert(ResultSet rs) throws SQLException {
    ReelCarrierLog data = new ReelCarrierLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierState(rs.getString(index++));
    data.setReelId(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setCustLot(rs.getString(index++));
    data.setCust(rs.getString(index++));
    data.setWafers(rs.getString(index++));
    data.setReason(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setReverseField3(rs.getString(index++));
    data.setReverseField4(rs.getString(index++));
    data.setReverseField5(rs.getString(index++));
    data.setModifiedUser(rs.getString(index++));
    data.setModifiedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
