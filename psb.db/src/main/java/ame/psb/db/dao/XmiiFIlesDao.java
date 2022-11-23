package ame.psb.db.dao;

import ame.psb.db.XmiiFiles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class XmiiFIlesDao {

  private static final String SQL_INS = "INSERT INTO XMII_FILES (id, name, description, pathid, modified, modifiedby, created, createdby, text, remotepath, checkedoutby, version, status, resourceid, filesize) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT id, name, description, pathId, modified, modifiedBy, created, createdBy, text, remotePath, checkedOutBy, version, status, resourceId, fileSize from XMII_FILES";

  private final Connection conn;

  public XmiiFIlesDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(List<XmiiFiles> dataList) throws SQLException {
    long maxId = getMaxId() + 1;
    int index = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (XmiiFiles data : dataList) {
        ps.setLong(1, maxId + index);
        ps.setString(2, data.getName());
        ps.setString(3, data.getDescription());
        ps.setLong(4, data.getPathId());
        DateUtils.setDateTz(ps, 5, data.getModified());
        ps.setString(6, data.getModifiedBy());
//                DateUtils.setDateTz(ps, 7, data.getCreated());
        DateUtils.setDate(ps, 7, new Date());
        ps.setString(8, data.getCreatedBy());
        ps.setBytes(9, data.getText());
        ps.setString(10, data.getRemotePath());
        ps.setString(11, data.getCheckedOutBy());
        ps.setString(12, data.getVersion());
        ps.setString(13, data.getStatus());
        ps.setString(14, data.getResourceId());
        ps.setLong(15, data.getFileSize());

        ps.addBatch();
        index++;
      }
      return ps.executeBatch().length;
    }
  }

  private XmiiFiles convert(ResultSet rs) throws SQLException {
    XmiiFiles data = new XmiiFiles();

    int index = 1;
    data.setId(rs.getLong(index++));
    data.setName(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setPathId(rs.getLong(index++));
    data.setModified(rs.getTimestamp(index++));
    data.setModifiedBy(rs.getString(index++));
    data.setCreated(rs.getTimestamp(index++));
    data.setCreatedBy(rs.getString(index++));
    data.setText(rs.getBytes(index++));
    data.setRemotePath(rs.getString(index++));
    data.setCheckedOutBy(rs.getString(index++));
    data.setVersion(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setResourceId(rs.getString(index++));
    data.setFileSize(rs.getLong(index++));

    return data;
  }

  public long getMaxId() throws SQLException {
    String sql = "select max(id) from XMII_FILES";
    long maxId = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        maxId = rs.getLong(1);
      }
    }
    return maxId;
  }

  public List<XmiiFiles> selectByItemGroupBo(String itemGroupFrom) throws SQLException {
    String sql = SQL_SEL
        + " where name in (select chart_query_seq from zd_spc_contents where item_group_bo = ?) and pathid = 109";
    ArrayList<XmiiFiles> result = new ArrayList<XmiiFiles>();
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, itemGroupFrom);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
    }
    return result;
  }

  public int selectCountByItemGroup(String itemGroupTo) throws SQLException {
    String selSql = "select count(1) from XMII_FILES where name in (select chart_query_seq from zd_spc_contents where item_group_bo = ?) and pathid = 109";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupTo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }


}
