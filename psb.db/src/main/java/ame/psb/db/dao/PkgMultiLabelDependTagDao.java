package ame.psb.db.dao;

import ame.psb.db.PkgMultiLabelDependTag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgMultiLabelDependTagDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_multilabel_depend_tag(label_bo,tag_bo,reserve_field1,reserve_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_multilabel_depend_tag SET reserve_field1=?,reserve_field2=?,updated_user=?,updated_time=? WHERE label_bo=? AND tag_bo=?";

  private static final String SQL_SEL = "SELECT label_bo,tag_bo,reserve_field1,reserve_field2,updated_user,updated_time FROM zd_pkg_multilabel_depend_tag ";

  private final Connection conn;

  public PkgMultiLabelDependTagDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgMultiLabelDependTag data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getLabelBo());
      ps.setString(2, data.getTagBo());
      ps.setString(3, data.getReserveField1());
      ps.setString(4, data.getReserveField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgMultiLabelDependTag> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgMultiLabelDependTag data : dataList) {
        ps.setString(1, data.getLabelBo());
        ps.setString(2, data.getTagBo());
        ps.setString(3, data.getReserveField1());
        ps.setString(4, data.getReserveField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgMultiLabelDependTag data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getReserveField1());
      ps.setString(2, data.getReserveField2());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getLabelBo());
      ps.setString(6, data.getTagBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgMultiLabelDependTag> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgMultiLabelDependTag data : dataList) {
        ps.setString(1, data.getReserveField1());
        ps.setString(2, data.getReserveField2());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getLabelBo());
        ps.setString(6, data.getTagBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String labelBo, String tagBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pkg_multilabel_depend_tag WHERE label_bo=? AND tag_bo=?")) {
      ps.setString(1, labelBo);
      ps.setString(2, tagBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgMultiLabelDependTag> selectAll() throws SQLException {
    ArrayList<PkgMultiLabelDependTag> result = new ArrayList<PkgMultiLabelDependTag>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgMultiLabelDependTag> selectByLabelBo(String labelBo) throws SQLException {
    ArrayList<PkgMultiLabelDependTag> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where LABEL_BO = ? ")) {
      ps.setString(1, labelBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgMultiLabelDependTag selectByPK(String labelBo, String tagBo) throws SQLException {
    PkgMultiLabelDependTag result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE label_bo=? AND tag_bo=?")) {
      ps.setString(1, labelBo);
      ps.setString(2, tagBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgMultiLabelDependTag convert(ResultSet rs) throws SQLException {
    PkgMultiLabelDependTag data = new PkgMultiLabelDependTag();

    int index = 1;
    data.setLabelBo(rs.getString(index++));
    data.setTagBo(rs.getString(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
