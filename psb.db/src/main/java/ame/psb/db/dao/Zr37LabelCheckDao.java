package ame.psb.db.dao;

import ame.psb.db.Zr37LabelCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Zr37LabelCheckDao {

  private static final String SQL_INS = "INSERT INTO zr_37_label_check(reel_id,reel_pkg_id,reel_seq,dn,dz,job_id,out_container,out_pkg_id,out_value,out_terminal_value,out_seq,in_pkg_id,in_value,in_terminal_value,in_seq,reel_value,reel_terminal_value,kid,print_user,print_time,check_user,check_time,check_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_37_label_check SET reel_pkg_id=?,reel_seq=?,dn=?,dz=?,job_id=?,out_container=?,out_pkg_id=?,out_value=?,out_terminal_value=?,out_seq=?,in_pkg_id=?,in_value=?,in_terminal_value=?,in_seq=?,reel_value=?,reel_terminal_value=?,kid=?,print_user=?,print_time=?,check_user=?,check_time=?,check_flag=? WHERE reel_id=?";

  private static final String SQL_SEL = "SELECT reel_id,reel_pkg_id,reel_seq,dn,dz,job_id,out_container,out_pkg_id,out_value,out_terminal_value,out_seq,in_pkg_id,in_value,in_terminal_value,in_seq,reel_value,reel_terminal_value,kid,print_user,print_time,check_user,check_time,check_flag FROM zr_37_label_check ";

  private final Connection conn;

  public Zr37LabelCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Zr37LabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getReelId());
      ps.setString(2, data.getReelPkgId());
      ps.setString(3, data.getReelSeq());
      ps.setString(4, data.getDn());
      ps.setString(5, data.getDz());
      ps.setString(6, data.getJobId());
      ps.setString(7, data.getOutContainer());
      ps.setString(8, data.getOutPkgId());
      ps.setString(9, data.getOutValue());
      ps.setString(10, data.getOutTerminalValue());
      ps.setString(11, data.getOutSeq());
      ps.setString(12, data.getInPkgId());
      ps.setString(13, data.getInValue());
      ps.setString(14, data.getInTerminalValue());
      ps.setString(15, data.getInSeq());
      ps.setString(16, data.getReelValue());
      ps.setString(17, data.getReelTerminalValue());
      ps.setString(18, data.getKid());
      ps.setString(19, data.getPrintUser());
      DateUtils.setDateTz(ps, 20, data.getPrintTime());
      ps.setString(21, data.getCheckUser());
      DateUtils.setDateTz(ps, 22, data.getCheckTime());
      ps.setString(23, data.getCheckFlag());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Zr37LabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Zr37LabelCheck data : dataList) {
        ps.setString(1, data.getReelId());
        ps.setString(2, data.getReelPkgId());
        ps.setString(3, data.getReelSeq());
        ps.setString(4, data.getDn());
        ps.setString(5, data.getDz());
        ps.setString(6, data.getJobId());
        ps.setString(7, data.getOutContainer());
        ps.setString(8, data.getOutPkgId());
        ps.setString(9, data.getOutValue());
        ps.setString(10, data.getOutTerminalValue());
        ps.setString(11, data.getOutSeq());
        ps.setString(12, data.getInPkgId());
        ps.setString(13, data.getInValue());
        ps.setString(14, data.getInTerminalValue());
        ps.setString(15, data.getInSeq());
        ps.setString(16, data.getReelValue());
        ps.setString(17, data.getReelTerminalValue());
        ps.setString(18, data.getKid());
        ps.setString(19, data.getPrintUser());
        DateUtils.setDateTz(ps, 20, data.getPrintTime());
        ps.setString(21, data.getCheckUser());
        DateUtils.setDateTz(ps, 22, data.getCheckTime());
        ps.setString(23, data.getCheckFlag());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Zr37LabelCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReelPkgId());
      ps.setString(2, data.getReelSeq());
      ps.setString(3, data.getDn());
      ps.setString(4, data.getDz());
      ps.setString(5, data.getJobId());
      ps.setString(6, data.getOutContainer());
      ps.setString(7, data.getOutPkgId());
      ps.setString(8, data.getOutValue());
      ps.setString(9, data.getOutTerminalValue());
      ps.setString(10, data.getOutSeq());
      ps.setString(11, data.getInPkgId());
      ps.setString(12, data.getInValue());
      ps.setString(13, data.getInTerminalValue());
      ps.setString(14, data.getInSeq());
      ps.setString(15, data.getReelValue());
      ps.setString(16, data.getReelTerminalValue());
      ps.setString(17, data.getKid());
      ps.setString(18, data.getPrintUser());
      DateUtils.setDateTz(ps, 19, data.getPrintTime());
      ps.setString(20, data.getCheckUser());
      DateUtils.setDateTz(ps, 21, data.getCheckTime());
      ps.setString(22, data.getCheckFlag());
      ps.setString(23, data.getReelId());

      return ps.executeUpdate();
    }
  }

  public int update(List<Zr37LabelCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Zr37LabelCheck data : dataList) {
        ps.setString(1, data.getReelPkgId());
        ps.setString(2, data.getReelSeq());
        ps.setString(3, data.getDn());
        ps.setString(4, data.getDz());
        ps.setString(5, data.getJobId());
        ps.setString(6, data.getOutContainer());
        ps.setString(7, data.getOutPkgId());
        ps.setString(8, data.getOutValue());
        ps.setString(9, data.getOutTerminalValue());
        ps.setString(10, data.getOutSeq());
        ps.setString(11, data.getInPkgId());
        ps.setString(12, data.getInValue());
        ps.setString(13, data.getInTerminalValue());
        ps.setString(14, data.getInSeq());
        ps.setString(15, data.getReelValue());
        ps.setString(16, data.getReelTerminalValue());
        ps.setString(17, data.getKid());
        ps.setString(18, data.getPrintUser());
        DateUtils.setDateTz(ps, 19, data.getPrintTime());
        ps.setString(20, data.getCheckUser());
        DateUtils.setDateTz(ps, 21, data.getCheckTime());
        ps.setString(22, data.getCheckFlag());
        ps.setString(23, data.getReelId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String reelId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_37_label_check WHERE reel_id=?")) {
      ps.setString(1, reelId);

      return ps.executeUpdate();
    }
  }

  public int deleteByDn(String dn) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_37_label_check WHERE dn=?")) {
      ps.setString(1, dn);

      return ps.executeUpdate();
    }
  }

  public int updateByDn(String dn) throws SQLException { //按照DN号把表快速更新下
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_37_label_check SET reel_value=reel_id WHERE dn=?")) {
      ps.setString(1, dn);

      return ps.executeUpdate();
    }
  }

  public List<Zr37LabelCheck> selectAll() throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Zr37LabelCheck selectByPK(String reelId) throws SQLException {
    Zr37LabelCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE reel_id=?")) {
      ps.setString(1, reelId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<Zr37LabelCheck> selectByContainerName(String outContainer) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE out_container=?")) {
      ps.setString(1, outContainer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByDnAndContainerName(String dn, String outContainer)
      throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dn= ? and out_container=?")) {
      ps.setString(1, dn);
      ps.setString(2, outContainer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByDn(String dn) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dn=? and check_flag ='N' order by reel_seq ")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByInstockDn(String dn) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE dn=? ")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByDnAndOutSeqFlag(String dn, String outSeq)
      throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE dn=? and out_seq=?  and check_flag ='N' order by reel_seq ")) {
      ps.setString(1, dn);
      ps.setString(2, outSeq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByDnAndOutSeq(String dn, String outSeq) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dn=? and out_seq=?   order by reel_seq ")) {
      ps.setString(1, dn);
      ps.setString(2, outSeq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<Zr37LabelCheck> selectByDnAndOutSeqAndInSeq(String dn, String outSeq, String inSeq)
      throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE dn=? and out_seq=? and in_seq=? and check_flag ='N' order by reel_seq ")) {
      ps.setString(1, dn);
      ps.setString(2, outSeq);
      ps.setString(3, inSeq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<Zr37LabelCheck> selectByContainerNameFlag(String outContainer) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE out_container=? and check_flag ='N'  order by reel_seq ")) {
      ps.setString(1, outContainer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByInValue(String inValue) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE in_value=? and check_flag ='Y'  order by reel_seq ")) {
      ps.setString(1, inValue);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByOutContainer(String outContainer) throws SQLException {
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE out_container=? and check_flag ='Y'  order by reel_seq ")) {
      ps.setString(1, outContainer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<Zr37LabelCheck> selectByReelPkgId(String reelPkgId)
      throws SQLException { //通过卷盘容器编号查记录
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE REEL_PKG_ID=?")) {
      ps.setString(1, reelPkgId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByInPkgId(String inPkgId) throws SQLException { //通过内箱容器编号查记录
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE IN_PKG_ID=? order by REEL_PKG_ID ASC ")) {
      ps.setString(1, inPkgId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByOutPkgId(String outPkgId) throws SQLException { //通过外箱容器编号查记录
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE OUT_PKG_ID=? order by IN_PKG_ID ASC ")) {
      ps.setString(1, outPkgId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Zr37LabelCheck> selectByOutPkgIdFlag(String outPkgId)
      throws SQLException { //通过外箱容器编号查记录
    ArrayList<Zr37LabelCheck> result = new ArrayList<Zr37LabelCheck>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE OUT_PKG_ID=? and check_flag ='N' ")) {
      ps.setString(1, outPkgId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private Zr37LabelCheck convert(ResultSet rs) throws SQLException {
    Zr37LabelCheck data = new Zr37LabelCheck();

    int index = 1;
    data.setReelId(rs.getString(index++));
    data.setReelPkgId(rs.getString(index++));
    data.setReelSeq(rs.getString(index++));
    data.setDn(rs.getString(index++));
    data.setDz(rs.getString(index++));
    data.setJobId(rs.getString(index++));
    data.setOutContainer(rs.getString(index++));
    data.setOutPkgId(rs.getString(index++));
    data.setOutValue(rs.getString(index++));
    data.setOutTerminalValue(rs.getString(index++));
    data.setOutSeq(rs.getString(index++));
    data.setInPkgId(rs.getString(index++));
    data.setInValue(rs.getString(index++));
    data.setInTerminalValue(rs.getString(index++));
    data.setInSeq(rs.getString(index++));
    data.setReelValue(rs.getString(index++));
    data.setReelTerminalValue(rs.getString(index++));
    data.setKid(rs.getString(index++));
    data.setPrintUser(rs.getString(index++));
    data.setPrintTime(DateUtils.getDateTz(rs, index++));
    data.setCheckUser(rs.getString(index++));
    data.setCheckTime(DateUtils.getDateTz(rs, index++));
    data.setCheckFlag(rs.getString(index++));

    return data;
  }
}
