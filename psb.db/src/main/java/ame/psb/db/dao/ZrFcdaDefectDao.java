package ame.psb.db.dao;

import ame.psb.db.ZrFcdaDefect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZrFcdaDefectDao {

  private static final String SQL_INS = "INSERT INTO zr_fcda_defect(sfc,wafer_id,missing_die,up_look,frame_deformation,other,remarks,update_user,update_time,content1,content2,content3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_fcda_defect SET sfc=?,missing_die=?,up_look=?,frame_deformation=?,other=?,remarks=?,update_user=?,update_time=?,content1=?,content2=?,content3=? WHERE wafer_id=?";

  private static final String SQL_SEL = "SELECT sfc,wafer_id,missing_die,up_look,frame_deformation,other,remarks,update_user,update_time,content1,content2,content3 FROM zr_fcda_defect ";

  private final Connection conn;

  public ZrFcdaDefectDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrFcdaDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getWaferId());
      ps.setInt(3, data.getMissingDie());
      ps.setInt(4, data.getUpLook());
      ps.setInt(5, data.getFrameDeformation());
      ps.setInt(6, data.getOther());
      ps.setString(7, data.getRemarks());
      ps.setString(8, data.getUpdateUser());
      DateUtils.setDateTz(ps, 9, data.getUpdateTime());
      ps.setString(10, data.getContent1());
      ps.setString(11, data.getContent2());
      ps.setString(12, data.getContent3());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrFcdaDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrFcdaDefect data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getWaferId());
        ps.setInt(3, data.getMissingDie());
        ps.setInt(4, data.getUpLook());
        ps.setInt(5, data.getFrameDeformation());
        ps.setInt(6, data.getOther());
        ps.setString(7, data.getRemarks());
        ps.setString(8, data.getUpdateUser());
        DateUtils.setDateTz(ps, 9, data.getUpdateTime());
        ps.setString(10, data.getContent1());
        ps.setString(11, data.getContent2());
        ps.setString(12, data.getContent3());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrFcdaDefect data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setInt(2, data.getMissingDie());
      ps.setInt(3, data.getUpLook());
      ps.setInt(4, data.getFrameDeformation());
      ps.setInt(5, data.getOther());
      ps.setString(6, data.getRemarks());
      ps.setString(7, data.getUpdateUser());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getContent1());
      ps.setString(10, data.getContent2());
      ps.setString(11, data.getContent3());
      ps.setString(12, data.getWaferId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrFcdaDefect> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrFcdaDefect data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setInt(2, data.getMissingDie());
        ps.setInt(3, data.getUpLook());
        ps.setInt(4, data.getFrameDeformation());
        ps.setInt(5, data.getOther());
        ps.setString(6, data.getRemarks());
        ps.setString(7, data.getUpdateUser());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getContent1());
        ps.setString(10, data.getContent2());
        ps.setString(11, data.getContent3());
        ps.setString(12, data.getWaferId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String waferId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_fcda_defect WHERE wafer_id=?")) {
      ps.setString(1, waferId);

      return ps.executeUpdate();
    }
  }

  public List<ZrFcdaDefect> selectAll() throws SQLException {
    ArrayList<ZrFcdaDefect> result = new ArrayList<ZrFcdaDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrFcdaDefect selectByPK(String waferId) throws SQLException {
    ZrFcdaDefect result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE wafer_id=?")) {
      ps.setString(1, waferId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZrFcdaDefect> selectBySfc(String sfc) throws SQLException {
    ArrayList<ZrFcdaDefect> result = new ArrayList<ZrFcdaDefect>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc=?")) {
      ps.setString(1, sfc);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZrFcdaDefect convert(ResultSet rs) throws SQLException {
    ZrFcdaDefect data = new ZrFcdaDefect();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setMissingDie(rs.getInt(index++));
    data.setUpLook(rs.getInt(index++));
    data.setFrameDeformation(rs.getInt(index++));
    data.setOther(rs.getInt(index++));
    data.setRemarks(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setContent1(rs.getString(index++));
    data.setContent2(rs.getString(index++));
    data.setContent3(rs.getString(index++));

    return data;
  }
}
