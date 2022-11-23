package ame.psb.db.dao;

import ame.psb.db.RunFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class RunFileDao {

  private static final String SQL_INS = "INSERT INTO zr_file(id,file_name,binary,comments,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_file SET file_name=?,binary=?,comments=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,file_name,binary,comments,updated_user,updated_time FROM zr_file ";

  private final Connection conn;

  public RunFileDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(RunFile data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getFileName());
      ps.setBytes(3, data.getCompressedBinary());
      ps.setString(4, data.getComments());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<RunFile> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (RunFile data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getFileName());
        ps.setBytes(3, data.getCompressedBinary());
        ps.setString(4, data.getComments());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(RunFile data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFileName());
      ps.setBytes(2, data.getCompressedBinary());
      ps.setString(3, data.getComments());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<RunFile> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (RunFile data : dataList) {
        ps.setString(1, data.getFileName());
        ps.setBytes(2, data.getCompressedBinary());
        ps.setString(3, data.getComments());
        ps.setString(4, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
        ps.setString(6, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zr_file WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }


  public RunFile selectByPK(String id) throws SQLException {
    RunFile result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public RunFile selectByFileName(String fileName) throws SQLException { //按照文件名查map
    RunFile result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE file_name=? ORDER BY updated_time DESC")) {
      ps.setString(1, fileName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;

    }
  }

  public RunFile selectByUserAndComments(String user, String comments)
      throws SQLException { //按照文件名查map
    RunFile result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE updated_user like ? AND comments=? ORDER BY updated_time DESC")) {
      ps.setString(1, user + "%");
      ps.setString(2, comments);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;

    }
  }

  public List<RunFile> selectByComments(String comments) throws SQLException { //按照文件名查map
    List<RunFile> result = new ArrayList<RunFile>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE comments=?")) {
      ps.setString(1, comments);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;

    }
  }

  private RunFile convert(ResultSet rs) throws SQLException {
    RunFile data = new RunFile();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setFileName(rs.getString(index++));
    data.setBinaryAndDecompress(rs.getBytes(index++));
    data.setComments(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDate(rs, index++));

    return data;
  }
}
