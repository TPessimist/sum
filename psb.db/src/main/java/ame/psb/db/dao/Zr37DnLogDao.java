package ame.psb.db.dao;

import ame.psb.db.Zr37DnLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class Zr37DnLogDao {

  private static final String SQL_INS = "INSERT INTO zr_37_dn_log(uuid,dn,container_name,content,value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_37_dn_log SET dn=?,container_name=?,content=?,value=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,dn,container_name,content,value,updated_user,updated_time FROM zr_37_dn_log ";

  private final Connection conn;

  public Zr37DnLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Zr37DnLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getDn());
      ps.setString(3, data.getContainerName());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getValue());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Zr37DnLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Zr37DnLog data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getDn());
        ps.setString(3, data.getContainerName());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getValue());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Zr37DnLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDn());
      ps.setString(2, data.getContainerName());
      ps.setString(3, data.getContent());
      ps.setString(4, data.getValue());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<Zr37DnLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Zr37DnLog data : dataList) {
        ps.setString(1, data.getDn());
        ps.setString(2, data.getContainerName());
        ps.setString(3, data.getContent());
        ps.setString(4, data.getValue());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_37_dn_log WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<Zr37DnLog> selectAll() throws SQLException {
    ArrayList<Zr37DnLog> result = new ArrayList<Zr37DnLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Zr37DnLog selectByPK(String uuid) throws SQLException {
    Zr37DnLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<Zr37DnLog> selectByDn(String dn) throws SQLException {
    ArrayList<Zr37DnLog> result = new ArrayList<Zr37DnLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE dn=? order by updated_time desc")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private Zr37DnLog convert(ResultSet rs) throws SQLException {
    Zr37DnLog data = new Zr37DnLog();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setDn(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
