package ame.psb.db.dao;

import ame.psb.db.PkgWarmupPrintLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgWarmupPrintLabelDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_warmup_print_label(id,start_time,end_time,cutoff_time,partno_seq,content,print_time,value1,value2) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_warmup_print_label SET start_time=?,end_time=?,cutoff_time=?,partno_seq=?,content=?,print_time=?,value1=?,value2=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,start_time,end_time,cutoff_time,partno_seq,content,print_time,value1,value2 FROM zr_pkg_warmup_print_label ";

  private final Connection conn;

  public PkgWarmupPrintLabelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgWarmupPrintLabel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      DateUtils.setDateTz(ps, 2, data.getStartTime());
      DateUtils.setDateTz(ps, 3, data.getEndTime());
      DateUtils.setDateTz(ps, 4, data.getCutoffTime());
      ps.setString(5, data.getPartnoSeq());
      ps.setString(6, data.getContent());
      DateUtils.setDateTz(ps, 7, data.getPrintTime());
      ps.setString(8, data.getValue1());
      ps.setString(9, data.getValue2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgWarmupPrintLabel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgWarmupPrintLabel data : dataList) {
        ps.setString(1, data.getId());
        DateUtils.setDateTz(ps, 2, data.getStartTime());
        DateUtils.setDateTz(ps, 3, data.getEndTime());
        DateUtils.setDateTz(ps, 4, data.getCutoffTime());
        ps.setString(5, data.getPartnoSeq());
        ps.setString(6, data.getContent());
        DateUtils.setDateTz(ps, 7, data.getPrintTime());
        ps.setString(8, data.getValue1());
        ps.setString(9, data.getValue2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgWarmupPrintLabel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      DateUtils.setDateTz(ps, 1, data.getStartTime());
      DateUtils.setDateTz(ps, 2, data.getEndTime());
      DateUtils.setDateTz(ps, 3, data.getCutoffTime());
      ps.setString(4, data.getPartnoSeq());
      ps.setString(5, data.getContent());
      DateUtils.setDateTz(ps, 6, data.getPrintTime());
      ps.setString(7, data.getValue1());
      ps.setString(8, data.getValue2());
      ps.setString(9, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgWarmupPrintLabel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgWarmupPrintLabel data : dataList) {
        DateUtils.setDateTz(ps, 1, data.getStartTime());
        DateUtils.setDateTz(ps, 2, data.getEndTime());
        DateUtils.setDateTz(ps, 3, data.getCutoffTime());
        ps.setString(4, data.getPartnoSeq());
        ps.setString(5, data.getContent());
        DateUtils.setDateTz(ps, 6, data.getPrintTime());
        ps.setString(7, data.getValue1());
        ps.setString(8, data.getValue2());
        ps.setString(9, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_warmup_print_label WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PkgWarmupPrintLabel> selectAll() throws SQLException {
    ArrayList<PkgWarmupPrintLabel> result = new ArrayList<PkgWarmupPrintLabel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgWarmupPrintLabel selectByPK(String id) throws SQLException {
    PkgWarmupPrintLabel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgWarmupPrintLabel selectByInventoryId(String inventoryId) throws SQLException {
    PkgWarmupPrintLabel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE partno_seq=?")) {
      ps.setString(1, inventoryId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgWarmupPrintLabel convert(ResultSet rs) throws SQLException {
    PkgWarmupPrintLabel data = new PkgWarmupPrintLabel();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStartTime(DateUtils.getDate(rs, index++));
    data.setEndTime(DateUtils.getDate(rs, index++));
    data.setCutoffTime(DateUtils.getDate(rs, index++));
    data.setPartnoSeq(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setPrintTime(DateUtils.getDate(rs, index++));
    data.setValue1(rs.getString(index++));
    data.setValue2(rs.getString(index++));

    return data;
  }
}
