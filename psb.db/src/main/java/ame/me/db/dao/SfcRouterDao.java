package ame.me.db.dao;

import ame.me.db.SfcRouter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SfcRouterDao {

  private static final String SQL_INS = "INSERT INTO sfc_router(handle,sfc_routing_bo,router_bo,sequence,in_use,completed,sub_router,qty,reworked_from_sfc_step_bo,return_type,sub_type,partition_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE sfc_router SET sfc_routing_bo=?,router_bo=?,sequence=?,in_use=?,completed=?,sub_router=?,qty=?,reworked_from_sfc_step_bo=?,return_type=?,sub_type=?,partition_date=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,sfc_routing_bo,router_bo,sequence,in_use,completed,sub_router,qty,reworked_from_sfc_step_bo,return_type,sub_type,partition_date FROM sfc_router ";

  private static final String SQL_UPD_QTY = "UPDATE sfc_router SET qty=?  WHERE handle=?";

  private static final String SQL_UPD_REVERSE = "UPDATE sfc_router SET IN_USE ='true', COMPLETED ='false'  WHERE handle=?";

  private final Connection conn;

  public SfcRouterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcRouter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSfcRoutingBo());
      ps.setString(3, data.getRouterBo());
      ps.setBigDecimal(4, data.getSequence());
      ps.setString(5, data.getInUse());
      ps.setString(6, data.getCompleted());
      ps.setString(7, data.getSubRouter());
      ps.setBigDecimal(8, data.getQty());
      ps.setString(9, data.getReworkedFromSfcStepBo());
      ps.setString(10, data.getReturnType());
      ps.setString(11, data.getSubType());
      ps.setTimestamp(12, new Timestamp(data.getPartitionDate().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<SfcRouter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SfcRouter data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSfcRoutingBo());
        ps.setString(3, data.getRouterBo());
        ps.setBigDecimal(4, data.getSequence());
        ps.setString(5, data.getInUse());
        ps.setString(6, data.getCompleted());
        ps.setString(7, data.getSubRouter());
        ps.setBigDecimal(8, data.getQty());
        ps.setString(9, data.getReworkedFromSfcStepBo());
        ps.setString(10, data.getReturnType());
        ps.setString(11, data.getSubType());
        ps.setTimestamp(12, new Timestamp(data.getPartitionDate().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SfcRouter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcRoutingBo());
      ps.setString(2, data.getRouterBo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getInUse());
      ps.setString(5, data.getCompleted());
      ps.setString(6, data.getSubRouter());
      ps.setBigDecimal(7, data.getQty());
      ps.setString(8, data.getReworkedFromSfcStepBo());
      ps.setString(9, data.getReturnType());
      ps.setString(10, data.getSubType());
      ps.setTimestamp(11, new Timestamp(data.getPartitionDate().getTime()));
      ps.setString(12, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(SfcRouter data, String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcRoutingBo());
      ps.setString(2, data.getRouterBo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getInUse());
      ps.setString(5, data.getCompleted());
      ps.setString(6, data.getSubRouter());
      ps.setBigDecimal(7, data.getQty());
      ps.setString(8, data.getReworkedFromSfcStepBo());
      ps.setString(9, data.getReturnType());
      ps.setString(10, data.getSubType());
      ps.setTimestamp(11, new Timestamp(data.getPartitionDate().getTime()));
      ps.setString(12, handle);

      return ps.executeUpdate();
    }
  }

  public int updateQty(BigDecimal qty, String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_QTY)) {
      ps.setBigDecimal(1, qty);
      ps.setString(2, handle);
      return ps.executeUpdate();
    }
  }

  public int updateForReverse(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_REVERSE)) {
      //ps.setBigDecimal(1, qty);
      ps.setString(1, handle);
      return ps.executeUpdate();
    }
  }

  public int update(List<SfcRouter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SfcRouter data : dataList) {
        ps.setString(1, data.getSfcRoutingBo());
        ps.setString(2, data.getRouterBo());
        ps.setBigDecimal(3, data.getSequence());
        ps.setString(4, data.getInUse());
        ps.setString(5, data.getCompleted());
        ps.setString(6, data.getSubRouter());
        ps.setBigDecimal(7, data.getQty());
        ps.setString(8, data.getReworkedFromSfcStepBo());
        ps.setString(9, data.getReturnType());
        ps.setString(10, data.getSubType());
        ps.setTimestamp(11, new Timestamp(data.getPartitionDate().getTime()));
        ps.setString(12, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM sfc_router WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<SfcRouter> selectAll() throws SQLException {
    ArrayList<SfcRouter> result = new ArrayList<SfcRouter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SfcRouter selectByPK(String handle) throws SQLException {
    SfcRouter result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SfcRouter selectBySfcRoutingBo(String handle) throws SQLException {
    SfcRouter result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SFC_ROUTING_BO=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SfcRouter convert(ResultSet rs) throws SQLException {
    SfcRouter data = new SfcRouter();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSfcRoutingBo(rs.getString(index++));
    data.setRouterBo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setInUse(rs.getString(index++));
    data.setCompleted(rs.getString(index++));
    data.setSubRouter(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setReworkedFromSfcStepBo(rs.getString(index++));
    data.setReturnType(rs.getString(index++));
    data.setSubType(rs.getString(index++));
    data.setPartitionDate(rs.getTimestamp(index++));

    return data;
  }
}
