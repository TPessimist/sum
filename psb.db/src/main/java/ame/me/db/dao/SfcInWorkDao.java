package ame.me.db.dao;

import ame.me.db.SfcInWork;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SfcInWorkDao {

  private static final String SQL_INS = "INSERT INTO sfc_in_work(handle,sfc_step_bo,owner_gbo,paused,resource_bo,work_center_bo,qty_in_work,date_started,rework,user_bo) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE sfc_in_work SET sfc_step_bo=?,owner_gbo=?,paused=?,resource_bo=?,work_center_bo=?,qty_in_work=?,date_started=?,rework=?,user_bo=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,sfc_step_bo,owner_gbo,paused,resource_bo,work_center_bo,qty_in_work,date_started,rework,user_bo FROM sfc_in_work ";

  private static final String SQL_UPD_INWORKQTY = "UPDATE sfc_in_work SET  qty_in_work=?  WHERE sfc_step_bo=?";


  private final Connection conn;

  public SfcInWorkDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SfcInWork data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSfcStepBo());
      ps.setString(3, data.getOwnerGbo());
      ps.setString(4, data.getPaused());
      ps.setString(5, data.getResourceBo());
      ps.setString(6, data.getWorkCenterBo());
      ps.setBigDecimal(7, data.getQtyInWork());
      ps.setTimestamp(8, new Timestamp(data.getDateStarted().getTime()));
      ps.setString(9, data.getRework());
      ps.setString(10, data.getUserBo());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SfcInWork> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SfcInWork data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getSfcStepBo());
        ps.setString(3, data.getOwnerGbo());
        ps.setString(4, data.getPaused());
        ps.setString(5, data.getResourceBo());
        ps.setString(6, data.getWorkCenterBo());
        ps.setBigDecimal(7, data.getQtyInWork());
        ps.setTimestamp(8, new Timestamp(data.getDateStarted().getTime()));
        ps.setString(9, data.getRework());
        ps.setString(10, data.getUserBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SfcInWork data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcStepBo());
      ps.setString(2, data.getOwnerGbo());
      ps.setString(3, data.getPaused());
      ps.setString(4, data.getResourceBo());
      ps.setString(5, data.getWorkCenterBo());
      ps.setBigDecimal(6, data.getQtyInWork());
      ps.setTimestamp(7, new Timestamp(data.getDateStarted().getTime()));
      ps.setString(8, data.getRework());
      ps.setString(9, data.getUserBo());
      ps.setString(10, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int updateInWorkQty(BigDecimal qty, String sfcStep) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_INWORKQTY)) {
      ps.setBigDecimal(1, qty);
      ps.setString(2, sfcStep);
      return ps.executeUpdate();
    }
  }

  public int update(List<SfcInWork> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SfcInWork data : dataList) {
        ps.setString(1, data.getSfcStepBo());
        ps.setString(2, data.getOwnerGbo());
        ps.setString(3, data.getPaused());
        ps.setString(4, data.getResourceBo());
        ps.setString(5, data.getWorkCenterBo());
        ps.setBigDecimal(6, data.getQtyInWork());
        ps.setTimestamp(7, new Timestamp(data.getDateStarted().getTime()));
        ps.setString(8, data.getRework());
        ps.setString(9, data.getUserBo());
        ps.setString(10, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM sfc_in_work WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<SfcInWork> selectAll() throws SQLException {
    ArrayList<SfcInWork> result = new ArrayList<SfcInWork>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SfcInWork selectByPK(String handle) throws SQLException {
    SfcInWork result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SfcInWork selectByStep(String handle) throws SQLException {
    SfcInWork result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE SFC_STEP_BO=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SfcInWork convert(ResultSet rs) throws SQLException {
    SfcInWork data = new SfcInWork();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSfcStepBo(rs.getString(index++));
    data.setOwnerGbo(rs.getString(index++));
    data.setPaused(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setWorkCenterBo(rs.getString(index++));
    data.setQtyInWork(rs.getBigDecimal(index++));
    data.setDateStarted(rs.getTimestamp(index++));
    data.setRework(rs.getString(index++));
    data.setUserBo(rs.getString(index++));

    return data;
  }
}
