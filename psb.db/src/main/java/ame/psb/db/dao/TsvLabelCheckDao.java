package ame.psb.db.dao;

import ame.psb.db.TsvLabelCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class TsvLabelCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_tsv_label_check(label_out,container_id_out,label_in,container_id_in,check_user,check_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_tsv_label_check SET container_id_out=?,container_id_in=?,check_user=?,check_time=? WHERE label_out=? AND label_in=?";

  private static final String SQL_SEL = "SELECT label_out,container_id_out,label_in,container_id_in,check_user,check_time FROM zr_tsv_label_check ";

  private final Connection conn;

  public TsvLabelCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TsvLabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getLabelOut());
      ps.setString(2, data.getContainerIdOut());
      ps.setString(3, data.getLabelIn());
      ps.setString(4, data.getContainerIdIn());
      ps.setString(5, data.getCheckUser());
      DateUtils.setDateTz(ps, 6, data.getCheckTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TsvLabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TsvLabelCheck data : dataList) {
        ps.setString(1, data.getLabelOut());
        ps.setString(2, data.getContainerIdOut());
        ps.setString(3, data.getLabelIn());
        ps.setString(4, data.getContainerIdIn());
        ps.setString(5, data.getCheckUser());
        DateUtils.setDateTz(ps, 6, data.getCheckTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TsvLabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getContainerIdOut());
      ps.setString(2, data.getContainerIdIn());
      ps.setString(3, data.getCheckUser());
      DateUtils.setDateTz(ps, 4, data.getCheckTime());
      ps.setString(5, data.getLabelOut());
      ps.setString(6, data.getLabelIn());

      return ps.executeUpdate();
    }
  }

  public int update(List<TsvLabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TsvLabelCheck data : dataList) {
        ps.setString(1, data.getContainerIdOut());
        ps.setString(2, data.getContainerIdIn());
        ps.setString(3, data.getCheckUser());
        DateUtils.setDateTz(ps, 4, data.getCheckTime());
        ps.setString(5, data.getLabelOut());
        ps.setString(6, data.getLabelIn());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String labelOut) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_tsv_label_check WHERE label_out=?")) {
      ps.setString(1, labelOut);

      return ps.executeUpdate();
    }
  }

  public List<TsvLabelCheck> selectAll() throws SQLException {
    ArrayList<TsvLabelCheck> result = new ArrayList<TsvLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<TsvLabelCheck> selectByOut(String labelOut) throws SQLException {
    ArrayList<TsvLabelCheck> result = new ArrayList<TsvLabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_out=?")) {
      ps.setString(1, labelOut);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public TsvLabelCheck selectByPK(String labelOut) throws SQLException {
    TsvLabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_out=?")) {
      ps.setString(1, labelOut);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public TsvLabelCheck selectByOutAndIn(String labelOut, String labelIn) throws SQLException {
    TsvLabelCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_out=? AND label_in=?")) {
      ps.setString(1, labelOut);
      ps.setString(2, labelIn);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private TsvLabelCheck convert(ResultSet rs) throws SQLException {
    TsvLabelCheck data = new TsvLabelCheck();

    int index = 1;
    data.setLabelOut(rs.getString(index++));
    data.setContainerIdOut(rs.getString(index++));
    data.setLabelIn(rs.getString(index++));
    data.setContainerIdIn(rs.getString(index++));
    data.setCheckUser(rs.getString(index++));
    data.setCheckTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
