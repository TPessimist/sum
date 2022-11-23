package ame.psb.db.dao;

import ame.psb.db.ZdResourceSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdResourceSlotDao {

  private final static String SQL_SEL = "SELECT ID, RESOURCE_BO, SLOT_NO, SLOT_TYPE, CONTENT, CAPACITY, ROOT_RESOURCE, UPDATED_USER, UPDATED_TIME, \"REF\", RESERVE_FOR, STATE_NAME FROM ZD_RESOURCE_SLOT ";

  private Connection conn;

  public ZdResourceSlotDao(Connection conn) {
    this.conn = conn;
  }

  public List<ZdResourceSlot> getResourceLotList() throws SQLException {

    ArrayList<ZdResourceSlot> result = new ArrayList<ZdResourceSlot>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE RESERVE_FOR IS NOT NULL AND RESERVE_FOR <> ''")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }

  }


  public List<ZdResourceSlot> getResourceLotById(String id) throws SQLException {

    ArrayList<ZdResourceSlot> result = new ArrayList<>();

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ID LIKE ?")) {
      ps.setString(1, "%" + id + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }

  }

  private ZdResourceSlot convert(ResultSet rs) throws SQLException {
    ZdResourceSlot data = new ZdResourceSlot();
    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setSlotType(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setCapacity(rs.getString(index++));
    data.setRootResource(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setRef(rs.getString(index++));
    data.setReserveFor(rs.getString(index++));
    data.setStateName(rs.getString(index++));

    return data;
  }


}
