package ame.psb.db.dao;

import ame.psb.db.Attached;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachedDao {

  private static final String SQL_INS = "INSERT INTO attached(handle,attachment_bo,attachment_set,key_id,attachment_type,attached_to_gbo,count_total,item,operation) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE attached SET attachment_bo=?,attachment_set=?,key_id=?,attachment_type=?,attached_to_gbo=?,count_total=?,item=?,operation=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,attachment_bo,attachment_set,key_id,attachment_type,attached_to_gbo,count_total,item,operation FROM attached ";

  private final Connection conn;

  public AttachedDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Attached data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getAttachmentBo());
      ps.setBigDecimal(3, data.getAttachmentSet());
      ps.setBigDecimal(4, data.getKeyId());
      ps.setString(5, data.getAttachmentType());
      ps.setString(6, data.getAttachedToGbo());
      ps.setBigDecimal(7, data.getCountTotal());
      ps.setString(8, data.getItem());
      ps.setString(9, data.getOperation());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Attached> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Attached data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getAttachmentBo());
        ps.setBigDecimal(3, data.getAttachmentSet());
        ps.setBigDecimal(4, data.getKeyId());
        ps.setString(5, data.getAttachmentType());
        ps.setString(6, data.getAttachedToGbo());
        ps.setBigDecimal(7, data.getCountTotal());
        ps.setString(8, data.getItem());
        ps.setString(9, data.getOperation());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(Attached data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getAttachmentBo());
      ps.setBigDecimal(2, data.getAttachmentSet());
      ps.setBigDecimal(3, data.getKeyId());
      ps.setString(4, data.getAttachmentType());
      ps.setString(5, data.getAttachedToGbo());
      ps.setBigDecimal(6, data.getCountTotal());
      ps.setString(7, data.getItem());
      ps.setString(8, data.getOperation());
      ps.setString(9, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<Attached> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Attached data : dataList) {
        ps.setString(1, data.getAttachmentBo());
        ps.setBigDecimal(2, data.getAttachmentSet());
        ps.setBigDecimal(3, data.getKeyId());
        ps.setString(4, data.getAttachmentType());
        ps.setString(5, data.getAttachedToGbo());
        ps.setBigDecimal(6, data.getCountTotal());
        ps.setString(7, data.getItem());
        ps.setString(8, data.getOperation());
        ps.setString(9, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM attached WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }
    public List<Attached> selectAllByOperationItemAll(String operation,String item) throws SQLException {
        ArrayList<Attached> result = new ArrayList<Attached>();
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where operation = ? and item = ?and key_id = '1' and ATTACHMENT_TYPE = 'T'")) {
            ps.setString(1, operation);
            ps.setString(2, item);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(convert(rs));
            }
            return result;
        }
    }


  public List<Attached> selectAll() throws SQLException {
    ArrayList<Attached> result = new ArrayList<Attached>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Attached> selectAllByOperationItem(String operation, String item)
      throws SQLException {
    ArrayList<Attached> result = new ArrayList<Attached>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where operation = ? and item = ? and ATTACHMENT_TYPE = 'T'")) {
      ps.setString(1, operation);
      ps.setString(2, item);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Attached> selectAllByAttachmentBo(String attachmentBo) throws SQLException {
    ArrayList<Attached> result = new ArrayList<Attached>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where attachment_bo = ?  ")) {
      ps.setString(1, attachmentBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Attached selectByPK(String handle) throws SQLException {
    Attached result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Attached convert(ResultSet rs) throws SQLException {
    Attached data = new Attached();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setAttachmentBo(rs.getString(index++));
    data.setAttachmentSet(rs.getBigDecimal(index++));
    data.setKeyId(rs.getBigDecimal(index++));
    data.setAttachmentType(rs.getString(index++));
    data.setAttachedToGbo(rs.getString(index++));
    data.setCountTotal(rs.getBigDecimal(index++));
    data.setItem(rs.getString(index++));
    data.setOperation(rs.getString(index++));

    return data;
  }
}
