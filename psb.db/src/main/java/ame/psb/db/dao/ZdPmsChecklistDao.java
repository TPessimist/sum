package ame.psb.db.dao;

import ame.psb.db.ZdPmsChecklist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdPmsChecklistDao {

  private static final String SQL_INS = "INSERT INTO zd_pms_checklist(checklist,description,remark,check_type,create_user,created_date_time,modify_user,modified_date_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pms_checklist SET description=?,remark=?,check_type=?,create_user=?,created_date_time=?,modify_user=?,modified_date_time=? WHERE checklist=?";

  private static final String SQL_SEL = "SELECT checklist,description,remark,check_type,create_user,created_date_time,modify_user,modified_date_time FROM zd_pms_checklist ";

  private final Connection conn;

  public ZdPmsChecklistDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdPmsChecklist data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getChecklist());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getRemark());
      ps.setString(4, data.getCheckType());
      ps.setString(5, data.getCreateUser());
      DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
      ps.setString(7, data.getModifyUser());
      DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdPmsChecklist> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdPmsChecklist data : dataList) {
        ps.setString(1, data.getChecklist());
        ps.setString(2, data.getDescription());
        ps.setString(3, data.getRemark());
        ps.setString(4, data.getCheckType());
        ps.setString(5, data.getCreateUser());
        DateUtils.setDateTz(ps, 6, data.getCreatedDateTime());
        ps.setString(7, data.getModifyUser());
        DateUtils.setDateTz(ps, 8, data.getModifiedDateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdPmsChecklist data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDescription());
      ps.setString(2, data.getRemark());
      ps.setString(3, data.getCheckType());
      ps.setString(4, data.getCreateUser());
      DateUtils.setDateTz(ps, 5, data.getCreatedDateTime());
      ps.setString(6, data.getModifyUser());
      DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
      ps.setString(8, data.getChecklist());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdPmsChecklist> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdPmsChecklist data : dataList) {
        ps.setString(1, data.getDescription());
        ps.setString(2, data.getRemark());
        ps.setString(3, data.getCheckType());
        ps.setString(4, data.getCreateUser());
        DateUtils.setDateTz(ps, 5, data.getCreatedDateTime());
        ps.setString(6, data.getModifyUser());
        DateUtils.setDateTz(ps, 7, data.getModifiedDateTime());
        ps.setString(8, data.getChecklist());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String checklist) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pms_checklist WHERE checklist=?")) {
      ps.setString(1, checklist);

      return ps.executeUpdate();
    }
  }

  public List<ZdPmsChecklist> selectAll() throws SQLException {
    ArrayList<ZdPmsChecklist> result = new ArrayList<ZdPmsChecklist>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<ZdPmsChecklist> selectLike(String filter) throws SQLException {
    ArrayList<ZdPmsChecklist> result = new ArrayList<ZdPmsChecklist>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " where checklist like '%'||?||'%'")) {
      ps.setString(1, filter);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public ZdPmsChecklist selectByPK(String checklist) throws SQLException {
    ZdPmsChecklist result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE checklist=?")) {
      ps.setString(1, checklist);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  private ZdPmsChecklist convert(ResultSet rs) throws SQLException {
    ZdPmsChecklist data = new ZdPmsChecklist();

    int index = 1;
    data.setChecklist(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setCheckType(rs.getString(index++));
    data.setCreateUser(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifyUser(rs.getString(index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
