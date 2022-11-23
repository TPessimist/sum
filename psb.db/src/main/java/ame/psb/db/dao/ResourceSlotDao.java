package ame.psb.db.dao;

import ame.psb.db.ResourceSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ResourceSlotDao {

  private static final String SQL_INS = "INSERT INTO zd_resource_slot(id,resource_bo,slot_no,slot_type,content,capacity,root_resource,updated_user,updated_time,ref,state_name,reserve_for) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_resource_slot SET resource_bo=?,slot_no=?,slot_type=?,content=?,capacity=?,root_resource=?,updated_user=?,updated_time=?,ref=?,state_name=?,reserve_for=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,slot_no,slot_type,content,capacity,root_resource,updated_user,updated_time,ref,state_name,reserve_for FROM zd_resource_slot ";

  private final Connection conn;

  public ResourceSlotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ResourceSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setInt(3, data.getSlotNo());
      ps.setString(4, data.getSlotType());
      ps.setString(5, data.getContent());
      ps.setBigDecimal(6, data.getCapacity());
      ps.setString(7, data.getRootResource());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getRef());
      ps.setString(11, data.getStateName());
      ps.setString(12, data.getReserveFor());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ResourceSlot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ResourceSlot data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setInt(3, data.getSlotNo());
        ps.setString(4, data.getSlotType());
        ps.setString(5, data.getContent());
        ps.setBigDecimal(6, data.getCapacity());
        ps.setString(7, data.getRootResource());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getRef());
        ps.setString(11, data.getStateName());
        ps.setString(12, data.getReserveFor());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ResourceSlot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setInt(2, data.getSlotNo());
      ps.setString(3, data.getSlotType());
      ps.setString(4, data.getContent());
      ps.setBigDecimal(5, data.getCapacity());
      ps.setString(6, data.getRootResource());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getRef());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getReserveFor());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(ResourceSlot data, Date lastUpdatedTime) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD + " and updated_time=?")) {
      ps.setString(1, data.getResourceBo());
      ps.setInt(2, data.getSlotNo());
      ps.setString(3, data.getSlotType());
      ps.setString(4, data.getContent());
      ps.setBigDecimal(5, data.getCapacity());
      ps.setString(6, data.getRootResource());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getRef());
      ps.setString(10, data.getStateName());
      ps.setString(11, data.getReserveFor());
      ps.setString(12, data.getId());
      DateUtils.setDateTz(ps, 13, lastUpdatedTime);

      return ps.executeUpdate();
    }
  }

  public int update(List<ResourceSlot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ResourceSlot data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setInt(2, data.getSlotNo());
        ps.setString(3, data.getSlotType());
        ps.setString(4, data.getContent());
        ps.setBigDecimal(5, data.getCapacity());
        ps.setString(6, data.getRootResource());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getRef());
        ps.setString(10, data.getStateName());
        ps.setString(11, data.getReserveFor());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_resource_slot WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int updateById(String id, String ref) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("update  zd_resource_slot SET ref=? WHERE id=?")) {
      ps.setString(1, ref);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public List<ResourceSlot> selectAll() throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<ResourceSlot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceSlot> selectByResource(String resourceBo) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<ResourceSlot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? order by slot_no")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<ResourceSlot> selectByReservedFor(String resourceName) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE reserve_for=? order by slot_no")) {
      ps.setString(1, resourceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceSlot> selectByRootResource(String rootResource) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE root_resource=? order by slot_no")) {
      ps.setString(1, rootResource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public ResourceSlot selectByPK(String id) throws SQLException {
    ResourceSlot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }


  public ResourceSlot selectByResourceSlot(String resoureBo, int slotNo) throws SQLException {
    ResourceSlot result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? and slot_no=?")) {
      ps.setString(1, resoureBo);
      ps.setInt(2, slotNo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public ResourceSlot selectByContent(String content) throws SQLException { //通过工具查询所属的设备
    ResourceSlot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE content=? ")) {
      ps.setString(1, content);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<ResourceSlot> selectByResource1(String resourceBo) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<ResourceSlot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE resource_bo like ? and content is not null ")) {
      ps.setString(1, "%" + resourceBo + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ResourceSlot> selectByTypeAndValue(String type, String value) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<ResourceSlot>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "zrs inner join CUSTOM_FIELDS cf ON zrs.RESOURCE_BO =cf.HANDLE  "
            + "WHERE cf.\"ATTRIBUTE\" = ? "
            + "AND cf.VALUE =? "
            + "AND zrs.CONTENT is not NULL "
            + "ORDER BY zrs.UPDATED_TIME DESC ")) {
      ps.setString(1, type);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ResourceSlot> selectByResourceInSKB(String resourceBo) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<ResourceSlot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE resource_bo=? and content is not null ORDER BY UPDATED_TIME DESC ")) {
      ps.setString(1, resourceBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ResourceSlot> selectByResource2(String resourceBo) throws SQLException {
    ArrayList<ResourceSlot> result = new ArrayList<ResourceSlot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo like ? and content is null")) {
      ps.setString(1, "%" + resourceBo + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ResourceSlot convert(ResultSet rs) throws SQLException {
    ResourceSlot data = new ResourceSlot();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotNo(rs.getInt(index++));
    data.setSlotType(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setCapacity(rs.getBigDecimal(index++));
    data.setRootResource(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setRef(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setReserveFor(rs.getString(index++));

    return data;
  }
}
