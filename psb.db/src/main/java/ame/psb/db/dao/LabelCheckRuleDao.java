package ame.psb.db.dao;

import ame.psb.db.LabelCheckRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelCheckRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_label_check_rule(device,rcodesplit,rbseq,iseq,cseq,rbcheck,ichecka,icheckb,ccheck,rcontain,bcontain,icontain,ccontain,rbqty,iqty,cqty,rbseqnum,iseqnum,cseqnum,rbseqnumno,iseqnumno,cseqnumno,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_check_rule SET rcodesplit=?,rbseq=?,iseq=?,cseq=?,rbcheck=?,ichecka=?,icheckb=?,ccheck=?,rcontain=?,bcontain=?,icontain=?,ccontain=?,rbqty=?,iqty=?,cqty=?,rbseqnum=?,iseqnum=?,cseqnum=?,rbseqnumno=?,iseqnumno=?,cseqnumno=?,update_user=?,update_time=? WHERE device=?";

  private static final String SQL_SEL = "SELECT device,rcodesplit,rbseq,iseq,cseq,rbcheck,ichecka,icheckb,ccheck,rcontain,bcontain,icontain,ccontain,rbqty,iqty,cqty,rbseqnum,iseqnum,cseqnum,rbseqnumno,iseqnumno,cseqnumno,update_user,update_time FROM zd_label_check_rule ";

  private final Connection conn;

  public LabelCheckRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelCheckRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getDevice());
      ps.setString(2, data.getRcodesplit());
      ps.setString(3, data.getRbseq());
      ps.setString(4, data.getIseq());
      ps.setString(5, data.getCseq());
      ps.setString(6, data.getRbcheck());
      ps.setString(7, data.getIchecka());
      ps.setString(8, data.getIcheckb());
      ps.setString(9, data.getCcheck());
      ps.setString(10, data.getRcontain());
      ps.setString(11, data.getBcontain());
      ps.setString(12, data.getIcontain());
      ps.setString(13, data.getCcontain());
      ps.setString(14, data.getRbqty());
      ps.setString(15, data.getIqty());
      ps.setString(16, data.getCqty());
      ps.setString(17, data.getRbseqnum());
      ps.setString(18, data.getIseqnum());
      ps.setString(19, data.getCseqnum());
      ps.setString(20, data.getRbseqnumno());
      ps.setString(21, data.getIseqnumno());
      ps.setString(22, data.getCseqnumno());
      ps.setString(23, data.getUpdateUser());
      DateUtils.setDateTz(ps, 24, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelCheckRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelCheckRule data : dataList) {
        ps.setString(1, data.getDevice());
        ps.setString(2, data.getRcodesplit());
        ps.setString(3, data.getRbseq());
        ps.setString(4, data.getIseq());
        ps.setString(5, data.getCseq());
        ps.setString(6, data.getRbcheck());
        ps.setString(7, data.getIchecka());
        ps.setString(8, data.getIcheckb());
        ps.setString(9, data.getCcheck());
        ps.setString(10, data.getRcontain());
        ps.setString(11, data.getBcontain());
        ps.setString(12, data.getIcontain());
        ps.setString(13, data.getCcontain());
        ps.setString(14, data.getRbqty());
        ps.setString(15, data.getIqty());
        ps.setString(16, data.getCqty());
        ps.setString(17, data.getRbseqnum());
        ps.setString(18, data.getIseqnum());
        ps.setString(19, data.getCseqnum());
        ps.setString(20, data.getRbseqnumno());
        ps.setString(21, data.getIseqnumno());
        ps.setString(22, data.getCseqnumno());
        ps.setString(23, data.getUpdateUser());
        DateUtils.setDateTz(ps, 24, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelCheckRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRcodesplit());
      ps.setString(2, data.getRbseq());
      ps.setString(3, data.getIseq());
      ps.setString(4, data.getCseq());
      ps.setString(5, data.getRbcheck());
      ps.setString(6, data.getIchecka());
      ps.setString(7, data.getIcheckb());
      ps.setString(8, data.getCcheck());
      ps.setString(9, data.getRcontain());
      ps.setString(10, data.getBcontain());
      ps.setString(11, data.getIcontain());
      ps.setString(12, data.getCcontain());
      ps.setString(13, data.getRbqty());
      ps.setString(14, data.getIqty());
      ps.setString(15, data.getCqty());
      ps.setString(16, data.getRbseqnum());
      ps.setString(17, data.getIseqnum());
      ps.setString(18, data.getCseqnum());
      ps.setString(19, data.getRbseqnumno());
      ps.setString(20, data.getIseqnumno());
      ps.setString(21, data.getCseqnumno());
      ps.setString(22, data.getUpdateUser());
      DateUtils.setDateTz(ps, 23, data.getUpdateTime());
      ps.setString(24, data.getDevice());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelCheckRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelCheckRule data : dataList) {
        ps.setString(1, data.getRcodesplit());
        ps.setString(2, data.getRbseq());
        ps.setString(3, data.getIseq());
        ps.setString(4, data.getCseq());
        ps.setString(5, data.getRbcheck());
        ps.setString(6, data.getIchecka());
        ps.setString(7, data.getIcheckb());
        ps.setString(8, data.getCcheck());
        ps.setString(9, data.getRcontain());
        ps.setString(10, data.getBcontain());
        ps.setString(11, data.getIcontain());
        ps.setString(12, data.getCcontain());
        ps.setString(13, data.getRbqty());
        ps.setString(14, data.getIqty());
        ps.setString(15, data.getCqty());
        ps.setString(16, data.getRbseqnum());
        ps.setString(17, data.getIseqnum());
        ps.setString(18, data.getCseqnum());
        ps.setString(19, data.getRbseqnumno());
        ps.setString(20, data.getIseqnumno());
        ps.setString(21, data.getCseqnumno());
        ps.setString(22, data.getUpdateUser());
        DateUtils.setDateTz(ps, 23, data.getUpdateTime());
        ps.setString(24, data.getDevice());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String device) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_check_rule WHERE device=?")) {
      ps.setString(1, device);

      return ps.executeUpdate();
    }
  }

  public List<LabelCheckRule> selectAll() throws SQLException {
    ArrayList<LabelCheckRule> result = new ArrayList<LabelCheckRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelCheckRule selectByPK(String device) throws SQLException {
    LabelCheckRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device=?")) {
      ps.setString(1, device);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private LabelCheckRule convert(ResultSet rs) throws SQLException {
    LabelCheckRule data = new LabelCheckRule();

    int index = 1;
    data.setDevice(rs.getString(index++));
    data.setRcodesplit(rs.getString(index++));
    data.setRbseq(rs.getString(index++));
    data.setIseq(rs.getString(index++));
    data.setCseq(rs.getString(index++));
    data.setRbcheck(rs.getString(index++));
    data.setIchecka(rs.getString(index++));
    data.setIcheckb(rs.getString(index++));
    data.setCcheck(rs.getString(index++));
    data.setRcontain(rs.getString(index++));
    data.setBcontain(rs.getString(index++));
    data.setIcontain(rs.getString(index++));
    data.setCcontain(rs.getString(index++));
    data.setRbqty(rs.getString(index++));
    data.setIqty(rs.getString(index++));
    data.setCqty(rs.getString(index++));
    data.setRbseqnum(rs.getString(index++));
    data.setIseqnum(rs.getString(index++));
    data.setCseqnum(rs.getString(index++));
    data.setRbseqnumno(rs.getString(index++));
    data.setIseqnumno(rs.getString(index++));
    data.setCseqnumno(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
