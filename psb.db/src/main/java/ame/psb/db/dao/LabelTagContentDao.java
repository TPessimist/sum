package ame.psb.db.dao;

import ame.psb.db.LabelTagContent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelTagContentDao {

  private static final String SQL_INS = "INSERT INTO zd_label_tag_content(uuid,container_bo,label_bo,tag_bo,tag_value,tag_type,print_qty,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_tag_content SET container_bo=?,label_bo=?,tag_bo=?,tag_value=?,tag_type=?,print_qty=?,reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,container_bo,label_bo,tag_bo,tag_value,tag_type,print_qty,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_label_tag_content ";

  private final Connection conn;

  public LabelTagContentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelTagContent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getLabelBo());
      ps.setString(4, data.getTagBo());
      ps.setString(5, data.getTagValue());
      ps.setString(6, data.getTagType());
      ps.setBigDecimal(7, data.getPrintQty());
      ps.setString(8, data.getReserveField1());
      ps.setString(9, data.getReserveField2());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelTagContent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelTagContent data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getLabelBo());
        ps.setString(4, data.getTagBo());
        ps.setString(5, data.getTagValue());
        ps.setString(6, data.getTagType());
        ps.setBigDecimal(7, data.getPrintQty());
        ps.setString(8, data.getReserveField1());
        ps.setString(9, data.getReserveField2());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelTagContent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getLabelBo());
      ps.setString(3, data.getTagBo());
      ps.setString(4, data.getTagValue());
      ps.setString(5, data.getTagType());
      ps.setBigDecimal(6, data.getPrintQty());
      ps.setString(7, data.getReserveField1());
      ps.setString(8, data.getReserveField2());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
      ps.setString(11, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelTagContent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelTagContent data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getLabelBo());
        ps.setString(3, data.getTagBo());
        ps.setString(4, data.getTagValue());
        ps.setString(5, data.getTagType());
        ps.setBigDecimal(6, data.getPrintQty());
        ps.setString(7, data.getReserveField1());
        ps.setString(8, data.getReserveField2());
        ps.setString(9, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 10, data.getUpdatedTime());
        ps.setString(11, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_tag_content WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public int deleteByContainer(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_tag_content WHERE container_bo=? ")) {
      ps.setString(1, containerBo);

      return ps.executeUpdate();
    }
  }

  public int deleteByContainerAndLabel(String containerBo, String labelBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "DELETE FROM zd_label_tag_content WHERE container_bo=? AND label_bo=? ")) {
      ps.setString(1, containerBo);
      ps.setString(2, labelBo);

      return ps.executeUpdate();
    }
  }

  public List<LabelTagContent> selectAll() throws SQLException {
    ArrayList<LabelTagContent> result = new ArrayList<LabelTagContent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelTagContent selectByPK(String uuid) throws SQLException {
    LabelTagContent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<LabelTagContent> selectByContainer(String containerBo) throws SQLException {
    ArrayList<LabelTagContent> result = new ArrayList<LabelTagContent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<LabelTagContent> selectByContainerAndLabelAndTag(String containerBo, String labelBo,
      String tagBo) throws SQLException {
    ArrayList<LabelTagContent> result = new ArrayList<LabelTagContent>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND label_bo=? AND tag_bo=? ")) {
      ps.setString(1, containerBo);
      ps.setString(2, labelBo);
      ps.setString(3, tagBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private LabelTagContent convert(ResultSet rs) throws SQLException {
    LabelTagContent data = new LabelTagContent();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setLabelBo(rs.getString(index++));
    data.setTagBo(rs.getString(index++));
    data.setTagValue(rs.getString(index++));
    data.setTagType(rs.getString(index++));
    data.setPrintQty(rs.getBigDecimal(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
