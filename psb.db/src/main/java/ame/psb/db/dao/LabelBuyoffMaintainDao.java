package ame.psb.db.dao;

import ame.psb.db.LabelBuyoffMaintain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class LabelBuyoffMaintainDao {

  private static final String SQL_INS = "INSERT INTO zd_label_buyoff_maintain(uuid,label_id,subid,code_type,begin_index,end_index,code_value,description,comment,note,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_label_buyoff_maintain SET label_id=?,subid=?,code_type=?,begin_index=?,end_index=?,code_value=?,description=?,comment=?,note=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,label_id,subid,code_type,begin_index,end_index,code_value,description,comment,note,updated_user,updated_time FROM zd_label_buyoff_maintain ";

  private final Connection conn;

  public LabelBuyoffMaintainDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelBuyoffMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getLabelId());
      ps.setString(3, data.getSubid());
      ps.setString(4, data.getCodeType());
      ps.setInt(5, data.getBeginIndex());
      ps.setInt(6, data.getEndIndex());
      ps.setString(7, data.getCodeValue());
      ps.setString(8, data.getDescription());
      ps.setString(9, data.getComment());
      ps.setString(10, data.getNote());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelBuyoffMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelBuyoffMaintain data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getLabelId());
        ps.setString(3, data.getSubid());
        ps.setString(4, data.getCodeType());
        ps.setInt(5, data.getBeginIndex());
        ps.setInt(6, data.getEndIndex());
        ps.setString(7, data.getCodeValue());
        ps.setString(8, data.getDescription());
        ps.setString(9, data.getComment());
        ps.setString(10, data.getNote());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelBuyoffMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLabelId());
      ps.setString(2, data.getSubid());
      ps.setString(3, data.getCodeType());
      ps.setInt(4, data.getBeginIndex());
      ps.setInt(5, data.getEndIndex());
      ps.setString(6, data.getCodeValue());
      ps.setString(7, data.getDescription());
      ps.setString(8, data.getComment());
      ps.setString(9, data.getNote());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelBuyoffMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelBuyoffMaintain data : dataList) {
        ps.setString(1, data.getLabelId());
        ps.setString(2, data.getSubid());
        ps.setString(3, data.getCodeType());
        ps.setInt(4, data.getBeginIndex());
        ps.setInt(5, data.getEndIndex());
        ps.setString(6, data.getCodeValue());
        ps.setString(7, data.getDescription());
        ps.setString(8, data.getComment());
        ps.setString(9, data.getNote());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_label_buyoff_maintain WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<LabelBuyoffMaintain> selectAll() throws SQLException {
    ArrayList<LabelBuyoffMaintain> result = new ArrayList<LabelBuyoffMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelBuyoffMaintain selectByPK(String uuid) throws SQLException {
    LabelBuyoffMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<LabelBuyoffMaintain> selectByLabelId(String labelId) throws SQLException {
    ArrayList<LabelBuyoffMaintain> result = new ArrayList<LabelBuyoffMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE label_id=?")) {
      ps.setString(1, labelId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private LabelBuyoffMaintain convert(ResultSet rs) throws SQLException {
    LabelBuyoffMaintain data = new LabelBuyoffMaintain();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setLabelId(rs.getString(index++));
    data.setSubid(rs.getString(index++));
    data.setCodeType(rs.getString(index++));
    data.setBeginIndex(rs.getInt(index++));
    data.setEndIndex(rs.getInt(index++));
    data.setCodeValue(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setNote(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
