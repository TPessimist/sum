package ame.psb.db.dao;

import ame.psb.db.FrameSpecSetting;
import ame.psb.db.ViewFrameSpecSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class FrameSpecSettingDao {

  private static final String SQL_INS = "INSERT INTO zd_frame_spec_setting(id,item_bo,item,item_revision,quantity,frame_model,frame_spec,compensation_value,create_user,create_time,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_frame_spec_setting SET item_bo=?,item=?,item_revision=?,quantity=?,frame_model=?,frame_spec=?,compensation_value=?,create_user=?,create_time=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_bo,item,item_revision,quantity,frame_model,frame_spec,compensation_value,create_user,create_time,updated_user,updated_time FROM zd_frame_spec_setting ";

  private static final String SQL_SEL_VIEW = "SELECT fss.id,fss.item_bo,fss.item,fss.item_revision,fss.quantity,fss.frame_model,fss.frame_spec,fss.compensation_value,fss.create_user,fss.create_time,fss.updated_user,fss.updated_time,i.description as item_description FROM zd_frame_spec_setting fss inner join item i on i.handle = fss.item_bo ";

  private final Connection conn;

  public FrameSpecSettingDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FrameSpecSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemBo());
      ps.setString(3, data.getItem());
      ps.setString(4, data.getItemRevision());
      ps.setString(5, data.getQuantity());
      ps.setString(6, data.getFrameModel());
      ps.setString(7, data.getFrameSpec());
      ps.setString(8, data.getCompensationValue());
      ps.setString(9, data.getCreateUser());
      DateUtils.setDateTz(ps, 10, data.getCreateTime());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FrameSpecSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FrameSpecSetting data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getItemBo());
        ps.setString(3, data.getItem());
        ps.setString(4, data.getItemRevision());
        ps.setString(5, data.getQuantity());
        ps.setString(6, data.getFrameModel());
        ps.setString(7, data.getFrameSpec());
        ps.setString(8, data.getCompensationValue());
        ps.setString(9, data.getCreateUser());
        DateUtils.setDateTz(ps, 10, data.getCreateTime());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FrameSpecSetting data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemBo());
      ps.setString(2, data.getItem());
      ps.setString(3, data.getItemRevision());
      ps.setString(4, data.getQuantity());
      ps.setString(5, data.getFrameModel());
      ps.setString(6, data.getFrameSpec());
      ps.setString(7, data.getCompensationValue());
      ps.setString(8, data.getCreateUser());
      DateUtils.setDateTz(ps, 9, data.getCreateTime());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FrameSpecSetting> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FrameSpecSetting data : dataList) {
        ps.setString(1, data.getItemBo());
        ps.setString(2, data.getItem());
        ps.setString(3, data.getItemRevision());
        ps.setString(4, data.getQuantity());
        ps.setString(5, data.getFrameModel());
        ps.setString(6, data.getFrameSpec());
        ps.setString(7, data.getCompensationValue());
        ps.setString(8, data.getCreateUser());
        DateUtils.setDateTz(ps, 9, data.getCreateTime());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_frame_spec_setting WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<FrameSpecSetting> selectAll() throws SQLException {
    ArrayList<FrameSpecSetting> result = new ArrayList<FrameSpecSetting>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FrameSpecSetting selectByPK(String id) throws SQLException {
    FrameSpecSetting result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<FrameSpecSetting> select(Where where) throws SQLException {
    ArrayList<FrameSpecSetting> result = new ArrayList<FrameSpecSetting>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public List<ViewFrameSpecSetting> selectByItemLike(String itemName) throws SQLException {
    List<ViewFrameSpecSetting> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VIEW + "WHERE fss.item like ?")) {
      ps.setString(1, "%" + itemName + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convertView(rs));
      }
      return result;
    }
  }

  private FrameSpecSetting convert(ResultSet rs) throws SQLException {
    FrameSpecSetting data = new FrameSpecSetting();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setItemRevision(rs.getString(index++));
    data.setQuantity(rs.getString(index++));
    data.setFrameModel(rs.getString(index++));
    data.setFrameSpec(rs.getString(index++));
    data.setCompensationValue(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private ViewFrameSpecSetting convertView(ResultSet rs) throws SQLException {
    ViewFrameSpecSetting data = new ViewFrameSpecSetting();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setItemRevision(rs.getString(index++));
    data.setQuantity(rs.getString(index++));
    data.setFrameModel(rs.getString(index++));
    data.setFrameSpec(rs.getString(index++));
    data.setCompensationValue(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setItemDescription(rs.getString(index++));

    return data;
  }
}
