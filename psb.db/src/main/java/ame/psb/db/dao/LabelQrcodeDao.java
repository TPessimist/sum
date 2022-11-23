package ame.psb.db.dao;

import ame.psb.db.LabelQrcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelQrcodeDao {

  private static final String SQL_INS = "INSERT INTO zd_label_qrcode(label_bo,qrcode,interval_char,start_char,end_char,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_qrcode SET interval_char=?,start_char=?,end_char=?,reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE label_bo=? AND qrcode=?";

  private static final String SQL_SEL = "SELECT label_bo,qrcode,interval_char,start_char,end_char,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_label_qrcode ";

  private final Connection conn;

  public LabelQrcodeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelQrcode data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getLabelBo());
      ps.setString(2, data.getQrcode());
      ps.setString(3, data.getIntervalChar());
      ps.setString(4, data.getStartChar());
      ps.setString(5, data.getEndChar());
      ps.setString(6, data.getReserveField1());
      ps.setString(7, data.getReserveField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelQrcode> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelQrcode data : dataList) {
        ps.setString(1, data.getLabelBo());
        ps.setString(2, data.getQrcode());
        ps.setString(3, data.getIntervalChar());
        ps.setString(4, data.getStartChar());
        ps.setString(5, data.getEndChar());
        ps.setString(6, data.getReserveField1());
        ps.setString(7, data.getReserveField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelQrcode data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getIntervalChar());
      ps.setString(2, data.getStartChar());
      ps.setString(3, data.getEndChar());
      ps.setString(4, data.getReserveField1());
      ps.setString(5, data.getReserveField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getLabelBo());
      ps.setString(9, data.getQrcode());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelQrcode> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelQrcode data : dataList) {
        ps.setString(1, data.getIntervalChar());
        ps.setString(2, data.getStartChar());
        ps.setString(3, data.getEndChar());
        ps.setString(4, data.getReserveField1());
        ps.setString(5, data.getReserveField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getLabelBo());
        ps.setString(9, data.getQrcode());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String labelBo, String qrcode) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_qrcode WHERE label_bo=? AND qrcode=?")) {
      ps.setString(1, labelBo);
      ps.setString(2, qrcode);

      return ps.executeUpdate();
    }
  }

  public List<LabelQrcode> selectAll() throws SQLException {
    ArrayList<LabelQrcode> result = new ArrayList<LabelQrcode>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public LabelQrcode selectByPK(String labelBo, String qrcode) throws SQLException {
    LabelQrcode result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_bo=? AND qrcode=?")) {
      ps.setString(1, labelBo);
      ps.setString(2, qrcode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public LabelQrcode selectByLabelBo(String labelBo) throws SQLException {
    LabelQrcode result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_bo=? ")) {
      ps.setString(1, labelBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private LabelQrcode convert(ResultSet rs) throws SQLException {
    LabelQrcode data = new LabelQrcode();

    int index = 1;
    data.setLabelBo(rs.getString(index++));
    data.setQrcode(rs.getString(index++));
    data.setIntervalChar(rs.getString(index++));
    data.setStartChar(rs.getString(index++));
    data.setEndChar(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
