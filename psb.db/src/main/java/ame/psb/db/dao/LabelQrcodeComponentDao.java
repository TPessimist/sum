package ame.psb.db.dao;

import ame.psb.db.LabelQrcodeComponent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelQrcodeComponentDao {

  private static final String SQL_INS = "INSERT INTO zd_label_qrcode_component(id,qrcode,sequence,component_tag,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_qrcode_component SET qrcode=?,sequence=?,component_tag=?,reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,qrcode,sequence,component_tag,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_label_qrcode_component ";

  private final Connection conn;

  public LabelQrcodeComponentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelQrcodeComponent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getQrcode());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getComponentTag());
      ps.setString(5, data.getReserveField1());
      ps.setString(6, data.getReserveField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelQrcodeComponent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelQrcodeComponent data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getQrcode());
        ps.setBigDecimal(3, data.getSequence());
        ps.setString(4, data.getComponentTag());
        ps.setString(5, data.getReserveField1());
        ps.setString(6, data.getReserveField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelQrcodeComponent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getQrcode());
      ps.setBigDecimal(2, data.getSequence());
      ps.setString(3, data.getComponentTag());
      ps.setString(4, data.getReserveField1());
      ps.setString(5, data.getReserveField2());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelQrcodeComponent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelQrcodeComponent data : dataList) {
        ps.setString(1, data.getQrcode());
        ps.setBigDecimal(2, data.getSequence());
        ps.setString(3, data.getComponentTag());
        ps.setString(4, data.getReserveField1());
        ps.setString(5, data.getReserveField2());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_qrcode_component WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByQrcode(String qrcode) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_qrcode_component WHERE qrcode=?")) {
      ps.setString(1, qrcode);

      return ps.executeUpdate();
    }
  }

  public List<LabelQrcodeComponent> selectAll() throws SQLException {
    ArrayList<LabelQrcodeComponent> result = new ArrayList<LabelQrcodeComponent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelQrcodeComponent selectByPK(String id) throws SQLException {
    LabelQrcodeComponent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<LabelQrcodeComponent> selectByQrcode(String qrcode) throws SQLException {
    ArrayList<LabelQrcodeComponent> result = new ArrayList<LabelQrcodeComponent>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE qrcode=? ORDER BY SEQUENCE ASC ")) {
      ps.setString(1, qrcode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private LabelQrcodeComponent convert(ResultSet rs) throws SQLException {
    LabelQrcodeComponent data = new LabelQrcodeComponent();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setQrcode(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setComponentTag(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
