package ame.psb.db.dao;

import ame.psb.db.BumpingLabelCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BumpingLabelCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_bumping_label_check(lot_out,container_name_out,lot_in,container_name_in,container_id_out,container_id_in,check_user,check_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_bumping_label_check SET container_name_out=?,lot_in=?,container_name_in=?,container_id_out=?,lot_out =?,check_user=?,check_time=? WHERE container_id_in=?";

  private static final String SQL_SEL = "SELECT lot_out,container_name_out,lot_in,container_name_in,container_id_out,container_id_in,check_user,check_time FROM zr_bumping_label_check ";

  private final Connection conn;

  public BumpingLabelCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BumpingLabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getLotOut());
      ps.setString(2, data.getContainerNameOut());
      ps.setString(3, data.getLotIn());
      ps.setString(4, data.getContainerNameIn());
      ps.setString(5, data.getContainerIdOut());
      ps.setString(6, data.getContainerIdIn());
      ps.setString(7, data.getCheckUser());
      DateUtils.setDateTz(ps, 8, data.getCheckTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BumpingLabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BumpingLabelCheck data : dataList) {
        ps.setString(1, data.getLotOut());
        ps.setString(2, data.getContainerNameOut());
        ps.setString(3, data.getLotIn());
        ps.setString(4, data.getContainerNameIn());
        ps.setString(5, data.getContainerIdOut());
        ps.setString(6, data.getContainerIdIn());
        ps.setString(7, data.getCheckUser());
        DateUtils.setDateTz(ps, 8, data.getCheckTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BumpingLabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getContainerNameOut());
      ps.setString(2, data.getLotIn());
      ps.setString(3, data.getContainerNameIn());
      ps.setString(4, data.getContainerIdOut());
      ps.setString(5, data.getLotOut());
      ps.setString(6, data.getCheckUser());
      DateUtils.setDateTz(ps, 7, data.getCheckTime());
      ps.setString(8, data.getContainerIdIn());
      return ps.executeUpdate();
    }
  }

  public int update(List<BumpingLabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BumpingLabelCheck data : dataList) {
        ps.setString(1, data.getContainerNameOut());
        ps.setString(2, data.getLotIn());
        ps.setString(3, data.getContainerNameIn());
        ps.setString(4, data.getContainerIdOut());
        ps.setString(5, data.getLotOut());
        ps.setString(6, data.getCheckUser());
        DateUtils.setDateTz(ps, 7, data.getCheckTime());
        ps.setString(8, data.getContainerIdIn());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String lotOut) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_bumping_label_check WHERE lot_out=?")) {
      ps.setString(1, lotOut);

      return ps.executeUpdate();
    }
  }

  public List<BumpingLabelCheck> selectAll() throws SQLException {
    ArrayList<BumpingLabelCheck> result = new ArrayList<BumpingLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BumpingLabelCheck> selectByLot(String lotOut) throws SQLException {
    ArrayList<BumpingLabelCheck> result = new ArrayList<BumpingLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE lot_out=?")) {
      ps.setString(1, lotOut);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BumpingLabelCheck selectByPK(String lotOut) throws SQLException {
    BumpingLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE lot_out=?")) {
      ps.setString(1, lotOut);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public BumpingLabelCheck selectByContainerIdOut(String containerIdOut) throws SQLException {
    BumpingLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_id_out=?")) {
      ps.setString(1, containerIdOut);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public BumpingLabelCheck selectByContainerIdIn(String containerIdIn) throws SQLException {
    BumpingLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_id_in=?")) {
      ps.setString(1, containerIdIn);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BumpingLabelCheck convert(ResultSet rs) throws SQLException {
    BumpingLabelCheck data = new BumpingLabelCheck();

    int index = 1;
    data.setLotOut(rs.getString(index++));
    data.setContainerNameOut(rs.getString(index++));
    data.setLotIn(rs.getString(index++));
    data.setContainerNameIn(rs.getString(index++));
    data.setContainerIdOut(rs.getString(index++));
    data.setContainerIdIn(rs.getString(index++));
    data.setCheckUser(rs.getString(index++));
    data.setCheckTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
