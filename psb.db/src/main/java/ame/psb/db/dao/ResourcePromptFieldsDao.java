package ame.psb.db.dao;

import ame.psb.db.ResourcePromptFields;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourcePromptFieldsDao {

  private static final String SQL_INS = "INSERT INTO zr_resource_prompt_fields(id,subid,group_id,value,group_name,prompt_user,prompt_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_resource_prompt_fields SET value=?,group_name=?,prompt_user=?,prompt_time=? WHERE id=? AND subid=? AND group_id=?";

  private static final String SQL_SEL = "SELECT id,subid,group_id,value,group_name,prompt_user,prompt_time FROM zr_resource_prompt_fields ";

  private final Connection conn;

  public ResourcePromptFieldsDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourcePromptFields data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSubid());
      ps.setString(3, data.getGroupId());
      ps.setString(4, data.getValue());
      ps.setString(5, data.getGroupName());
      ps.setString(6, data.getPromptUser());
      ps.setTimestamp(7, new Timestamp(data.getPromptTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourcePromptFields> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourcePromptFields data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSubid());
        ps.setString(3, data.getGroupId());
        ps.setString(4, data.getValue());
        ps.setString(5, data.getGroupName());
        ps.setString(6, data.getPromptUser());
        ps.setTimestamp(7, new Timestamp(data.getPromptTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourcePromptFields data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getValue());
      ps.setString(2, data.getGroupName());
      ps.setString(3, data.getPromptUser());
      ps.setTimestamp(4, new Timestamp(data.getPromptTime().getTime()));
      ps.setString(5, data.getId());
      ps.setString(6, data.getSubid());
      ps.setString(7, data.getGroupId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourcePromptFields> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourcePromptFields data : dataList) {
        ps.setString(1, data.getValue());
        ps.setString(2, data.getGroupName());
        ps.setString(3, data.getPromptUser());
        ps.setTimestamp(4, new Timestamp(data.getPromptTime().getTime()));
        ps.setString(5, data.getId());
        ps.setString(6, data.getSubid());
        ps.setString(7, data.getGroupId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id, String subid, String groupId) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_resource_prompt_fields WHERE id=? AND subid=? AND group_id=?")) {
      ps.setString(1, id);
      ps.setString(2, subid);
      ps.setString(3, groupId);

      return ps.executeUpdate();
    }
  }

  public List<ResourcePromptFields> selectAll() throws SQLException {
    ArrayList<ResourcePromptFields> result = new ArrayList<ResourcePromptFields>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ResourcePromptFields selectByPK(String id, String subid, String groupId)
      throws SQLException {
    ResourcePromptFields result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND subid=? AND group_id=?")) {
      ps.setString(1, id);
      ps.setString(2, subid);
      ps.setString(3, groupId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public ResourcePromptFields selectPreDevice(String groupName) throws SQLException {
    ResourcePromptFields result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE GROUP_NAME=? AND SUBID = ? ORDER BY PROMPT_TIME DESC LIMIT 1 ")) {
      ps.setString(1, groupName);
      ps.setString(2, "DEVICE");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ResourcePromptFields> selectByResource(String groupName, Date begin, Date end)
      throws SQLException {
    ArrayList<ResourcePromptFields> result = new ArrayList<ResourcePromptFields>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE group_name =? AND prompt_time BETWEEN ? AND ? ")) {
      ps.setString(1, groupName);
      DateUtils.setDateTz(ps, 2, begin);
      DateUtils.setDateTz(ps, 3, end);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private ResourcePromptFields convert(ResultSet rs) throws SQLException {
    ResourcePromptFields data = new ResourcePromptFields();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSubid(rs.getString(index++));
    data.setGroupId(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setGroupName(rs.getString(index++));
    data.setPromptUser(rs.getString(index++));
    data.setPromptTime(rs.getTimestamp(index++));

    return data;
  }
}
