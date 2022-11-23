package ame.psb.db.dao;


import ame.psb.db.XmiiFile;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class XmiiFileDao {

  private static final String SQL_INS = "INSERT INTO xmii_files(id,name,description,pathid,modified,modifiedby,created,createdby,text,remotepath,checkedoutby,version,status,resourceid,filesize) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE xmii_files SET name=?,description=?,pathid=?,modified=?,modifiedby=?,created=?,createdby=?,text=?,remotepath=?,checkedoutby=?,version=?,status=?,resourceid=?,filesize=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,name,description,pathid,modified,modifiedby,created,createdby,text,remotepath,checkedoutby,version,status,resourceid,filesize FROM xmii_files ";

  private final Connection conn;

  public XmiiFileDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(XmiiFile data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getName());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getPathid());
      ps.setTimestamp(5, new Timestamp(data.getModified().getTime()));
      ps.setString(6, data.getModifiedby());
      ps.setTimestamp(7, new Timestamp(data.getCreated().getTime()));
      ps.setString(8, data.getCreatedby());
      ps.setString(9, data.getText());
      ps.setString(10, data.getRemotepath());
      ps.setString(11, data.getCheckedoutby());
      ps.setString(12, data.getVersion());
      ps.setString(13, data.getStatus());
      ps.setString(14, data.getResourceid());
      ps.setString(15, data.getFilesize());

      return ps.executeUpdate();
    }
  }

  public int insert(List<XmiiFile> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (XmiiFile data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getName());
        ps.setString(3, data.getDescription());
        ps.setString(4, data.getPathid());
        ps.setTimestamp(5, new Timestamp(data.getModified().getTime()));
        ps.setString(6, data.getModifiedby());
        ps.setTimestamp(7, new Timestamp(data.getCreated().getTime()));
        ps.setString(8, data.getCreatedby());
        // ps.setString(9, data.getText());
        ps.setString(9, data.getText());
        ps.setString(10, data.getRemotepath());
        ps.setString(11, data.getCheckedoutby());
        ps.setString(12, data.getVersion());
        ps.setString(13, data.getStatus());
        ps.setString(14, data.getResourceid());
        ps.setString(15, data.getFilesize());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(XmiiFile data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getName());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getPathid());
      DateUtils.setDateTz(ps, 4, data.getModified());
      // ps.setTimestamp(4, new Timestamp(data.getModified().getTime()));
      ps.setString(5, data.getModifiedby());
      ps.setTimestamp(6, new Timestamp(data.getCreated().getTime()));
      ps.setString(7, data.getCreatedby());
      ps.setString(8, data.getText());
      ps.setString(9, data.getRemotepath());
      ps.setString(10, data.getCheckedoutby());
      ps.setString(11, data.getVersion());
      ps.setString(12, data.getStatus());
      ps.setString(13, data.getResourceid());
      ps.setString(14, data.getFilesize());
      ps.setString(15, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<XmiiFile> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (XmiiFile data : dataList) {
        ps.setString(1, data.getName());
        ps.setString(2, data.getDescription());
        ps.setString(3, data.getPathid());
        DateUtils.setDateTz(ps, 4, data.getModified());
        // ps.setTimestamp(4, new Timestamp(data.getModified().getTime()));
        ps.setString(5, data.getModifiedby());
        ps.setTimestamp(6, new Timestamp(data.getCreated().getTime()));
        ps.setString(7, data.getCreatedby());
        // ps.setString(8, data.getText());
        ps.setString(8, data.getText());
        ps.setString(9, data.getRemotepath());
        ps.setString(10, data.getCheckedoutby());
        ps.setString(11, data.getVersion());
        ps.setString(12, data.getStatus());
        ps.setString(13, data.getResourceid());
        ps.setString(14, data.getFilesize());
        ps.setString(15, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM xmii_files WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<XmiiFile> selectAll() throws SQLException {
    ArrayList<XmiiFile> result = new ArrayList<XmiiFile>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public XmiiFile selectByPK(String id) throws SQLException {
    XmiiFile result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public XmiiFile selectByFileNameAndPath(String fileName, String pathId) throws SQLException {
    XmiiFile result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE name=? and pathid = ?")) {
      ps.setString(1, fileName);
      ps.setString(2, pathId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private XmiiFile convert(ResultSet rs) throws SQLException {
    XmiiFile data = new XmiiFile();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setPathid(rs.getString(index++));
    data.setModified(rs.getTimestamp(index++));
    data.setModifiedby(rs.getString(index++));
    data.setCreated(rs.getTimestamp(index++));
    data.setCreatedby(rs.getString(index++));
    Blob b = rs.getBlob(index++);
    String c = "";
    if (null == b) {
      data.setText(null);
    } else {
      try {
        c = new String(b.getBytes(1, (int) b.length()), "GBK");
        //System.out.println(c);
      } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }//blob 转 String
      data.setText(c);
    }

    data.setRemotepath(rs.getString(index++));
    data.setCheckedoutby(rs.getString(index++));
    data.setVersion(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setResourceid(rs.getString(index++));
    data.setFilesize(rs.getString(index++));

    return data;
  }
}
